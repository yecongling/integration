package cn.net.framework.netty.service;

/**
 * @ClassName PushMsgService
 * @Description 消息推送服务
 * @Author ycl
 * @Date 2024/3/9上午10:14
 * @Version 1.0
 */
public interface PushMsgService {

    /**
     * 推送消息给制定用户
     * @param useId 用户id
     * @param msg 消息
     */
    void pushMsgToOne(String useId, String msg);

    /**
     * 推送给所有用户
     * @param msg 消息
     */
    void pushMsgToAll(String msg);
}
