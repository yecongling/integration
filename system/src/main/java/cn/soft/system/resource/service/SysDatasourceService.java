package cn.soft.system.resource.service;

import cn.soft.common.api.vo.Result;
import cn.soft.system.resource.entity.SysDatasource;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @ClassName SysDatasourceService
 * @Description 数据源service
 * @Author ycl
 * @Date 2022/11/22 12:54
 * @Version 1.0
 */
public interface SysDatasourceService {

    /**
     * 查询所有的数据源信息
     *
     * @param datasource 查询条件
     * @return 数据源信息集合
     */
    Result<List<SysDatasource>> queryDatasource(SysDatasource datasource);

    /**
     * 添加数据源
     *
     * @param datasource 数据源
     * @return 新增结果
     */
    Result<JSONObject> addDatasource(SysDatasource datasource);

    /**
     * 修改数据源信息
     *
     * @param datasource 数据源
     * @return 修改结果
     */
    Result<JSONObject> updateDatasource(SysDatasource datasource);

    /**
     * 检测连接是否可用
     *
     * @param datasource 数据源
     * @return 测试连接结果
     */
    Result<JSONObject> testConnection(SysDatasource datasource);
}
