
package org.example.ClientSimpleStandalone.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.example.ClientSimpleStandalone.generated.Client;


/**
 * <p>Java class for findByTitleResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findByTitleResponse"&gt;
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
@XmlType(name = "findByTitleResponse", propOrder = {
    "_return"
})
public class FindByIdResponse {

    @XmlElement(name = "return", namespace = "https://it.nure.ua/social", nillable = true)
    protected Client _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link org.example.ClientSimpleStandalone.generated.Client }
     *     
     */
    public Client getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.example.ClientSimpleStandalone.generated.Client }
     *     
     */
    public void setReturn(org.example.ClientSimpleStandalone.generated.Client value) {
        this._return = value;
    }

}
