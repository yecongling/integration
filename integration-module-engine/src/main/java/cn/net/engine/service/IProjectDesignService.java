package cn.net.engine.service;

import cn.net.engine.bean.project.Project;
import cn.net.engine.bean.project.Router;

import java.util.List;

/**
 * @ClassName IProjectDesignService
 * @Description 项目设计service
 * @Author ycl
 * @Date 2024/5/9 上午9:23
 * @Version 1.0
 */
public interface IProjectDesignService {
    /**
     * 查询所有项目信息
     *
     * @param param 项目查询条件
     * @return 所有项目信息
     */
    List<Project> getProjects(Project param);

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    Project getProjectById(String projectId);

    /**
     * 新增服务信息
     *
     * @param project 项目对象
     * @return 保存结果
     */
    boolean addProject(Project project);

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    boolean updateProject(Project project);

    /**
     * 删除菜单
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    boolean deleteProject(String projectId);

    /**
     * 改变服务状态 例如服务发布、取消发布
     *
     * @param project 服务信息
     * @return 返回改变后的状态 成功 - 失败（带异常信息）
     */
    Object changeServiceStatus(Project project);

    /**
     * 构建路由的执行流程数据
     *
     * @param projectId 项目id
     * @return 流程数据
     */
    List<Router> buildRouterProcess(String projectId);
}
