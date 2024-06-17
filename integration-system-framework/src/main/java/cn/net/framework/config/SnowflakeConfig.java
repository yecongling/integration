package cn.net.framework.config;

import cn.net.base.bean.SnowFlakeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SnowflakeConfig
 * @Description 雪花算法配置bean
 * @Author ycl
 * @Date 2024/6/17 上午10:13
 * @Version 1.0
 */
@Configuration
public class SnowflakeConfig {

    @Bean
    public SnowFlakeGenerator snowFlakeGenerator() {
        long workerId = 1L;
        long datacenterId = 1L;
        return new SnowFlakeGenerator(workerId, datacenterId);
    }
}
