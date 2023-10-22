package cn.net.integration.modules.emr.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DesignerMapper
 * @Description 设计器mapper
 * @Author ycl
 * @Date 2022/11/25 12:57
 * @Version 1.0
 */
@Mapper
public interface EmrDesignerMapper {

    /**
     * 查询所有的文书分类
     * @param param 查询参数
     * @return 分类信息
     */
    List<Map<String, Object>> getEmrCategory(@Param("param")JSONObject param);
}
