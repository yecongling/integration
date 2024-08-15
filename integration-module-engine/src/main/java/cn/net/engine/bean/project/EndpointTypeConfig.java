package cn.net.engine.bean.project;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName EndpointConfig
 * @Description 端点配置类
 * @Author ycl
 * @Date 2024/5/31 上午9:47
 * @Version 1.0
 */
public class EndpointTypeConfig implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // 类型id
    @NotEmpty(message = "端点类型配置id不能为空")
    private String id;

    @NotEmpty(message = "配置所属类型不能为空")
    private String typeId;
    // 配置名
    @NotEmpty(message = "配置名不能为空")
    private String name;

    // 配置标题
    @NotEmpty(message = "配置标题不能为空")
    private String title;

    // 描述
    private String description;

    // 配置类型，如text、input、select
    @NotEmpty(message = "配置类型不能为空")
    private String type;

    // 默认值
    private String defaultValue;

    // 可选字段，配置项（select使用）
    private String options;

    // 校验规则
    private String validationRules;

    // 适用于哪一端 producer \ consumer
    private String appliesTo;

    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;

    public @NotEmpty(message = "端点类型配置id不能为空") String getId() {
        return id;
    }

    public void setId(@NotEmpty(message = "端点类型配置id不能为空") String id) {
        this.id = id;
    }

    public @NotEmpty(message = "配置所属类型不能为空") String getTypeId() {
        return typeId;
    }

    public void setTypeId(@NotEmpty(message = "配置所属类型不能为空") String typeId) {
        this.typeId = typeId;
    }

    public @NotEmpty(message = "配置名不能为空") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "配置名不能为空") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "配置标题不能为空") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "配置标题不能为空") String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotEmpty(message = "配置类型不能为空") String getType() {
        return type;
    }

    public void setType(@NotEmpty(message = "配置类型不能为空") String type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getValidationRules() {
        return validationRules;
    }

    public void setValidationRules(String validationRules) {
        this.validationRules = validationRules;
    }

    public String getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(String appliesTo) {
        this.appliesTo = appliesTo;
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
}
