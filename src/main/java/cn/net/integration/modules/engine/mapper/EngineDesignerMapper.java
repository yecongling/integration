package cn.net.integration.modules.engine.mapper;

import cn.net.integration.modules.engine.entity.project.*;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DesignerMapper
 * @Description 设计器mapper
 * @Author 叶丛林
 * @Date 2023/8/30 22:42
 * @Version 1.0
 **/
@Mapper
public interface EngineDesignerMapper extends BaseMapper<Endpoint> {

    /**
     * 查询endpoint
     *
     * @param param 参数
     * @return endpoints
     */
    List<Endpoint> getEndpoints(JSONObject param);

    /**
     * 查询项目所包含的endpoint
     *
     * @param projectId 项目ID
     * @return 多个 endpoints
     */
    List<Endpoint> getEndpointsByProjectId(@Param("id") String projectId);

    /**
     * 查询项目所包含的route
     *
     * @param projectId 项目ID
     * @return 多个路由
     */
    List<Route> getRoutsByProjectId(@Param("id") String projectId);

    /**
     * 查询项目包含的消息收发器
     *
     * @param projectId 项目ID
     * @return 消息收发器
     */
    List<MessageSendReceiver> getMessageSR(@Param("id") String projectId);

    /**
     * 查询项目包含的分组信息
     *
     * @param projectId 项目ID
     * @return 分组信息
     */
    List<Group> getGroup(@Param("id") String projectId);

    /**
     * 查询终端的配置属性
     *
     * @param params 筛选条件
     * @return 终端配置属性
     */
    List<EndpointProperties> queryEndpointProperties(@Param("query") JSONObject params);

    /**
     * 通过路由ID查询路由信息（可能包含多个路由）
     *
     * @param routeIDs 路由ID
     * @return 流程数据
     */
    List<Route> queryRoutes(List<String> routeIDs);

}
