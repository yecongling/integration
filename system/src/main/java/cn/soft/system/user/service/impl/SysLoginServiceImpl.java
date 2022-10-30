package cn.soft.system.user.service.impl;

import cn.soft.system.user.entity.SysLoginModel;
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
        if (username == null) {
            throw new RuntimeException("用户名不存在");
        }
        return null;
    }
}
