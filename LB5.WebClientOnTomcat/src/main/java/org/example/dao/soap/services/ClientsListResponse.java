
package org.example.dao.soap.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.example.dao.soap.entities.Clients;


/**
 * <p>Java class for newPostsListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="newPostsListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://it.nure.ua/social}return" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientsListResponse", propOrder = {
    "_return"
})
public class ClientsListResponse {

    @XmlElement(name = "return", namespace = "https://it.nure.ua/sport", nillable = true)
    protected org.example.dao.soap.entities.Clients  _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link org.example.dao.soap.entities.Clients }
     *     
     */
    public org.example.dao.soap.entities.Clients  getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.example.dao.soap.entities.Clients }
     *     
     */
    public void setReturn(org.example.dao.soap.entities.Clients value) {
        this._return = value;
    }

}
