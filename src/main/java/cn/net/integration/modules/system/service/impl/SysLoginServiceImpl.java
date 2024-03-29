package cn.net.integration.modules.system.service.impl;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.core.common.spring.event.Publisher;
import cn.net.integration.core.common.system.vo.LoginUser;
import cn.net.integration.core.common.util.PasswordUtil;
import cn.net.integration.modules.system.entity.SysLoginModel;
import cn.net.integration.modules.system.entity.SysUser;
import cn.net.integration.modules.system.mapper.SysLoginMapper;
import cn.net.integration.modules.system.service.ISysLoginService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @ClassName SysLoginServiceImpl
 * @Description 系统登录相关业务操作
 * @Author ycl
 * @Date 2022/10/28 11:01
 * @Version 1.0
 */
@Service
public class SysLoginServiceImpl extends ServiceImpl<SysLoginMapper, SysUser> implements ISysLoginService {

    private SysLoginMapper sysLoginMapper;
    private Publisher publisher;

    @Autowired
    public void setSysLoginMapper(SysLoginMapper sysLoginMapper) {
        this.sysLoginMapper = sysLoginMapper;
    }

    @Autowired
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    /**
     * 登录逻辑
     *
     * @param loginModel 登录对象
     * @return 登录结果
     */
    @Override
    public Response<JSONObject> login(SysLoginModel loginModel, HttpServletRequest request) throws Exception {
        Response<JSONObject> response;
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        SysUser sysUser = sysLoginMapper.getSysUserByUsername(username);
        // 校验用户信息
        response = this.checkUserIsEffective(sysUser);
        if (!response.isSuccess()) {
            return response;
        }
        // 校验用户名密码是否正确
        String encrypt = PasswordUtil.encrypt(username, password, sysUser.getSalt());
        String sysPassword = sysUser.getPassword();
        if (!sysPassword.equals(encrypt)) {
            response.error500("用户名或密码错误");
            return response;
        }
        // 用户登录信息
        loadUserInfo(sysUser, response);
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser, loginUser);
        // 异步发送消息（用于记录操作员的登录信息）
        publisher.sendMsg(username, request);
        return response;
    }

    /**
     * 校验用户是否有效
     *
     * @param sysUser 用户信息
     * @return 校验结果
     */
    @Override
    public Response<JSONObject> checkUserIsEffective(SysUser sysUser) {
        if (sysUser == null) {
            return Response.error("账号不存在!");
        }
        return new Response<>();
    }

    /**
     * 加载用户信息
     *
     * @param sysUser 用户
     * @param response  返回结果
     */
    private void loadUserInfo(SysUser sysUser, Response<JSONObject> response) {
        JSONObject obj = new JSONObject(new LinkedHashMap<>());
        obj.put("userInfo", sysUser);
        obj.put("token", sysUser.getId());
        obj.put("status", "ok");
        response.setResult(obj);
        response.setMessage("登录成功");
    }
}
