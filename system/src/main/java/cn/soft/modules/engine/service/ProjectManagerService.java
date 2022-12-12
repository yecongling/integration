package cn.soft.modules.engine.service;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.engine.entity.project.EndpointProperties;
import cn.soft.modules.engine.entity.project.ProjectModel;
import cn.soft.modules.engine.entity.project.Route;
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
     * @param param 项目查询条件
     * @return 所有项目信息
     */
    Result<List<ProjectModel>> queryProjects(JSONObject param);

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    Result<ProjectModel> queryProjectById(String projectId);

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
     * @param status 状态 是发布服务还是取消  还是半启动
     * @return 发布服务结果
     */
    Result<JSONObject> publishService(String projectId, Integer status);

    /**
     * 查询终端属性配置
     *
     * @return 返回终端的属性配置
     */
    Result<List<EndpointProperties>> queryEndpointProperties();

    /**
     * 查询路由
     *
     * @param routeIds 需要查询的路由ID
     * @return 返回多个路由信息
     */
    List<Route> queryRoutes(List<String> routeIds);


}
