package cn.soft.system.engine.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 * @ClassName HisPushService
 * @Description 患者推送服务
 * @Author ycl
 * @Date 2022/11/23 13:56
 * @Version 1.0
 */
@javax.jws.WebService(name = "HisPushService", targetNamespace = "http://HipService.jtsoft.cn")
public interface HisPushService {

    @WebMethod
    @WebResult(name = "String")
    String invoke(@WebParam(name = "code") String code, @WebParam(name = "inData") String inData);
}
