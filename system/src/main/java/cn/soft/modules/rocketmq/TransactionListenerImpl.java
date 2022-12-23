package cn.soft.modules.rocketmq;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @ClassName TransactionListenerImpl
 * @Description TODO
 * @Author ycl
 * @Date 2022/12/23 16:22
 * @Version 1.0
 */
public class    TransactionListenerImpl implements TransactionListener {
    /**
     * When send transactional prepare(half) message succeed, this method will be invoked to execute local transaction.
     *
     * @param msg Half(prepare) message
     * @param arg Custom business parameter
     * @return Transaction state
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // 执行本地事务，判断半事务消息是提交还是回滚
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    /**
     * When no response to prepare(half) message. broker will send check message to check the transaction status, and this
     * method will be invoked to get local transaction status.
     *
     * @param msg Check message
     * @return Transaction state
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        // 当上面的本地事务执行后未提交到mq时，mq像生产者发送的本地事务状态检测，
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
