package cn.soft.system.user.service.impl;

import cn.soft.common.util.PasswordUtil;
import cn.soft.system.user.entity.SysLoginModel;
import cn.soft.system.user.entity.SysUser;
import cn.soft.system.user.mapper.SysLoginMapper;
import cn.soft.system.user.service.SysLoginService;
import com.alibaba.fastjson.JSONObject;
import cn.soft.common.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    /**
     * 登录逻辑
     *
     * @param loginModel 登录对象
     * @return 登录结果
     */
    @Override
    public Result<JSONObject> login(SysLoginModel loginModel) {
        Result<JSONObject> result = new Result<>();
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
        return null;
    }

    /**
     * 校验用户是否有效
     *
     * @param sysUser 用户信息
     * @return 校验结果
     */
    @Override
    public Result<JSONObject> checkUserIsEffective(SysUser sysUser) {
        return null;
    }
}
