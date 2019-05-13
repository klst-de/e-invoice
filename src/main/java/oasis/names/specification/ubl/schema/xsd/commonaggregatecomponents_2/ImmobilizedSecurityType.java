//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FaceValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ImmobilizationCertificateIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarketValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SecurityIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SharesNumberQuantityType;


/**
 * <p>Java-Klasse für ImmobilizedSecurityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ImmobilizedSecurityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ImmobilizationCertificateID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SecurityID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IssueDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FaceValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarketValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SharesNumberQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}IssuerParty" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImmobilizedSecurityType", propOrder = {
    "immobilizationCertificateID",
    "securityID",
    "issueDate",
    "faceValueAmount",
    "marketValueAmount",
    "sharesNumberQuantity",
    "issuerParty"
})
public class ImmobilizedSecurityType {

    @XmlElement(name = "ImmobilizationCertificateID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ImmobilizationCertificateIDType immobilizationCertificateID;
    @XmlElement(name = "SecurityID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SecurityIDType securityID;
    @XmlElement(name = "IssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IssueDateType issueDate;
    @XmlElement(name = "FaceValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FaceValueAmountType faceValueAmount;
    @XmlElement(name = "MarketValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarketValueAmountType marketValueAmount;
    @XmlElement(name = "SharesNumberQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SharesNumberQuantityType sharesNumberQuantity;
    @XmlElement(name = "IssuerParty")
    protected PartyType issuerParty;

    /**
     * Ruft den Wert der immobilizationCertificateID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImmobilizationCertificateIDType }
     *     
     */
    public ImmobilizationCertificateIDType getImmobilizationCertificateID() {
        return immobilizationCertificateID;
    }

    /**
     * Legt den Wert der immobilizationCertificateID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImmobilizationCertificateIDType }
     *     
     */
    public void setImmobilizationCertificateID(ImmobilizationCertificateIDType value) {
        this.immobilizationCertificateID = value;
    }

    /**
     * Ruft den Wert der securityID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SecurityIDType }
     *     
     */
    public SecurityIDType getSecurityID() {
        return securityID;
    }

    /**
     * Legt den Wert der securityID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityIDType }
     *     
     */
    public void setSecurityID(SecurityIDType value) {
        this.securityID = value;
    }

    /**
     * Ruft den Wert der issueDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IssueDateType }
     *     
     */
    public IssueDateType getIssueDate() {
        return issueDate;
    }

    /**
     * Legt den Wert der issueDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueDateType }
     *     
     */
    public void setIssueDate(IssueDateType value) {
        this.issueDate = value;
    }

    /**
     * Ruft den Wert der faceValueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FaceValueAmountType }
     *     
     */
    public FaceValueAmountType getFaceValueAmount() {
        return faceValueAmount;
    }

    /**
     * Legt den Wert der faceValueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FaceValueAmountType }
     *     
     */
    public void setFaceValueAmount(FaceValueAmountType value) {
        this.faceValueAmount = value;
    }

    /**
     * Ruft den Wert der marketValueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MarketValueAmountType }
     *     
     */
    public MarketValueAmountType getMarketValueAmount() {
        return marketValueAmount;
    }

    /**
     * Legt den Wert der marketValueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MarketValueAmountType }
     *     
     */
    public void setMarketValueAmount(MarketValueAmountType value) {
        this.marketValueAmount = value;
    }

    /**
     * Ruft den Wert der sharesNumberQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SharesNumberQuantityType }
     *     
     */
    public SharesNumberQuantityType getSharesNumberQuantity() {
        return sharesNumberQuantity;
    }

    /**
     * Legt den Wert der sharesNumberQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SharesNumberQuantityType }
     *     
     */
    public void setSharesNumberQuantity(SharesNumberQuantityType value) {
        this.sharesNumberQuantity = value;
    }

    /**
     * Ruft den Wert der issuerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getIssuerParty() {
        return issuerParty;
    }

    /**
     * Legt den Wert der issuerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setIssuerParty(PartyType value) {
        this.issuerParty = value;
    }

}
