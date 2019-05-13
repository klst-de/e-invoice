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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionReportIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalConsumedQuantityType;


/**
 * <p>Java-Klasse für ConsumptionReportReferenceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionReportReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionReportID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalConsumedQuantity"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Period"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionReportReferenceType", propOrder = {
    "consumptionReportID",
    "consumptionType",
    "consumptionTypeCode",
    "totalConsumedQuantity",
    "period"
})
public class ConsumptionReportReferenceType {

    @XmlElement(name = "ConsumptionReportID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ConsumptionReportIDType consumptionReportID;
    @XmlElement(name = "ConsumptionType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeType consumptionType;
    @XmlElement(name = "ConsumptionTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeCodeType consumptionTypeCode;
    @XmlElement(name = "TotalConsumedQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TotalConsumedQuantityType totalConsumedQuantity;
    @XmlElement(name = "Period", required = true)
    protected PeriodType period;

    /**
     * Ruft den Wert der consumptionReportID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionReportIDType }
     *     
     */
    public ConsumptionReportIDType getConsumptionReportID() {
        return consumptionReportID;
    }

    /**
     * Legt den Wert der consumptionReportID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionReportIDType }
     *     
     */
    public void setConsumptionReportID(ConsumptionReportIDType value) {
        this.consumptionReportID = value;
    }

    /**
     * Ruft den Wert der consumptionType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionTypeType }
     *     
     */
    public ConsumptionTypeType getConsumptionType() {
        return consumptionType;
    }

    /**
     * Legt den Wert der consumptionType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionTypeType }
     *     
     */
    public void setConsumptionType(ConsumptionTypeType value) {
        this.consumptionType = value;
    }

    /**
     * Ruft den Wert der consumptionTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionTypeCodeType }
     *     
     */
    public ConsumptionTypeCodeType getConsumptionTypeCode() {
        return consumptionTypeCode;
    }

    /**
     * Legt den Wert der consumptionTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionTypeCodeType }
     *     
     */
    public void setConsumptionTypeCode(ConsumptionTypeCodeType value) {
        this.consumptionTypeCode = value;
    }

    /**
     * Ruft den Wert der totalConsumedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalConsumedQuantityType }
     *     
     */
    public TotalConsumedQuantityType getTotalConsumedQuantity() {
        return totalConsumedQuantity;
    }

    /**
     * Legt den Wert der totalConsumedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalConsumedQuantityType }
     *     
     */
    public void setTotalConsumedQuantity(TotalConsumedQuantityType value) {
        this.totalConsumedQuantity = value;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPeriod(PeriodType value) {
        this.period = value;
    }

}
