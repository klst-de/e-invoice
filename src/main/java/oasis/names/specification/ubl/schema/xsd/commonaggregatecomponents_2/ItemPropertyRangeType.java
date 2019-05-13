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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumValueType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumValueType;


/**
 * <p>Java-Klasse für ItemPropertyRangeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ItemPropertyRangeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumValue" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemPropertyRangeType", propOrder = {
    "minimumValue",
    "maximumValue"
})
public class ItemPropertyRangeType {

    @XmlElement(name = "MinimumValue", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumValueType minimumValue;
    @XmlElement(name = "MaximumValue", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumValueType maximumValue;

    /**
     * Ruft den Wert der minimumValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumValueType }
     *     
     */
    public MinimumValueType getMinimumValue() {
        return minimumValue;
    }

    /**
     * Legt den Wert der minimumValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumValueType }
     *     
     */
    public void setMinimumValue(MinimumValueType value) {
        this.minimumValue = value;
    }

    /**
     * Ruft den Wert der maximumValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumValueType }
     *     
     */
    public MaximumValueType getMaximumValue() {
        return maximumValue;
    }

    /**
     * Legt den Wert der maximumValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumValueType }
     *     
     */
    public void setMaximumValue(MaximumValueType value) {
        this.maximumValue = value;
    }

}
