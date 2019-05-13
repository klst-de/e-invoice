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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestForQuotationLineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalTaxAmountType;


/**
 * <p>Java-Klasse für QuotationLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="QuotationLineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineExtensionAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalTaxAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequestForQuotationLineID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LineItem"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SellerProposedSubstituteLineItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AlternativeLineItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestLineReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuotationLineType", propOrder = {
    "id",
    "note",
    "quantity",
    "lineExtensionAmount",
    "totalTaxAmount",
    "requestForQuotationLineID",
    "documentReference",
    "lineItem",
    "sellerProposedSubstituteLineItem",
    "alternativeLineItem",
    "requestLineReference"
})
public class QuotationLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "LineExtensionAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineExtensionAmountType lineExtensionAmount;
    @XmlElement(name = "TotalTaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalTaxAmountType totalTaxAmount;
    @XmlElement(name = "RequestForQuotationLineID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequestForQuotationLineIDType requestForQuotationLineID;
    @XmlElement(name = "DocumentReference")
    protected List<DocumentReferenceType> documentReference;
    @XmlElement(name = "LineItem", required = true)
    protected LineItemType lineItem;
    @XmlElement(name = "SellerProposedSubstituteLineItem")
    protected List<LineItemType> sellerProposedSubstituteLineItem;
    @XmlElement(name = "AlternativeLineItem")
    protected List<LineItemType> alternativeLineItem;
    @XmlElement(name = "RequestLineReference")
    protected LineReferenceType requestLineReference;

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
     * Ruft den Wert der quantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Legt den Wert der quantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * Ruft den Wert der lineExtensionAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public LineExtensionAmountType getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    /**
     * Legt den Wert der lineExtensionAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public void setLineExtensionAmount(LineExtensionAmountType value) {
        this.lineExtensionAmount = value;
    }

    /**
     * Ruft den Wert der totalTaxAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalTaxAmountType }
     *     
     */
    public TotalTaxAmountType getTotalTaxAmount() {
        return totalTaxAmount;
    }

    /**
     * Legt den Wert der totalTaxAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalTaxAmountType }
     *     
     */
    public void setTotalTaxAmount(TotalTaxAmountType value) {
        this.totalTaxAmount = value;
    }

    /**
     * Ruft den Wert der requestForQuotationLineID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequestForQuotationLineIDType }
     *     
     */
    public RequestForQuotationLineIDType getRequestForQuotationLineID() {
        return requestForQuotationLineID;
    }

    /**
     * Legt den Wert der requestForQuotationLineID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestForQuotationLineIDType }
     *     
     */
    public void setRequestForQuotationLineID(RequestForQuotationLineIDType value) {
        this.requestForQuotationLineID = value;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.documentReference;
    }

    /**
     * Ruft den Wert der lineItem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineItemType }
     *     
     */
    public LineItemType getLineItem() {
        return lineItem;
    }

    /**
     * Legt den Wert der lineItem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineItemType }
     *     
     */
    public void setLineItem(LineItemType value) {
        this.lineItem = value;
    }

    /**
     * Gets the value of the sellerProposedSubstituteLineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sellerProposedSubstituteLineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSellerProposedSubstituteLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineItemType }
     * 
     * 
     */
    public List<LineItemType> getSellerProposedSubstituteLineItem() {
        if (sellerProposedSubstituteLineItem == null) {
            sellerProposedSubstituteLineItem = new ArrayList<LineItemType>();
        }
        return this.sellerProposedSubstituteLineItem;
    }

    /**
     * Gets the value of the alternativeLineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternativeLineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternativeLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineItemType }
     * 
     * 
     */
    public List<LineItemType> getAlternativeLineItem() {
        if (alternativeLineItem == null) {
            alternativeLineItem = new ArrayList<LineItemType>();
        }
        return this.alternativeLineItem;
    }

    /**
     * Ruft den Wert der requestLineReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineReferenceType }
     *     
     */
    public LineReferenceType getRequestLineReference() {
        return requestLineReference;
    }

    /**
     * Legt den Wert der requestLineReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineReferenceType }
     *     
     */
    public void setRequestLineReference(LineReferenceType value) {
        this.requestLineReference = value;
    }

}
