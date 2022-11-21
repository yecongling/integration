package cn.soft.system.project.service.impl;

import cn.soft.system.project.mapper.ProjectManagerMapper;
import cn.soft.system.project.entity.ProjectModel;
import cn.soft.system.project.service.ProjectManagerService;
import cn.soft.common.api.vo.Result;
import com.alibaba.fastjson.JSONObject;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectManagerServiceImpl
 * @Description 项目管理服务实现类
 * @Author 叶丛林
 * @Date 2022/10/20 12:57
 * @Version 1.0
 **/
@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {

    /**
     * 注入camel运行的上下文环境，发布项目时，向该环境中添加运行路由
     */
    private CamelContext context;

    @Autowired
    public void setContext(CamelContext context) {
        this.context = context;
    }

    /* 注入项目管理mapper */
    private ProjectManagerMapper projectManagerMapper;

    @Autowired
    public void setProjectManagerMapper(ProjectManagerMapper projectManagerMapper) {
        this.projectManagerMapper = projectManagerMapper;
    }

    /**
     * 查询所有项目信息
     *
     * @param projectModel 项目查询条件
     * @return 所有项目信息
     */
    @Override
    public Result<ProjectModel> queryProjects(ProjectModel projectModel) {
        return null;
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
    public Result<JSONObject> publishService(String projectId) {
        return null;
    }

}
