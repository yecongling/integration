package cn.net.engine.camel.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicServiceGenerator
 * @Description 动态服务生成，利用java的反射和动态代理的机制生成接口
 * @Author 叶丛林
 * @Date 2024/7/25 21:17
 * @Version 1.0
 **/
public class DynamicServiceGenerator {

    /**
     * 创建代理对象
     *
     * @param serviceInterface 服务接口
     * @param handler          处理类型
     * @return 返回代理的对象
     */
    public static Object createProxy(Class<?> serviceInterface, InvocationHandler handler) {
        return Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface}, handler);
    }


    /**
     * 动态服务的接口
     */
    public interface DynamicService {
        /**
         * 定义一个通用的方法来接收所有参数
         *
         * @param methodName 方法名
         * @param args       参数
         * @return 结果
         * @throws Exception 异常
         */
        Object invoke(String methodName, Object[] args) throws Exception;
    }
}
