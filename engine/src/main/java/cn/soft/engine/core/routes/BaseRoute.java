package cn.soft.engine.core.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * @TODO 基础路由类
 * @Author ycl
 * @Date 2022/10/20 12:39
 * @Version 1.0
 */
public abstract class BaseRoute extends RouteBuilder {

    /* 路由ID 大多是和项目ID一致，目的是为了区分每一条路由（每一个项目发布的一个服务可以理解成发布了一个路由） */
    protected String routerID;

    /**
     * <b>Called on initialization to build the routes using the fluent builder syntax.</b>
     * <p/>
     * This is a central method for RouteBuilder implementations to implement the routes using the Java fluent builder
     * syntax.
     *
     * @throws Exception can be thrown during configuration
     */
    @Override
    public abstract void configure() throws Exception;
}
