package cn.net.integration.modules.system.service.impl;

import cn.net.integration.modules.system.entity.SysRole;
import cn.net.integration.modules.system.mapper.RoleMapper;
import cn.net.integration.modules.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoleServiceImpl
 * @Description 角色管理业务实现类
 * @Author ycl
 * @Date 2024/1/23 08:42
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRole> implements IRoleService {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
}
