package cn.soft.modules.system.service.impl;

import cn.soft.modules.system.entity.SysPermission;
import cn.soft.modules.system.mapper.SysPermissionMapper;
import cn.soft.modules.system.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysPermissionServiceImpl
 * @Description 权限业务实现类
 * @Author ycl
 * @Date 2022/12/22 12:55
 * @Version 1.0
 */
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    public void setSysPermissionMapper(SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
    }

    /**
     * 获取登录用户所拥有的权限
     *
     * @param userId 用户ID
     * @return 权限数据
     */
    @Override
    public List<SysPermission> queryByUser(String userId) {
        return null;
    }
}
