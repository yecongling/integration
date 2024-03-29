package cn.net.integration.modules.engine.mapper;

import cn.net.integration.modules.engine.entity.project.*;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ProjectManagerMapper extends BaseMapper<Project> {

    /**
     * 查询所有项目信息
     *
     * @param param 检索条件
     * @return 返回所有项目信息
     */
    List<Project> queryAllProject(JSONObject param);

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
