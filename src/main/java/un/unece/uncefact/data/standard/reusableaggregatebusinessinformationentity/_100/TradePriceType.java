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
import un.unece.uncefact.data.standard.qualifieddatatype._100.PriceTypeCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.NumericType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradePriceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradePriceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PriceTypeCodeType" minOccurs="0"/>
 *         &lt;element name="ChargeAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded"/>
 *         &lt;element name="BasisQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="MinimumQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="MaximumQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="ChangeReason" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OrderUnitConversionFactorNumeric" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}NumericType" minOccurs="0"/>
 *         &lt;element name="AppliedTradeAllowanceCharge" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAllowanceChargeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ValiditySpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/>
 *         &lt;element name="IncludedTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DeliveryTradeLocation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeLocationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TradeComparisonReferencePrice" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencePriceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AssociatedReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePriceType", propOrder = {
    "typeCode",
    "chargeAmount",
    "basisQuantity",
    "minimumQuantity",
    "maximumQuantity",
    "changeReason",
    "orderUnitConversionFactorNumeric",
    "appliedTradeAllowanceCharge",
    "validitySpecifiedPeriod",
    "includedTradeTax",
    "deliveryTradeLocation",
    "tradeComparisonReferencePrice",
    "associatedReferencedDocument"
})
public class TradePriceType {

    @XmlElement(name = "TypeCode")
    protected PriceTypeCodeType typeCode;
    @XmlElement(name = "ChargeAmount", required = true)
    protected List<AmountType> chargeAmount;
    @XmlElement(name = "BasisQuantity")
    protected QuantityType basisQuantity;
    @XmlElement(name = "MinimumQuantity")
    protected QuantityType minimumQuantity;
    @XmlElement(name = "MaximumQuantity")
    protected QuantityType maximumQuantity;
    @XmlElement(name = "ChangeReason")
    protected List<TextType> changeReason;
    @XmlElement(name = "OrderUnitConversionFactorNumeric")
    protected NumericType orderUnitConversionFactorNumeric;
    @XmlElement(name = "AppliedTradeAllowanceCharge")
    protected List<TradeAllowanceChargeType> appliedTradeAllowanceCharge;
    @XmlElement(name = "ValiditySpecifiedPeriod")
    protected SpecifiedPeriodType validitySpecifiedPeriod;
    @XmlElement(name = "IncludedTradeTax")
    protected List<TradeTaxType> includedTradeTax;
    @XmlElement(name = "DeliveryTradeLocation")
    protected List<TradeLocationType> deliveryTradeLocation;
    @XmlElement(name = "TradeComparisonReferencePrice")
    protected List<ReferencePriceType> tradeComparisonReferencePrice;
    @XmlElement(name = "AssociatedReferencedDocument")
    protected List<ReferencedDocumentType> associatedReferencedDocument;

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceTypeCodeType }
     *     
     */
    public PriceTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceTypeCodeType }
     *     
     */
    public void setTypeCode(PriceTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the chargeAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chargeAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getChargeAmount() {
        if (chargeAmount == null) {
            chargeAmount = new ArrayList<AmountType>();
        }
        return this.chargeAmount;
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
     * Ruft den Wert der minimumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * Legt den Wert der minimumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setMinimumQuantity(QuantityType value) {
        this.minimumQuantity = value;
    }

    /**
     * Ruft den Wert der maximumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getMaximumQuantity() {
        return maximumQuantity;
    }

    /**
     * Legt den Wert der maximumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setMaximumQuantity(QuantityType value) {
        this.maximumQuantity = value;
    }

    /**
     * Gets the value of the changeReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getChangeReason() {
        if (changeReason == null) {
            changeReason = new ArrayList<TextType>();
        }
        return this.changeReason;
    }

    /**
     * Ruft den Wert der orderUnitConversionFactorNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getOrderUnitConversionFactorNumeric() {
        return orderUnitConversionFactorNumeric;
    }

    /**
     * Legt den Wert der orderUnitConversionFactorNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setOrderUnitConversionFactorNumeric(NumericType value) {
        this.orderUnitConversionFactorNumeric = value;
    }

    /**
     * Gets the value of the appliedTradeAllowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appliedTradeAllowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppliedTradeAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeAllowanceChargeType }
     * 
     * 
     */
    public List<TradeAllowanceChargeType> getAppliedTradeAllowanceCharge() {
        if (appliedTradeAllowanceCharge == null) {
            appliedTradeAllowanceCharge = new ArrayList<TradeAllowanceChargeType>();
        }
        return this.appliedTradeAllowanceCharge;
    }

    /**
     * Ruft den Wert der validitySpecifiedPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public SpecifiedPeriodType getValiditySpecifiedPeriod() {
        return validitySpecifiedPeriod;
    }

    /**
     * Legt den Wert der validitySpecifiedPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public void setValiditySpecifiedPeriod(SpecifiedPeriodType value) {
        this.validitySpecifiedPeriod = value;
    }

    /**
     * Gets the value of the includedTradeTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedTradeTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedTradeTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeTaxType }
     * 
     * 
     */
    public List<TradeTaxType> getIncludedTradeTax() {
        if (includedTradeTax == null) {
            includedTradeTax = new ArrayList<TradeTaxType>();
        }
        return this.includedTradeTax;
    }

    /**
     * Gets the value of the deliveryTradeLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryTradeLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryTradeLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeLocationType }
     * 
     * 
     */
    public List<TradeLocationType> getDeliveryTradeLocation() {
        if (deliveryTradeLocation == null) {
            deliveryTradeLocation = new ArrayList<TradeLocationType>();
        }
        return this.deliveryTradeLocation;
    }

    /**
     * Gets the value of the tradeComparisonReferencePrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tradeComparisonReferencePrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTradeComparisonReferencePrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencePriceType }
     * 
     * 
     */
    public List<ReferencePriceType> getTradeComparisonReferencePrice() {
        if (tradeComparisonReferencePrice == null) {
            tradeComparisonReferencePrice = new ArrayList<ReferencePriceType>();
        }
        return this.tradeComparisonReferencePrice;
    }

    /**
     * Gets the value of the associatedReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getAssociatedReferencedDocument() {
        if (associatedReferencedDocument == null) {
            associatedReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.associatedReferencedDocument;
    }

}
