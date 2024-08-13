package cn.net.engine.bean.project;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName EndpointType
 * @Description 端点类型
 * @Author ycl
 * @Date 2024/6/5 下午4:12
 * @Version 1.0
 */
public class EndpointType implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    // 端点类型名称
    @NotEmpty(message = "端点类型不能为空")
    private String name;
    // 支持的模式
    @NotEmpty(message = "支持的模式不能为空，可选项为IN、IN_OUT、OUT、OUT_IN")
    private String supportedModes;
    // 包含的配置项
    private List<EndpointTypeConfig> properties;
    // 子节点
    private List<EndpointType> children;

    // 父节点
    private String parentId;

    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupportedModes() {
        return supportedModes;
    }

    public void setSupportedModes(String supportedModes) {
        this.supportedModes = supportedModes;
    }

    public List<EndpointTypeConfig> getProperties() {
        return properties;
    }

    public void setProperties(List<EndpointTypeConfig> properties) {
        this.properties = properties;
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

    public List<EndpointType> getChildren() {
        return children;
    }

    public void setChildren(List<EndpointType> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
