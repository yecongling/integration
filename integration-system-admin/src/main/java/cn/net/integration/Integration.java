package cn.net.integration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.net"})
@MapperScan(basePackages = {"cn.net.**.mapper"})
public class Integration {

    public static void main(String[] args) {
        SpringApplication.run(Integration.class, args);
    }

}
