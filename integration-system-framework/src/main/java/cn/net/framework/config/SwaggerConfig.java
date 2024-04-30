package cn.net.framework.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SwaggerConfig
 * @Description 接口生成配置类
 * @Author ycl
 * @Date 2024/4/30 上午10:35
 * @Version 1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerOpenApi() {
        return new OpenAPI().info(
                new Info().title("集成信息管理平台")
                        .description("集成信息管理平台")
                        .version("1.0")
        ).externalDocs(new ExternalDocumentation()
                .description("设计文档")
                .url("https://github.com/yecongling/integration.git"));
    }
}
