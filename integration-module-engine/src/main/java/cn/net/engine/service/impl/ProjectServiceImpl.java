package cn.net.engine.service.impl;

import cn.net.base.bean.SnowFlakeGenerator;
import cn.net.base.bean.SysOpr;
import cn.net.engine.bean.project.Project;
import cn.net.engine.bean.project.Router;
import cn.net.engine.camel.core.EngineServiceCenter;
import cn.net.engine.camel.routes.BaseRouteImpl;
import cn.net.engine.mapper.ProjectDesignMapper;
import cn.net.engine.service.IProjectService;
import cn.net.framework.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName ProjectDesignServiceImpl
 * @Description 项目设计实现类
 * @Author ycl
 * @Date 2024/5/9 上午9:24
 * @Version 1.0
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    // 注入项目设计mapper
    private ProjectDesignMapper projectDesignMapper;
    // 注入servlet工具
    private ServletUtils servletUtils;
    // 注入引擎服务中心
    private EngineServiceCenter engineServiceCenter;
    // 生成唯一id的雪花算法
    private SnowFlakeGenerator snowFlakeGenerator;

    @Autowired
    public void setProjectDesignMapper(ProjectDesignMapper projectDesignMapper) {
        this.projectDesignMapper = projectDesignMapper;
    }

    @Autowired
    public void setServletUtils(ServletUtils servletUtils) {
        this.servletUtils = servletUtils;
    }

    @Autowired
    public void setEngineServiceCenter(EngineServiceCenter engineServiceCenter) {
        this.engineServiceCenter = engineServiceCenter;
    }

    @Autowired
    public void setSnowFlakeGenerator(SnowFlakeGenerator snowFlakeGenerator) {
        this.snowFlakeGenerator = snowFlakeGenerator;
    }

    /**
     * 查询所有项目信息
     *
     * @param param 项目查询条件
     * @return 所有项目信息
     */
    @Override
    public List<Project> getProjects(Project param) {
        return projectDesignMapper.getAllProjects(param);
    }

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    @Override
    public Project getProjectById(String projectId) {
        return projectDesignMapper.queryProjectInfoByID(projectId);
    }

    /**
     * 新增服务信息
     *
     * @param project 项目对象
     * @return 保存结果
     */
    @Override
    public boolean addProject(Project project) {
        // 获取操作员
        SysOpr sysOpr = servletUtils.getSysOpr();
        // 设置主键
        project.setId(snowFlakeGenerator.generateUniqueId());
        // 设置操作人、操作时间
        project.setCreateBy(sysOpr.getUserName());
        project.setUpdateBy(sysOpr.getUserName());
        project.setCreateTime(new Date());
        project.setUpdateTime(new Date());
        // 项目的状态默认为0，就是未启动状态
        project.setStatus(0);
        // 默认为未删除状态
        project.setDelFlag(0);
        return projectDesignMapper.addProject(project) > 0;
    }

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    @Override
    public boolean updateProject(Project project) {
        // 获取操作员
        SysOpr sysOpr = servletUtils.getSysOpr();
        // 设置操作人、操作时间
        project.setUpdateBy(sysOpr.getUserName());
        project.setUpdateTime(new Date());
        return projectDesignMapper.updateProject(project) > 0;
    }

    /**
     * 删除菜单
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @Override
    public boolean deleteProject(String projectId) {
        return projectDesignMapper.deleteProject(projectId);
    }

    /**
     * 改变服务状态 例如服务发布、取消发布
     *
     * @param project 服务信息
     * @return 返回改变后的状态 成功 - 失败（带异常信息）
     */
    @Override
    public Object changeServiceStatus(Project project) {
        List<Object> result = new ArrayList<>();
        // 判断是发布还是取消
        // 如果是发布
        // 查询执行流程
        // 构建执行路由(一个项目里面可能多个执行路由)
        List<Router> routers = this.buildRouterProcess(project.getId());
        // 各个路由发布不能相互影响
        for (Router router : routers) {
            // 发布的结果
            Map<String, Object> param = new HashMap<>();
            try {
                BaseRouteImpl baseRoute = new BaseRouteImpl(router);
                // 调用服务发布
                Object r = engineServiceCenter.publishService(baseRoute);
                param.put(router.getRouterId(), r);
            } catch (Exception e) {
                System.out.println("发布失败，原因：" + e.getMessage());
                param.put(router.getRouterId(), e.getMessage());
            }
            result.add(param);
        }
        return result;
    }

    /**
     * 查询路由的执行流程数据
     *
     * @param projectId 项目id
     * @return 流程数据
     */
    @Override
    public List<Router> buildRouterProcess(String projectId) {

        return null;
    }
}
