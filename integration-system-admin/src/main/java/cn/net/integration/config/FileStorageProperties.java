package cn.net.integration.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @ClassName FileStorageProperties
 * @Description 文件存储属性
 * @Author ycl
 * @Date 2024/8/7 上午10:06
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @PostConstruct
    public void init() {
        File file = new File(uploadPath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                System.err.println("创建文件夹失败，文件夹为：" + uploadPath);
            }
        }
    }
}
