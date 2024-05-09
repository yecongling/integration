package cn.net.system.controller;

import cn.net.system.bean.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/system/role")
public class RoleController {

    /**
     * 获取所有角色
     *
     * @return 角色
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<Role> findAll() {
        return new ArrayList<>();
    }
}
