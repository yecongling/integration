package cn.net.platform.controller;

import cn.net.platform.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProjectController
 * @Description 项目管理部分
 * @Author ycl
 * @Date 2024/4/28 下午12:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    private final IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }
}
