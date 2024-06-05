package cn.net.engine.service.impl;

import cn.net.engine.bean.project.EndpointType;
import cn.net.engine.mapper.EndpointTypeMapper;
import cn.net.engine.service.IEndpointTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EndpointTypeServiceImpl
 * @Description 端点类型服务实现类
 * @Author ycl
 * @Date 2024/6/5 下午5:12
 * @Version 1.0
 */
@Service
public class EndpointTypeServiceImpl implements IEndpointTypeService {

    private EndpointTypeMapper endpointTypeMapper;
    @Autowired
    public void setEndpointTypeMapper(EndpointTypeMapper endpointTypeMapper) {
        this.endpointTypeMapper = endpointTypeMapper;
    }

    /**
     * 查询所有端点类型
     *
     * @param endpointType 查询条件
     * @return 端点类型集合
     */
    @Override
    public List<EndpointType> findAll(EndpointType endpointType) {
        return endpointTypeMapper.getEndpointTypes(endpointType);
    }

    /**
     * 新增端点类型
     *
     * @param endpointType 端点类型
     * @return true 成功 false 失败
     */
    @Override
    public boolean addEndpointType(EndpointType endpointType) {
        return false;
    }

    /**
     * 更新端点类型
     *
     * @param endpointType 端点类型
     * @return true 成功 false 失败
     */
    @Override
    public boolean updateEndpointType(EndpointType endpointType) {
        return false;
    }

    /**
     * 删除端点类型
     *
     * @param endpointTypeName 端点名称
     * @return true 成功 false 失败
     */
    @Override
    public boolean deleteEndpointType(String endpointTypeName) {
        return false;
    }
}
