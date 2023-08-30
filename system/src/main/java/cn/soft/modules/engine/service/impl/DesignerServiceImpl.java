package cn.soft.modules.engine.service.impl;

import cn.soft.modules.base.service.impl.BaseCommonServiceImpl;
import cn.soft.modules.engine.entity.project.Endpoint;
import cn.soft.modules.engine.mapper.DesignerMapper;
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

    private DesignerMapper designerMapper;

    @Autowired
    public void setDesignerMapper(DesignerMapper designerMapper) {
        this.designerMapper = designerMapper;
    }

    /**
     * 查询endpoint
     *
     * @param params 参数
     * @return endpoints
     */
    @Override
    public List<Endpoint> getEndpointService(JSONObject params) {
        return null;
    }
}
