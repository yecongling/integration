package cn.net.engine.bean.project;

import java.io.Serializable;

/**
 * @ClassName EndpointConfig
 * @Description 端点配置类
 * @Author ycl
 * @Date 2024/5/31 上午9:47
 * @Version 1.0
 */
public class EndpointConfig implements Serializable {

    // 配置id
    private String id;
    // 配置名称
    private String name;
    // 配置标题
    private String title;
    // 提示信息
    private String tips;
    // 配置类型
    private String type;
    // 是否必填
    private boolean required;
    // 默认值
    private Object defaultValue;
    // 所属端点
    private String endpointId;
    // 应用在生产者端还是消费者端的配置
    private String appliesTo;

}
