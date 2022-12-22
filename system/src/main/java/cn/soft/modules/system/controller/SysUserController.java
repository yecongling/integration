package cn.soft.modules.system.controller;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.system.entity.SysUser;
import cn.soft.modules.system.service.ISysUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SysUserController
 * @Description 用户相关controller  如注册、用户管理等
 * @Author ycl
 * @Date 2022/11/4 12:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    private ISysUserService userService;
    @Autowired
    public void setUserService(ISysUserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册
     *
     * @param data 注册数据
     * @param user 用户
     * @return 返回注册结果
     */
    @PostMapping("/register")
    public Result<JSONObject> userRegister(@RequestBody JSONObject data, SysUser user) {
        return userService.register(data, user);
    }

    /**
     * 获取用户信息
     *
     * @param request 请求
     * @return 用户信息
     */
    @GetMapping("/getUserInfo")
    public Result<JSONObject> getUserInfo(HttpServletRequest request) {
        return userService.getUserInfo(request);
    }
}
