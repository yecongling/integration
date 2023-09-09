package cn.net.integration.engine.study.springboot.router;

import cn.net.integration.engine.study.springboot.processor.SpringbootProcessor;
import org.apache.camel.builder.RouteBuilder;
import cn.net.integration.engine.study.bean.TestBean;

/**
 * 模拟springboot下使用的路由
 *
 */
public class SpringbootRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{myPeriod}}&repeatCount=1").routeId("hello")
                // and call the bean
                .bean(TestBean::new, "saySomething")
                .process(new SpringbootProcessor())
                // and print it to system out via stream component
                .to("stream:out");
    }
}
