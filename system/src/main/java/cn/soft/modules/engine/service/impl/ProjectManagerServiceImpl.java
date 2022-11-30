package cn.soft.modules.engine.service.impl;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.base.service.impl.BaseCommonServiceImpl;
import cn.soft.modules.engine.entity.project.EndpointProperties;
import cn.soft.modules.engine.entity.project.ProjectModel;
import cn.soft.modules.engine.mapper.ProjectManagerMapper;
import cn.soft.modules.engine.service.ProjectManagerService;
import com.alibaba.fastjson.JSONObject;
import org.apache.camel.CamelContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProjectManagerServiceImpl
 * @Description 项目管理服务实现类
 * @Author 叶丛林
 * @Date 2022/10/20 12:57
 * @Version 1.0
 **/
@Service
public class ProjectManagerServiceImpl extends BaseCommonServiceImpl implements ProjectManagerService, BeanFactoryAware {

    /**
     * 注入camel运行的上下文环境，发布项目时，向该环境中添加运行路由
     */
    private CamelContext context;

    @Autowired
    public void setContext(CamelContext context) {
        this.context = context;
    }

    /**
     * bean工厂
     */
    private DefaultListableBeanFactory beanFactory;

    /* 注入项目管理mapper */
    private ProjectManagerMapper projectManagerMapper;

    @Autowired
    public void setProjectManagerMapper(ProjectManagerMapper projectManagerMapper) {
        this.projectManagerMapper = projectManagerMapper;
    }

    /**
     * 查询所有项目信息
     *
     * @param projectModel 项目查询条件
     * @return 所有项目信息
     */
    @Override
    public Result<ProjectModel> queryProjects(ProjectModel projectModel) {
        return null;
    }

    /**
     * 新增服务信息
     *
     * @param projectModel 项目对象
     * @return 保存结果
     */
    @Override
    public Result<JSONObject> addProject(ProjectModel projectModel) {
        return null;
    }

    /**
     * 修改项目信息
     *
     * @param projectModel 项目对象
     * @return 修改结果
     */
    @Override
    public Result<JSONObject> updateProject(ProjectModel projectModel) {
        return null;
    }

    /**
     * 发布服务
     *
     * @param projectId 项目编号
     * @return 发布的结果
     */
    public Result<JSONObject> publishService(String projectId) {
        return null;
    }

    /**
     * 查询终端属性配置
     *
     * @return 返回终端的属性配置
     */
    @Override
    public Result<List<EndpointProperties>> queryEndpointProperties() {
        JSONObject param = new JSONObject();
        List<EndpointProperties> properties = projectManagerMapper.queryEndpointProperties(param);
        return Result.OK(properties);
    }

    /**
     * 注入bean工厂，作用是动态发布bean（如动态编译的cxf类，注册为bean，作为camel 的endpoint使用bean）
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     *                    The bean can immediately call methods on the factory.
     * @throws BeansException bean异常
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
}
