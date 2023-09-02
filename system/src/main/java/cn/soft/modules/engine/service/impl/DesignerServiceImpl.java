package cn.soft.modules.engine.service.impl;

import cn.soft.modules.base.service.impl.BaseCommonServiceImpl;
import cn.soft.modules.engine.entity.project.Endpoint;
import cn.soft.modules.engine.mapper.EngineDesignerMapper;
import cn.soft.modules.engine.service.IDesignerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DesignerServiceImpl
 * @Description 引擎设计器实现类
 * @Author 叶丛林
 * @Date 2023/8/30 22:38
 * @Version 1.0
 **/
@Service(value = "engineDesignerService")
public class DesignerServiceImpl extends BaseCommonServiceImpl implements IDesignerService {

    private EngineDesignerMapper engineDesignerMapper;

    @Autowired
    public void setDesignerMapper(EngineDesignerMapper engineDesignerMapper) {
        this.engineDesignerMapper = engineDesignerMapper;
    }

    /**
     * 根据项目获取其对应的endpoint服务
     *
     * @param params 查询参数，包括项目ID
     * @return endpoints
     */
    @Override
    public List<Endpoint> getEndpoints(JSONObject params) {
        return null;
    }
}
