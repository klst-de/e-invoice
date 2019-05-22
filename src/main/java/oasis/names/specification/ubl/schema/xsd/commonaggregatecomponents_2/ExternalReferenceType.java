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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CharacterSetCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentHashType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EncodingCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FileNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FormatCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HashAlgorithmMethodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MimeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.URIType;


/**
 * <p>Java-Klasse für ExternalReferenceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ExternalReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}URI" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DocumentHash" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HashAlgorithmMethod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExpiryDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExpiryTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MimeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FormatCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EncodingCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CharacterSetCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FileName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalReferenceType", propOrder = {
    "uri",
    "documentHash",
    "hashAlgorithmMethod",
    "expiryDate",
    "expiryTime",
    "mimeCode",
    "formatCode",
    "encodingCode",
    "characterSetCode",
    "fileName",
    "description"
})
public class ExternalReferenceType {

    @XmlElement(name = "URI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected URIType uri;
    @XmlElement(name = "DocumentHash", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DocumentHashType documentHash;
    @XmlElement(name = "HashAlgorithmMethod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HashAlgorithmMethodType hashAlgorithmMethod;
    @XmlElement(name = "ExpiryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExpiryDateType expiryDate;
    @XmlElement(name = "ExpiryTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExpiryTimeType expiryTime;
    @XmlElement(name = "MimeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MimeCodeType mimeCode;
    @XmlElement(name = "FormatCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FormatCodeType formatCode;
    @XmlElement(name = "EncodingCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EncodingCodeType encodingCode;
    @XmlElement(name = "CharacterSetCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CharacterSetCodeType characterSetCode;
    @XmlElement(name = "FileName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FileNameType fileName;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;

    /**
     * Ruft den Wert der uri-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link URIType }
     *     
     */
    public URIType getURI() {
        return uri;
    }

    /**
     * Legt den Wert der uri-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link URIType }
     *     
     */
    public void setURI(URIType value) {
        this.uri = value;
    }

    /**
     * Ruft den Wert der documentHash-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentHashType }
     *     
     */
    public DocumentHashType getDocumentHash() {
        return documentHash;
    }

    /**
     * Legt den Wert der documentHash-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentHashType }
     *     
     */
    public void setDocumentHash(DocumentHashType value) {
        this.documentHash = value;
    }

    /**
     * Ruft den Wert der hashAlgorithmMethod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HashAlgorithmMethodType }
     *     
     */
    public HashAlgorithmMethodType getHashAlgorithmMethod() {
        return hashAlgorithmMethod;
    }

    /**
     * Legt den Wert der hashAlgorithmMethod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HashAlgorithmMethodType }
     *     
     */
    public void setHashAlgorithmMethod(HashAlgorithmMethodType value) {
        this.hashAlgorithmMethod = value;
    }

    /**
     * Ruft den Wert der expiryDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpiryDateType }
     *     
     */
    public ExpiryDateType getExpiryDate() {
        return expiryDate;
    }

    /**
     * Legt den Wert der expiryDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpiryDateType }
     *     
     */
    public void setExpiryDate(ExpiryDateType value) {
        this.expiryDate = value;
    }

    /**
     * Ruft den Wert der expiryTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpiryTimeType }
     *     
     */
    public ExpiryTimeType getExpiryTime() {
        return expiryTime;
    }

    /**
     * Legt den Wert der expiryTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpiryTimeType }
     *     
     */
    public void setExpiryTime(ExpiryTimeType value) {
        this.expiryTime = value;
    }

    /**
     * Ruft den Wert der mimeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MimeCodeType }
     *     
     */
    public MimeCodeType getMimeCode() {
        return mimeCode;
    }

    /**
     * Legt den Wert der mimeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MimeCodeType }
     *     
     */
    public void setMimeCode(MimeCodeType value) {
        this.mimeCode = value;
    }

    /**
     * Ruft den Wert der formatCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FormatCodeType }
     *     
     */
    public FormatCodeType getFormatCode() {
        return formatCode;
    }

    /**
     * Legt den Wert der formatCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FormatCodeType }
     *     
     */
    public void setFormatCode(FormatCodeType value) {
        this.formatCode = value;
    }

    /**
     * Ruft den Wert der encodingCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EncodingCodeType }
     *     
     */
    public EncodingCodeType getEncodingCode() {
        return encodingCode;
    }

    /**
     * Legt den Wert der encodingCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EncodingCodeType }
     *     
     */
    public void setEncodingCode(EncodingCodeType value) {
        this.encodingCode = value;
    }

    /**
     * Ruft den Wert der characterSetCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CharacterSetCodeType }
     *     
     */
    public CharacterSetCodeType getCharacterSetCode() {
        return characterSetCode;
    }

    /**
     * Legt den Wert der characterSetCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterSetCodeType }
     *     
     */
    public void setCharacterSetCode(CharacterSetCodeType value) {
        this.characterSetCode = value;
    }

    /**
     * Ruft den Wert der fileName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FileNameType }
     *     
     */
    public FileNameType getFileName() {
        return fileName;
    }

    /**
     * Legt den Wert der fileName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FileNameType }
     *     
     */
    public void setFileName(FileNameType value) {
        this.fileName = value;
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
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

}
