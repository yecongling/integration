package cn.soft.system.project.model;

import com.soft.common.api.vo.BaseModel;

/**
 * 项目model封装
 * 基本和数据库中项目表字段对应
 */
public class ProjectModel extends BaseModel {

    private static final long serialVersionUID = 2394196668840811356L;
    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型
     */
    private Integer projectType;

}
