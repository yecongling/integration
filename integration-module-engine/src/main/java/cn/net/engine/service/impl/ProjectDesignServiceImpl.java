package cn.net.engine.service.impl;

import cn.net.engine.bean.project.Project;
import cn.net.engine.mapper.ProjectDesignMapper;
import cn.net.engine.service.IProjectDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProjectDesignServiceImpl
 * @Description 项目设计实现类
 * @Author ycl
 * @Date 2024/5/9 上午9:24
 * @Version 1.0
 */
@Service
public class ProjectDesignServiceImpl implements IProjectDesignService {

    // 注入项目设计mapper
    private ProjectDesignMapper projectDesignMapper;

    @Autowired
    public void setProjectDesignMapper(ProjectDesignMapper projectDesignMapper) {
        this.projectDesignMapper = projectDesignMapper;
    }

    /**
     * 查询所有项目信息
     *
     * @param param 项目查询条件
     * @return 所有项目信息
     */
    @Override
    public List<Project> getProjects(Project param) {
        return projectDesignMapper.getAllProjects(param);
    }

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    @Override
    public Project getProjectById(String projectId) {
        return projectDesignMapper.queryProjectInfoByID(projectId);
    }

    /**
     * 新增服务信息
     *
     * @param project 项目对象
     * @return 保存结果
     */
    @Override
    public boolean addProject(Project project) {
        return projectDesignMapper.addProject(project) > 0;
    }

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    @Override
    public boolean updateProject(Project project) {
        return projectDesignMapper.updateProject(project) > 0;
    }

    /**
     * 删除菜单
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @Override
    public boolean deleteProject(String projectId) {
        return projectDesignMapper.deleteProject(projectId);
    }
}
