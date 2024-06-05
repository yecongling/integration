package cn.net.engine.service;

import cn.net.engine.bean.project.EndpointType;

import java.util.List;

/**
 * @ClassName IEndpointTypeService
 * @Description 端点类型服务接口
 * @Author ycl
 * @Date 2024/6/5 下午5:09
 * @Version 1.0
 */
public interface IEndpointTypeService {

    /**
     * 查询所有端点类型
     *
     * @param endpointType 查询条件
     * @return 端点类型集合
     */
    List<EndpointType> findAll(EndpointType endpointType);

    /**
     * 新增端点类型
     *
     * @param endpointType 端点类型
     * @return true 成功 false 失败
     */
    boolean addEndpointType(EndpointType endpointType);

    /**
     * 更新端点类型
     *
     * @param endpointType 端点类型
     * @return true 成功 false 失败
     */
    boolean updateEndpointType(EndpointType endpointType);

    /**
     * 删除端点类型
     *
     * @param endpointTypeName 端点名称
     * @return true 成功 false 失败
     */
    boolean deleteEndpointType(String endpointTypeName);
}
