package cn.soft.modules.engine.service;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.engine.entity.project.EndpointProperties;
import cn.soft.modules.engine.entity.project.ProjectModel;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @TODO 项目管理service接口
 * @Author ycl
 * @Date 2022/10/20 12:57
 * @Version 1.0
 */
public interface ProjectManagerService {

    /**
     * 查询所有项目信息
     *
     * @param projectModel 项目查询条件
     * @return 所有项目信息
     */
    Result<ProjectModel> queryProjects(ProjectModel projectModel);

    /**
     * 新增服务信息
     *
     * @param projectModel 项目对象
     * @return 保存结果
     */
    Result<JSONObject> addProject(ProjectModel projectModel);

    /**
     * 修改项目信息
     *
     * @param projectModel 项目对象
     * @return 修改结果
     */
    Result<JSONObject> updateProject(ProjectModel projectModel);

    /**
     * 根据项目ID查找项目信息 并发布该服务
     *
     * @param projectId 项目ID
     * @return 发布服务结果
     */
    Result<JSONObject> publishService(String projectId);

    /**
     * 查询终端属性配置
     *
     * @return 返回终端的属性配置
     */
    Result<List<EndpointProperties>> queryEndpointProperties();
}
