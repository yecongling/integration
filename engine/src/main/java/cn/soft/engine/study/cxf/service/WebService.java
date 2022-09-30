package cn.soft.engine.study.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

@javax.jws.WebService(name = "CxfService", targetNamespace = "http://cxfService.body.com")
public interface WebService {

    @WebMethod
    @WebResult(name = "String")
    String sayHello(@WebParam(name = "talk") String talk);
}
