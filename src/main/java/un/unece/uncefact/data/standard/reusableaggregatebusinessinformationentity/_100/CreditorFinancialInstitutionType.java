//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für CreditorFinancialInstitutionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CreditorFinancialInstitutionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BICID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="CHIPSUniversalID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="NewZealandNCCID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="IrishNSCID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="UKSortCodeID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="CHIPSParticipantID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="SwissBCID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="FedwireRoutingNumberID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="PortugueseNCCID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="RussianCentralBankID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="ItalianDomesticID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="AustrianBankleitzahlID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="CanadianPaymentsAssociationID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="SICID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="GermanBankleitzahlID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="SpanishDomesticInterbankingID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="SouthAfricanNCCID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="HongKongBankID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="AustralianBSBID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="IndianFinancialSystemID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="HellenicBankID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="PolishNationalClearingID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="ClearingSystemName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="JapanFinancialInstitutionCommonID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="LocationFinancialInstitutionAddress" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}FinancialInstitutionAddressType" minOccurs="0"/&gt;
 *         &lt;element name="SubDivisionBranchFinancialInstitution" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}BranchFinancialInstitutionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorFinancialInstitutionType", propOrder = {
    "bicid",
    "chipsUniversalID",
    "newZealandNCCID",
    "irishNSCID",
    "ukSortCodeID",
    "chipsParticipantID",
    "swissBCID",
    "fedwireRoutingNumberID",
    "portugueseNCCID",
    "russianCentralBankID",
    "italianDomesticID",
    "austrianBankleitzahlID",
    "canadianPaymentsAssociationID",
    "sicid",
    "germanBankleitzahlID",
    "spanishDomesticInterbankingID",
    "southAfricanNCCID",
    "hongKongBankID",
    "australianBSBID",
    "indianFinancialSystemID",
    "hellenicBankID",
    "polishNationalClearingID",
    "name",
    "clearingSystemName",
    "japanFinancialInstitutionCommonID",
    "locationFinancialInstitutionAddress",
    "subDivisionBranchFinancialInstitution"
})
public class CreditorFinancialInstitutionType {

    @XmlElement(name = "BICID")
    protected IDType bicid;
    @XmlElement(name = "CHIPSUniversalID")
    protected IDType chipsUniversalID;
    @XmlElement(name = "NewZealandNCCID")
    protected IDType newZealandNCCID;
    @XmlElement(name = "IrishNSCID")
    protected IDType irishNSCID;
    @XmlElement(name = "UKSortCodeID")
    protected IDType ukSortCodeID;
    @XmlElement(name = "CHIPSParticipantID")
    protected IDType chipsParticipantID;
    @XmlElement(name = "SwissBCID")
    protected IDType swissBCID;
    @XmlElement(name = "FedwireRoutingNumberID")
    protected IDType fedwireRoutingNumberID;
    @XmlElement(name = "PortugueseNCCID")
    protected IDType portugueseNCCID;
    @XmlElement(name = "RussianCentralBankID")
    protected IDType russianCentralBankID;
    @XmlElement(name = "ItalianDomesticID")
    protected IDType italianDomesticID;
    @XmlElement(name = "AustrianBankleitzahlID")
    protected IDType austrianBankleitzahlID;
    @XmlElement(name = "CanadianPaymentsAssociationID")
    protected IDType canadianPaymentsAssociationID;
    @XmlElement(name = "SICID")
    protected IDType sicid;
    @XmlElement(name = "GermanBankleitzahlID")
    protected IDType germanBankleitzahlID;
    @XmlElement(name = "SpanishDomesticInterbankingID")
    protected IDType spanishDomesticInterbankingID;
    @XmlElement(name = "SouthAfricanNCCID")
    protected IDType southAfricanNCCID;
    @XmlElement(name = "HongKongBankID")
    protected IDType hongKongBankID;
    @XmlElement(name = "AustralianBSBID")
    protected IDType australianBSBID;
    @XmlElement(name = "IndianFinancialSystemID")
    protected IDType indianFinancialSystemID;
    @XmlElement(name = "HellenicBankID")
    protected IDType hellenicBankID;
    @XmlElement(name = "PolishNationalClearingID")
    protected IDType polishNationalClearingID;
    @XmlElement(name = "Name")
    protected TextType name;
    @XmlElement(name = "ClearingSystemName")
    protected TextType clearingSystemName;
    @XmlElement(name = "JapanFinancialInstitutionCommonID")
    protected IDType japanFinancialInstitutionCommonID;
    @XmlElement(name = "LocationFinancialInstitutionAddress")
    protected FinancialInstitutionAddressType locationFinancialInstitutionAddress;
    @XmlElement(name = "SubDivisionBranchFinancialInstitution")
    protected BranchFinancialInstitutionType subDivisionBranchFinancialInstitution;

    /**
     * Ruft den Wert der bicid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getBICID() {
        return bicid;
    }

    /**
     * Legt den Wert der bicid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setBICID(IDType value) {
        this.bicid = value;
    }

    /**
     * Ruft den Wert der chipsUniversalID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getCHIPSUniversalID() {
        return chipsUniversalID;
    }

    /**
     * Legt den Wert der chipsUniversalID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setCHIPSUniversalID(IDType value) {
        this.chipsUniversalID = value;
    }

    /**
     * Ruft den Wert der newZealandNCCID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getNewZealandNCCID() {
        return newZealandNCCID;
    }

    /**
     * Legt den Wert der newZealandNCCID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setNewZealandNCCID(IDType value) {
        this.newZealandNCCID = value;
    }

    /**
     * Ruft den Wert der irishNSCID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getIrishNSCID() {
        return irishNSCID;
    }

    /**
     * Legt den Wert der irishNSCID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setIrishNSCID(IDType value) {
        this.irishNSCID = value;
    }

    /**
     * Ruft den Wert der ukSortCodeID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getUKSortCodeID() {
        return ukSortCodeID;
    }

    /**
     * Legt den Wert der ukSortCodeID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setUKSortCodeID(IDType value) {
        this.ukSortCodeID = value;
    }

    /**
     * Ruft den Wert der chipsParticipantID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getCHIPSParticipantID() {
        return chipsParticipantID;
    }

    /**
     * Legt den Wert der chipsParticipantID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setCHIPSParticipantID(IDType value) {
        this.chipsParticipantID = value;
    }

    /**
     * Ruft den Wert der swissBCID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSwissBCID() {
        return swissBCID;
    }

    /**
     * Legt den Wert der swissBCID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSwissBCID(IDType value) {
        this.swissBCID = value;
    }

    /**
     * Ruft den Wert der fedwireRoutingNumberID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getFedwireRoutingNumberID() {
        return fedwireRoutingNumberID;
    }

    /**
     * Legt den Wert der fedwireRoutingNumberID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setFedwireRoutingNumberID(IDType value) {
        this.fedwireRoutingNumberID = value;
    }

    /**
     * Ruft den Wert der portugueseNCCID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getPortugueseNCCID() {
        return portugueseNCCID;
    }

    /**
     * Legt den Wert der portugueseNCCID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setPortugueseNCCID(IDType value) {
        this.portugueseNCCID = value;
    }

    /**
     * Ruft den Wert der russianCentralBankID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getRussianCentralBankID() {
        return russianCentralBankID;
    }

    /**
     * Legt den Wert der russianCentralBankID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setRussianCentralBankID(IDType value) {
        this.russianCentralBankID = value;
    }

    /**
     * Ruft den Wert der italianDomesticID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getItalianDomesticID() {
        return italianDomesticID;
    }

    /**
     * Legt den Wert der italianDomesticID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setItalianDomesticID(IDType value) {
        this.italianDomesticID = value;
    }

    /**
     * Ruft den Wert der austrianBankleitzahlID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getAustrianBankleitzahlID() {
        return austrianBankleitzahlID;
    }

    /**
     * Legt den Wert der austrianBankleitzahlID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setAustrianBankleitzahlID(IDType value) {
        this.austrianBankleitzahlID = value;
    }

    /**
     * Ruft den Wert der canadianPaymentsAssociationID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getCanadianPaymentsAssociationID() {
        return canadianPaymentsAssociationID;
    }

    /**
     * Legt den Wert der canadianPaymentsAssociationID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setCanadianPaymentsAssociationID(IDType value) {
        this.canadianPaymentsAssociationID = value;
    }

    /**
     * Ruft den Wert der sicid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSICID() {
        return sicid;
    }

    /**
     * Legt den Wert der sicid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSICID(IDType value) {
        this.sicid = value;
    }

    /**
     * Ruft den Wert der germanBankleitzahlID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getGermanBankleitzahlID() {
        return germanBankleitzahlID;
    }

    /**
     * Legt den Wert der germanBankleitzahlID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setGermanBankleitzahlID(IDType value) {
        this.germanBankleitzahlID = value;
    }

    /**
     * Ruft den Wert der spanishDomesticInterbankingID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSpanishDomesticInterbankingID() {
        return spanishDomesticInterbankingID;
    }

    /**
     * Legt den Wert der spanishDomesticInterbankingID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSpanishDomesticInterbankingID(IDType value) {
        this.spanishDomesticInterbankingID = value;
    }

    /**
     * Ruft den Wert der southAfricanNCCID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSouthAfricanNCCID() {
        return southAfricanNCCID;
    }

    /**
     * Legt den Wert der southAfricanNCCID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSouthAfricanNCCID(IDType value) {
        this.southAfricanNCCID = value;
    }

    /**
     * Ruft den Wert der hongKongBankID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getHongKongBankID() {
        return hongKongBankID;
    }

    /**
     * Legt den Wert der hongKongBankID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setHongKongBankID(IDType value) {
        this.hongKongBankID = value;
    }

    /**
     * Ruft den Wert der australianBSBID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getAustralianBSBID() {
        return australianBSBID;
    }

    /**
     * Legt den Wert der australianBSBID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setAustralianBSBID(IDType value) {
        this.australianBSBID = value;
    }

    /**
     * Ruft den Wert der indianFinancialSystemID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getIndianFinancialSystemID() {
        return indianFinancialSystemID;
    }

    /**
     * Legt den Wert der indianFinancialSystemID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setIndianFinancialSystemID(IDType value) {
        this.indianFinancialSystemID = value;
    }

    /**
     * Ruft den Wert der hellenicBankID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getHellenicBankID() {
        return hellenicBankID;
    }

    /**
     * Legt den Wert der hellenicBankID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setHellenicBankID(IDType value) {
        this.hellenicBankID = value;
    }

    /**
     * Ruft den Wert der polishNationalClearingID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getPolishNationalClearingID() {
        return polishNationalClearingID;
    }

    /**
     * Legt den Wert der polishNationalClearingID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setPolishNationalClearingID(IDType value) {
        this.polishNationalClearingID = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setName(TextType value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der clearingSystemName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getClearingSystemName() {
        return clearingSystemName;
    }

    /**
     * Legt den Wert der clearingSystemName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setClearingSystemName(TextType value) {
        this.clearingSystemName = value;
    }

    /**
     * Ruft den Wert der japanFinancialInstitutionCommonID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getJapanFinancialInstitutionCommonID() {
        return japanFinancialInstitutionCommonID;
    }

    /**
     * Legt den Wert der japanFinancialInstitutionCommonID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setJapanFinancialInstitutionCommonID(IDType value) {
        this.japanFinancialInstitutionCommonID = value;
    }

    /**
     * Ruft den Wert der locationFinancialInstitutionAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionAddressType }
     *     
     */
    public FinancialInstitutionAddressType getLocationFinancialInstitutionAddress() {
        return locationFinancialInstitutionAddress;
    }

    /**
     * Legt den Wert der locationFinancialInstitutionAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionAddressType }
     *     
     */
    public void setLocationFinancialInstitutionAddress(FinancialInstitutionAddressType value) {
        this.locationFinancialInstitutionAddress = value;
    }

    /**
     * Ruft den Wert der subDivisionBranchFinancialInstitution-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchFinancialInstitutionType }
     *     
     */
    public BranchFinancialInstitutionType getSubDivisionBranchFinancialInstitution() {
        return subDivisionBranchFinancialInstitution;
    }

    /**
     * Legt den Wert der subDivisionBranchFinancialInstitution-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchFinancialInstitutionType }
     *     
     */
    public void setSubDivisionBranchFinancialInstitution(BranchFinancialInstitutionType value) {
        this.subDivisionBranchFinancialInstitution = value;
    }

}
