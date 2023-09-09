package cn.net.integration.system.modules.engine.controller;

import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.system.modules.engine.entity.connection.DatasourceModel;
import cn.net.integration.system.modules.engine.service.IDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DataSourceController
 * @Description s数据源controller
 * @Author ycl
 * @Date 2022/11/26 09:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/datasource")
public class DataSourceController {

    private IDatasourceService datasourceService;

    @Autowired
    public void setDatasourceService(IDatasourceService datasourceService) {
        this.datasourceService = datasourceService;
    }

    /**
     * 查询数据源
     *
     * @param datasourceModel 查询条件
     * @param pageNo          页大小
     * @param pageSize        页大小
     * @return 数据
     */
    @PostMapping("/queryDatasource")
    public Result<List<DatasourceModel>> queryDatasource(DatasourceModel datasourceModel,
                                                         @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return datasourceService.queryDatasource(datasourceModel, pageNo, pageSize);
    }

    /**
     * 新增数据源
     *
     * @param model 数据源对象
     * @return 结果
     */
    @PostMapping("/addDataSource")
    public Result<Object> addDataSource(DatasourceModel model) {
        return datasourceService.addDatasource(model);
    }
}
