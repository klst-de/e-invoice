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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdjustmentReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RevisedForecastLineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceForecastIssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceForecastIssueTimeType;


/**
 * <p>Java-Klasse für ForecastRevisionLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ForecastRevisionLineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RevisedForecastLineID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SourceForecastIssueDate"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SourceForecastIssueTime"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdjustmentReasonCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ForecastPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SalesItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForecastRevisionLineType", propOrder = {
    "id",
    "note",
    "description",
    "revisedForecastLineID",
    "sourceForecastIssueDate",
    "sourceForecastIssueTime",
    "adjustmentReasonCode",
    "forecastPeriod",
    "salesItem"
})
public class ForecastRevisionLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "RevisedForecastLineID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected RevisedForecastLineIDType revisedForecastLineID;
    @XmlElement(name = "SourceForecastIssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected SourceForecastIssueDateType sourceForecastIssueDate;
    @XmlElement(name = "SourceForecastIssueTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected SourceForecastIssueTimeType sourceForecastIssueTime;
    @XmlElement(name = "AdjustmentReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AdjustmentReasonCodeType adjustmentReasonCode;
    @XmlElement(name = "ForecastPeriod")
    protected PeriodType forecastPeriod;
    @XmlElement(name = "SalesItem")
    protected SalesItemType salesItem;

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
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der revisedForecastLineID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RevisedForecastLineIDType }
     *     
     */
    public RevisedForecastLineIDType getRevisedForecastLineID() {
        return revisedForecastLineID;
    }

    /**
     * Legt den Wert der revisedForecastLineID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RevisedForecastLineIDType }
     *     
     */
    public void setRevisedForecastLineID(RevisedForecastLineIDType value) {
        this.revisedForecastLineID = value;
    }

    /**
     * Ruft den Wert der sourceForecastIssueDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SourceForecastIssueDateType }
     *     
     */
    public SourceForecastIssueDateType getSourceForecastIssueDate() {
        return sourceForecastIssueDate;
    }

    /**
     * Legt den Wert der sourceForecastIssueDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceForecastIssueDateType }
     *     
     */
    public void setSourceForecastIssueDate(SourceForecastIssueDateType value) {
        this.sourceForecastIssueDate = value;
    }

    /**
     * Ruft den Wert der sourceForecastIssueTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SourceForecastIssueTimeType }
     *     
     */
    public SourceForecastIssueTimeType getSourceForecastIssueTime() {
        return sourceForecastIssueTime;
    }

    /**
     * Legt den Wert der sourceForecastIssueTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceForecastIssueTimeType }
     *     
     */
    public void setSourceForecastIssueTime(SourceForecastIssueTimeType value) {
        this.sourceForecastIssueTime = value;
    }

    /**
     * Ruft den Wert der adjustmentReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AdjustmentReasonCodeType }
     *     
     */
    public AdjustmentReasonCodeType getAdjustmentReasonCode() {
        return adjustmentReasonCode;
    }

    /**
     * Legt den Wert der adjustmentReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AdjustmentReasonCodeType }
     *     
     */
    public void setAdjustmentReasonCode(AdjustmentReasonCodeType value) {
        this.adjustmentReasonCode = value;
    }

    /**
     * Ruft den Wert der forecastPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getForecastPeriod() {
        return forecastPeriod;
    }

    /**
     * Legt den Wert der forecastPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setForecastPeriod(PeriodType value) {
        this.forecastPeriod = value;
    }

    /**
     * Ruft den Wert der salesItem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SalesItemType }
     *     
     */
    public SalesItemType getSalesItem() {
        return salesItem;
    }

    /**
     * Legt den Wert der salesItem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesItemType }
     *     
     */
    public void setSalesItem(SalesItemType value) {
        this.salesItem = value;
    }

}
