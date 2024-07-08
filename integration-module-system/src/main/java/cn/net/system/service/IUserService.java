package cn.net.system.service;

import cn.net.base.core.Response;
import cn.net.system.bean.SysUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName IUserService
 * @Description 用户service
 * @Author ycl
 * @Date 2024/4/28 下午1:51
 * @Version 1.0
 */
public interface IUserService {
    /**
     * 查询所有的用户
     *
     * @param sysUser 查询条件
     * @return 所有用户
     */
    Response<List<SysUser>> getAllUsers(SysUser sysUser);

    /**
     * 根据id查询用户
     *
     * @param id id
     * @return 用户信息
     */
    Response<SysUser> getUserById(@PathVariable String id);

    /**
     * 新增用户信息
     *
     * @param sysUser 用户信息
     * @return 新增结果
     */
    Response<SysUser> addUser(@RequestBody @Valid SysUser sysUser);

    /**
     * 更新用户信息（包括删除 - 移入回收站）
     *
     * @param sysUser 用户信息
     * @return 更新结果
     */
    Response<SysUser> updateUser(@Valid @RequestBody SysUser sysUser);

    /**
     * 删除用户信息(这里多指从回收站删除)
     *
     * @param id 用户id
     * @return 结果
     */
    Response<SysUser> deleteUser(@PathVariable String id);
}
