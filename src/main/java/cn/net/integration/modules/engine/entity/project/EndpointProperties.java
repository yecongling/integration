package cn.net.integration.modules.engine.entity.project;


import cn.net.integration.core.common.api.vo.BaseModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName EndpointProperties
 * @Description 端点属性配置
 * @Author ycl
 * @Date 2022/11/28 10:16
 * @Version 1.0
 */
public class EndpointProperties extends BaseModel {
    private static final long serialVersionUID = -1947498305784507756L;
    /* 终端类型名 主键 */
    private String endpointTypeName;
    /* 属性名 主键 */
    private String name;
    /* 属性类型 */
    private String type;
    /* 是否必要 */
    private Boolean required;
    /* 允许的值  主要用于下拉选择格式为  title=value|title=value title为显示标题  value为存储值 */
    private String allowedValues;
    private List<String> allowedValue;
    /* 默认的值 */
    private String defaultValue;
    /* 用于终端的哪种特定模式 */
    private String endpointModes;
    private List<String> modes;
    /*  */
    private Boolean masked;
    /* 模式必要 */
    private Boolean modeRequired;
    /* 用于哪一端 生产（IN/IN_OUT） 消费（OUT/OUT_IN）*/
    private String appliesTo;

    public String getEndpointTypeName() {
        return endpointTypeName;
    }

    public void setEndpointTypeName(String endpointTypeName) {
        this.endpointTypeName = endpointTypeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(String allowedValues) {
        this.allowedValues = allowedValues;
        if (this.allowedValues != null) {
            // 设置list数据来源
            String[] split = allowedValues.split("\\|");
            this.allowedValue = new ArrayList<>(split.length);
            Collections.addAll(this.allowedValue, split);
        }
    }

    public List<String> getAllowedValue() {
        return allowedValue;
    }

    public void setAllowedValue(List<String> allowedValue) {
        this.allowedValue = allowedValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getEndpointModes() {
        return endpointModes;
    }

    public void setEndpointModes(String endpointModes) {
        this.endpointModes = endpointModes;
        if (this.endpointModes != null) {
            // 设置list数据来源
            String[] split = endpointModes.split("\\|");
            this.modes = new ArrayList<>(split.length);
            Collections.addAll(this.modes, split);
        }
    }

    public List<String> getModes() {
        return modes;
    }

    public void setModes(List<String> modes) {
        this.modes = modes;
    }

    public Boolean getMasked() {
        return masked;
    }

    public void setMasked(Boolean masked) {
        this.masked = masked;
    }

    public Boolean getModeRequired() {
        return modeRequired;
    }

    public void setModeRequired(Boolean modeRequired) {
        this.modeRequired = modeRequired;
    }

    public String getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(String appliesTo) {
        this.appliesTo = appliesTo;
    }
}
