package cn.soft.system.project.service.impl;

import cn.soft.system.project.mapper.ProjectManagerMapper;
import cn.soft.system.project.entity.ProjectModel;
import cn.soft.system.project.service.ProjectManagerService;
import com.soft.common.api.vo.Result;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @TODO 项目管理服务实现类
 * @Author ycl
 * @Date 2022/10/20 12:57
 * @Version 1.0
 */
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
     * 新增服务信息
     *
     * @param projectModel 项目对象
     * @return 保存结果
     */
    @Override
    public Result<Object> addProject(ProjectModel projectModel) {
        return null;
    }

    /**
     * 发布服务
     *
     * @param projectId 项目编号
     * @return 发布的结果
     */
    public Result<Object> publishService(String projectId) {
        return null;
    }

}
