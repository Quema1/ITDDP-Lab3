
package org.example.fitnessClub.entities;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for Subscription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Subscription"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="price" type="{https://it.nure.ua/sport}PositiveDecimal"/&gt;
 *           &lt;element name="startDate" type="{https://it.nure.ua/sport}Date"/&gt;
 *           &lt;element name="endDate" type="{https://it.nure.ua/sport}Date"/&gt;
 *           &lt;element name="coach" type="{https://it.nure.ua/sport}Coach"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="id" type="{https://it.nure.ua/sport}PositiveInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscription", namespace = "https://it.nure.ua/sport", propOrder = {
    "price",
    "startDate",
    "endDate",
    "coach"
})
public class Subscription {

    @XmlElement(namespace = "https://it.nure.ua/sport")
    protected BigDecimal price;
    @XmlElement(namespace = "https://it.nure.ua/sport")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(namespace = "https://it.nure.ua/sport")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(namespace = "https://it.nure.ua/sport")
    protected Coach coach;
    @XmlAttribute(name = "id")
    protected Integer id;

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the coach property.
     * 
     * @return
     *     possible object is
     *     {@link Coach }
     *     
     */
    public Coach getCoach() {
        return coach;
    }

    /**
     * Sets the value of the coach property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coach }
     *     
     */
    public void setCoach(Coach value) {
        this.coach = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", coach=" + coach +
                '}';
    }
}
