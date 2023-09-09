package cn.net.integration.engine.study.cxf.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * CXF处理器
 */
public class CxfProcessor implements Processor {

    /**
     * @param exchange 封装的传输对象
     * @throws Exception -
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("传输对象是：" + exchange);
        System.out.println("输入的消息体是：" + exchange.getIn().getBody());
    }
}
