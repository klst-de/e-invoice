//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für DocumentContextParameterType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DocumentContextParameterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="Value" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="SpecifiedDocumentVersion" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentVersionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentContextParameterType", propOrder = {
    "id",
    "value",
    "specifiedDocumentVersion"
})
public class DocumentContextParameterType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "Value")
    protected TextType value;
    @XmlElement(name = "SpecifiedDocumentVersion")
    protected DocumentVersionType specifiedDocumentVersion;

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
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setValue(TextType value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der specifiedDocumentVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentVersionType }
     *     
     */
    public DocumentVersionType getSpecifiedDocumentVersion() {
        return specifiedDocumentVersion;
    }

    /**
     * Legt den Wert der specifiedDocumentVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentVersionType }
     *     
     */
    public void setSpecifiedDocumentVersion(DocumentVersionType value) {
        this.specifiedDocumentVersion = value;
    }

}
