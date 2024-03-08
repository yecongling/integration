package cn.net.integration.modules.engine.service.impl;

import cn.net.integration.modules.engine.entity.resource.ResourceModel;
import cn.net.integration.modules.engine.mapper.ResourceMapper;
import cn.net.integration.modules.engine.service.IResourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ResourceServiceImpl
 * @Description 资源管理部分
 * @Author 叶丛林
 * @Date 2023/9/1 23:12
 * @Version 1.0
 **/
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourceModel> implements IResourceService {

    private ResourceMapper resourceMapper;
    @Autowired
    public void setResourceMapper(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    /**
     * 查询符合条件的资源
     *
     * @param resourceModel 资源的检索条件
     * @return 资源列表
     */
    @Override
    public List<ResourceModel> queryAllResource(ResourceModel resourceModel) {
        QueryWrapper<ResourceModel> wrapper = new QueryWrapper<>();
        List<ResourceModel> list = resourceMapper.selectList(wrapper);
        return list;
    }
}
