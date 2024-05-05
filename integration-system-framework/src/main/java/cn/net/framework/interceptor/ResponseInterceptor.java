package cn.net.framework.interceptor;

import cn.net.base.core.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一返回数据格式
 */
@ControllerAdvice
public class ResponseInterceptor implements ResponseBodyAdvice<Object> {

    /**
     * 是否支持该类型
     *
     * @param returnType    返回类型
     * @param converterType 转化类型
     * @return true 支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 内容写入body
     *
     * @param body                  返回内容
     * @param returnType            返回类型
     * @param selectedContentType   类型
     * @param selectedConverterType 类型
     * @param request               请求
     * @param response              响应
     * @return 封装的返回类型
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Response) {
            return body;
        }
        return Response.success(body);
    }
}
