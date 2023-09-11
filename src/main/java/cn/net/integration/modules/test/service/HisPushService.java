package cn.net.integration.modules.test.service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;

/**
 * @ClassName HisPushService
 * @Description 患者推送服务
 * @Author ycl
 * @Date 2022/11/23 13:56
 * @Version 1.0
 */
@jakarta.jws.WebService(name = "HisPushService", targetNamespace = "http://HipService.jtsoft.cn")
public interface HisPushService {

    @WebMethod
    @WebResult(name = "String")
    String invoke(@WebParam(name = "code") String code, @WebParam(name = "inData") String inData);
}
