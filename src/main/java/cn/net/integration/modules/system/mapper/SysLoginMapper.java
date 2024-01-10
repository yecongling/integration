package cn.net.integration.modules.system.mapper;

import cn.net.integration.modules.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName SysLoginMapper
 * @Description 系统登录mapper
 * @Author ycl
 * @Date 2022/10/28 11:00
 * @Version 1.0
 */
@Mapper
public interface SysLoginMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户实例
     */
    SysUser getSysUserByUsername(@Param("username") String username);

}
