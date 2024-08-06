package cn.net.framework.interceptor;

import cn.net.base.core.Response;
import cn.net.framework.redis.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义的登录拦截器，用于验证用户登录权限
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final RedisUtil redisUtil;

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
        Response<String> result = new Response<>();
        if (StringUtils.isBlank(token)) {
            result.setCode(403);
            result.setMessage("用户未登录，无法进行业务请求！");
            response.getWriter().write(JSONObject.toJSONString(result));
            return false;
        }
        // 从redis中获取数据，判定token是否有效
        if (!redisUtil.hasKey(token)) {
            result.setCode(403);
            result.setMessage("会话已失效！请重新登录");
            response.getWriter().write(JSONObject.toJSONString(result));
            return false;
        }
        // 这里先默认放过，后面实际添加验证
        return true;
    }
}
