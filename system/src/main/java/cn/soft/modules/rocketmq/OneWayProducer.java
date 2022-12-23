package cn.soft.modules.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @ClassName OneWayProducer
 * @Description TODO
 * @Author ycl
 * @Date 2022/12/23 11:35
 * @Version 1.0
 */
public class OneWayProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("produce_group");
        // 设置nameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动producer实例
        producer.start();
        // 创建消息并指定topic，tag和消息体
        for (int i = 0; i < 100; i++) {
            // 创建消息
            Message message = new Message("Topic", "tagA", ("Hello Rocket" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息到broker
            producer.sendOneway(message);
        }
        // 发送完毕过后，关闭producer实例
        producer.shutdown();
    }
}
