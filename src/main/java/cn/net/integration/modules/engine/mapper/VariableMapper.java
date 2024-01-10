package cn.net.integration.modules.engine.mapper;

import cn.net.integration.modules.engine.entity.resource.VariableModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName VariableMapper
 * @Description 变量定义mapper
 * @Author 叶丛林
 * @Date 2022/11/24 21:49
 * @Version 1.0
 **/
@Mapper
public interface VariableMapper extends BaseMapper<VariableModel> {

}
