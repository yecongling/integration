package cn.net.framework.interceptor;

import cn.net.framework.security.DecryptedHttpInputMessage;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @ClassName DecryptRequestBodyAdvice
 * @Description 后端解密（使用了@requestBody注解标明的参数都是需要走这里来解密的）
 * @Author ycl
 * @Date 2024/8/5 下午5:26
 * @Version 1.0
 */
@Component
@ControllerAdvice
public class DecryptRequestBodyAdvice implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 支持所有请求
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        try {
            // 获取请求头中的加密判定，决定是否需要解密
            HttpHeaders headers = inputMessage.getHeaders();
            // 如果配置不解密，则不进行解密处理，默认是需要解密处理
            if ( "0".equals(headers.getFirst("encrypt")) ) {
                return inputMessage;
            }
            return new DecryptedHttpInputMessage(inputMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 返回解密的请求体
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
