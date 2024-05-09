package cn.net.engine.controller;

import cn.net.engine.bean.project.Project;
import cn.net.engine.service.IProjectDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ProjectDesignController
 * @Description 项目设计controller
 * @Author ycl
 * @Date 2024/5/9 上午9:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/engine/project")
public class ProjectDesignController {
    private final IProjectDesignService projectDesignService;

    @Autowired
    public ProjectDesignController(IProjectDesignService projectDesignService) {
        this.projectDesignService = projectDesignService;
    }

    /**
     * 查询所有项目信息
     *
     * @param param 检索条件
     * @return 所有的项目信息
     */
    @RequestMapping("/queryProjects")
    public List<Project> queryProject(@RequestBody(required = false) Project param) {
        return projectDesignService.getProjects(param);
    }

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    @GetMapping("/queryProjectById/{projectId}")
    public Project queryProjectById(@PathVariable("projectId") String projectId) {
        return projectDesignService.getProjectById(projectId);
    }

    /**
     * 新增项目信息
     *
     * @param project 封装的项目对象
     * @return 返回保存结果
     */
    @PostMapping("/addProject")
    public boolean addProject(@RequestBody Project project) {
        return projectDesignService.addProject(project);
    }

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    @PostMapping("/updateProject")
    public boolean updateProject(@RequestBody Project project) {
        return projectDesignService.updateProject(project);
    }

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @DeleteMapping("/deleteProject")
    public boolean deleteProject(@RequestParam(name = "projectId") String projectId) {
        return projectDesignService.deleteProject(projectId);
    }
}
