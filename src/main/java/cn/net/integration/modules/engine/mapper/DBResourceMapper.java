package cn.net.integration.modules.engine.mapper;

import cn.net.integration.modules.engine.entity.resource.DBResourceModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DBResourceMapper
 * @Description 数据库资源mapper
 * @Author yeconglin
 * @Date 2024/1/9 20:01
 * @Version 1.0
 */
@Mapper
public interface DBResourceMapper {

    /**
     * 查询数据库资源
     *
     * @param dbResourceModel 数据库资源模型
     * @param pageNo          分页数
     * @param pageSize        分页大小
     * @return 数据库资源
     */
    List<DBResourceModel> queryDBResource(@Param("param") DBResourceModel dbResourceModel, int pageNo, int pageSize);
}
