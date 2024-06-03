package cn.net.engine.bean.project;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName EndpointConfig
 * @Description 端点配置类
 * @Author ycl
 * @Date 2024/5/31 上午9:47
 * @Version 1.0
 */
public class EndpointConfig implements Serializable {

    // 配置名称
    private String name;
    // 配置标题
    private String title;
    // 提示信息
    private String tips;
    // 配置类型
    private String type;
    // 是否必填
    private boolean required;
    // 默认值
    private String defaultValue;
    // 允许值
    private String allowedValues;
    // 所属端点类型
    private String endpointType;
    // 所属端点模式
    private String endpointMode;
    // 应用在生产者端还是消费者端的配置
    private String appliesTo;
    // 模式需要
    private int modeRequired;
    // 标记
    private int masked;

    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getEndpointType() {
        return endpointType;
    }

    public void setEndpointType(String endpointType) {
        this.endpointType = endpointType;
    }

    public String getEndpointMode() {
        return endpointMode;
    }

    public void setEndpointMode(String endpointMode) {
        this.endpointMode = endpointMode;
    }

    public String getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(String appliesTo) {
        this.appliesTo = appliesTo;
    }

    public String getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(String allowedValues) {
        this.allowedValues = allowedValues;
    }

    public int getModeRequired() {
        return modeRequired;
    }

    public void setModeRequired(int modeRequired) {
        this.modeRequired = modeRequired;
    }

    public int getMasked() {
        return masked;
    }

    public void setMasked(int masked) {
        this.masked = masked;
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
