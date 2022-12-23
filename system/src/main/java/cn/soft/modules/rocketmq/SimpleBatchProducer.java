package cn.soft.modules.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SimpleBatchProducer
 * @Description 简单地批量发送消息
 * @Author ycl
 * @Date 2022/12/23 15:17
 * @Version 1.0
 */
public class SimpleBatchProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("ScheduledMessageProducer");
        // 设置nameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 设置消息同步发送失败时的重试次数，默认为2
        producer.setRetryTimesWhenSendFailed(2);
        // 设置消息发送超时时间，默认3000ms
        producer.setSendMsgTimeout(3000);
        // 启动producer实例
        producer.start();
        // 创建消息并指定topic，tag和消息体
        Message message1 = new Message("wonderland", "wonderland", ("Hello Rocket1").getBytes(RemotingHelper.DEFAULT_CHARSET));
        Message message2 = new Message("wonderland", "wonderland", ("Hello Rocket2").getBytes(RemotingHelper.DEFAULT_CHARSET));
        Message message3 = new Message("wonderland", "wonderland", ("Hello Rocket3").getBytes(RemotingHelper.DEFAULT_CHARSET));
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        // 发送消息
        producer.send(messages);
        // 发送完毕过后，关闭producer实例
        producer.shutdown();
    }
}
