//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TimeReferenceCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.NumericType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.RateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeTaxType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeTaxType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CalculatedAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TaxTypeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="ExemptionReason" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="CalculatedRate" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}RateType" minOccurs="0"/&gt;
 *         &lt;element name="CalculationSequenceNumeric" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}NumericType" minOccurs="0"/&gt;
 *         &lt;element name="BasisQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="BasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="UnitBasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="LineTotalBasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AllowanceChargeBasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CategoryCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TaxCategoryCodeType" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CurrencyCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Jurisdiction" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CustomsDutyIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="ExemptionReasonCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="TaxBasisAllowanceRate" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}RateType" minOccurs="0"/&gt;
 *         &lt;element name="TaxPointDate" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateType" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="InformationAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CategoryName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DueDateTypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TimeReferenceCodeType" minOccurs="0"/&gt;
 *         &lt;element name="RateApplicablePercent" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}PercentType" minOccurs="0"/&gt;
 *         &lt;element name="SpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ServiceSupplyTradeCountry" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeCountryType" minOccurs="0"/&gt;
 *         &lt;element name="BuyerRepayableTaxSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" minOccurs="0"/&gt;
 *         &lt;element name="SellerPayableTaxSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" minOccurs="0"/&gt;
 *         &lt;element name="SellerRefundableTaxSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" minOccurs="0"/&gt;
 *         &lt;element name="BuyerDeductibleTaxSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" minOccurs="0"/&gt;
 *         &lt;element name="BuyerNonDeductibleTaxSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" minOccurs="0"/&gt;
 *         &lt;element name="PlaceApplicableTradeLocation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeLocationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeTaxType", propOrder = {
    "calculatedAmount",
    "typeCode",
    "exemptionReason",
    "calculatedRate",
    "calculationSequenceNumeric",
    "basisQuantity",
    "basisAmount",
    "unitBasisAmount",
    "lineTotalBasisAmount",
    "allowanceChargeBasisAmount",
    "categoryCode",
    "currencyCode",
    "jurisdiction",
    "customsDutyIndicator",
    "exemptionReasonCode",
    "taxBasisAllowanceRate",
    "taxPointDate",
    "type",
    "informationAmount",
    "categoryName",
    "dueDateTypeCode",
    "rateApplicablePercent",
    "specifiedTradeAccountingAccount",
    "serviceSupplyTradeCountry",
    "buyerRepayableTaxSpecifiedTradeAccountingAccount",
    "sellerPayableTaxSpecifiedTradeAccountingAccount",
    "sellerRefundableTaxSpecifiedTradeAccountingAccount",
    "buyerDeductibleTaxSpecifiedTradeAccountingAccount",
    "buyerNonDeductibleTaxSpecifiedTradeAccountingAccount",
    "placeApplicableTradeLocation"
})
public class TradeTaxType {

    @XmlElement(name = "CalculatedAmount")
    protected List<AmountType> calculatedAmount;
    @XmlElement(name = "TypeCode")
    protected TaxTypeCodeType typeCode;
    @XmlElement(name = "ExemptionReason")
    protected TextType exemptionReason;
    @XmlElement(name = "CalculatedRate")
    protected RateType calculatedRate;
    @XmlElement(name = "CalculationSequenceNumeric")
    protected NumericType calculationSequenceNumeric;
    @XmlElement(name = "BasisQuantity")
    protected QuantityType basisQuantity;
    @XmlElement(name = "BasisAmount")
    protected List<AmountType> basisAmount;
    @XmlElement(name = "UnitBasisAmount")
    protected List<AmountType> unitBasisAmount;
    @XmlElement(name = "LineTotalBasisAmount")
    protected List<AmountType> lineTotalBasisAmount;
    @XmlElement(name = "AllowanceChargeBasisAmount")
    protected List<AmountType> allowanceChargeBasisAmount;
    @XmlElement(name = "CategoryCode")
    protected TaxCategoryCodeType categoryCode;
    @XmlElement(name = "CurrencyCode")
    protected CurrencyCodeType currencyCode;
    @XmlElement(name = "Jurisdiction")
    protected List<TextType> jurisdiction;
    @XmlElement(name = "CustomsDutyIndicator")
    protected IndicatorType customsDutyIndicator;
    @XmlElement(name = "ExemptionReasonCode")
    protected CodeType exemptionReasonCode;
    @XmlElement(name = "TaxBasisAllowanceRate")
    protected RateType taxBasisAllowanceRate;
    @XmlElement(name = "TaxPointDate")
    protected DateType taxPointDate;
    @XmlElement(name = "Type")
    protected TextType type;
    @XmlElement(name = "InformationAmount")
    protected List<AmountType> informationAmount;
    @XmlElement(name = "CategoryName")
    protected List<TextType> categoryName;
    @XmlElement(name = "DueDateTypeCode")
    protected TimeReferenceCodeType dueDateTypeCode;
    @XmlElement(name = "RateApplicablePercent")
    protected PercentType rateApplicablePercent;
    @XmlElement(name = "SpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> specifiedTradeAccountingAccount;
    @XmlElement(name = "ServiceSupplyTradeCountry")
    protected TradeCountryType serviceSupplyTradeCountry;
    @XmlElement(name = "BuyerRepayableTaxSpecifiedTradeAccountingAccount")
    protected TradeAccountingAccountType buyerRepayableTaxSpecifiedTradeAccountingAccount;
    @XmlElement(name = "SellerPayableTaxSpecifiedTradeAccountingAccount")
    protected TradeAccountingAccountType sellerPayableTaxSpecifiedTradeAccountingAccount;
    @XmlElement(name = "SellerRefundableTaxSpecifiedTradeAccountingAccount")
    protected TradeAccountingAccountType sellerRefundableTaxSpecifiedTradeAccountingAccount;
    @XmlElement(name = "BuyerDeductibleTaxSpecifiedTradeAccountingAccount")
    protected TradeAccountingAccountType buyerDeductibleTaxSpecifiedTradeAccountingAccount;
    @XmlElement(name = "BuyerNonDeductibleTaxSpecifiedTradeAccountingAccount")
    protected TradeAccountingAccountType buyerNonDeductibleTaxSpecifiedTradeAccountingAccount;
    @XmlElement(name = "PlaceApplicableTradeLocation")
    protected List<TradeLocationType> placeApplicableTradeLocation;

    /**
     * Gets the value of the calculatedAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calculatedAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalculatedAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getCalculatedAmount() {
        if (calculatedAmount == null) {
            calculatedAmount = new ArrayList<AmountType>();
        }
        return this.calculatedAmount;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxTypeCodeType }
     *     
     */
    public TaxTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxTypeCodeType }
     *     
     */
    public void setTypeCode(TaxTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der exemptionReason-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getExemptionReason() {
        return exemptionReason;
    }

    /**
     * Legt den Wert der exemptionReason-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setExemptionReason(TextType value) {
        this.exemptionReason = value;
    }

    /**
     * Ruft den Wert der calculatedRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RateType }
     *     
     */
    public RateType getCalculatedRate() {
        return calculatedRate;
    }

    /**
     * Legt den Wert der calculatedRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RateType }
     *     
     */
    public void setCalculatedRate(RateType value) {
        this.calculatedRate = value;
    }

    /**
     * Ruft den Wert der calculationSequenceNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getCalculationSequenceNumeric() {
        return calculationSequenceNumeric;
    }

    /**
     * Legt den Wert der calculationSequenceNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setCalculationSequenceNumeric(NumericType value) {
        this.calculationSequenceNumeric = value;
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
     * Gets the value of the basisAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the basisAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBasisAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getBasisAmount() {
        if (basisAmount == null) {
            basisAmount = new ArrayList<AmountType>();
        }
        return this.basisAmount;
    }

    /**
     * Gets the value of the unitBasisAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unitBasisAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnitBasisAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getUnitBasisAmount() {
        if (unitBasisAmount == null) {
            unitBasisAmount = new ArrayList<AmountType>();
        }
        return this.unitBasisAmount;
    }

    /**
     * Gets the value of the lineTotalBasisAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineTotalBasisAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineTotalBasisAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getLineTotalBasisAmount() {
        if (lineTotalBasisAmount == null) {
            lineTotalBasisAmount = new ArrayList<AmountType>();
        }
        return this.lineTotalBasisAmount;
    }

    /**
     * Gets the value of the allowanceChargeBasisAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceChargeBasisAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceChargeBasisAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getAllowanceChargeBasisAmount() {
        if (allowanceChargeBasisAmount == null) {
            allowanceChargeBasisAmount = new ArrayList<AmountType>();
        }
        return this.allowanceChargeBasisAmount;
    }

    /**
     * Ruft den Wert der categoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxCategoryCodeType }
     *     
     */
    public TaxCategoryCodeType getCategoryCode() {
        return categoryCode;
    }

    /**
     * Legt den Wert der categoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCategoryCodeType }
     *     
     */
    public void setCategoryCode(TaxCategoryCodeType value) {
        this.categoryCode = value;
    }

    /**
     * Ruft den Wert der currencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Legt den Wert der currencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setCurrencyCode(CurrencyCodeType value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the jurisdiction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jurisdiction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJurisdiction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getJurisdiction() {
        if (jurisdiction == null) {
            jurisdiction = new ArrayList<TextType>();
        }
        return this.jurisdiction;
    }

    /**
     * Ruft den Wert der customsDutyIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getCustomsDutyIndicator() {
        return customsDutyIndicator;
    }

    /**
     * Legt den Wert der customsDutyIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setCustomsDutyIndicator(IndicatorType value) {
        this.customsDutyIndicator = value;
    }

    /**
     * Ruft den Wert der exemptionReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getExemptionReasonCode() {
        return exemptionReasonCode;
    }

    /**
     * Legt den Wert der exemptionReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setExemptionReasonCode(CodeType value) {
        this.exemptionReasonCode = value;
    }

    /**
     * Ruft den Wert der taxBasisAllowanceRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RateType }
     *     
     */
    public RateType getTaxBasisAllowanceRate() {
        return taxBasisAllowanceRate;
    }

    /**
     * Legt den Wert der taxBasisAllowanceRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RateType }
     *     
     */
    public void setTaxBasisAllowanceRate(RateType value) {
        this.taxBasisAllowanceRate = value;
    }

    /**
     * Ruft den Wert der taxPointDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * Legt den Wert der taxPointDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setTaxPointDate(DateType value) {
        this.taxPointDate = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setType(TextType value) {
        this.type = value;
    }

    /**
     * Gets the value of the informationAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getInformationAmount() {
        if (informationAmount == null) {
            informationAmount = new ArrayList<AmountType>();
        }
        return this.informationAmount;
    }

    /**
     * Gets the value of the categoryName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCategoryName() {
        if (categoryName == null) {
            categoryName = new ArrayList<TextType>();
        }
        return this.categoryName;
    }

    /**
     * Ruft den Wert der dueDateTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TimeReferenceCodeType }
     *     
     */
    public TimeReferenceCodeType getDueDateTypeCode() {
        return dueDateTypeCode;
    }

    /**
     * Legt den Wert der dueDateTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeReferenceCodeType }
     *     
     */
    public void setDueDateTypeCode(TimeReferenceCodeType value) {
        this.dueDateTypeCode = value;
    }

    /**
     * Ruft den Wert der rateApplicablePercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PercentType }
     *     
     */
    public PercentType getRateApplicablePercent() {
        return rateApplicablePercent;
    }

    /**
     * Legt den Wert der rateApplicablePercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PercentType }
     *     
     */
    public void setRateApplicablePercent(PercentType value) {
        this.rateApplicablePercent = value;
    }

    /**
     * Gets the value of the specifiedTradeAccountingAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedTradeAccountingAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedTradeAccountingAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeAccountingAccountType }
     * 
     * 
     */
    public List<TradeAccountingAccountType> getSpecifiedTradeAccountingAccount() {
        if (specifiedTradeAccountingAccount == null) {
            specifiedTradeAccountingAccount = new ArrayList<TradeAccountingAccountType>();
        }
        return this.specifiedTradeAccountingAccount;
    }

    /**
     * Ruft den Wert der serviceSupplyTradeCountry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeCountryType }
     *     
     */
    public TradeCountryType getServiceSupplyTradeCountry() {
        return serviceSupplyTradeCountry;
    }

    /**
     * Legt den Wert der serviceSupplyTradeCountry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeCountryType }
     *     
     */
    public void setServiceSupplyTradeCountry(TradeCountryType value) {
        this.serviceSupplyTradeCountry = value;
    }

    /**
     * Ruft den Wert der buyerRepayableTaxSpecifiedTradeAccountingAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public TradeAccountingAccountType getBuyerRepayableTaxSpecifiedTradeAccountingAccount() {
        return buyerRepayableTaxSpecifiedTradeAccountingAccount;
    }

    /**
     * Legt den Wert der buyerRepayableTaxSpecifiedTradeAccountingAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public void setBuyerRepayableTaxSpecifiedTradeAccountingAccount(TradeAccountingAccountType value) {
        this.buyerRepayableTaxSpecifiedTradeAccountingAccount = value;
    }

    /**
     * Ruft den Wert der sellerPayableTaxSpecifiedTradeAccountingAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public TradeAccountingAccountType getSellerPayableTaxSpecifiedTradeAccountingAccount() {
        return sellerPayableTaxSpecifiedTradeAccountingAccount;
    }

    /**
     * Legt den Wert der sellerPayableTaxSpecifiedTradeAccountingAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public void setSellerPayableTaxSpecifiedTradeAccountingAccount(TradeAccountingAccountType value) {
        this.sellerPayableTaxSpecifiedTradeAccountingAccount = value;
    }

    /**
     * Ruft den Wert der sellerRefundableTaxSpecifiedTradeAccountingAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public TradeAccountingAccountType getSellerRefundableTaxSpecifiedTradeAccountingAccount() {
        return sellerRefundableTaxSpecifiedTradeAccountingAccount;
    }

    /**
     * Legt den Wert der sellerRefundableTaxSpecifiedTradeAccountingAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public void setSellerRefundableTaxSpecifiedTradeAccountingAccount(TradeAccountingAccountType value) {
        this.sellerRefundableTaxSpecifiedTradeAccountingAccount = value;
    }

    /**
     * Ruft den Wert der buyerDeductibleTaxSpecifiedTradeAccountingAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public TradeAccountingAccountType getBuyerDeductibleTaxSpecifiedTradeAccountingAccount() {
        return buyerDeductibleTaxSpecifiedTradeAccountingAccount;
    }

    /**
     * Legt den Wert der buyerDeductibleTaxSpecifiedTradeAccountingAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public void setBuyerDeductibleTaxSpecifiedTradeAccountingAccount(TradeAccountingAccountType value) {
        this.buyerDeductibleTaxSpecifiedTradeAccountingAccount = value;
    }

    /**
     * Ruft den Wert der buyerNonDeductibleTaxSpecifiedTradeAccountingAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public TradeAccountingAccountType getBuyerNonDeductibleTaxSpecifiedTradeAccountingAccount() {
        return buyerNonDeductibleTaxSpecifiedTradeAccountingAccount;
    }

    /**
     * Legt den Wert der buyerNonDeductibleTaxSpecifiedTradeAccountingAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAccountingAccountType }
     *     
     */
    public void setBuyerNonDeductibleTaxSpecifiedTradeAccountingAccount(TradeAccountingAccountType value) {
        this.buyerNonDeductibleTaxSpecifiedTradeAccountingAccount = value;
    }

    /**
     * Gets the value of the placeApplicableTradeLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the placeApplicableTradeLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlaceApplicableTradeLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeLocationType }
     * 
     * 
     */
    public List<TradeLocationType> getPlaceApplicableTradeLocation() {
        if (placeApplicableTradeLocation == null) {
            placeApplicableTradeLocation = new ArrayList<TradeLocationType>();
        }
        return this.placeApplicableTradeLocation;
    }

}
