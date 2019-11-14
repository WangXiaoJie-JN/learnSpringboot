
package com.own.springboot.biz.systemuser.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.own.springboot.biz.systemuser.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUserListResponse_QNAME = new QName("http://service.systemUser.biz.springboot.own.com/", "getUserListResponse");
    private final static QName _GetUserList_QNAME = new QName("http://service.systemUser.biz.springboot.own.com/", "getUserList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.own.springboot.biz.systemuser.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserListResponse }
     * 
     */
    public GetUserListResponse createGetUserListResponse() {
        return new GetUserListResponse();
    }

    /**
     * Create an instance of {@link GetUserList }
     * 
     */
    public GetUserList createGetUserList() {
        return new GetUserList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemUser.biz.springboot.own.com/", name = "getUserListResponse")
    public JAXBElement<GetUserListResponse> createGetUserListResponse(GetUserListResponse value) {
        return new JAXBElement<GetUserListResponse>(_GetUserListResponse_QNAME, GetUserListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemUser.biz.springboot.own.com/", name = "getUserList")
    public JAXBElement<GetUserList> createGetUserList(GetUserList value) {
        return new JAXBElement<GetUserList>(_GetUserList_QNAME, GetUserList.class, null, value);
    }

}
