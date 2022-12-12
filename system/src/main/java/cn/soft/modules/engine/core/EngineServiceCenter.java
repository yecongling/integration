package cn.soft.modules.engine.core;

import cn.soft.modules.engine.route.BaseRouteImpl;
import com.alibaba.fastjson.JSONObject;
import org.apache.camel.CamelContext;
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
     * bean工厂
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
     * @param status 状态 是发布服务还是取消  还是半启动
     * @return 服务发布结果
     */
    public JSONObject publishService(String projectId, int status) {
        BaseRouteImpl baseRoute = new BaseRouteImpl(projectId);
        JSONObject result = new JSONObject();
        boolean success = true;
        String msg = "";
        try {
            // 提示消息需要改  ？？？？
            context.addRoutes(baseRoute);
            msg = "服务发布成功!";
        } catch (Exception e) {
            msg = "服务发布失败，原因：" + e.getMessage();
            success = false;
        }
        result.put("success", success);
        result.put("msg", msg);
        return result;
    }
}
