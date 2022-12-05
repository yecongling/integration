package cn.soft.modules.system.user.security;

import cn.soft.common.api.vo.Result;
import cn.soft.common.util.ServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AnonymousAuthenticationEntryPoint
 * @Description 匿名用户无法访问
 * @Author ycl
 * @Date 2022/12/5 11:47
 * @Version 1.0
 */
public class AnonymousAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final Logger logger = LoggerFactory.getLogger(AnonymousAuthenticationEntryPoint.class);
    /**
     * @param request 请求
     * @param response 响应
     * @param e 异常
     * @throws IOException -
     * @throws ServletException -
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.warn("用户需要登录，访问[{}]失败，AuthenticationException={}", request.getRequestURI(), e);
        ServletUtil.render(request, response, Result.error("用户需要登录"));
    }
}
