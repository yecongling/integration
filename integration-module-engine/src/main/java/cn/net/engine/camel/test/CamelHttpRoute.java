package cn.net.engine.camel.test;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CamelHttpRoute
 * @Description 测试undertow
 * @Author ycl
 * @Date 2024/5/15 下午2:02
 * @Version 1.0
 */
@Configuration
public class CamelHttpRoute {


    @Bean
    public RouteBuilder httpRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("jetty:http://localhost:8081/myEndpoint")
                        .to("log:httpRequest")
                        .process(exchange -> {
                            // 处理 HTTP 请求逻辑
                            String body = exchange.getIn().getBody(String.class);
                            // 进行业务处理
                            String response = "Response to HTTP request: " + body;
                            // 设置响应
                            exchange.getMessage().setBody(response);
                        });
            }
        };
    }

}
