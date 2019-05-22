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
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentTermsEventTimeReferenceCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentTermsIDType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentTermsTypeCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradePaymentTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradePaymentTermsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PaymentTermsIDType" minOccurs="0"/&gt;
 *         &lt;element name="FromEventCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PaymentTermsEventTimeReferenceCodeType" minOccurs="0"/&gt;
 *         &lt;element name="SettlementPeriodMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DueDateDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PaymentTermsTypeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="InstructionTypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="DirectDebitMandateID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PartialPaymentPercent" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}PercentType" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMeansID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PartialPaymentAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableTradePaymentPenaltyTerms" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePaymentPenaltyTermsType" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableTradePaymentDiscountTerms" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePaymentDiscountTermsType" minOccurs="0"/&gt;
 *         &lt;element name="PayeeTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePaymentTermsType", propOrder = {
    "id",
    "fromEventCode",
    "settlementPeriodMeasure",
    "description",
    "dueDateDateTime",
    "typeCode",
    "instructionTypeCode",
    "directDebitMandateID",
    "partialPaymentPercent",
    "paymentMeansID",
    "partialPaymentAmount",
    "applicableTradePaymentPenaltyTerms",
    "applicableTradePaymentDiscountTerms",
    "payeeTradeParty"
})
public class TradePaymentTermsType {

    @XmlElement(name = "ID")
    protected PaymentTermsIDType id;
    @XmlElement(name = "FromEventCode")
    protected PaymentTermsEventTimeReferenceCodeType fromEventCode;
    @XmlElement(name = "SettlementPeriodMeasure")
    protected MeasureType settlementPeriodMeasure;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "DueDateDateTime")
    protected DateTimeType dueDateDateTime;
    @XmlElement(name = "TypeCode")
    protected PaymentTermsTypeCodeType typeCode;
    @XmlElement(name = "InstructionTypeCode")
    protected CodeType instructionTypeCode;
    @XmlElement(name = "DirectDebitMandateID")
    protected List<IDType> directDebitMandateID;
    @XmlElement(name = "PartialPaymentPercent")
    protected PercentType partialPaymentPercent;
    @XmlElement(name = "PaymentMeansID")
    protected List<IDType> paymentMeansID;
    @XmlElement(name = "PartialPaymentAmount")
    protected List<AmountType> partialPaymentAmount;
    @XmlElement(name = "ApplicableTradePaymentPenaltyTerms")
    protected TradePaymentPenaltyTermsType applicableTradePaymentPenaltyTerms;
    @XmlElement(name = "ApplicableTradePaymentDiscountTerms")
    protected TradePaymentDiscountTermsType applicableTradePaymentDiscountTerms;
    @XmlElement(name = "PayeeTradeParty")
    protected List<TradePartyType> payeeTradeParty;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsIDType }
     *     
     */
    public PaymentTermsIDType getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsIDType }
     *     
     */
    public void setID(PaymentTermsIDType value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der fromEventCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsEventTimeReferenceCodeType }
     *     
     */
    public PaymentTermsEventTimeReferenceCodeType getFromEventCode() {
        return fromEventCode;
    }

    /**
     * Legt den Wert der fromEventCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsEventTimeReferenceCodeType }
     *     
     */
    public void setFromEventCode(PaymentTermsEventTimeReferenceCodeType value) {
        this.fromEventCode = value;
    }

    /**
     * Ruft den Wert der settlementPeriodMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getSettlementPeriodMeasure() {
        return settlementPeriodMeasure;
    }

    /**
     * Legt den Wert der settlementPeriodMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setSettlementPeriodMeasure(MeasureType value) {
        this.settlementPeriodMeasure = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDescription() {
        if (description == null) {
            description = new ArrayList<TextType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der dueDateDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getDueDateDateTime() {
        return dueDateDateTime;
    }

    /**
     * Legt den Wert der dueDateDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setDueDateDateTime(DateTimeType value) {
        this.dueDateDateTime = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsTypeCodeType }
     *     
     */
    public PaymentTermsTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsTypeCodeType }
     *     
     */
    public void setTypeCode(PaymentTermsTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der instructionTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getInstructionTypeCode() {
        return instructionTypeCode;
    }

    /**
     * Legt den Wert der instructionTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setInstructionTypeCode(CodeType value) {
        this.instructionTypeCode = value;
    }

    /**
     * Gets the value of the directDebitMandateID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directDebitMandateID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectDebitMandateID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getDirectDebitMandateID() {
        if (directDebitMandateID == null) {
            directDebitMandateID = new ArrayList<IDType>();
        }
        return this.directDebitMandateID;
    }

    /**
     * Ruft den Wert der partialPaymentPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PercentType }
     *     
     */
    public PercentType getPartialPaymentPercent() {
        return partialPaymentPercent;
    }

    /**
     * Legt den Wert der partialPaymentPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PercentType }
     *     
     */
    public void setPartialPaymentPercent(PercentType value) {
        this.partialPaymentPercent = value;
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
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getPaymentMeansID() {
        if (paymentMeansID == null) {
            paymentMeansID = new ArrayList<IDType>();
        }
        return this.paymentMeansID;
    }

    /**
     * Gets the value of the partialPaymentAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partialPaymentAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartialPaymentAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getPartialPaymentAmount() {
        if (partialPaymentAmount == null) {
            partialPaymentAmount = new ArrayList<AmountType>();
        }
        return this.partialPaymentAmount;
    }

    /**
     * Ruft den Wert der applicableTradePaymentPenaltyTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePaymentPenaltyTermsType }
     *     
     */
    public TradePaymentPenaltyTermsType getApplicableTradePaymentPenaltyTerms() {
        return applicableTradePaymentPenaltyTerms;
    }

    /**
     * Legt den Wert der applicableTradePaymentPenaltyTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePaymentPenaltyTermsType }
     *     
     */
    public void setApplicableTradePaymentPenaltyTerms(TradePaymentPenaltyTermsType value) {
        this.applicableTradePaymentPenaltyTerms = value;
    }

    /**
     * Ruft den Wert der applicableTradePaymentDiscountTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePaymentDiscountTermsType }
     *     
     */
    public TradePaymentDiscountTermsType getApplicableTradePaymentDiscountTerms() {
        return applicableTradePaymentDiscountTerms;
    }

    /**
     * Legt den Wert der applicableTradePaymentDiscountTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePaymentDiscountTermsType }
     *     
     */
    public void setApplicableTradePaymentDiscountTerms(TradePaymentDiscountTermsType value) {
        this.applicableTradePaymentDiscountTerms = value;
    }

    /**
     * Gets the value of the payeeTradeParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payeeTradeParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayeeTradeParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradePartyType }
     * 
     * 
     */
    public List<TradePartyType> getPayeeTradeParty() {
        if (payeeTradeParty == null) {
            payeeTradeParty = new ArrayList<TradePartyType>();
        }
        return this.payeeTradeParty;
    }

}
