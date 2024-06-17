package cn.net.engine.mapper;

import cn.net.engine.bean.project.EndpointType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * 根据名称获取端点类型，用于前端判断重复
     *
     * @param name 端点类型名
     * @return 端点类型
     */
    int getEndpointTypeByName(String name);

    /**
     * 根据id查询端点类型
     * @param id 端点类型id
     * @return 端点类型
     */
    EndpointType getEndpointTypeById(@Param("id") String id);

    /**
     * 查询端点类型
     *
     * @param endpointType 端点类型查询条件
     * @return 端点类型集合
     */
    List<EndpointType> getEndpointTypes(EndpointType endpointType);

    /**
     * 添加端点类型
     *
     * @param endpointType 端点类型数据
     * @return 受影响的行数
     */
    int addEndpointType(EndpointType endpointType);

    /**
     * 更新端点类型
     *
     * @param endpointType 端点类型
     * @return 受影响的行数
     */
    int updateEndpointType(EndpointType endpointType);

    /**
     * 删除端点类型
     *
     * @param key 端点id
     * @return 受影响的行数
     */
    int deleteEndpointType(@Param("id") String key);
}
