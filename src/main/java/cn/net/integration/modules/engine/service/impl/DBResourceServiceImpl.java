package cn.net.integration.modules.engine.service.impl;

import cn.net.integration.modules.engine.entity.resource.DBResourceModel;
import cn.net.integration.modules.engine.mapper.DBResourceMapper;
import cn.net.integration.modules.engine.service.DBResourceService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DBResourceServiceImpl
 * @Description 数据库资源业务类
 * @Author yeconglin
 * @Date 2024/1/9 19:41
 * @Version 1.0
 */
@Service
public class DBResourceServiceImpl extends ServiceImpl<DBResourceMapper, DBResourceModel> implements DBResourceService {
    private DBResourceMapper dbResourceMapper;

    @Autowired
    public void setDbResourceMapper(DBResourceMapper dbResourceMapper) {
        this.dbResourceMapper = dbResourceMapper;
    }

    /**
     * 查询数据库资源数据
     *
     * @param param    查询参数
     * @param pageNo   分页数
     * @param pageSize 分页大小
     * @return 数据库资源
     */
    @Override
    public List<Map<String, Object>> queryDBResource(JSONObject param, int pageNo, int pageSize) {
        // 构建查询的参数变化
        DBResourceModel model = new DBResourceModel();
        // 查询数据库资源
        List<DBResourceModel> models = dbResourceMapper.queryDBResource(model, pageNo, pageSize);
        // 验证资源
        return null;
    }
}
