package cn.soft.modules.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @ClassName SyncProducer
 * @Description TODO
 * @Author ycl
 * @Date 2022/12/23 09:59
 * @Version 1.0
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("produce_group");
        // 设置nameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 设置消息同步发送失败时的重试次数，默认为2
        producer.setRetryTimesWhenSendFailed(2);
        // 设置消息发送超时时间，默认3000ms
        producer.setSendMsgTimeout(3000);
        // 启动producer实例
        producer.start();
        // 创建消息并指定topic，tag和消息体
        for (int i = 0; i < 100; i++) {
            // 创建消息
            Message message = new Message("Topic", "tagA", ("Hello Rocket" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息到broker
            SendResult send = producer.send(message);
            // 通过SendResult判定消息是否发送成功
            System.out.printf("%s%n", send);
        }
        // 发送完毕过后，关闭producer实例
        producer.shutdown();
    }
}
