package cn.net.engine.controller;

import cn.net.base.core.Response;
import cn.net.engine.bean.project.Project;
import cn.net.engine.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ProjectController
 * @Description 项目controller
 * @Author ycl
 * @Date 2024/5/9 上午9:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    private final IProjectService projectDesignService;

    @Autowired
    public ProjectController(IProjectService projectDesignService) {
        this.projectDesignService = projectDesignService;
    }

    /**
     * 查询所有项目信息
     *
     * @param param 检索条件
     * @return 所有的项目信息
     */
    @RequestMapping("/getProjects")
    public List<Project> getProjects(@RequestBody(required = false) Project param) {
        return projectDesignService.getProjects(param);
    }

    /**
     * 通过项目ID查询项目信息
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
     * 查询回收站项目数据
     *
     * @param project 查询条件
     * @return 项目数据
     */
    @RequestMapping("/queryRecycle")
    public Response<Project> queryRecycle(@RequestBody Project project) {
        return null;
    }

    /**
     * 项目添加到回收站 （逻辑删除）
     *
     * @param projectId 项目id
     * @return 结果
     */
    @DeleteMapping("/addRecycle")
    public Response<String> addRecycle(@RequestParam(name = "projectId") String projectId) {
        return null;
    }

    /**
     * 从回收站中恢复
     *
     * @param projectId 项目id
     * @return 结果
     */
    @RequestMapping("/recover")
    public Response<String> recover(@RequestParam(name = "projectId") String projectId) {
        return null;
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
