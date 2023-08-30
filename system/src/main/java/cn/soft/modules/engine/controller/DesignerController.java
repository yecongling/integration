package cn.soft.modules.engine.controller;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.emr.service.DesignerService;
import cn.soft.modules.engine.entity.project.Endpoint;
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

    private DesignerService designerService;

    @Autowired
    public void setDesignerService(DesignerService designerService) {
        this.designerService = designerService;
    }

    /**
     * 查询服务（根据项目ID查询其包含的终端服务）
     *
     * @param param 参数
     * @return endpoint
     */
    @PostMapping("/getEndpointService")
    public Result<List<Endpoint>> getEndpointService(@RequestBody(required = false) JSONObject param) {
        return null;
    }
}
