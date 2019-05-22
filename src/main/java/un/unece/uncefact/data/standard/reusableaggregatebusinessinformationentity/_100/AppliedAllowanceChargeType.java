//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für AppliedAllowanceChargeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AppliedAllowanceChargeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActualAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="ReasonCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="CalculationPercent" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}PercentType" minOccurs="0"/&gt;
 *         &lt;element name="BasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="ChargeIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType"/&gt;
 *         &lt;element name="CategoryAppliedTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}AppliedTaxType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppliedAllowanceChargeType", propOrder = {
    "actualAmount",
    "description",
    "reasonCode",
    "calculationPercent",
    "basisAmount",
    "chargeIndicator",
    "categoryAppliedTax"
})
public class AppliedAllowanceChargeType {

    @XmlElement(name = "ActualAmount")
    protected AmountType actualAmount;
    @XmlElement(name = "Description")
    protected TextType description;
    @XmlElement(name = "ReasonCode")
    protected CodeType reasonCode;
    @XmlElement(name = "CalculationPercent")
    protected PercentType calculationPercent;
    @XmlElement(name = "BasisAmount")
    protected AmountType basisAmount;
    @XmlElement(name = "ChargeIndicator", required = true)
    protected IndicatorType chargeIndicator;
    @XmlElement(name = "CategoryAppliedTax")
    protected AppliedTaxType categoryAppliedTax;

    /**
     * Ruft den Wert der actualAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getActualAmount() {
        return actualAmount;
    }

    /**
     * Legt den Wert der actualAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setActualAmount(AmountType value) {
        this.actualAmount = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDescription(TextType value) {
        this.description = value;
    }

    /**
     * Ruft den Wert der reasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getReasonCode() {
        return reasonCode;
    }

    /**
     * Legt den Wert der reasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setReasonCode(CodeType value) {
        this.reasonCode = value;
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
     * Ruft den Wert der chargeIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getChargeIndicator() {
        return chargeIndicator;
    }

    /**
     * Legt den Wert der chargeIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setChargeIndicator(IndicatorType value) {
        this.chargeIndicator = value;
    }

    /**
     * Ruft den Wert der categoryAppliedTax-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AppliedTaxType }
     *     
     */
    public AppliedTaxType getCategoryAppliedTax() {
        return categoryAppliedTax;
    }

    /**
     * Legt den Wert der categoryAppliedTax-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AppliedTaxType }
     *     
     */
    public void setCategoryAppliedTax(AppliedTaxType value) {
        this.categoryAppliedTax = value;
    }

}
