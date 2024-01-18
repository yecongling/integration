package cn.net.integration.core.common.config;

import cn.net.integration.core.common.api.vo.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName ResponseAdvice
 * @Description 统一返回格式
 * @Author 叶丛林
 * @Date 2023/9/1 22:37
 * @Version 1.0
 **/
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

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
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}
