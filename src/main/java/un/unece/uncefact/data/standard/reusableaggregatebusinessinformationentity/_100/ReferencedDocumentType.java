//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentStatusCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.ReferenceCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.BinaryObjectType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für ReferencedDocumentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReferencedDocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IssuerAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="URIID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="StatusCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}DocumentStatusCodeType" minOccurs="0"/>
 *         &lt;element name="CopyIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="LineID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}DocumentCodeType" minOccurs="0"/>
 *         &lt;element name="GlobalID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="RevisionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AttachmentBinaryObject" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}BinaryObjectType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Information" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReferenceTypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}ReferenceCodeType" minOccurs="0"/>
 *         &lt;element name="SectionName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PreviousRevisionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FormattedIssueDateTime" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}FormattedDateTimeType" minOccurs="0"/>
 *         &lt;element name="EffectiveSpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/>
 *         &lt;element name="IssuerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="AttachedSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencedDocumentType", propOrder = {
    "issuerAssignedID",
    "uriid",
    "statusCode",
    "copyIndicator",
    "lineID",
    "typeCode",
    "globalID",
    "revisionID",
    "name",
    "attachmentBinaryObject",
    "information",
    "referenceTypeCode",
    "sectionName",
    "previousRevisionID",
    "formattedIssueDateTime",
    "effectiveSpecifiedPeriod",
    "issuerTradeParty",
    "attachedSpecifiedBinaryFile"
})
public class ReferencedDocumentType {

    @XmlElement(name = "IssuerAssignedID")
    protected IDType issuerAssignedID;
    @XmlElement(name = "URIID")
    protected IDType uriid;
    @XmlElement(name = "StatusCode")
    protected DocumentStatusCodeType statusCode;
    @XmlElement(name = "CopyIndicator")
    protected IndicatorType copyIndicator;
    @XmlElement(name = "LineID")
    protected IDType lineID;
    @XmlElement(name = "TypeCode")
    protected DocumentCodeType typeCode;
    @XmlElement(name = "GlobalID")
    protected IDType globalID;
    @XmlElement(name = "RevisionID")
    protected IDType revisionID;
    @XmlElement(name = "Name")
    protected List<TextType> name;
    @XmlElement(name = "AttachmentBinaryObject")
    protected List<BinaryObjectType> attachmentBinaryObject;
    @XmlElement(name = "Information")
    protected List<TextType> information;
    @XmlElement(name = "ReferenceTypeCode")
    protected ReferenceCodeType referenceTypeCode;
    @XmlElement(name = "SectionName")
    protected List<TextType> sectionName;
    @XmlElement(name = "PreviousRevisionID")
    protected List<IDType> previousRevisionID;
    @XmlElement(name = "FormattedIssueDateTime")
    protected FormattedDateTimeType formattedIssueDateTime;
    @XmlElement(name = "EffectiveSpecifiedPeriod")
    protected SpecifiedPeriodType effectiveSpecifiedPeriod;
    @XmlElement(name = "IssuerTradeParty")
    protected TradePartyType issuerTradeParty;
    @XmlElement(name = "AttachedSpecifiedBinaryFile")
    protected List<SpecifiedBinaryFileType> attachedSpecifiedBinaryFile;

    /**
     * Ruft den Wert der issuerAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getIssuerAssignedID() {
        return issuerAssignedID;
    }

    /**
     * Legt den Wert der issuerAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setIssuerAssignedID(IDType value) {
        this.issuerAssignedID = value;
    }

    /**
     * Ruft den Wert der uriid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getURIID() {
        return uriid;
    }

    /**
     * Legt den Wert der uriid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setURIID(IDType value) {
        this.uriid = value;
    }

    /**
     * Ruft den Wert der statusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentStatusCodeType }
     *     
     */
    public DocumentStatusCodeType getStatusCode() {
        return statusCode;
    }

    /**
     * Legt den Wert der statusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentStatusCodeType }
     *     
     */
    public void setStatusCode(DocumentStatusCodeType value) {
        this.statusCode = value;
    }

    /**
     * Ruft den Wert der copyIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getCopyIndicator() {
        return copyIndicator;
    }

    /**
     * Legt den Wert der copyIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setCopyIndicator(IndicatorType value) {
        this.copyIndicator = value;
    }

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
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentCodeType }
     *     
     */
    public DocumentCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentCodeType }
     *     
     */
    public void setTypeCode(DocumentCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der globalID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getGlobalID() {
        return globalID;
    }

    /**
     * Legt den Wert der globalID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setGlobalID(IDType value) {
        this.globalID = value;
    }

    /**
     * Ruft den Wert der revisionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getRevisionID() {
        return revisionID;
    }

    /**
     * Legt den Wert der revisionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setRevisionID(IDType value) {
        this.revisionID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getName() {
        if (name == null) {
            name = new ArrayList<TextType>();
        }
        return this.name;
    }

    /**
     * Gets the value of the attachmentBinaryObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachmentBinaryObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachmentBinaryObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BinaryObjectType }
     * 
     * 
     */
    public List<BinaryObjectType> getAttachmentBinaryObject() {
        if (attachmentBinaryObject == null) {
            attachmentBinaryObject = new ArrayList<BinaryObjectType>();
        }
        return this.attachmentBinaryObject;
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
     * Ruft den Wert der referenceTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceCodeType }
     *     
     */
    public ReferenceCodeType getReferenceTypeCode() {
        return referenceTypeCode;
    }

    /**
     * Legt den Wert der referenceTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceCodeType }
     *     
     */
    public void setReferenceTypeCode(ReferenceCodeType value) {
        this.referenceTypeCode = value;
    }

    /**
     * Gets the value of the sectionName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sectionName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSectionName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getSectionName() {
        if (sectionName == null) {
            sectionName = new ArrayList<TextType>();
        }
        return this.sectionName;
    }

    /**
     * Gets the value of the previousRevisionID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previousRevisionID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreviousRevisionID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getPreviousRevisionID() {
        if (previousRevisionID == null) {
            previousRevisionID = new ArrayList<IDType>();
        }
        return this.previousRevisionID;
    }

    /**
     * Ruft den Wert der formattedIssueDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public FormattedDateTimeType getFormattedIssueDateTime() {
        return formattedIssueDateTime;
    }

    /**
     * Legt den Wert der formattedIssueDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public void setFormattedIssueDateTime(FormattedDateTimeType value) {
        this.formattedIssueDateTime = value;
    }

    /**
     * Ruft den Wert der effectiveSpecifiedPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public SpecifiedPeriodType getEffectiveSpecifiedPeriod() {
        return effectiveSpecifiedPeriod;
    }

    /**
     * Legt den Wert der effectiveSpecifiedPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public void setEffectiveSpecifiedPeriod(SpecifiedPeriodType value) {
        this.effectiveSpecifiedPeriod = value;
    }

    /**
     * Ruft den Wert der issuerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getIssuerTradeParty() {
        return issuerTradeParty;
    }

    /**
     * Legt den Wert der issuerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setIssuerTradeParty(TradePartyType value) {
        this.issuerTradeParty = value;
    }

    /**
     * Gets the value of the attachedSpecifiedBinaryFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachedSpecifiedBinaryFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachedSpecifiedBinaryFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecifiedBinaryFileType }
     * 
     * 
     */
    public List<SpecifiedBinaryFileType> getAttachedSpecifiedBinaryFile() {
        if (attachedSpecifiedBinaryFile == null) {
            attachedSpecifiedBinaryFile = new ArrayList<SpecifiedBinaryFileType>();
        }
        return this.attachedSpecifiedBinaryFile;
    }

}
