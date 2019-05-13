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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeableQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeableWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomsImportClassifiedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomsStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomsTariffQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredCustomsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredForCarriageValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredStatisticsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreeOnBoardValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousRiskIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InsuranceValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetNetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreferenceCriterionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredCustomsIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReturnableQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceNumberIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TraceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueAmountType;


/**
 * <p>Java-Klasse für GoodsItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GoodsItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceNumberID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousRiskIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredCustomsValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredForCarriageValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredStatisticsValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FreeOnBoardValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InsuranceValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetNetWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChargeableWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossVolumeMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetVolumeMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreferenceCriterionCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequiredCustomsID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomsStatusCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomsTariffQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomsImportClassifiedIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChargeableQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReturnableQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TraceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Item" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}GoodsItemContainer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}InvoiceLine" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Temperature" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContainedGoodsItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginAddress" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Delivery" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Pickup" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Despatch" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementDimension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContainingPackage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShipmentDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MinimumTemperature" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MaximumTemperature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GoodsItemType", propOrder = {
    "id",
    "sequenceNumberID",
    "description",
    "hazardousRiskIndicator",
    "declaredCustomsValueAmount",
    "declaredForCarriageValueAmount",
    "declaredStatisticsValueAmount",
    "freeOnBoardValueAmount",
    "insuranceValueAmount",
    "valueAmount",
    "grossWeightMeasure",
    "netWeightMeasure",
    "netNetWeightMeasure",
    "chargeableWeightMeasure",
    "grossVolumeMeasure",
    "netVolumeMeasure",
    "quantity",
    "preferenceCriterionCode",
    "requiredCustomsID",
    "customsStatusCode",
    "customsTariffQuantity",
    "customsImportClassifiedIndicator",
    "chargeableQuantity",
    "returnableQuantity",
    "traceID",
    "item",
    "goodsItemContainer",
    "freightAllowanceCharge",
    "invoiceLine",
    "temperature",
    "containedGoodsItem",
    "originAddress",
    "delivery",
    "pickup",
    "despatch",
    "measurementDimension",
    "containingPackage",
    "shipmentDocumentReference",
    "minimumTemperature",
    "maximumTemperature"
})
public class GoodsItemType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "SequenceNumberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SequenceNumberIDType sequenceNumberID;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "HazardousRiskIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousRiskIndicatorType hazardousRiskIndicator;
    @XmlElement(name = "DeclaredCustomsValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredCustomsValueAmountType declaredCustomsValueAmount;
    @XmlElement(name = "DeclaredForCarriageValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredForCarriageValueAmountType declaredForCarriageValueAmount;
    @XmlElement(name = "DeclaredStatisticsValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredStatisticsValueAmountType declaredStatisticsValueAmount;
    @XmlElement(name = "FreeOnBoardValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FreeOnBoardValueAmountType freeOnBoardValueAmount;
    @XmlElement(name = "InsuranceValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InsuranceValueAmountType insuranceValueAmount;
    @XmlElement(name = "ValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValueAmountType valueAmount;
    @XmlElement(name = "GrossWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossWeightMeasureType grossWeightMeasure;
    @XmlElement(name = "NetWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetWeightMeasureType netWeightMeasure;
    @XmlElement(name = "NetNetWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetNetWeightMeasureType netNetWeightMeasure;
    @XmlElement(name = "ChargeableWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ChargeableWeightMeasureType chargeableWeightMeasure;
    @XmlElement(name = "GrossVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossVolumeMeasureType grossVolumeMeasure;
    @XmlElement(name = "NetVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetVolumeMeasureType netVolumeMeasure;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "PreferenceCriterionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreferenceCriterionCodeType preferenceCriterionCode;
    @XmlElement(name = "RequiredCustomsID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequiredCustomsIDType requiredCustomsID;
    @XmlElement(name = "CustomsStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CustomsStatusCodeType customsStatusCode;
    @XmlElement(name = "CustomsTariffQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CustomsTariffQuantityType customsTariffQuantity;
    @XmlElement(name = "CustomsImportClassifiedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CustomsImportClassifiedIndicatorType customsImportClassifiedIndicator;
    @XmlElement(name = "ChargeableQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ChargeableQuantityType chargeableQuantity;
    @XmlElement(name = "ReturnableQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReturnableQuantityType returnableQuantity;
    @XmlElement(name = "TraceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TraceIDType traceID;
    @XmlElement(name = "Item")
    protected List<ItemType> item;
    @XmlElement(name = "GoodsItemContainer")
    protected List<GoodsItemContainerType> goodsItemContainer;
    @XmlElement(name = "FreightAllowanceCharge")
    protected List<AllowanceChargeType> freightAllowanceCharge;
    @XmlElement(name = "InvoiceLine")
    protected List<InvoiceLineType> invoiceLine;
    @XmlElement(name = "Temperature")
    protected List<TemperatureType> temperature;
    @XmlElement(name = "ContainedGoodsItem")
    protected List<GoodsItemType> containedGoodsItem;
    @XmlElement(name = "OriginAddress")
    protected AddressType originAddress;
    @XmlElement(name = "Delivery")
    protected DeliveryType delivery;
    @XmlElement(name = "Pickup")
    protected PickupType pickup;
    @XmlElement(name = "Despatch")
    protected DespatchType despatch;
    @XmlElement(name = "MeasurementDimension")
    protected List<DimensionType> measurementDimension;
    @XmlElement(name = "ContainingPackage")
    protected List<PackageType> containingPackage;
    @XmlElement(name = "ShipmentDocumentReference")
    protected DocumentReferenceType shipmentDocumentReference;
    @XmlElement(name = "MinimumTemperature")
    protected TemperatureType minimumTemperature;
    @XmlElement(name = "MaximumTemperature")
    protected TemperatureType maximumTemperature;

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
     * Ruft den Wert der sequenceNumberID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SequenceNumberIDType }
     *     
     */
    public SequenceNumberIDType getSequenceNumberID() {
        return sequenceNumberID;
    }

    /**
     * Legt den Wert der sequenceNumberID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceNumberIDType }
     *     
     */
    public void setSequenceNumberID(SequenceNumberIDType value) {
        this.sequenceNumberID = value;
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
     * Ruft den Wert der hazardousRiskIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public HazardousRiskIndicatorType getHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    /**
     * Legt den Wert der hazardousRiskIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public void setHazardousRiskIndicator(HazardousRiskIndicatorType value) {
        this.hazardousRiskIndicator = value;
    }

    /**
     * Ruft den Wert der declaredCustomsValueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeclaredCustomsValueAmountType }
     *     
     */
    public DeclaredCustomsValueAmountType getDeclaredCustomsValueAmount() {
        return declaredCustomsValueAmount;
    }

    /**
     * Legt den Wert der declaredCustomsValueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaredCustomsValueAmountType }
     *     
     */
    public void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountType value) {
        this.declaredCustomsValueAmount = value;
    }

    /**
     * Ruft den Wert der declaredForCarriageValueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeclaredForCarriageValueAmountType }
     *     
     */
    public DeclaredForCarriageValueAmountType getDeclaredForCarriageValueAmount() {
        return declaredForCarriageValueAmount;
    }

    /**
     * Legt den Wert der declaredForCarriageValueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaredForCarriageValueAmountType }
     *     
     */
    public void setDeclaredForCarriageValueAmount(DeclaredForCarriageValueAmountType value) {
        this.declaredForCarriageValueAmount = value;
    }

    /**
     * Ruft den Wert der declaredStatisticsValueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeclaredStatisticsValueAmountType }
     *     
     */
    public DeclaredStatisticsValueAmountType getDeclaredStatisticsValueAmount() {
        return declaredStatisticsValueAmount;
    }

    /**
     * Legt den Wert der declaredStatisticsValueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaredStatisticsValueAmountType }
     *     
     */
    public void setDeclaredStatisticsValueAmount(DeclaredStatisticsValueAmountType value) {
        this.declaredStatisticsValueAmount = value;
    }

    /**
     * Ruft den Wert der freeOnBoardValueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FreeOnBoardValueAmountType }
     *     
     */
    public FreeOnBoardValueAmountType getFreeOnBoardValueAmount() {
        return freeOnBoardValueAmount;
    }

    /**
     * Legt den Wert der freeOnBoardValueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FreeOnBoardValueAmountType }
     *     
     */
    public void setFreeOnBoardValueAmount(FreeOnBoardValueAmountType value) {
        this.freeOnBoardValueAmount = value;
    }

    /**
     * Ruft den Wert der insuranceValueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InsuranceValueAmountType }
     *     
     */
    public InsuranceValueAmountType getInsuranceValueAmount() {
        return insuranceValueAmount;
    }

    /**
     * Legt den Wert der insuranceValueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuranceValueAmountType }
     *     
     */
    public void setInsuranceValueAmount(InsuranceValueAmountType value) {
        this.insuranceValueAmount = value;
    }

    /**
     * Ruft den Wert der valueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValueAmountType }
     *     
     */
    public ValueAmountType getValueAmount() {
        return valueAmount;
    }

    /**
     * Legt den Wert der valueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueAmountType }
     *     
     */
    public void setValueAmount(ValueAmountType value) {
        this.valueAmount = value;
    }

    /**
     * Ruft den Wert der grossWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GrossWeightMeasureType }
     *     
     */
    public GrossWeightMeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    /**
     * Legt den Wert der grossWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GrossWeightMeasureType }
     *     
     */
    public void setGrossWeightMeasure(GrossWeightMeasureType value) {
        this.grossWeightMeasure = value;
    }

    /**
     * Ruft den Wert der netWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public NetWeightMeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    /**
     * Legt den Wert der netWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public void setNetWeightMeasure(NetWeightMeasureType value) {
        this.netWeightMeasure = value;
    }

    /**
     * Ruft den Wert der netNetWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetNetWeightMeasureType }
     *     
     */
    public NetNetWeightMeasureType getNetNetWeightMeasure() {
        return netNetWeightMeasure;
    }

    /**
     * Legt den Wert der netNetWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetNetWeightMeasureType }
     *     
     */
    public void setNetNetWeightMeasure(NetNetWeightMeasureType value) {
        this.netNetWeightMeasure = value;
    }

    /**
     * Ruft den Wert der chargeableWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeableWeightMeasureType }
     *     
     */
    public ChargeableWeightMeasureType getChargeableWeightMeasure() {
        return chargeableWeightMeasure;
    }

    /**
     * Legt den Wert der chargeableWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeableWeightMeasureType }
     *     
     */
    public void setChargeableWeightMeasure(ChargeableWeightMeasureType value) {
        this.chargeableWeightMeasure = value;
    }

    /**
     * Ruft den Wert der grossVolumeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GrossVolumeMeasureType }
     *     
     */
    public GrossVolumeMeasureType getGrossVolumeMeasure() {
        return grossVolumeMeasure;
    }

    /**
     * Legt den Wert der grossVolumeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GrossVolumeMeasureType }
     *     
     */
    public void setGrossVolumeMeasure(GrossVolumeMeasureType value) {
        this.grossVolumeMeasure = value;
    }

    /**
     * Ruft den Wert der netVolumeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public NetVolumeMeasureType getNetVolumeMeasure() {
        return netVolumeMeasure;
    }

    /**
     * Legt den Wert der netVolumeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public void setNetVolumeMeasure(NetVolumeMeasureType value) {
        this.netVolumeMeasure = value;
    }

    /**
     * Ruft den Wert der quantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Legt den Wert der quantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * Ruft den Wert der preferenceCriterionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PreferenceCriterionCodeType }
     *     
     */
    public PreferenceCriterionCodeType getPreferenceCriterionCode() {
        return preferenceCriterionCode;
    }

    /**
     * Legt den Wert der preferenceCriterionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferenceCriterionCodeType }
     *     
     */
    public void setPreferenceCriterionCode(PreferenceCriterionCodeType value) {
        this.preferenceCriterionCode = value;
    }

    /**
     * Ruft den Wert der requiredCustomsID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequiredCustomsIDType }
     *     
     */
    public RequiredCustomsIDType getRequiredCustomsID() {
        return requiredCustomsID;
    }

    /**
     * Legt den Wert der requiredCustomsID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredCustomsIDType }
     *     
     */
    public void setRequiredCustomsID(RequiredCustomsIDType value) {
        this.requiredCustomsID = value;
    }

    /**
     * Ruft den Wert der customsStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CustomsStatusCodeType }
     *     
     */
    public CustomsStatusCodeType getCustomsStatusCode() {
        return customsStatusCode;
    }

    /**
     * Legt den Wert der customsStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomsStatusCodeType }
     *     
     */
    public void setCustomsStatusCode(CustomsStatusCodeType value) {
        this.customsStatusCode = value;
    }

    /**
     * Ruft den Wert der customsTariffQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CustomsTariffQuantityType }
     *     
     */
    public CustomsTariffQuantityType getCustomsTariffQuantity() {
        return customsTariffQuantity;
    }

    /**
     * Legt den Wert der customsTariffQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomsTariffQuantityType }
     *     
     */
    public void setCustomsTariffQuantity(CustomsTariffQuantityType value) {
        this.customsTariffQuantity = value;
    }

    /**
     * Ruft den Wert der customsImportClassifiedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CustomsImportClassifiedIndicatorType }
     *     
     */
    public CustomsImportClassifiedIndicatorType getCustomsImportClassifiedIndicator() {
        return customsImportClassifiedIndicator;
    }

    /**
     * Legt den Wert der customsImportClassifiedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomsImportClassifiedIndicatorType }
     *     
     */
    public void setCustomsImportClassifiedIndicator(CustomsImportClassifiedIndicatorType value) {
        this.customsImportClassifiedIndicator = value;
    }

    /**
     * Ruft den Wert der chargeableQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeableQuantityType }
     *     
     */
    public ChargeableQuantityType getChargeableQuantity() {
        return chargeableQuantity;
    }

    /**
     * Legt den Wert der chargeableQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeableQuantityType }
     *     
     */
    public void setChargeableQuantity(ChargeableQuantityType value) {
        this.chargeableQuantity = value;
    }

    /**
     * Ruft den Wert der returnableQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReturnableQuantityType }
     *     
     */
    public ReturnableQuantityType getReturnableQuantity() {
        return returnableQuantity;
    }

    /**
     * Legt den Wert der returnableQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnableQuantityType }
     *     
     */
    public void setReturnableQuantity(ReturnableQuantityType value) {
        this.returnableQuantity = value;
    }

    /**
     * Ruft den Wert der traceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TraceIDType }
     *     
     */
    public TraceIDType getTraceID() {
        return traceID;
    }

    /**
     * Legt den Wert der traceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TraceIDType }
     *     
     */
    public void setTraceID(TraceIDType value) {
        this.traceID = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * 
     * 
     */
    public List<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    /**
     * Gets the value of the goodsItemContainer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the goodsItemContainer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGoodsItemContainer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GoodsItemContainerType }
     * 
     * 
     */
    public List<GoodsItemContainerType> getGoodsItemContainer() {
        if (goodsItemContainer == null) {
            goodsItemContainer = new ArrayList<GoodsItemContainerType>();
        }
        return this.goodsItemContainer;
    }

    /**
     * Gets the value of the freightAllowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the freightAllowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFreightAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getFreightAllowanceCharge() {
        if (freightAllowanceCharge == null) {
            freightAllowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.freightAllowanceCharge;
    }

    /**
     * Gets the value of the invoiceLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLineType }
     * 
     * 
     */
    public List<InvoiceLineType> getInvoiceLine() {
        if (invoiceLine == null) {
            invoiceLine = new ArrayList<InvoiceLineType>();
        }
        return this.invoiceLine;
    }

    /**
     * Gets the value of the temperature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temperature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemperature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TemperatureType }
     * 
     * 
     */
    public List<TemperatureType> getTemperature() {
        if (temperature == null) {
            temperature = new ArrayList<TemperatureType>();
        }
        return this.temperature;
    }

    /**
     * Gets the value of the containedGoodsItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containedGoodsItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainedGoodsItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GoodsItemType }
     * 
     * 
     */
    public List<GoodsItemType> getContainedGoodsItem() {
        if (containedGoodsItem == null) {
            containedGoodsItem = new ArrayList<GoodsItemType>();
        }
        return this.containedGoodsItem;
    }

    /**
     * Ruft den Wert der originAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getOriginAddress() {
        return originAddress;
    }

    /**
     * Legt den Wert der originAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setOriginAddress(AddressType value) {
        this.originAddress = value;
    }

    /**
     * Ruft den Wert der delivery-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryType }
     *     
     */
    public DeliveryType getDelivery() {
        return delivery;
    }

    /**
     * Legt den Wert der delivery-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryType }
     *     
     */
    public void setDelivery(DeliveryType value) {
        this.delivery = value;
    }

    /**
     * Ruft den Wert der pickup-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PickupType }
     *     
     */
    public PickupType getPickup() {
        return pickup;
    }

    /**
     * Legt den Wert der pickup-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupType }
     *     
     */
    public void setPickup(PickupType value) {
        this.pickup = value;
    }

    /**
     * Ruft den Wert der despatch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DespatchType }
     *     
     */
    public DespatchType getDespatch() {
        return despatch;
    }

    /**
     * Legt den Wert der despatch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DespatchType }
     *     
     */
    public void setDespatch(DespatchType value) {
        this.despatch = value;
    }

    /**
     * Gets the value of the measurementDimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measurementDimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasurementDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionType }
     * 
     * 
     */
    public List<DimensionType> getMeasurementDimension() {
        if (measurementDimension == null) {
            measurementDimension = new ArrayList<DimensionType>();
        }
        return this.measurementDimension;
    }

    /**
     * Gets the value of the containingPackage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containingPackage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainingPackage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackageType }
     * 
     * 
     */
    public List<PackageType> getContainingPackage() {
        if (containingPackage == null) {
            containingPackage = new ArrayList<PackageType>();
        }
        return this.containingPackage;
    }

    /**
     * Ruft den Wert der shipmentDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getShipmentDocumentReference() {
        return shipmentDocumentReference;
    }

    /**
     * Legt den Wert der shipmentDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setShipmentDocumentReference(DocumentReferenceType value) {
        this.shipmentDocumentReference = value;
    }

    /**
     * Ruft den Wert der minimumTemperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getMinimumTemperature() {
        return minimumTemperature;
    }

    /**
     * Legt den Wert der minimumTemperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setMinimumTemperature(TemperatureType value) {
        this.minimumTemperature = value;
    }

    /**
     * Ruft den Wert der maximumTemperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getMaximumTemperature() {
        return maximumTemperature;
    }

    /**
     * Legt den Wert der maximumTemperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setMaximumTemperature(TemperatureType value) {
        this.maximumTemperature = value;
    }

}
