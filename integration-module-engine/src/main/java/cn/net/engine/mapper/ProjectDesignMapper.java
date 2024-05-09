package cn.net.engine.mapper;

import cn.net.engine.bean.project.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ProjectDesignMapper
 * @Description 项目设计mapper
 * @Author ycl
 * @Date 2024/5/9 上午9:18
 * @Version 1.0
 */
@Mapper
public interface ProjectDesignMapper {
    /**
     * 查询所有项目信息
     *
     * @param param 检索条件
     * @return 返回所有项目信息
     */
    List<Project> getAllProjects(Project param);

    /**
     * 添加项目
     *
     * @param project 项目信息
     * @return 结果
     */
    int addProject(Project project);

    /**
     * 更新项目
     *
     * @param project 项目信息
     * @return 结果
     */
    int updateProject(Project project);

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 结果
     */
    boolean deleteProject(@Param("id") String projectId);


    /**
     * 根据项目ID查询项目信息
     *
     * @param id 项目ID
     * @return 项目信息
     */
    Project queryProjectInfoByID(@Param("id") String id);
}
