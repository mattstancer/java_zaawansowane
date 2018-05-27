package com.company;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface JaxWsServer extends ObjectSerializer {
    @WebMethod
    public Employeess SerializeObject(@WebParam String token) throws Exception;

}