package cn.soft.modules.engine.entity.project;

import cn.soft.common.api.vo.BaseModel;

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
    /* 属性名 主键 */
    private String name;
    /* 属性类型 */
    private String type;
    /* 是否必要 */
    private Boolean required;
    /* 允许的值  主要用于下拉选择 */
    private List<String> allowedValues;
    /* 默认的值 */
    private String defaultValue;
    /* 用于终端的哪种特定模式 */
    private List<String> endpointModes;
    /*  */
    private Boolean masked;
    /* 模式必要 */
    private Boolean modeRequired;
    /* 用于哪一端 生产（IN/IN_OUT） 消费（OUT/OUT_IN）*/
    private String appliesTo;

}
