package cn.net.system.controller;

import cn.net.base.core.domain.Response;
import cn.net.system.bean.SysUser;
import cn.net.system.service.ILoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录入口
 */
@RestController
@RequestMapping("/system")
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
    @PostMapping("/login")
    public Response<SysUser> login(@RequestBody @Valid SysUser user, BindingResult errors) {
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
}
