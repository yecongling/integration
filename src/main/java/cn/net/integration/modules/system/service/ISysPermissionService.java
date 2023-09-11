package cn.net.integration.modules.system.service;


import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.system.entity.SysPermission;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName ISysPermissionService
 * @Description 菜单权限业务层
 * @Author ycl
 * @Date 2022/12/22 12:04
 * @Version 1.0
 */
public interface ISysPermissionService {

    /**
     * 获取登录用户所拥有的权限
     *
     * @param userId 用户ID
     * @return 权限数据
     */
    Result<JSONObject> queryByUser(String userId);

    /**
     * 获取所有菜单
     *
     * @param params 查询参数
     * @return 所有菜单
     */
    Result<JSONObject> getAllPermission(JSONObject params);

    /**
     * 获取所有目录菜单
     *
     * @return 目录菜单
     */
    Result<JSONObject> getDirectoryPermission();

    /**
     * 新增菜单
     *
     * @param permission 菜单
     * @return 结果
     */
    Result<Object> addPermission(SysPermission permission);

    /**
     * 更新菜单
     *
     * @param permission 菜单对象
     * @return 结果
     */
    Result<String> updatePermission(SysPermission permission);

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return -
     */
    Result<Object> deletePermission(String id);
}
