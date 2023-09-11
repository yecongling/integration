package cn.net.integration.modules.system.controller;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.system.entity.SysLoginModel;
import cn.net.integration.modules.system.service.ISysLoginService;
import com.alibaba.fastjson.JSONObject;
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

    private cn.net.integration.modules.system.service.ISysLoginService ISysLoginService;

    @Autowired
    public void setSysLoginService(ISysLoginService ISysLoginService) {
        this.ISysLoginService = ISysLoginService;
    }

    /**
     * 系统登录接口
     *
     * @param loginModel 登录对象
     * @return 返回登录结果
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<JSONObject> login(@RequestBody SysLoginModel loginModel) throws Exception{
        return ISysLoginService.login(loginModel);
    }

}
