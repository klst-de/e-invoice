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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.BinaryObjectType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für SpecifiedBinaryFileType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpecifiedBinaryFileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Title" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AuthorName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VersionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="FileName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="URIID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="MIMECode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="EncodingCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="CharacterSetCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="IncludedBinaryObject" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}BinaryObjectType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Access" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SizeMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="AccessAvailabilitySpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecifiedBinaryFileType", propOrder = {
    "id",
    "title",
    "authorName",
    "versionID",
    "fileName",
    "uriid",
    "mimeCode",
    "encodingCode",
    "characterSetCode",
    "includedBinaryObject",
    "access",
    "description",
    "sizeMeasure",
    "accessAvailabilitySpecifiedPeriod"
})
public class SpecifiedBinaryFileType {

    @XmlElement(name = "ID")
    protected List<IDType> id;
    @XmlElement(name = "Title")
    protected List<TextType> title;
    @XmlElement(name = "AuthorName")
    protected List<TextType> authorName;
    @XmlElement(name = "VersionID")
    protected IDType versionID;
    @XmlElement(name = "FileName")
    protected TextType fileName;
    @XmlElement(name = "URIID")
    protected IDType uriid;
    @XmlElement(name = "MIMECode")
    protected CodeType mimeCode;
    @XmlElement(name = "EncodingCode")
    protected CodeType encodingCode;
    @XmlElement(name = "CharacterSetCode")
    protected CodeType characterSetCode;
    @XmlElement(name = "IncludedBinaryObject")
    protected List<BinaryObjectType> includedBinaryObject;
    @XmlElement(name = "Access")
    protected List<TextType> access;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "SizeMeasure")
    protected MeasureType sizeMeasure;
    @XmlElement(name = "AccessAvailabilitySpecifiedPeriod")
    protected SpecifiedPeriodType accessAvailabilitySpecifiedPeriod;

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
     * Gets the value of the title property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the title property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getTitle() {
        if (title == null) {
            title = new ArrayList<TextType>();
        }
        return this.title;
    }

    /**
     * Gets the value of the authorName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getAuthorName() {
        if (authorName == null) {
            authorName = new ArrayList<TextType>();
        }
        return this.authorName;
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
     * Ruft den Wert der fileName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFileName() {
        return fileName;
    }

    /**
     * Legt den Wert der fileName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFileName(TextType value) {
        this.fileName = value;
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
     * Ruft den Wert der mimeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getMIMECode() {
        return mimeCode;
    }

    /**
     * Legt den Wert der mimeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setMIMECode(CodeType value) {
        this.mimeCode = value;
    }

    /**
     * Ruft den Wert der encodingCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getEncodingCode() {
        return encodingCode;
    }

    /**
     * Legt den Wert der encodingCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setEncodingCode(CodeType value) {
        this.encodingCode = value;
    }

    /**
     * Ruft den Wert der characterSetCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getCharacterSetCode() {
        return characterSetCode;
    }

    /**
     * Legt den Wert der characterSetCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setCharacterSetCode(CodeType value) {
        this.characterSetCode = value;
    }

    /**
     * Gets the value of the includedBinaryObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedBinaryObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedBinaryObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BinaryObjectType }
     * 
     * 
     */
    public List<BinaryObjectType> getIncludedBinaryObject() {
        if (includedBinaryObject == null) {
            includedBinaryObject = new ArrayList<BinaryObjectType>();
        }
        return this.includedBinaryObject;
    }

    /**
     * Gets the value of the access property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the access property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getAccess() {
        if (access == null) {
            access = new ArrayList<TextType>();
        }
        return this.access;
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
     * Ruft den Wert der sizeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getSizeMeasure() {
        return sizeMeasure;
    }

    /**
     * Legt den Wert der sizeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setSizeMeasure(MeasureType value) {
        this.sizeMeasure = value;
    }

    /**
     * Ruft den Wert der accessAvailabilitySpecifiedPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public SpecifiedPeriodType getAccessAvailabilitySpecifiedPeriod() {
        return accessAvailabilitySpecifiedPeriod;
    }

    /**
     * Legt den Wert der accessAvailabilitySpecifiedPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public void setAccessAvailabilitySpecifiedPeriod(SpecifiedPeriodType value) {
        this.accessAvailabilitySpecifiedPeriod = value;
    }

}
