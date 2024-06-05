package cn.net.engine.mapper;

import cn.net.engine.bean.project.EndpointType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName EndpointTypeMapper
 * @Description 端点类型访问数据库的接口
 * @Author ycl
 * @Date 2024/6/5 下午5:09
 * @Version 1.0
 */
@Mapper
public interface EndpointTypeMapper {

    /**
     * 查询端点类型
     * @param endpointType 端点类型查询条件
     * @return 端点类型集合
     */
    List<EndpointType> getEndpointTypes(EndpointType endpointType);
}
