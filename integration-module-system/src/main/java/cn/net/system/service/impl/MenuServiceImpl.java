package cn.net.system.service.impl;

import cn.net.system.mapper.MenuMapper;
import cn.net.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MenuServiceImpl
 * @Description 菜单service实现类
 * @Author ycl
 * @Date 2024/4/28 下午12:47
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements IMenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }
}
