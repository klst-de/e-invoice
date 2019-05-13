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
import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für HeaderTradeSettlementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HeaderTradeSettlementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DuePayableAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreditorReferenceTypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreditorReferenceType" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreditorReferenceIssuerID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreditorReferenceID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="PaymentReference" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TaxCurrencyCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CurrencyCodeType" minOccurs="0"/>
 *         &lt;element name="InvoiceCurrencyCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CurrencyCodeType" minOccurs="0"/>
 *         &lt;element name="PaymentCurrencyCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CurrencyCodeType" minOccurs="0"/>
 *         &lt;element name="InvoiceIssuerReference" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="InvoiceDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="NextInvoiceDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreditReasonCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="CreditReason" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InvoicerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="InvoiceeTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="PayeeTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="PayerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="TaxApplicableTradeCurrencyExchange" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeCurrencyExchangeType" minOccurs="0"/>
 *         &lt;element name="InvoiceApplicableTradeCurrencyExchange" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeCurrencyExchangeType" minOccurs="0"/>
 *         &lt;element name="PaymentApplicableTradeCurrencyExchange" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeCurrencyExchangeType" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradeSettlementPaymentMeans" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeSettlementPaymentMeansType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ApplicableTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BillingSpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradeAllowanceCharge" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAllowanceChargeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubtotalCalculatedTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedLogisticsServiceCharge" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsServiceChargeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradePaymentTerms" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePaymentTermsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradeSettlementHeaderMonetarySummation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeSettlementHeaderMonetarySummationType" minOccurs="0"/>
 *         &lt;element name="SpecifiedFinancialAdjustment" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}FinancialAdjustmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InvoiceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="ProFormaInvoiceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="LetterOfCreditReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="FactoringAgreementReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FactoringListReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PayableSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReceivableSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PurchaseSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SalesSpecifiedTradeAccountingAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAccountingAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedTradeSettlementFinancialCard" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeSettlementFinancialCardType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedAdvancePayment" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}AdvancePaymentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UltimatePayeeTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderTradeSettlementType", propOrder = {
    "duePayableAmount",
    "creditorReferenceTypeCode",
    "creditorReferenceType",
    "creditorReferenceIssuerID",
    "creditorReferenceID",
    "paymentReference",
    "taxCurrencyCode",
    "invoiceCurrencyCode",
    "paymentCurrencyCode",
    "invoiceIssuerReference",
    "invoiceDateTime",
    "nextInvoiceDateTime",
    "creditReasonCode",
    "creditReason",
    "invoicerTradeParty",
    "invoiceeTradeParty",
    "payeeTradeParty",
    "payerTradeParty",
    "taxApplicableTradeCurrencyExchange",
    "invoiceApplicableTradeCurrencyExchange",
    "paymentApplicableTradeCurrencyExchange",
    "specifiedTradeSettlementPaymentMeans",
    "applicableTradeTax",
    "billingSpecifiedPeriod",
    "specifiedTradeAllowanceCharge",
    "subtotalCalculatedTradeTax",
    "specifiedLogisticsServiceCharge",
    "specifiedTradePaymentTerms",
    "specifiedTradeSettlementHeaderMonetarySummation",
    "specifiedFinancialAdjustment",
    "invoiceReferencedDocument",
    "proFormaInvoiceReferencedDocument",
    "letterOfCreditReferencedDocument",
    "factoringAgreementReferencedDocument",
    "factoringListReferencedDocument",
    "payableSpecifiedTradeAccountingAccount",
    "receivableSpecifiedTradeAccountingAccount",
    "purchaseSpecifiedTradeAccountingAccount",
    "salesSpecifiedTradeAccountingAccount",
    "specifiedTradeSettlementFinancialCard",
    "specifiedAdvancePayment",
    "ultimatePayeeTradeParty"
})
public class HeaderTradeSettlementType {

    @XmlElement(name = "DuePayableAmount")
    protected List<AmountType> duePayableAmount;
    @XmlElement(name = "CreditorReferenceTypeCode")
    protected List<CodeType> creditorReferenceTypeCode;
    @XmlElement(name = "CreditorReferenceType")
    protected List<TextType> creditorReferenceType;
    @XmlElement(name = "CreditorReferenceIssuerID")
    protected List<IDType> creditorReferenceIssuerID;
    @XmlElement(name = "CreditorReferenceID")
    protected IDType creditorReferenceID;
    @XmlElement(name = "PaymentReference")
    protected List<TextType> paymentReference;
    @XmlElement(name = "TaxCurrencyCode")
    protected CurrencyCodeType taxCurrencyCode;
    @XmlElement(name = "InvoiceCurrencyCode")
    protected CurrencyCodeType invoiceCurrencyCode;
    @XmlElement(name = "PaymentCurrencyCode")
    protected CurrencyCodeType paymentCurrencyCode;
    @XmlElement(name = "InvoiceIssuerReference")
    protected TextType invoiceIssuerReference;
    @XmlElement(name = "InvoiceDateTime")
    protected DateTimeType invoiceDateTime;
    @XmlElement(name = "NextInvoiceDateTime")
    protected List<DateTimeType> nextInvoiceDateTime;
    @XmlElement(name = "CreditReasonCode")
    protected CodeType creditReasonCode;
    @XmlElement(name = "CreditReason")
    protected List<TextType> creditReason;
    @XmlElement(name = "InvoicerTradeParty")
    protected TradePartyType invoicerTradeParty;
    @XmlElement(name = "InvoiceeTradeParty")
    protected TradePartyType invoiceeTradeParty;
    @XmlElement(name = "PayeeTradeParty")
    protected TradePartyType payeeTradeParty;
    @XmlElement(name = "PayerTradeParty")
    protected TradePartyType payerTradeParty;
    @XmlElement(name = "TaxApplicableTradeCurrencyExchange")
    protected TradeCurrencyExchangeType taxApplicableTradeCurrencyExchange;
    @XmlElement(name = "InvoiceApplicableTradeCurrencyExchange")
    protected TradeCurrencyExchangeType invoiceApplicableTradeCurrencyExchange;
    @XmlElement(name = "PaymentApplicableTradeCurrencyExchange")
    protected TradeCurrencyExchangeType paymentApplicableTradeCurrencyExchange;
    @XmlElement(name = "SpecifiedTradeSettlementPaymentMeans")
    protected List<TradeSettlementPaymentMeansType> specifiedTradeSettlementPaymentMeans;
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
    @XmlElement(name = "SpecifiedTradeSettlementHeaderMonetarySummation")
    protected TradeSettlementHeaderMonetarySummationType specifiedTradeSettlementHeaderMonetarySummation;
    @XmlElement(name = "SpecifiedFinancialAdjustment")
    protected List<FinancialAdjustmentType> specifiedFinancialAdjustment;
    @XmlElement(name = "InvoiceReferencedDocument")
    protected ReferencedDocumentType invoiceReferencedDocument;
    @XmlElement(name = "ProFormaInvoiceReferencedDocument")
    protected ReferencedDocumentType proFormaInvoiceReferencedDocument;
    @XmlElement(name = "LetterOfCreditReferencedDocument")
    protected ReferencedDocumentType letterOfCreditReferencedDocument;
    @XmlElement(name = "FactoringAgreementReferencedDocument")
    protected List<ReferencedDocumentType> factoringAgreementReferencedDocument;
    @XmlElement(name = "FactoringListReferencedDocument")
    protected List<ReferencedDocumentType> factoringListReferencedDocument;
    @XmlElement(name = "PayableSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> payableSpecifiedTradeAccountingAccount;
    @XmlElement(name = "ReceivableSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> receivableSpecifiedTradeAccountingAccount;
    @XmlElement(name = "PurchaseSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> purchaseSpecifiedTradeAccountingAccount;
    @XmlElement(name = "SalesSpecifiedTradeAccountingAccount")
    protected List<TradeAccountingAccountType> salesSpecifiedTradeAccountingAccount;
    @XmlElement(name = "SpecifiedTradeSettlementFinancialCard")
    protected List<TradeSettlementFinancialCardType> specifiedTradeSettlementFinancialCard;
    @XmlElement(name = "SpecifiedAdvancePayment")
    protected List<AdvancePaymentType> specifiedAdvancePayment;
    @XmlElement(name = "UltimatePayeeTradeParty")
    protected TradePartyType ultimatePayeeTradeParty;

    /**
     * Gets the value of the duePayableAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the duePayableAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDuePayableAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getDuePayableAmount() {
        if (duePayableAmount == null) {
            duePayableAmount = new ArrayList<AmountType>();
        }
        return this.duePayableAmount;
    }

    /**
     * Gets the value of the creditorReferenceTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditorReferenceTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditorReferenceTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getCreditorReferenceTypeCode() {
        if (creditorReferenceTypeCode == null) {
            creditorReferenceTypeCode = new ArrayList<CodeType>();
        }
        return this.creditorReferenceTypeCode;
    }

    /**
     * Gets the value of the creditorReferenceType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditorReferenceType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditorReferenceType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCreditorReferenceType() {
        if (creditorReferenceType == null) {
            creditorReferenceType = new ArrayList<TextType>();
        }
        return this.creditorReferenceType;
    }

    /**
     * Gets the value of the creditorReferenceIssuerID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditorReferenceIssuerID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditorReferenceIssuerID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getCreditorReferenceIssuerID() {
        if (creditorReferenceIssuerID == null) {
            creditorReferenceIssuerID = new ArrayList<IDType>();
        }
        return this.creditorReferenceIssuerID;
    }

    /**
     * Ruft den Wert der creditorReferenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getCreditorReferenceID() {
        return creditorReferenceID;
    }

    /**
     * Legt den Wert der creditorReferenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setCreditorReferenceID(IDType value) {
        this.creditorReferenceID = value;
    }

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
     * Ruft den Wert der taxCurrencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getTaxCurrencyCode() {
        return taxCurrencyCode;
    }

    /**
     * Legt den Wert der taxCurrencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setTaxCurrencyCode(CurrencyCodeType value) {
        this.taxCurrencyCode = value;
    }

    /**
     * Ruft den Wert der invoiceCurrencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getInvoiceCurrencyCode() {
        return invoiceCurrencyCode;
    }

    /**
     * Legt den Wert der invoiceCurrencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setInvoiceCurrencyCode(CurrencyCodeType value) {
        this.invoiceCurrencyCode = value;
    }

    /**
     * Ruft den Wert der paymentCurrencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    /**
     * Legt den Wert der paymentCurrencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setPaymentCurrencyCode(CurrencyCodeType value) {
        this.paymentCurrencyCode = value;
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
     * Ruft den Wert der invoiceDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getInvoiceDateTime() {
        return invoiceDateTime;
    }

    /**
     * Legt den Wert der invoiceDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setInvoiceDateTime(DateTimeType value) {
        this.invoiceDateTime = value;
    }

    /**
     * Gets the value of the nextInvoiceDateTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nextInvoiceDateTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNextInvoiceDateTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DateTimeType }
     * 
     * 
     */
    public List<DateTimeType> getNextInvoiceDateTime() {
        if (nextInvoiceDateTime == null) {
            nextInvoiceDateTime = new ArrayList<DateTimeType>();
        }
        return this.nextInvoiceDateTime;
    }

    /**
     * Ruft den Wert der creditReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getCreditReasonCode() {
        return creditReasonCode;
    }

    /**
     * Legt den Wert der creditReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setCreditReasonCode(CodeType value) {
        this.creditReasonCode = value;
    }

    /**
     * Gets the value of the creditReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCreditReason() {
        if (creditReason == null) {
            creditReason = new ArrayList<TextType>();
        }
        return this.creditReason;
    }

    /**
     * Ruft den Wert der invoicerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getInvoicerTradeParty() {
        return invoicerTradeParty;
    }

    /**
     * Legt den Wert der invoicerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setInvoicerTradeParty(TradePartyType value) {
        this.invoicerTradeParty = value;
    }

    /**
     * Ruft den Wert der invoiceeTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getInvoiceeTradeParty() {
        return invoiceeTradeParty;
    }

    /**
     * Legt den Wert der invoiceeTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setInvoiceeTradeParty(TradePartyType value) {
        this.invoiceeTradeParty = value;
    }

    /**
     * Ruft den Wert der payeeTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getPayeeTradeParty() {
        return payeeTradeParty;
    }

    /**
     * Legt den Wert der payeeTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setPayeeTradeParty(TradePartyType value) {
        this.payeeTradeParty = value;
    }

    /**
     * Ruft den Wert der payerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getPayerTradeParty() {
        return payerTradeParty;
    }

    /**
     * Legt den Wert der payerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setPayerTradeParty(TradePartyType value) {
        this.payerTradeParty = value;
    }

    /**
     * Ruft den Wert der taxApplicableTradeCurrencyExchange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public TradeCurrencyExchangeType getTaxApplicableTradeCurrencyExchange() {
        return taxApplicableTradeCurrencyExchange;
    }

    /**
     * Legt den Wert der taxApplicableTradeCurrencyExchange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public void setTaxApplicableTradeCurrencyExchange(TradeCurrencyExchangeType value) {
        this.taxApplicableTradeCurrencyExchange = value;
    }

    /**
     * Ruft den Wert der invoiceApplicableTradeCurrencyExchange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public TradeCurrencyExchangeType getInvoiceApplicableTradeCurrencyExchange() {
        return invoiceApplicableTradeCurrencyExchange;
    }

    /**
     * Legt den Wert der invoiceApplicableTradeCurrencyExchange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public void setInvoiceApplicableTradeCurrencyExchange(TradeCurrencyExchangeType value) {
        this.invoiceApplicableTradeCurrencyExchange = value;
    }

    /**
     * Ruft den Wert der paymentApplicableTradeCurrencyExchange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public TradeCurrencyExchangeType getPaymentApplicableTradeCurrencyExchange() {
        return paymentApplicableTradeCurrencyExchange;
    }

    /**
     * Legt den Wert der paymentApplicableTradeCurrencyExchange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeCurrencyExchangeType }
     *     
     */
    public void setPaymentApplicableTradeCurrencyExchange(TradeCurrencyExchangeType value) {
        this.paymentApplicableTradeCurrencyExchange = value;
    }

    /**
     * Gets the value of the specifiedTradeSettlementPaymentMeans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedTradeSettlementPaymentMeans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedTradeSettlementPaymentMeans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeSettlementPaymentMeansType }
     * 
     * 
     */
    public List<TradeSettlementPaymentMeansType> getSpecifiedTradeSettlementPaymentMeans() {
        if (specifiedTradeSettlementPaymentMeans == null) {
            specifiedTradeSettlementPaymentMeans = new ArrayList<TradeSettlementPaymentMeansType>();
        }
        return this.specifiedTradeSettlementPaymentMeans;
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
     * Ruft den Wert der specifiedTradeSettlementHeaderMonetarySummation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeSettlementHeaderMonetarySummationType }
     *     
     */
    public TradeSettlementHeaderMonetarySummationType getSpecifiedTradeSettlementHeaderMonetarySummation() {
        return specifiedTradeSettlementHeaderMonetarySummation;
    }

    /**
     * Legt den Wert der specifiedTradeSettlementHeaderMonetarySummation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeSettlementHeaderMonetarySummationType }
     *     
     */
    public void setSpecifiedTradeSettlementHeaderMonetarySummation(TradeSettlementHeaderMonetarySummationType value) {
        this.specifiedTradeSettlementHeaderMonetarySummation = value;
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
     * Ruft den Wert der proFormaInvoiceReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getProFormaInvoiceReferencedDocument() {
        return proFormaInvoiceReferencedDocument;
    }

    /**
     * Legt den Wert der proFormaInvoiceReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setProFormaInvoiceReferencedDocument(ReferencedDocumentType value) {
        this.proFormaInvoiceReferencedDocument = value;
    }

    /**
     * Ruft den Wert der letterOfCreditReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getLetterOfCreditReferencedDocument() {
        return letterOfCreditReferencedDocument;
    }

    /**
     * Legt den Wert der letterOfCreditReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setLetterOfCreditReferencedDocument(ReferencedDocumentType value) {
        this.letterOfCreditReferencedDocument = value;
    }

    /**
     * Gets the value of the factoringAgreementReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the factoringAgreementReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFactoringAgreementReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getFactoringAgreementReferencedDocument() {
        if (factoringAgreementReferencedDocument == null) {
            factoringAgreementReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.factoringAgreementReferencedDocument;
    }

    /**
     * Gets the value of the factoringListReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the factoringListReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFactoringListReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getFactoringListReferencedDocument() {
        if (factoringListReferencedDocument == null) {
            factoringListReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.factoringListReferencedDocument;
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
     * Gets the value of the specifiedTradeSettlementFinancialCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedTradeSettlementFinancialCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedTradeSettlementFinancialCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeSettlementFinancialCardType }
     * 
     * 
     */
    public List<TradeSettlementFinancialCardType> getSpecifiedTradeSettlementFinancialCard() {
        if (specifiedTradeSettlementFinancialCard == null) {
            specifiedTradeSettlementFinancialCard = new ArrayList<TradeSettlementFinancialCardType>();
        }
        return this.specifiedTradeSettlementFinancialCard;
    }

    /**
     * Gets the value of the specifiedAdvancePayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedAdvancePayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedAdvancePayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdvancePaymentType }
     * 
     * 
     */
    public List<AdvancePaymentType> getSpecifiedAdvancePayment() {
        if (specifiedAdvancePayment == null) {
            specifiedAdvancePayment = new ArrayList<AdvancePaymentType>();
        }
        return this.specifiedAdvancePayment;
    }

    /**
     * Ruft den Wert der ultimatePayeeTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getUltimatePayeeTradeParty() {
        return ultimatePayeeTradeParty;
    }

    /**
     * Legt den Wert der ultimatePayeeTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setUltimatePayeeTradeParty(TradePartyType value) {
        this.ultimatePayeeTradeParty = value;
    }

}
