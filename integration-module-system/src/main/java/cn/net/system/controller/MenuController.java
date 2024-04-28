package cn.net.system.controller;

import cn.net.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MenuController
 * @Description 菜单管理的控制器
 * @Author ycl
 * @Date 2024/4/28 下午12:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private final IMenuService menuService;

    @Autowired
    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }


}
