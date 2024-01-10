package cn.net.integration.modules.engine.service;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.engine.entity.connection.DatasourceModel;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @ClassName SysDatasourceService
 * @Description 数据源service
 * @Author ycl
 * @Date 2022/11/22 12:54
 * @Version 1.0
 */
public interface IDatasourceService extends IService<DatasourceModel> {

    /**
     * 查询所有的数据源信息
     *
     * @param datasource 查询条件
     * @param pageNo -
     * @param pageSize -
     * @return 数据源信息集合
     */
    Result<List<DatasourceModel>> queryDatasource(DatasourceModel datasource, int pageNo, int pageSize);

    /**
     * 添加数据源
     *
     * @param datasource 数据源
     * @return 新增结果
     */
    Result<Object> addDatasource(DatasourceModel datasource);

    /**
     * 修改数据源信息
     *
     * @param datasource 数据源
     * @return 修改结果
     */
    Result<JSONObject> updateDatasource(DatasourceModel datasource);

    /**
     * 检测连接是否可用
     *
     * @param datasource 数据源
     * @return 测试连接结果
     */
    Result<JSONObject> testConnection(DatasourceModel datasource);
}
