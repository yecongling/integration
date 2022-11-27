package cn.soft.modules.test.router;

import cn.soft.modules.test.processors.GroovyProcessor;
import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.language.groovy.GroovyLanguage.groovy;

/**
 * @ClassName HisServiceRouter
 * @Description 路由构建器
 * @Author ycl
 * @Date 2022/11/23 14:08
 * @Version 1.0
 */
public class HisServiceRouter extends RouteBuilder {

    /* 路由ID 标识整个流程的ID */
    private final String routeId;

    // 构造器
    public HisServiceRouter(String routeId) {
        this.routeId = routeId;
    }

    /**
     * @throws Exception -
     */
    @Override
    public void configure() throws Exception {
        from("cxf:bean:cxfEndpoint").routeId(routeId).filter(groovy("println \"123\";return true;")).process(new GroovyProcessor()).log("路由执行成功");
    }
}
