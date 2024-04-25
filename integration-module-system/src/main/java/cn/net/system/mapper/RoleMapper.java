package cn.net.system.mapper;

import cn.net.system.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色mapper
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户id
     * @return 角色信息
     */
    List<Role> selectByUserId(Long userId);
}
