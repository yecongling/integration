package cn.net.system.service.impl;

import cn.net.base.constant.CommonConstant;
import cn.net.base.constant.SymbolConstant;
import cn.net.base.utils.ConvertUtils;
import cn.net.system.bean.Menu;
import cn.net.system.mapper.MenuMapper;
import cn.net.system.service.IMenuService;
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
 * @ClassName MenuServiceImpl
 * @Description 菜单service实现类
 * @Author ycl
 * @Date 2024/4/28 下午12:47
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements IMenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    /**
     * 获取所有菜单
     *
     * @param menu 菜单查询条件
     * @return 符合条件的菜单
     */
    @Override
    public List<Menu> getAllMenus(JSONObject menu) {
        List<Menu> allMenus = menuMapper.getAllMenus(menu);
        // 构建菜单的上下级关系
        return this.buildMenus(allMenus);
    }

    /**
     * 根据角色获取菜单
     *
     * @param roleId 角色id
     * @return 菜单信息
     */
    @Override
    public JSONArray getMenusByRole(String roleId) {
        // 根据userId获取对应的菜单
        List<Menu> permissions = menuMapper.queryByUser(roleId);
        // 将平级的菜单构建成上下结构的格式
        JSONArray jsonArray = new JSONArray();
        this.getPermissionJsonArray(jsonArray, permissions, null);
        // 路由菜单
        return jsonArray;
    }

    /**
     * 获取一级菜单，用于构建菜单的上级
     *
     * @param roleId 角色ID
     * @return 目录
     */
    @Override
    public JSONArray getDirectory(String roleId) {
        List<Menu> directory = menuMapper.getDirectory(roleId);
        JSONArray jsonArray = new JSONArray();
        this.getDirectory(jsonArray, directory, null);
        return jsonArray;
    }

    /**
     * 构建菜单的上下级关系
     *
     * @param menus 所有菜单
     * @return 构件上树形结构的菜单数据
     */
    private List<Menu> buildMenus(List<Menu> menus) {
        Map<String, Menu> idToPermissionMap = new HashMap<>();
        for (Menu menu : menus) {
            idToPermissionMap.put(menu.getId(), menu);
        }
        List<Menu> roots = new ArrayList<>();
        for (Menu menu : menus) {
            String parentId = menu.getParentId();
            menu.setKey(menu.getId());
            if (StringUtils.isBlank(parentId)) {
                roots.add(menu);
            } else {
                Menu parent = idToPermissionMap.get(parentId);
                if (parent != null) {
                    parent.getChildren().add(menu);
                } else {
                    // 针对检索的结果有可能没有父级
                    roots.add(menu);
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
    private void getDirectory(JSONArray array, List<Menu> permissions, JSONObject parentJSON) {
        for (Menu menu : permissions) {
            if (menu.getMenuType() == null) {
                continue;
            }
            String parentId = menu.getParentId();
            JSONObject json = getPermissionDirectory(menu);
            if (json == null) {
                continue;
            }
            if (parentJSON == null && ConvertUtils.isEmpty(parentId)) {
                array.add(json);
                if (!menu.isLeaf()) {
                    getPermissionJsonArray(array, permissions, json);
                }
            } else if (parentJSON != null && ConvertUtils.isNotEmpty(parentId) && parentId.equals(parentJSON.get("id"))) {
                // 类型( 0：一级菜单 1：子菜单 2：按钮 )
                if (menu.getMenuType().equals(CommonConstant.MENU_TYPE_1) || menu.getMenuType().equals(CommonConstant.MENU_TYPE_0)) {
                    if (parentJSON.containsKey("children")) {
                        parentJSON.getJSONArray("children").add(json);
                    } else {
                        JSONArray children = new JSONArray();
                        children.add(json);
                        parentJSON.put("children", children);
                    }
                    if (!menu.isLeaf()) {
                        getDirectory(array, permissions, json);
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
    private void getPermissionJsonArray(JSONArray array, List<Menu> permissions, JSONObject parentJSON) {
        for (Menu permission : permissions) {
            if (permission.getMenuType() == null) {
                continue;
            }
            String parentId = permission.getParentId();
            JSONObject json = getPermissionJsonObject(permission);
            if (json == null) {
                continue;
            }
            if (parentJSON == null && ConvertUtils.isEmpty(parentId)) {
                array.add(json);
                if (!permission.isLeaf()) {
                    getPermissionJsonArray(array, permissions, json);
                }
            } else if (parentJSON != null && ConvertUtils.isNotEmpty(parentId) && parentId.equals(parentJSON.get("id"))) {
                // 类型( 0：一级菜单 1：子菜单 2：子路由  3：按钮 )
                if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_3)) {
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
                } else if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_2)) {
                    // 处理子路由，即不能再左边菜单列表中进行路由的菜单，但是页面内部又要能路由过去的
                    if (parentJSON.containsKey("childrenRoute")) {
                        parentJSON.getJSONArray("childrenRoute").add(json);
                    } else {
                        JSONArray jsonArray = new JSONArray();
                        jsonArray.add(json);
                        parentJSON.put("childrenRoute", jsonArray);
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
    private void getPermissionDirectory(JSONArray array, List<Menu> permissions, JSONObject parentJSON) {
        for (Menu permission : permissions) {
            if (permission.getMenuType() == null) {
                continue;
            }
            String parentId = permission.getParentId();
            JSONObject json = getPermissionDirectory(permission);
            if (json == null) {
                continue;
            }
            if (parentJSON == null && ConvertUtils.isEmpty(parentId)) {
                array.add(json);
                if (!permission.isLeaf()) {
                    getPermissionJsonArray(array, permissions, json);
                }
            } else if (parentJSON != null && ConvertUtils.isNotEmpty(parentId) && parentId.equals(parentJSON.get("id"))) {
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
    private JSONObject getPermissionJsonObject(Menu permission) {
        // 类型 0 一级菜单  1 子菜单  2 子路由 3 按钮
        if (permission.getMenuType().equals(CommonConstant.MENU_TYPE_3)) {
            return null;
        }
        JSONObject json = new JSONObject();
        json.put("id", permission.getId());
        // 表示生成路由
        json.put("route", permission.isRoute() ? "1" : "0");
        json.put("path", permission.getUrl());
        if (ConvertUtils.isNotEmpty(permission.getComponentName())) {
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
        if (ConvertUtils.isEmpty(permission.getParentId())) {
            // 一级菜单跳转地址
            json.put("redirect", permission.getRedirect());
        }
        if (ConvertUtils.isNotEmpty(permission.getIcon())) {
            meta.put("icon", permission.getIcon());
        }
        if (isWwwHttpUrl(permission.getUrl())) {
            meta.put("url", permission.getUrl());
        }
        json.put("meta", meta);
        return json;
    }

    /**
     * 根据菜单配置生成路由json
     *
     * @param permission 菜单权限
     * @return json
     */
    private JSONObject getPermissionDirectory(Menu permission) {
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
        if (ConvertUtils.isNotEmpty(url)) {
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
