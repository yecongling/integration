package cn.soft.modules.system.controller;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.system.service.ISysPermissionService;
import com.alibaba.fastjson.JSONArray;
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
        Result<JSONObject> result = new Result<>();
        try {
            // 获取当前登录用户
//            LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//            LoginUser loginUser = null;
//            if (ConvertUtil.isEmpty(loginUser)) {
//                return Result.error("请登录系统");
//            }
            JSONObject object = new JSONObject();
            object.put("path","/menu");
            object.put("component","system/menu");
            JSONObject meta = new JSONObject();
            object.put("meta", meta);
            meta.put("title", "测试菜单");
            meta.put("icon", "PropertySafetyOutlined");
            meta.put("requiresAuth", true);
            JSONArray array = new JSONArray();
            array.add(object);
            JSONObject result2 = new JSONObject();
            result2.put("menu", array);
            return Result.OK(result2);

        } catch (Exception e) {
            result.error500("查询失败：" + e.getMessage());
        }
        return null;
    }
}
