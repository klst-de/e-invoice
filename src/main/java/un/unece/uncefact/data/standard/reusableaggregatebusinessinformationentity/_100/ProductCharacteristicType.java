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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für ProductCharacteristicType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ProductCharacteristicType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ValueMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="MeasurementMethodCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="Value" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ValueCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ValueDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/>
 *         &lt;element name="ValueIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="ContentTypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ValueSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" minOccurs="0"/>
 *         &lt;element name="ApplicableProductCharacteristicCondition" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ProductCharacteristicConditionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ApplicableReferencedStandard" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedStandardType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductCharacteristicType", propOrder = {
    "id",
    "typeCode",
    "description",
    "valueMeasure",
    "measurementMethodCode",
    "value",
    "valueCode",
    "valueDateTime",
    "valueIndicator",
    "contentTypeCode",
    "valueSpecifiedBinaryFile",
    "applicableProductCharacteristicCondition",
    "applicableReferencedStandard"
})
public class ProductCharacteristicType {

    @XmlElement(name = "ID")
    protected List<IDType> id;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "ValueMeasure")
    protected MeasureType valueMeasure;
    @XmlElement(name = "MeasurementMethodCode")
    protected CodeType measurementMethodCode;
    @XmlElement(name = "Value")
    protected List<TextType> value;
    @XmlElement(name = "ValueCode")
    protected CodeType valueCode;
    @XmlElement(name = "ValueDateTime")
    protected DateTimeType valueDateTime;
    @XmlElement(name = "ValueIndicator")
    protected IndicatorType valueIndicator;
    @XmlElement(name = "ContentTypeCode")
    protected CodeType contentTypeCode;
    @XmlElement(name = "ValueSpecifiedBinaryFile")
    protected SpecifiedBinaryFileType valueSpecifiedBinaryFile;
    @XmlElement(name = "ApplicableProductCharacteristicCondition")
    protected List<ProductCharacteristicConditionType> applicableProductCharacteristicCondition;
    @XmlElement(name = "ApplicableReferencedStandard")
    protected ReferencedStandardType applicableReferencedStandard;

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getID() {
        if (id == null) {
            id = new ArrayList<IDType>();
        }
        return this.id;
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
     * Ruft den Wert der valueMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getValueMeasure() {
        return valueMeasure;
    }

    /**
     * Legt den Wert der valueMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setValueMeasure(MeasureType value) {
        this.valueMeasure = value;
    }

    /**
     * Ruft den Wert der measurementMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getMeasurementMethodCode() {
        return measurementMethodCode;
    }

    /**
     * Legt den Wert der measurementMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setMeasurementMethodCode(CodeType value) {
        this.measurementMethodCode = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getValue() {
        if (value == null) {
            value = new ArrayList<TextType>();
        }
        return this.value;
    }

    /**
     * Ruft den Wert der valueCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getValueCode() {
        return valueCode;
    }

    /**
     * Legt den Wert der valueCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setValueCode(CodeType value) {
        this.valueCode = value;
    }

    /**
     * Ruft den Wert der valueDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getValueDateTime() {
        return valueDateTime;
    }

    /**
     * Legt den Wert der valueDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setValueDateTime(DateTimeType value) {
        this.valueDateTime = value;
    }

    /**
     * Ruft den Wert der valueIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getValueIndicator() {
        return valueIndicator;
    }

    /**
     * Legt den Wert der valueIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setValueIndicator(IndicatorType value) {
        this.valueIndicator = value;
    }

    /**
     * Ruft den Wert der contentTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getContentTypeCode() {
        return contentTypeCode;
    }

    /**
     * Legt den Wert der contentTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setContentTypeCode(CodeType value) {
        this.contentTypeCode = value;
    }

    /**
     * Ruft den Wert der valueSpecifiedBinaryFile-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedBinaryFileType }
     *     
     */
    public SpecifiedBinaryFileType getValueSpecifiedBinaryFile() {
        return valueSpecifiedBinaryFile;
    }

    /**
     * Legt den Wert der valueSpecifiedBinaryFile-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedBinaryFileType }
     *     
     */
    public void setValueSpecifiedBinaryFile(SpecifiedBinaryFileType value) {
        this.valueSpecifiedBinaryFile = value;
    }

    /**
     * Gets the value of the applicableProductCharacteristicCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableProductCharacteristicCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableProductCharacteristicCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductCharacteristicConditionType }
     * 
     * 
     */
    public List<ProductCharacteristicConditionType> getApplicableProductCharacteristicCondition() {
        if (applicableProductCharacteristicCondition == null) {
            applicableProductCharacteristicCondition = new ArrayList<ProductCharacteristicConditionType>();
        }
        return this.applicableProductCharacteristicCondition;
    }

    /**
     * Ruft den Wert der applicableReferencedStandard-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedStandardType }
     *     
     */
    public ReferencedStandardType getApplicableReferencedStandard() {
        return applicableReferencedStandard;
    }

    /**
     * Legt den Wert der applicableReferencedStandard-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedStandardType }
     *     
     */
    public void setApplicableReferencedStandard(ReferencedStandardType value) {
        this.applicableReferencedStandard = value;
    }

}
