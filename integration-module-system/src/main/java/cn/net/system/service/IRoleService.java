package cn.net.system.service;

import cn.net.system.bean.Role;

import java.util.List;

/**
 * @ClassName IRoleService
 * @Description 角色service接口类
 * @Author ycl
 * @Date 2024/7/8 下午2:52
 * @Version 1.0
 */
public interface IRoleService {

    /**
     * 查询角色信息
     *
     * @param role 角色信息
     * @return 角色列表
     */
    List<Role> selectRoleList(Role role);

    /**
     * 根据角色id获取角色信息
     *
     * @param roleId 角色id
     * @return 角色信息
     */
    Role selectRoleById(String roleId);

    /**
     * 新增角色
     *
     * @param role 角色
     * @return 结果
     */
    Boolean insertRole(Role role);

    /**
     * 更新角色
     *
     * @param role 角色
     * @return 结果
     */
    Boolean updateRole(Role role);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return true 成功 false 失败
     */
    Boolean deleteRole(String roleId);

    /**
     * 给角色分配权限菜单
     *
     * @param role 角色信息（包含菜单）
     * @return 分配结果
     */
    Boolean assignMenuToRole(Role role);
}
