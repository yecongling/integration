package cn.net.framework.interceptor;

import cn.net.framework.redis.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义的登录拦截器，用于验证用户登录权限
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final RedisUtil redisUtil;

    @Autowired
    public LoginInterceptor(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 处理前的验证
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return 结果
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 判定request的header是否携带token，并从Redis中获取token，判定token是否失效
        String token = request.getHeader("token");
        Object o = redisUtil.get(token);
        System.out.println(o);
        if (StringUtils.isBlank(token)) {
            response.setStatus(401);
            response.getWriter().write("token已失效或不存在！请重新登录");
            return false;
        }
        // 从redis中获取数据，判定token是否有效

        // 这里先默认放过，后面实际添加验证
        return true;
    }
}
