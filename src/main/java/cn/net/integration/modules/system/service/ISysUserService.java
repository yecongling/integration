package cn.net.integration.modules.system.service;


import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.system.entity.SysUser;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * @ClassName SysUserService
 * @Description 系统用户service接口
 * @Author ycl
 * @Date 2022/11/4 13:01
 * @Version 1.0
 */
public interface ISysUserService extends IService<SysUser> {

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

    /**
     * 查询所有用户信息
     *
     * @param user 查询的用户参数
     * @return 用户信息
     */
    List<SysUser> queryUserInfo(JSONObject user);
}
