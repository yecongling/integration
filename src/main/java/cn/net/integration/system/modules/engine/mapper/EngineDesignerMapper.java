package cn.net.integration.system.modules.engine.mapper;

import cn.net.integration.system.modules.engine.entity.project.Endpoint;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName DesignerMapper
 * @Description 设计器mapper
 * @Author 叶丛林
 * @Date 2023/8/30 22:42
 * @Version 1.0
 **/
@Mapper
public interface EngineDesignerMapper {

    /**
     * 查询endpoint
     *
     * @param param 参数
     * @return endpoints
     */
    public List<Endpoint> getEndpoints(JSONObject param);

}
