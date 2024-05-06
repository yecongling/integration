package cn.net.system.controller;

import cn.net.system.bean.Menu;
import cn.net.system.service.IMenuService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 查询所有菜单
     *
     *
     * @param menu 菜单查询条件
     * @return 菜单信息
     */
    @PostMapping("/getAllMenus")
    public List<Menu> getAllMenus(@RequestBody JSONObject menu) {
        return menuService.getAllMenus(menu);
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

    /**
     * 获取所有一级菜单（当前登录用户持有的）
     *
     * @return 菜单
     */
    @GetMapping("/getDirectoryMenu")
    public List<Menu> getDirectoryMenu() {
        return null;
    }
}
