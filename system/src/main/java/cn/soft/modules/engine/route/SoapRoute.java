package cn.soft.modules.engine.route;

import cn.soft.engine.core.routes.BaseRoute;
import cn.soft.modules.engine.mapper.ProjectManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SoapRoute
 * @Description 支持soap请求用的路由
 * @Author ycl
 * @Date 2022/11/30 10:52
 * @Version 1.0
 */
@Component
public class SoapRoute extends BaseRoute {

    /* 注入项目管理mapper */
    private ProjectManagerMapper projectManagerMapper;

    @Autowired
    public void setProjectManagerMapper(ProjectManagerMapper projectManagerMapper) {
        this.projectManagerMapper = projectManagerMapper;
    }

    /**
     *  soap路由流程配置
     *
     * @throws Exception can be thrown during configuration
     */
    @Override
    public void configure() throws Exception {
        // 根据路由ID查询出整个流程的执行顺序数据
        List<Map<String, Object>> routes = projectManagerMapper.queryRoute(this.getRouterID());

    }
}
