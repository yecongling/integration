package cn.soft.modules.base.service;

import cn.soft.common.api.dto.SysLog;
import cn.soft.common.system.vo.LoginUser;

/**
 * @ClassName BaseCommonService
 * @Description 基础接口
 * @Author 叶丛林
 * @Date 2022/11/3 22:08
 * @Version 1.0
 **/
public interface BaseCommonService {

    /**
     * 保存日志
     *
     * @param sysLog 日志对象
     */
    void addLog(SysLog sysLog);

    /**
     * 保存日志
     *
     * @param logContent  日志内容
     * @param logType     日志类型
     * @param operateType 操作类型
     * @param user        登录人
     */
    void addLog(String logContent, Integer logType, Integer operateType, LoginUser user);

    /**
     * 保存日志
     *
     * @param logContent  日志内容
     * @param logType     日志类型
     * @param operateType 操作类型
     */
    void addLog(String logContent, Integer logType, Integer operateType);
}
