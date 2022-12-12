package cn.soft.modules.engine.service.impl;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.engine.core.EngineServiceCenter;
import cn.soft.modules.base.service.impl.BaseCommonServiceImpl;
import cn.soft.modules.engine.entity.project.EndpointProperties;
import cn.soft.modules.engine.entity.project.ProjectModel;
import cn.soft.modules.engine.entity.project.Route;
import cn.soft.modules.engine.mapper.ProjectManagerMapper;
import cn.soft.modules.engine.service.ProjectManagerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProjectManagerServiceImpl
 * @Description 项目管理服务实现类
 * @Author 叶丛林
 * @Date 2022/10/20 12:57
 * @Version 1.0
 **/
@Service
public class ProjectManagerServiceImpl extends BaseCommonServiceImpl implements ProjectManagerService {

    /* 注入项目管理mapper */
    private ProjectManagerMapper projectManagerMapper;

    @Autowired
    public void setProjectManagerMapper(ProjectManagerMapper projectManagerMapper) {
        this.projectManagerMapper = projectManagerMapper;
    }

    private EngineServiceCenter engineServiceCenter;
    @Autowired
    public void setEngineServiceCenter(EngineServiceCenter engineServiceCenter) {
        this.engineServiceCenter = engineServiceCenter;
    }

    /**
     * 查询所有项目信息
     *
     * @param param 项目查询条件
     * @return 所有项目信息
     */
    @Override
    public Result<List<ProjectModel>> queryProjects(JSONObject param) {
        List<ProjectModel> allProject = projectManagerMapper.queryAllProject(param);
        return Result.ok(allProject);
    }

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    @Override
    public Result<ProjectModel> queryProjectById(String projectId) {
        ProjectModel projectModel = projectManagerMapper.queryProjectInfoByID(projectId);
        // 后续添加查询其对应的终端、路由组件、连线等数据

        return Result.ok(projectModel);
    }

    /**
     * 新增服务信息
     *
     * @param projectModel 项目对象
     * @return 保存结果
     */
    @Override
    public Result<JSONObject> addProject(ProjectModel projectModel) {
        return null;
    }

    /**
     * 修改项目信息
     *
     * @param projectModel 项目对象
     * @return 修改结果
     */
    @Override
    public Result<JSONObject> updateProject(ProjectModel projectModel) {
        return null;
    }

    /**
     * 发布服务
     *
     * @param projectId 项目编号
     * @return 发布的结果
     */
    @Override
    public Result<JSONObject> publishService(String projectId, Integer status) {
        JSONObject result = engineServiceCenter.publishService(projectId, status);
        // 根据服务发布的结果对表中的数据标识（如发布状态、运行状态、异常信息等）
        if (result.getBoolean("success")) {
            // 修改表中配置，改动发布状态
            System.out.println();
        }
        return null;
    }

    /**
     * 查询终端属性配置
     *
     * @return 返回终端的属性配置
     */
    @Override
    public Result<List<EndpointProperties>> queryEndpointProperties() {
        JSONObject param = new JSONObject();
        List<EndpointProperties> properties = projectManagerMapper.queryEndpointProperties(param);
        return Result.OK(properties);
    }

    /**
     * 查询路由
     *
     * @param routeIds 需要查询的路由ID
     * @return 返回多个路由信息
     */
    @Override
    public List<Route> queryRoutes(List<String> routeIds) {
        List<Route> routes = projectManagerMapper.queryRoutes(routeIds);
        // 仅仅是为了返回（后续需要更改的）
        if (routes.isEmpty()) {
            return new ArrayList<>();
        }
        return routes;
    }
}
