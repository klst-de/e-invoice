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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OptionalLineItemIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrivacyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SecurityClassificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;


/**
 * <p>Java-Klasse für RequestForQuotationLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RequestForQuotationLineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OptionalLineItemIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrivacyCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SecurityClassificationCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LineItem"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestForQuotationLineType", propOrder = {
    "id",
    "uuid",
    "note",
    "optionalLineItemIndicator",
    "privacyCode",
    "securityClassificationCode",
    "documentReference",
    "lineItem"
})
public class RequestForQuotationLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UUIDType uuid;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "OptionalLineItemIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OptionalLineItemIndicatorType optionalLineItemIndicator;
    @XmlElement(name = "PrivacyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrivacyCodeType privacyCode;
    @XmlElement(name = "SecurityClassificationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SecurityClassificationCodeType securityClassificationCode;
    @XmlElement(name = "DocumentReference")
    protected List<DocumentReferenceType> documentReference;
    @XmlElement(name = "LineItem", required = true)
    protected LineItemType lineItem;

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
     * Ruft den Wert der optionalLineItemIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OptionalLineItemIndicatorType }
     *     
     */
    public OptionalLineItemIndicatorType getOptionalLineItemIndicator() {
        return optionalLineItemIndicator;
    }

    /**
     * Legt den Wert der optionalLineItemIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionalLineItemIndicatorType }
     *     
     */
    public void setOptionalLineItemIndicator(OptionalLineItemIndicatorType value) {
        this.optionalLineItemIndicator = value;
    }

    /**
     * Ruft den Wert der privacyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PrivacyCodeType }
     *     
     */
    public PrivacyCodeType getPrivacyCode() {
        return privacyCode;
    }

    /**
     * Legt den Wert der privacyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivacyCodeType }
     *     
     */
    public void setPrivacyCode(PrivacyCodeType value) {
        this.privacyCode = value;
    }

    /**
     * Ruft den Wert der securityClassificationCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SecurityClassificationCodeType }
     *     
     */
    public SecurityClassificationCodeType getSecurityClassificationCode() {
        return securityClassificationCode;
    }

    /**
     * Legt den Wert der securityClassificationCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityClassificationCodeType }
     *     
     */
    public void setSecurityClassificationCode(SecurityClassificationCodeType value) {
        this.securityClassificationCode = value;
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

}
