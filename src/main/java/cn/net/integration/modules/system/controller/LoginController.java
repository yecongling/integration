package cn.net.integration.modules.system.controller;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.system.entity.SysLoginModel;
import cn.net.integration.modules.system.service.ISysLoginService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SysLoginController
 * @Description 系统登录controller
 * @Author ycl
 * @Date 2022/10/28 10:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys")
@Tag(name = "登录控制器", description = "登录模块使用")
public class LoginController {

    private ISysLoginService ISysLoginService;

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
    @Operation(summary = "登录方法", description = "登录方法")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SaResult login(@RequestBody SysLoginModel loginModel, HttpServletRequest request) throws Exception {
        Result<JSONObject> result = ISysLoginService.login(loginModel, request);
        if (result.isSuccess()) {
            SaLoginModel model = new SaLoginModel();
            model.setIsLastingCookie(false);
            model.setTimeout(300L);
            model.setIsWriteHeader(true);
            // 会话登录
            StpUtil.login(loginModel.getUsername());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
        return SaResult.error(result.getMessage());
    }

    /**
     * 退出登录
     *
     * @param userId 用户ID
     * @return 返回退出登录结果
     */
    @Operation(summary = "退出登录")
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public SaResult logout(@RequestParam String userId) {
        StpUtil.logout(userId);
        return SaResult.ok();
    }

}
