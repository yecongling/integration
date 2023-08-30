package cn.soft.modules.engine.controller;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.engine.entity.project.EndpointProperties;
import cn.soft.modules.engine.entity.project.Project;
import cn.soft.modules.engine.entity.project.Route;
import cn.soft.modules.engine.service.IProjectManagerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProjectManagerController
 * @Description 项目管理controller
 * @Author 叶丛林
 * @Date 2022/10/20 12:53
 * @Version 1.0
 **/
@RestController
@RequestMapping("/engine/project")
public class ProjectManagerController {

    /* 注入项目管理service */
    private IProjectManagerService projectManagerService;

    @Autowired
    public void setProjectManagerService(IProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    /**
     * 查询所有项目信息
     *
     * @param param 检索条件
     * @return 所有的项目信息
     */
    @RequestMapping("/queryProjects")
    public Result<List<Project>> queryProject(@RequestBody(required = false) JSONObject param) {
        return projectManagerService.queryProjects(param);
    }

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    @GetMapping("/queryProjectById/{projectId}")
    public Result<Project> queryProjectById(@PathVariable("projectId") String projectId) {
        return projectManagerService.queryProjectById(projectId);
    }

    /**
     * 新增项目信息
     *
     * @param project 封装的项目对象
     * @return 返回保存结果
     */
    @PostMapping("/addProject")
    public Result<String> addProject(@RequestBody Project project) {
        return projectManagerService.addProject(project);
    }

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    @PostMapping("/updateProject")
    public Result<Object> updateProject(@RequestBody Project project) {
        return projectManagerService.updateProject(project);
    }

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @DeleteMapping("/deleteProject")
    public Result<Object> deleteProject(@RequestParam(name = "projectId", required = true) String projectId) {
        return projectManagerService.deleteProject(projectId);
    }

    /**
     * （取消）发布服务
     *
     * @param projectID 服务ID
     * @param status    状态 是发布服务还是取消  还是半启动
     * @return 发布结果
     */
    @GetMapping("/publishService/")
    public Result<JSONObject> publishService(@RequestParam("projectID") String projectID, @RequestParam("status") Integer status) {
        // 需要添加状态参数
        return projectManagerService.publishService(projectID, status);
    }

    /**
     * 查询终端的属性配置
     *
     * @return 终端属性配置
     */
    @GetMapping("/endpointProperties")
    public Result<List<EndpointProperties>> queryEndpointProperties() {
        return projectManagerService.queryEndpointProperties();
    }

    /**
     * 查询路由信息
     *
     * @return 返回路由信息
     */
    @RequestMapping("/queryRoutes")
    public Result<List<Route>> queryRoutes() {
        List<String> ids = new ArrayList<>();
        ids.add("route_123456");
        List<Route> routes = projectManagerService.queryRoutes(ids);
        return Result.ok(routes);
    }

}
