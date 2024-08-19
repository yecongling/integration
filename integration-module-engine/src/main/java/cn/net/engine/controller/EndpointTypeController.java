package cn.net.engine.controller;

import cn.net.base.core.Response;
import cn.net.engine.bean.project.EndpointType;
import cn.net.engine.bean.project.EndpointTypeConfig;
import cn.net.engine.service.IEndpointTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName EndpointTypeController
 * @Description 端点类型接口(一个推送测试)
 * @Author ycl
 * @Date 2024/6/5 下午4:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/project/endpointType")
public class EndpointTypeController {

    private IEndpointTypeService endpointTypeService;

    @Autowired
    public void setEndpointTypeService(IEndpointTypeService endpointTypeService) {
        this.endpointTypeService = endpointTypeService;
    }

    /**
     * 查询端点类型(树形结构数据)
     *
     * @param typeName 类型名
     * @return 端点类型
     */
    @GetMapping("/getEndpointTypeTree")
    public Response<List<EndpointType>> getEndpointTypeTree(String typeName) {
        return Response.success(endpointTypeService.getEndpointTypesTree(typeName));
    }

    /**
     * 查询端点类型不包括配置
     *
     * @param endpointType 端点类型
     * @return 所有满足条件的端点类型
     */
    @PostMapping("/getEndpointTypes")
    public Response<List<EndpointType>> getEndpointTypes(@RequestBody(required = false) EndpointType endpointType) {
        return Response.success(endpointTypeService.findAll(endpointType));
    }

    /**
     * 根据端点类型查询类型配置
     * @param typeId 类型id
     * @return 类型配置
     */
    @GetMapping("/getEndpointTypeConfig")
    public Response<List<EndpointTypeConfig>> getEndpointTypeConfig(@RequestParam(name = "typeId") String typeId) {
        return Response.success(endpointTypeService.getEndpointTypeConfigs(typeId));
    }

    /**
     * 新增端点类型
     *
     * @param endpointType 端点类型数据
     * @return true 成功 false 失败
     */
    @PostMapping("/addEndpointType")
    public Response<Boolean> addEndpointType(@Valid @RequestBody EndpointType endpointType) {
        return Response.success(endpointTypeService.addEndpointType(endpointType));
    }

    /**
     * 更新端点类型
     *
     * @param endpointType 端点类型
     * @return true 成功 false 失败
     */
    @PostMapping("/updateEndpointType")
    public Response<Boolean> updateEndpointType(@Valid @RequestBody EndpointType endpointType) {
        return Response.success(endpointTypeService.updateEndpointType(endpointType));
    }

    /**
     * 删除端点类型
     *
     * @param endpointTypeId 端点类型id
     * @return true 成功 false 失败
     */
    @DeleteMapping("/deleteEndpointType/{endpointTypeId}")
    public Response<Boolean> deleteEndpointType(@PathVariable String endpointTypeId) {
        return Response.success(endpointTypeService.deleteEndpointType(endpointTypeId));
    }
}
