package cn.net.integration.modules.engine.core;

import cn.net.integration.modules.engine.route.BaseRouteImpl;
import com.alibaba.fastjson.JSONObject;
import org.apache.camel.CamelContext;
import org.apache.camel.spi.RouteController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName EngineServiceCenter
 * @Description 引擎服务发布调用中心
 * @Author ycl
 * @Date 2022/12/10 10:50
 * @Version 1.0
 */
@Component
public class EngineServiceCenter implements BeanFactoryAware {

    /**
     * 注入camel运行的上下文环境，发布项目时，向该环境中添加运行路由
     */
    private CamelContext context;

    @Autowired
    public void setContext(CamelContext context) {
        this.context = context;
    }

    /**
     * bean工厂（用于动态注册bean，如：cxfEndpoint）
     */
    private DefaultListableBeanFactory beanFactory;

    /**
     * Callback that supplies the owning factory to a bean instance.
     * <p>Invoked after the population of normal bean properties
     * but before an initialization callback such as
     * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     *                    The bean can immediately call methods on the factory.
     * @throws BeansException in case of initialization errors
     * @see BeanInitializationException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    /**
     * 服务发布
     *
     * @param projectId 项目ID
     * @return 服务发布结果
     */
    public JSONObject publishService(String projectId) {
        // 需要修改（不能通过项目ID决定路由的名称，因为一个项目中可能包含多个路由，都需要已入口终端的名作为唯一值才行）
        BaseRouteImpl baseRoute = new BaseRouteImpl(projectId);

        JSONObject result = new JSONObject();
        boolean success = true;
        String msg = "服务发布成功";
        try {
            context.addRoutes(baseRoute);
        } catch (Exception e) {
            msg = "服务发布失败，原因：" + e.getMessage();
            success = false;
        }
        result.put("success", success);
        result.put("msg", msg);
        return result;
    }

    /**
     * 关闭服务
     *
     * @param projectId 项目ID
     * @return 关闭结果
     */
    public JSONObject closeService(String projectId) {
        JSONObject result = new JSONObject();
        // 获取路由生命周期控制器
        RouteController routeController = context.getRouteController();
        boolean success = true;
        String msg = "服务关闭成功";
        try {
            routeController.stopRoute("路由ID");
            // 针对其他类型的服务要考虑是否做bean的卸载工作

        } catch (Exception e) {
            success = false;
            msg = "关闭发布失败，原因：" + e.getMessage();
        }
        result.put("success", success);
        result.put("msg", msg);
        return result;
    }

    /**
     * 发布webservice（根据项目ID，查询其包含的soap终端（使用的资源、发布地址、服务名等））
     *
     * @param projectId 项目ID
     */
    private void publishWebService(String projectId) {

    }
}
