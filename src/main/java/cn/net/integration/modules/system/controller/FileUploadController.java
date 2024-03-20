package cn.net.integration.modules.system.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileUploadController
 * @Description 文件上传controller 需要支持大小文件的上传，还要支持文件分片上传、断点续传等功能
 * @Author yeconglin
 * @Date 2024/1/3 15:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    /**
     * jar包上传
     *
     * @param file    文件对象
     * @param request 请求对象
     * @return 返回上传结果
     */
    @PostMapping(value = "jarFile", produces = "multipart/form-data")
    public Object upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
        return null;
    }
}
