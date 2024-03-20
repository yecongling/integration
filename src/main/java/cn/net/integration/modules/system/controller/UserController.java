package cn.net.integration.modules.system.controller;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.modules.system.entity.SysUser;
import cn.net.integration.modules.system.service.ISysUserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ClassName SysUserController
 * @Description 用户相关controller  如注册、用户管理等
 * @Author ycl
 * @Date 2022/11/4 12:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

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
    public Response<JSONObject> userRegister(@RequestBody JSONObject data, SysUser user) {
        return userService.register(data, user);
    }

    /**
     * 查询用户数据
     *
     * @param params 查询参数
     * @return 用户信息
     */
    @PostMapping("/getAllUser")
    public List<SysUser> getAllUser(@RequestBody JSONObject params) {
        return userService.queryUserInfo(params);
    }

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 更新结果
     */
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody SysUser user) {
        // 进行参数判定（用户id必传）
        String id = user.getId();
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("传入的用户ID为空，无法进行用户信息更改！");
        }
        return userService.updateUser(user);
    }

    /**
     * 分配用户权限，相对于给用户分配角色
     * @param params 用户信息和角色信息
     * @return 结果
     */
    @PostMapping("/assignPermission")
    public String assignPermission(@RequestBody JSONObject params) {
        return "";
    }
}
