package cn.net.integration.system.modules.system.controller;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.system.modules.system.entity.SysPermission;
import cn.net.integration.system.modules.system.service.ISysPermissionService;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName SysPermissionController
 * @Description 菜单权限控制器
 * @Author ycl
 * @Date 2022/12/22 12:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/permission")
public class SysPermissionController {

    private ISysPermissionService sysPermissionService;

    @Autowired
    public void setSysPermissionService(ISysPermissionService sysPermissionService) {
        this.sysPermissionService = sysPermissionService;
    }

    /**
     * 查询当前用户所拥有的菜单权限和按钮权限
     *
     * @param request 请求
     * @return 权限列表
     */
    @RequestMapping(value = "/getUserPermissionByToken", method = RequestMethod.GET)
    public Result<JSONObject> getUserPermissionByToken(HttpServletRequest request) {
        return sysPermissionService.queryByUser("");
    }

    /**
     * 获取所有菜单
     *
     * @param object 请求参数
     * @return 菜单信息
     */
    @RequestMapping(value = "/getAllPermission", method = RequestMethod.POST)
    public Result<JSONObject> getAllPermission(@RequestBody JSONObject object) {
        return sysPermissionService.getAllPermission(object);
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
