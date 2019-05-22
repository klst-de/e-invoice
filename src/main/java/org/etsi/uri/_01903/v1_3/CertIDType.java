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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig_.X509IssuerSerialType;


/**
 * <p>Java-Klasse für CertIDType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CertIDType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CertDigest" type="{http://uri.etsi.org/01903/v1.3.2#}DigestAlgAndValueType"/&gt;
 *         &lt;element name="IssuerSerial" type="{http://www.w3.org/2000/09/xmldsig#}X509IssuerSerialType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertIDType", propOrder = {
    "certDigest",
    "issuerSerial"
})
public class CertIDType {

    @XmlElement(name = "CertDigest", required = true)
    protected DigestAlgAndValueType certDigest;
    @XmlElement(name = "IssuerSerial", required = true)
    protected X509IssuerSerialType issuerSerial;
    @XmlAttribute(name = "URI")
    @XmlSchemaType(name = "anyURI")
    protected String uri;

    /**
     * Ruft den Wert der certDigest-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public DigestAlgAndValueType getCertDigest() {
        return certDigest;
    }

    /**
     * Legt den Wert der certDigest-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public void setCertDigest(DigestAlgAndValueType value) {
        this.certDigest = value;
    }

    /**
     * Ruft den Wert der issuerSerial-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link X509IssuerSerialType }
     *     
     */
    public X509IssuerSerialType getIssuerSerial() {
        return issuerSerial;
    }

    /**
     * Legt den Wert der issuerSerial-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link X509IssuerSerialType }
     *     
     */
    public void setIssuerSerial(X509IssuerSerialType value) {
        this.issuerSerial = value;
    }

    /**
     * Ruft den Wert der uri-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURI() {
        return uri;
    }

    /**
     * Legt den Wert der uri-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURI(String value) {
        this.uri = value;
    }

}
