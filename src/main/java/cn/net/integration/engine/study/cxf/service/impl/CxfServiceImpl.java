package cn.net.integration.engine.study.cxf.service.impl;

import cn.net.integration.engine.study.cxf.router.CxfRouter;
import cn.net.integration.engine.study.cxf.service.CxfService;
import org.apache.camel.CamelContext;
import org.apache.camel.spi.RouteController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class CxfServiceImpl implements CxfService, BeanFactoryAware {

    private CamelContext camelContext;

    @Autowired
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    /**
     * bean工厂
     */
    private DefaultListableBeanFactory beanFactory;

    /**
     * 开启服务
     *
     * @return
     */
    @Override
    public String openService() throws Exception {
//        CxfEndpoint cxfEndpoint = new CxfEndpoint();
//        cxfEndpoint.setBeanId("cxfEndpoint");
//        cxfEndpoint.setServiceClass(WebService.class);
//        cxfEndpoint.setAddress("http://localhost:8081/ig/cxfService");
//        // 注册bean
//        beanFactory.registerSingleton("cxfEndpoint", cxfEndpoint);
//        camelContext.addEndpoint("cxfEndpoint", cxfEndpoint);
        // 开启路由
        camelContext.addRoutes(new CxfRouter());
        return "接口发布成功";
    }

    /**
     * 关闭服务
     *
     * @return
     */
    @Override
    public String closeService() throws Exception {
        RouteController routeController = camelContext.getRouteController();
        routeController.stopRoute("cxfService");
        return "接口取消发布成功";
    }

    /**
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
}
