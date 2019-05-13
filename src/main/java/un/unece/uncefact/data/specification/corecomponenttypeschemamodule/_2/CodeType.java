//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UNDT000007&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;CCT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Code. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A character string (letters, figures, or symbols) that for brevity and/or languange
 *                     independence may be used to represent or replace a definitive value or text of an attribute together
 *                     with relevant supplementary information.
 *                 &lt;/ccts:Definition&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Code&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UsageRule xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Should not be used if the character string identifies an instance of an object class or
 *                     an object in the real world, in which case the Identifier. Type should be used.
 *                 &lt;/ccts:UsageRule&gt;
 * </pre>
 * 
 *             
 * 
 * <p>Java-Klasse für CodeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CodeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *       &lt;attribute name="listID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="listAgencyID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="listAgencyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="listName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="listVersionID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="languageID" type="{http://www.w3.org/2001/XMLSchema}language" />
 *       &lt;attribute name="listURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="listSchemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodeType", propOrder = {
    "value"
})
@XmlSeeAlso({
    oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.CodeType.class
})
public class CodeType {

    @XmlValue
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String value;
    @XmlAttribute(name = "listID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String listID;
    @XmlAttribute(name = "listAgencyID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String listAgencyID;
    @XmlAttribute(name = "listAgencyName")
    protected String listAgencyName;
    @XmlAttribute(name = "listName")
    protected String listName;
    @XmlAttribute(name = "listVersionID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String listVersionID;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "languageID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String languageID;
    @XmlAttribute(name = "listURI")
    @XmlSchemaType(name = "anyURI")
    protected String listURI;
    @XmlAttribute(name = "listSchemeURI")
    @XmlSchemaType(name = "anyURI")
    protected String listSchemeURI;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der listID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListID() {
        return listID;
    }

    /**
     * Legt den Wert der listID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListID(String value) {
        this.listID = value;
    }

    /**
     * Ruft den Wert der listAgencyID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAgencyID() {
        return listAgencyID;
    }

    /**
     * Legt den Wert der listAgencyID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAgencyID(String value) {
        this.listAgencyID = value;
    }

    /**
     * Ruft den Wert der listAgencyName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAgencyName() {
        return listAgencyName;
    }

    /**
     * Legt den Wert der listAgencyName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAgencyName(String value) {
        this.listAgencyName = value;
    }

    /**
     * Ruft den Wert der listName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListName() {
        return listName;
    }

    /**
     * Legt den Wert der listName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListName(String value) {
        this.listName = value;
    }

    /**
     * Ruft den Wert der listVersionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListVersionID() {
        return listVersionID;
    }

    /**
     * Legt den Wert der listVersionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListVersionID(String value) {
        this.listVersionID = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der languageID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageID() {
        return languageID;
    }

    /**
     * Legt den Wert der languageID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageID(String value) {
        this.languageID = value;
    }

    /**
     * Ruft den Wert der listURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListURI() {
        return listURI;
    }

    /**
     * Legt den Wert der listURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListURI(String value) {
        this.listURI = value;
    }

    /**
     * Ruft den Wert der listSchemeURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListSchemeURI() {
        return listSchemeURI;
    }

    /**
     * Legt den Wert der listSchemeURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListSchemeURI(String value) {
        this.listSchemeURI = value;
    }

}
