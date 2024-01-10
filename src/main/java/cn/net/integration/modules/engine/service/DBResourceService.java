package cn.net.integration.modules.engine.service;

import cn.net.integration.modules.engine.entity.resource.DBResourceModel;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DBResourceService
 * @Description 数据库资源service
 * @Author yeconglin
 * @Date 2024/1/9 19:35
 * @Version 1.0
 */
public interface DBResourceService extends IService<DBResourceModel> {

    /**
     * 查询数据库资源数据
     *
     * @param param    查询参数
     * @param pageNo   分页数
     * @param pageSize 分页大小
     * @return 数据库资源
     */
    List<Map<String, Object>> queryDBResource(JSONObject param, int pageNo, int pageSize);
}
