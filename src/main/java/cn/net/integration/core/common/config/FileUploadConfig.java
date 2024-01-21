package cn.net.integration.core.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName FileUploadConfig
 * @Description 文件上传配置类
 * @Author yeconglin
 * @Date 2024/1/21 23:18
 * @Version 1.0
 */
@Configuration
public class FileUploadConfig implements WebMvcConfigurer {

    @Value("${my.upload.path}")
    private String path;


    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param registry
     * @see ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String staticMapping = "/upload/**";
        String localDirectory = "file:" + path;
        registry.addResourceHandler(staticMapping).addResourceLocations(localDirectory);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
