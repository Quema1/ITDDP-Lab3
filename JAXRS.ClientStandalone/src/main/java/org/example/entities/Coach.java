
package org.example.entities;
import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;


/**
 * <p>Java class for Coach complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Coach"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="name" type="{https://it.nure.ua/sport}NonEmptyString"/&gt;
 *         &lt;element name="surname" type="{https://it.nure.ua/sport}NonEmptyString"/&gt;
 *         &lt;element name="experience" type="{https://it.nure.ua/sport}Experience"/&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="id" type="{https://it.nure.ua/sport}PositiveInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Coach", namespace = "https://it.nure.ua/sport", propOrder = {

})
public class Coach {

    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected String name;
    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected String surname;
    @XmlElement(namespace = "https://it.nure.ua/sport", required = true)
    protected BigDecimal experience;
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
     * Gets the value of the experience property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExperience() {
        return experience;
    }

    /**
     * Sets the value of the experience property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExperience(BigDecimal value) {
        this.experience = value;
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
        return "Coach{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", experience=" + experience +
                '}';
    }
}
