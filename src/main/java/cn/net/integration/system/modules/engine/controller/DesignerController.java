package cn.net.integration.system.modules.engine.controller;

import cn.net.integration.system.modules.engine.entity.project.Endpoint;
import cn.net.integration.system.modules.engine.service.IDesignerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DesignerController
 * @Description 设计器controller
 * @Author 叶丛林
 * @Date 2023/8/30 21:53
 * @Version 1.0
 **/
@RestController(value = "engineDesigner")
@RequestMapping("/engine/designer")
public class DesignerController {

    private IDesignerService designerService;

    @Autowired
    public void setDesignerService(IDesignerService designerService) {
        this.designerService = designerService;
    }

    /**
     * 查询服务（根据项目ID查询其包含的终端服务）
     *
     * @param param 参数
     * @return endpoint
     */
    @PostMapping("/getEndpointService")
    public List<Endpoint> getEndpointService(@RequestBody JSONObject param) {
        return designerService.getEndpoints(param);
    }
}
