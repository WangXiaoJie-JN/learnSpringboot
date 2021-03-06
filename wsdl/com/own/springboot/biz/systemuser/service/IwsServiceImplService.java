
package com.own.springboot.biz.systemuser.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "IwsServiceImplService", targetNamespace = "http://service.systemUser.biz.springboot.own.com/", wsdlLocation = "http://localhost:8989/ws/userList2?wsdl")
public class IwsServiceImplService
    extends Service
{

    private final static URL IWSSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException IWSSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName IWSSERVICEIMPLSERVICE_QNAME = new QName("http://service.systemUser.biz.springboot.own.com/", "IwsServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8989/ws/userList2?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IWSSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        IWSSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public IwsServiceImplService() {
        super(__getWsdlLocation(), IWSSERVICEIMPLSERVICE_QNAME);
    }

    public IwsServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IWSSERVICEIMPLSERVICE_QNAME, features);
    }

    public IwsServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, IWSSERVICEIMPLSERVICE_QNAME);
    }

    public IwsServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IWSSERVICEIMPLSERVICE_QNAME, features);
    }

    public IwsServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IwsServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IwsServiceImpl
     */
    @WebEndpoint(name = "IwsServiceImplPort")
    public IwsServiceImpl getIwsServiceImplPort() {
        return super.getPort(new QName("http://service.systemUser.biz.springboot.own.com/", "IwsServiceImplPort"), IwsServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IwsServiceImpl
     */
    @WebEndpoint(name = "IwsServiceImplPort")
    public IwsServiceImpl getIwsServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.systemUser.biz.springboot.own.com/", "IwsServiceImplPort"), IwsServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IWSSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw IWSSERVICEIMPLSERVICE_EXCEPTION;
        }
        return IWSSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
