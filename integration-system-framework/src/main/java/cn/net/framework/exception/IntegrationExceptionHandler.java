package cn.net.framework.exception;

import cn.net.base.bean.SysOpr;
import cn.net.base.core.Response;
import cn.net.framework.netty.service.PushMsgService;
import cn.net.framework.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局的异常处理器
 */
@RestControllerAdvice
public class IntegrationExceptionHandler {

    // 消息推送（通过netty+websocket）
    private PushMsgService pushMsgService;

    @Autowired
    public void setPushMsgService(PushMsgService pushMsgService) {
        this.pushMsgService = pushMsgService;
    }

    // 获取上下文请求的操作员
    private ServletUtils servletUtils;

    @Autowired
    public void setServletUtils(ServletUtils servletUtils) {
        this.servletUtils = servletUtils;
    }

    /**
     * 暂时在这里处理全部的异常，后续有其他类型的异常则在这里进行扩展
     *
     * @param e 异常
     * @return 错误信息
     */
    @ExceptionHandler(Exception.class)
    public Response<Object> doException(Exception e) {
        SysOpr sysOpr = servletUtils.getSysOpr();
        if (sysOpr != null) {
            // 消息推送
            pushMsgService.pushMsgToOne(sysOpr.getUserId(), ExceptionUtils.getStackTrace(e));
        }
        // 有时候e.getMessage可能返回的是null数据，无法进行错误的判断
        String errorMsg = e.getMessage();
        if (StringUtils.isBlank(errorMsg)) {
            errorMsg = ExceptionUtils.getStackTrace(e);
        }
        return Response.error(errorMsg);
    }
}
