package cn.net.integration.core.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SwaggerConfig
 * @Description swagger配置文件
 * @Author yeconglin
 * @Date 2024/1/10 14:00
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
