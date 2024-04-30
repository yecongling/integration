package cn.net.system.event;

import cn.net.base.constant.CommonConstant;
import cn.net.base.service.BaseCommonService;
import cn.net.framework.event.BaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName Consumer
 * @Description 消息消费
 * @Author 叶丛林
 * @Date 2024/4/24 22:00
 * @Version 1.0
 */
@Component
@Async // 允许异步执行
public class Consumer implements ApplicationListener<BaseEvent<Object>> {

    // 定义日志
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private BaseCommonService baseCommonService;

    @Autowired
    public void setBaseCommonService(BaseCommonService baseCommonService) {
        this.baseCommonService = baseCommonService;
    }

    /**
     * @param event 事件传输的对象
     */
    @Override
    public void onApplicationEvent(BaseEvent event) {
        // 判断操作类型
        // 如果是登录
        if (CommonConstant.LOGIN_OPERATION.equals(event.getOperation())) {
            // 登录操作，记录登录日志
            Object data = event.getData();
            // @TODO 暂时这么写
            baseCommonService.addLog(data.toString());
            return;
        }

        logger.info("Spring事件驱动模型-接收消息：{}", event);
    }
}
