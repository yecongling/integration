package cn.net.engine.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @ClassName GroovyProcessor
 * @Description groovy 脚本的处理器
 * @Author ycl
 * @Date 2024/5/15 上午10:16
 * @Version 1.0
 */
public class GroovyProcessor implements Processor {
    /**
     * Processes the message exchange
     *
     * @param exchange the message exchange
     * @throws Exception if an internal processing error has occurred.
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("groovy processor");
    }
}
