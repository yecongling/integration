package cn.net.framework.config;

import cn.net.base.bean.SysOpr;
import cn.net.base.utils.SpringContextUtils;
import cn.net.framework.redis.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @ClassName UserArgResolver
 * @Description 用于支持在controller的方法中设置操作员参数
 * @Author ycl
 * @Date 2024/5/11 上午9:27
 * @Version 1.0
 */
public class UserArgResolver implements HandlerMethodArgumentResolver {

    private final RedisUtil redisUtil;

    public UserArgResolver(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }
    /**
     * Whether the given {@linkplain MethodParameter method parameter} is
     * supported by this resolver.
     *
     * @param parameter the method parameter to check
     * @return {@code true} if this resolver supports the supplied parameter;
     * {@code false} otherwise
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return SysOpr.class.isAssignableFrom(parameter.getParameterType());
    }

    /**
     * Resolves a method parameter into an argument value from a given request.
     * A {@link ModelAndViewContainer} provides access to the model for the
     * request. A {@link WebDataBinderFactory} provides a way to create
     * a {@link WebDataBinder} instance when needed for data binding and
     * type conversion purposes.
     *
     * @param parameter     the method parameter to resolve. This parameter must
     *                      have previously been passed to {@link #supportsParameter} which must
     *                      have returned {@code true}.
     * @param mavContainer  the ModelAndViewContainer for the current request
     * @param webRequest    the current request
     * @param binderFactory a factory for creating {@link WebDataBinder} instances
     * @return the resolved argument value, or {@code null} if not resolvable
     * @throws Exception in case of errors with the preparation of argument values
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 从request中获取token，然后在redis中获取该操作员
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("用户未进行登录，请登录后再进行下一步操作！");
        }
        Object o = redisUtil.get(token);
        if (ObjectUtils.isEmpty(o)) {
            throw new RuntimeException("用户会话已失效，请重新登录！");
        }
        return (SysOpr) o;
    }
}
