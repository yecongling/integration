package cn.net.engine.camel.routes;

import cn.net.engine.bean.project.Router;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

/**
 * @ClassName BaseRouteImpl
 * @Description 基础路由实现（用于构建对应的路由执行流程）
 * @Author ycl
 * @Date 2024/5/15 上午10:12
 * @Version 1.0
 */
public class BaseRouteImpl extends RouteBuilder {

    // 路由
    private final Router router;
    public BaseRouteImpl(Router router) {
        this.router = router;
    }

    /**
     * 根据路由配置生成相应的路由
     * @throws Exception 异常
     */
    @Override
    public void configure() throws Exception {
        // 需要从projectService中获取路由的调用开头的名称作为路由的id
        RouteDefinition from = from(router.getRouterUrl());
        // 设置路由id(projectID_entryID)
        from.routeId(router.getRouterId());
        // 后续就是调用各种处理器、消息系统（消息转换、过滤、分发等）、消息路由（可参考@href="https://camel.apache.org/components/4.4.x/eips/enterprise-integration-patterns.html#_message_routing"）
    }
}
