//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExemptionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxLevelCodeType;


/**
 * <p>Java-Klasse für PartyTaxSchemeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PartyTaxSchemeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxLevelCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExemptionReasonCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExemptionReason" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RegistrationAddress" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxScheme"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyTaxSchemeType", propOrder = {
    "registrationName",
    "companyID",
    "taxLevelCode",
    "exemptionReasonCode",
    "exemptionReason",
    "registrationAddress",
    "taxScheme"
})
public class PartyTaxSchemeType {

    @XmlElement(name = "RegistrationName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationNameType registrationName;
    @XmlElement(name = "CompanyID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyIDType companyID;
    @XmlElement(name = "TaxLevelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxLevelCodeType taxLevelCode;
    @XmlElement(name = "ExemptionReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExemptionReasonCodeType exemptionReasonCode;
    @XmlElement(name = "ExemptionReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ExemptionReasonType> exemptionReason;
    @XmlElement(name = "RegistrationAddress")
    protected AddressType registrationAddress;
    @XmlElement(name = "TaxScheme", required = true)
    protected TaxSchemeType taxScheme;

    /**
     * Ruft den Wert der registrationName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationNameType }
     *     
     */
    public RegistrationNameType getRegistrationName() {
        return registrationName;
    }

    /**
     * Legt den Wert der registrationName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationNameType }
     *     
     */
    public void setRegistrationName(RegistrationNameType value) {
        this.registrationName = value;
    }

    /**
     * Ruft den Wert der companyID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompanyIDType }
     *     
     */
    public CompanyIDType getCompanyID() {
        return companyID;
    }

    /**
     * Legt den Wert der companyID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyIDType }
     *     
     */
    public void setCompanyID(CompanyIDType value) {
        this.companyID = value;
    }

    /**
     * Ruft den Wert der taxLevelCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxLevelCodeType }
     *     
     */
    public TaxLevelCodeType getTaxLevelCode() {
        return taxLevelCode;
    }

    /**
     * Legt den Wert der taxLevelCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxLevelCodeType }
     *     
     */
    public void setTaxLevelCode(TaxLevelCodeType value) {
        this.taxLevelCode = value;
    }

    /**
     * Ruft den Wert der exemptionReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExemptionReasonCodeType }
     *     
     */
    public ExemptionReasonCodeType getExemptionReasonCode() {
        return exemptionReasonCode;
    }

    /**
     * Legt den Wert der exemptionReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemptionReasonCodeType }
     *     
     */
    public void setExemptionReasonCode(ExemptionReasonCodeType value) {
        this.exemptionReasonCode = value;
    }

    /**
     * Gets the value of the exemptionReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exemptionReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExemptionReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExemptionReasonType }
     * 
     * 
     */
    public List<ExemptionReasonType> getExemptionReason() {
        if (exemptionReason == null) {
            exemptionReason = new ArrayList<ExemptionReasonType>();
        }
        return this.exemptionReason;
    }

    /**
     * Ruft den Wert der registrationAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getRegistrationAddress() {
        return registrationAddress;
    }

    /**
     * Legt den Wert der registrationAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setRegistrationAddress(AddressType value) {
        this.registrationAddress = value;
    }

    /**
     * Ruft den Wert der taxScheme-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxSchemeType }
     *     
     */
    public TaxSchemeType getTaxScheme() {
        return taxScheme;
    }

    /**
     * Legt den Wert der taxScheme-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxSchemeType }
     *     
     */
    public void setTaxScheme(TaxSchemeType value) {
        this.taxScheme = value;
    }

}
