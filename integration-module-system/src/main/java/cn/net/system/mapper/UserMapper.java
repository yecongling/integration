package cn.net.system.mapper;

import cn.net.system.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description 用户mapper
 * @Author ycl
 * @Date 2024/4/28 下午2:18
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    SysUser getUserByUsername(String username);
}
