package cn.net.system.controller;

import cn.net.base.core.Response;
import cn.net.system.bean.Menu;
import cn.net.system.service.IMenuService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
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
@RequestMapping("/system/menu")
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
    public List<Menu> getAllMenus(@RequestBody(required = false) JSONObject menu) {
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
     * @param roleId 角色ID
     * @return 菜单
     */
    @GetMapping("/getDirectoryMenu")
    public JSONArray getDirectoryMenu(@RequestParam(name = "roleId") String roleId) {
        return menuService.getDirectory(roleId);
    }

    /**
     * 新增菜单
     *
     * @param sysPermission 菜单信息对象
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/addPermission", method = RequestMethod.POST)
    public Response<Object> addPermission(@RequestBody Menu sysPermission) {
        return menuService.addMenu(sysPermission);
    }

    /**
     * 修改菜单
     *
     * @param sysPermission 菜单信息对象
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
    public Response<String> updatePermission(@RequestBody Menu sysPermission) throws Exception{
        return menuService.updateMenu(sysPermission);
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/deletePermission", method = RequestMethod.POST)
    public Response<Object> deletePermission(@RequestBody String id) {
        return menuService.deleteMenu(id);
    }
}
