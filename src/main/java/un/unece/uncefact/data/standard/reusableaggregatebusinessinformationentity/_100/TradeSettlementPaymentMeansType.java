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
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentGuaranteeMeansCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentMeansChannelCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentMeansCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeSettlementPaymentMeansType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeSettlementPaymentMeansType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentChannelCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PaymentMeansChannelCodeType" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PaymentMeansCodeType" minOccurs="0"/&gt;
 *         &lt;element name="GuaranteeMethodCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PaymentGuaranteeMeansCodeType" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMethodCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="Information" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableTradeSettlementFinancialCard" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeSettlementFinancialCardType" minOccurs="0"/&gt;
 *         &lt;element name="PayerPartyDebtorFinancialAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DebtorFinancialAccountType" minOccurs="0"/&gt;
 *         &lt;element name="PayeePartyCreditorFinancialAccount" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}CreditorFinancialAccountType" minOccurs="0"/&gt;
 *         &lt;element name="PayerSpecifiedDebtorFinancialInstitution" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DebtorFinancialInstitutionType" minOccurs="0"/&gt;
 *         &lt;element name="PayeeSpecifiedCreditorFinancialInstitution" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}CreditorFinancialInstitutionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeSettlementPaymentMeansType", propOrder = {
    "paymentChannelCode",
    "typeCode",
    "guaranteeMethodCode",
    "paymentMethodCode",
    "information",
    "id",
    "applicableTradeSettlementFinancialCard",
    "payerPartyDebtorFinancialAccount",
    "payeePartyCreditorFinancialAccount",
    "payerSpecifiedDebtorFinancialInstitution",
    "payeeSpecifiedCreditorFinancialInstitution"
})
public class TradeSettlementPaymentMeansType {

    @XmlElement(name = "PaymentChannelCode")
    protected PaymentMeansChannelCodeType paymentChannelCode;
    @XmlElement(name = "TypeCode")
    protected PaymentMeansCodeType typeCode;
    @XmlElement(name = "GuaranteeMethodCode")
    protected PaymentGuaranteeMeansCodeType guaranteeMethodCode;
    @XmlElement(name = "PaymentMethodCode")
    protected CodeType paymentMethodCode;
    @XmlElement(name = "Information")
    protected List<TextType> information;
    @XmlElement(name = "ID")
    protected List<IDType> id;
    @XmlElement(name = "ApplicableTradeSettlementFinancialCard")
    protected TradeSettlementFinancialCardType applicableTradeSettlementFinancialCard;
    @XmlElement(name = "PayerPartyDebtorFinancialAccount")
    protected DebtorFinancialAccountType payerPartyDebtorFinancialAccount;
    @XmlElement(name = "PayeePartyCreditorFinancialAccount")
    protected CreditorFinancialAccountType payeePartyCreditorFinancialAccount;
    @XmlElement(name = "PayerSpecifiedDebtorFinancialInstitution")
    protected DebtorFinancialInstitutionType payerSpecifiedDebtorFinancialInstitution;
    @XmlElement(name = "PayeeSpecifiedCreditorFinancialInstitution")
    protected CreditorFinancialInstitutionType payeeSpecifiedCreditorFinancialInstitution;

    /**
     * Ruft den Wert der paymentChannelCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMeansChannelCodeType }
     *     
     */
    public PaymentMeansChannelCodeType getPaymentChannelCode() {
        return paymentChannelCode;
    }

    /**
     * Legt den Wert der paymentChannelCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMeansChannelCodeType }
     *     
     */
    public void setPaymentChannelCode(PaymentMeansChannelCodeType value) {
        this.paymentChannelCode = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMeansCodeType }
     *     
     */
    public PaymentMeansCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMeansCodeType }
     *     
     */
    public void setTypeCode(PaymentMeansCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der guaranteeMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentGuaranteeMeansCodeType }
     *     
     */
    public PaymentGuaranteeMeansCodeType getGuaranteeMethodCode() {
        return guaranteeMethodCode;
    }

    /**
     * Legt den Wert der guaranteeMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentGuaranteeMeansCodeType }
     *     
     */
    public void setGuaranteeMethodCode(PaymentGuaranteeMeansCodeType value) {
        this.guaranteeMethodCode = value;
    }

    /**
     * Ruft den Wert der paymentMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getPaymentMethodCode() {
        return paymentMethodCode;
    }

    /**
     * Legt den Wert der paymentMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setPaymentMethodCode(CodeType value) {
        this.paymentMethodCode = value;
    }

    /**
     * Gets the value of the information property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the information property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getInformation() {
        if (information == null) {
            information = new ArrayList<TextType>();
        }
        return this.information;
    }

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getID() {
        if (id == null) {
            id = new ArrayList<IDType>();
        }
        return this.id;
    }

    /**
     * Ruft den Wert der applicableTradeSettlementFinancialCard-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeSettlementFinancialCardType }
     *     
     */
    public TradeSettlementFinancialCardType getApplicableTradeSettlementFinancialCard() {
        return applicableTradeSettlementFinancialCard;
    }

    /**
     * Legt den Wert der applicableTradeSettlementFinancialCard-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeSettlementFinancialCardType }
     *     
     */
    public void setApplicableTradeSettlementFinancialCard(TradeSettlementFinancialCardType value) {
        this.applicableTradeSettlementFinancialCard = value;
    }

    /**
     * Ruft den Wert der payerPartyDebtorFinancialAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DebtorFinancialAccountType }
     *     
     */
    public DebtorFinancialAccountType getPayerPartyDebtorFinancialAccount() {
        return payerPartyDebtorFinancialAccount;
    }

    /**
     * Legt den Wert der payerPartyDebtorFinancialAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DebtorFinancialAccountType }
     *     
     */
    public void setPayerPartyDebtorFinancialAccount(DebtorFinancialAccountType value) {
        this.payerPartyDebtorFinancialAccount = value;
    }

    /**
     * Ruft den Wert der payeePartyCreditorFinancialAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CreditorFinancialAccountType }
     *     
     */
    public CreditorFinancialAccountType getPayeePartyCreditorFinancialAccount() {
        return payeePartyCreditorFinancialAccount;
    }

    /**
     * Legt den Wert der payeePartyCreditorFinancialAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorFinancialAccountType }
     *     
     */
    public void setPayeePartyCreditorFinancialAccount(CreditorFinancialAccountType value) {
        this.payeePartyCreditorFinancialAccount = value;
    }

    /**
     * Ruft den Wert der payerSpecifiedDebtorFinancialInstitution-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DebtorFinancialInstitutionType }
     *     
     */
    public DebtorFinancialInstitutionType getPayerSpecifiedDebtorFinancialInstitution() {
        return payerSpecifiedDebtorFinancialInstitution;
    }

    /**
     * Legt den Wert der payerSpecifiedDebtorFinancialInstitution-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DebtorFinancialInstitutionType }
     *     
     */
    public void setPayerSpecifiedDebtorFinancialInstitution(DebtorFinancialInstitutionType value) {
        this.payerSpecifiedDebtorFinancialInstitution = value;
    }

    /**
     * Ruft den Wert der payeeSpecifiedCreditorFinancialInstitution-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CreditorFinancialInstitutionType }
     *     
     */
    public CreditorFinancialInstitutionType getPayeeSpecifiedCreditorFinancialInstitution() {
        return payeeSpecifiedCreditorFinancialInstitution;
    }

    /**
     * Legt den Wert der payeeSpecifiedCreditorFinancialInstitution-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorFinancialInstitutionType }
     *     
     */
    public void setPayeeSpecifiedCreditorFinancialInstitution(CreditorFinancialInstitutionType value) {
        this.payeeSpecifiedCreditorFinancialInstitution = value;
    }

}
