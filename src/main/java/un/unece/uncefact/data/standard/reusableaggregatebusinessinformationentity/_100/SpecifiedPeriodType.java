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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.NumericType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für SpecifiedPeriodType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpecifiedPeriodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DurationMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InclusiveIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StartDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="EndDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="CompleteDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="OpenIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="SeasonCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SequenceNumeric" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}NumericType" minOccurs="0"/>
 *         &lt;element name="StartDateFlexibilityCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ContinuousIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="PurposeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecifiedPeriodType", propOrder = {
    "durationMeasure",
    "inclusiveIndicator",
    "description",
    "startDateTime",
    "endDateTime",
    "completeDateTime",
    "openIndicator",
    "seasonCode",
    "id",
    "name",
    "sequenceNumeric",
    "startDateFlexibilityCode",
    "continuousIndicator",
    "purposeCode"
})
public class SpecifiedPeriodType {

    @XmlElement(name = "DurationMeasure")
    protected List<MeasureType> durationMeasure;
    @XmlElement(name = "InclusiveIndicator")
    protected IndicatorType inclusiveIndicator;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "StartDateTime")
    protected DateTimeType startDateTime;
    @XmlElement(name = "EndDateTime")
    protected DateTimeType endDateTime;
    @XmlElement(name = "CompleteDateTime")
    protected DateTimeType completeDateTime;
    @XmlElement(name = "OpenIndicator")
    protected IndicatorType openIndicator;
    @XmlElement(name = "SeasonCode")
    protected CodeType seasonCode;
    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "Name")
    protected List<TextType> name;
    @XmlElement(name = "SequenceNumeric")
    protected NumericType sequenceNumeric;
    @XmlElement(name = "StartDateFlexibilityCode")
    protected CodeType startDateFlexibilityCode;
    @XmlElement(name = "ContinuousIndicator")
    protected IndicatorType continuousIndicator;
    @XmlElement(name = "PurposeCode")
    protected CodeType purposeCode;

    /**
     * Gets the value of the durationMeasure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the durationMeasure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDurationMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureType }
     * 
     * 
     */
    public List<MeasureType> getDurationMeasure() {
        if (durationMeasure == null) {
            durationMeasure = new ArrayList<MeasureType>();
        }
        return this.durationMeasure;
    }

    /**
     * Ruft den Wert der inclusiveIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getInclusiveIndicator() {
        return inclusiveIndicator;
    }

    /**
     * Legt den Wert der inclusiveIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setInclusiveIndicator(IndicatorType value) {
        this.inclusiveIndicator = value;
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
     * Ruft den Wert der startDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getStartDateTime() {
        return startDateTime;
    }

    /**
     * Legt den Wert der startDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setStartDateTime(DateTimeType value) {
        this.startDateTime = value;
    }

    /**
     * Ruft den Wert der endDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getEndDateTime() {
        return endDateTime;
    }

    /**
     * Legt den Wert der endDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setEndDateTime(DateTimeType value) {
        this.endDateTime = value;
    }

    /**
     * Ruft den Wert der completeDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getCompleteDateTime() {
        return completeDateTime;
    }

    /**
     * Legt den Wert der completeDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setCompleteDateTime(DateTimeType value) {
        this.completeDateTime = value;
    }

    /**
     * Ruft den Wert der openIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getOpenIndicator() {
        return openIndicator;
    }

    /**
     * Legt den Wert der openIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setOpenIndicator(IndicatorType value) {
        this.openIndicator = value;
    }

    /**
     * Ruft den Wert der seasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getSeasonCode() {
        return seasonCode;
    }

    /**
     * Legt den Wert der seasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setSeasonCode(CodeType value) {
        this.seasonCode = value;
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
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getName() {
        if (name == null) {
            name = new ArrayList<TextType>();
        }
        return this.name;
    }

    /**
     * Ruft den Wert der sequenceNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getSequenceNumeric() {
        return sequenceNumeric;
    }

    /**
     * Legt den Wert der sequenceNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setSequenceNumeric(NumericType value) {
        this.sequenceNumeric = value;
    }

    /**
     * Ruft den Wert der startDateFlexibilityCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getStartDateFlexibilityCode() {
        return startDateFlexibilityCode;
    }

    /**
     * Legt den Wert der startDateFlexibilityCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setStartDateFlexibilityCode(CodeType value) {
        this.startDateFlexibilityCode = value;
    }

    /**
     * Ruft den Wert der continuousIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getContinuousIndicator() {
        return continuousIndicator;
    }

    /**
     * Legt den Wert der continuousIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setContinuousIndicator(IndicatorType value) {
        this.continuousIndicator = value;
    }

    /**
     * Ruft den Wert der purposeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getPurposeCode() {
        return purposeCode;
    }

    /**
     * Legt den Wert der purposeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setPurposeCode(CodeType value) {
        this.purposeCode = value;
    }

}
