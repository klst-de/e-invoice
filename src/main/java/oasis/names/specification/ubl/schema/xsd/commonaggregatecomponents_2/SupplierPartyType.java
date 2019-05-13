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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomerAssignedAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DataSendingCapabilityType;


/**
 * <p>Java-Klasse für SupplierPartyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SupplierPartyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomerAssignedAccountID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalAccountID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DataSendingCapability" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Party" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DespatchContact" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AccountingContact" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SellerContact" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplierPartyType", propOrder = {
    "customerAssignedAccountID",
    "additionalAccountID",
    "dataSendingCapability",
    "party",
    "despatchContact",
    "accountingContact",
    "sellerContact"
})
public class SupplierPartyType {

    @XmlElement(name = "CustomerAssignedAccountID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CustomerAssignedAccountIDType customerAssignedAccountID;
    @XmlElement(name = "AdditionalAccountID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<AdditionalAccountIDType> additionalAccountID;
    @XmlElement(name = "DataSendingCapability", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DataSendingCapabilityType dataSendingCapability;
    @XmlElement(name = "Party")
    protected PartyType party;
    @XmlElement(name = "DespatchContact")
    protected ContactType despatchContact;
    @XmlElement(name = "AccountingContact")
    protected ContactType accountingContact;
    @XmlElement(name = "SellerContact")
    protected ContactType sellerContact;

    /**
     * Ruft den Wert der customerAssignedAccountID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAssignedAccountIDType }
     *     
     */
    public CustomerAssignedAccountIDType getCustomerAssignedAccountID() {
        return customerAssignedAccountID;
    }

    /**
     * Legt den Wert der customerAssignedAccountID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAssignedAccountIDType }
     *     
     */
    public void setCustomerAssignedAccountID(CustomerAssignedAccountIDType value) {
        this.customerAssignedAccountID = value;
    }

    /**
     * Gets the value of the additionalAccountID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalAccountID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalAccountID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalAccountIDType }
     * 
     * 
     */
    public List<AdditionalAccountIDType> getAdditionalAccountID() {
        if (additionalAccountID == null) {
            additionalAccountID = new ArrayList<AdditionalAccountIDType>();
        }
        return this.additionalAccountID;
    }

    /**
     * Ruft den Wert der dataSendingCapability-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataSendingCapabilityType }
     *     
     */
    public DataSendingCapabilityType getDataSendingCapability() {
        return dataSendingCapability;
    }

    /**
     * Legt den Wert der dataSendingCapability-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSendingCapabilityType }
     *     
     */
    public void setDataSendingCapability(DataSendingCapabilityType value) {
        this.dataSendingCapability = value;
    }

    /**
     * Ruft den Wert der party-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getParty() {
        return party;
    }

    /**
     * Legt den Wert der party-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setParty(PartyType value) {
        this.party = value;
    }

    /**
     * Ruft den Wert der despatchContact-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getDespatchContact() {
        return despatchContact;
    }

    /**
     * Legt den Wert der despatchContact-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setDespatchContact(ContactType value) {
        this.despatchContact = value;
    }

    /**
     * Ruft den Wert der accountingContact-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getAccountingContact() {
        return accountingContact;
    }

    /**
     * Legt den Wert der accountingContact-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setAccountingContact(ContactType value) {
        this.accountingContact = value;
    }

    /**
     * Ruft den Wert der sellerContact-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getSellerContact() {
        return sellerContact;
    }

    /**
     * Legt den Wert der sellerContact-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setSellerContact(ContactType value) {
        this.sellerContact = value;
    }

}
