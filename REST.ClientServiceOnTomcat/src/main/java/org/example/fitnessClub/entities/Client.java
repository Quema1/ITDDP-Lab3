
package org.example.fitnessClub.entities;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Client complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Client"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{https://it.nure.ua/sport}NonEmptyString"/&gt;
 *         &lt;element name="surname" type="{https://it.nure.ua/sport}NonEmptyString"/&gt;
 *         &lt;element name="photo" type="{https://it.nure.ua/sport}NonEmptyString"/&gt;
 *         &lt;element name="dateOfBirth" type="{https://it.nure.ua/sport}Date"/&gt;
 *         &lt;element name="homeAddress" type="{https://it.nure.ua/sport}NonEmptyString"/&gt;
 *         &lt;element name="currentSubscription" type="{https://it.nure.ua/sport}Subscription"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{https://it.nure.ua/sport}PositiveInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Client", namespace = "https://it.nure.ua/sport", propOrder = {
    "name",
    "surname",
    "photo",
    "dateOfBirth",
    "currentSubscription"
})
public class Client {

    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected String name;
    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected String surname;
    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected String photo;
    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected Subscription currentSubscription;
    @XmlAttribute(name = "id")
    protected Integer id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the homeAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */

    /**
     * Gets the value of the currentSubscription property.
     * 
     * @return
     *     possible object is
     *     {@link Subscription }
     *     
     */
    public Subscription getCurrentSubscription() {
        return currentSubscription;
    }

    /**
     * Sets the value of the currentSubscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscription }
     *     
     */
    public void setCurrentSubscription(Subscription value) {
        this.currentSubscription = value;
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
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", photo='" + photo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", currentSubscription=" + currentSubscription +
                '}';
    }
}
