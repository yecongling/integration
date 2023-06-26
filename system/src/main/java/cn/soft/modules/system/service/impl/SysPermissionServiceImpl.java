package cn.soft.modules.system.service.impl;

import cn.soft.common.api.vo.Result;
import cn.soft.common.constant.CommonConstant;
import cn.soft.common.constant.SymbolConstant;
import cn.soft.common.util.ConvertUtil;
import cn.soft.modules.system.entity.SysPermission;
import cn.soft.modules.system.mapper.SysPermissionMapper;
import cn.soft.modules.system.service.ISysPermissionService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SysPermissionServiceImpl
 * @Description 权限业务实现类
 * @Author ycl
 * @Date 2022/12/22 12:55
 * @Version 1.0
 */
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    public void setSysPermissionMapper(SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
    }

    /**
     * 获取登录用户所拥有的权限
     *
     * @param userId 用户ID
     * @return 权限数据
     */
    @Override
    public Result<JSONObject> queryByUser(String userId) {
        Result<JSONObject> result = new Result<>();
        try {
            // 根据userId获取对应的菜单
            List<SysPermission> permissions = sysPermissionMapper.queryByUser(userId);
            // 将平级的菜单构建成上下结构的格式
            JSONArray jsonArray = new JSONArray();
            this.getPermissionJsonArray(jsonArray, permissions, null);
            // 路由菜单
            JSONObject json = new JSONObject();
            json.put("menu", jsonArray);
            result.setResult(json);
        } catch (Exception e) {
            result.error500("查询失败：" + e.getMessage());
        }
        return result;
    }

    /**
     * 获取所有菜单 这里需要修改，处理成上下级的那种数据，和上面的路由的数据格式不一致
     *
     * @return 所有菜单
     */
    @Override
    public Result<JSONObject> getAllPermission() {
        Result<JSONObject> result = new Result<>();
        List<SysPermission> allPermission = sysPermissionMapper.getAllPermission();
        // 构建菜单的上下级结构关系
        List<SysPermission> sysPermissions = this.buildPermission(allPermission);
        // 路由菜单
        JSONObject json = new JSONObject();
        json.put("data", sysPermissions);
        result.setResult(json);
        result.setCode(200);
        return result;
    }


    /**
     * 新增菜单
     *
     * @param permission 菜单
     * @return 结果
     */
    @Override
    public Result<Object> addPermission(SysPermission permission){
        System.out.println("添加菜单");
        return null;
    }

    /**
     * 构建菜单数据
     * @param permissions 查出来的菜单数据
     * @return 构建好的菜单数据
     */
    private List<SysPermission> buildPermission(List<SysPermission> permissions) {
        Map<String, SysPermission> idToPermissionMap = new HashMap<>();
        for (SysPermission permission : permissions) {
            idToPermissionMap.put(permission.getId(), permission);
        }
        List<SysPermission> roots = new ArrayList<>();
        for (SysPermission permission : permissions) {
            String parentId = permission.getParentId();
            permission.setKey(permission.getId());
            if (StringUtils.isBlank(parentId)) {
                roots.add(permission);
            } else {
                SysPermission parent = idToPermissionMap.get(parentId);
                if (parent != null) {
                    parent.getChildren().add(permission);
                }
            }
        }
        return roots;
    }

    /**
     * 获取菜单json数组
     *
     * @param array       json数组
     * @param permissions 菜单数据
     * @param parentJSON  父级
     */
    private void getPermissionJsonArray(JSONArray array, List<SysPermission> permissions, JSONObject parentJSON) {
        for (SysPermission permission : permissions) {
            if (permission.getMenuType() == null) {
                continue;
            }
            String parentId = permission.getParentId();
            JSONObject json = getPermissionJsonObject(permission);
            if (json == null) {
                continue;
            }
            if (parentJSON == null && ConvertUtil.isEmpty(parentId)) {
                array.add(json);
                if (!permission.isLeaf()) {
                    getPermissionJsonArray(array, permissions, json);
                }
            } else if (parentJSON != null && ConvertUtil.isNotEmpty(parentId) && parentId.equals(parentJSON.get("id"))) {
                // 类型( 0：一级菜单 1：子菜单 2：按钮 )
                if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_2)) {
                    JSONObject meta = parentJSON.getJSONObject("meta");
                    if (meta.containsKey("permissionList")) {
                        meta.getJSONArray("permissionList").add(json);
                    } else {
                        JSONArray permissionList = new JSONArray();
                        permissionList.add(json);
                        meta.put("permissionList", permissionList);
                    }
                } else if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_1) || permission.getMenuType().equals(CommonConstant.MENU_TYPE_0)) {
                    if (parentJSON.containsKey("children")) {
                        parentJSON.getJSONArray("children").add(json);
                    } else {
                        JSONArray children = new JSONArray();
                        children.add(json);
                        parentJSON.put("children", children);
                    }
                    if (!permission.isLeaf()) {
                        getPermissionJsonArray(array, permissions, json);
                    }
                }
            }
        }
    }

    /**
     * 根据菜单配置生成路由json
     *
     * @param permission 菜单权限
     * @return json
     */
    private JSONObject getPermissionJsonObject(SysPermission permission) {
        JSONObject json = new JSONObject();
        // 类型 0 一级菜单  1 子菜单  2 按钮
        if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_2)) {
            return null;
        } else if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_0) || permission.getMenuType().equals(CommonConstant.MENU_TYPE_1)) {
            json.put("id", permission.getId());
            // 表示生成路由
            json.put("route", permission.isRoute() ? "1" : "0");
            json.put("path", permission.getUrl());
            if (ConvertUtil.isNotEmpty(permission.getComponentName())) {
                json.put("name", permission.getComponentName());
            } else {
                json.put("name", urlToRouteName(permission.getUrl()));
            }
            // 元数据
            JSONObject meta = new JSONObject();
            // 是否隐藏路由，默认都显示
            if (permission.isHidden()) {
                json.put("hidden", true);
            }
            json.put("component", permission.getComponent());
            meta.put("keepAlive", permission.isKeepAlive());
            // 外链菜单打开方式
            meta.put("internalOrExternal", permission.isInternalOrExternal());
            meta.put("title", permission.getName());
            String component = permission.getComponent();
            if (ConvertUtil.isNotEmpty(permission.getComponentName()) || ConvertUtil.isNotEmpty(component)) {
                meta.put("componentName", ConvertUtil.getString(permission.getComponentName(), component.substring(component.lastIndexOf("/") + 1)));
            }
            if (ConvertUtil.isEmpty(permission.getParentId())) {
                // 一级菜单跳转地址
                json.put("redirect", permission.getRedirect());
            }
            if (ConvertUtil.isNotEmpty(permission.getIcon())) {
                meta.put("icon", permission.getIcon());
            }
            if (isWwwHttpUrl(permission.getUrl())) {
                meta.put("url", permission.getUrl());
            }
            json.put("meta", meta);
        }
        return json;
    }

    /**
     * 判断是否外网URL 例如： <a href="http://localhost:8080/jeecg-boot/swagger-ui.html#/">...</a> 支持特殊格式： {{
     * window._CONFIG['domianURL'] }}/druid/ {{ JS代码片段 }}，前台解析会自动执行JS代码片段
     *
     * @return
     */
    private boolean isWwwHttpUrl(String url) {
        return url != null && (url.startsWith(CommonConstant.HTTP_PROTOCOL) || url.startsWith(CommonConstant.HTTPS_PROTOCOL) || url.startsWith(SymbolConstant.DOUBLE_LEFT_CURLY_BRACKET));
    }

    /**
     * 通过URL生成路由name（去掉URL前缀斜杠，替换内容中的斜杠‘/’为-） 举例： URL = /system/role RouteName =
     * system-role
     *
     * @return
     */
    private String urlToRouteName(String url) {
        if (ConvertUtil.isNotEmpty(url)) {
            if (url.startsWith(SymbolConstant.SINGLE_SLASH)) {
                url = url.substring(1);
            }
            url = url.replace("/", "-");

            // 特殊标记
            url = url.replace(":", "@");
            return url;
        } else {
            return null;
        }
    }
}
