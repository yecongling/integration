package cn.soft.system.user.service.impl;

import cn.soft.system.user.mapper.SysLoginMapper;
import cn.soft.system.user.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysLoginServiceImpl
 * @Description 系统登录相关业务操作
 * @Author ycl
 * @Date 2022/10/28 11:01
 * @Version 1.0
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {

    private SysLoginMapper sysLoginMapper;
    @Autowired
    public void setSysLoginMapper(SysLoginMapper sysLoginMapper) {
        this.sysLoginMapper = sysLoginMapper;
    }
}
