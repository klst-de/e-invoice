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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.NumericType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeSettlementFinancialCardType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeSettlementFinancialCardType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MicrochipIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="CardholderName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="ExpiryDate" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateType" minOccurs="0"/>
 *         &lt;element name="VerificationNumeric" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}NumericType" minOccurs="0"/>
 *         &lt;element name="ValidFromDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="CreditLimitAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreditAvailableAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InterestRatePercent" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}PercentType" minOccurs="0"/>
 *         &lt;element name="IssuingCompanyName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeSettlementFinancialCardType", propOrder = {
    "microchipIndicator",
    "id",
    "typeCode",
    "cardholderName",
    "expiryDate",
    "verificationNumeric",
    "validFromDateTime",
    "creditLimitAmount",
    "creditAvailableAmount",
    "interestRatePercent",
    "issuingCompanyName",
    "description"
})
public class TradeSettlementFinancialCardType {

    @XmlElement(name = "MicrochipIndicator")
    protected IndicatorType microchipIndicator;
    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "CardholderName")
    protected TextType cardholderName;
    @XmlElement(name = "ExpiryDate")
    protected DateType expiryDate;
    @XmlElement(name = "VerificationNumeric")
    protected NumericType verificationNumeric;
    @XmlElement(name = "ValidFromDateTime")
    protected DateTimeType validFromDateTime;
    @XmlElement(name = "CreditLimitAmount")
    protected List<AmountType> creditLimitAmount;
    @XmlElement(name = "CreditAvailableAmount")
    protected List<AmountType> creditAvailableAmount;
    @XmlElement(name = "InterestRatePercent")
    protected PercentType interestRatePercent;
    @XmlElement(name = "IssuingCompanyName")
    protected TextType issuingCompanyName;
    @XmlElement(name = "Description")
    protected TextType description;

    /**
     * Ruft den Wert der microchipIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getMicrochipIndicator() {
        return microchipIndicator;
    }

    /**
     * Legt den Wert der microchipIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setMicrochipIndicator(IndicatorType value) {
        this.microchipIndicator = value;
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
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setTypeCode(CodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der cardholderName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCardholderName() {
        return cardholderName;
    }

    /**
     * Legt den Wert der cardholderName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCardholderName(TextType value) {
        this.cardholderName = value;
    }

    /**
     * Ruft den Wert der expiryDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getExpiryDate() {
        return expiryDate;
    }

    /**
     * Legt den Wert der expiryDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setExpiryDate(DateType value) {
        this.expiryDate = value;
    }

    /**
     * Ruft den Wert der verificationNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getVerificationNumeric() {
        return verificationNumeric;
    }

    /**
     * Legt den Wert der verificationNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setVerificationNumeric(NumericType value) {
        this.verificationNumeric = value;
    }

    /**
     * Ruft den Wert der validFromDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getValidFromDateTime() {
        return validFromDateTime;
    }

    /**
     * Legt den Wert der validFromDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setValidFromDateTime(DateTimeType value) {
        this.validFromDateTime = value;
    }

    /**
     * Gets the value of the creditLimitAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditLimitAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditLimitAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getCreditLimitAmount() {
        if (creditLimitAmount == null) {
            creditLimitAmount = new ArrayList<AmountType>();
        }
        return this.creditLimitAmount;
    }

    /**
     * Gets the value of the creditAvailableAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditAvailableAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditAvailableAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getCreditAvailableAmount() {
        if (creditAvailableAmount == null) {
            creditAvailableAmount = new ArrayList<AmountType>();
        }
        return this.creditAvailableAmount;
    }

    /**
     * Ruft den Wert der interestRatePercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PercentType }
     *     
     */
    public PercentType getInterestRatePercent() {
        return interestRatePercent;
    }

    /**
     * Legt den Wert der interestRatePercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PercentType }
     *     
     */
    public void setInterestRatePercent(PercentType value) {
        this.interestRatePercent = value;
    }

    /**
     * Ruft den Wert der issuingCompanyName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getIssuingCompanyName() {
        return issuingCompanyName;
    }

    /**
     * Legt den Wert der issuingCompanyName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setIssuingCompanyName(TextType value) {
        this.issuingCompanyName = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDescription(TextType value) {
        this.description = value;
    }

}
