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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für LineTradeSettlementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LineTradeSettlementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentReference" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InvoiceIssuerReference" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="TotalAdjustmentAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/>
 *         &lt;element name="DiscountIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="ApplicableTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BillingSpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradeAllowanceCharge" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAllowanceChargeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubtotalCalculatedTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedLogisticsServiceCharge" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsServiceChargeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradePaymentTerms" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePaymentTermsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradeSettlementLineMonetarySummation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeSettlementLineMonetarySummationType" minOccurs="0"/>
 *         &lt;element name="SpecifiedFinancialAdjustment" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}FinancialAdjustmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InvoiceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="AdditionalReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PayableSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReceivableSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PurchaseSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SalesSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradeSettlementFinancialCard" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeSettlementFinancialCardType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineTradeSettlementType", propOrder = {
    "paymentReference",
    "invoiceIssuerReference",
    "totalAdjustmentAmount",
    "discountIndicator",
    "applicableTradeTax",
    "billingSpecifiedPeriod",
    "specifiedTradeAllowanceCharge",
    "subtotalCalculatedTradeTax",
    "specifiedLogisticsServiceCharge",
    "specifiedTradePaymentTerms",
    "specifiedTradeSettlementLineMonetarySummation",
    "specifiedFinancialAdjustment",
    "invoiceReferencedDocument",
    "additionalReferencedDocument",
    "payableSpecifiedTradeAccountingAccount",
    "receivableSpecifiedTradeAccountingAccount",
    "purchaseSpecifiedTradeAccountingAccount",
    "salesSpecifiedTradeAccountingAccount",
    "specifiedTradeSettlementFinancialCard"
})
public class LineTradeSettlementType {

    @XmlElement(name = "PaymentReference")
    protected List<TextType> paymentReference;
    @XmlElement(name = "InvoiceIssuerReference")
    protected TextType invoiceIssuerReference;
    @XmlElement(name = "TotalAdjustmentAmount")
    protected AmountType totalAdjustmentAmount;
    @XmlElement(name = "DiscountIndicator")
    protected IndicatorType discountIndicator;
    @XmlElement(name = "ApplicableTradeTax")
    protected List<TradeTaxType> applicableTradeTax;
    @XmlElement(name = "BillingSpecifiedPeriod")
    protected SpecifiedPeriodType billingSpecifiedPeriod;
    @XmlElement(name = "SpecifiedTradeAllowanceCharge")
    protected List<TradeAllowanceChargeType> specifiedTradeAllowanceCharge;
    @XmlElement(name = "SubtotalCalculatedTradeTax")
    protected List<TradeTaxType> subtotalCalculatedTradeTax;
    @XmlElement(name = "SpecifiedLogisticsServiceCharge")
    protected List<LogisticsServiceChargeType> specifiedLogisticsServiceCharge;
    @XmlElement(name = "SpecifiedTradePaymentTerms")
    protected List<TradePaymentTermsType> specifiedTradePaymentTerms;
    @XmlElement(name = "SpecifiedTradeSettlementLineMonetarySummation")
    protected TradeSettlementLineMonetarySummationType specifiedTradeSettlementLineMonetarySummation;
    @XmlElement(name = "SpecifiedFinancialAdjustment")
    protected List<FinancialAdjustmentType> specifiedFinancialAdjustment;
    @XmlElement(name = "InvoiceReferencedDocument")
    protected ReferencedDocumentType invoiceReferencedDocument;
    @XmlElement(name = "AdditionalReferencedDocument")
    protected List<ReferencedDocumentType> additionalReferencedDocument;
    @XmlElement(name = "PayableSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> payableSpecifiedTradeAccountingAccount;
    @XmlElement(name = "ReceivableSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> receivableSpecifiedTradeAccountingAccount;
    @XmlElement(name = "PurchaseSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> purchaseSpecifiedTradeAccountingAccount;
    @XmlElement(name = "SalesSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> salesSpecifiedTradeAccountingAccount;
    @XmlElement(name = "SpecifiedTradeSettlementFinancialCard")
    protected TradeSettlementFinancialCardType specifiedTradeSettlementFinancialCard;

    /**
     * Gets the value of the paymentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getPaymentReference() {
        if (paymentReference == null) {
            paymentReference = new ArrayList<TextType>();
        }
        return this.paymentReference;
    }

    /**
     * Ruft den Wert der invoiceIssuerReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getInvoiceIssuerReference() {
        return invoiceIssuerReference;
    }

    /**
     * Legt den Wert der invoiceIssuerReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setInvoiceIssuerReference(TextType value) {
        this.invoiceIssuerReference = value;
    }

    /**
     * Ruft den Wert der totalAdjustmentAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTotalAdjustmentAmount() {
        return totalAdjustmentAmount;
    }

    /**
     * Legt den Wert der totalAdjustmentAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTotalAdjustmentAmount(AmountType value) {
        this.totalAdjustmentAmount = value;
    }

    /**
     * Ruft den Wert der discountIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getDiscountIndicator() {
        return discountIndicator;
    }

    /**
     * Legt den Wert der discountIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setDiscountIndicator(IndicatorType value) {
        this.discountIndicator = value;
    }

    /**
     * Gets the value of the applicableTradeTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableTradeTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableTradeTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeTaxType }
     * 
     * 
     */
    public List<TradeTaxType> getApplicableTradeTax() {
        if (applicableTradeTax == null) {
            applicableTradeTax = new ArrayList<TradeTaxType>();
        }
        return this.applicableTradeTax;
    }

    /**
     * Ruft den Wert der billingSpecifiedPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public SpecifiedPeriodType getBillingSpecifiedPeriod() {
        return billingSpecifiedPeriod;
    }

    /**
     * Legt den Wert der billingSpecifiedPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public void setBillingSpecifiedPeriod(SpecifiedPeriodType value) {
        this.billingSpecifiedPeriod = value;
    }

    /**
     * Gets the value of the specifiedTradeAllowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedTradeAllowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedTradeAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeAllowanceChargeType }
     * 
     * 
     */
    public List<TradeAllowanceChargeType> getSpecifiedTradeAllowanceCharge() {
        if (specifiedTradeAllowanceCharge == null) {
            specifiedTradeAllowanceCharge = new ArrayList<TradeAllowanceChargeType>();
        }
        return this.specifiedTradeAllowanceCharge;
    }

    /**
     * Gets the value of the subtotalCalculatedTradeTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtotalCalculatedTradeTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtotalCalculatedTradeTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeTaxType }
     * 
     * 
     */
    public List<TradeTaxType> getSubtotalCalculatedTradeTax() {
        if (subtotalCalculatedTradeTax == null) {
            subtotalCalculatedTradeTax = new ArrayList<TradeTaxType>();
        }
        return this.subtotalCalculatedTradeTax;
    }

    /**
     * Gets the value of the specifiedLogisticsServiceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedLogisticsServiceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedLogisticsServiceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogisticsServiceChargeType }
     * 
     * 
     */
    public List<LogisticsServiceChargeType> getSpecifiedLogisticsServiceCharge() {
        if (specifiedLogisticsServiceCharge == null) {
            specifiedLogisticsServiceCharge = new ArrayList<LogisticsServiceChargeType>();
        }
        return this.specifiedLogisticsServiceCharge;
    }

    /**
     * Gets the value of the specifiedTradePaymentTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedTradePaymentTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedTradePaymentTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradePaymentTermsType }
     * 
     * 
     */
    public List<TradePaymentTermsType> getSpecifiedTradePaymentTerms() {
        if (specifiedTradePaymentTerms == null) {
            specifiedTradePaymentTerms = new ArrayList<TradePaymentTermsType>();
        }
        return this.specifiedTradePaymentTerms;
    }

    /**
     * Ruft den Wert der specifiedTradeSettlementLineMonetarySummation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeSettlementLineMonetarySummationType }
     *     
     */
    public TradeSettlementLineMonetarySummationType getSpecifiedTradeSettlementLineMonetarySummation() {
        return specifiedTradeSettlementLineMonetarySummation;
    }

    /**
     * Legt den Wert der specifiedTradeSettlementLineMonetarySummation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeSettlementLineMonetarySummationType }
     *     
     */
    public void setSpecifiedTradeSettlementLineMonetarySummation(TradeSettlementLineMonetarySummationType value) {
        this.specifiedTradeSettlementLineMonetarySummation = value;
    }

    /**
     * Gets the value of the specifiedFinancialAdjustment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedFinancialAdjustment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedFinancialAdjustment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinancialAdjustmentType }
     * 
     * 
     */
    public List<FinancialAdjustmentType> getSpecifiedFinancialAdjustment() {
        if (specifiedFinancialAdjustment == null) {
            specifiedFinancialAdjustment = new ArrayList<FinancialAdjustmentType>();
        }
        return this.specifiedFinancialAdjustment;
    }

    /**
     * Ruft den Wert der invoiceReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getInvoiceReferencedDocument() {
        return invoiceReferencedDocument;
    }

    /**
     * Legt den Wert der invoiceReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setInvoiceReferencedDocument(ReferencedDocumentType value) {
        this.invoiceReferencedDocument = value;
    }

    /**
     * Gets the value of the additionalReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getAdditionalReferencedDocument() {
        if (additionalReferencedDocument == null) {
            additionalReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.additionalReferencedDocument;
    }

    /**
     * Gets the value of the payableSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payableSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayableSpecifiedTradeAccountingAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeAccountingAccountType }
     * 
     * 
     */
    public List<TradeAccountingAccountType> getPayableSpecifiedTradeAccountingAccount() {
        if (payableSpecifiedTradeAccountingAccount == null) {
            payableSpecifiedTradeAccountingAccount = new ArrayList<TradeAccountingAccountType>();
        }
        return this.payableSpecifiedTradeAccountingAccount;
    }

    /**
     * Gets the value of the receivableSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receivableSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceivableSpecifiedTradeAccountingAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeAccountingAccountType }
     * 
     * 
     */
    public List<TradeAccountingAccountType> getReceivableSpecifiedTradeAccountingAccount() {
        if (receivableSpecifiedTradeAccountingAccount == null) {
            receivableSpecifiedTradeAccountingAccount = new ArrayList<TradeAccountingAccountType>();
        }
        return this.receivableSpecifiedTradeAccountingAccount;
    }

    /**
     * Gets the value of the purchaseSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the purchaseSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPurchaseSpecifiedTradeAccountingAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeAccountingAccountType }
     * 
     * 
     */
    public List<TradeAccountingAccountType> getPurchaseSpecifiedTradeAccountingAccount() {
        if (purchaseSpecifiedTradeAccountingAccount == null) {
            purchaseSpecifiedTradeAccountingAccount = new ArrayList<TradeAccountingAccountType>();
        }
        return this.purchaseSpecifiedTradeAccountingAccount;
    }

    /**
     * Gets the value of the salesSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesSpecifiedTradeAccountingAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesSpecifiedTradeAccountingAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeAccountingAccountType }
     * 
     * 
     */
    public List<TradeAccountingAccountType> getSalesSpecifiedTradeAccountingAccount() {
        if (salesSpecifiedTradeAccountingAccount == null) {
            salesSpecifiedTradeAccountingAccount = new ArrayList<TradeAccountingAccountType>();
        }
        return this.salesSpecifiedTradeAccountingAccount;
    }

    /**
     * Ruft den Wert der specifiedTradeSettlementFinancialCard-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeSettlementFinancialCardType }
     *     
     */
    public TradeSettlementFinancialCardType getSpecifiedTradeSettlementFinancialCard() {
        return specifiedTradeSettlementFinancialCard;
    }

    /**
     * Legt den Wert der specifiedTradeSettlementFinancialCard-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeSettlementFinancialCardType }
     *     
     */
    public void setSpecifiedTradeSettlementFinancialCard(TradeSettlementFinancialCardType value) {
        this.specifiedTradeSettlementFinancialCard = value;
    }

}
