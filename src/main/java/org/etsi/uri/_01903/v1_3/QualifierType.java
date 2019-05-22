//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für QualifierType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="QualifierType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OIDAsURI"/&gt;
 *     &lt;enumeration value="OIDAsURN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "QualifierType")
@XmlEnum
public enum QualifierType {

    @XmlEnumValue("OIDAsURI")
    OID_AS_URI("OIDAsURI"),
    @XmlEnumValue("OIDAsURN")
    OID_AS_URN("OIDAsURN");
    private final String value;

    QualifierType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QualifierType fromValue(String v) {
        for (QualifierType c: QualifierType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
