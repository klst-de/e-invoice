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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für FinancialAdjustmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FinancialAdjustmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReasonCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="Reason" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ActualAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ActualQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="ActualDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="ClaimRelatedTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceReferenceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialAdjustmentType", propOrder = {
    "reasonCode",
    "reason",
    "actualAmount",
    "actualQuantity",
    "actualDateTime",
    "claimRelatedTradeParty",
    "invoiceReferenceReferencedDocument"
})
public class FinancialAdjustmentType {

    @XmlElement(name = "ReasonCode")
    protected CodeType reasonCode;
    @XmlElement(name = "Reason")
    protected List<TextType> reason;
    @XmlElement(name = "ActualAmount")
    protected List<AmountType> actualAmount;
    @XmlElement(name = "ActualQuantity")
    protected QuantityType actualQuantity;
    @XmlElement(name = "ActualDateTime")
    protected DateTimeType actualDateTime;
    @XmlElement(name = "ClaimRelatedTradeParty")
    protected TradePartyType claimRelatedTradeParty;
    @XmlElement(name = "InvoiceReferenceReferencedDocument")
    protected ReferencedDocumentType invoiceReferenceReferencedDocument;

    /**
     * Ruft den Wert der reasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getReasonCode() {
        return reasonCode;
    }

    /**
     * Legt den Wert der reasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setReasonCode(CodeType value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getReason() {
        if (reason == null) {
            reason = new ArrayList<TextType>();
        }
        return this.reason;
    }

    /**
     * Gets the value of the actualAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actualAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActualAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getActualAmount() {
        if (actualAmount == null) {
            actualAmount = new ArrayList<AmountType>();
        }
        return this.actualAmount;
    }

    /**
     * Ruft den Wert der actualQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getActualQuantity() {
        return actualQuantity;
    }

    /**
     * Legt den Wert der actualQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setActualQuantity(QuantityType value) {
        this.actualQuantity = value;
    }

    /**
     * Ruft den Wert der actualDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getActualDateTime() {
        return actualDateTime;
    }

    /**
     * Legt den Wert der actualDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setActualDateTime(DateTimeType value) {
        this.actualDateTime = value;
    }

    /**
     * Ruft den Wert der claimRelatedTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getClaimRelatedTradeParty() {
        return claimRelatedTradeParty;
    }

    /**
     * Legt den Wert der claimRelatedTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setClaimRelatedTradeParty(TradePartyType value) {
        this.claimRelatedTradeParty = value;
    }

    /**
     * Ruft den Wert der invoiceReferenceReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getInvoiceReferenceReferencedDocument() {
        return invoiceReferenceReferencedDocument;
    }

    /**
     * Legt den Wert der invoiceReferenceReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setInvoiceReferenceReferencedDocument(ReferencedDocumentType value) {
        this.invoiceReferenceReferencedDocument = value;
    }

}
