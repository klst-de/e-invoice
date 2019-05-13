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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für RegisteredTaxType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RegisteredTaxType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ExemptionReasonCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ExemptionReason" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="Jurisdiction" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CustomsDutyIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisteredTaxType", propOrder = {
    "typeCode",
    "exemptionReasonCode",
    "exemptionReason",
    "currencyCode",
    "jurisdiction",
    "description",
    "customsDutyIndicator"
})
public class RegisteredTaxType {

    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "ExemptionReasonCode")
    protected CodeType exemptionReasonCode;
    @XmlElement(name = "ExemptionReason")
    protected List<TextType> exemptionReason;
    @XmlElement(name = "CurrencyCode")
    protected CodeType currencyCode;
    @XmlElement(name = "Jurisdiction")
    protected List<TextType> jurisdiction;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "CustomsDutyIndicator")
    protected IndicatorType customsDutyIndicator;

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
     * Ruft den Wert der exemptionReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getExemptionReasonCode() {
        return exemptionReasonCode;
    }

    /**
     * Legt den Wert der exemptionReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setExemptionReasonCode(CodeType value) {
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
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getExemptionReason() {
        if (exemptionReason == null) {
            exemptionReason = new ArrayList<TextType>();
        }
        return this.exemptionReason;
    }

    /**
     * Ruft den Wert der currencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Legt den Wert der currencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setCurrencyCode(CodeType value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the jurisdiction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jurisdiction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJurisdiction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getJurisdiction() {
        if (jurisdiction == null) {
            jurisdiction = new ArrayList<TextType>();
        }
        return this.jurisdiction;
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
     * Ruft den Wert der customsDutyIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getCustomsDutyIndicator() {
        return customsDutyIndicator;
    }

    /**
     * Legt den Wert der customsDutyIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setCustomsDutyIndicator(IndicatorType value) {
        this.customsDutyIndicator = value;
    }

}
