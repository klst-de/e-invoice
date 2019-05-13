//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;


/**
 * <p>Java-Klasse für TradePaymentPenaltyTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradePaymentPenaltyTermsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasisDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="BasisPeriodMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="BasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/>
 *         &lt;element name="CalculationPercent" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}PercentType" minOccurs="0"/>
 *         &lt;element name="ActualPenaltyAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePaymentPenaltyTermsType", propOrder = {
    "basisDateTime",
    "basisPeriodMeasure",
    "basisAmount",
    "calculationPercent",
    "actualPenaltyAmount"
})
public class TradePaymentPenaltyTermsType {

    @XmlElement(name = "BasisDateTime")
    protected DateTimeType basisDateTime;
    @XmlElement(name = "BasisPeriodMeasure")
    protected MeasureType basisPeriodMeasure;
    @XmlElement(name = "BasisAmount")
    protected AmountType basisAmount;
    @XmlElement(name = "CalculationPercent")
    protected PercentType calculationPercent;
    @XmlElement(name = "ActualPenaltyAmount")
    protected AmountType actualPenaltyAmount;

    /**
     * Ruft den Wert der basisDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getBasisDateTime() {
        return basisDateTime;
    }

    /**
     * Legt den Wert der basisDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setBasisDateTime(DateTimeType value) {
        this.basisDateTime = value;
    }

    /**
     * Ruft den Wert der basisPeriodMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getBasisPeriodMeasure() {
        return basisPeriodMeasure;
    }

    /**
     * Legt den Wert der basisPeriodMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setBasisPeriodMeasure(MeasureType value) {
        this.basisPeriodMeasure = value;
    }

    /**
     * Ruft den Wert der basisAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getBasisAmount() {
        return basisAmount;
    }

    /**
     * Legt den Wert der basisAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setBasisAmount(AmountType value) {
        this.basisAmount = value;
    }

    /**
     * Ruft den Wert der calculationPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PercentType }
     *     
     */
    public PercentType getCalculationPercent() {
        return calculationPercent;
    }

    /**
     * Legt den Wert der calculationPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PercentType }
     *     
     */
    public void setCalculationPercent(PercentType value) {
        this.calculationPercent = value;
    }

    /**
     * Ruft den Wert der actualPenaltyAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getActualPenaltyAmount() {
        return actualPenaltyAmount;
    }

    /**
     * Legt den Wert der actualPenaltyAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setActualPenaltyAmount(AmountType value) {
        this.actualPenaltyAmount = value;
    }

}
