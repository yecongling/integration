package cn.soft.modules.engine.controller;

import cn.soft.modules.engine.entity.project.ProjectModel;
import cn.soft.modules.engine.service.ProjectManagerService;
import com.alibaba.fastjson.JSONObject;
import cn.soft.common.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ProjectManagerController
 * @Description 项目管理controller
 * @Author 叶丛林
 * @Date 2022/10/20 12:53
 * @Version 1.0
 **/
@RestController
@RequestMapping("/sys/project")
public class ProjectManagerController {

    /* 注入项目管理service */
    private ProjectManagerService projectManagerService;

    @Autowired
    public void setProjectManagerService(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    /**
     * 查询所有项目信息
     *
     * @param projectModel 项目信息
     * @return 所有的项目信息
     */
    @RequestMapping("/queryProjects")
    public Result<ProjectModel> queryProject(@RequestBody ProjectModel projectModel) {
        return projectManagerService.queryProjects(projectModel);
    }

    /**
     * 新增项目信息
     *
     * @param projectModel 封装的项目对象
     * @return 返回保存结果
     */
    @RequestMapping("/addProject")
    public Result<JSONObject> addProject(@RequestBody ProjectModel projectModel) {
        return projectManagerService.addProject(projectModel);
    }

    /**
     * 修改项目信息
     *
     * @param projectModel 项目对象
     * @return 修改结果
     */
    @RequestMapping("/updateProject")
    public Result<JSONObject> updateProject(@RequestBody ProjectModel projectModel) {
        return projectManagerService.updateProject(projectModel);
    }

    /**
     * （取消）发布服务
     *
     * @param projectID 服务ID
     * @return 发布结果
     */
    @GetMapping("/publishService/{projectID}")
    public Result<JSONObject> publishService(@PathVariable("projectID") String projectID) {
        return projectManagerService.publishService(projectID);
    }

}
