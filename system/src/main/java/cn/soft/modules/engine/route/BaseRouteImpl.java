package cn.soft.modules.engine.route;

import cn.soft.common.util.SpringContextUtils;
import cn.soft.engine.core.routes.BaseRoute;
import cn.soft.modules.engine.mapper.ProjectManagerMapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseRouteImpl
 * @Description 基础路由的实现（通过传入项目ID，去查询对应的配置信息，决定路由配置）
 * @Author ycl
 * @Date 2022/11/30 10:52
 * @Version 1.0
 */
public class BaseRouteImpl extends BaseRoute {

    public BaseRouteImpl(String routeId) {
        this.routerID = routeId;
    }

    /**
     * 路由流程配置
     *
     * @throws Exception can be thrown during configuration
     */
    @Override
    public void configure() throws Exception {
        ProjectManagerMapper projectManagerMapper = SpringContextUtils.getBean(ProjectManagerMapper.class);
        // 根据路由ID查询出整个流程的执行顺序数据
        List<Map<String, Object>> routes = projectManagerMapper.queryRoute(routerID);

    }
}
