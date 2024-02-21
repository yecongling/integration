package cn.net.integration.modules.engine.controller;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.engine.entity.project.*;
import cn.net.integration.modules.engine.service.IDesignerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DesignerController
 * @Description 设计器controller
 * @Author 叶丛林
 * @Date 2023/8/30 21:53
 * @Version 1.0
 **/
@RestController(value = "engineDesigner")
@RequestMapping("/engine/designer")
public class DesignerController {

    private IDesignerService designerService;

    @Autowired
    public void setDesignerService(IDesignerService designerService) {
        this.designerService = designerService;
    }

    /**
     * 查询服务（根据项目ID查询其包含的终端服务）
     *
     * @param param 参数
     * @return endpoint
     */
    @PostMapping("/getEndpointService")
    public List<Endpoint> getEndpointService(@RequestBody JSONObject param) {
        return designerService.getEndpoints(param);
    }

    /**
     * 查询项目包含的组件信息，其中包括端点、路由、消息收发器
     *
     * @param projectId 项目ID
     * @return 数据
     */
    @GetMapping("/queryComponents")
    public Object queryEndpointsByProjectId(@RequestParam(name = "projectId") String projectId) {
        // 端点
        List<Endpoint> endpoints = designerService.getEndpointsByProjectId(projectId);
        Map<String, Object> result = new HashMap<>();
        result.put("endpoints", endpoints);
        // 路由
        List<Route> routsByProjectId = designerService.getRoutsByProjectId(projectId);
        result.put("routes", routsByProjectId);
        // 消息收发器
        List<MessageSendReceiver> messageSR = designerService.getMessageSR(projectId);
        result.put("messageSR", messageSR);
        // 分组
        List<Group> group = designerService.getGroup(projectId);
        result.put("group", group);
        return result;
    }

    /**
     * 查询终端的属性配置
     *
     * @return 终端属性配置
     */
    @GetMapping("/endpointProperties")
    public Result<List<EndpointProperties>> queryEndpointProperties() {
        return designerService.queryEndpointProperties();
    }

    /**
     * 查询路由信息
     *
     * @return 返回路由信息
     */
    @RequestMapping("/queryRoutes")
    public Result<List<Route>> queryRoutes() {
        List<String> ids = new ArrayList<>();
        ids.add("route_123456");
        List<Route> routes = designerService.queryRoutes(ids);
        return Result.success(routes);
    }
}
