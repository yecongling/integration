package cn.net.integration.modules.system.controller;

import cn.net.integration.modules.system.entity.SysRole;
import cn.net.integration.modules.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description 角色controller
 * @Author ycl
 * @Date 2024/1/22 14:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {
    private IRoleService roleService;

    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 查询所有角色信息（用于角色信息维护界面上的角色信息）
     * 也可用于在给用户分配角色时选择角色
     * @param role 查询条件
     * @return 角色信息
     */
    @PostMapping("/queryRoles")
    public List<SysRole> queryRoles(@RequestBody SysRole role) {
        return null;
    }

    /**
     *  保存修改系统角色信息
     *
     * @param role 角色信息
     * @return true 修改成功  false 修改失败
     */
    public boolean saveOrUpdate(@RequestBody SysRole role) {
        return true;
    }
}
