package cn.soft.engine.study.springboot.controller;

import cn.soft.engine.study.springboot.router.SpringbootRouter;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootController {

    private CamelContext camelContext;

    @Autowired
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @RequestMapping("/openSpringboot")
    public String openCamel() throws Exception {
        camelContext.addRoutes(new SpringbootRouter());
        return "开启springboot路由成功";
    }

}
