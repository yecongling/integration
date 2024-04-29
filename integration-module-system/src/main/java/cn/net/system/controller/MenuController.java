package cn.net.system.controller;

import cn.net.system.service.IMenuService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MenuController
 * @Description 菜单管理的控制器
 * @Author ycl
 * @Date 2024/4/28 下午12:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private final IMenuService menuService;

    @Autowired
    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 根据角色查询对应的菜单
     *
     * @param roleId 角色id
     * @return 菜单信息
     */
    @RequestMapping(value = "/getMenusByRole", method = RequestMethod.GET)
    public JSONArray getMenusByRole(@RequestParam(name = "roleId") String roleId) {
        return menuService.getMenusByRole(roleId);
    }
}
