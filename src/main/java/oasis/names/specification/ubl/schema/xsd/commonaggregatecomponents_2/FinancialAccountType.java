//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountFormatCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AliasNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentNoteType;


/**
 * <p>Java-Klasse für FinancialAccountType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FinancialAccountType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AliasName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountFormatCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CurrencyCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentNote" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinancialInstitutionBranch" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Country" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialAccountType", propOrder = {
    "id",
    "name",
    "aliasName",
    "accountTypeCode",
    "accountFormatCode",
    "currencyCode",
    "paymentNote",
    "financialInstitutionBranch",
    "country"
})
public class FinancialAccountType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameType name;
    @XmlElement(name = "AliasName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AliasNameType aliasName;
    @XmlElement(name = "AccountTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountTypeCodeType accountTypeCode;
    @XmlElement(name = "AccountFormatCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountFormatCodeType accountFormatCode;
    @XmlElement(name = "CurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CurrencyCodeType currencyCode;
    @XmlElement(name = "PaymentNote", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PaymentNoteType> paymentNote;
    @XmlElement(name = "FinancialInstitutionBranch")
    protected BranchType financialInstitutionBranch;
    @XmlElement(name = "Country")
    protected CountryType country;

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
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setName(NameType value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der aliasName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AliasNameType }
     *     
     */
    public AliasNameType getAliasName() {
        return aliasName;
    }

    /**
     * Legt den Wert der aliasName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AliasNameType }
     *     
     */
    public void setAliasName(AliasNameType value) {
        this.aliasName = value;
    }

    /**
     * Ruft den Wert der accountTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountTypeCodeType }
     *     
     */
    public AccountTypeCodeType getAccountTypeCode() {
        return accountTypeCode;
    }

    /**
     * Legt den Wert der accountTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountTypeCodeType }
     *     
     */
    public void setAccountTypeCode(AccountTypeCodeType value) {
        this.accountTypeCode = value;
    }

    /**
     * Ruft den Wert der accountFormatCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountFormatCodeType }
     *     
     */
    public AccountFormatCodeType getAccountFormatCode() {
        return accountFormatCode;
    }

    /**
     * Legt den Wert der accountFormatCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountFormatCodeType }
     *     
     */
    public void setAccountFormatCode(AccountFormatCodeType value) {
        this.accountFormatCode = value;
    }

    /**
     * Ruft den Wert der currencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Legt den Wert der currencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setCurrencyCode(CurrencyCodeType value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the paymentNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentNoteType }
     * 
     * 
     */
    public List<PaymentNoteType> getPaymentNote() {
        if (paymentNote == null) {
            paymentNote = new ArrayList<PaymentNoteType>();
        }
        return this.paymentNote;
    }

    /**
     * Ruft den Wert der financialInstitutionBranch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchType }
     *     
     */
    public BranchType getFinancialInstitutionBranch() {
        return financialInstitutionBranch;
    }

    /**
     * Legt den Wert der financialInstitutionBranch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchType }
     *     
     */
    public void setFinancialInstitutionBranch(BranchType value) {
        this.financialInstitutionBranch = value;
    }

    /**
     * Ruft den Wert der country-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Legt den Wert der country-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

}
