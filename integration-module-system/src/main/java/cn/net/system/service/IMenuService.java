package cn.net.system.service;

import com.alibaba.fastjson.JSONArray;

/**
 * @ClassName IMenuService
 * @Description 查询菜单信息的service
 * @Author ycl
 * @Date 2024/4/28 下午12:47
 * @Version 1.0
 */
public interface IMenuService {

    /**
     * 根据角色获取菜单
     *
     * @param roleId 角色id
     * @return 菜单信息
     */
    JSONArray getMenusByRole(String roleId);
}
