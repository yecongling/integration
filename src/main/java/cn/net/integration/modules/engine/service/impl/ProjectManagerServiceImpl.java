package cn.net.integration.modules.engine.service.impl;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.core.common.util.UUIDUtil;
import cn.net.integration.modules.engine.core.EngineServiceCenter;
import cn.net.integration.modules.engine.entity.project.Project;
import cn.net.integration.modules.engine.mapper.ProjectManagerMapper;
import cn.net.integration.modules.engine.service.IProjectManagerService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ProjectManagerServiceImpl extends ServiceImpl<ProjectManagerMapper, Project> implements IProjectManagerService {

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
    public Response<List<Project>> queryProjects(JSONObject param) {
        List<Project> allProject = projectManagerMapper.queryAllProject(param);
        for (Project model : allProject) {
            model.setKey(model.getId());
        }
        return Response.success(allProject);
    }

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    @Override
    public Response<Project> queryProjectById(String projectId) {
        Project project = projectManagerMapper.queryProjectInfoByID(projectId);
        // 后续添加查询其对应的终端、路由组件、连线等数据

        return Response.success(project);
    }

    /**
     * 新增服务信息
     *
     * @param project 项目对象
     * @return 保存结果
     */
    @Override
    public Response<String> addProject(Project project) {
        // 新增，添加创建、更新时间、操作员
        project.setCreateTime(new Date());
        project.setCreateBy("ycl");
        project.setUpdateBy("ycl");
        project.setUpdateTime(new Date());
        project.setId(UUIDUtil.getUniqueId());
        int i = projectManagerMapper.addProject(project);
        if (i > 0) {
            return Response.success("新增项目成功");
        }
        return Response.error("新增项目失败");
    }

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    @Override
    public Response<Object> updateProject(Project project) {
        project.setUpdateBy("admin");
        project.setUpdateTime(new Date());
        int i = projectManagerMapper.updateProject(project);
        if (i > 0) {
            return Response.success("修改项目成功");
        }
        return Response.error("修改项目失败");
    }

    /**
     * 删除菜单
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @Override
    public Response<Object> deleteProject(String projectId) {
        boolean b = projectManagerMapper.deleteProject(projectId);
        if (b) {
            return Response.success("删除成功");
        }
        return Response.error("删除失败");
    }

    /**
     * 发布服务
     *
     * @param projectId 项目编号
     * @return 发布的结果
     */
    @Override
    public Response<JSONObject> publishService(String projectId, Integer status) {
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

}
