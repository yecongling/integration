package cn.net.integration.modules.engine.entity.project;

import cn.net.integration.core.common.api.vo.BaseModel;

import java.io.Serial;
import java.util.Map;

/**
 * @ClassName Node
 * @Description 节点定义（主要是路由内部的组件定义-包括自己外部的端点）
 * @Author ycl
 * @Date 2022/11/26 12:50
 * @Version 1.0
 */
public class Node extends BaseModel {
    @Serial
    private static final long serialVersionUID = 6182673725006132140L;
    /* 节点ID */
    private String nodeId;
    /* 节点名 */
    private String nodeName;
    /* 节点类型 NODE（组件-主要的类型） INPUT_PORT（输入节点） OUTPUT_PORT（输出节点） 后面两个是针对路由内部的存储 */
    private String type;
    /* 次类型 如果type=NODE 则subType为对应组件的类型（如groovy脚本组件、filter消息过滤组件等），否则为null，则表示是路由自己的端点 */
    private String subType;
    /* 组件的属性配置 */
    private Map<String, Object> properties;

    /* 组件的位置 */
    private Integer x;
    private Integer y;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
