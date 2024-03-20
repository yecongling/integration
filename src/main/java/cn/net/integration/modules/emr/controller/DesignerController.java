package cn.net.integration.modules.emr.controller;

import cn.net.integration.core.common.api.vo.Response;
import cn.net.integration.modules.emr.service.DesignerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DesignerController
 * @Description 设计器controller
 * @Author ycl
 * @Date 2022/11/25 12:56
 * @Version 1.0
 */
@RestController(value = "emrDesigner")
@RequestMapping("/emr/designer")
public class DesignerController {

    private DesignerService designerService;

    @Autowired
    public void setDesignerService(DesignerService designerService) {
        this.designerService = designerService;
    }

    /**
     * 查询所有的文书种类信息
     *
     * @param param 查询参数
     * @return 文书种类信息
     */
    @PostMapping("/getCategory")
    public Response<Object> getEmrCategory(@RequestBody JSONObject param) {
        List<Map<String, Object>> category = designerService.getEmrCategory(param);

        return null;
    }
}
