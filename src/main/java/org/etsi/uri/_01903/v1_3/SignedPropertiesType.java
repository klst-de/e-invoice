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
 * <p>Java-Klasse für SignedPropertiesType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignedPropertiesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SignedSignatureProperties" type="{http://uri.etsi.org/01903/v1.3.2#}SignedSignaturePropertiesType" minOccurs="0"/&gt;
 *         &lt;element name="SignedDataObjectProperties" type="{http://uri.etsi.org/01903/v1.3.2#}SignedDataObjectPropertiesType" minOccurs="0"/&gt;
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
@XmlType(name = "SignedPropertiesType", propOrder = {
    "signedSignatureProperties",
    "signedDataObjectProperties"
})
public class SignedPropertiesType {

    @XmlElement(name = "SignedSignatureProperties")
    protected SignedSignaturePropertiesType signedSignatureProperties;
    @XmlElement(name = "SignedDataObjectProperties")
    protected SignedDataObjectPropertiesType signedDataObjectProperties;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Ruft den Wert der signedSignatureProperties-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignedSignaturePropertiesType }
     *     
     */
    public SignedSignaturePropertiesType getSignedSignatureProperties() {
        return signedSignatureProperties;
    }

    /**
     * Legt den Wert der signedSignatureProperties-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedSignaturePropertiesType }
     *     
     */
    public void setSignedSignatureProperties(SignedSignaturePropertiesType value) {
        this.signedSignatureProperties = value;
    }

    /**
     * Ruft den Wert der signedDataObjectProperties-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignedDataObjectPropertiesType }
     *     
     */
    public SignedDataObjectPropertiesType getSignedDataObjectProperties() {
        return signedDataObjectProperties;
    }

    /**
     * Legt den Wert der signedDataObjectProperties-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedDataObjectPropertiesType }
     *     
     */
    public void setSignedDataObjectProperties(SignedDataObjectPropertiesType value) {
        this.signedDataObjectProperties = value;
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
