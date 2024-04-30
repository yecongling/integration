package cn.net.base.service;

/**
 * @ClassName BaseCommonService
 * @Description 基础service接口，主要提供像日志记录功能
 * @Author ycl
 * @Date 2024/4/30 上午10:58
 * @Version 1.0
 */
public interface BaseCommonService {

    /**
     * 保存日志
     *
     * @param log 日志内容
     */
    void addLog(String log);
}
