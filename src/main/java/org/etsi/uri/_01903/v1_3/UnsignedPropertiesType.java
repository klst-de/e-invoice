//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java-Klasse für UnsignedPropertiesType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="UnsignedPropertiesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UnsignedSignatureProperties" type="{http://uri.etsi.org/01903/v1.3.2#}UnsignedSignaturePropertiesType" minOccurs="0"/&gt;
 *         &lt;element name="UnsignedDataObjectProperties" type="{http://uri.etsi.org/01903/v1.3.2#}UnsignedDataObjectPropertiesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnsignedPropertiesType", propOrder = {
    "unsignedSignatureProperties",
    "unsignedDataObjectProperties"
})
public class UnsignedPropertiesType {

    @XmlElement(name = "UnsignedSignatureProperties")
    protected UnsignedSignaturePropertiesType unsignedSignatureProperties;
    @XmlElement(name = "UnsignedDataObjectProperties")
    protected UnsignedDataObjectPropertiesType unsignedDataObjectProperties;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Ruft den Wert der unsignedSignatureProperties-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UnsignedSignaturePropertiesType }
     *     
     */
    public UnsignedSignaturePropertiesType getUnsignedSignatureProperties() {
        return unsignedSignatureProperties;
    }

    /**
     * Legt den Wert der unsignedSignatureProperties-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UnsignedSignaturePropertiesType }
     *     
     */
    public void setUnsignedSignatureProperties(UnsignedSignaturePropertiesType value) {
        this.unsignedSignatureProperties = value;
    }

    /**
     * Ruft den Wert der unsignedDataObjectProperties-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UnsignedDataObjectPropertiesType }
     *     
     */
    public UnsignedDataObjectPropertiesType getUnsignedDataObjectProperties() {
        return unsignedDataObjectProperties;
    }

    /**
     * Legt den Wert der unsignedDataObjectProperties-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UnsignedDataObjectPropertiesType }
     *     
     */
    public void setUnsignedDataObjectProperties(UnsignedDataObjectPropertiesType value) {
        this.unsignedDataObjectProperties = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
