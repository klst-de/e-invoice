//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
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
 * &lt;complexType name="SignaturePolicyIdentifierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="SignaturePolicyId" type="{http://uri.etsi.org/01903/v1.3.2#}SignaturePolicyIdType"/>
 *         &lt;element name="SignaturePolicyImplied" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
