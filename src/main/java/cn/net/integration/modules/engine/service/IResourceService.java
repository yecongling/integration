package cn.net.integration.modules.engine.service;

import cn.net.integration.modules.engine.entity.resource.ResourceModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @ClassName ResourceService
 * @Description 资源业务接口
 * @Author ycl
 * @Date 2022/11/25 13:00
 * @Version 1.0
 */
public interface IResourceService extends IService<ResourceModel> {

    /**
     * 查询符合条件的资源
     * @param resourceModel 资源的检索条件
     * @return 资源列表
     */
    List<ResourceModel> queryAllResource(ResourceModel resourceModel);



}
