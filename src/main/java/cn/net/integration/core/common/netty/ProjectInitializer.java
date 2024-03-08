package cn.net.integration.core.common.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProjectInitializer
 * @Description TODO
 * @Author yeconglin
 * @Date 2024/3/8 22:42
 * @Version 1.0
 */
@Component
public class ProjectInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 初始化channel
     *
     * @param socketChannel socket
     * @throws Exception exception
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

    }
}
