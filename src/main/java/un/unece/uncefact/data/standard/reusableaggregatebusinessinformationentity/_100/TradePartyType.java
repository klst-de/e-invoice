//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PartyRoleCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradePartyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradePartyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GlobalID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="RoleCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PartyRoleCodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedLegalOrganization" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LegalOrganizationType" minOccurs="0"/>
 *         &lt;element name="DefinedTradeContact" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeContactType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PostalTradeAddress" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAddressType" minOccurs="0"/>
 *         &lt;element name="URIUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedTaxRegistration" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TaxRegistrationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EndPointURIUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="LogoAssociatedSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePartyType", propOrder = {
    "id",
    "globalID",
    "name",
    "roleCode",
    "description",
    "specifiedLegalOrganization",
    "definedTradeContact",
    "postalTradeAddress",
    "uriUniversalCommunication",
    "specifiedTaxRegistration",
    "endPointURIUniversalCommunication",
    "logoAssociatedSpecifiedBinaryFile"
})
public class TradePartyType {

    @XmlElement(name = "ID")
    protected List<IDType> id;
    @XmlElement(name = "GlobalID")
    protected List<IDType> globalID;
    @XmlElement(name = "Name")
    protected TextType name;
    @XmlElement(name = "RoleCode")
    protected List<PartyRoleCodeType> roleCode;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "SpecifiedLegalOrganization")
    protected LegalOrganizationType specifiedLegalOrganization;
    @XmlElement(name = "DefinedTradeContact")
    protected List<TradeContactType> definedTradeContact;
    @XmlElement(name = "PostalTradeAddress")
    protected TradeAddressType postalTradeAddress;
    @XmlElement(name = "URIUniversalCommunication")
    protected List<UniversalCommunicationType> uriUniversalCommunication;
    @XmlElement(name = "SpecifiedTaxRegistration")
    protected List<TaxRegistrationType> specifiedTaxRegistration;
    @XmlElement(name = "EndPointURIUniversalCommunication")
    protected UniversalCommunicationType endPointURIUniversalCommunication;
    @XmlElement(name = "LogoAssociatedSpecifiedBinaryFile")
    protected List<SpecifiedBinaryFileType> logoAssociatedSpecifiedBinaryFile;

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getID() {
        if (id == null) {
            id = new ArrayList<IDType>();
        }
        return this.id;
    }

    /**
     * Gets the value of the globalID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the globalID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlobalID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getGlobalID() {
        if (globalID == null) {
            globalID = new ArrayList<IDType>();
        }
        return this.globalID;
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
     * Gets the value of the roleCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyRoleCodeType }
     * 
     * 
     */
    public List<PartyRoleCodeType> getRoleCode() {
        if (roleCode == null) {
            roleCode = new ArrayList<PartyRoleCodeType>();
        }
        return this.roleCode;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDescription() {
        if (description == null) {
            description = new ArrayList<TextType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der specifiedLegalOrganization-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LegalOrganizationType }
     *     
     */
    public LegalOrganizationType getSpecifiedLegalOrganization() {
        return specifiedLegalOrganization;
    }

    /**
     * Legt den Wert der specifiedLegalOrganization-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalOrganizationType }
     *     
     */
    public void setSpecifiedLegalOrganization(LegalOrganizationType value) {
        this.specifiedLegalOrganization = value;
    }

    /**
     * Gets the value of the definedTradeContact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the definedTradeContact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefinedTradeContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeContactType }
     * 
     * 
     */
    public List<TradeContactType> getDefinedTradeContact() {
        if (definedTradeContact == null) {
            definedTradeContact = new ArrayList<TradeContactType>();
        }
        return this.definedTradeContact;
    }

    /**
     * Ruft den Wert der postalTradeAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeAddressType }
     *     
     */
    public TradeAddressType getPostalTradeAddress() {
        return postalTradeAddress;
    }

    /**
     * Legt den Wert der postalTradeAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAddressType }
     *     
     */
    public void setPostalTradeAddress(TradeAddressType value) {
        this.postalTradeAddress = value;
    }

    /**
     * Gets the value of the uriUniversalCommunication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uriUniversalCommunication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getURIUniversalCommunication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniversalCommunicationType }
     * 
     * 
     */
    public List<UniversalCommunicationType> getURIUniversalCommunication() {
        if (uriUniversalCommunication == null) {
            uriUniversalCommunication = new ArrayList<UniversalCommunicationType>();
        }
        return this.uriUniversalCommunication;
    }

    /**
     * Gets the value of the specifiedTaxRegistration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedTaxRegistration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedTaxRegistration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxRegistrationType }
     * 
     * 
     */
    public List<TaxRegistrationType> getSpecifiedTaxRegistration() {
        if (specifiedTaxRegistration == null) {
            specifiedTaxRegistration = new ArrayList<TaxRegistrationType>();
        }
        return this.specifiedTaxRegistration;
    }

    /**
     * Ruft den Wert der endPointURIUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getEndPointURIUniversalCommunication() {
        return endPointURIUniversalCommunication;
    }

    /**
     * Legt den Wert der endPointURIUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setEndPointURIUniversalCommunication(UniversalCommunicationType value) {
        this.endPointURIUniversalCommunication = value;
    }

    /**
     * Gets the value of the logoAssociatedSpecifiedBinaryFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logoAssociatedSpecifiedBinaryFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogoAssociatedSpecifiedBinaryFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecifiedBinaryFileType }
     * 
     * 
     */
    public List<SpecifiedBinaryFileType> getLogoAssociatedSpecifiedBinaryFile() {
        if (logoAssociatedSpecifiedBinaryFile == null) {
            logoAssociatedSpecifiedBinaryFile = new ArrayList<SpecifiedBinaryFileType>();
        }
        return this.logoAssociatedSpecifiedBinaryFile;
    }

}
