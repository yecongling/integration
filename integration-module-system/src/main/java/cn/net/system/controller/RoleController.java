package cn.net.system.controller;

import cn.net.base.core.Response;
import cn.net.system.bean.Role;
import cn.net.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/role")
public class RoleController {

    private IRoleService roleService;
    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 获取所有角色
     *
     * @param role 筛选条件
     * @return 角色
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Response<List<Role>> findAll(Role role) {
        return Response.success(roleService.selectRoleList(role));
    }

    /**
     * 根据角色id获取角色信息
     *
     * @param roleId 角色id
     * @return 角色信息
     */
    @GetMapping(value = "/getRoleById/{roleId}")
    public Response<Role> getRoleById(@PathVariable("roleId") String roleId) {
        return Response.success(roleService.selectRoleById(roleId));
    }

    /**
     * 新增角色
     *
     * @param role 角色信息
     * @return 结果
     */
    @PostMapping(value = "/addRole")
    public Response<Boolean> addRole(@RequestBody Role role) {
        return Response.success(roleService.insertRole(role));
    }

    /**
     * 更新角色信息（禁用启用也是）
     *
     * @param role 角色
     * @return 结果
     */
    @PostMapping(value = "/updateRole")
    public Response<Boolean> updateRole(@RequestBody Role role) {
        return Response.success(roleService.updateRole(role));
    }

    /**
     * 删除角色
     *
     * @param roleId 角色信息
     * @return 结果
     */
    @DeleteMapping("/deleteRole/{roleId}")
    public Response<Boolean> deleteRole(@PathVariable("roleId") String roleId) {
        return Response.success(roleService.deleteRole(roleId));
    }

    /**
     * 给角色分配权限菜单
     *
     * @param role 角色信息（包含菜单）
     * @return 分配结果
     */
    @PostMapping(value = "/assignMenusToRole")
    public Response<Boolean> assignMenusToRole(@RequestBody Role role) {
        return Response.success(roleService.assignMenuToRole(role));
    }
}
