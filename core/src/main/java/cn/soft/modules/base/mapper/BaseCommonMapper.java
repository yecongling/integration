package cn.soft.modules.base.mapper;

import cn.soft.common.api.dto.SysLog;
import org.apache.ibatis.annotations.Param;

/**
 * @Description 通用基础mapper
 * @Author ycl
 * @Date 2022-10-09 16:34
 * @Version 1.0
 */
public interface BaseCommonMapper {

    /**
     * 保存日志
     * @param dto 日志对象
     */
    void saveLog(@Param("dto") SysLog dto);
}
