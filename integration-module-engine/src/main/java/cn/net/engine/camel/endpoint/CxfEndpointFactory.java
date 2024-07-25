package cn.net.engine.camel.endpoint;

import cn.net.engine.camel.config.DynamicServiceGenerator;
import org.apache.camel.Endpoint;
import org.apache.camel.component.cxf.jaxws.CxfEndpoint;

/**
 * @ClassName CxfEndpointFactory
 * @Description 生产cxf端点的工厂
 * @Author 叶丛林
 * @Date 2024/7/25 21:37
 * @Version 1.0
 **/
public class CxfEndpointFactory {

    /**
     * 创建端点
     * @return
     */
    public static Endpoint createEndpoint() {
        Object object = DynamicServiceGenerator.createProxy(DynamicServiceGenerator.DynamicService.class, ((proxy, method, args) -> "执行结果"));
        CxfEndpoint endpoint = new CxfEndpoint();
        endpoint.setBeanId("cxfEndpoint");
        endpoint.setServiceClass(DynamicServiceGenerator.DynamicService.class);
        endpoint.setAddress(object.getClass().getName());
        return endpoint;
    }

}
