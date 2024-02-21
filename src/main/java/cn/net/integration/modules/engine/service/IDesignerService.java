package cn.net.integration.modules.engine.service;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.engine.entity.project.*;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @ClassName IDesignerService
 * @Description 引擎设计器服务类
 * @Author 叶丛林
 * @Date 2023/8/30 22:37
 * @Version 1.0
 **/
public interface IDesignerService extends IService<Endpoint> {

    /**
     * 根据项目获取其对应的endpoint服务
     *
     * @param params 查询参数，包括项目ID
     * @return endpoints
     */
    List<Endpoint> getEndpoints(JSONObject params);

    /**
     * 查询项目所包含的endpoint
     *
     * @param projectId 项目ID
     * @return 多个 endpoints
     */
    List<Endpoint> getEndpointsByProjectId(String projectId);

    /**
     * 查询项目所包含的route
     *
     * @param projectId 项目ID
     * @return 多个路由
     */
    List<Route> getRoutsByProjectId(String projectId);

    /**
     * 查询项目包含的消息收发器
     *
     * @param projectId 项目ID
     * @return 消息收发器
     */
    List<MessageSendReceiver> getMessageSR(String projectId);

    /**
     * 查询项目包含的分组信息
     * @param projectId 项目ID
     * @return 分组信息
     */
    List<Group> getGroup(String projectId);

    /**
     * 查询终端属性配置
     *
     * @return 返回终端的属性配置
     */
    Result<List<EndpointProperties>> queryEndpointProperties();

    /**
     * 查询路由
     *
     * @param routeIds 需要查询的路由ID
     * @return 返回多个路由信息
     */
    List<Route> queryRoutes(List<String> routeIds);
}
