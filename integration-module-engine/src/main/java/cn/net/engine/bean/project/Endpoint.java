package cn.net.engine.bean.project;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Endpoint
 * @Description 端点配置
 * @Author ycl
 * @Date 2024/5/31 上午9:20
 * @Version 1.0
 */
public class Endpoint implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // endpoint id
    private String id;
    // endpoint名称
    @NotEmpty(message = "端点名称不能为空")
    private String name;
    // endpoint类型(不使用枚举的原因是后期有可能加其他类型，不能再枚举中定死)
    @NotEmpty(message = "端点类型不能为空")
    private String type;
    // endpoint模式
    @NotNull(message = "端点模式不能为空")
    private String mode;
    // endpoint描述
    private String description;

    // 所属项目
    private String projectId;

    // 端点状态 1-正常运行 2-部分异常 3 - 异常运行 4 - 未运行
    private Integer status = 4;

    // 删除标记
    private boolean delFlag = false;

    // 配置数据
    private String configs;

    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;
    /**
     * 配置列表
     */
    private List<EndpointConfig> configList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotEmpty String name) {
        this.name = name;
    }

    public @NotEmpty String getType() {
        return type;
    }

    public void setType(@NotEmpty String type) {
        this.type = type;
    }

    public @NotEmpty String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getConfigs() {
        return configs;
    }

    public void setConfigs(String configs) {
        this.configs = configs;
    }

    public List<EndpointConfig> getConfigList() {
        return configList;
    }

    public void setConfigList(List<EndpointConfig> configList) {
        this.configList = configList;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
