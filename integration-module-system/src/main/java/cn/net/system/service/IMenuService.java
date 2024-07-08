package cn.net.system.service;

import cn.net.base.core.Response;
import cn.net.system.bean.Menu;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @ClassName IMenuService
 * @Description 查询菜单信息的service
 * @Author ycl
 * @Date 2024/4/28 下午12:47
 * @Version 1.0
 */
public interface IMenuService {

    /**
     * 获取所有菜单
     *
     * @param menu 菜单查询条件
     * @return 符合条件的菜单
     */
    List<Menu> getAllMenus(JSONObject menu);

    /**
     * 根据角色获取菜单
     *
     * @param roleId 角色id
     * @return 菜单信息
     */
    JSONArray getMenusByRole(String roleId);

    /**
     * 获取一级菜单，用于构建菜单的上级
     * @param roleId 角色ID
     * @return 目录
     */
    JSONArray getDirectory(String roleId);

    /**
     * 新增菜单
     *
     * @param menu 菜单
     * @return 结果
     */
    Response<Object> addMenu(Menu menu);

    /**
     * 更新菜单
     *
     * @param menu 菜单对象
     * @return 结果
     */
    Response<String> updateMenu(Menu menu) throws Exception;

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return -
     */
    Response<Object> deleteMenu(String id);
}
