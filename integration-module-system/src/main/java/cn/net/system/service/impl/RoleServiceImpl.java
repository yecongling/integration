package cn.net.system.service.impl;

import cn.net.system.bean.Role;
import cn.net.system.mapper.RoleMapper;
import cn.net.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description 角色service具体实现
 * @Author ycl
 * @Date 2024/7/8 下午4:42
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {

    private RoleMapper roleMapper;
    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    /**
     * 查询角色信息
     *
     * @param role 角色信息
     * @return 角色列表
     */
    @Override
    public List<Role> selectRoleList(Role role) {
        return List.of();
    }

    /**
     * 根据角色id获取角色信息
     *
     * @param roleId 角色id
     * @return 角色信息
     */
    @Override
    public Role selectRoleById(String roleId) {
        return null;
    }

    /**
     * 新增角色
     *
     * @param role 角色
     * @return 结果
     */
    @Override
    public Boolean insertRole(Role role) {
        return null;
    }

    /**
     * 更新角色
     *
     * @param role 角色
     * @return 结果
     */
    @Override
    public Boolean updateRole(Role role) {
        return null;
    }

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return true 成功 false 失败
     */
    @Override
    public Boolean deleteRole(String roleId) {
        return null;
    }

    /**
     * 给角色分配权限菜单
     *
     * @param role 角色信息（包含菜单）
     * @return 分配结果
     */
    @Override
    public Boolean assignMenuToRole(Role role) {
        return null;
    }
}
