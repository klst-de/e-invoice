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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLegalFormCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLegalFormType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLiquidationStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorporateStockAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FullyPaidSharesIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationExpirationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SoleProprietorshipIndicatorType;


/**
 * <p>Java-Klasse für PartyLegalEntityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PartyLegalEntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationExpirationDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyLegalFormCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyLegalForm" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SoleProprietorshipIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyLiquidationStatusCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CorporateStockAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FullyPaidSharesIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RegistrationAddress" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CorporateRegistrationScheme" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HeadOfficeParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShareholderParty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyLegalEntityType", propOrder = {
    "registrationName",
    "companyID",
    "registrationDate",
    "registrationExpirationDate",
    "companyLegalFormCode",
    "companyLegalForm",
    "soleProprietorshipIndicator",
    "companyLiquidationStatusCode",
    "corporateStockAmount",
    "fullyPaidSharesIndicator",
    "registrationAddress",
    "corporateRegistrationScheme",
    "headOfficeParty",
    "shareholderParty"
})
public class PartyLegalEntityType {

    @XmlElement(name = "RegistrationName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationNameType registrationName;
    @XmlElement(name = "CompanyID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyIDType companyID;
    @XmlElement(name = "RegistrationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationDateType registrationDate;
    @XmlElement(name = "RegistrationExpirationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationExpirationDateType registrationExpirationDate;
    @XmlElement(name = "CompanyLegalFormCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyLegalFormCodeType companyLegalFormCode;
    @XmlElement(name = "CompanyLegalForm", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyLegalFormType companyLegalForm;
    @XmlElement(name = "SoleProprietorshipIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SoleProprietorshipIndicatorType soleProprietorshipIndicator;
    @XmlElement(name = "CompanyLiquidationStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyLiquidationStatusCodeType companyLiquidationStatusCode;
    @XmlElement(name = "CorporateStockAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CorporateStockAmountType corporateStockAmount;
    @XmlElement(name = "FullyPaidSharesIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FullyPaidSharesIndicatorType fullyPaidSharesIndicator;
    @XmlElement(name = "RegistrationAddress")
    protected AddressType registrationAddress;
    @XmlElement(name = "CorporateRegistrationScheme")
    protected CorporateRegistrationSchemeType corporateRegistrationScheme;
    @XmlElement(name = "HeadOfficeParty")
    protected PartyType headOfficeParty;
    @XmlElement(name = "ShareholderParty")
    protected List<ShareholderPartyType> shareholderParty;

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
     * Ruft den Wert der registrationDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationDateType }
     *     
     */
    public RegistrationDateType getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Legt den Wert der registrationDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationDateType }
     *     
     */
    public void setRegistrationDate(RegistrationDateType value) {
        this.registrationDate = value;
    }

    /**
     * Ruft den Wert der registrationExpirationDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationExpirationDateType }
     *     
     */
    public RegistrationExpirationDateType getRegistrationExpirationDate() {
        return registrationExpirationDate;
    }

    /**
     * Legt den Wert der registrationExpirationDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationExpirationDateType }
     *     
     */
    public void setRegistrationExpirationDate(RegistrationExpirationDateType value) {
        this.registrationExpirationDate = value;
    }

    /**
     * Ruft den Wert der companyLegalFormCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompanyLegalFormCodeType }
     *     
     */
    public CompanyLegalFormCodeType getCompanyLegalFormCode() {
        return companyLegalFormCode;
    }

    /**
     * Legt den Wert der companyLegalFormCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyLegalFormCodeType }
     *     
     */
    public void setCompanyLegalFormCode(CompanyLegalFormCodeType value) {
        this.companyLegalFormCode = value;
    }

    /**
     * Ruft den Wert der companyLegalForm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompanyLegalFormType }
     *     
     */
    public CompanyLegalFormType getCompanyLegalForm() {
        return companyLegalForm;
    }

    /**
     * Legt den Wert der companyLegalForm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyLegalFormType }
     *     
     */
    public void setCompanyLegalForm(CompanyLegalFormType value) {
        this.companyLegalForm = value;
    }

    /**
     * Ruft den Wert der soleProprietorshipIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SoleProprietorshipIndicatorType }
     *     
     */
    public SoleProprietorshipIndicatorType getSoleProprietorshipIndicator() {
        return soleProprietorshipIndicator;
    }

    /**
     * Legt den Wert der soleProprietorshipIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SoleProprietorshipIndicatorType }
     *     
     */
    public void setSoleProprietorshipIndicator(SoleProprietorshipIndicatorType value) {
        this.soleProprietorshipIndicator = value;
    }

    /**
     * Ruft den Wert der companyLiquidationStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompanyLiquidationStatusCodeType }
     *     
     */
    public CompanyLiquidationStatusCodeType getCompanyLiquidationStatusCode() {
        return companyLiquidationStatusCode;
    }

    /**
     * Legt den Wert der companyLiquidationStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyLiquidationStatusCodeType }
     *     
     */
    public void setCompanyLiquidationStatusCode(CompanyLiquidationStatusCodeType value) {
        this.companyLiquidationStatusCode = value;
    }

    /**
     * Ruft den Wert der corporateStockAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CorporateStockAmountType }
     *     
     */
    public CorporateStockAmountType getCorporateStockAmount() {
        return corporateStockAmount;
    }

    /**
     * Legt den Wert der corporateStockAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CorporateStockAmountType }
     *     
     */
    public void setCorporateStockAmount(CorporateStockAmountType value) {
        this.corporateStockAmount = value;
    }

    /**
     * Ruft den Wert der fullyPaidSharesIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FullyPaidSharesIndicatorType }
     *     
     */
    public FullyPaidSharesIndicatorType getFullyPaidSharesIndicator() {
        return fullyPaidSharesIndicator;
    }

    /**
     * Legt den Wert der fullyPaidSharesIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FullyPaidSharesIndicatorType }
     *     
     */
    public void setFullyPaidSharesIndicator(FullyPaidSharesIndicatorType value) {
        this.fullyPaidSharesIndicator = value;
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
     * Ruft den Wert der corporateRegistrationScheme-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CorporateRegistrationSchemeType }
     *     
     */
    public CorporateRegistrationSchemeType getCorporateRegistrationScheme() {
        return corporateRegistrationScheme;
    }

    /**
     * Legt den Wert der corporateRegistrationScheme-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CorporateRegistrationSchemeType }
     *     
     */
    public void setCorporateRegistrationScheme(CorporateRegistrationSchemeType value) {
        this.corporateRegistrationScheme = value;
    }

    /**
     * Ruft den Wert der headOfficeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getHeadOfficeParty() {
        return headOfficeParty;
    }

    /**
     * Legt den Wert der headOfficeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setHeadOfficeParty(PartyType value) {
        this.headOfficeParty = value;
    }

    /**
     * Gets the value of the shareholderParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shareholderParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShareholderParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShareholderPartyType }
     * 
     * 
     */
    public List<ShareholderPartyType> getShareholderParty() {
        if (shareholderParty == null) {
            shareholderParty = new ArrayList<ShareholderPartyType>();
        }
        return this.shareholderParty;
    }

}
