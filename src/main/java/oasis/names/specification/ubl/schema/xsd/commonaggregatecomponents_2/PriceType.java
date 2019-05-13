//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderableUnitFactorRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceChangeReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceTypeType;


/**
 * <p>Java-Klasse für PriceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PriceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceAmount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BaseQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceChangeReason" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OrderableUnitFactorRate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PriceList" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PricingExchangeRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceType", propOrder = {
    "priceAmount",
    "baseQuantity",
    "priceChangeReason",
    "priceTypeCode",
    "priceType",
    "orderableUnitFactorRate",
    "validityPeriod",
    "priceList",
    "allowanceCharge",
    "pricingExchangeRate"
})
public class PriceType {

    @XmlElement(name = "PriceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PriceAmountType priceAmount;
    @XmlElement(name = "BaseQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BaseQuantityType baseQuantity;
    @XmlElement(name = "PriceChangeReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PriceChangeReasonType> priceChangeReason;
    @XmlElement(name = "PriceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriceTypeCodeType priceTypeCode;
    @XmlElement(name = "PriceType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriceTypeType priceType;
    @XmlElement(name = "OrderableUnitFactorRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OrderableUnitFactorRateType orderableUnitFactorRate;
    @XmlElement(name = "ValidityPeriod")
    protected List<PeriodType> validityPeriod;
    @XmlElement(name = "PriceList")
    protected PriceListType priceList;
    @XmlElement(name = "AllowanceCharge")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "PricingExchangeRate")
    protected ExchangeRateType pricingExchangeRate;

    /**
     * Ruft den Wert der priceAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceAmountType }
     *     
     */
    public PriceAmountType getPriceAmount() {
        return priceAmount;
    }

    /**
     * Legt den Wert der priceAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceAmountType }
     *     
     */
    public void setPriceAmount(PriceAmountType value) {
        this.priceAmount = value;
    }

    /**
     * Ruft den Wert der baseQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BaseQuantityType }
     *     
     */
    public BaseQuantityType getBaseQuantity() {
        return baseQuantity;
    }

    /**
     * Legt den Wert der baseQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseQuantityType }
     *     
     */
    public void setBaseQuantity(BaseQuantityType value) {
        this.baseQuantity = value;
    }

    /**
     * Gets the value of the priceChangeReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceChangeReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceChangeReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceChangeReasonType }
     * 
     * 
     */
    public List<PriceChangeReasonType> getPriceChangeReason() {
        if (priceChangeReason == null) {
            priceChangeReason = new ArrayList<PriceChangeReasonType>();
        }
        return this.priceChangeReason;
    }

    /**
     * Ruft den Wert der priceTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceTypeCodeType }
     *     
     */
    public PriceTypeCodeType getPriceTypeCode() {
        return priceTypeCode;
    }

    /**
     * Legt den Wert der priceTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceTypeCodeType }
     *     
     */
    public void setPriceTypeCode(PriceTypeCodeType value) {
        this.priceTypeCode = value;
    }

    /**
     * Ruft den Wert der priceType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceTypeType }
     *     
     */
    public PriceTypeType getPriceType() {
        return priceType;
    }

    /**
     * Legt den Wert der priceType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceTypeType }
     *     
     */
    public void setPriceType(PriceTypeType value) {
        this.priceType = value;
    }

    /**
     * Ruft den Wert der orderableUnitFactorRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrderableUnitFactorRateType }
     *     
     */
    public OrderableUnitFactorRateType getOrderableUnitFactorRate() {
        return orderableUnitFactorRate;
    }

    /**
     * Legt den Wert der orderableUnitFactorRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderableUnitFactorRateType }
     *     
     */
    public void setOrderableUnitFactorRate(OrderableUnitFactorRateType value) {
        this.orderableUnitFactorRate = value;
    }

    /**
     * Gets the value of the validityPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validityPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidityPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getValidityPeriod() {
        if (validityPeriod == null) {
            validityPeriod = new ArrayList<PeriodType>();
        }
        return this.validityPeriod;
    }

    /**
     * Ruft den Wert der priceList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceListType }
     *     
     */
    public PriceListType getPriceList() {
        return priceList;
    }

    /**
     * Legt den Wert der priceList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceListType }
     *     
     */
    public void setPriceList(PriceListType value) {
        this.priceList = value;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    /**
     * Ruft den Wert der pricingExchangeRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRateType }
     *     
     */
    public ExchangeRateType getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    /**
     * Legt den Wert der pricingExchangeRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRateType }
     *     
     */
    public void setPricingExchangeRate(ExchangeRateType value) {
        this.pricingExchangeRate = value;
    }

}
