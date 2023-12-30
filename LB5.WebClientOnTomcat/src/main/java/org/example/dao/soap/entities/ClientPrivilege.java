
package org.example.dao.soap.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientPrivilege.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="ClientPrivilege"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Basic"/&gt;
 *     &lt;enumeration value="Medium"/&gt;
 *     &lt;enumeration value="Elite"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ClientPrivilege", namespace = "https://it.nure.ua/sport")
@XmlEnum
public enum ClientPrivilege {

    @XmlEnumValue("Basic")
    BASIC("Basic"),
    @XmlEnumValue("Medium")
    MEDIUM("Medium"),
    @XmlEnumValue("Elite")
    ELITE("Elite");
    private final String value;

    ClientPrivilege(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClientPrivilege fromValue(String v) {
        for (ClientPrivilege c: ClientPrivilege.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
