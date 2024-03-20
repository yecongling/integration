package cn.net.integration.modules.engine.service.impl;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.modules.engine.entity.project.*;
import cn.net.integration.modules.engine.mapper.EngineDesignerMapper;
import cn.net.integration.modules.engine.service.IDesignerService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DesignerServiceImpl
 * @Description 引擎设计器实现类
 * @Author 叶丛林
 * @Date 2023/8/30 22:38
 * @Version 1.0
 **/
@Service(value = "engineDesignerService")
public class DesignerServiceImpl extends ServiceImpl<EngineDesignerMapper, Endpoint> implements IDesignerService {

    private EngineDesignerMapper engineDesignerMapper;

    @Autowired
    public void setDesignerMapper(EngineDesignerMapper engineDesignerMapper) {
        this.engineDesignerMapper = engineDesignerMapper;
    }

    /**
     * 根据项目获取其对应的endpoint服务
     *
     * @param params 查询参数，包括项目ID
     * @return endpoints
     */
    @Override
    public List<Endpoint> getEndpoints(JSONObject params) {
        return null;
    }

    /**
     * 查询项目所包含的endpoint
     *
     * @param projectId 项目ID
     * @return 多个 endpoints
     */
    @Override
    public List<Endpoint> getEndpointsByProjectId(String projectId) {
        return engineDesignerMapper.getEndpointsByProjectId(projectId);
    }

    /**
     * 查询项目所包含的route
     *
     * @param projectId 项目ID
     * @return 多个路由
     */
    @Override
    public List<Route> getRoutsByProjectId(String projectId) {
        return engineDesignerMapper.getRoutsByProjectId(projectId);
    }

    /**
     * 查询项目包含的消息收发器
     *
     * @param projectId 项目ID
     * @return 消息收发器
     */
    @Override
    public List<MessageSendReceiver> getMessageSR(String projectId) {
        return engineDesignerMapper.getMessageSR(projectId);
    }

    /**
     * 查询项目包含的分组信息
     *
     * @param projectId 项目ID
     * @return 分组信息
     */
    @Override
    public List<Group> getGroup(String projectId) {
        return engineDesignerMapper.getGroup(projectId);
    }

    /**
     * 查询终端属性配置
     *
     * @return 返回终端的属性配置
     */
    @Override
    public Response<List<EndpointProperties>> queryEndpointProperties() {
        JSONObject param = new JSONObject();
        List<EndpointProperties> properties = engineDesignerMapper.queryEndpointProperties(param);
        return Response.success(properties);
    }

    /**
     * 查询路由
     *
     * @param routeIds 需要查询的路由ID
     * @return 返回多个路由信息
     */
    @Override
    public List<Route> queryRoutes(List<String> routeIds) {
        List<Route> routes = engineDesignerMapper.queryRoutes(routeIds);
        // 仅仅是为了返回（后续需要更改的）
        if (routes.isEmpty()) {
            return new ArrayList<>();
        }
        return routes;
    }
}
