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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für LegalOrganizationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LegalOrganizationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalClassificationCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="TradingBusinessName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="PostalTradeAddress" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAddressType" minOccurs="0"/>
 *         &lt;element name="AuthorizedLegalRegistration" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LegalRegistrationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalOrganizationType", propOrder = {
    "legalClassificationCode",
    "name",
    "id",
    "tradingBusinessName",
    "postalTradeAddress",
    "authorizedLegalRegistration"
})
public class LegalOrganizationType {

    @XmlElement(name = "LegalClassificationCode")
    protected CodeType legalClassificationCode;
    @XmlElement(name = "Name")
    protected TextType name;
    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "TradingBusinessName")
    protected TextType tradingBusinessName;
    @XmlElement(name = "PostalTradeAddress")
    protected TradeAddressType postalTradeAddress;
    @XmlElement(name = "AuthorizedLegalRegistration")
    protected List<LegalRegistrationType> authorizedLegalRegistration;

    /**
     * Ruft den Wert der legalClassificationCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getLegalClassificationCode() {
        return legalClassificationCode;
    }

    /**
     * Legt den Wert der legalClassificationCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setLegalClassificationCode(CodeType value) {
        this.legalClassificationCode = value;
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
     * Ruft den Wert der tradingBusinessName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTradingBusinessName() {
        return tradingBusinessName;
    }

    /**
     * Legt den Wert der tradingBusinessName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTradingBusinessName(TextType value) {
        this.tradingBusinessName = value;
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
     * Gets the value of the authorizedLegalRegistration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorizedLegalRegistration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorizedLegalRegistration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegalRegistrationType }
     * 
     * 
     */
    public List<LegalRegistrationType> getAuthorizedLegalRegistration() {
        if (authorizedLegalRegistration == null) {
            authorizedLegalRegistration = new ArrayList<LegalRegistrationType>();
        }
        return this.authorizedLegalRegistration;
    }

}
