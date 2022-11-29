package cn.soft.modules.engine.mapper;

import cn.soft.modules.engine.entity.project.EndpointProperties;
import cn.soft.modules.engine.entity.project.ProjectModel;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @TODO 项目管理mapper
 * @Author ycl
 * @Date 2022/10/20 12:54
 * @Version 1.0
 */
@Mapper
public interface ProjectManagerMapper {

    /**
     * 根据项目ID查询项目信息
     *
     * @param projectId 项目ID
     * @return 项目信息
     */
    List<ProjectModel> queryProjectInfoByID(@Param("projectId") String projectId);

    /**
     * 查询终端的配置属性
     *
     * @param params 筛选条件
     * @return 终端配置属性
     */
    List<EndpointProperties> queryEndpointProperties(@Param("query")JSONObject params);
}
