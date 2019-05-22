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
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.MessageFunctionCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für ExchangedDocumentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ExchangedDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType"/&gt;
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}DocumentCodeType" minOccurs="0"/&gt;
 *         &lt;element name="IssueDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType"/&gt;
 *         &lt;element name="CopyIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="Purpose" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="ControlRequirementIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="LanguageID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PurposeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}MessageFunctionCodeType" minOccurs="0"/&gt;
 *         &lt;element name="RevisionDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="VersionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="GlobalID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="RevisionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="PreviousRevisionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="CategoryCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="IncludedNote" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}NoteType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="EffectiveSpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/&gt;
 *         &lt;element name="IssuerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangedDocumentType", propOrder = {
    "id",
    "name",
    "typeCode",
    "issueDateTime",
    "copyIndicator",
    "purpose",
    "controlRequirementIndicator",
    "languageID",
    "purposeCode",
    "revisionDateTime",
    "versionID",
    "globalID",
    "revisionID",
    "previousRevisionID",
    "categoryCode",
    "includedNote",
    "effectiveSpecifiedPeriod",
    "issuerTradeParty"
})
public class ExchangedDocumentType {

    @XmlElement(name = "ID", required = true)
    protected IDType id;
    @XmlElement(name = "Name")
    protected List<TextType> name;
    @XmlElement(name = "TypeCode")
    protected DocumentCodeType typeCode;
    @XmlElement(name = "IssueDateTime", required = true)
    protected DateTimeType issueDateTime;
    @XmlElement(name = "CopyIndicator")
    protected IndicatorType copyIndicator;
    @XmlElement(name = "Purpose")
    protected TextType purpose;
    @XmlElement(name = "ControlRequirementIndicator")
    protected IndicatorType controlRequirementIndicator;
    @XmlElement(name = "LanguageID")
    protected List<IDType> languageID;
    @XmlElement(name = "PurposeCode")
    protected MessageFunctionCodeType purposeCode;
    @XmlElement(name = "RevisionDateTime")
    protected DateTimeType revisionDateTime;
    @XmlElement(name = "VersionID")
    protected IDType versionID;
    @XmlElement(name = "GlobalID")
    protected IDType globalID;
    @XmlElement(name = "RevisionID")
    protected IDType revisionID;
    @XmlElement(name = "PreviousRevisionID")
    protected IDType previousRevisionID;
    @XmlElement(name = "CategoryCode")
    protected CodeType categoryCode;
    @XmlElement(name = "IncludedNote")
    protected List<NoteType> includedNote;
    @XmlElement(name = "EffectiveSpecifiedPeriod")
    protected SpecifiedPeriodType effectiveSpecifiedPeriod;
    @XmlElement(name = "IssuerTradeParty")
    protected TradePartyType issuerTradeParty;

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
     * Ruft den Wert der issueDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getIssueDateTime() {
        return issueDateTime;
    }

    /**
     * Legt den Wert der issueDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setIssueDateTime(DateTimeType value) {
        this.issueDateTime = value;
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
     * Ruft den Wert der purpose-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPurpose() {
        return purpose;
    }

    /**
     * Legt den Wert der purpose-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPurpose(TextType value) {
        this.purpose = value;
    }

    /**
     * Ruft den Wert der controlRequirementIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getControlRequirementIndicator() {
        return controlRequirementIndicator;
    }

    /**
     * Legt den Wert der controlRequirementIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setControlRequirementIndicator(IndicatorType value) {
        this.controlRequirementIndicator = value;
    }

    /**
     * Gets the value of the languageID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languageID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguageID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getLanguageID() {
        if (languageID == null) {
            languageID = new ArrayList<IDType>();
        }
        return this.languageID;
    }

    /**
     * Ruft den Wert der purposeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MessageFunctionCodeType }
     *     
     */
    public MessageFunctionCodeType getPurposeCode() {
        return purposeCode;
    }

    /**
     * Legt den Wert der purposeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageFunctionCodeType }
     *     
     */
    public void setPurposeCode(MessageFunctionCodeType value) {
        this.purposeCode = value;
    }

    /**
     * Ruft den Wert der revisionDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getRevisionDateTime() {
        return revisionDateTime;
    }

    /**
     * Legt den Wert der revisionDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setRevisionDateTime(DateTimeType value) {
        this.revisionDateTime = value;
    }

    /**
     * Ruft den Wert der versionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getVersionID() {
        return versionID;
    }

    /**
     * Legt den Wert der versionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setVersionID(IDType value) {
        this.versionID = value;
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
     * Ruft den Wert der previousRevisionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getPreviousRevisionID() {
        return previousRevisionID;
    }

    /**
     * Legt den Wert der previousRevisionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setPreviousRevisionID(IDType value) {
        this.previousRevisionID = value;
    }

    /**
     * Ruft den Wert der categoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getCategoryCode() {
        return categoryCode;
    }

    /**
     * Legt den Wert der categoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setCategoryCode(CodeType value) {
        this.categoryCode = value;
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

}
