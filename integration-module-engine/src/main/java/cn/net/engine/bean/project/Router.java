package cn.net.engine.bean.project;

import java.io.Serializable;

/**
 * @ClassName Router
 * @Description 路由
 * @Author ycl
 * @Date 2024/5/15 上午11:00
 * @Version 1.0
 */
public class Router implements Serializable {
    // 路由ID
    private String routerId;
    // 路由名称
    private String routerName;
    // 路由地址（根据配置的服务类型和参数进行构建）
    private String routerUrl;

    // 路由类型（HTTP、SOAP、JDBC、FILE、MQ） 这里考虑改用枚举
    private String routerType;

    public String getRouterId() {
        return routerId;
    }

    public void setRouterId(String routerId) {
        this.routerId = routerId;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getRouterUrl() {
        return routerUrl;
    }

    public void setRouterUrl(String routerUrl) {
        this.routerUrl = routerUrl;
    }
}
