package cn.soft.modules.engine.service;

import cn.soft.modules.engine.entity.project.Endpoint;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @ClassName IDesignerService
 * @Description 引擎设计器服务类
 * @Author 叶丛林
 * @Date 2023/8/30 22:37
 * @Version 1.0
 **/
public interface IDesignerService {

    /**
     * 查询endpoint
     *
     * @param params 参数
     * @return endpoints
     */
    public List<Endpoint> getEndpointService(JSONObject params);
}
