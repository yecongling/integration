package cn.net.integration.modules.engine.mapper;

import cn.net.integration.modules.engine.entity.resource.ResourceModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ResourceMapper
 * @Description 资源mapper
 * @Author ycl
 * @Date 2022/11/25 12:59
 * @Version 1.0
 */
@Mapper
public interface ResourceMapper extends BaseMapper<ResourceModel> {
}
