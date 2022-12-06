package cn.soft.modules.engine.route;

import cn.soft.common.util.SpringContextUtils;
import cn.soft.engine.core.routes.BaseRoute;
import cn.soft.modules.engine.entity.project.ProjectModel;
import cn.soft.modules.engine.mapper.ProjectManagerMapper;

/**
 * @ClassName BaseRouteImpl
 * @Description 基础路由的实现（通过传入项目ID，去查询对应的配置信息，决定路由配置）
 * @Author ycl
 * @Date 2022/11/30 10:52
 * @Version 1.0
 */
public class BaseRouteImpl extends BaseRoute {

    public BaseRouteImpl(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 路由流程配置
     *
     * @throws Exception can be thrown during configuration
     */
    @Override
    public void configure() throws Exception {
        ProjectManagerMapper projectManagerMapper = SpringContextUtils.getBean(ProjectManagerMapper.class);
        // 根据项目ID查询出整个流程的执行顺序数据
        ProjectModel projectModel = projectManagerMapper.queryProjectInfoByID(projectId);

    }
}
