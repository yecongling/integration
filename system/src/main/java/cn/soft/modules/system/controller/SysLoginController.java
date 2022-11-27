package cn.soft.modules.system.controller;

import cn.soft.modules.system.entity.SysLoginModel;
import cn.soft.modules.system.service.SysLoginService;
import com.alibaba.fastjson.JSONObject;
import cn.soft.common.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysLoginController
 * @Description 系统登录controller
 * @Author ycl
 * @Date 2022/10/28 10:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController {

    private SysLoginService sysLoginService;

    @Autowired
    public void setSysLoginService(SysLoginService sysLoginService) {
        this.sysLoginService = sysLoginService;
    }

    /**
     * 系统登录接口
     *
     * @param loginModel 登录对象
     * @return 返回登录结果
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<JSONObject> login(@RequestBody SysLoginModel loginModel) throws Exception{
        return sysLoginService.login(loginModel);
    }

}
