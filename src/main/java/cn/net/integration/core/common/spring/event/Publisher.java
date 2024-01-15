package cn.net.integration.core.common.spring.event;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Producer
 * @Description 生产者，生产消息
 * @Author yeconglin
 * @Date 2024/1/15 21:38
 * @Version 1.0
 */
@Component
public class Publisher {
    // 定义日志
    private static final Logger logger = LoggerFactory.getLogger(Publisher.class);
    // 定义发送消息的组件
    private ApplicationEventPublisher publisher;

    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * 发送消息
     *
     * @throws Exception 异常信息
     */
    public void sendMsg(String username, HttpServletRequest request) throws Exception {
        // 构造登录成功的用户实体信息
        LoginEvent loginEvent = new LoginEvent(this, username, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), request);
        publisher.publishEvent(loginEvent);
        logger.info("Spring事件驱动模型-发送消息： {}", loginEvent);
    }
}
