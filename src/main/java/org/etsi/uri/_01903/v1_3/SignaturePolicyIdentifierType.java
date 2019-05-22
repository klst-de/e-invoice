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


/**
 * <p>Java-Klasse für SignaturePolicyIdentifierType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignaturePolicyIdentifierType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="SignaturePolicyId" type="{http://uri.etsi.org/01903/v1.3.2#}SignaturePolicyIdType"/&gt;
 *         &lt;element name="SignaturePolicyImplied" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignaturePolicyIdentifierType", propOrder = {
    "signaturePolicyId",
    "signaturePolicyImplied"
})
public class SignaturePolicyIdentifierType {

    @XmlElement(name = "SignaturePolicyId")
    protected SignaturePolicyIdType signaturePolicyId;
    @XmlElement(name = "SignaturePolicyImplied")
    protected Object signaturePolicyImplied;

    /**
     * Ruft den Wert der signaturePolicyId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignaturePolicyIdType }
     *     
     */
    public SignaturePolicyIdType getSignaturePolicyId() {
        return signaturePolicyId;
    }

    /**
     * Legt den Wert der signaturePolicyId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignaturePolicyIdType }
     *     
     */
    public void setSignaturePolicyId(SignaturePolicyIdType value) {
        this.signaturePolicyId = value;
    }

    /**
     * Ruft den Wert der signaturePolicyImplied-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSignaturePolicyImplied() {
        return signaturePolicyImplied;
    }

    /**
     * Legt den Wert der signaturePolicyImplied-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSignaturePolicyImplied(Object value) {
        this.signaturePolicyImplied = value;
    }

}
