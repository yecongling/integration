package cn.net.integration.modules.engine.controller;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.engine.service.DBResourceService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DBResourceController
 * @Description 数据库资源controller
 * @Author yeconglin
 * @Date 2024/1/9 19:34
 * @Version 1.0
 */
@RestController
@RequestMapping("/db")
public class DBResourceController {
    private DBResourceService dbResourceService;

    @Autowired
    public void setDbResourceService(DBResourceService dbResourceService) {
        this.dbResourceService = dbResourceService;
    }

    /**
     * 查询数据库资源（分页查询）
     *
     * @param param    查询参数
     * @param pageNo   分页数
     * @param pageSize 分页大小
     * @return 数据库资源
     */
    @GetMapping("/getAll")
    public Result<Object> queryDBResource(@RequestParam JSONObject param,
                                          @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        List<Map<String, Object>> maps = dbResourceService.queryDBResource(param, pageNo, pageSize);
        return Result.success(maps);
    }
}
