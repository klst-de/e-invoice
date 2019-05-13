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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstallmentDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicingPartyReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentMeansIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentTermsDetailsURIType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PenaltyAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PenaltySurchargePercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrepaidPaymentReferenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceEventCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SettlementDiscountAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SettlementDiscountPercentType;


/**
 * <p>Java-Klasse für PaymentTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PaymentTermsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentMeansID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrepaidPaymentReferenceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferenceEventCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SettlementDiscountPercent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PenaltySurchargePercent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentPercent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Amount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SettlementDiscountAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PenaltyAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentTermsDetailsURI" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentDueDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InstallmentDueDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InvoicingPartyReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SettlementPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PenaltyPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExchangeRate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTermsType", propOrder = {
    "id",
    "paymentMeansID",
    "prepaidPaymentReferenceID",
    "note",
    "referenceEventCode",
    "settlementDiscountPercent",
    "penaltySurchargePercent",
    "paymentPercent",
    "amount",
    "settlementDiscountAmount",
    "penaltyAmount",
    "paymentTermsDetailsURI",
    "paymentDueDate",
    "installmentDueDate",
    "invoicingPartyReference",
    "settlementPeriod",
    "penaltyPeriod",
    "exchangeRate",
    "validityPeriod"
})
public class PaymentTermsType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "PaymentMeansID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PaymentMeansIDType> paymentMeansID;
    @XmlElement(name = "PrepaidPaymentReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrepaidPaymentReferenceIDType prepaidPaymentReferenceID;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "ReferenceEventCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReferenceEventCodeType referenceEventCode;
    @XmlElement(name = "SettlementDiscountPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SettlementDiscountPercentType settlementDiscountPercent;
    @XmlElement(name = "PenaltySurchargePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PenaltySurchargePercentType penaltySurchargePercent;
    @XmlElement(name = "PaymentPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentPercentType paymentPercent;
    @XmlElement(name = "Amount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AmountType amount;
    @XmlElement(name = "SettlementDiscountAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SettlementDiscountAmountType settlementDiscountAmount;
    @XmlElement(name = "PenaltyAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PenaltyAmountType penaltyAmount;
    @XmlElement(name = "PaymentTermsDetailsURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentTermsDetailsURIType paymentTermsDetailsURI;
    @XmlElement(name = "PaymentDueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentDueDateType paymentDueDate;
    @XmlElement(name = "InstallmentDueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InstallmentDueDateType installmentDueDate;
    @XmlElement(name = "InvoicingPartyReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InvoicingPartyReferenceType invoicingPartyReference;
    @XmlElement(name = "SettlementPeriod")
    protected PeriodType settlementPeriod;
    @XmlElement(name = "PenaltyPeriod")
    protected PeriodType penaltyPeriod;
    @XmlElement(name = "ExchangeRate")
    protected ExchangeRateType exchangeRate;
    @XmlElement(name = "ValidityPeriod")
    protected PeriodType validityPeriod;

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
     * Gets the value of the paymentMeansID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMeansID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMeansID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMeansIDType }
     * 
     * 
     */
    public List<PaymentMeansIDType> getPaymentMeansID() {
        if (paymentMeansID == null) {
            paymentMeansID = new ArrayList<PaymentMeansIDType>();
        }
        return this.paymentMeansID;
    }

    /**
     * Ruft den Wert der prepaidPaymentReferenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PrepaidPaymentReferenceIDType }
     *     
     */
    public PrepaidPaymentReferenceIDType getPrepaidPaymentReferenceID() {
        return prepaidPaymentReferenceID;
    }

    /**
     * Legt den Wert der prepaidPaymentReferenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PrepaidPaymentReferenceIDType }
     *     
     */
    public void setPrepaidPaymentReferenceID(PrepaidPaymentReferenceIDType value) {
        this.prepaidPaymentReferenceID = value;
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
     * Ruft den Wert der referenceEventCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceEventCodeType }
     *     
     */
    public ReferenceEventCodeType getReferenceEventCode() {
        return referenceEventCode;
    }

    /**
     * Legt den Wert der referenceEventCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceEventCodeType }
     *     
     */
    public void setReferenceEventCode(ReferenceEventCodeType value) {
        this.referenceEventCode = value;
    }

    /**
     * Ruft den Wert der settlementDiscountPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SettlementDiscountPercentType }
     *     
     */
    public SettlementDiscountPercentType getSettlementDiscountPercent() {
        return settlementDiscountPercent;
    }

    /**
     * Legt den Wert der settlementDiscountPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementDiscountPercentType }
     *     
     */
    public void setSettlementDiscountPercent(SettlementDiscountPercentType value) {
        this.settlementDiscountPercent = value;
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
     * Ruft den Wert der paymentPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentPercentType }
     *     
     */
    public PaymentPercentType getPaymentPercent() {
        return paymentPercent;
    }

    /**
     * Legt den Wert der paymentPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentPercentType }
     *     
     */
    public void setPaymentPercent(PaymentPercentType value) {
        this.paymentPercent = value;
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
     * Ruft den Wert der settlementDiscountAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SettlementDiscountAmountType }
     *     
     */
    public SettlementDiscountAmountType getSettlementDiscountAmount() {
        return settlementDiscountAmount;
    }

    /**
     * Legt den Wert der settlementDiscountAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementDiscountAmountType }
     *     
     */
    public void setSettlementDiscountAmount(SettlementDiscountAmountType value) {
        this.settlementDiscountAmount = value;
    }

    /**
     * Ruft den Wert der penaltyAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PenaltyAmountType }
     *     
     */
    public PenaltyAmountType getPenaltyAmount() {
        return penaltyAmount;
    }

    /**
     * Legt den Wert der penaltyAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PenaltyAmountType }
     *     
     */
    public void setPenaltyAmount(PenaltyAmountType value) {
        this.penaltyAmount = value;
    }

    /**
     * Ruft den Wert der paymentTermsDetailsURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsDetailsURIType }
     *     
     */
    public PaymentTermsDetailsURIType getPaymentTermsDetailsURI() {
        return paymentTermsDetailsURI;
    }

    /**
     * Legt den Wert der paymentTermsDetailsURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsDetailsURIType }
     *     
     */
    public void setPaymentTermsDetailsURI(PaymentTermsDetailsURIType value) {
        this.paymentTermsDetailsURI = value;
    }

    /**
     * Ruft den Wert der paymentDueDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDueDateType }
     *     
     */
    public PaymentDueDateType getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * Legt den Wert der paymentDueDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDueDateType }
     *     
     */
    public void setPaymentDueDate(PaymentDueDateType value) {
        this.paymentDueDate = value;
    }

    /**
     * Ruft den Wert der installmentDueDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InstallmentDueDateType }
     *     
     */
    public InstallmentDueDateType getInstallmentDueDate() {
        return installmentDueDate;
    }

    /**
     * Legt den Wert der installmentDueDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InstallmentDueDateType }
     *     
     */
    public void setInstallmentDueDate(InstallmentDueDateType value) {
        this.installmentDueDate = value;
    }

    /**
     * Ruft den Wert der invoicingPartyReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InvoicingPartyReferenceType }
     *     
     */
    public InvoicingPartyReferenceType getInvoicingPartyReference() {
        return invoicingPartyReference;
    }

    /**
     * Legt den Wert der invoicingPartyReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoicingPartyReferenceType }
     *     
     */
    public void setInvoicingPartyReference(InvoicingPartyReferenceType value) {
        this.invoicingPartyReference = value;
    }

    /**
     * Ruft den Wert der settlementPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getSettlementPeriod() {
        return settlementPeriod;
    }

    /**
     * Legt den Wert der settlementPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setSettlementPeriod(PeriodType value) {
        this.settlementPeriod = value;
    }

    /**
     * Ruft den Wert der penaltyPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPenaltyPeriod() {
        return penaltyPeriod;
    }

    /**
     * Legt den Wert der penaltyPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPenaltyPeriod(PeriodType value) {
        this.penaltyPeriod = value;
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

    /**
     * Ruft den Wert der validityPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Legt den Wert der validityPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setValidityPeriod(PeriodType value) {
        this.validityPeriod = value;
    }

}
