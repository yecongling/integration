package cn.soft.modules.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.PullStatus;
import org.apache.rocketmq.common.message.MessageQueue;

/**
 * @ClassName PullConsumer
 * @Description TODO
 * @Author ycl
 * @Date 2022/12/26 16:02
 * @Version 1.0
 */
public class PullConsumer {
    public static void main(String[] args) throws Exception{
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("group");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.start();
        // 构造需要拉取的队列（也可以通过下面的方式获取）
//        Set<MessageQueue> queues = consumer.fetchSubscribeMessageQueues("Topic");
        MessageQueue queue = new MessageQueue();
        queue.setQueueId(0);
        queue.setTopic("Topic");
        queue.setBrokerName("指定Broker");
        // 消费位点
        long offset = 26;
        // 拉取消息
        PullResult pull = consumer.pull(queue, "*", offset, 32);
        if (pull.getPullStatus().equals(PullStatus.FOUND)) {
            // 更新消费位点
            consumer.updateConsumeOffset(queue, pull.getNextBeginOffset());
        }
        consumer.shutdown();
    }
}
