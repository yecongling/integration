package cn.soft.modules.engine.entity.project;

import cn.soft.common.api.vo.BaseModel;

import java.util.List;

/**
 * @ClassName Route
 * @Description 路由定义model
 * @Author ycl
 * @Date 2022/11/26 11:34
 * @Version 1.0
 */
public class Route extends BaseModel {
    private static final long serialVersionUID = 3272368134709013107L;

    /* 路由ID 以route_开头 */
    private String routeId;
    /* 路由名称 */
    private String routeName;
    /* 描述 */
    private String description;
    /* 启用调试模式 */
    private Boolean debug;
    /* 启用深度克隆 */
    private Boolean deepClone;
    /* 处理策略 分 SEQUENTIAL（顺序处理） PARALLEL（并行处理） */
    private String processingStrategy;
    /* 处理线程数 */
    private Integer threadCount;
    /* 在页面上的位置 x */
    private Integer x;
    /* 在页面上的位置 y */
    private Integer y;
    /* 路由内部包含的节点 */
    private List<String> nodes;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public Boolean getDeepClone() {
        return deepClone;
    }

    public void setDeepClone(Boolean deepClone) {
        this.deepClone = deepClone;
    }

    public String getProcessingStrategy() {
        return processingStrategy;
    }

    public void setProcessingStrategy(String processingStrategy) {
        this.processingStrategy = processingStrategy;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
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

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
