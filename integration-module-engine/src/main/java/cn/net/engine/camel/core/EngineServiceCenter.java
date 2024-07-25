package cn.net.engine.camel.core;

import cn.net.engine.camel.endpoint.CxfEndpointFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.spi.RouteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName EngineServiceCenter
 * @Description 引擎服务发布调度中心
 * @Author ycl
 * @Date 2024/5/15 上午10:23
 * @Version 1.0
 */
@Component
public class EngineServiceCenter {

    // 注入camel运行的上下文环境，发布项目时像该环境中添加路由 取消发布时，从该服务中移除路由
    private final CamelContext camelContext;

    @Autowired
    public EngineServiceCenter(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    /**
     * 发布webservice 服务
     */
    public void publishWebservice() throws Exception {
        Endpoint endpoint = CxfEndpointFactory.createEndpoint();
        camelContext.addEndpoint("cxfEndpoint", endpoint);
    }

    /**
     * 发布服务
     *
     * @param routesBuilder 构建的路由结构
     * @return 发布的结果
     */
    public Object publishService(RoutesBuilder routesBuilder) {
        try {
            publishWebservice();

            camelContext.addRoutes(routesBuilder);
        } catch (Exception e) {
            System.out.println("服务发布失败，原因：" + e.getMessage());
        }
        return null;
    }

    /**
     * 关闭服务
     *
     * @param routeId 路由id
     * @return 关闭的结果
     */
    public Object closeService(String routeId) {
        // 获取路由的生命周期控制器
        RouteController routeController = camelContext.getRouteController();
        // 关闭路由
        try {
            // @TODO 这里需要考虑一下是停止路由的好还是暂停路由的好（暂停的情况下恢复起来会更快）,但是一般情况都是需要改路由配置才会暂停
            routeController.stopRoute(routeId);
//            routeController.suspendRoute(routeId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
