package cn.net.integration.core.base.controller;

import cn.net.integration.core.common.netty.service.PushMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author ycl
 * @Date 2024/3/13下午12:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/push")
public class TestController {

    PushMsgService pushMsgService;
    @Autowired
    public void setPushMsgService(PushMsgService pushMsgService) {
        this.pushMsgService = pushMsgService;
    }

    /**
     * 推送消息到具体客户端
     */
    @GetMapping("/{uid}")
    public void pushOne(@PathVariable String uid) {
        pushMsgService.pushMsgToOne(uid, "hello----------------------");
    }

    /**
     * 推送消息到具体客户端
     */
    @GetMapping("/pushAll")
    public void pushAll() {
        pushMsgService.pushMsgToAll("hello----------------------");
    }
}
