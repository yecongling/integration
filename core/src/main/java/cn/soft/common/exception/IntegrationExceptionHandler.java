package cn.soft.common.exception;

import cn.soft.common.api.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @TODO 引擎的全局异常处理器
 * @Author ycl
 * @Date 2022/10/21 17:35
 * @Version 1.0
 */
@RestControllerAdvice
public class IntegrationExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e) {
        System.out.println("输出异常:" + e.getMessage());
        return null;
    }
}
