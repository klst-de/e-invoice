//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.AccountingAccountTypeCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.AccountingAmountTypeCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.AccountingDocumentCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeAccountingAccountType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeAccountingAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType"/>
 *         &lt;element name="SetTriggerCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}AccountingDocumentCodeType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}AccountingAccountTypeCodeType" minOccurs="0"/>
 *         &lt;element name="AmountTypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}AccountingAmountTypeCodeType" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CostReferenceDimensionPattern" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeAccountingAccountType", propOrder = {
    "id",
    "setTriggerCode",
    "typeCode",
    "amountTypeCode",
    "name",
    "costReferenceDimensionPattern"
})
public class TradeAccountingAccountType {

    @XmlElement(name = "ID", required = true)
    protected IDType id;
    @XmlElement(name = "SetTriggerCode")
    protected AccountingDocumentCodeType setTriggerCode;
    @XmlElement(name = "TypeCode")
    protected AccountingAccountTypeCodeType typeCode;
    @XmlElement(name = "AmountTypeCode")
    protected AccountingAmountTypeCodeType amountTypeCode;
    @XmlElement(name = "Name")
    protected TextType name;
    @XmlElement(name = "CostReferenceDimensionPattern")
    protected TextType costReferenceDimensionPattern;

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
     * Ruft den Wert der setTriggerCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountingDocumentCodeType }
     *     
     */
    public AccountingDocumentCodeType getSetTriggerCode() {
        return setTriggerCode;
    }

    /**
     * Legt den Wert der setTriggerCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingDocumentCodeType }
     *     
     */
    public void setSetTriggerCode(AccountingDocumentCodeType value) {
        this.setTriggerCode = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountingAccountTypeCodeType }
     *     
     */
    public AccountingAccountTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingAccountTypeCodeType }
     *     
     */
    public void setTypeCode(AccountingAccountTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der amountTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountingAmountTypeCodeType }
     *     
     */
    public AccountingAmountTypeCodeType getAmountTypeCode() {
        return amountTypeCode;
    }

    /**
     * Legt den Wert der amountTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingAmountTypeCodeType }
     *     
     */
    public void setAmountTypeCode(AccountingAmountTypeCodeType value) {
        this.amountTypeCode = value;
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
     * Ruft den Wert der costReferenceDimensionPattern-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCostReferenceDimensionPattern() {
        return costReferenceDimensionPattern;
    }

    /**
     * Legt den Wert der costReferenceDimensionPattern-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCostReferenceDimensionPattern(TextType value) {
        this.costReferenceDimensionPattern = value;
    }

}
