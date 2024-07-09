package cn.net.system.mapper;

import cn.net.system.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色mapper
 */
@Mapper
public interface RoleMapper {

    /**
     * 查询角色信息
     *
     * @param role 角色信息
     * @return 角色列表
     */
    List<Role> selectRoleList(Role role);

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户id
     * @return 角色信息
     */
    List<Role> selectByUserId(String userId);

    /**
     * 根据角色id查询角色信息
     *
     * @param roleId 角色id
     * @return 角色信息
     */
    Role selectRoleById(String roleId);

    /**
     * 新增角色
     *
     * @param role 角色
     * @return 受影响的行数
     */
    int addRole(Role role);

    /**
     * 更新角色
     *
     * @param role 角色信息
     * @return 受影响的行数
     */
    int updateRole(Role role);

    /**
     * 删除角色
     *
     * @param id 角色ID
     * @return 受影响的行数
     */
    int deleteRole(String id);

    /**
     * 给角色分配菜单
     *
     * @param role 角色信息（包含菜单）
     * @return 成功或失败
     */
    boolean assignMenuToRole(Role role);
}
