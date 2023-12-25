
package org.example.ClientSimpleStandalone.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.example.ClientSimpleStandalone.generated.Client;


/**
 * <p>Java class for addPost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addPost"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://it.nure.ua/social}Post" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addClient", propOrder = {
    "client"
})
public class AddClient {

    @XmlElement(name = "Client", namespace = "https://it.nure.ua/sport")
    protected Client client;

    /**
     * Gets the value of the post property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the value of the post property.
     * 
     * @param value
     *     allowed object is
     *
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

}
