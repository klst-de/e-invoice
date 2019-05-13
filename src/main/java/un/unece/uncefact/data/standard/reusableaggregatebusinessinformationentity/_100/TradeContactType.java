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
import un.unece.uncefact.data.standard.qualifieddatatype._100.ContactTypeCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeContactType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeContactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="PersonName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="DepartmentName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}ContactTypeCodeType" minOccurs="0"/>
 *         &lt;element name="JobTitle" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="Responsibility" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="PersonID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TelephoneUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="DirectTelephoneUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="MobileTelephoneUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="FaxUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="EmailURIUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="TelexUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="VOIPUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="InstantMessagingUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
 *         &lt;element name="SpecifiedNote" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}NoteType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedContactPerson" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ContactPersonType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeContactType", propOrder = {
    "id",
    "personName",
    "departmentName",
    "typeCode",
    "jobTitle",
    "responsibility",
    "personID",
    "telephoneUniversalCommunication",
    "directTelephoneUniversalCommunication",
    "mobileTelephoneUniversalCommunication",
    "faxUniversalCommunication",
    "emailURIUniversalCommunication",
    "telexUniversalCommunication",
    "voipUniversalCommunication",
    "instantMessagingUniversalCommunication",
    "specifiedNote",
    "specifiedContactPerson"
})
public class TradeContactType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "PersonName")
    protected TextType personName;
    @XmlElement(name = "DepartmentName")
    protected TextType departmentName;
    @XmlElement(name = "TypeCode")
    protected ContactTypeCodeType typeCode;
    @XmlElement(name = "JobTitle")
    protected TextType jobTitle;
    @XmlElement(name = "Responsibility")
    protected TextType responsibility;
    @XmlElement(name = "PersonID")
    protected List<IDType> personID;
    @XmlElement(name = "TelephoneUniversalCommunication")
    protected UniversalCommunicationType telephoneUniversalCommunication;
    @XmlElement(name = "DirectTelephoneUniversalCommunication")
    protected UniversalCommunicationType directTelephoneUniversalCommunication;
    @XmlElement(name = "MobileTelephoneUniversalCommunication")
    protected UniversalCommunicationType mobileTelephoneUniversalCommunication;
    @XmlElement(name = "FaxUniversalCommunication")
    protected UniversalCommunicationType faxUniversalCommunication;
    @XmlElement(name = "EmailURIUniversalCommunication")
    protected UniversalCommunicationType emailURIUniversalCommunication;
    @XmlElement(name = "TelexUniversalCommunication")
    protected UniversalCommunicationType telexUniversalCommunication;
    @XmlElement(name = "VOIPUniversalCommunication")
    protected UniversalCommunicationType voipUniversalCommunication;
    @XmlElement(name = "InstantMessagingUniversalCommunication")
    protected UniversalCommunicationType instantMessagingUniversalCommunication;
    @XmlElement(name = "SpecifiedNote")
    protected List<NoteType> specifiedNote;
    @XmlElement(name = "SpecifiedContactPerson")
    protected ContactPersonType specifiedContactPerson;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der personName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPersonName() {
        return personName;
    }

    /**
     * Legt den Wert der personName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPersonName(TextType value) {
        this.personName = value;
    }

    /**
     * Ruft den Wert der departmentName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDepartmentName() {
        return departmentName;
    }

    /**
     * Legt den Wert der departmentName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDepartmentName(TextType value) {
        this.departmentName = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactTypeCodeType }
     *     
     */
    public ContactTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactTypeCodeType }
     *     
     */
    public void setTypeCode(ContactTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der jobTitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getJobTitle() {
        return jobTitle;
    }

    /**
     * Legt den Wert der jobTitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setJobTitle(TextType value) {
        this.jobTitle = value;
    }

    /**
     * Ruft den Wert der responsibility-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getResponsibility() {
        return responsibility;
    }

    /**
     * Legt den Wert der responsibility-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setResponsibility(TextType value) {
        this.responsibility = value;
    }

    /**
     * Gets the value of the personID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getPersonID() {
        if (personID == null) {
            personID = new ArrayList<IDType>();
        }
        return this.personID;
    }

    /**
     * Ruft den Wert der telephoneUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getTelephoneUniversalCommunication() {
        return telephoneUniversalCommunication;
    }

    /**
     * Legt den Wert der telephoneUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setTelephoneUniversalCommunication(UniversalCommunicationType value) {
        this.telephoneUniversalCommunication = value;
    }

    /**
     * Ruft den Wert der directTelephoneUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getDirectTelephoneUniversalCommunication() {
        return directTelephoneUniversalCommunication;
    }

    /**
     * Legt den Wert der directTelephoneUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setDirectTelephoneUniversalCommunication(UniversalCommunicationType value) {
        this.directTelephoneUniversalCommunication = value;
    }

    /**
     * Ruft den Wert der mobileTelephoneUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getMobileTelephoneUniversalCommunication() {
        return mobileTelephoneUniversalCommunication;
    }

    /**
     * Legt den Wert der mobileTelephoneUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setMobileTelephoneUniversalCommunication(UniversalCommunicationType value) {
        this.mobileTelephoneUniversalCommunication = value;
    }

    /**
     * Ruft den Wert der faxUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getFaxUniversalCommunication() {
        return faxUniversalCommunication;
    }

    /**
     * Legt den Wert der faxUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setFaxUniversalCommunication(UniversalCommunicationType value) {
        this.faxUniversalCommunication = value;
    }

    /**
     * Ruft den Wert der emailURIUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getEmailURIUniversalCommunication() {
        return emailURIUniversalCommunication;
    }

    /**
     * Legt den Wert der emailURIUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setEmailURIUniversalCommunication(UniversalCommunicationType value) {
        this.emailURIUniversalCommunication = value;
    }

    /**
     * Ruft den Wert der telexUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getTelexUniversalCommunication() {
        return telexUniversalCommunication;
    }

    /**
     * Legt den Wert der telexUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setTelexUniversalCommunication(UniversalCommunicationType value) {
        this.telexUniversalCommunication = value;
    }

    /**
     * Ruft den Wert der voipUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getVOIPUniversalCommunication() {
        return voipUniversalCommunication;
    }

    /**
     * Legt den Wert der voipUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setVOIPUniversalCommunication(UniversalCommunicationType value) {
        this.voipUniversalCommunication = value;
    }

    /**
     * Ruft den Wert der instantMessagingUniversalCommunication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public UniversalCommunicationType getInstantMessagingUniversalCommunication() {
        return instantMessagingUniversalCommunication;
    }

    /**
     * Legt den Wert der instantMessagingUniversalCommunication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UniversalCommunicationType }
     *     
     */
    public void setInstantMessagingUniversalCommunication(UniversalCommunicationType value) {
        this.instantMessagingUniversalCommunication = value;
    }

    /**
     * Gets the value of the specifiedNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getSpecifiedNote() {
        if (specifiedNote == null) {
            specifiedNote = new ArrayList<NoteType>();
        }
        return this.specifiedNote;
    }

    /**
     * Ruft den Wert der specifiedContactPerson-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactPersonType }
     *     
     */
    public ContactPersonType getSpecifiedContactPerson() {
        return specifiedContactPerson;
    }

    /**
     * Legt den Wert der specifiedContactPerson-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactPersonType }
     *     
     */
    public void setSpecifiedContactPerson(ContactPersonType value) {
        this.specifiedContactPerson = value;
    }

}
