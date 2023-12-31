
package org.example.ClientSimpleStandalone.services;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "DAOException", targetNamespace = "https://it.nure.ua/sport/service")
public class DAOException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DAOException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DAOException_Exception(String message, DAOException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DAOException_Exception(String message, DAOException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ua.nure.it.social.service.DAOException
     */
    public DAOException getFaultInfo() {
        return faultInfo;
    }

}
