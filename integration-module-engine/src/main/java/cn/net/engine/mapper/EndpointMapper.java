package cn.net.engine.mapper;

import cn.net.engine.bean.project.Endpoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName TerminalMapper
 * @Description 终端mapper
 * @Author ycl
 * @Date 2024/5/31 上午9:16
 * @Version 1.0
 */
@Mapper
public interface EndpointMapper {

    /**
     * 根据条件查询端点信息
     *
     * @param endpoint 端点信息
     * @return 查询到的端点数据
     */
    List<Endpoint> queryEndpoints(Endpoint endpoint);

    /**
     * 根据端点id获取详细的端点信息
     *
     * @param endpointId 端点id
     * @return 端点信息
     */
    Endpoint getEndpointById(@Param("id") String endpointId);

    /**
     * 添加端点
     * @param endpoint 端点信息
     * @return 受影响的行数
     */
    int addEndpoint(Endpoint endpoint);

    /**
     * 更新端点
     * @param endpoint 端点
     * @return 受影响的行数
     */
    int updateEndpoint(Endpoint endpoint);

    /**
     * 删除端点 会真正的删除
     * @param endpointId 端点信息
     * @return 受影响的行数
     */
    int deleteEndpoint(@Param("id") String endpointId);
}
