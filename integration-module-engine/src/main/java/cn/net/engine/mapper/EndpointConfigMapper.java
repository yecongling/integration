package cn.net.engine.mapper;

import cn.net.engine.bean.project.EndpointConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName EndpointConfigMapper
 * @Description 端点配置mapper
 * @Author ycl
 * @Date 2024/6/17 上午11:52
 * @Version 1.0
 */
public interface EndpointConfigMapper {

    /**
     * 根据端点类型查询配置信息表的数据
     *
     * @param endpointType 配置名称
     * @return 配置数据
     */
    List<EndpointConfig> findAllByEndpointType(@Param("endpointType") String endpointType);

    /**
     * 添加端点配置
     *
     * @param configs 配置项
     * @return 受影响的行数
     */
    int addEndpointConfig(@Param("configs") List<EndpointConfig> configs);

    /**
     * 添加端点配置 单条数据
     *
     * @param config 配置项
     * @return 受影响的行数
     */
    int addEndpointConfig(@Param("config") EndpointConfig config);

    /**
     * 更新端点配置
     *
     * @param config 配置数据
     * @return 受影响的行数
     */
    int updateEndpointConfig(@Param("config") EndpointConfig config);

    /**
     * 删除端点配置
     *
     * @param name 端点名
     * @param type 端点类型
     * @return 受影响的行数
     */
    int deleteEndpointConfig(@Param("name") String name, @Param("type") String type);
}
