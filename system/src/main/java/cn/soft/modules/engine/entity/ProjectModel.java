package cn.soft.modules.engine.entity;

import cn.soft.common.api.vo.BaseModel;

/**
 * 项目model封装
 * 基本和数据库中项目表字段对应
 */
public class ProjectModel extends BaseModel {

    private static final long serialVersionUID = 2394196668840811356L;
    /**
     * 项目ID 以project_开头
     */
    private String projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型 分 1、集成项目   2、接口项目
     */
    private Integer projectType;

    /* 日志类型 */
    private Integer logType;

    /* 项目描述 */
    private String description;

    /* 项目优先级 */
    private Integer projectPriority;

    /* 项目状态  0 - 未发布   1 - 发布 */
    private Integer status;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProjectPriority() {
        return projectPriority;
    }

    public void setProjectPriority(Integer projectPriority) {
        this.projectPriority = projectPriority;
    }
}
