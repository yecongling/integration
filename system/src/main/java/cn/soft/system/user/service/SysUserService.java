package cn.soft.system.user.service;

import cn.soft.common.api.vo.Result;
import cn.soft.system.user.entity.SysUser;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName SysUserService
 * @Description 系统用户service接口
 * @Author ycl
 * @Date 2022/11/4 13:01
 * @Version 1.0
 */
public interface SysUserService {

    /**
     * 用户注册
     *
     * @param jsonObject 注册信息
     * @param user 用户
     * @return 注册结果
     */
    Result<JSONObject> register(JSONObject jsonObject, SysUser user);

    /**
     * 添加用户和用户角色的关系
     *
     * @param user 用户
     * @param roles 角色
     */
    void addUserWithRole(SysUser user, String roles);
}
