package cn.net.engine.service;

import cn.net.engine.bean.project.Endpoint;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ITerminalService
 * @Description 终端service接口
 * @Author ycl
 * @Date 2024/5/31 上午9:17
 * @Version 1.0
 */
public interface IEndpointService {

    /**
     * 根据端点信息进行检索（端点表格界面-这里检索的时候不查询对应的详细的配置信息）
     *
     * @param endpoint 检索条件
     * @return 端点列表
     */
    List<Endpoint> getEndpoints(Endpoint endpoint);

    /**
     * 根据id查询端点
     * @param endpointId 终端id
     * @return 终端信息
     */
    Endpoint getEndpoint(String endpointId);

    /**
     * 查询终端的类型，用于在配置终端的时候选择其对应的类型
     * @return 查询到的Endpoint类型
     */
    List<Map<String, Object>> getEndpointTypes();

    /**
     * 添加端点
     * @param endpoint 端点信息
     * @return true、false
     */
    boolean addEndpoint(Endpoint endpoint);

    /**
     * 更新端点
     * @param endpoint 端点
     * @return true、false
     */
    boolean updateEndpoint(Endpoint endpoint);

    /**
     * 删除端点
     * @param endpointId 端点信息
     * @return true、false
     */
    boolean deleteEndpoint(String endpointId);
}
