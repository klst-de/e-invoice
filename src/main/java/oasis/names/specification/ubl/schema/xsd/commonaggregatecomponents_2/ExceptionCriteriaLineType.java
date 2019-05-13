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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CollaborationPriorityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExceptionResolutionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExceptionStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerformanceMetricTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SupplyChainActivityTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThresholdQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThresholdValueComparisonCodeType;


/**
 * <p>Java-Klasse für ExceptionCriteriaLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ExceptionCriteriaLineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ThresholdValueComparisonCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ThresholdQuantity"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExceptionStatusCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CollaborationPriorityCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExceptionResolutionCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SupplyChainActivityTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PerformanceMetricTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EffectivePeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupplyItem" maxOccurs="unbounded"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ForecastExceptionCriterionLine" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExceptionCriteriaLineType", propOrder = {
    "id",
    "note",
    "thresholdValueComparisonCode",
    "thresholdQuantity",
    "exceptionStatusCode",
    "collaborationPriorityCode",
    "exceptionResolutionCode",
    "supplyChainActivityTypeCode",
    "performanceMetricTypeCode",
    "effectivePeriod",
    "supplyItem",
    "forecastExceptionCriterionLine"
})
public class ExceptionCriteriaLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "ThresholdValueComparisonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ThresholdValueComparisonCodeType thresholdValueComparisonCode;
    @XmlElement(name = "ThresholdQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ThresholdQuantityType thresholdQuantity;
    @XmlElement(name = "ExceptionStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExceptionStatusCodeType exceptionStatusCode;
    @XmlElement(name = "CollaborationPriorityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CollaborationPriorityCodeType collaborationPriorityCode;
    @XmlElement(name = "ExceptionResolutionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExceptionResolutionCodeType exceptionResolutionCode;
    @XmlElement(name = "SupplyChainActivityTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SupplyChainActivityTypeCodeType supplyChainActivityTypeCode;
    @XmlElement(name = "PerformanceMetricTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PerformanceMetricTypeCodeType performanceMetricTypeCode;
    @XmlElement(name = "EffectivePeriod")
    protected PeriodType effectivePeriod;
    @XmlElement(name = "SupplyItem", required = true)
    protected List<ItemType> supplyItem;
    @XmlElement(name = "ForecastExceptionCriterionLine")
    protected ForecastExceptionCriterionLineType forecastExceptionCriterionLine;

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
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Ruft den Wert der thresholdValueComparisonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThresholdValueComparisonCodeType }
     *     
     */
    public ThresholdValueComparisonCodeType getThresholdValueComparisonCode() {
        return thresholdValueComparisonCode;
    }

    /**
     * Legt den Wert der thresholdValueComparisonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThresholdValueComparisonCodeType }
     *     
     */
    public void setThresholdValueComparisonCode(ThresholdValueComparisonCodeType value) {
        this.thresholdValueComparisonCode = value;
    }

    /**
     * Ruft den Wert der thresholdQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThresholdQuantityType }
     *     
     */
    public ThresholdQuantityType getThresholdQuantity() {
        return thresholdQuantity;
    }

    /**
     * Legt den Wert der thresholdQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThresholdQuantityType }
     *     
     */
    public void setThresholdQuantity(ThresholdQuantityType value) {
        this.thresholdQuantity = value;
    }

    /**
     * Ruft den Wert der exceptionStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionStatusCodeType }
     *     
     */
    public ExceptionStatusCodeType getExceptionStatusCode() {
        return exceptionStatusCode;
    }

    /**
     * Legt den Wert der exceptionStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionStatusCodeType }
     *     
     */
    public void setExceptionStatusCode(ExceptionStatusCodeType value) {
        this.exceptionStatusCode = value;
    }

    /**
     * Ruft den Wert der collaborationPriorityCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CollaborationPriorityCodeType }
     *     
     */
    public CollaborationPriorityCodeType getCollaborationPriorityCode() {
        return collaborationPriorityCode;
    }

    /**
     * Legt den Wert der collaborationPriorityCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CollaborationPriorityCodeType }
     *     
     */
    public void setCollaborationPriorityCode(CollaborationPriorityCodeType value) {
        this.collaborationPriorityCode = value;
    }

    /**
     * Ruft den Wert der exceptionResolutionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionResolutionCodeType }
     *     
     */
    public ExceptionResolutionCodeType getExceptionResolutionCode() {
        return exceptionResolutionCode;
    }

    /**
     * Legt den Wert der exceptionResolutionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionResolutionCodeType }
     *     
     */
    public void setExceptionResolutionCode(ExceptionResolutionCodeType value) {
        this.exceptionResolutionCode = value;
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
     * Ruft den Wert der effectivePeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * Legt den Wert der effectivePeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setEffectivePeriod(PeriodType value) {
        this.effectivePeriod = value;
    }

    /**
     * Gets the value of the supplyItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supplyItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupplyItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * 
     * 
     */
    public List<ItemType> getSupplyItem() {
        if (supplyItem == null) {
            supplyItem = new ArrayList<ItemType>();
        }
        return this.supplyItem;
    }

    /**
     * Ruft den Wert der forecastExceptionCriterionLine-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ForecastExceptionCriterionLineType }
     *     
     */
    public ForecastExceptionCriterionLineType getForecastExceptionCriterionLine() {
        return forecastExceptionCriterionLine;
    }

    /**
     * Legt den Wert der forecastExceptionCriterionLine-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastExceptionCriterionLineType }
     *     
     */
    public void setForecastExceptionCriterionLine(ForecastExceptionCriterionLineType value) {
        this.forecastExceptionCriterionLine = value;
    }

}
