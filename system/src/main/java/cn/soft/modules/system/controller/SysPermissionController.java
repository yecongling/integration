package cn.soft.modules.system.controller;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.system.service.ISysPermissionService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
     * @return 菜单信息
     */
    @RequestMapping(value = "/getAllPermission", method = RequestMethod.POST)
    public Result<JSONObject> getAllPermission() throws Exception{
        return sysPermissionService.getAllPermission();
    }
}
