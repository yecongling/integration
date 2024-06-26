package cn.net.system.controller;

import cn.net.base.core.Response;
import cn.net.system.bean.SysUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SysUserController
 * @Description 系统用户控制器接口
 * @Author ycl
 * @Date 2024/5/31 上午9:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController {

    /**
     * 查询所有的用户
     *
     * @param sysUser 查询条件
     * @return 所有用户
     */
    @PostMapping("/getAllUsers")
    public Response<List<SysUser>> getAllUsers(SysUser sysUser) {
        return null;
    }

    /**
     * 根据id查询用户
     *
     * @param id id
     * @return 用户信息
     */
    @GetMapping("/getUserById/{id}")
    public Response<SysUser> getUserById(@PathVariable String id) {
        return null;
    }

    /**
     * 新增用户信息
     *
     * @param sysUser 用户信息
     * @return 新增结果
     */
    @PostMapping("/addUser")
    public Response<SysUser> addUser(@RequestBody @Valid SysUser sysUser) {
        return null;
    }

    /**
     * 更新用户信息（包括删除 - 移入回收站）
     *
     * @param sysUser 用户信息
     * @return 更新结果
     */
    @PostMapping("/updateUser")
    public Response<SysUser> updateUser(@Valid @RequestBody SysUser sysUser) {
        return null;
    }

    /**
     * 删除用户信息(这里多指从回收站删除)
     *
     * @param id 用户id
     * @return 结果
     */
    @DeleteMapping("/deleteUser/{id}")
    public Response<SysUser> deleteUser(@PathVariable String id) {
        return null;
    }


}
