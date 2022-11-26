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
}
