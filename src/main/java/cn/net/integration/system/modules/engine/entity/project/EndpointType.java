package cn.net.integration.system.modules.engine.entity.project;

import cn.net.integration.core.common.api.vo.BaseModel;

import java.io.Serial;
import java.util.List;

/**
 * @ClassName EndpointType
 * @Description 终端类型
 * @Author ycl
 * @Date 2022/11/26 18:28
 * @Version 1.0
 */
public class EndpointType extends BaseModel {
    @Serial
    private static final long serialVersionUID = -5325010281913695689L;

    /* 终端类型名 */
    private String name;
    /* 支持的模式（根据终端类型决定类型 IN IN_OUT OUT OUT_IN或其他） */
    private List<String> supportedMode;
    /* 对应终端类型需要的配置属性 */
    private List<EndpointProperties> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSupportedMode() {
        return supportedMode;
    }

    public void setSupportedMode(List<String> supportedMode) {
        this.supportedMode = supportedMode;
    }

    public List<EndpointProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<EndpointProperties> properties) {
        this.properties = properties;
    }
}
