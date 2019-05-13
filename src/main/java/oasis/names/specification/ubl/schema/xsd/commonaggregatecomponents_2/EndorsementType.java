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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ApprovalStatusType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RemarksType;


/**
 * <p>Java-Klasse für EndorsementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EndorsementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DocumentID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ApprovalStatus"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Remarks" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EndorserParty"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndorsementType", propOrder = {
    "documentID",
    "approvalStatus",
    "remarks",
    "endorserParty",
    "signature"
})
public class EndorsementType {

    @XmlElement(name = "DocumentID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected DocumentIDType documentID;
    @XmlElement(name = "ApprovalStatus", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ApprovalStatusType approvalStatus;
    @XmlElement(name = "Remarks", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RemarksType> remarks;
    @XmlElement(name = "EndorserParty", required = true)
    protected EndorserPartyType endorserParty;
    @XmlElement(name = "Signature")
    protected List<SignatureType> signature;

    /**
     * Ruft den Wert der documentID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentIDType }
     *     
     */
    public DocumentIDType getDocumentID() {
        return documentID;
    }

    /**
     * Legt den Wert der documentID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentIDType }
     *     
     */
    public void setDocumentID(DocumentIDType value) {
        this.documentID = value;
    }

    /**
     * Ruft den Wert der approvalStatus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalStatusType }
     *     
     */
    public ApprovalStatusType getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Legt den Wert der approvalStatus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalStatusType }
     *     
     */
    public void setApprovalStatus(ApprovalStatusType value) {
        this.approvalStatus = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemarks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemarksType }
     * 
     * 
     */
    public List<RemarksType> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<RemarksType>();
        }
        return this.remarks;
    }

    /**
     * Ruft den Wert der endorserParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EndorserPartyType }
     *     
     */
    public EndorserPartyType getEndorserParty() {
        return endorserParty;
    }

    /**
     * Legt den Wert der endorserParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EndorserPartyType }
     *     
     */
    public void setEndorserParty(EndorserPartyType value) {
        this.endorserParty = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureType }
     * 
     * 
     */
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
    }

}
