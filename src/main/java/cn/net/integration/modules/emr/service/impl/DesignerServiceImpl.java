package cn.net.integration.modules.emr.service.impl;

import cn.net.integration.modules.emr.entity.Designer;
import cn.net.integration.modules.emr.mapper.EmrDesignerMapper;
import cn.net.integration.modules.emr.service.DesignerService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DesignerServiceImpl
 * @Description 设计器实现类
 * @Author ycl
 * @Date 2022/11/26 10:07
 * @Version 1.0
 */
@Service
public class DesignerServiceImpl extends ServiceImpl<EmrDesignerMapper, Designer> implements DesignerService {

    /**
     * 查询所有的文书种类
     *
     * @param param 查询参数
     * @return 文书种类信息
     */
    @Override
    public List<Map<String, Object>> getEmrCategory(JSONObject param) {

        return null;
    }
}
