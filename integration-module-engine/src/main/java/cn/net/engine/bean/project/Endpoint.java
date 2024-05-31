package cn.net.engine.bean.project;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;
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
    @NotEmpty(message = "端点模式不能为空")
    private EndpointModeEnum mode;
    // endpoint描述
    private String description;

    // 所属项目
    private String projectId;

    // 端点状态
    private String status;

    // 配置
    List<EndpointConfig> configs;

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

    public @NotEmpty EndpointModeEnum getMode() {
        return mode;
    }

    public void setMode(@NotEmpty EndpointModeEnum mode) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EndpointConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<EndpointConfig> configs) {
        this.configs = configs;
    }
}
