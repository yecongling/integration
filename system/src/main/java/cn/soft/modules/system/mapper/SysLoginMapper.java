package cn.soft.modules.system.mapper;

import cn.soft.modules.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SysLoginMapper
 * @Description 系统登录mapper
 * @Author ycl
 * @Date 2022/10/28 11:00
 * @Version 1.0
 */
@Repository
public interface SysLoginMapper {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户实例
     */
    SysUser getSysUserByUsername(@Param("username") String username);

}
