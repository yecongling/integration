package cn.soft.system.resource.service.impl;

import cn.soft.system.resource.mapper.ResourceManagerMapper;
import cn.soft.system.resource.service.ResourceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ResourceManagerServiceImpl
 * @Description 资管管理service实现
 * @Author 叶丛林
 * @Date 2022/10/25 23:06
 * @Version 1.0
 **/
@Service
public class ResourceManagerServiceImpl implements ResourceManagerService {

    private ResourceManagerMapper resourceManagerMapper;
    @Autowired
    public void setResourceManagerMapper(ResourceManagerMapper resourceManagerMapper) {
        this.resourceManagerMapper = resourceManagerMapper;
    }
}
