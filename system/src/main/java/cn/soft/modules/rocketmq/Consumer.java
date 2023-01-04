package cn.soft.modules.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author ycl
 * @Date 2022/12/23 10:25
 * @Version 1.0
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        // 指定NameSrv地址
        consumer.setNamesrvAddr("localhost:9876");
        // 订阅topic
        consumer.subscribe("Topic", "*");
        // 重试消费次数
        consumer.setMaxReconsumeTimes(10);
        // 设置消费模式（可以集群消费和广播消费）
        consumer.setMessageModel(MessageModel.CLUSTERING);
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragely());
        // 注册回调函数，处理消息（这里是并发消费）
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            MessageExt messageExt = msgs.get(0);

            System.out.printf("%s Receive New Message: %s %n", Thread.currentThread().getName(), msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // 如果想顺序消费，需要注册顺序消费接口
//        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> null);
        // 启动消费者
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
