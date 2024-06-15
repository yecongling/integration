package cn.net.system.service.impl;

import cn.net.base.core.Response;
import cn.net.system.bean.SysUser;
import cn.net.system.mapper.UserMapper;
import cn.net.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户service实现类
 * @Author ycl
 * @Date 2024/4/28 下午1:52
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    private final UserMapper userMapper;

    @Autowired
    public SysUserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 查询所有的用户
     *
     * @param sysUser 查询条件
     * @return 所有用户
     */
    @Override
    public Response<List<SysUser>> getAllUsers(SysUser sysUser) {
        return null;
    }

    /**
     * 根据id查询用户
     *
     * @param id id
     * @return 用户信息
     */
    @Override
    public Response<SysUser> getUserById(String id) {
        return null;
    }

    /**
     * 新增用户信息
     *
     * @param sysUser 用户信息
     * @return 新增结果
     */
    @Override
    public Response<SysUser> addUser(SysUser sysUser) {
        return null;
    }

    /**
     * 更新用户信息（包括删除 - 移入回收站）
     *
     * @param sysUser 用户信息
     * @return 更新结果
     */
    @Override
    public Response<SysUser> updateUser(SysUser sysUser) {
        return null;
    }

    /**
     * 删除用户信息(这里多指从回收站删除)
     *
     * @param id 用户id
     * @return 结果
     */
    @Override
    public Response<SysUser> deleteUser(String id) {
        return null;
    }
}
