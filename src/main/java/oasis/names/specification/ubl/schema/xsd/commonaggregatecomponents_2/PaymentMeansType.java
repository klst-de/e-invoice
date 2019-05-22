//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionNoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentChannelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentMeansCodeType;


/**
 * <p>Java-Klasse für PaymentMeansType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PaymentMeansType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentMeansCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentDueDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentChannelCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InstructionID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InstructionNote" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CardAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PayerFinancialAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PayeeFinancialAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CreditAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentMandate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TradeFinancing" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMeansType", propOrder = {
    "id",
    "paymentMeansCode",
    "paymentDueDate",
    "paymentChannelCode",
    "instructionID",
    "instructionNote",
    "paymentID",
    "cardAccount",
    "payerFinancialAccount",
    "payeeFinancialAccount",
    "creditAccount",
    "paymentMandate",
    "tradeFinancing"
})
public class PaymentMeansType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "PaymentMeansCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PaymentMeansCodeType paymentMeansCode;
    @XmlElement(name = "PaymentDueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentDueDateType paymentDueDate;
    @XmlElement(name = "PaymentChannelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentChannelCodeType paymentChannelCode;
    @XmlElement(name = "InstructionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InstructionIDType instructionID;
    @XmlElement(name = "InstructionNote", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<InstructionNoteType> instructionNote;
    @XmlElement(name = "PaymentID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PaymentIDType> paymentID;
    @XmlElement(name = "CardAccount")
    protected CardAccountType cardAccount;
    @XmlElement(name = "PayerFinancialAccount")
    protected FinancialAccountType payerFinancialAccount;
    @XmlElement(name = "PayeeFinancialAccount")
    protected FinancialAccountType payeeFinancialAccount;
    @XmlElement(name = "CreditAccount")
    protected CreditAccountType creditAccount;
    @XmlElement(name = "PaymentMandate")
    protected PaymentMandateType paymentMandate;
    @XmlElement(name = "TradeFinancing")
    protected TradeFinancingType tradeFinancing;

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
     * Ruft den Wert der paymentMeansCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMeansCodeType }
     *     
     */
    public PaymentMeansCodeType getPaymentMeansCode() {
        return paymentMeansCode;
    }

    /**
     * Legt den Wert der paymentMeansCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMeansCodeType }
     *     
     */
    public void setPaymentMeansCode(PaymentMeansCodeType value) {
        this.paymentMeansCode = value;
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
     * Ruft den Wert der paymentChannelCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentChannelCodeType }
     *     
     */
    public PaymentChannelCodeType getPaymentChannelCode() {
        return paymentChannelCode;
    }

    /**
     * Legt den Wert der paymentChannelCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentChannelCodeType }
     *     
     */
    public void setPaymentChannelCode(PaymentChannelCodeType value) {
        this.paymentChannelCode = value;
    }

    /**
     * Ruft den Wert der instructionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InstructionIDType }
     *     
     */
    public InstructionIDType getInstructionID() {
        return instructionID;
    }

    /**
     * Legt den Wert der instructionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InstructionIDType }
     *     
     */
    public void setInstructionID(InstructionIDType value) {
        this.instructionID = value;
    }

    /**
     * Gets the value of the instructionNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instructionNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstructionNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstructionNoteType }
     * 
     * 
     */
    public List<InstructionNoteType> getInstructionNote() {
        if (instructionNote == null) {
            instructionNote = new ArrayList<InstructionNoteType>();
        }
        return this.instructionNote;
    }

    /**
     * Gets the value of the paymentID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentIDType }
     * 
     * 
     */
    public List<PaymentIDType> getPaymentID() {
        if (paymentID == null) {
            paymentID = new ArrayList<PaymentIDType>();
        }
        return this.paymentID;
    }

    /**
     * Ruft den Wert der cardAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CardAccountType }
     *     
     */
    public CardAccountType getCardAccount() {
        return cardAccount;
    }

    /**
     * Legt den Wert der cardAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAccountType }
     *     
     */
    public void setCardAccount(CardAccountType value) {
        this.cardAccount = value;
    }

    /**
     * Ruft den Wert der payerFinancialAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancialAccountType }
     *     
     */
    public FinancialAccountType getPayerFinancialAccount() {
        return payerFinancialAccount;
    }

    /**
     * Legt den Wert der payerFinancialAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAccountType }
     *     
     */
    public void setPayerFinancialAccount(FinancialAccountType value) {
        this.payerFinancialAccount = value;
    }

    /**
     * Ruft den Wert der payeeFinancialAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancialAccountType }
     *     
     */
    public FinancialAccountType getPayeeFinancialAccount() {
        return payeeFinancialAccount;
    }

    /**
     * Legt den Wert der payeeFinancialAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAccountType }
     *     
     */
    public void setPayeeFinancialAccount(FinancialAccountType value) {
        this.payeeFinancialAccount = value;
    }

    /**
     * Ruft den Wert der creditAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CreditAccountType }
     *     
     */
    public CreditAccountType getCreditAccount() {
        return creditAccount;
    }

    /**
     * Legt den Wert der creditAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditAccountType }
     *     
     */
    public void setCreditAccount(CreditAccountType value) {
        this.creditAccount = value;
    }

    /**
     * Ruft den Wert der paymentMandate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMandateType }
     *     
     */
    public PaymentMandateType getPaymentMandate() {
        return paymentMandate;
    }

    /**
     * Legt den Wert der paymentMandate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMandateType }
     *     
     */
    public void setPaymentMandate(PaymentMandateType value) {
        this.paymentMandate = value;
    }

    /**
     * Ruft den Wert der tradeFinancing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeFinancingType }
     *     
     */
    public TradeFinancingType getTradeFinancing() {
        return tradeFinancing;
    }

    /**
     * Legt den Wert der tradeFinancing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeFinancingType }
     *     
     */
    public void setTradeFinancing(TradeFinancingType value) {
        this.tradeFinancing = value;
    }

}
