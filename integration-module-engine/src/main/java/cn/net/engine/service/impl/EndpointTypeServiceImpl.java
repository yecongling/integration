package cn.net.engine.service.impl;

import cn.net.base.bean.SysOpr;
import cn.net.engine.bean.project.EndpointConfig;
import cn.net.engine.bean.project.EndpointType;
import cn.net.engine.mapper.EndpointConfigMapper;
import cn.net.engine.mapper.EndpointTypeMapper;
import cn.net.engine.service.IEndpointTypeService;
import cn.net.framework.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    // 端点类型管理Mapper
    private EndpointTypeMapper endpointTypeMapper;
    // 端点配置Mapper
    private EndpointConfigMapper endpointConfigMapper;
    // servlet工具
    private ServletUtils servletUtils;

    @Autowired
    public void setEndpointTypeMapper(EndpointTypeMapper endpointTypeMapper) {
        this.endpointTypeMapper = endpointTypeMapper;
    }

    @Autowired
    public void setEndpointConfigMapper(EndpointConfigMapper endpointConfigMapper) {
        this.endpointConfigMapper = endpointConfigMapper;
    }

    @Autowired
    public void setServletUtils(ServletUtils servletUtils) {
        this.servletUtils = servletUtils;
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
    @Transactional(rollbackFor = Exception.class)
    public boolean addEndpointType(EndpointType endpointType) {
        // 获取当前的操作员和时间
        SysOpr sysOpr = servletUtils.getSysOpr();
        String userId = sysOpr.getUserId();
        Date time = new Date();
        endpointType.setCreateBy(userId);
        endpointType.setUpdateBy(userId);
        endpointType.setCreateTime(time);
        endpointType.setUpdateTime(time);
        // 调用mapper插入类型表
        int addEndpointType = endpointTypeMapper.addEndpointType(endpointType);
        List<EndpointConfig> properties = endpointType.getProperties();
        if (properties != null && !properties.isEmpty()) {
            // 给每个配置项设置修改人和时间
            for (EndpointConfig endpointConfig : properties) {
                endpointConfig.setCreateBy(userId);
                endpointConfig.setUpdateBy(userId);
                endpointConfig.setCreateTime(time);
                endpointConfig.setUpdateTime(time);
            }
        }
        // 调用mapper插入配置表（有可能没有配置项）
        int addEndpointConfig = endpointConfigMapper.addEndpointConfig(endpointType.getProperties());
        return addEndpointType > 0 && addEndpointConfig >= 0;
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
