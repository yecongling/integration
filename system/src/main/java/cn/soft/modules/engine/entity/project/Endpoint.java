package cn.soft.modules.engine.entity.project;

import cn.soft.common.api.vo.BaseModel;

import java.io.Serial;
import java.util.Map;

/**
 * @ClassName Endpoint
 * @Description 终端实体类
 * @Author ycl
 * @Date 2022/11/26 12:49
 * @Version 1.0
 */
public class Endpoint extends BaseModel {
    @Serial
    private static final long serialVersionUID = -4983389133257246176L;
    /* 终端ID 构成格式endpoint_type_id type是终端类型 */
    private String endpointId;
    /* 终端名 */
    private String endpointName;
    /* 描述 */
    private String description;
    /* 终端类型 soap  http  等 */
    private EndpointType type;
    /* 模式  IN IN_OUT  OUT OUT_IN */
    private String mode;
    /* 终端的配置属性 */
    private Map<String, Object> properties;
    /* 终端的重试策略配置 */
    private Map<String, Object> retryPolicy;

}
