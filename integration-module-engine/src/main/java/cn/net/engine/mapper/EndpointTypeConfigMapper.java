package cn.net.engine.mapper;

import cn.net.engine.bean.project.EndpointTypeConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName EndpointConfigMapper
 * @Description 端点配置mapper
 * @Author ycl
 * @Date 2024/6/17 上午11:52
 * @Version 1.0
 */
public interface EndpointTypeConfigMapper {

    /**
     * 根据端点类型查询配置信息表的数据
     *
     * @param endpointType 配置名称
     * @return 配置数据
     */
    List<EndpointTypeConfig> findAllByEndpointType(@Param("endpointType") String endpointType);

    /**
     * 添加端点配置
     *
     * @param configs 配置项
     * @return 受影响的行数
     */
    int addEndpointConfigs(@Param("configs") List<EndpointTypeConfig> configs);

    /**
     * 添加端点配置 单条数据
     *
     * @param config 配置项
     * @return 受影响的行数
     */
    int addEndpointConfig(EndpointTypeConfig config);

    /**
     * 更新端点配置
     *
     * @param config 配置数据
     * @return 受影响的行数
     */
    int updateEndpointConfig(@Param("config") EndpointTypeConfig config);

    /**
     * 删除端点配置
     *
     * @param id 主键
     * @return 受影响的行数
     */
    int deleteEndpointConfig(@Param("id") String id);

    /**
     * 批量删除
     * @param ids id
     * @return 受影响的行数
     */
    int deleteEndpointConfigsBatch(@Param("ids") List<String> ids);

    /**
     * 根据端点类型删除
     * @param endpointType 端点类型
     * @return 受影响的行数
     */
    int deleteEndpointConfigs(@Param("endpointType") String endpointType);
}
