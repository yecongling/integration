package cn.net.integration.modules.system.service;


import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.modules.system.entity.SysPermission;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @ClassName ISysPermissionService
 * @Description 菜单权限业务层
 * @Author ycl
 * @Date 2022/12/22 12:04
 * @Version 1.0
 */
public interface ISysPermissionService extends IService<SysPermission> {

    /**
     * 获取登录用户所拥有的权限
     *
     * @param userId 用户ID
     * @return 权限数据
     */
    Object queryByUser(String userId);

    /**
     * 获取所有菜单
     *
     * @param params 查询参数
     * @return 所有菜单
     */
    List<SysPermission> getAllPermission(JSONObject params);

    /**
     * 获取所有目录菜单
     *
     * @return 目录菜单
     */
    Response<JSONObject> getDirectoryPermission();

    /**
     * 新增菜单
     *
     * @param permission 菜单
     * @return 结果
     */
    Response<Object> addPermission(SysPermission permission);

    /**
     * 更新菜单
     *
     * @param permission 菜单对象
     * @return 结果
     */
    Response<String> updatePermission(SysPermission permission);

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return -
     */
    Response<Object> deletePermission(String id);
}
