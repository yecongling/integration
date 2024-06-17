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
     * 添加端点配置
     *
     * @param configs 配置项
     * @return 受影响的行数
     */
    int addEndpointConfig(@Param("configs") List<EndpointConfig> configs);
}
