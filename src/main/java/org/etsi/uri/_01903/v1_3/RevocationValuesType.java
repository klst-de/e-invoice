//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
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
 * <p>Java-Klasse für RevocationValuesType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RevocationValuesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CRLValues" type="{http://uri.etsi.org/01903/v1.3.2#}CRLValuesType" minOccurs="0"/>
 *         &lt;element name="OCSPValues" type="{http://uri.etsi.org/01903/v1.3.2#}OCSPValuesType" minOccurs="0"/>
 *         &lt;element name="OtherValues" type="{http://uri.etsi.org/01903/v1.3.2#}OtherCertStatusValuesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RevocationValuesType", propOrder = {
    "crlValues",
    "ocspValues",
    "otherValues"
})
public class RevocationValuesType {

    @XmlElement(name = "CRLValues")
    protected CRLValuesType crlValues;
    @XmlElement(name = "OCSPValues")
    protected OCSPValuesType ocspValues;
    @XmlElement(name = "OtherValues")
    protected OtherCertStatusValuesType otherValues;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Ruft den Wert der crlValues-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CRLValuesType }
     *     
     */
    public CRLValuesType getCRLValues() {
        return crlValues;
    }

    /**
     * Legt den Wert der crlValues-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CRLValuesType }
     *     
     */
    public void setCRLValues(CRLValuesType value) {
        this.crlValues = value;
    }

    /**
     * Ruft den Wert der ocspValues-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OCSPValuesType }
     *     
     */
    public OCSPValuesType getOCSPValues() {
        return ocspValues;
    }

    /**
     * Legt den Wert der ocspValues-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OCSPValuesType }
     *     
     */
    public void setOCSPValues(OCSPValuesType value) {
        this.ocspValues = value;
    }

    /**
     * Ruft den Wert der otherValues-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OtherCertStatusValuesType }
     *     
     */
    public OtherCertStatusValuesType getOtherValues() {
        return otherValues;
    }

    /**
     * Legt den Wert der otherValues-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherCertStatusValuesType }
     *     
     */
    public void setOtherValues(OtherCertStatusValuesType value) {
        this.otherValues = value;
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
