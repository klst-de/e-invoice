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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseUnitMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerUnitAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TierRangeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TierRatePercentType;


/**
 * <p>Java-Klasse für TaxCategoryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TaxCategoryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Percent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BaseUnitMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PerUnitAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxExemptionReasonCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxExemptionReason" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TierRange" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TierRatePercent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxScheme"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxCategoryType", propOrder = {
    "id",
    "name",
    "percent",
    "baseUnitMeasure",
    "perUnitAmount",
    "taxExemptionReasonCode",
    "taxExemptionReason",
    "tierRange",
    "tierRatePercent",
    "taxScheme"
})
public class TaxCategoryType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameType name;
    @XmlElement(name = "Percent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PercentType percent;
    @XmlElement(name = "BaseUnitMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BaseUnitMeasureType baseUnitMeasure;
    @XmlElement(name = "PerUnitAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PerUnitAmountType perUnitAmount;
    @XmlElement(name = "TaxExemptionReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxExemptionReasonCodeType taxExemptionReasonCode;
    @XmlElement(name = "TaxExemptionReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TaxExemptionReasonType> taxExemptionReason;
    @XmlElement(name = "TierRange", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TierRangeType tierRange;
    @XmlElement(name = "TierRatePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TierRatePercentType tierRatePercent;
    @XmlElement(name = "TaxScheme", required = true)
    protected TaxSchemeType taxScheme;

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
     * Ruft den Wert der taxExemptionReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxExemptionReasonCodeType }
     *     
     */
    public TaxExemptionReasonCodeType getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }

    /**
     * Legt den Wert der taxExemptionReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxExemptionReasonCodeType }
     *     
     */
    public void setTaxExemptionReasonCode(TaxExemptionReasonCodeType value) {
        this.taxExemptionReasonCode = value;
    }

    /**
     * Gets the value of the taxExemptionReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxExemptionReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxExemptionReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxExemptionReasonType }
     * 
     * 
     */
    public List<TaxExemptionReasonType> getTaxExemptionReason() {
        if (taxExemptionReason == null) {
            taxExemptionReason = new ArrayList<TaxExemptionReasonType>();
        }
        return this.taxExemptionReason;
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
     * Ruft den Wert der taxScheme-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxSchemeType }
     *     
     */
    public TaxSchemeType getTaxScheme() {
        return taxScheme;
    }

    /**
     * Legt den Wert der taxScheme-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxSchemeType }
     *     
     */
    public void setTaxScheme(TaxSchemeType value) {
        this.taxScheme = value;
    }

}
