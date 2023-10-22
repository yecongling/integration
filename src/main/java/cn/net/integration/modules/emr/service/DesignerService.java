package cn.net.integration.modules.emr.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DesignerService
 * @Description 设计器业务接口
 * @Author ycl
 * @Date 2022/11/25 12:57
 * @Version 1.0
 */
public interface DesignerService {

    /**
     * 查询所有的文书种类
     * @param param 查询参数
     * @return 文书种类信息
     */
    List<Map<String, Object>> getEmrCategory(JSONObject param);
}
