
package org.example.entities;

import jakarta.xml.bind.annotation.*;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clients" type="{https://it.nure.ua/sport}Clients"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clients"
})
@XmlRootElement(name = "fitnessClub", namespace = "https://it.nure.ua/sport")
public class FitnessClub {

    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected Clients clients;

    /**
     * Gets the value of the clients property.
     * 
     * @return
     *     possible object is
     *     {@link Clients }
     *     
     */
    public Clients getClients() {
        return clients;
    }

    /**
     * Sets the value of the clients property.
     * 
     * @param value
     *     allowed object is
     *     {@link Clients }
     *     
     */
    public void setClients(Clients value) {
        this.clients = value;
    }

    @Override
    public String toString() {
        return "FitnessClub{" +
                "clients=" + clients +
                '}';
    }
}
