package cn.net.engine.controller;

import cn.net.base.core.Response;
import cn.net.engine.bean.project.Endpoint;
import cn.net.engine.service.IEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TerminalController
 * @Description 终端管理接口
 * @Author ycl
 * @Date 2024/5/31 上午9:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/engine/endpoint")
public class EndpointController {

    private IEndpointService endpointService;
    @Autowired
    public void setEndpointService(IEndpointService endpointService) {
        this.endpointService = endpointService;
    }

    /**
     * 查询端点
     * @param endpoint 查询条件
     * @return 端点数据
     */
    @PostMapping("/getEndpoints")
    public Response<List<Endpoint>> getEndpoints(@RequestBody Endpoint endpoint) {
        List<Endpoint> endpoints = endpointService.getEndpoints(endpoint);
        return Response.success(endpoints);
    }
}
