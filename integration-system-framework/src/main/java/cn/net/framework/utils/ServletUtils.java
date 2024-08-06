package cn.net.framework.utils;

import cn.net.base.bean.SysOpr;
import cn.net.base.utils.SpringContextUtils;
import cn.net.framework.redis.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName ServletUtils
 * @Description 获取当前请求上下文中的操作员 可通过这种方式获取  也可通过controller层的参数进行注入，其实现请见 {@link cn.net.framework.config.UserArgResolver}
 * @Author ycl
 * @Date 2024/5/11 上午9:50
 * @Version 1.0
 */
@Component
public class ServletUtils {

    // redis操作的工具类
    private RedisUtil redisUtil;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 获取当前请求下的操作员
     * @return 系统操作员
     */
    public SysOpr getSysOpr() {
        // 从request中获取token，然后在redis中获取该操作员
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        String token = request.getHeader("token");
        // 如果是登录地址进来，这里是获取不到操作员的（这里是mybatis拦截器那里可能会拦截登录的sql取操作员）
        String requestURI = request.getRequestURI();
        if ("/integration/login".equals(requestURI)) {
            return null;
        }
        Object o = redisUtil.get(token);
        if (ObjectUtils.isEmpty(o)) {
            // 如果没取到，直接抛出异常，阻止进行下一步操作
            throw new RuntimeException("用户为进行登录或会话已失效，请重新登录进行操作");
        }
        return (SysOpr) o;
    }
}
