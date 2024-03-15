package cn.net.integration.core.common.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.core.common.netty.service.PushMsgService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 消息推送服务
    private PushMsgService pushMsgService;

    @Autowired
    public void setPushMsgService(PushMsgService pushMsgService) {
        this.pushMsgService = pushMsgService;
    }

    /**
     * 处理空指针返回
     *
     * @param e 空指针
     * @return 错误信息
     */
    @ExceptionHandler(NullPointerException.class)
    public Result<Object> doNullPointerException(NullPointerException e) {
        pushMsgService.pushMsgToOne("", ExceptionUtils.getStackTrace(e));
        return Result.error("空指针异常" + e.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param e 异常
     * @return 返回消息
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> doException(Exception e) {
        pushMsgService.pushMsgToOne("", ExceptionUtils.getStackTrace(e));
        return Result.error(e.getMessage());
    }

    /**
     * 未登录异常
     *
     * @param e 异常
     * @return 数据
     */
    @ExceptionHandler(NotLoginException.class)
    public Result<Object> noLoginException(NotLoginException e) {
        pushMsgService.pushMsgToOne("", ExceptionUtils.getStackTrace(e));
        return new Result<>(403, e.getMessage());
    }
}
