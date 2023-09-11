package cn.net.integration.modules.test.controller;

import cn.net.integration.modules.test.router.HisServiceRouter;
import org.apache.camel.CamelContext;
import org.apache.camel.spi.RouteController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HisPushServiceController
 * @Description TODO
 * @Author ycl
 * @Date 2022/11/23 15:41
 * @Version 1.0
 */
@RestController
public class HisPushServiceController implements BeanFactoryAware {

    private CamelContext camelContext;

    @Autowired
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    /**
     * bean工厂
     */
    private DefaultListableBeanFactory beanFactory;

    @RequestMapping("/openService")
    public Object openService() throws Exception {
//        CxfEndpoint cxfEndpoint = new CxfEndpoint();
//        cxfEndpoint.setBeanId("cxfEndpoint");
//        cxfEndpoint.setServiceClass(HisPushService.class);
//        cxfEndpoint.setAddress("http://localhost:8081/ig/hisservice");
//        // 注册bean
//        beanFactory.registerSingleton("cxfEndpoint", cxfEndpoint);
//        camelContext.addEndpoint("cxfEndpoint", cxfEndpoint);

        // 开启路由
//        camelContext.addRoutes(new SoapRoute("cxfEndpoint", "soap"));


        camelContext.addRoutes(new HisServiceRouter("HisPushService"));

        return "成功开启路由";
    }

    @RequestMapping("/closeService")
    public Object closeService() throws Exception {
        RouteController routeController = camelContext.getRouteController();
        routeController.stopRoute("HisPushService");
        // 卸载
//        beanFactory.destroySingleton("cxfEndpoint");
        return "关闭路由成功，并卸载了web service";
    }



    /**
     * @param beanFactory
     * @throws BeansException
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
}
