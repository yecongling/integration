package cn.net.integration.engine.study.springboot.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * 模拟springboot下使用的处理器
 *
 */
public class SpringbootProcessor implements Processor {
    /**
     * Processes the message exchange
     *
     * @param exchange the message exchange
     * @throws Exception if an internal processing error has occurred.
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange);
        System.out.println(exchange.getIn().getBody());
        // 改掉body内容

    }
}
