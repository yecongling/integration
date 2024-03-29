package cn.net.integration.modules.system.service.impl;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.core.common.constant.CommonConstant;
import cn.net.integration.core.common.constant.SymbolConstant;
import cn.net.integration.core.common.util.ConvertUtil;
import cn.net.integration.core.common.util.UUIDUtil;
import cn.net.integration.modules.system.entity.SysPermission;
import cn.net.integration.modules.system.mapper.SysPermissionMapper;
import cn.net.integration.modules.system.service.ISysPermissionService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName SysPermissionServiceImpl
 * @Description 权限业务实现类
 * @Author ycl
 * @Date 2022/12/22 12:55
 * @Version 1.0
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    public void setSysPermissionMapper(SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
    }

    /**
     * 获取登录用户所拥有的权限，根据角色查询菜单信息
     *
     * @param roleId 角色ID
     * @return 权限数据
     */
    @Override
    public Object queryByUser(String roleId) {
        // 根据userId获取对应的菜单
        List<SysPermission> permissions = sysPermissionMapper.queryByUser(roleId);
        // 将平级的菜单构建成上下结构的格式
        JSONArray jsonArray = new JSONArray();
        this.getPermissionJsonArray(jsonArray, permissions, null);
        // 路由菜单
        return jsonArray;
    }

    /**
     * 获取所有菜单 这里需要修改，处理成上下级的那种数据，和上面的路由的数据格式不一致
     *
     * @param params 查询参数
     * @return 所有菜单
     */
    @Override
    public List<SysPermission> getAllPermission(JSONObject params) {
        List<SysPermission> allPermission = sysPermissionMapper.getAllPermission(params);
        // 构建菜单的上下级结构关系
        return this.buildPermission(allPermission);
    }

    /**
     * 获取所有目录菜单
     *
     * @return 目录菜单
     */
    @Override
    public Response<JSONObject> getDirectoryPermission() {
        Response<JSONObject> response = new Response<>();
        List<SysPermission> permissions = sysPermissionMapper.getDirectoryPermission();
        // 将平级的菜单构建成上下结构的格式
        JSONArray jsonArray = new JSONArray();
        this.getPermissionDirectory(jsonArray, permissions, null);
        // 路由菜单
        JSONObject json = new JSONObject();
        json.put("directory", jsonArray);
        response.setCode(200);
        response.setResult(json);
        return response;
    }

    /**
     * 新增菜单
     *
     * @param permission 菜单
     * @return 结果
     */
    @Override
    public Response<Object> addPermission(SysPermission permission) {
        // 设置一些必要属性
        Date date = new Date();
        permission.setId(UUIDUtil.getUniqueId());
        permission.setCreateTime(date);
        permission.setUpdateTime(date);
        permission.setCreateBy("admin");
        permission.setUpdateBy("admin");
        int i = sysPermissionMapper.addPermission(permission);
        if (i > 0) {
            return Response.success("新增菜单成功");
        }
        return Response.error("新增菜单失败");
    }

    /**
     * 更新菜单
     *
     * @param permission 菜单对象
     * @return 结果
     */
    @Override
    public Response<String> updatePermission(SysPermission permission) {
        // 设置一些必要属性
        Date date = new Date();
        permission.setCreateTime(date);
        permission.setUpdateTime(date);
        permission.setCreateBy("admin");
        permission.setUpdateBy("admin");
        int i = sysPermissionMapper.updatePermission(permission);
        if (i > 0) {
            return Response.success("修改菜单成功");
        }
        return Response.error("菜单修改失败");
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return -
     */
    @Override
    public Response<Object> deletePermission(String id) {
        int i = sysPermissionMapper.deletePermission(id);
        return Response.success(i);
    }

    /**
     * 构建菜单数据
     *
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
                } else {
                    // 针对检索的结果有可能没有父级
                    roots.add(permission);
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
     * 获取菜单json数组
     *
     * @param array       json数组
     * @param permissions 菜单数据
     * @param parentJSON  父级
     */
    private void getPermissionDirectory(JSONArray array, List<SysPermission> permissions, JSONObject parentJSON) {
        for (SysPermission permission : permissions) {
            if (permission.getMenuType() == null) {
                continue;
            }
            String parentId = permission.getParentId();
            JSONObject json = getPermissionDirectory(permission);
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
                if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_1) || permission.getMenuType().equals(CommonConstant.MENU_TYPE_0)) {
                    if (parentJSON.containsKey("children")) {
                        parentJSON.getJSONArray("children").add(json);
                    } else {
                        JSONArray children = new JSONArray();
                        children.add(json);
                        parentJSON.put("children", children);
                    }
                    if (!permission.isLeaf()) {
                        getPermissionDirectory(array, permissions, json);
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
            meta.put("componentName", permission.getComponentName());
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
     * 根据菜单配置生成路由json
     *
     * @param permission 菜单权限
     * @return json
     */
    private JSONObject getPermissionDirectory(SysPermission permission) {
        JSONObject json = new JSONObject();
        // 类型 0 一级菜单  1 子菜单  2 按钮
        if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_2)) {
            return null;
        } else if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_0) || permission.getMenuType().equals(CommonConstant.MENU_TYPE_1)) {
            json.put("value", permission.getId());
            json.put("title", permission.getName());
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
