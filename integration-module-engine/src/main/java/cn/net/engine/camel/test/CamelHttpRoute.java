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
//                from("file-watch:/home/ycl/jt_work/camel-test")
//                        .log("File event: ${header.CamelFileEventType} occurred on file ${header.CamelFileName} at ${header.CamelFileLastModified}");
            }
        };
    }

}
