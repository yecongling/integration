package cn.net.integration.modules.system.controller;

import cn.net.integration.modules.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RoleController
 * @Description 角色controller
 * @Author ycl
 * @Date 2024/1/22 14:05
 * @Version 1.0
 */
@RestController
public class RoleController {
    private IRoleService roleService;

    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

}
