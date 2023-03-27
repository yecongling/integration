package cn.soft.modules.engine.mapper;

import cn.soft.modules.engine.entity.connection.DatasourceModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName DatasourceMapper
 * @Description 数据源mapper
 * @Author 叶丛林
 * @Date 2022/11/24 21:48
 * @Version 1.0
 **/
@Mapper
public interface DatasourceMapper {

    /**
     * 查询数据源
     *
     * @param model    查询条件
     * @param pageNo   页大小
     * @param pageSize 页大小
     * @return 数据源
     */
    List<DatasourceModel> queryDatasource(DatasourceModel model, int pageNo, int pageSize);

}
