package cn.net.integration.modules.engine.service;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.modules.engine.entity.project.*;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 项目管理service接口
 * @Author ycl
 * @Date 2022/10/20 12:57
 * @Version 1.0
 */
public interface IProjectManagerService extends IService<Project> {

    /**
     * 查询所有项目信息
     *
     * @param param 项目查询条件
     * @return 所有项目信息
     */
    Response<List<Project>> queryProjects(JSONObject param);

    /**
     * 通过项目ID查询项目信息（包括项目包含的终端、路由、组件、连线）
     *
     * @param projectId 项目ID
     * @return 项目model
     */
    Response<Project> queryProjectById(String projectId);

    /**
     * 新增服务信息
     *
     * @param project 项目对象
     * @return 保存结果
     */
    Response<String> addProject(Project project);

    /**
     * 修改项目信息
     *
     * @param project 项目对象
     * @return 修改结果
     */
    Response<Object> updateProject(Project project);

    /**
     * 删除菜单
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    Response<Object> deleteProject(String projectId);

    /**
     * 根据项目ID查找项目信息 并发布该服务
     *
     * @param projectId 项目ID
     * @param status    状态 是发布服务还是取消  还是半启动
     * @return 发布服务结果
     */
    Response<JSONObject> publishService(String projectId, Integer status);

}
