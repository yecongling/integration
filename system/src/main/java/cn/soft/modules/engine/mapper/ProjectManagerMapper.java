package cn.soft.modules.engine.mapper;

import cn.soft.modules.engine.entity.project.EndpointProperties;
import cn.soft.modules.engine.entity.project.ProjectModel;
import cn.soft.modules.engine.entity.project.Route;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ProjectManagerMapper
 * @Description 项目管理Mapper
 * @Author 叶丛林
 * @Date 2022/10/20 12:57
 * @Version 1.0
 **/
@Mapper
public interface ProjectManagerMapper {

    /**
     * 查询所有项目信息
     *
     * @param param 检索条件
     * @return 返回所有项目信息
     */
    List<ProjectModel> queryAllProject(JSONObject param);

    /**
     * 根据项目ID查询项目信息
     *
     * @param projectId 项目ID
     * @return 项目信息
     */
    ProjectModel queryProjectInfoByID(@Param("projectId") String projectId);

    /**
     * 查询终端的配置属性
     *
     * @param params 筛选条件
     * @return 终端配置属性
     */
    List<EndpointProperties> queryEndpointProperties(@Param("query") JSONObject params);

    /**
     * 通过路由ID查询路由信息（可能包含多个路由）
     *
     * @param routeIDs 路由ID
     * @return 流程数据
     */
    List<Route> queryRoutes(List<String> routeIDs);
}
