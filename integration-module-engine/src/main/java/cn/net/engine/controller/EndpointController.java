package cn.net.engine.controller;

import cn.net.base.core.Response;
import cn.net.engine.bean.project.Endpoint;
import cn.net.engine.service.IEndpointService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *
     * @param endpoint 查询条件
     * @return 端点数据
     */
    @PostMapping("/getEndpoints")
    public Response<List<Endpoint>> getEndpoints(@RequestBody Endpoint endpoint) {
        List<Endpoint> endpoints = endpointService.getEndpoints(endpoint);
        return Response.success(endpoints);
    }

    /**
     * 根据id查询端点
     *
     * @param endpointId 端点id
     * @return 端点信息
     */
    @GetMapping("/getEndpointById/{endpointId}")
    public Response<Endpoint> getEndpointById(@PathVariable("endpointId") String endpointId) {
        return Response.success(endpointService.getEndpoint(endpointId));
    }

    /**
     * 新增端点
     *
     * @param endpoint 端点数据
     * @return 结果
     */
    @PostMapping("/addEndpoint")
    public Response<Boolean> addEndpoint(@Valid @RequestBody Endpoint endpoint) {
        return Response.success(endpointService.addEndpoint(endpoint));
    }

    /**
     * 更新端点(前端部分的删除端点，走这里，只能修改端点的删除状态，真正的删除需要去垃圾箱处理)
     *
     * @param endpoint 端点
     * @return true、false
     */
    @PostMapping("/updateEndpoint")
    public Response<Boolean> updateEndpoint(@Valid @RequestBody Endpoint endpoint) {
        return Response.success(endpointService.updateEndpoint(endpoint));
    }

    /**
     * 删除端点
     *
     * @param endpointId 端点id
     * @return 删除结果
     */
    @DeleteMapping("/deleteEndpoint/{endpointId}")
    public Response<Boolean> deleteEndpoint(@PathVariable("endpointId") String endpointId) {
        return Response.success(endpointService.deleteEndpoint(endpointId));
    }
}
