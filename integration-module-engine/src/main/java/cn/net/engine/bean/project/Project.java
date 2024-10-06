package cn.net.engine.bean.project;

import cn.net.base.bean.BaseModel;

import java.io.Serial;

/**
 * @ClassName Project
 * @Description 项目设计bean
 * @Author ycl
 * @Date 2024/5/9 上午9:28
 * @Version 1.0
 */
public class Project extends BaseModel {

    @Serial
    private static final long serialVersionUID = 2394196668840811356L;

    /**
     * 项目ID 以project_开头
     */
    private String id;

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

    /* 项目优先级 1-10*/
    private Integer projectPriority;

    /* 项目状态  0 - 全部停止   1 - 部分已启动  2 - 全部启动 */
    private Integer status = 1;
    /* 删除标记 1、删除 0、未删除 删除的数据放置在回收站 */
    private Integer delFlag = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
