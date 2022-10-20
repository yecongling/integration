package cn.soft.engine.project.controller;

import cn.soft.engine.project.service.ProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @TODO 项目管理controller
 * @Author ycl
 * @Date 2022/10/20 12:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class ProjectManagerController {

    /* 注入项目管理service */
    private ProjectManagerService projectManagerService;

    @Autowired
    public void setProjectManagerService(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }


}
