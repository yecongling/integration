package cn.soft.engine.study.cxf.controller;

import cn.soft.engine.study.cxf.service.CxfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cxf")
public class CxfController {
    private CxfService cxfService;
    @Autowired
    public void setCxfService(CxfService cxfService) {
        this.cxfService = cxfService;
    }

    @RequestMapping("/openService")
    public String startService() throws Exception {
        cxfService.openService();
        System.out.println("uchu");
        return "soap服务已开启";
    }

    @RequestMapping("/closeService")
    public String closeService() throws Exception {
        cxfService.closeService();
        return "soap服务已开启";
    }
}
