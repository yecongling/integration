package cn.soft.modules.engine.controller;

import cn.soft.common.api.vo.Result;
import cn.soft.modules.engine.entity.connection.DatasourceModel;
import cn.soft.modules.engine.service.IDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/queryDatasource")
    public Result<List<DatasourceModel>> queryDatasource(DatasourceModel datasourceModel,
                                                         @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return datasourceService.queryDatasource(datasourceModel, pageNo, pageSize);
    }
}
