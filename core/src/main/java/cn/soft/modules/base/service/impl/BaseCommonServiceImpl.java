package cn.soft.modules.base.service.impl;

import cn.soft.common.api.dto.SysLog;
import cn.soft.common.system.vo.LoginUser;
import cn.soft.modules.base.service.BaseCommonService;
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
    @Override
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
    @Override
    public void addLog(String logContent, Integer logType, Integer operateType, LoginUser user) {

    }

    /**
     * 保存日志
     *
     * @param logContent  日志内容
     * @param logType     日志类型
     * @param operateType 操作类型
     */
    @Override
    public void addLog(String logContent, Integer logType, Integer operateType) {

    }
}
