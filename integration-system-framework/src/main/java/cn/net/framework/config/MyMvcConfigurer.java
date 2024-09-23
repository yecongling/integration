package cn.net.framework.config;

import cn.net.framework.interceptor.LoginInterceptor;
import cn.net.framework.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 配置拦截器，用于判定用户是否登录了，未登录的用户不能进行后台资源的访问
 */
@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {

    // redis操作的工具类
    private RedisUtil redisUtil;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 添加拦截器
     *
     * @param registry 拦截器注册中心
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(redisUtil))
                .addPathPatterns("/**")  // 拦截所有请求
                .excludePathPatterns("/login", "/logout"); // 排除不拦截的路径
    }

    /**
     * 添加参数解析器
     * @param resolvers 解析器集合
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserArgResolver(redisUtil));
    }
}
