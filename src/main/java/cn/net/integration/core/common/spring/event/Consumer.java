package cn.net.integration.core.common.spring.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author yeconglin
 * @Date 2024/1/15 21:33
 * @Version 1.0
 */
@Component
@Async  // 允许异步执行
public class Consumer implements ApplicationListener<LoginEvent> {

    // 定义日志
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    /**
     * 监听消费信息
     *
     * @param event 事件对象
     */
    @Override
    public void onApplicationEvent(LoginEvent event) {
        // 打印日志
        logger.info("Spring事件驱动模型-接收消息： {}", event);
    }
}
