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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BalanceBroughtForwardIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditLineAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DebitLineAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentPurposeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PenaltySurchargePercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;


/**
 * <p>Java-Klasse für ReminderLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReminderLineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BalanceBroughtForwardIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DebitLineAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CreditLineAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCostCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCost" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PenaltySurchargePercent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Amount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentPurposeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReminderPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BillingReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExchangeRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReminderLineType", propOrder = {
    "id",
    "note",
    "uuid",
    "balanceBroughtForwardIndicator",
    "debitLineAmount",
    "creditLineAmount",
    "accountingCostCode",
    "accountingCost",
    "penaltySurchargePercent",
    "amount",
    "paymentPurposeCode",
    "reminderPeriod",
    "billingReference",
    "exchangeRate"
})
public class ReminderLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UUIDType uuid;
    @XmlElement(name = "BalanceBroughtForwardIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BalanceBroughtForwardIndicatorType balanceBroughtForwardIndicator;
    @XmlElement(name = "DebitLineAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DebitLineAmountType debitLineAmount;
    @XmlElement(name = "CreditLineAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CreditLineAmountType creditLineAmount;
    @XmlElement(name = "AccountingCostCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostCodeType accountingCostCode;
    @XmlElement(name = "AccountingCost", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostType accountingCost;
    @XmlElement(name = "PenaltySurchargePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PenaltySurchargePercentType penaltySurchargePercent;
    @XmlElement(name = "Amount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AmountType amount;
    @XmlElement(name = "PaymentPurposeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentPurposeCodeType paymentPurposeCode;
    @XmlElement(name = "ReminderPeriod")
    protected List<PeriodType> reminderPeriod;
    @XmlElement(name = "BillingReference")
    protected List<BillingReferenceType> billingReference;
    @XmlElement(name = "ExchangeRate")
    protected ExchangeRateType exchangeRate;

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
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Ruft den Wert der uuid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UUIDType }
     *     
     */
    public UUIDType getUUID() {
        return uuid;
    }

    /**
     * Legt den Wert der uuid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UUIDType }
     *     
     */
    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    /**
     * Ruft den Wert der balanceBroughtForwardIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BalanceBroughtForwardIndicatorType }
     *     
     */
    public BalanceBroughtForwardIndicatorType getBalanceBroughtForwardIndicator() {
        return balanceBroughtForwardIndicator;
    }

    /**
     * Legt den Wert der balanceBroughtForwardIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceBroughtForwardIndicatorType }
     *     
     */
    public void setBalanceBroughtForwardIndicator(BalanceBroughtForwardIndicatorType value) {
        this.balanceBroughtForwardIndicator = value;
    }

    /**
     * Ruft den Wert der debitLineAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DebitLineAmountType }
     *     
     */
    public DebitLineAmountType getDebitLineAmount() {
        return debitLineAmount;
    }

    /**
     * Legt den Wert der debitLineAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitLineAmountType }
     *     
     */
    public void setDebitLineAmount(DebitLineAmountType value) {
        this.debitLineAmount = value;
    }

    /**
     * Ruft den Wert der creditLineAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CreditLineAmountType }
     *     
     */
    public CreditLineAmountType getCreditLineAmount() {
        return creditLineAmount;
    }

    /**
     * Legt den Wert der creditLineAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLineAmountType }
     *     
     */
    public void setCreditLineAmount(CreditLineAmountType value) {
        this.creditLineAmount = value;
    }

    /**
     * Ruft den Wert der accountingCostCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * Legt den Wert der accountingCostCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    /**
     * Ruft den Wert der accountingCost-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostType }
     *     
     */
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    /**
     * Legt den Wert der accountingCost-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostType }
     *     
     */
    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    /**
     * Ruft den Wert der penaltySurchargePercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PenaltySurchargePercentType }
     *     
     */
    public PenaltySurchargePercentType getPenaltySurchargePercent() {
        return penaltySurchargePercent;
    }

    /**
     * Legt den Wert der penaltySurchargePercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PenaltySurchargePercentType }
     *     
     */
    public void setPenaltySurchargePercent(PenaltySurchargePercentType value) {
        this.penaltySurchargePercent = value;
    }

    /**
     * Ruft den Wert der amount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Legt den Wert der amount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * Ruft den Wert der paymentPurposeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentPurposeCodeType }
     *     
     */
    public PaymentPurposeCodeType getPaymentPurposeCode() {
        return paymentPurposeCode;
    }

    /**
     * Legt den Wert der paymentPurposeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentPurposeCodeType }
     *     
     */
    public void setPaymentPurposeCode(PaymentPurposeCodeType value) {
        this.paymentPurposeCode = value;
    }

    /**
     * Gets the value of the reminderPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reminderPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReminderPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getReminderPeriod() {
        if (reminderPeriod == null) {
            reminderPeriod = new ArrayList<PeriodType>();
        }
        return this.reminderPeriod;
    }

    /**
     * Gets the value of the billingReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingReferenceType }
     * 
     * 
     */
    public List<BillingReferenceType> getBillingReference() {
        if (billingReference == null) {
            billingReference = new ArrayList<BillingReferenceType>();
        }
        return this.billingReference;
    }

    /**
     * Ruft den Wert der exchangeRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRateType }
     *     
     */
    public ExchangeRateType getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Legt den Wert der exchangeRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRateType }
     *     
     */
    public void setExchangeRate(ExchangeRateType value) {
        this.exchangeRate = value;
    }

}
