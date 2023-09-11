package cn.net.integration.modules.test.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @ClassName GroovyProcessor
 * @Description groovy脚本处理器
 * @Author ycl
 * @Date 2022/11/23 14:28
 * @Version 1.0
 */
public class GroovyProcessor implements Processor {

    /**
     * Processes the message exchange
     *
     * @param exchange the message exchange
     * @throws Exception if an internal processing error has occurred.
     */
    public void process(Exchange exchange) throws Exception {
        System.out.println("这里是groovy处理器");
        exchange.getMessage().setBody("这是返回内容");
    }
}
