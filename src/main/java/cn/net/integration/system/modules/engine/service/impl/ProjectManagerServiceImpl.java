package cn.net.integration.system.modules.engine.service.impl;

import cn.net.integration.core.base.service.impl.BaseCommonServiceImpl;
import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.core.common.util.UUIDUtil;
import cn.net.integration.system.modules.engine.core.EngineServiceCenter;
import cn.net.integration.system.modules.engine.entity.project.EndpointProperties;
import cn.net.integration.system.modules.engine.entity.project.Project;
import cn.net.integration.system.modules.engine.entity.project.Route;
import cn.net.integration.system.modules.engine.mapper.ProjectManagerMapper;
import cn.net.integration.system.modules.engine.service.IProjectManagerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ProjectManagerServiceImpl
 * @Description 项目管理服务实现类
 * @Author 叶丛林
 * @Date 2022/10/20 12:57
 * @Version 1.0
 **/
@Service
public class ProjectManagerServiceImpl extends BaseCommonServiceImpl implements IProjectManagerService {

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
    public Result<List<Project>> queryProjects(JSONObject param) {
        List<Project> allProject = projectManagerMapper.queryAllProject(param);
        for (Project model : allProject) {
            model.setKey(model.getId());
        }
        return Result.ok(allProject);
    }

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    @Override
    public Result<Project> queryProjectById(String projectId) {
        Project project = projectManagerMapper.queryProjectInfoByID(projectId);
        // 后续添加查询其对应的终端、路由组件、连线等数据

        return Result.ok(project);
    }

    /**
     * 新增服务信息
     *
     * @param project 项目对象
     * @return 保存结果
     */
    @Override
    public Result<String> addProject(Project project) {
        // 新增，添加创建、更新时间、操作员
        project.setCreateTime(new Date());
        project.setCreateBy("ycl");
        project.setUpdateBy("ycl");
        project.setUpdateTime(new Date());
        project.setId(UUIDUtil.getUniqueId());
        int i = projectManagerMapper.addProject(project);
        if (i > 0) {
            return Result.ok("新增项目成功");
        }
        return Result.error("新增项目失败");
    }

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    @Override
    public Result<Object> updateProject(Project project) {
        project.setUpdateBy("admin");
        project.setUpdateTime(new Date());
        int i = projectManagerMapper.updateProject(project);
        if (i > 0) {
            return Result.ok("修改项目成功");
        }
        return Result.error("修改项目失败");
    }

    /**
     * 删除菜单
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @Override
    public Result<Object> deleteProject(String projectId) {
        boolean b = projectManagerMapper.deleteProject(projectId);
        if (b) {
            return Result.ok("删除成功");
        }
        return Result.error("删除失败");
    }

    /**
     * 发布服务
     *
     * @param projectId 项目编号
     * @return 发布的结果
     */
    @Override
    public Result<JSONObject> publishService(String projectId, Integer status) {
        JSONObject result;
        // 这里后续考虑更改，使用枚举或者自定义常量
        if (status == 1) {
            result = engineServiceCenter.publishService(projectId);
        } else {
            result = engineServiceCenter.closeService(projectId);
        }
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
