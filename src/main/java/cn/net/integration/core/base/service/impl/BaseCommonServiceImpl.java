package cn.net.integration.core.base.service.impl;

import cn.net.integration.core.base.service.BaseCommonService;
import cn.net.integration.core.common.api.dto.SysLog;
import cn.net.integration.core.common.system.vo.LoginUser;
import org.springframework.stereotype.Service;

/**
 * @ClassName BaseCommonServiceImpl
 * @Description TODO
 * @Author 叶丛林
 * @Date 2022/11/3 22:10
 * @Version 1.0
 **/
@Service
public class BaseCommonServiceImpl implements BaseCommonService {
    /**
     * 保存日志
     *
     * @param sysLog 日志对象
     */
    public void addLog(SysLog sysLog) {

    }

    /**
     * 保存日志
     *
     * @param logContent  日志内容
     * @param logType     日志类型
     * @param operateType 操作类型
     * @param user        登录人
     */
    public void addLog(String logContent, Integer logType, Integer operateType, LoginUser user) {

    }

    /**
     * 保存日志
     *
     * @param logContent  日志内容
     * @param logType     日志类型
     * @param operateType 操作类型
     */
    public void addLog(String logContent, Integer logType, Integer operateType) {

    }
}
