package cn.net.engine.service.impl;

import cn.net.base.bean.SysOpr;
import cn.net.base.utils.UUIDUtils;
import cn.net.engine.bean.project.Endpoint;
import cn.net.engine.mapper.EndpointMapper;
import cn.net.engine.service.IEndpointService;
import cn.net.framework.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EndpointServiceImpl
 * @Description 端点服务实现类
 * @Author ycl
 * @Date 2024/5/31 下午5:22
 * @Version 1.0
 */
@Service
public class EndpointServiceImpl implements IEndpointService {

    private EndpointMapper endpointMapper;

    private ServletUtils servletUtils;

    @Autowired
    public void setEndpointMapper(EndpointMapper endpointMapper) {
        this.endpointMapper = endpointMapper;
    }

    @Autowired
    public void setServletUtils(ServletUtils servletUtils) {
        this.servletUtils = servletUtils;
    }

    /**
     * 根据端点信息进行检索（端点表格界面-这里检索的时候不查询对应的详细的配置信息）
     *
     * @param endpoint 检索条件
     * @return 端点列表
     */
    @Override
    public List<Endpoint> getEndpoints(Endpoint endpoint) {
        // 首选通过查询条件去查询端点的数据
        return endpointMapper.queryEndpoints(endpoint);
    }

    /**
     * 根据id查询端点
     *
     * @param endpointId 终端id
     * @return 终端信息
     */
    @Override
    public Endpoint getEndpoint(String endpointId) {
        return endpointMapper.getEndpointById(endpointId);
    }

    /**
     * 查询终端的类型，用于在配置终端的时候选择其对应的类型
     *
     * @return 查询到的Endpoint类型
     */
    @Override
    public List<Map<String, Object>> getEndpointTypes() {
        return List.of();
    }

    /**
     * 添加端点
     *
     * @param endpoint 端点信息
     * @return true、false
     */
    @Override
    public boolean addEndpoint(Endpoint endpoint) {
        // 获取当前操作时间和操作员
        SysOpr sysOpr = servletUtils.getSysOpr();
        endpoint.setCreateBy(sysOpr.getUserId());
        endpoint.setUpdateBy(sysOpr.getUserId());
        endpoint.setCreateTime(new Date());
        endpoint.setUpdateTime(new Date());
        // 设置生成的唯一id
        endpoint.setId(UUIDUtils.getUniqueId());
        int i = endpointMapper.addEndpoint(endpoint);
        return i > 0;
    }

    /**
     * 更新端点(前端部分的删除端点，走这里，只能修改端点的删除状态，真正的删除需要去垃圾箱处理)
     *
     * @param endpoint 端点
     * @return true、false
     */
    @Override
    public boolean updateEndpoint(Endpoint endpoint) {
        // 更新之前，需要先判定当前端点是否在哪运行中
        Endpoint endpoint1 = getEndpoint(endpoint.getId());
        if (endpoint1 != null && endpoint1.getStatus() != 4) {
            throw new RuntimeException("运行中端点不能进行修改，请停用后再修改！");
        }
        // 更新时间和操作人
        SysOpr sysOpr = servletUtils.getSysOpr();
        endpoint.setUpdateBy(sysOpr.getUserId());
        endpoint.setUpdateTime(new Date());
        int i = endpointMapper.updateEndpoint(endpoint);
        return i > 0;
    }

    /**
     * 删除端点
     *
     * @param endpointId 端点信息
     * @return true、false
     */
    @Override
    public boolean deleteEndpoint(String endpointId) {
        // 首先需要去查询该端点是否在运行中，运行中的端点不能进行删除
        Endpoint endpoint1 = getEndpoint(endpointId);
        if (endpoint1 != null && endpoint1.getStatus() != 4) {
            throw new RuntimeException("运行中端点不能进行删除，请停用后再删除！");
        }
        int i = endpointMapper.deleteEndpoint(endpointId);
        return i > 0;
    }
}
