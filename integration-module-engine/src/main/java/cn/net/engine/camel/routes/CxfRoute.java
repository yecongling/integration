package cn.net.engine.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

/**
 * @ClassName CxfRoute
 * @Description cxf的camel路由
 * @Author 叶丛林
 * @Date 2024/7/25 21:33
 * @Version 1.0
 **/
public class CxfRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("cxf:/DynamicService?serviceClass=cn.net.engine.camel.config.DynamicServiceGenerator$DynamicService")
                .process(this::processResult);
    }

    /**
     * 处理结果
     * @param exchange
     */
    private void processResult(Exchange exchange) {
        String methodName = exchange.getIn().getHeader("methodName", String.class);
        Object[] params = exchange.getIn().getBody(Object[].class);
        System.out.println("方法名：" + methodName);
        System.out.println("参数列表" + params);
    }
}
