package cn.net.integration.modules.engine.controller;

import cn.net.integration.modules.engine.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ResourceController
 * @Description 资源controller
 * @Author ycl
 * @Date 2022/11/25 12:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/engine/resource")
public class ResourceController {

    private IResourceService resourceService;

    @Autowired
    public void setResourceService(IResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
