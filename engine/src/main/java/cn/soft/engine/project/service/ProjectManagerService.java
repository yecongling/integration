package cn.soft.engine.project.service;

import cn.soft.engine.project.model.ProjectModel;
import com.soft.common.api.vo.Result;

/**
 * @TODO 项目管理service接口
 * @Author ycl
 * @Date 2022/10/20 12:57
 * @Version 1.0
 */
public interface ProjectManagerService {

    /**
     * 新增服务信息
     *
     * @param projectModel 项目对象
     * @return 保存结果
     */
    Result<Object> addProject(ProjectModel projectModel);

    /**
     * 根据项目ID查找项目信息 并发布该服务
     *
     * @param projectId 项目ID
     * @return 发布服务结果
     */
    Result<Object> publishService(String projectId);

}
