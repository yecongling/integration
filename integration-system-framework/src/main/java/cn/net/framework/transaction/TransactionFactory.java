package cn.net.framework.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @ClassName TransactionFactory
 * @Description 全局的事务管理器
 * @Author ycl
 * @Date 2024/4/29 上午9:15
 * @Version 1.0
 */
@Component
public class TransactionFactory {

    private TransactionStatus transactionStatus;

    // 事务管理器
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public TransactionFactory(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 开启事务
     */
    public void openTransaction() {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        // 设置事务的隔离级别
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionStatus = transactionManager.getTransaction(transactionDefinition);
    }

    /**
     * 提交事务
     */
    public void commit() {
        if (transactionStatus != null) {
            transactionManager.commit(transactionStatus);
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        if (transactionStatus != null) {
            transactionManager.rollback(transactionStatus);
        }
    }
}
