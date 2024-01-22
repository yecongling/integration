package cn.net.integration.modules.system.mapper;

import cn.net.integration.modules.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName SysUserRoleMapper
 * @Description 用户角色关联
 * @Author ycl
 * @Date 2022/11/9 12:46
 * @Version 1.0
 */
@Mapper
public interface RoleMapper extends BaseMapper<SysRole> {

    /**
     * 添加用户角色关系
     *
     * @param userRole 用户角色关联对象
     * @return 受影响的行数
     */
    Integer addUserRole(SysRole userRole);
}
