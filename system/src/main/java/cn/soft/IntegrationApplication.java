package cn.soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class IntegrationApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IntegrationApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("一个输出");
        SpringApplication.run(IntegrationApplication.class, args);
    }
}
