package cn.soft.modules.engine.route;

import cn.soft.common.util.SpringContextUtils;
import cn.soft.engine.core.routes.BaseRoute;
import cn.soft.modules.engine.mapper.ProjectManagerMapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SoapRoute
 * @Description 支持soap请求用的路由
 * @Author ycl
 * @Date 2022/11/30 10:52
 * @Version 1.0
 */
public class SoapRoute extends BaseRoute {

    public SoapRoute(String routeId, String protocol) {
        this.routerID = routeId;
        this.protocol = protocol;
    }

    /**
     *  soap路由流程配置
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
