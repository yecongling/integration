package cn.soft.system.project.mapper;

import cn.soft.system.project.model.ProjectModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @TODO 项目管理mapper
 * @Author ycl
 * @Date 2022/10/20 12:54
 * @Version 1.0
 */
@Repository
public interface ProjectManagerMapper {

    /**
     * 根据项目ID查询项目信息
     *
     * @param projectId 项目ID
     * @return 项目信息
     */
    List<ProjectModel> queryProjectInfoByID(@Param("projectId") String projectId);
}
