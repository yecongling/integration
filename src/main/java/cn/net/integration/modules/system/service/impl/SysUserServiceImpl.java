package cn.net.integration.modules.system.service.impl;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.core.common.constant.CommonConstant;
import cn.net.integration.core.common.util.ConvertUtil;
import cn.net.integration.core.common.util.PasswordUtil;
import cn.net.integration.modules.system.entity.SysUser;
import cn.net.integration.modules.system.mapper.RoleMapper;
import cn.net.integration.modules.system.mapper.SysUserMapper;
import cn.net.integration.modules.system.service.ISysUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description 系统用户service实现类
 * @Author ycl
 * @Date 2022/11/4 13:02
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private SysUserMapper userMapper;

    @Autowired
    public void setUserMapper(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private RoleMapper userRoleMapper;

    @Autowired
    public void setUserRoleMapper(RoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    /**
     * 用户注册
     *
     * @param jsonObject 注册信息
     * @return 注册结果
     */
    @Override
    public Response<JSONObject> register(JSONObject jsonObject, SysUser user) {
        Response<JSONObject> response = new Response<>();
        String phone = jsonObject.getString("phone");
        String username = jsonObject.getString("username");
        // 未设置用户名，则用手机号作为用户名
        if (StringUtils.isEmpty(username)) {
            username = phone;
        }
        String password = jsonObject.getString("password");
        if (StringUtils.isEmpty(password)) {
            return response.error500("注册失败，密码不能为空");
        }
        // 根据用户名检测是否重复
        SysUser sysUser = userMapper.getUserByName(username);
        if (sysUser != null) {
            response.setMessage("用户名已注册");
            response.setCode(500);
            return response;
        }
        // 根据手机号验证用户是否存在
        SysUser byPhone = userMapper.getUserByPhone(phone);
        if (byPhone != null) {
            response.setMessage("该手机号已注册");
            response.setCode(500);
            return response;
        }
        try {
            user.setCreateTime(new Date());// 设置创建时间
            String salt = ConvertUtil.randomGen(8);
            String passwordEncode = PasswordUtil.encrypt(username, password, salt);
            user.setSalt(salt);
            user.setUsername(username);
            user.setRealName(username);
            user.setPassword(passwordEncode);
            user.setPhone(phone);
            user.setStatus(CommonConstant.USER_UNFREEZE);
            user.setDelFlag(CommonConstant.DEL_FLAG_0);
            user.setActivitySync(CommonConstant.ACT_SYNC_0);
            // 默认临时角色
//            this.addUserWithRole(user, "ee8626f80f7c2619917b6236f3a7f02b");
            Response.success("注册成功");
        } catch (Exception e) {
            response.error500("注册失败， 原因： " + e.getMessage());
        }
        return response;
    }


    /**
     * 添加用户和用户角色的关系
     *
     * @param user  用户
     * @param roles 角色
     */
    @Override
    public void addUserWithRole(SysUser user, String roles) {
        userMapper.saveUser(user);
//        if (StringUtils.isNotEmpty(roles)) {
//            String[] arr = roles.split(",");
//            // 后续添加角色和用户关联表的数据
//            for (String roleId : arr) {
//                SysRole userRole = new SysRole(roleId);
//                userRoleMapper.addUserRole(userRole);
//            }
//        }
    }

    /**
     * 查询所有用户信息
     *
     * @param user 查询的用户参数
     * @return 用户信息
     */
    @Override
    public List<SysUser> queryUserInfo(JSONObject user) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isBlank(user.getString("username")), "username", user.getString("username"));
        wrapper.eq(StringUtils.isBlank(user.getString("real_name")), "real_name", user.getString("real_name"));
        wrapper.eq(StringUtils.isBlank(user.getString("sex")), "sex", user.getString("sex"));
        wrapper.eq(StringUtils.isBlank(user.getString("status")), "status", user.getString("status"));
        return userMapper.selectList(wrapper);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return true 更新成功 false 更新失败
     */
    @Override
    public boolean updateUser(SysUser user) {
        int i = userMapper.updateById(user);
        return i > 0;
    }
}
