//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.LinearUnitMeasureType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TransportEquipmentCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TransportEquipmentFullnessCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TransportEquipmentSizeTypeCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;


/**
 * <p>Java-Klasse für LogisticsTransportEquipmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LogisticsTransportEquipmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="LoadingLengthMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}LinearUnitMeasureType" minOccurs="0"/&gt;
 *         &lt;element name="CategoryCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TransportEquipmentCategoryCodeType" minOccurs="0"/&gt;
 *         &lt;element name="CharacteristicCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TransportEquipmentSizeTypeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="UsedCapacityCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TransportEquipmentFullnessCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LinearSpatialDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpatialDimensionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogisticsTransportEquipmentType", propOrder = {
    "id",
    "loadingLengthMeasure",
    "categoryCode",
    "characteristicCode",
    "usedCapacityCode",
    "linearSpatialDimension"
})
public class LogisticsTransportEquipmentType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "LoadingLengthMeasure")
    protected LinearUnitMeasureType loadingLengthMeasure;
    @XmlElement(name = "CategoryCode")
    protected TransportEquipmentCategoryCodeType categoryCode;
    @XmlElement(name = "CharacteristicCode")
    protected TransportEquipmentSizeTypeCodeType characteristicCode;
    @XmlElement(name = "UsedCapacityCode")
    protected TransportEquipmentFullnessCodeType usedCapacityCode;
    @XmlElement(name = "LinearSpatialDimension")
    protected SpatialDimensionType linearSpatialDimension;

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
     * Ruft den Wert der loadingLengthMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LinearUnitMeasureType }
     *     
     */
    public LinearUnitMeasureType getLoadingLengthMeasure() {
        return loadingLengthMeasure;
    }

    /**
     * Legt den Wert der loadingLengthMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LinearUnitMeasureType }
     *     
     */
    public void setLoadingLengthMeasure(LinearUnitMeasureType value) {
        this.loadingLengthMeasure = value;
    }

    /**
     * Ruft den Wert der categoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEquipmentCategoryCodeType }
     *     
     */
    public TransportEquipmentCategoryCodeType getCategoryCode() {
        return categoryCode;
    }

    /**
     * Legt den Wert der categoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEquipmentCategoryCodeType }
     *     
     */
    public void setCategoryCode(TransportEquipmentCategoryCodeType value) {
        this.categoryCode = value;
    }

    /**
     * Ruft den Wert der characteristicCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEquipmentSizeTypeCodeType }
     *     
     */
    public TransportEquipmentSizeTypeCodeType getCharacteristicCode() {
        return characteristicCode;
    }

    /**
     * Legt den Wert der characteristicCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEquipmentSizeTypeCodeType }
     *     
     */
    public void setCharacteristicCode(TransportEquipmentSizeTypeCodeType value) {
        this.characteristicCode = value;
    }

    /**
     * Ruft den Wert der usedCapacityCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEquipmentFullnessCodeType }
     *     
     */
    public TransportEquipmentFullnessCodeType getUsedCapacityCode() {
        return usedCapacityCode;
    }

    /**
     * Legt den Wert der usedCapacityCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEquipmentFullnessCodeType }
     *     
     */
    public void setUsedCapacityCode(TransportEquipmentFullnessCodeType value) {
        this.usedCapacityCode = value;
    }

    /**
     * Ruft den Wert der linearSpatialDimension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpatialDimensionType }
     *     
     */
    public SpatialDimensionType getLinearSpatialDimension() {
        return linearSpatialDimension;
    }

    /**
     * Legt den Wert der linearSpatialDimension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialDimensionType }
     *     
     */
    public void setLinearSpatialDimension(SpatialDimensionType value) {
        this.linearSpatialDimension = value;
    }

}
