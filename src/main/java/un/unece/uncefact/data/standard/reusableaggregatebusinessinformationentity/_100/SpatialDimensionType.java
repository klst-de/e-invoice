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
import un.unece.uncefact.data.standard.qualifieddatatype._100.DimensionTypeCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.LinearUnitMeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für SpatialDimensionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpatialDimensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ValueMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}DimensionTypeCodeType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="WidthMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="LengthMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="HeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="DiameterMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}LinearUnitMeasureType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpatialDimensionType", propOrder = {
    "valueMeasure",
    "typeCode",
    "description",
    "widthMeasure",
    "lengthMeasure",
    "heightMeasure",
    "id",
    "diameterMeasure"
})
public class SpatialDimensionType {

    @XmlElement(name = "ValueMeasure")
    protected MeasureType valueMeasure;
    @XmlElement(name = "TypeCode")
    protected DimensionTypeCodeType typeCode;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "WidthMeasure")
    protected MeasureType widthMeasure;
    @XmlElement(name = "LengthMeasure")
    protected MeasureType lengthMeasure;
    @XmlElement(name = "HeightMeasure")
    protected MeasureType heightMeasure;
    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "DiameterMeasure")
    protected LinearUnitMeasureType diameterMeasure;

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
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DimensionTypeCodeType }
     *     
     */
    public DimensionTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionTypeCodeType }
     *     
     */
    public void setTypeCode(DimensionTypeCodeType value) {
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
     * Ruft den Wert der widthMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getWidthMeasure() {
        return widthMeasure;
    }

    /**
     * Legt den Wert der widthMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setWidthMeasure(MeasureType value) {
        this.widthMeasure = value;
    }

    /**
     * Ruft den Wert der lengthMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getLengthMeasure() {
        return lengthMeasure;
    }

    /**
     * Legt den Wert der lengthMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setLengthMeasure(MeasureType value) {
        this.lengthMeasure = value;
    }

    /**
     * Ruft den Wert der heightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getHeightMeasure() {
        return heightMeasure;
    }

    /**
     * Legt den Wert der heightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setHeightMeasure(MeasureType value) {
        this.heightMeasure = value;
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
     * Ruft den Wert der diameterMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LinearUnitMeasureType }
     *     
     */
    public LinearUnitMeasureType getDiameterMeasure() {
        return diameterMeasure;
    }

    /**
     * Legt den Wert der diameterMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LinearUnitMeasureType }
     *     
     */
    public void setDiameterMeasure(LinearUnitMeasureType value) {
        this.diameterMeasure = value;
    }

}
