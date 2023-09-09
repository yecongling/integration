package cn.net.integration.engine.study.cxf.router;

import cn.net.integration.engine.study.cxf.processor.CxfProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * CXF路由构建器
 */
public class CxfRouter extends RouteBuilder {
    /**
     * <b>Called on initialization to build the routes using the fluent builder syntax.</b>
     * <p/>
     * This is a central method for RouteBuilder implementations to implement the routes using the Java fluent builder
     * syntax.
     *
     * @throws Exception can be thrown during configuration
     */
    @Override
    public void configure() throws Exception {
        from("cxf:bean:cxfEndpoint").routeId("cxfService").process(new CxfProcessor()).log("路由执行成功");
    }

}
