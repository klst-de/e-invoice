//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig_.DigestMethodType;


/**
 * <p>Java-Klasse für DigestAlgAndValueType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DigestAlgAndValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}DigestMethod"/&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}DigestValue"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DigestAlgAndValueType", propOrder = {
    "digestMethod",
    "digestValue"
})
public class DigestAlgAndValueType {

    @XmlElement(name = "DigestMethod", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected DigestMethodType digestMethod;
    @XmlElement(name = "DigestValue", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected byte[] digestValue;

    /**
     * Ruft den Wert der digestMethod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DigestMethodType }
     *     
     */
    public DigestMethodType getDigestMethod() {
        return digestMethod;
    }

    /**
     * Legt den Wert der digestMethod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestMethodType }
     *     
     */
    public void setDigestMethod(DigestMethodType value) {
        this.digestMethod = value;
    }

    /**
     * Ruft den Wert der digestValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDigestValue() {
        return digestValue;
    }

    /**
     * Legt den Wert der digestValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDigestValue(byte[] value) {
        this.digestValue = value;
    }

}
