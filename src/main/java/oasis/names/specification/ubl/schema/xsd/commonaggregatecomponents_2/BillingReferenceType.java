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


/**
 * <p>Java-Klasse für BillingReferenceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BillingReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}InvoiceDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SelfBilledInvoiceDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CreditNoteDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SelfBilledCreditNoteDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DebitNoteDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReminderDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BillingReferenceLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingReferenceType", propOrder = {
    "invoiceDocumentReference",
    "selfBilledInvoiceDocumentReference",
    "creditNoteDocumentReference",
    "selfBilledCreditNoteDocumentReference",
    "debitNoteDocumentReference",
    "reminderDocumentReference",
    "additionalDocumentReference",
    "billingReferenceLine"
})
public class BillingReferenceType {

    @XmlElement(name = "InvoiceDocumentReference")
    protected DocumentReferenceType invoiceDocumentReference;
    @XmlElement(name = "SelfBilledInvoiceDocumentReference")
    protected DocumentReferenceType selfBilledInvoiceDocumentReference;
    @XmlElement(name = "CreditNoteDocumentReference")
    protected DocumentReferenceType creditNoteDocumentReference;
    @XmlElement(name = "SelfBilledCreditNoteDocumentReference")
    protected DocumentReferenceType selfBilledCreditNoteDocumentReference;
    @XmlElement(name = "DebitNoteDocumentReference")
    protected DocumentReferenceType debitNoteDocumentReference;
    @XmlElement(name = "ReminderDocumentReference")
    protected DocumentReferenceType reminderDocumentReference;
    @XmlElement(name = "AdditionalDocumentReference")
    protected DocumentReferenceType additionalDocumentReference;
    @XmlElement(name = "BillingReferenceLine")
    protected List<BillingReferenceLineType> billingReferenceLine;

    /**
     * Ruft den Wert der invoiceDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getInvoiceDocumentReference() {
        return invoiceDocumentReference;
    }

    /**
     * Legt den Wert der invoiceDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setInvoiceDocumentReference(DocumentReferenceType value) {
        this.invoiceDocumentReference = value;
    }

    /**
     * Ruft den Wert der selfBilledInvoiceDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getSelfBilledInvoiceDocumentReference() {
        return selfBilledInvoiceDocumentReference;
    }

    /**
     * Legt den Wert der selfBilledInvoiceDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setSelfBilledInvoiceDocumentReference(DocumentReferenceType value) {
        this.selfBilledInvoiceDocumentReference = value;
    }

    /**
     * Ruft den Wert der creditNoteDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getCreditNoteDocumentReference() {
        return creditNoteDocumentReference;
    }

    /**
     * Legt den Wert der creditNoteDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setCreditNoteDocumentReference(DocumentReferenceType value) {
        this.creditNoteDocumentReference = value;
    }

    /**
     * Ruft den Wert der selfBilledCreditNoteDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getSelfBilledCreditNoteDocumentReference() {
        return selfBilledCreditNoteDocumentReference;
    }

    /**
     * Legt den Wert der selfBilledCreditNoteDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setSelfBilledCreditNoteDocumentReference(DocumentReferenceType value) {
        this.selfBilledCreditNoteDocumentReference = value;
    }

    /**
     * Ruft den Wert der debitNoteDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getDebitNoteDocumentReference() {
        return debitNoteDocumentReference;
    }

    /**
     * Legt den Wert der debitNoteDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setDebitNoteDocumentReference(DocumentReferenceType value) {
        this.debitNoteDocumentReference = value;
    }

    /**
     * Ruft den Wert der reminderDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getReminderDocumentReference() {
        return reminderDocumentReference;
    }

    /**
     * Legt den Wert der reminderDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setReminderDocumentReference(DocumentReferenceType value) {
        this.reminderDocumentReference = value;
    }

    /**
     * Ruft den Wert der additionalDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * Legt den Wert der additionalDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setAdditionalDocumentReference(DocumentReferenceType value) {
        this.additionalDocumentReference = value;
    }

    /**
     * Gets the value of the billingReferenceLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingReferenceLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingReferenceLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingReferenceLineType }
     * 
     * 
     */
    public List<BillingReferenceLineType> getBillingReferenceLine() {
        if (billingReferenceLine == null) {
            billingReferenceLine = new ArrayList<BillingReferenceLineType>();
        }
        return this.billingReferenceLine;
    }

}
