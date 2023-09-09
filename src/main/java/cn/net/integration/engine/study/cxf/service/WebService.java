package cn.net.integration.engine.study.cxf.service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;

@jakarta.jws.WebService(name = "CxfService", targetNamespace = "http://cxfService.body.com")
public interface WebService {

    @WebMethod
    @WebResult(name = "String")
    String sayHello(@WebParam(name = "talk") String talk);
}
