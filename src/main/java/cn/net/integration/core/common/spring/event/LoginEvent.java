package cn.net.integration.core.common.spring.event;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @ClassName LoginEvent
 * @Description 登录成功后的事件
 * @Author yeconglin
 * @Date 2024/1/15 21:29
 * @Version 1.0
 */
public class LoginEvent extends ApplicationEvent implements Serializable {
    private String username;
    private String loginTime;
    private HttpServletRequest request;

    public LoginEvent(Object source, String username, String loginTime, HttpServletRequest request) {
        super(source);
        this.username = username;
        this.loginTime = loginTime;
        this.request = request;
    }
}
