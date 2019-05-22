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
import un.unece.uncefact.data.standard.qualifieddatatype._100.PackageTypeCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für SupplyChainPackagingType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SupplyChainPackagingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PackageTypeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ConditionCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="DisposalMethodCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="WeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="MaximumStackabilityQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="MaximumStackabilityWeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/&gt;
 *         &lt;element name="CustomerFacingTotalUnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="LayerTotalUnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="ContentLayerQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="LinearSpatialDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpatialDimensionType" minOccurs="0"/&gt;
 *         &lt;element name="MinimumLinearSpatialDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpatialDimensionType" minOccurs="0"/&gt;
 *         &lt;element name="MaximumLinearSpatialDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpatialDimensionType" minOccurs="0"/&gt;
 *         &lt;element name="SpecifiedPackagingMarking" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}PackagingMarkingType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableMaterialGoodsCharacteristic" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}MaterialGoodsCharacteristicType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableDisposalInstructions" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DisposalInstructionsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableReturnableAssetInstructions" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReturnableAssetInstructionsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainPackagingType", propOrder = {
    "typeCode",
    "type",
    "description",
    "conditionCode",
    "disposalMethodCode",
    "weightMeasure",
    "maximumStackabilityQuantity",
    "maximumStackabilityWeightMeasure",
    "customerFacingTotalUnitQuantity",
    "layerTotalUnitQuantity",
    "contentLayerQuantity",
    "linearSpatialDimension",
    "minimumLinearSpatialDimension",
    "maximumLinearSpatialDimension",
    "specifiedPackagingMarking",
    "applicableMaterialGoodsCharacteristic",
    "applicableDisposalInstructions",
    "applicableReturnableAssetInstructions"
})
public class SupplyChainPackagingType {

    @XmlElement(name = "TypeCode")
    protected PackageTypeCodeType typeCode;
    @XmlElement(name = "Type")
    protected TextType type;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "ConditionCode")
    protected CodeType conditionCode;
    @XmlElement(name = "DisposalMethodCode")
    protected List<CodeType> disposalMethodCode;
    @XmlElement(name = "WeightMeasure")
    protected List<MeasureType> weightMeasure;
    @XmlElement(name = "MaximumStackabilityQuantity")
    protected QuantityType maximumStackabilityQuantity;
    @XmlElement(name = "MaximumStackabilityWeightMeasure")
    protected MeasureType maximumStackabilityWeightMeasure;
    @XmlElement(name = "CustomerFacingTotalUnitQuantity")
    protected QuantityType customerFacingTotalUnitQuantity;
    @XmlElement(name = "LayerTotalUnitQuantity")
    protected QuantityType layerTotalUnitQuantity;
    @XmlElement(name = "ContentLayerQuantity")
    protected QuantityType contentLayerQuantity;
    @XmlElement(name = "LinearSpatialDimension")
    protected SpatialDimensionType linearSpatialDimension;
    @XmlElement(name = "MinimumLinearSpatialDimension")
    protected SpatialDimensionType minimumLinearSpatialDimension;
    @XmlElement(name = "MaximumLinearSpatialDimension")
    protected SpatialDimensionType maximumLinearSpatialDimension;
    @XmlElement(name = "SpecifiedPackagingMarking")
    protected List<PackagingMarkingType> specifiedPackagingMarking;
    @XmlElement(name = "ApplicableMaterialGoodsCharacteristic")
    protected List<MaterialGoodsCharacteristicType> applicableMaterialGoodsCharacteristic;
    @XmlElement(name = "ApplicableDisposalInstructions")
    protected List<DisposalInstructionsType> applicableDisposalInstructions;
    @XmlElement(name = "ApplicableReturnableAssetInstructions")
    protected List<ReturnableAssetInstructionsType> applicableReturnableAssetInstructions;

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PackageTypeCodeType }
     *     
     */
    public PackageTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageTypeCodeType }
     *     
     */
    public void setTypeCode(PackageTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setType(TextType value) {
        this.type = value;
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
     * Ruft den Wert der conditionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getConditionCode() {
        return conditionCode;
    }

    /**
     * Legt den Wert der conditionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setConditionCode(CodeType value) {
        this.conditionCode = value;
    }

    /**
     * Gets the value of the disposalMethodCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disposalMethodCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisposalMethodCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getDisposalMethodCode() {
        if (disposalMethodCode == null) {
            disposalMethodCode = new ArrayList<CodeType>();
        }
        return this.disposalMethodCode;
    }

    /**
     * Gets the value of the weightMeasure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weightMeasure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeightMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureType }
     * 
     * 
     */
    public List<MeasureType> getWeightMeasure() {
        if (weightMeasure == null) {
            weightMeasure = new ArrayList<MeasureType>();
        }
        return this.weightMeasure;
    }

    /**
     * Ruft den Wert der maximumStackabilityQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getMaximumStackabilityQuantity() {
        return maximumStackabilityQuantity;
    }

    /**
     * Legt den Wert der maximumStackabilityQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setMaximumStackabilityQuantity(QuantityType value) {
        this.maximumStackabilityQuantity = value;
    }

    /**
     * Ruft den Wert der maximumStackabilityWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMaximumStackabilityWeightMeasure() {
        return maximumStackabilityWeightMeasure;
    }

    /**
     * Legt den Wert der maximumStackabilityWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMaximumStackabilityWeightMeasure(MeasureType value) {
        this.maximumStackabilityWeightMeasure = value;
    }

    /**
     * Ruft den Wert der customerFacingTotalUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getCustomerFacingTotalUnitQuantity() {
        return customerFacingTotalUnitQuantity;
    }

    /**
     * Legt den Wert der customerFacingTotalUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setCustomerFacingTotalUnitQuantity(QuantityType value) {
        this.customerFacingTotalUnitQuantity = value;
    }

    /**
     * Ruft den Wert der layerTotalUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getLayerTotalUnitQuantity() {
        return layerTotalUnitQuantity;
    }

    /**
     * Legt den Wert der layerTotalUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setLayerTotalUnitQuantity(QuantityType value) {
        this.layerTotalUnitQuantity = value;
    }

    /**
     * Ruft den Wert der contentLayerQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getContentLayerQuantity() {
        return contentLayerQuantity;
    }

    /**
     * Legt den Wert der contentLayerQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setContentLayerQuantity(QuantityType value) {
        this.contentLayerQuantity = value;
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

    /**
     * Ruft den Wert der minimumLinearSpatialDimension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpatialDimensionType }
     *     
     */
    public SpatialDimensionType getMinimumLinearSpatialDimension() {
        return minimumLinearSpatialDimension;
    }

    /**
     * Legt den Wert der minimumLinearSpatialDimension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialDimensionType }
     *     
     */
    public void setMinimumLinearSpatialDimension(SpatialDimensionType value) {
        this.minimumLinearSpatialDimension = value;
    }

    /**
     * Ruft den Wert der maximumLinearSpatialDimension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpatialDimensionType }
     *     
     */
    public SpatialDimensionType getMaximumLinearSpatialDimension() {
        return maximumLinearSpatialDimension;
    }

    /**
     * Legt den Wert der maximumLinearSpatialDimension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialDimensionType }
     *     
     */
    public void setMaximumLinearSpatialDimension(SpatialDimensionType value) {
        this.maximumLinearSpatialDimension = value;
    }

    /**
     * Gets the value of the specifiedPackagingMarking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedPackagingMarking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedPackagingMarking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackagingMarkingType }
     * 
     * 
     */
    public List<PackagingMarkingType> getSpecifiedPackagingMarking() {
        if (specifiedPackagingMarking == null) {
            specifiedPackagingMarking = new ArrayList<PackagingMarkingType>();
        }
        return this.specifiedPackagingMarking;
    }

    /**
     * Gets the value of the applicableMaterialGoodsCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableMaterialGoodsCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableMaterialGoodsCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaterialGoodsCharacteristicType }
     * 
     * 
     */
    public List<MaterialGoodsCharacteristicType> getApplicableMaterialGoodsCharacteristic() {
        if (applicableMaterialGoodsCharacteristic == null) {
            applicableMaterialGoodsCharacteristic = new ArrayList<MaterialGoodsCharacteristicType>();
        }
        return this.applicableMaterialGoodsCharacteristic;
    }

    /**
     * Gets the value of the applicableDisposalInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableDisposalInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableDisposalInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisposalInstructionsType }
     * 
     * 
     */
    public List<DisposalInstructionsType> getApplicableDisposalInstructions() {
        if (applicableDisposalInstructions == null) {
            applicableDisposalInstructions = new ArrayList<DisposalInstructionsType>();
        }
        return this.applicableDisposalInstructions;
    }

    /**
     * Gets the value of the applicableReturnableAssetInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableReturnableAssetInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableReturnableAssetInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReturnableAssetInstructionsType }
     * 
     * 
     */
    public List<ReturnableAssetInstructionsType> getApplicableReturnableAssetInstructions() {
        if (applicableReturnableAssetInstructions == null) {
            applicableReturnableAssetInstructions = new ArrayList<ReturnableAssetInstructionsType>();
        }
        return this.applicableReturnableAssetInstructions;
    }

}
