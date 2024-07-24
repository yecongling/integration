package cn.net.system.controller;

import cn.net.base.core.Response;
import cn.net.framework.redis.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SessionController
 * @Description 会话controller，目的是为了用户在操作过程中，用于延长会话有效期
 * @Author ycl
 * @Date 2024/7/24 上午9:30
 * @Version 1.0
 */
@RestController
public class SessionController {

    // redis操作的工具类
    private RedisUtil redisUtil;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 延长会话（这里的延长是redis中key的有效期）
     * @param request 请求
     * @return 结果
     */
    @RequestMapping
    public Response<Object> extendSession(HttpServletRequest request) {
        // 从请求中获取token
        String token = request.getHeader("token");
        Object o = redisUtil.get(token);
        if (o == null) {
            // 未取到操作员直接返回错误，提示会话失效（前端处理 - 跳转到登录界面）
            return Response.error("会话已失效，请重新登录！");
        }
        // 延长有效期
        redisUtil.expire(token, 1800);
        return Response.success(o);
    }

}
