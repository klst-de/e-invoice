//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseUnitMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationSequenceNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerUnitAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TierRangeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TierRatePercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransactionCurrencyTaxAmountType;


/**
 * <p>Java-Klasse für TaxSubtotalType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TaxSubtotalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxableAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxAmount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CalculationSequenceNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransactionCurrencyTaxAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Percent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BaseUnitMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PerUnitAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TierRange" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TierRatePercent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxCategory"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxSubtotalType", propOrder = {
    "taxableAmount",
    "taxAmount",
    "calculationSequenceNumeric",
    "transactionCurrencyTaxAmount",
    "percent",
    "baseUnitMeasure",
    "perUnitAmount",
    "tierRange",
    "tierRatePercent",
    "taxCategory"
})
public class TaxSubtotalType {

    @XmlElement(name = "TaxableAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxableAmountType taxableAmount;
    @XmlElement(name = "TaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TaxAmountType taxAmount;
    @XmlElement(name = "CalculationSequenceNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CalculationSequenceNumericType calculationSequenceNumeric;
    @XmlElement(name = "TransactionCurrencyTaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransactionCurrencyTaxAmountType transactionCurrencyTaxAmount;
    @XmlElement(name = "Percent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PercentType percent;
    @XmlElement(name = "BaseUnitMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BaseUnitMeasureType baseUnitMeasure;
    @XmlElement(name = "PerUnitAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PerUnitAmountType perUnitAmount;
    @XmlElement(name = "TierRange", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TierRangeType tierRange;
    @XmlElement(name = "TierRatePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TierRatePercentType tierRatePercent;
    @XmlElement(name = "TaxCategory", required = true)
    protected TaxCategoryType taxCategory;

    /**
     * Ruft den Wert der taxableAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxableAmountType }
     *     
     */
    public TaxableAmountType getTaxableAmount() {
        return taxableAmount;
    }

    /**
     * Legt den Wert der taxableAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxableAmountType }
     *     
     */
    public void setTaxableAmount(TaxableAmountType value) {
        this.taxableAmount = value;
    }

    /**
     * Ruft den Wert der taxAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxAmountType }
     *     
     */
    public TaxAmountType getTaxAmount() {
        return taxAmount;
    }

    /**
     * Legt den Wert der taxAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAmountType }
     *     
     */
    public void setTaxAmount(TaxAmountType value) {
        this.taxAmount = value;
    }

    /**
     * Ruft den Wert der calculationSequenceNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CalculationSequenceNumericType }
     *     
     */
    public CalculationSequenceNumericType getCalculationSequenceNumeric() {
        return calculationSequenceNumeric;
    }

    /**
     * Legt den Wert der calculationSequenceNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculationSequenceNumericType }
     *     
     */
    public void setCalculationSequenceNumeric(CalculationSequenceNumericType value) {
        this.calculationSequenceNumeric = value;
    }

    /**
     * Ruft den Wert der transactionCurrencyTaxAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransactionCurrencyTaxAmountType }
     *     
     */
    public TransactionCurrencyTaxAmountType getTransactionCurrencyTaxAmount() {
        return transactionCurrencyTaxAmount;
    }

    /**
     * Legt den Wert der transactionCurrencyTaxAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionCurrencyTaxAmountType }
     *     
     */
    public void setTransactionCurrencyTaxAmount(TransactionCurrencyTaxAmountType value) {
        this.transactionCurrencyTaxAmount = value;
    }

    /**
     * Ruft den Wert der percent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PercentType }
     *     
     */
    public PercentType getPercent() {
        return percent;
    }

    /**
     * Legt den Wert der percent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PercentType }
     *     
     */
    public void setPercent(PercentType value) {
        this.percent = value;
    }

    /**
     * Ruft den Wert der baseUnitMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BaseUnitMeasureType }
     *     
     */
    public BaseUnitMeasureType getBaseUnitMeasure() {
        return baseUnitMeasure;
    }

    /**
     * Legt den Wert der baseUnitMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseUnitMeasureType }
     *     
     */
    public void setBaseUnitMeasure(BaseUnitMeasureType value) {
        this.baseUnitMeasure = value;
    }

    /**
     * Ruft den Wert der perUnitAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PerUnitAmountType }
     *     
     */
    public PerUnitAmountType getPerUnitAmount() {
        return perUnitAmount;
    }

    /**
     * Legt den Wert der perUnitAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PerUnitAmountType }
     *     
     */
    public void setPerUnitAmount(PerUnitAmountType value) {
        this.perUnitAmount = value;
    }

    /**
     * Ruft den Wert der tierRange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TierRangeType }
     *     
     */
    public TierRangeType getTierRange() {
        return tierRange;
    }

    /**
     * Legt den Wert der tierRange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TierRangeType }
     *     
     */
    public void setTierRange(TierRangeType value) {
        this.tierRange = value;
    }

    /**
     * Ruft den Wert der tierRatePercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TierRatePercentType }
     *     
     */
    public TierRatePercentType getTierRatePercent() {
        return tierRatePercent;
    }

    /**
     * Legt den Wert der tierRatePercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TierRatePercentType }
     *     
     */
    public void setTierRatePercent(TierRatePercentType value) {
        this.tierRatePercent = value;
    }

    /**
     * Ruft den Wert der taxCategory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxCategoryType }
     *     
     */
    public TaxCategoryType getTaxCategory() {
        return taxCategory;
    }

    /**
     * Legt den Wert der taxCategory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCategoryType }
     *     
     */
    public void setTaxCategory(TaxCategoryType value) {
        this.taxCategory = value;
    }

}
