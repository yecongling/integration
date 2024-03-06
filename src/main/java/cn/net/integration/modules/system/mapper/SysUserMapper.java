package cn.net.integration.modules.system.mapper;

import cn.net.integration.modules.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName SysUserMapper
 * @Description 系统用户mapper
 * @Author ycl
 * @Date 2022/11/4 13:02
 * @Version 1.0
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户对象
     */
    SysUser getUserByName(@Param("username") String username);

    /**
     * 根据电话查询用户信息
     *
     * @param phone 电话信息
     * @return 用户对象
     */
    SysUser getUserByPhone(@Param("phone") String phone);

    /**
     * 保存用户信息
     *
     * @param user 用户
     */
    void saveUser(SysUser user);

}
