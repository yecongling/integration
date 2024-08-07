package cn.net.integration.controller;

import cn.net.base.core.Response;
import cn.net.integration.config.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName FileUploadController
 * @Description 统一的文件上传controller(需要修改，不能作为上传接口，因为需要业务上还需要一些上传的信息，如文件名，大小，类型等)
 * @Author ycl
 * @Date 2024/8/7 上午10:15
 * @Version 1.0
 */
@RestController
@RequestMapping("/files")
public class FileUploadController {

    private FileStorageProperties properties;
    @Autowired
    public FileUploadController(FileStorageProperties properties) {
        this.properties = properties;
    }

    @PostMapping("/upload")
    public Response<Object> handleFileUpload(@RequestParam("file") MultipartFile file) {
        Path path = Paths.get(properties.getUploadPath(), file.getOriginalFilename());
        long size = file.getSize();
        return null;
    }
}
