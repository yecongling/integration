package cn.net.framework.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @ClassName Producer
 * @Description 事件驱动中的消息生产者
 * @Author 叶丛林
 * @Date 2024/4/24 21:54
 * @Version 1.0
 */
@Component
public class Producer<T> {

    // 定义日志
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    // 定义发送消息的组件
    private final ApplicationEventPublisher publisher;

    @Autowired
    public Producer(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * 推送事件
     *
     * @param event 事件对象
     */
    public void publishEvent(BaseEvent<T> event) {
        // 构造待发送的消息
        publisher.publishEvent(event);
    }

}
