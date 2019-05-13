//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeekDayCodeType;


/**
 * <p>Java-Klasse für ServiceFrequencyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ServiceFrequencyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeekDayCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceFrequencyType", propOrder = {
    "weekDayCode"
})
public class ServiceFrequencyType {

    @XmlElement(name = "WeekDayCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected WeekDayCodeType weekDayCode;

    /**
     * Ruft den Wert der weekDayCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeekDayCodeType }
     *     
     */
    public WeekDayCodeType getWeekDayCode() {
        return weekDayCode;
    }

    /**
     * Legt den Wert der weekDayCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeekDayCodeType }
     *     
     */
    public void setWeekDayCode(WeekDayCodeType value) {
        this.weekDayCode = value;
    }

}
