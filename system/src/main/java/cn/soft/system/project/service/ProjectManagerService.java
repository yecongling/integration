package cn.soft.system.project.service;

import cn.soft.common.api.vo.Result;
import cn.soft.system.project.entity.ProjectModel;
import com.alibaba.fastjson.JSONObject;

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
    Result<JSONObject> addProject(ProjectModel projectModel);

    /**
     * 修改项目信息
     *
     * @param projectModel 项目对象
     * @return 修改结果
     */
    Result<JSONObject> updateProject(ProjectModel projectModel);

    /**
     * 根据项目ID查找项目信息 并发布该服务
     *
     * @param projectId 项目ID
     * @return 发布服务结果
     */
    Result<JSONObject> publishService(String projectId);

}
