package cn.net.framework.netty.service;

import cn.net.framework.netty.config.NettyConfig;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName PushMsgServiceImpl
 * @Description 推送消息实现类
 * @Author ycl
 * @Date 2024/3/9下午12:53
 * @Version 1.0
 */
@Service
public class PushMsgServiceImpl implements PushMsgService{
    /**
     * 推送消息给制定用户
     *
     * @param useId 用户id
     * @param msg   消息
     */
    @Override
    public void pushMsgToOne(String useId, String msg) {
        Channel channel = NettyConfig.getChannel(useId);
        if (Objects.isNull(channel)) {
            throw new RuntimeException("未连接socket服务器");
        }
        channel.writeAndFlush(new TextWebSocketFrame(msg));
    }

    /**
     * 推送给所有用户
     *
     * @param msg 消息
     */
    @Override
    public void pushMsgToAll(String msg) {
        NettyConfig.getChannelGroup().writeAndFlush(new TextWebSocketFrame(msg));
    }
}
