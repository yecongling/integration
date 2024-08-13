package cn.net.engine.service.impl;

import cn.net.base.bean.SnowFlakeGenerator;
import cn.net.base.bean.SysOpr;
import cn.net.engine.bean.project.EndpointTypeConfig;
import cn.net.engine.bean.project.EndpointType;
import cn.net.engine.mapper.EndpointTypeConfigMapper;
import cn.net.engine.mapper.EndpointTypeMapper;
import cn.net.engine.service.IEndpointTypeService;
import cn.net.framework.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

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
    private EndpointTypeConfigMapper endpointConfigMapper;
    // servlet工具
    private ServletUtils servletUtils;
    // 雪花ID
    private SnowFlakeGenerator snowFlakeGenerator;

    @Autowired
    public void setEndpointTypeMapper(EndpointTypeMapper endpointTypeMapper) {
        this.endpointTypeMapper = endpointTypeMapper;
    }

    @Autowired
    public void setEndpointConfigMapper(EndpointTypeConfigMapper endpointConfigMapper) {
        this.endpointConfigMapper = endpointConfigMapper;
    }

    @Autowired
    public void setServletUtils(ServletUtils servletUtils) {
        this.servletUtils = servletUtils;
    }

    @Autowired
    public void setSnowFlakeGenerator(SnowFlakeGenerator snowFlakeGenerator) {
        this.snowFlakeGenerator = snowFlakeGenerator;
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
     * 查询端点类型的树结构数据
     *
     * @param endpointType 查询条件
     * @return 端点信息
     */
    @Override
    public List<EndpointType> getEndpointTypesTree(String endpointType) {
        List<EndpointType> types = endpointTypeMapper.getEndpointType(endpointType);
        // 构建成上下级的关系
        // 先处理成map结构方便快速查找
        Map<String, EndpointType> collect = types.stream().collect(Collectors.toMap(EndpointType::getId, e -> e));
        // 定义返回的结果
        List<EndpointType> rootNodes = new ArrayList<>();
        for (EndpointType type : types) {
            if (type.getParentId() != null) {
                // 找到父节点
                EndpointType parent = collect.get(type.getParentId());
                if (parent != null) {
                    parent.getChildren().add(type);
                }
            } else {
                rootNodes.add(type);
            }
        }
        return rootNodes;
    }

    /**
     * 根据端点类型查询该类型的配置项
     *
     * @param endpointType 端点类型
     * @return 配置项
     */
    @Override
    public List<EndpointTypeConfig> getEndpointTypeConfigs(String endpointType) {
        return endpointConfigMapper.findAllByEndpointType(endpointType);
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
        endpointType.setId(snowFlakeGenerator.generateUniqueId());
        // 调用mapper插入类型表
        int addEndpointType = endpointTypeMapper.addEndpointType(endpointType);
        List<EndpointTypeConfig> properties = endpointType.getProperties();
        if (properties != null && !properties.isEmpty()) {
            // 给每个配置项设置修改人和时间
            for (EndpointTypeConfig endpointTypeConfig : properties) {
                endpointTypeConfig.setCreateBy(userId);
                endpointTypeConfig.setUpdateBy(userId);
                endpointTypeConfig.setId(snowFlakeGenerator.generateUniqueId());
                endpointTypeConfig.setCreateTime(time);
                endpointTypeConfig.setUpdateTime(time);
            }
        }
        // 调用mapper插入配置表（有可能没有配置项）
        int addEndpointConfig = endpointConfigMapper.addEndpointConfig(endpointType.getProperties());
        return addEndpointType > 0 && addEndpointConfig >= 0;
    }

    /**
     * 更新端点类型（更新设计到端点类型更新，配置的增删改）
     *
     * @param endpointType 端点类型
     * @return true 成功 false 失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateEndpointType(EndpointType endpointType) {
        // 获取当前的操作员和时间
        SysOpr sysOpr = servletUtils.getSysOpr();
        String userId = sysOpr.getUserId();
        Date time = new Date();
        endpointType.setUpdateBy(userId);
        endpointType.setUpdateTime(time);
        List<EndpointTypeConfig> properties = endpointType.getProperties();
        if (properties != null && !properties.isEmpty()) {
            // 给每个配置项设置修改人和时间
            for (EndpointTypeConfig endpointTypeConfig : properties) {
                endpointTypeConfig.setUpdateBy(userId);
                endpointTypeConfig.setUpdateTime(time);
            }
        }
        AtomicBoolean success = new AtomicBoolean(true);
        // 先更新端点类型表
        int updateEndpointType = endpointTypeMapper.updateEndpointType(endpointType);
        // 获取端点类型表关联的配置表的现有数据
        List<EndpointTypeConfig> endpointProperties = endpointConfigMapper.findAllByEndpointType(endpointType.getName());
        // 构建当前配置表的类型和名称的唯一集合
        Set<String> currentKeys = endpointProperties.stream()
                .map(EndpointTypeConfig::getId)
                .collect(Collectors.toSet());
        // 构建新B表的数据的唯一键集合
        Set<String> newKeys;
        if (properties != null && !properties.isEmpty()) {
            newKeys = properties.stream()
                    .map(EndpointTypeConfig::getId).collect(Collectors.toSet());
        } else {
            newKeys = new HashSet<>();
        }
        // 找到需要删除的配置表的数据
        endpointProperties.forEach(b -> {
            String key = b.getId();
            if (!newKeys.contains(key)) {
                success.set(endpointConfigMapper.deleteEndpointConfig(b.getId()) > 0);
            }
        });
        // 更新或新增配置表的数据
        if (properties != null && !properties.isEmpty()) {
            properties.forEach(b -> {
                String key = b.getId();
                if (!currentKeys.contains(key)) {
                    success.set(endpointConfigMapper.updateEndpointConfig(b) > 0);
                } else {
                    success.set(endpointConfigMapper.addEndpointConfig(b) > 0);
                }
            });
        }
        return success.get() && updateEndpointType > 0;
    }

    /**
     * 删除端点类型
     *
     * @param endpointTypeId 端点名称
     * @return true 成功 false 失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteEndpointType(String endpointTypeId) {
        // 先查询端点类型表的类型名
        EndpointType endpointType = endpointTypeMapper.getEndpointTypeById(endpointTypeId);
        if (endpointType == null) {
            throw new RuntimeException("ID " + endpointTypeId + " not found");
        }
        // 先删除配置表的，再删除端点类型表的
        int configs = endpointConfigMapper.deleteEndpointConfigs(endpointType.getName());
        int type = endpointTypeMapper.deleteEndpointType(endpointTypeId);
        // 因为配置表可能没有对应的配置数据
        return type > 0 && configs >= 0;
    }
}
