package cn.net.integration.modules.engine.entity.project;

import cn.net.integration.core.common.api.vo.BaseModel;

import java.io.Serial;

/**
 * @ClassName Link
 * @Description 连接实例对象
 * @Author ycl
 * @Date 2022/11/28 09:09
 * @Version 1.0
 */
public class Link extends BaseModel {
    @Serial
    private static final long serialVersionUID = 3292722748249655220L;

    /* 源节点ID */
    private String sourceID;
    /* 源节点类型 */
    private String sourceType;
    /* 源节点端口 */
    private String sourcePort;
    /* 连线类型  考虑 正常  -  错误   -   警告几类 */
    private String errorLink;
    /* 目标节点ID */
    private String targetID;
    /* 目标节点类型 */
    private String targetType;
    /* 目标端点 */
    private String targetPort;

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getErrorLink() {
        return errorLink;
    }

    public void setErrorLink(String errorLink) {
        this.errorLink = errorLink;
    }

    public String getTargetID() {
        return targetID;
    }

    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(String targetPort) {
        this.targetPort = targetPort;
    }
}
