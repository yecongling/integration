package cn.net.engine.service;

import cn.net.engine.bean.project.EndpointType;
import cn.net.engine.bean.project.EndpointTypeConfig;

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
     * 查询端点类型的树结构数据
     * @param endpointType 查询条件
     * @return 端点信息
     */
    List<EndpointType> getEndpointTypesTree(String endpointType);

    /**
     * 根据端点类型查询该类型的配置项
     * @param endpointType 端点类型
     * @return 配置项
     */
    List<EndpointTypeConfig> getEndpointTypeConfigs(String endpointType);

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
     * @param endpointTypeId 端点id
     * @return true 成功 false 失败
     */
    boolean deleteEndpointType(String endpointTypeId);
}
