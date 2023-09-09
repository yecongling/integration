package cn.net.integration.engine.study.cxf.service;

/**
 * CXF服务发布关闭测试
 */
public interface CxfService {

    /**
     * 开启服务
     * @return
     */
    String openService() throws Exception;

    /**
     * 关闭服务
     * @return
     */
    String closeService() throws Exception;
}
