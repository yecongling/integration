package cn.soft.system.project.controller;

import cn.soft.system.project.entity.ProjectModel;
import cn.soft.system.project.service.ProjectManagerService;
import com.alibaba.fastjson.JSONPObject;
import com.soft.common.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @TODO 项目管理controller
 * @Author ycl
 * @Date 2022/10/20 12:53
 * @Version 1.0
 */
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
     * 新增项目信息
     *
     * @param projectModel 封装的项目对象
     * @return 返回保存结果
     */
    @RequestMapping("/addProject")
    public Result<Object> addProject(@RequestBody ProjectModel projectModel) {
        return projectManagerService.addProject(projectModel);
    }

    /**
     * 改变项目状态
     *
     * @param param 项目信息
     * @return 执行结果
     */
    @RequestMapping("/changeStatus")
    public Result<Object> changeStatus(@RequestBody JSONPObject param) {
        return null;
    }



    /**
     * 发布服务
     *
     * @param projectID 服务ID
     * @return 发布结果
     */
    @GetMapping("/publishService/{projectID}")
    public Result<Object> publishService(@PathVariable("projectID") String projectID) {
        return projectManagerService.publishService(projectID);
    }

}
