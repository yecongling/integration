package cn.net.integration.core.common.config;

/**
 * @ClassName SaTokenConfigure
 * @Description Sa-Tokenl路由拦截器
 * @Author yeconglin
 * @Date 2024/1/13 16:02
 * @Version 1.0
 */
/*@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    *//**
     * @param registry 拦截器
     *//*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册Sa-Token拦截器，校验规则为StpUtil.checkLogin()登录校验
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/sys/login");
    }
}*/
