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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActivityTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActivityTypeType;


/**
 * <p>Java-Klasse für ContractingActivityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ContractingActivityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActivityTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActivityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractingActivityType", propOrder = {
    "activityTypeCode",
    "activityType"
})
public class ContractingActivityType {

    @XmlElement(name = "ActivityTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActivityTypeCodeType activityTypeCode;
    @XmlElement(name = "ActivityType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActivityTypeType activityType;

    /**
     * Ruft den Wert der activityTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ActivityTypeCodeType }
     *     
     */
    public ActivityTypeCodeType getActivityTypeCode() {
        return activityTypeCode;
    }

    /**
     * Legt den Wert der activityTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityTypeCodeType }
     *     
     */
    public void setActivityTypeCode(ActivityTypeCodeType value) {
        this.activityTypeCode = value;
    }

    /**
     * Ruft den Wert der activityType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ActivityTypeType }
     *     
     */
    public ActivityTypeType getActivityType() {
        return activityType;
    }

    /**
     * Legt den Wert der activityType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityTypeType }
     *     
     */
    public void setActivityType(ActivityTypeType value) {
        this.activityType = value;
    }

}
