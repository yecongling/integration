package cn.net.integration.modules.system.controller;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.system.entity.SysPermission;
import cn.net.integration.modules.system.service.ISysPermissionService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName SysPermissionController
 * @Description 菜单权限控制器
 * @Author ycl
 * @Date 2022/12/22 12:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/permission")
public class PermissionController {

    private ISysPermissionService sysPermissionService;

    @Autowired
    public void setSysPermissionService(ISysPermissionService sysPermissionService) {
        this.sysPermissionService = sysPermissionService;
    }

    /**
     * 查询当前用户角色所拥有的菜单权限和按钮权限
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    @RequestMapping(value = "/getUserPermissionByRole", method = RequestMethod.GET)
    public Object getUserPermissionByToken(@RequestParam(name = "roleId") String roleId) {
        return sysPermissionService.queryByUser(roleId);
    }

    /**
     * 获取所有菜单
     *
     * @param object 请求参数
     * @return 菜单信息
     */
    @RequestMapping(value = "/getAllPermission", method = RequestMethod.POST)
    public Result<Object> getAllPermission(@RequestBody JSONObject object) {
        return Result.success(sysPermissionService.getAllPermission(object));
    }

    /**
     * 获取所有目录
     *
     * @return 目录
     */
    @RequestMapping(value = "/getDirectoryPermission", method = RequestMethod.GET)
    public Result<JSONObject> getDirectoryPermission() {
        return sysPermissionService.getDirectoryPermission();
    }

    /**
     * 新增菜单
     *
     * @param sysPermission 菜单信息对象
     * @return 新增成功或失败
     */
     @RequestMapping(value = "/addPermission", method = RequestMethod.POST)
    public Result<Object> addPermission(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.addPermission(sysPermission);
    }

    /**
     * 修改菜单
     *
     * @param sysPermission 菜单信息对象
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
    public Result<String> updatePermission(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.updatePermission(sysPermission);
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/deletePermission", method = RequestMethod.POST)
    public Result<Object> deletePermission(@RequestBody String id) {
        return sysPermissionService.deletePermission(id);
    }


}
