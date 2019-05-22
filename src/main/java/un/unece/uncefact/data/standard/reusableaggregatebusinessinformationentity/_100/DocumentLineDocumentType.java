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
import un.unece.uncefact.data.standard.qualifieddatatype._100.LineStatusCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;


/**
 * <p>Java-Klasse für DocumentLineDocumentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DocumentLineDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LineID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="ParentLineID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="LineStatusCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}LineStatusCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LineStatusReasonCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="IncludedNote" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}NoteType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentLineDocumentType", propOrder = {
    "lineID",
    "parentLineID",
    "lineStatusCode",
    "lineStatusReasonCode",
    "includedNote"
})
public class DocumentLineDocumentType {

    @XmlElement(name = "LineID")
    protected IDType lineID;
    @XmlElement(name = "ParentLineID")
    protected IDType parentLineID;
    @XmlElement(name = "LineStatusCode")
    protected LineStatusCodeType lineStatusCode;
    @XmlElement(name = "LineStatusReasonCode")
    protected CodeType lineStatusReasonCode;
    @XmlElement(name = "IncludedNote")
    protected List<NoteType> includedNote;

    /**
     * Ruft den Wert der lineID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getLineID() {
        return lineID;
    }

    /**
     * Legt den Wert der lineID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setLineID(IDType value) {
        this.lineID = value;
    }

    /**
     * Ruft den Wert der parentLineID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getParentLineID() {
        return parentLineID;
    }

    /**
     * Legt den Wert der parentLineID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setParentLineID(IDType value) {
        this.parentLineID = value;
    }

    /**
     * Ruft den Wert der lineStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineStatusCodeType }
     *     
     */
    public LineStatusCodeType getLineStatusCode() {
        return lineStatusCode;
    }

    /**
     * Legt den Wert der lineStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStatusCodeType }
     *     
     */
    public void setLineStatusCode(LineStatusCodeType value) {
        this.lineStatusCode = value;
    }

    /**
     * Ruft den Wert der lineStatusReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getLineStatusReasonCode() {
        return lineStatusReasonCode;
    }

    /**
     * Legt den Wert der lineStatusReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setLineStatusReasonCode(CodeType value) {
        this.lineStatusReasonCode = value;
    }

    /**
     * Gets the value of the includedNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getIncludedNote() {
        if (includedNote == null) {
            includedNote = new ArrayList<NoteType>();
        }
        return this.includedNote;
    }

}
