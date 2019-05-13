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
import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.NumericType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.RateType;


/**
 * <p>Java-Klasse für TradeCurrencyExchangeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeCurrencyExchangeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceCurrencyCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CurrencyCodeType"/>
 *         &lt;element name="SourceUnitBasisNumeric" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}NumericType" minOccurs="0"/>
 *         &lt;element name="TargetCurrencyCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CurrencyCodeType"/>
 *         &lt;element name="TargetUnitBaseNumeric" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}NumericType" minOccurs="0"/>
 *         &lt;element name="MarketID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="ConversionRate" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}RateType"/>
 *         &lt;element name="ConversionRateDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="AssociatedReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeCurrencyExchangeType", propOrder = {
    "sourceCurrencyCode",
    "sourceUnitBasisNumeric",
    "targetCurrencyCode",
    "targetUnitBaseNumeric",
    "marketID",
    "conversionRate",
    "conversionRateDateTime",
    "associatedReferencedDocument"
})
public class TradeCurrencyExchangeType {

    @XmlElement(name = "SourceCurrencyCode", required = true)
    protected CurrencyCodeType sourceCurrencyCode;
    @XmlElement(name = "SourceUnitBasisNumeric")
    protected NumericType sourceUnitBasisNumeric;
    @XmlElement(name = "TargetCurrencyCode", required = true)
    protected CurrencyCodeType targetCurrencyCode;
    @XmlElement(name = "TargetUnitBaseNumeric")
    protected NumericType targetUnitBaseNumeric;
    @XmlElement(name = "MarketID")
    protected IDType marketID;
    @XmlElement(name = "ConversionRate", required = true)
    protected RateType conversionRate;
    @XmlElement(name = "ConversionRateDateTime")
    protected DateTimeType conversionRateDateTime;
    @XmlElement(name = "AssociatedReferencedDocument")
    protected List<ReferencedDocumentType> associatedReferencedDocument;

    /**
     * Ruft den Wert der sourceCurrencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    /**
     * Legt den Wert der sourceCurrencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setSourceCurrencyCode(CurrencyCodeType value) {
        this.sourceCurrencyCode = value;
    }

    /**
     * Ruft den Wert der sourceUnitBasisNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getSourceUnitBasisNumeric() {
        return sourceUnitBasisNumeric;
    }

    /**
     * Legt den Wert der sourceUnitBasisNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setSourceUnitBasisNumeric(NumericType value) {
        this.sourceUnitBasisNumeric = value;
    }

    /**
     * Ruft den Wert der targetCurrencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    /**
     * Legt den Wert der targetCurrencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setTargetCurrencyCode(CurrencyCodeType value) {
        this.targetCurrencyCode = value;
    }

    /**
     * Ruft den Wert der targetUnitBaseNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getTargetUnitBaseNumeric() {
        return targetUnitBaseNumeric;
    }

    /**
     * Legt den Wert der targetUnitBaseNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setTargetUnitBaseNumeric(NumericType value) {
        this.targetUnitBaseNumeric = value;
    }

    /**
     * Ruft den Wert der marketID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getMarketID() {
        return marketID;
    }

    /**
     * Legt den Wert der marketID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setMarketID(IDType value) {
        this.marketID = value;
    }

    /**
     * Ruft den Wert der conversionRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RateType }
     *     
     */
    public RateType getConversionRate() {
        return conversionRate;
    }

    /**
     * Legt den Wert der conversionRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RateType }
     *     
     */
    public void setConversionRate(RateType value) {
        this.conversionRate = value;
    }

    /**
     * Ruft den Wert der conversionRateDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getConversionRateDateTime() {
        return conversionRateDateTime;
    }

    /**
     * Legt den Wert der conversionRateDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setConversionRateDateTime(DateTimeType value) {
        this.conversionRateDateTime = value;
    }

    /**
     * Gets the value of the associatedReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getAssociatedReferencedDocument() {
        if (associatedReferencedDocument == null) {
            associatedReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.associatedReferencedDocument;
    }

}
