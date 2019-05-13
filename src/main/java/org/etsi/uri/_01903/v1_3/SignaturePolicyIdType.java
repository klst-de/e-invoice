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
import org.w3._2000._09.xmldsig_.TransformsType;


/**
 * <p>Java-Klasse für SignaturePolicyIdType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignaturePolicyIdType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SigPolicyId" type="{http://uri.etsi.org/01903/v1.3.2#}ObjectIdentifierType"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Transforms" minOccurs="0"/>
 *         &lt;element name="SigPolicyHash" type="{http://uri.etsi.org/01903/v1.3.2#}DigestAlgAndValueType"/>
 *         &lt;element name="SigPolicyQualifiers" type="{http://uri.etsi.org/01903/v1.3.2#}SigPolicyQualifiersListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignaturePolicyIdType", propOrder = {
    "sigPolicyId",
    "transforms",
    "sigPolicyHash",
    "sigPolicyQualifiers"
})
public class SignaturePolicyIdType {

    @XmlElement(name = "SigPolicyId", required = true)
    protected ObjectIdentifierType sigPolicyId;
    @XmlElement(name = "Transforms", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected TransformsType transforms;
    @XmlElement(name = "SigPolicyHash", required = true)
    protected DigestAlgAndValueType sigPolicyHash;
    @XmlElement(name = "SigPolicyQualifiers")
    protected SigPolicyQualifiersListType sigPolicyQualifiers;

    /**
     * Ruft den Wert der sigPolicyId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ObjectIdentifierType }
     *     
     */
    public ObjectIdentifierType getSigPolicyId() {
        return sigPolicyId;
    }

    /**
     * Legt den Wert der sigPolicyId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectIdentifierType }
     *     
     */
    public void setSigPolicyId(ObjectIdentifierType value) {
        this.sigPolicyId = value;
    }

    /**
     * Ruft den Wert der transforms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransformsType }
     *     
     */
    public TransformsType getTransforms() {
        return transforms;
    }

    /**
     * Legt den Wert der transforms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransformsType }
     *     
     */
    public void setTransforms(TransformsType value) {
        this.transforms = value;
    }

    /**
     * Ruft den Wert der sigPolicyHash-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public DigestAlgAndValueType getSigPolicyHash() {
        return sigPolicyHash;
    }

    /**
     * Legt den Wert der sigPolicyHash-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public void setSigPolicyHash(DigestAlgAndValueType value) {
        this.sigPolicyHash = value;
    }

    /**
     * Ruft den Wert der sigPolicyQualifiers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SigPolicyQualifiersListType }
     *     
     */
    public SigPolicyQualifiersListType getSigPolicyQualifiers() {
        return sigPolicyQualifiers;
    }

    /**
     * Legt den Wert der sigPolicyQualifiers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SigPolicyQualifiersListType }
     *     
     */
    public void setSigPolicyQualifiers(SigPolicyQualifiersListType value) {
        this.sigPolicyQualifiers = value;
    }

}
