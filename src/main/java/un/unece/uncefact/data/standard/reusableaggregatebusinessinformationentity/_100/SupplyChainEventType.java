//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.BinaryObjectType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für SupplyChainEventType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SupplyChainEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="OccurrenceDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DescriptionBinaryObject" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}BinaryObjectType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="UnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="LatestOccurrenceDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="EarliestOccurrenceDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="OccurrenceSpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/&gt;
 *         &lt;element name="OccurrenceLogisticsLocation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsLocationType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainEventType", propOrder = {
    "id",
    "occurrenceDateTime",
    "typeCode",
    "description",
    "descriptionBinaryObject",
    "unitQuantity",
    "latestOccurrenceDateTime",
    "earliestOccurrenceDateTime",
    "occurrenceSpecifiedPeriod",
    "occurrenceLogisticsLocation"
})
public class SupplyChainEventType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "OccurrenceDateTime")
    protected DateTimeType occurrenceDateTime;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "DescriptionBinaryObject")
    protected List<BinaryObjectType> descriptionBinaryObject;
    @XmlElement(name = "UnitQuantity")
    protected QuantityType unitQuantity;
    @XmlElement(name = "LatestOccurrenceDateTime")
    protected DateTimeType latestOccurrenceDateTime;
    @XmlElement(name = "EarliestOccurrenceDateTime")
    protected DateTimeType earliestOccurrenceDateTime;
    @XmlElement(name = "OccurrenceSpecifiedPeriod")
    protected SpecifiedPeriodType occurrenceSpecifiedPeriod;
    @XmlElement(name = "OccurrenceLogisticsLocation")
    protected LogisticsLocationType occurrenceLogisticsLocation;

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
     * Ruft den Wert der occurrenceDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getOccurrenceDateTime() {
        return occurrenceDateTime;
    }

    /**
     * Legt den Wert der occurrenceDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setOccurrenceDateTime(DateTimeType value) {
        this.occurrenceDateTime = value;
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
     * Gets the value of the descriptionBinaryObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the descriptionBinaryObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescriptionBinaryObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BinaryObjectType }
     * 
     * 
     */
    public List<BinaryObjectType> getDescriptionBinaryObject() {
        if (descriptionBinaryObject == null) {
            descriptionBinaryObject = new ArrayList<BinaryObjectType>();
        }
        return this.descriptionBinaryObject;
    }

    /**
     * Ruft den Wert der unitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getUnitQuantity() {
        return unitQuantity;
    }

    /**
     * Legt den Wert der unitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setUnitQuantity(QuantityType value) {
        this.unitQuantity = value;
    }

    /**
     * Ruft den Wert der latestOccurrenceDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getLatestOccurrenceDateTime() {
        return latestOccurrenceDateTime;
    }

    /**
     * Legt den Wert der latestOccurrenceDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setLatestOccurrenceDateTime(DateTimeType value) {
        this.latestOccurrenceDateTime = value;
    }

    /**
     * Ruft den Wert der earliestOccurrenceDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getEarliestOccurrenceDateTime() {
        return earliestOccurrenceDateTime;
    }

    /**
     * Legt den Wert der earliestOccurrenceDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setEarliestOccurrenceDateTime(DateTimeType value) {
        this.earliestOccurrenceDateTime = value;
    }

    /**
     * Ruft den Wert der occurrenceSpecifiedPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public SpecifiedPeriodType getOccurrenceSpecifiedPeriod() {
        return occurrenceSpecifiedPeriod;
    }

    /**
     * Legt den Wert der occurrenceSpecifiedPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public void setOccurrenceSpecifiedPeriod(SpecifiedPeriodType value) {
        this.occurrenceSpecifiedPeriod = value;
    }

    /**
     * Ruft den Wert der occurrenceLogisticsLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LogisticsLocationType }
     *     
     */
    public LogisticsLocationType getOccurrenceLogisticsLocation() {
        return occurrenceLogisticsLocation;
    }

    /**
     * Legt den Wert der occurrenceLogisticsLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LogisticsLocationType }
     *     
     */
    public void setOccurrenceLogisticsLocation(LogisticsLocationType value) {
        this.occurrenceLogisticsLocation = value;
    }

}
