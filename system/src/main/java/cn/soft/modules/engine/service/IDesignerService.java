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
     * 根据项目获取其对应的endpoint服务
     *
     * @param params 查询参数，包括项目ID
     * @return endpoints
     */
    public List<Endpoint> getEndpoints(JSONObject params);
}
