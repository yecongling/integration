package cn.soft.modules.engine.entity.project;

import cn.soft.common.api.vo.BaseModel;

import java.io.Serial;
import java.util.List;

/**
 * 项目model封装
 * 基本和数据库中项目表字段对应
 */
public class Project extends BaseModel {

    @Serial
    private static final long serialVersionUID = 2394196668840811356L;

    /* 用在前台的key */
    private String key;

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
    private Integer status = 0;

    /* 项目中所含的路由ID */
    private List<Route> routes;
    /* 项目中所含的终端ID */
    private List<Endpoint> endpoints;
    /* 项目包含的连线-针对第一个编辑器对象中的 */
    private List<Link> links;

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

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
