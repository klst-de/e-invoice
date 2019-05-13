//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.AllowanceChargeIdentificationCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.AllowanceChargeReasonCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.NumericType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeAllowanceChargeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeAllowanceChargeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChargeIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="SequenceNumeric" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}NumericType" minOccurs="0"/>
 *         &lt;element name="CalculationPercent" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}PercentType" minOccurs="0"/>
 *         &lt;element name="BasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/>
 *         &lt;element name="BasisQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="PrepaidIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="ActualAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UnitBasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/>
 *         &lt;element name="ReasonCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}AllowanceChargeReasonCodeType" minOccurs="0"/>
 *         &lt;element name="Reason" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}AllowanceChargeIdentificationCodeType" minOccurs="0"/>
 *         &lt;element name="CategoryTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ActualTradeCurrencyExchange" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeCurrencyExchangeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeAllowanceChargeType", propOrder = {
    "chargeIndicator",
    "id",
    "sequenceNumeric",
    "calculationPercent",
    "basisAmount",
    "basisQuantity",
    "prepaidIndicator",
    "actualAmount",
    "unitBasisAmount",
    "reasonCode",
    "reason",
    "typeCode",
    "categoryTradeTax",
    "actualTradeCurrencyExchange"
})
public class TradeAllowanceChargeType {

    @XmlElement(name = "ChargeIndicator")
    protected IndicatorType chargeIndicator;
    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "SequenceNumeric")
    protected NumericType sequenceNumeric;
    @XmlElement(name = "CalculationPercent")
    protected PercentType calculationPercent;
    @XmlElement(name = "BasisAmount")
    protected AmountType basisAmount;
    @XmlElement(name = "BasisQuantity")
    protected QuantityType basisQuantity;
    @XmlElement(name = "PrepaidIndicator")
    protected IndicatorType prepaidIndicator;
    @XmlElement(name = "ActualAmount")
    protected List<AmountType> actualAmount;
    @XmlElement(name = "UnitBasisAmount")
    protected AmountType unitBasisAmount;
    @XmlElement(name = "ReasonCode")
    protected AllowanceChargeReasonCodeType reasonCode;
    @XmlElement(name = "Reason")
    protected TextType reason;
    @XmlElement(name = "TypeCode")
    protected AllowanceChargeIdentificationCodeType typeCode;
    @XmlElement(name = "CategoryTradeTax")
    protected List<TradeTaxType> categoryTradeTax;
    @XmlElement(name = "ActualTradeCurrencyExchange")
    protected TradeCurrencyExchangeType actualTradeCurrencyExchange;

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
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der sequenceNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getSequenceNumeric() {
        return sequenceNumeric;
    }

    /**
     * Legt den Wert der sequenceNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setSequenceNumeric(NumericType value) {
        this.sequenceNumeric = value;
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
     * Ruft den Wert der basisQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getBasisQuantity() {
        return basisQuantity;
    }

    /**
     * Legt den Wert der basisQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setBasisQuantity(QuantityType value) {
        this.basisQuantity = value;
    }

    /**
     * Ruft den Wert der prepaidIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getPrepaidIndicator() {
        return prepaidIndicator;
    }

    /**
     * Legt den Wert der prepaidIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setPrepaidIndicator(IndicatorType value) {
        this.prepaidIndicator = value;
    }

    /**
     * Gets the value of the actualAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actualAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActualAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getActualAmount() {
        if (actualAmount == null) {
            actualAmount = new ArrayList<AmountType>();
        }
        return this.actualAmount;
    }

    /**
     * Ruft den Wert der unitBasisAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getUnitBasisAmount() {
        return unitBasisAmount;
    }

    /**
     * Legt den Wert der unitBasisAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setUnitBasisAmount(AmountType value) {
        this.unitBasisAmount = value;
    }

    /**
     * Ruft den Wert der reasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AllowanceChargeReasonCodeType }
     *     
     */
    public AllowanceChargeReasonCodeType getReasonCode() {
        return reasonCode;
    }

    /**
     * Legt den Wert der reasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowanceChargeReasonCodeType }
     *     
     */
    public void setReasonCode(AllowanceChargeReasonCodeType value) {
        this.reasonCode = value;
    }

    /**
     * Ruft den Wert der reason-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getReason() {
        return reason;
    }

    /**
     * Legt den Wert der reason-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setReason(TextType value) {
        this.reason = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AllowanceChargeIdentificationCodeType }
     *     
     */
    public AllowanceChargeIdentificationCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowanceChargeIdentificationCodeType }
     *     
     */
    public void setTypeCode(AllowanceChargeIdentificationCodeType value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the categoryTradeTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryTradeTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryTradeTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeTaxType }
     * 
     * 
     */
    public List<TradeTaxType> getCategoryTradeTax() {
        if (categoryTradeTax == null) {
            categoryTradeTax = new ArrayList<TradeTaxType>();
        }
        return this.categoryTradeTax;
    }

    /**
     * Ruft den Wert der actualTradeCurrencyExchange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public TradeCurrencyExchangeType getActualTradeCurrencyExchange() {
        return actualTradeCurrencyExchange;
    }

    /**
     * Legt den Wert der actualTradeCurrencyExchange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public void setActualTradeCurrencyExchange(TradeCurrencyExchangeType value) {
        this.actualTradeCurrencyExchange = value;
    }

}
