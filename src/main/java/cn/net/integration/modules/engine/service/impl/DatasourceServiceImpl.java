package cn.net.integration.modules.engine.service.impl;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.core.common.util.UUIDUtil;
import cn.net.integration.modules.engine.entity.connection.DatasourceModel;
import cn.net.integration.modules.engine.mapper.DatasourceMapper;
import cn.net.integration.modules.engine.service.IDatasourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName DatasourceServiceImpl
 * @Description 数据源业务实现类
 * @Author 叶丛林
 * @Date 2023/3/27 21:22
 * @Version 1.0
 **/
@Service
public class DatasourceServiceImpl extends ServiceImpl<DatasourceMapper, DatasourceModel> implements IDatasourceService {

    private DatasourceMapper datasourceMapper;

    @Autowired
    public void setDatasourceMapper(DatasourceMapper datasourceMapper) {
        this.datasourceMapper = datasourceMapper;
    }

    /**
     * 查询所有的数据源信息
     *
     * @param datasource 查询条件
     * @param pageNo     -
     * @param pageSize   -
     * @return 数据源信息集合
     */
    @Override
    public Response<List<DatasourceModel>> queryDatasource(DatasourceModel datasource, int pageNo, int pageSize) {
        List<DatasourceModel> models = datasourceMapper.queryDatasource(datasource, pageNo, pageSize);
        return Response.success(models);
    }

    /**
     * 添加数据源
     *
     * @param datasource 数据源
     * @return 新增结果
     */
    @Override
    public Response<Object> addDatasource(DatasourceModel datasource) {
        datasource.setId(UUIDUtil.getUniqueId());
        datasource.setCreateBy("admin");
        datasource.setCreateTime(new Date());
        datasource.setUpdateBy("admin");
        datasource.setUpdateTime(new Date());
        int i = datasourceMapper.addDataSource(datasource);
        if (i > 0) {
            return Response.success("新增数据源成功");
        }
        return Response.error("新增数据源失败");
    }

    /**
     * 修改数据源信息
     *
     * @param datasource 数据源
     * @return 修改结果
     */
    @Override
    public boolean updateDatasource(DatasourceModel datasource) {
        return true;
    }

    /**
     * 检测连接是否可用
     *
     * @param datasource 数据源
     * @return 测试连接结果
     */
    @Override
    public boolean testConnection(DatasourceModel datasource) {

        return true;
    }
}
