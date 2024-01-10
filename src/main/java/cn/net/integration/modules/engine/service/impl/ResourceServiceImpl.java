package cn.net.integration.modules.engine.service.impl;

import cn.net.integration.modules.engine.entity.resource.ResourceModel;
import cn.net.integration.modules.engine.mapper.ResourceMapper;
import cn.net.integration.modules.engine.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName ResourceServiceImpl
 * @Description 资源管理部分
 * @Author 叶丛林
 * @Date 2023/9/1 23:12
 * @Version 1.0
 **/
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourceModel> implements IResourceService {
}
