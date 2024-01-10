package cn.net.integration.modules.system.mapper;

import cn.net.integration.modules.system.entity.SysPermission;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SysPermissionMapper
 * @Description 菜单权限mapper
 * @Author ycl
 * @Date 2022/12/22 12:49
 * @Version 1.0
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 查询用户权限
     *
     * @param userId 用户ID
     * @return 用户权限
     */
    List<SysPermission> queryByUser(@Param("userId") String userId);

    /**
     * 获取所有菜单信息
     *
     * @param param 查询参数
     * @return 菜单信息
     */
    List<SysPermission> getAllPermission(@Param("params") JSONObject param);

    /**
     * 获取所有目录菜单
     *
     * @return 目录菜单
     */
    List<SysPermission> getDirectoryPermission();

    /**
     * 添加菜单
     *
     * @param permission 菜单对象
     * @return 受影响的行数
     */
    int addPermission(SysPermission permission);

    /**
     * 更新菜单
     *
     * @param permission 菜单对象
     * @return -
     */
    int updatePermission(SysPermission permission);

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return -
     */
    int deletePermission(String id);
}
