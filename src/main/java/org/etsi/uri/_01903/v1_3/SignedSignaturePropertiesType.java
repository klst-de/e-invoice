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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für SignedSignaturePropertiesType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignedSignaturePropertiesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SigningTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SigningCertificate" type="{http://uri.etsi.org/01903/v1.3.2#}CertIDListType" minOccurs="0"/>
 *         &lt;element name="SignaturePolicyIdentifier" type="{http://uri.etsi.org/01903/v1.3.2#}SignaturePolicyIdentifierType" minOccurs="0"/>
 *         &lt;element name="SignatureProductionPlace" type="{http://uri.etsi.org/01903/v1.3.2#}SignatureProductionPlaceType" minOccurs="0"/>
 *         &lt;element name="SignerRole" type="{http://uri.etsi.org/01903/v1.3.2#}SignerRoleType" minOccurs="0"/>
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
@XmlType(name = "SignedSignaturePropertiesType", propOrder = {
    "signingTime",
    "signingCertificate",
    "signaturePolicyIdentifier",
    "signatureProductionPlace",
    "signerRole"
})
public class SignedSignaturePropertiesType {

    @XmlElement(name = "SigningTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar signingTime;
    @XmlElement(name = "SigningCertificate")
    protected CertIDListType signingCertificate;
    @XmlElement(name = "SignaturePolicyIdentifier")
    protected SignaturePolicyIdentifierType signaturePolicyIdentifier;
    @XmlElement(name = "SignatureProductionPlace")
    protected SignatureProductionPlaceType signatureProductionPlace;
    @XmlElement(name = "SignerRole")
    protected SignerRoleType signerRole;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Ruft den Wert der signingTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSigningTime() {
        return signingTime;
    }

    /**
     * Legt den Wert der signingTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSigningTime(XMLGregorianCalendar value) {
        this.signingTime = value;
    }

    /**
     * Ruft den Wert der signingCertificate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CertIDListType }
     *     
     */
    public CertIDListType getSigningCertificate() {
        return signingCertificate;
    }

    /**
     * Legt den Wert der signingCertificate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CertIDListType }
     *     
     */
    public void setSigningCertificate(CertIDListType value) {
        this.signingCertificate = value;
    }

    /**
     * Ruft den Wert der signaturePolicyIdentifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignaturePolicyIdentifierType }
     *     
     */
    public SignaturePolicyIdentifierType getSignaturePolicyIdentifier() {
        return signaturePolicyIdentifier;
    }

    /**
     * Legt den Wert der signaturePolicyIdentifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignaturePolicyIdentifierType }
     *     
     */
    public void setSignaturePolicyIdentifier(SignaturePolicyIdentifierType value) {
        this.signaturePolicyIdentifier = value;
    }

    /**
     * Ruft den Wert der signatureProductionPlace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignatureProductionPlaceType }
     *     
     */
    public SignatureProductionPlaceType getSignatureProductionPlace() {
        return signatureProductionPlace;
    }

    /**
     * Legt den Wert der signatureProductionPlace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureProductionPlaceType }
     *     
     */
    public void setSignatureProductionPlace(SignatureProductionPlaceType value) {
        this.signatureProductionPlace = value;
    }

    /**
     * Ruft den Wert der signerRole-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignerRoleType }
     *     
     */
    public SignerRoleType getSignerRole() {
        return signerRole;
    }

    /**
     * Legt den Wert der signerRole-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignerRoleType }
     *     
     */
    public void setSignerRole(SignerRoleType value) {
        this.signerRole = value;
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
