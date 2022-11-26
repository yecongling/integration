package cn.soft.modules.system.service.impl;

import cn.soft.common.constant.CommonConstant;
import cn.soft.common.system.vo.LoginUser;
import cn.soft.common.util.PasswordUtil;
import cn.soft.modules.base.service.BaseCommonService;
import cn.soft.modules.system.entity.SysLoginModel;
import cn.soft.modules.system.entity.SysUser;
import cn.soft.modules.system.mapper.SysLoginMapper;
import cn.soft.modules.system.service.SysLoginService;
import com.alibaba.fastjson.JSONObject;
import cn.soft.common.api.vo.Result;
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
public class SysLoginServiceImpl implements SysLoginService {

    private SysLoginMapper sysLoginMapper;

    @Autowired
    public void setSysLoginMapper(SysLoginMapper sysLoginMapper) {
        this.sysLoginMapper = sysLoginMapper;
    }

    private BaseCommonService baseCommonService;

    @Autowired
    public void setBaseCommonService(BaseCommonService baseCommonService) {
        this.baseCommonService = baseCommonService;
    }

    /**
     * 登录逻辑
     *
     * @param loginModel 登录对象
     * @return 登录结果
     */
    @Override
    public Result<JSONObject> login(SysLoginModel loginModel) throws Exception{
        Result<JSONObject> result;
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        SysUser sysUser = sysLoginMapper.getSysUserByUsername(username);
        // 校验用户信息
        result = this.checkUserIsEffective(sysUser);
        if (!result.isSuccess()) {
            return result;
        }
        // 校验用户名密码是否正确
        String encrypt = PasswordUtil.encrypt(username, password, sysUser.getSalt());
        String sysPassword = sysUser.getPassword();
        if (!sysPassword.equals(encrypt)) {
            result.error500("用户名或密码错误");
            return result;
        }
        // 用户登录信息
        loadUserInfo(sysUser, result);
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser, loginUser);
        baseCommonService.addLog("用户名: " + username + ",登录成功！", CommonConstant.LOG_TYPE_1, null, loginUser);
        return result;
    }

    /**
     * 校验用户是否有效
     *
     * @param sysUser 用户信息
     * @return 校验结果
     */
    @Override
    public Result<JSONObject> checkUserIsEffective(SysUser sysUser) {
        return new Result<>();
    }

    /**
     * 加载用户信息
     *
     * @param sysUser 用户
     * @param result  返回结果
     */
    private void loadUserInfo(SysUser sysUser, Result<JSONObject> result) {
        JSONObject obj = new JSONObject(new LinkedHashMap<>());
        obj.put("userInfo", sysUser);
        obj.put("token", sysUser.getId());
        result.setResult(obj);
        result.success("登录成功");
    }
}
