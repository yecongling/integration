package cn.soft.modules.engine.entity.project;

import cn.soft.common.api.vo.BaseModel;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EndpointType
 * @Description 终端类型
 * @Author ycl
 * @Date 2022/11/26 18:28
 * @Version 1.0
 */
public class EndpointType extends BaseModel {
    private static final long serialVersionUID = -5325010281913695689L;

    /* 终端类型名 */
    private String name;
    /* 对应终端类型需要的配置属性 */
    private List<Map<String, Object>> properties;
    /* 支持的模式（根据终端类型决定类型 IN IN_OUT OUT OUT_IN） */
    private List<String> supportedMode;

}
