package cn.net.system.controller;

import cn.net.base.core.Response;
import cn.net.system.bean.SysUser;
import cn.net.system.service.ILoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 登录入口
 */
@RestController
@RequestMapping("/system")
@Tag(name = "登录控制器", description = "登录模块使用")
public class LoginController {

    private final ILoginService loginService;

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 系统登录接口
     *
     * @param user   登录的用户信息
     * @param errors Validation的校验错误存放对象
     * @return 返回登录结果
     */
    @Operation(summary = "登录方法", description = "登录方法")
    @PostMapping("/login")
    public Response<SysUser> login(@RequestBody @Valid SysUser user, BindingResult errors) throws Exception {
        Response<SysUser> response = new Response<>();
        // 如果校验有误，返回登录失败以及错误信息
        if (errors.hasErrors()) {
            response.setCode(500);
            response.setMsg(errors.getAllErrors().get(0).getDefaultMessage());
            return response;
        }
        // 调用登录服务
        response = loginService.login(user);
        return response;
    }

    /**
     * 退出登录
     *
     * @param userId 用户ID
     * @return 返回退出登录结果
     */
    @Operation(summary = "退出登录")
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Response<Object> logout(@RequestParam String userId) throws Exception {
        return loginService.logout(userId);
    }
}
