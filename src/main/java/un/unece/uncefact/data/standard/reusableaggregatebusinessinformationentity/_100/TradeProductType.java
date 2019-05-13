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
import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeProductType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="GlobalID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="SellerAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="BuyerAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="ManufacturerAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TradeName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="NetWeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="GrossWeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="ProductGroupID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EndItemTypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EndItemName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AreaDensityMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="UseDescription" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BrandName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="SubBrandName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="DrainedNetWeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="VariableMeasureIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/>
 *         &lt;element name="ColourCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ColourDescription" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Designation" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FormattedCancellationAnnouncedLaunchDateTime" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}FormattedDateTimeType" minOccurs="0"/>
 *         &lt;element name="FormattedLatestProductDataChangeDateTime" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}FormattedDateTimeType" minOccurs="0"/>
 *         &lt;element name="ApplicableProductCharacteristic" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ProductCharacteristicType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ApplicableMaterialGoodsCharacteristic" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}MaterialGoodsCharacteristicType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DesignatedProductClassification" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ProductClassificationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IndividualTradeProductInstance" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeProductInstanceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CertificationEvidenceReferenceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InspectionReferenceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OriginTradeCountry" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeCountryType" minOccurs="0"/>
 *         &lt;element name="LinearSpatialDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpatialDimensionType" minOccurs="0"/>
 *         &lt;element name="MinimumLinearSpatialDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpatialDimensionType" minOccurs="0"/>
 *         &lt;element name="MaximumLinearSpatialDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpatialDimensionType" minOccurs="0"/>
 *         &lt;element name="ManufacturerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="PresentationSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MSDSReferenceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="AdditionalReferenceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LegalRightsOwnerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="BrandOwnerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="IncludedReferencedProduct" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedProductType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InformationNote" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}NoteType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeProductType", propOrder = {
    "id",
    "globalID",
    "sellerAssignedID",
    "buyerAssignedID",
    "manufacturerAssignedID",
    "name",
    "tradeName",
    "description",
    "typeCode",
    "netWeightMeasure",
    "grossWeightMeasure",
    "productGroupID",
    "endItemTypeCode",
    "endItemName",
    "areaDensityMeasure",
    "useDescription",
    "brandName",
    "subBrandName",
    "drainedNetWeightMeasure",
    "variableMeasureIndicator",
    "colourCode",
    "colourDescription",
    "designation",
    "formattedCancellationAnnouncedLaunchDateTime",
    "formattedLatestProductDataChangeDateTime",
    "applicableProductCharacteristic",
    "applicableMaterialGoodsCharacteristic",
    "designatedProductClassification",
    "individualTradeProductInstance",
    "certificationEvidenceReferenceReferencedDocument",
    "inspectionReferenceReferencedDocument",
    "originTradeCountry",
    "linearSpatialDimension",
    "minimumLinearSpatialDimension",
    "maximumLinearSpatialDimension",
    "manufacturerTradeParty",
    "presentationSpecifiedBinaryFile",
    "msdsReferenceReferencedDocument",
    "additionalReferenceReferencedDocument",
    "legalRightsOwnerTradeParty",
    "brandOwnerTradeParty",
    "includedReferencedProduct",
    "informationNote"
})
public class TradeProductType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "GlobalID")
    protected IDType globalID;
    @XmlElement(name = "SellerAssignedID")
    protected IDType sellerAssignedID;
    @XmlElement(name = "BuyerAssignedID")
    protected IDType buyerAssignedID;
    @XmlElement(name = "ManufacturerAssignedID")
    protected IDType manufacturerAssignedID;
    @XmlElement(name = "Name")
    protected List<TextType> name;
    @XmlElement(name = "TradeName")
    protected TextType tradeName;
    @XmlElement(name = "Description")
    protected TextType description;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "NetWeightMeasure")
    protected MeasureType netWeightMeasure;
    @XmlElement(name = "GrossWeightMeasure")
    protected MeasureType grossWeightMeasure;
    @XmlElement(name = "ProductGroupID")
    protected List<IDType> productGroupID;
    @XmlElement(name = "EndItemTypeCode")
    protected List<CodeType> endItemTypeCode;
    @XmlElement(name = "EndItemName")
    protected List<TextType> endItemName;
    @XmlElement(name = "AreaDensityMeasure")
    protected MeasureType areaDensityMeasure;
    @XmlElement(name = "UseDescription")
    protected List<TextType> useDescription;
    @XmlElement(name = "BrandName")
    protected TextType brandName;
    @XmlElement(name = "SubBrandName")
    protected TextType subBrandName;
    @XmlElement(name = "DrainedNetWeightMeasure")
    protected MeasureType drainedNetWeightMeasure;
    @XmlElement(name = "VariableMeasureIndicator")
    protected IndicatorType variableMeasureIndicator;
    @XmlElement(name = "ColourCode")
    protected CodeType colourCode;
    @XmlElement(name = "ColourDescription")
    protected List<TextType> colourDescription;
    @XmlElement(name = "Designation")
    protected List<TextType> designation;
    @XmlElement(name = "FormattedCancellationAnnouncedLaunchDateTime")
    protected FormattedDateTimeType formattedCancellationAnnouncedLaunchDateTime;
    @XmlElement(name = "FormattedLatestProductDataChangeDateTime")
    protected FormattedDateTimeType formattedLatestProductDataChangeDateTime;
    @XmlElement(name = "ApplicableProductCharacteristic")
    protected List<ProductCharacteristicType> applicableProductCharacteristic;
    @XmlElement(name = "ApplicableMaterialGoodsCharacteristic")
    protected List<MaterialGoodsCharacteristicType> applicableMaterialGoodsCharacteristic;
    @XmlElement(name = "DesignatedProductClassification")
    protected List<ProductClassificationType> designatedProductClassification;
    @XmlElement(name = "IndividualTradeProductInstance")
    protected List<TradeProductInstanceType> individualTradeProductInstance;
    @XmlElement(name = "CertificationEvidenceReferenceReferencedDocument")
    protected List<ReferencedDocumentType> certificationEvidenceReferenceReferencedDocument;
    @XmlElement(name = "InspectionReferenceReferencedDocument")
    protected List<ReferencedDocumentType> inspectionReferenceReferencedDocument;
    @XmlElement(name = "OriginTradeCountry")
    protected TradeCountryType originTradeCountry;
    @XmlElement(name = "LinearSpatialDimension")
    protected SpatialDimensionType linearSpatialDimension;
    @XmlElement(name = "MinimumLinearSpatialDimension")
    protected SpatialDimensionType minimumLinearSpatialDimension;
    @XmlElement(name = "MaximumLinearSpatialDimension")
    protected SpatialDimensionType maximumLinearSpatialDimension;
    @XmlElement(name = "ManufacturerTradeParty")
    protected TradePartyType manufacturerTradeParty;
    @XmlElement(name = "PresentationSpecifiedBinaryFile")
    protected List<SpecifiedBinaryFileType> presentationSpecifiedBinaryFile;
    @XmlElement(name = "MSDSReferenceReferencedDocument")
    protected ReferencedDocumentType msdsReferenceReferencedDocument;
    @XmlElement(name = "AdditionalReferenceReferencedDocument")
    protected List<ReferencedDocumentType> additionalReferenceReferencedDocument;
    @XmlElement(name = "LegalRightsOwnerTradeParty")
    protected TradePartyType legalRightsOwnerTradeParty;
    @XmlElement(name = "BrandOwnerTradeParty")
    protected TradePartyType brandOwnerTradeParty;
    @XmlElement(name = "IncludedReferencedProduct")
    protected List<ReferencedProductType> includedReferencedProduct;
    @XmlElement(name = "InformationNote")
    protected List<NoteType> informationNote;

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
     * Ruft den Wert der globalID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getGlobalID() {
        return globalID;
    }

    /**
     * Legt den Wert der globalID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setGlobalID(IDType value) {
        this.globalID = value;
    }

    /**
     * Ruft den Wert der sellerAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSellerAssignedID() {
        return sellerAssignedID;
    }

    /**
     * Legt den Wert der sellerAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSellerAssignedID(IDType value) {
        this.sellerAssignedID = value;
    }

    /**
     * Ruft den Wert der buyerAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getBuyerAssignedID() {
        return buyerAssignedID;
    }

    /**
     * Legt den Wert der buyerAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setBuyerAssignedID(IDType value) {
        this.buyerAssignedID = value;
    }

    /**
     * Ruft den Wert der manufacturerAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getManufacturerAssignedID() {
        return manufacturerAssignedID;
    }

    /**
     * Legt den Wert der manufacturerAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setManufacturerAssignedID(IDType value) {
        this.manufacturerAssignedID = value;
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
     * Ruft den Wert der tradeName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTradeName() {
        return tradeName;
    }

    /**
     * Legt den Wert der tradeName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTradeName(TextType value) {
        this.tradeName = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDescription(TextType value) {
        this.description = value;
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
     * Ruft den Wert der netWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    /**
     * Legt den Wert der netWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setNetWeightMeasure(MeasureType value) {
        this.netWeightMeasure = value;
    }

    /**
     * Ruft den Wert der grossWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    /**
     * Legt den Wert der grossWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setGrossWeightMeasure(MeasureType value) {
        this.grossWeightMeasure = value;
    }

    /**
     * Gets the value of the productGroupID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productGroupID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductGroupID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getProductGroupID() {
        if (productGroupID == null) {
            productGroupID = new ArrayList<IDType>();
        }
        return this.productGroupID;
    }

    /**
     * Gets the value of the endItemTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endItemTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndItemTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getEndItemTypeCode() {
        if (endItemTypeCode == null) {
            endItemTypeCode = new ArrayList<CodeType>();
        }
        return this.endItemTypeCode;
    }

    /**
     * Gets the value of the endItemName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endItemName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndItemName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getEndItemName() {
        if (endItemName == null) {
            endItemName = new ArrayList<TextType>();
        }
        return this.endItemName;
    }

    /**
     * Ruft den Wert der areaDensityMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getAreaDensityMeasure() {
        return areaDensityMeasure;
    }

    /**
     * Legt den Wert der areaDensityMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setAreaDensityMeasure(MeasureType value) {
        this.areaDensityMeasure = value;
    }

    /**
     * Gets the value of the useDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the useDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUseDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getUseDescription() {
        if (useDescription == null) {
            useDescription = new ArrayList<TextType>();
        }
        return this.useDescription;
    }

    /**
     * Ruft den Wert der brandName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBrandName() {
        return brandName;
    }

    /**
     * Legt den Wert der brandName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBrandName(TextType value) {
        this.brandName = value;
    }

    /**
     * Ruft den Wert der subBrandName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSubBrandName() {
        return subBrandName;
    }

    /**
     * Legt den Wert der subBrandName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSubBrandName(TextType value) {
        this.subBrandName = value;
    }

    /**
     * Ruft den Wert der drainedNetWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getDrainedNetWeightMeasure() {
        return drainedNetWeightMeasure;
    }

    /**
     * Legt den Wert der drainedNetWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setDrainedNetWeightMeasure(MeasureType value) {
        this.drainedNetWeightMeasure = value;
    }

    /**
     * Ruft den Wert der variableMeasureIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getVariableMeasureIndicator() {
        return variableMeasureIndicator;
    }

    /**
     * Legt den Wert der variableMeasureIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setVariableMeasureIndicator(IndicatorType value) {
        this.variableMeasureIndicator = value;
    }

    /**
     * Ruft den Wert der colourCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getColourCode() {
        return colourCode;
    }

    /**
     * Legt den Wert der colourCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setColourCode(CodeType value) {
        this.colourCode = value;
    }

    /**
     * Gets the value of the colourDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colourDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColourDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getColourDescription() {
        if (colourDescription == null) {
            colourDescription = new ArrayList<TextType>();
        }
        return this.colourDescription;
    }

    /**
     * Gets the value of the designation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDesignation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDesignation() {
        if (designation == null) {
            designation = new ArrayList<TextType>();
        }
        return this.designation;
    }

    /**
     * Ruft den Wert der formattedCancellationAnnouncedLaunchDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public FormattedDateTimeType getFormattedCancellationAnnouncedLaunchDateTime() {
        return formattedCancellationAnnouncedLaunchDateTime;
    }

    /**
     * Legt den Wert der formattedCancellationAnnouncedLaunchDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public void setFormattedCancellationAnnouncedLaunchDateTime(FormattedDateTimeType value) {
        this.formattedCancellationAnnouncedLaunchDateTime = value;
    }

    /**
     * Ruft den Wert der formattedLatestProductDataChangeDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public FormattedDateTimeType getFormattedLatestProductDataChangeDateTime() {
        return formattedLatestProductDataChangeDateTime;
    }

    /**
     * Legt den Wert der formattedLatestProductDataChangeDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public void setFormattedLatestProductDataChangeDateTime(FormattedDateTimeType value) {
        this.formattedLatestProductDataChangeDateTime = value;
    }

    /**
     * Gets the value of the applicableProductCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableProductCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableProductCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductCharacteristicType }
     * 
     * 
     */
    public List<ProductCharacteristicType> getApplicableProductCharacteristic() {
        if (applicableProductCharacteristic == null) {
            applicableProductCharacteristic = new ArrayList<ProductCharacteristicType>();
        }
        return this.applicableProductCharacteristic;
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
     * Gets the value of the designatedProductClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designatedProductClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDesignatedProductClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductClassificationType }
     * 
     * 
     */
    public List<ProductClassificationType> getDesignatedProductClassification() {
        if (designatedProductClassification == null) {
            designatedProductClassification = new ArrayList<ProductClassificationType>();
        }
        return this.designatedProductClassification;
    }

    /**
     * Gets the value of the individualTradeProductInstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualTradeProductInstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualTradeProductInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeProductInstanceType }
     * 
     * 
     */
    public List<TradeProductInstanceType> getIndividualTradeProductInstance() {
        if (individualTradeProductInstance == null) {
            individualTradeProductInstance = new ArrayList<TradeProductInstanceType>();
        }
        return this.individualTradeProductInstance;
    }

    /**
     * Gets the value of the certificationEvidenceReferenceReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certificationEvidenceReferenceReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertificationEvidenceReferenceReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getCertificationEvidenceReferenceReferencedDocument() {
        if (certificationEvidenceReferenceReferencedDocument == null) {
            certificationEvidenceReferenceReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.certificationEvidenceReferenceReferencedDocument;
    }

    /**
     * Gets the value of the inspectionReferenceReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inspectionReferenceReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInspectionReferenceReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getInspectionReferenceReferencedDocument() {
        if (inspectionReferenceReferencedDocument == null) {
            inspectionReferenceReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.inspectionReferenceReferencedDocument;
    }

    /**
     * Ruft den Wert der originTradeCountry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeCountryType }
     *     
     */
    public TradeCountryType getOriginTradeCountry() {
        return originTradeCountry;
    }

    /**
     * Legt den Wert der originTradeCountry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeCountryType }
     *     
     */
    public void setOriginTradeCountry(TradeCountryType value) {
        this.originTradeCountry = value;
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
     * Ruft den Wert der manufacturerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getManufacturerTradeParty() {
        return manufacturerTradeParty;
    }

    /**
     * Legt den Wert der manufacturerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setManufacturerTradeParty(TradePartyType value) {
        this.manufacturerTradeParty = value;
    }

    /**
     * Gets the value of the presentationSpecifiedBinaryFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presentationSpecifiedBinaryFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresentationSpecifiedBinaryFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecifiedBinaryFileType }
     * 
     * 
     */
    public List<SpecifiedBinaryFileType> getPresentationSpecifiedBinaryFile() {
        if (presentationSpecifiedBinaryFile == null) {
            presentationSpecifiedBinaryFile = new ArrayList<SpecifiedBinaryFileType>();
        }
        return this.presentationSpecifiedBinaryFile;
    }

    /**
     * Ruft den Wert der msdsReferenceReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getMSDSReferenceReferencedDocument() {
        return msdsReferenceReferencedDocument;
    }

    /**
     * Legt den Wert der msdsReferenceReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setMSDSReferenceReferencedDocument(ReferencedDocumentType value) {
        this.msdsReferenceReferencedDocument = value;
    }

    /**
     * Gets the value of the additionalReferenceReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalReferenceReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalReferenceReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getAdditionalReferenceReferencedDocument() {
        if (additionalReferenceReferencedDocument == null) {
            additionalReferenceReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.additionalReferenceReferencedDocument;
    }

    /**
     * Ruft den Wert der legalRightsOwnerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getLegalRightsOwnerTradeParty() {
        return legalRightsOwnerTradeParty;
    }

    /**
     * Legt den Wert der legalRightsOwnerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setLegalRightsOwnerTradeParty(TradePartyType value) {
        this.legalRightsOwnerTradeParty = value;
    }

    /**
     * Ruft den Wert der brandOwnerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getBrandOwnerTradeParty() {
        return brandOwnerTradeParty;
    }

    /**
     * Legt den Wert der brandOwnerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setBrandOwnerTradeParty(TradePartyType value) {
        this.brandOwnerTradeParty = value;
    }

    /**
     * Gets the value of the includedReferencedProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedReferencedProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedReferencedProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedProductType }
     * 
     * 
     */
    public List<ReferencedProductType> getIncludedReferencedProduct() {
        if (includedReferencedProduct == null) {
            includedReferencedProduct = new ArrayList<ReferencedProductType>();
        }
        return this.includedReferencedProduct;
    }

    /**
     * Gets the value of the informationNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getInformationNote() {
        if (informationNote == null) {
            informationNote = new ArrayList<NoteType>();
        }
        return this.informationNote;
    }

}
