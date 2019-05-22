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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForecastTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerformanceMetricTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SupplyChainActivityTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimeFrequencyCodeType;


/**
 * <p>Java-Klasse für ItemInformationRequestLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ItemInformationRequestLineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimeFrequencyCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SupplyChainActivityTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForecastTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PerformanceMetricTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Period" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SalesItem" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemInformationRequestLineType", propOrder = {
    "timeFrequencyCode",
    "supplyChainActivityTypeCode",
    "forecastTypeCode",
    "performanceMetricTypeCode",
    "period",
    "salesItem"
})
public class ItemInformationRequestLineType {

    @XmlElement(name = "TimeFrequencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimeFrequencyCodeType timeFrequencyCode;
    @XmlElement(name = "SupplyChainActivityTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SupplyChainActivityTypeCodeType supplyChainActivityTypeCode;
    @XmlElement(name = "ForecastTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ForecastTypeCodeType forecastTypeCode;
    @XmlElement(name = "PerformanceMetricTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PerformanceMetricTypeCodeType performanceMetricTypeCode;
    @XmlElement(name = "Period", required = true)
    protected List<PeriodType> period;
    @XmlElement(name = "SalesItem", required = true)
    protected List<SalesItemType> salesItem;

    /**
     * Ruft den Wert der timeFrequencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TimeFrequencyCodeType }
     *     
     */
    public TimeFrequencyCodeType getTimeFrequencyCode() {
        return timeFrequencyCode;
    }

    /**
     * Legt den Wert der timeFrequencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeFrequencyCodeType }
     *     
     */
    public void setTimeFrequencyCode(TimeFrequencyCodeType value) {
        this.timeFrequencyCode = value;
    }

    /**
     * Ruft den Wert der supplyChainActivityTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainActivityTypeCodeType }
     *     
     */
    public SupplyChainActivityTypeCodeType getSupplyChainActivityTypeCode() {
        return supplyChainActivityTypeCode;
    }

    /**
     * Legt den Wert der supplyChainActivityTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainActivityTypeCodeType }
     *     
     */
    public void setSupplyChainActivityTypeCode(SupplyChainActivityTypeCodeType value) {
        this.supplyChainActivityTypeCode = value;
    }

    /**
     * Ruft den Wert der forecastTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ForecastTypeCodeType }
     *     
     */
    public ForecastTypeCodeType getForecastTypeCode() {
        return forecastTypeCode;
    }

    /**
     * Legt den Wert der forecastTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastTypeCodeType }
     *     
     */
    public void setForecastTypeCode(ForecastTypeCodeType value) {
        this.forecastTypeCode = value;
    }

    /**
     * Ruft den Wert der performanceMetricTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceMetricTypeCodeType }
     *     
     */
    public PerformanceMetricTypeCodeType getPerformanceMetricTypeCode() {
        return performanceMetricTypeCode;
    }

    /**
     * Legt den Wert der performanceMetricTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceMetricTypeCodeType }
     *     
     */
    public void setPerformanceMetricTypeCode(PerformanceMetricTypeCodeType value) {
        this.performanceMetricTypeCode = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the period property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getPeriod() {
        if (period == null) {
            period = new ArrayList<PeriodType>();
        }
        return this.period;
    }

    /**
     * Gets the value of the salesItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalesItemType }
     * 
     * 
     */
    public List<SalesItemType> getSalesItem() {
        if (salesItem == null) {
            salesItem = new ArrayList<SalesItemType>();
        }
        return this.salesItem;
    }

}
