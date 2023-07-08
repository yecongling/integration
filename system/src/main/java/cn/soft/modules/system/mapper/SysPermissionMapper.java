package cn.soft.modules.system.mapper;

import cn.soft.modules.system.entity.SysPermission;
import com.alibaba.fastjson.JSONObject;
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
public interface SysPermissionMapper {

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
    List<SysPermission> getAllPermission(@Param("params")JSONObject param);

    /**
     * 添加菜单
     *
     * @param permission 菜单对象
     * @return 受影响的行数
     */
    int addPermission(SysPermission permission);
}
