//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AirFlowPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnimalFoodApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CharacteristicsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DamageRemarksType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DangerousGoodsApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DispositionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FullnessIndicationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumanFoodApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumidityPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LegalStatusIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OwnerTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PowerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProviderTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferencedConsignmentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RefrigeratedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RefrigerationOnIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReturnabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SizeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialTransportRequirementsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TareWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TraceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TrackingDeviceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportEquipmentTypeCodeType;


/**
 * <p>Java-Klasse für TransportEquipmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportEquipmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferencedConsignmentID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportEquipmentTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProviderTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OwnerTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SizeTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DispositionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FullnessIndicationCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RefrigerationOnIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Information" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReturnabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LegalStatusIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AirFlowPercent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HumidityPercent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AnimalFoodApprovedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HumanFoodApprovedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DangerousGoodsApprovedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RefrigeratedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Characteristics" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DamageRemarks" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialTransportRequirements" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossWeightMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossVolumeMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TareWeightMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TrackingDeviceCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PowerIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TraceID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementDimension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEquipmentSeal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MinimumTemperature" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MaximumTemperature" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProviderParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingProofParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupplierParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OwnerParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OperatingParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UnloadingLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}StorageLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PositioningTransportEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}QuarantineTransportEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryTransportEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PickupTransportEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HandlingTransportEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingTransportEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ApplicableTransportMeans" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HaulageTradingTerms" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HazardousGoodsTransit" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PackagedTransportHandlingUnit" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ServiceAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AttachedTransportEquipment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Delivery" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Pickup" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Despatch" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShipmentDocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContainedInTransportEquipment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Package" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}GoodsItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportEquipmentType", propOrder = {
    "id",
    "referencedConsignmentID",
    "transportEquipmentTypeCode",
    "providerTypeCode",
    "ownerTypeCode",
    "sizeTypeCode",
    "dispositionCode",
    "fullnessIndicationCode",
    "refrigerationOnIndicator",
    "information",
    "returnabilityIndicator",
    "legalStatusIndicator",
    "airFlowPercent",
    "humidityPercent",
    "animalFoodApprovedIndicator",
    "humanFoodApprovedIndicator",
    "dangerousGoodsApprovedIndicator",
    "refrigeratedIndicator",
    "characteristics",
    "damageRemarks",
    "description",
    "specialTransportRequirements",
    "grossWeightMeasure",
    "grossVolumeMeasure",
    "tareWeightMeasure",
    "trackingDeviceCode",
    "powerIndicator",
    "traceID",
    "measurementDimension",
    "transportEquipmentSeal",
    "minimumTemperature",
    "maximumTemperature",
    "providerParty",
    "loadingProofParty",
    "supplierParty",
    "ownerParty",
    "operatingParty",
    "loadingLocation",
    "unloadingLocation",
    "storageLocation",
    "positioningTransportEvent",
    "quarantineTransportEvent",
    "deliveryTransportEvent",
    "pickupTransportEvent",
    "handlingTransportEvent",
    "loadingTransportEvent",
    "transportEvent",
    "applicableTransportMeans",
    "haulageTradingTerms",
    "hazardousGoodsTransit",
    "packagedTransportHandlingUnit",
    "serviceAllowanceCharge",
    "freightAllowanceCharge",
    "attachedTransportEquipment",
    "delivery",
    "pickup",
    "despatch",
    "shipmentDocumentReference",
    "containedInTransportEquipment",
    "_package",
    "goodsItem"
})
public class TransportEquipmentType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "ReferencedConsignmentID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ReferencedConsignmentIDType> referencedConsignmentID;
    @XmlElement(name = "TransportEquipmentTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportEquipmentTypeCodeType transportEquipmentTypeCode;
    @XmlElement(name = "ProviderTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProviderTypeCodeType providerTypeCode;
    @XmlElement(name = "OwnerTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OwnerTypeCodeType ownerTypeCode;
    @XmlElement(name = "SizeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SizeTypeCodeType sizeTypeCode;
    @XmlElement(name = "DispositionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DispositionCodeType dispositionCode;
    @XmlElement(name = "FullnessIndicationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FullnessIndicationCodeType fullnessIndicationCode;
    @XmlElement(name = "RefrigerationOnIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RefrigerationOnIndicatorType refrigerationOnIndicator;
    @XmlElement(name = "Information", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<InformationType> information;
    @XmlElement(name = "ReturnabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReturnabilityIndicatorType returnabilityIndicator;
    @XmlElement(name = "LegalStatusIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LegalStatusIndicatorType legalStatusIndicator;
    @XmlElement(name = "AirFlowPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AirFlowPercentType airFlowPercent;
    @XmlElement(name = "HumidityPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HumidityPercentType humidityPercent;
    @XmlElement(name = "AnimalFoodApprovedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AnimalFoodApprovedIndicatorType animalFoodApprovedIndicator;
    @XmlElement(name = "HumanFoodApprovedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HumanFoodApprovedIndicatorType humanFoodApprovedIndicator;
    @XmlElement(name = "DangerousGoodsApprovedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DangerousGoodsApprovedIndicatorType dangerousGoodsApprovedIndicator;
    @XmlElement(name = "RefrigeratedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RefrigeratedIndicatorType refrigeratedIndicator;
    @XmlElement(name = "Characteristics", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CharacteristicsType characteristics;
    @XmlElement(name = "DamageRemarks", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DamageRemarksType> damageRemarks;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "SpecialTransportRequirements", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<SpecialTransportRequirementsType> specialTransportRequirements;
    @XmlElement(name = "GrossWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossWeightMeasureType grossWeightMeasure;
    @XmlElement(name = "GrossVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossVolumeMeasureType grossVolumeMeasure;
    @XmlElement(name = "TareWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TareWeightMeasureType tareWeightMeasure;
    @XmlElement(name = "TrackingDeviceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TrackingDeviceCodeType trackingDeviceCode;
    @XmlElement(name = "PowerIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PowerIndicatorType powerIndicator;
    @XmlElement(name = "TraceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TraceIDType traceID;
    @XmlElement(name = "MeasurementDimension")
    protected List<DimensionType> measurementDimension;
    @XmlElement(name = "TransportEquipmentSeal")
    protected List<TransportEquipmentSealType> transportEquipmentSeal;
    @XmlElement(name = "MinimumTemperature")
    protected TemperatureType minimumTemperature;
    @XmlElement(name = "MaximumTemperature")
    protected TemperatureType maximumTemperature;
    @XmlElement(name = "ProviderParty")
    protected PartyType providerParty;
    @XmlElement(name = "LoadingProofParty")
    protected PartyType loadingProofParty;
    @XmlElement(name = "SupplierParty")
    protected SupplierPartyType supplierParty;
    @XmlElement(name = "OwnerParty")
    protected PartyType ownerParty;
    @XmlElement(name = "OperatingParty")
    protected PartyType operatingParty;
    @XmlElement(name = "LoadingLocation")
    protected LocationType loadingLocation;
    @XmlElement(name = "UnloadingLocation")
    protected LocationType unloadingLocation;
    @XmlElement(name = "StorageLocation")
    protected LocationType storageLocation;
    @XmlElement(name = "PositioningTransportEvent")
    protected List<TransportEventType> positioningTransportEvent;
    @XmlElement(name = "QuarantineTransportEvent")
    protected List<TransportEventType> quarantineTransportEvent;
    @XmlElement(name = "DeliveryTransportEvent")
    protected List<TransportEventType> deliveryTransportEvent;
    @XmlElement(name = "PickupTransportEvent")
    protected List<TransportEventType> pickupTransportEvent;
    @XmlElement(name = "HandlingTransportEvent")
    protected List<TransportEventType> handlingTransportEvent;
    @XmlElement(name = "LoadingTransportEvent")
    protected List<TransportEventType> loadingTransportEvent;
    @XmlElement(name = "TransportEvent")
    protected List<TransportEventType> transportEvent;
    @XmlElement(name = "ApplicableTransportMeans")
    protected TransportMeansType applicableTransportMeans;
    @XmlElement(name = "HaulageTradingTerms")
    protected List<TradingTermsType> haulageTradingTerms;
    @XmlElement(name = "HazardousGoodsTransit")
    protected List<HazardousGoodsTransitType> hazardousGoodsTransit;
    @XmlElement(name = "PackagedTransportHandlingUnit")
    protected List<TransportHandlingUnitType> packagedTransportHandlingUnit;
    @XmlElement(name = "ServiceAllowanceCharge")
    protected List<AllowanceChargeType> serviceAllowanceCharge;
    @XmlElement(name = "FreightAllowanceCharge")
    protected List<AllowanceChargeType> freightAllowanceCharge;
    @XmlElement(name = "AttachedTransportEquipment")
    protected List<TransportEquipmentType> attachedTransportEquipment;
    @XmlElement(name = "Delivery")
    protected DeliveryType delivery;
    @XmlElement(name = "Pickup")
    protected PickupType pickup;
    @XmlElement(name = "Despatch")
    protected DespatchType despatch;
    @XmlElement(name = "ShipmentDocumentReference")
    protected List<DocumentReferenceType> shipmentDocumentReference;
    @XmlElement(name = "ContainedInTransportEquipment")
    protected List<TransportEquipmentType> containedInTransportEquipment;
    @XmlElement(name = "Package")
    protected List<PackageType> _package;
    @XmlElement(name = "GoodsItem")
    protected List<GoodsItemType> goodsItem;

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
     * Gets the value of the referencedConsignmentID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referencedConsignmentID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferencedConsignmentID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedConsignmentIDType }
     * 
     * 
     */
    public List<ReferencedConsignmentIDType> getReferencedConsignmentID() {
        if (referencedConsignmentID == null) {
            referencedConsignmentID = new ArrayList<ReferencedConsignmentIDType>();
        }
        return this.referencedConsignmentID;
    }

    /**
     * Ruft den Wert der transportEquipmentTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEquipmentTypeCodeType }
     *     
     */
    public TransportEquipmentTypeCodeType getTransportEquipmentTypeCode() {
        return transportEquipmentTypeCode;
    }

    /**
     * Legt den Wert der transportEquipmentTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEquipmentTypeCodeType }
     *     
     */
    public void setTransportEquipmentTypeCode(TransportEquipmentTypeCodeType value) {
        this.transportEquipmentTypeCode = value;
    }

    /**
     * Ruft den Wert der providerTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProviderTypeCodeType }
     *     
     */
    public ProviderTypeCodeType getProviderTypeCode() {
        return providerTypeCode;
    }

    /**
     * Legt den Wert der providerTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderTypeCodeType }
     *     
     */
    public void setProviderTypeCode(ProviderTypeCodeType value) {
        this.providerTypeCode = value;
    }

    /**
     * Ruft den Wert der ownerTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OwnerTypeCodeType }
     *     
     */
    public OwnerTypeCodeType getOwnerTypeCode() {
        return ownerTypeCode;
    }

    /**
     * Legt den Wert der ownerTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OwnerTypeCodeType }
     *     
     */
    public void setOwnerTypeCode(OwnerTypeCodeType value) {
        this.ownerTypeCode = value;
    }

    /**
     * Ruft den Wert der sizeTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SizeTypeCodeType }
     *     
     */
    public SizeTypeCodeType getSizeTypeCode() {
        return sizeTypeCode;
    }

    /**
     * Legt den Wert der sizeTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeTypeCodeType }
     *     
     */
    public void setSizeTypeCode(SizeTypeCodeType value) {
        this.sizeTypeCode = value;
    }

    /**
     * Ruft den Wert der dispositionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DispositionCodeType }
     *     
     */
    public DispositionCodeType getDispositionCode() {
        return dispositionCode;
    }

    /**
     * Legt den Wert der dispositionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DispositionCodeType }
     *     
     */
    public void setDispositionCode(DispositionCodeType value) {
        this.dispositionCode = value;
    }

    /**
     * Ruft den Wert der fullnessIndicationCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FullnessIndicationCodeType }
     *     
     */
    public FullnessIndicationCodeType getFullnessIndicationCode() {
        return fullnessIndicationCode;
    }

    /**
     * Legt den Wert der fullnessIndicationCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FullnessIndicationCodeType }
     *     
     */
    public void setFullnessIndicationCode(FullnessIndicationCodeType value) {
        this.fullnessIndicationCode = value;
    }

    /**
     * Ruft den Wert der refrigerationOnIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RefrigerationOnIndicatorType }
     *     
     */
    public RefrigerationOnIndicatorType getRefrigerationOnIndicator() {
        return refrigerationOnIndicator;
    }

    /**
     * Legt den Wert der refrigerationOnIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RefrigerationOnIndicatorType }
     *     
     */
    public void setRefrigerationOnIndicator(RefrigerationOnIndicatorType value) {
        this.refrigerationOnIndicator = value;
    }

    /**
     * Gets the value of the information property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the information property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformationType }
     * 
     * 
     */
    public List<InformationType> getInformation() {
        if (information == null) {
            information = new ArrayList<InformationType>();
        }
        return this.information;
    }

    /**
     * Ruft den Wert der returnabilityIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReturnabilityIndicatorType }
     *     
     */
    public ReturnabilityIndicatorType getReturnabilityIndicator() {
        return returnabilityIndicator;
    }

    /**
     * Legt den Wert der returnabilityIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnabilityIndicatorType }
     *     
     */
    public void setReturnabilityIndicator(ReturnabilityIndicatorType value) {
        this.returnabilityIndicator = value;
    }

    /**
     * Ruft den Wert der legalStatusIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LegalStatusIndicatorType }
     *     
     */
    public LegalStatusIndicatorType getLegalStatusIndicator() {
        return legalStatusIndicator;
    }

    /**
     * Legt den Wert der legalStatusIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalStatusIndicatorType }
     *     
     */
    public void setLegalStatusIndicator(LegalStatusIndicatorType value) {
        this.legalStatusIndicator = value;
    }

    /**
     * Ruft den Wert der airFlowPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AirFlowPercentType }
     *     
     */
    public AirFlowPercentType getAirFlowPercent() {
        return airFlowPercent;
    }

    /**
     * Legt den Wert der airFlowPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AirFlowPercentType }
     *     
     */
    public void setAirFlowPercent(AirFlowPercentType value) {
        this.airFlowPercent = value;
    }

    /**
     * Ruft den Wert der humidityPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HumidityPercentType }
     *     
     */
    public HumidityPercentType getHumidityPercent() {
        return humidityPercent;
    }

    /**
     * Legt den Wert der humidityPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HumidityPercentType }
     *     
     */
    public void setHumidityPercent(HumidityPercentType value) {
        this.humidityPercent = value;
    }

    /**
     * Ruft den Wert der animalFoodApprovedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AnimalFoodApprovedIndicatorType }
     *     
     */
    public AnimalFoodApprovedIndicatorType getAnimalFoodApprovedIndicator() {
        return animalFoodApprovedIndicator;
    }

    /**
     * Legt den Wert der animalFoodApprovedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AnimalFoodApprovedIndicatorType }
     *     
     */
    public void setAnimalFoodApprovedIndicator(AnimalFoodApprovedIndicatorType value) {
        this.animalFoodApprovedIndicator = value;
    }

    /**
     * Ruft den Wert der humanFoodApprovedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HumanFoodApprovedIndicatorType }
     *     
     */
    public HumanFoodApprovedIndicatorType getHumanFoodApprovedIndicator() {
        return humanFoodApprovedIndicator;
    }

    /**
     * Legt den Wert der humanFoodApprovedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HumanFoodApprovedIndicatorType }
     *     
     */
    public void setHumanFoodApprovedIndicator(HumanFoodApprovedIndicatorType value) {
        this.humanFoodApprovedIndicator = value;
    }

    /**
     * Ruft den Wert der dangerousGoodsApprovedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DangerousGoodsApprovedIndicatorType }
     *     
     */
    public DangerousGoodsApprovedIndicatorType getDangerousGoodsApprovedIndicator() {
        return dangerousGoodsApprovedIndicator;
    }

    /**
     * Legt den Wert der dangerousGoodsApprovedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerousGoodsApprovedIndicatorType }
     *     
     */
    public void setDangerousGoodsApprovedIndicator(DangerousGoodsApprovedIndicatorType value) {
        this.dangerousGoodsApprovedIndicator = value;
    }

    /**
     * Ruft den Wert der refrigeratedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RefrigeratedIndicatorType }
     *     
     */
    public RefrigeratedIndicatorType getRefrigeratedIndicator() {
        return refrigeratedIndicator;
    }

    /**
     * Legt den Wert der refrigeratedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RefrigeratedIndicatorType }
     *     
     */
    public void setRefrigeratedIndicator(RefrigeratedIndicatorType value) {
        this.refrigeratedIndicator = value;
    }

    /**
     * Ruft den Wert der characteristics-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CharacteristicsType }
     *     
     */
    public CharacteristicsType getCharacteristics() {
        return characteristics;
    }

    /**
     * Legt den Wert der characteristics-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacteristicsType }
     *     
     */
    public void setCharacteristics(CharacteristicsType value) {
        this.characteristics = value;
    }

    /**
     * Gets the value of the damageRemarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the damageRemarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDamageRemarks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DamageRemarksType }
     * 
     * 
     */
    public List<DamageRemarksType> getDamageRemarks() {
        if (damageRemarks == null) {
            damageRemarks = new ArrayList<DamageRemarksType>();
        }
        return this.damageRemarks;
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
     * Gets the value of the specialTransportRequirements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialTransportRequirements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialTransportRequirements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecialTransportRequirementsType }
     * 
     * 
     */
    public List<SpecialTransportRequirementsType> getSpecialTransportRequirements() {
        if (specialTransportRequirements == null) {
            specialTransportRequirements = new ArrayList<SpecialTransportRequirementsType>();
        }
        return this.specialTransportRequirements;
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
     * Ruft den Wert der tareWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TareWeightMeasureType }
     *     
     */
    public TareWeightMeasureType getTareWeightMeasure() {
        return tareWeightMeasure;
    }

    /**
     * Legt den Wert der tareWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TareWeightMeasureType }
     *     
     */
    public void setTareWeightMeasure(TareWeightMeasureType value) {
        this.tareWeightMeasure = value;
    }

    /**
     * Ruft den Wert der trackingDeviceCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrackingDeviceCodeType }
     *     
     */
    public TrackingDeviceCodeType getTrackingDeviceCode() {
        return trackingDeviceCode;
    }

    /**
     * Legt den Wert der trackingDeviceCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingDeviceCodeType }
     *     
     */
    public void setTrackingDeviceCode(TrackingDeviceCodeType value) {
        this.trackingDeviceCode = value;
    }

    /**
     * Ruft den Wert der powerIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PowerIndicatorType }
     *     
     */
    public PowerIndicatorType getPowerIndicator() {
        return powerIndicator;
    }

    /**
     * Legt den Wert der powerIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerIndicatorType }
     *     
     */
    public void setPowerIndicator(PowerIndicatorType value) {
        this.powerIndicator = value;
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
     * Gets the value of the transportEquipmentSeal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportEquipmentSeal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportEquipmentSeal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentSealType }
     * 
     * 
     */
    public List<TransportEquipmentSealType> getTransportEquipmentSeal() {
        if (transportEquipmentSeal == null) {
            transportEquipmentSeal = new ArrayList<TransportEquipmentSealType>();
        }
        return this.transportEquipmentSeal;
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

    /**
     * Ruft den Wert der providerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getProviderParty() {
        return providerParty;
    }

    /**
     * Legt den Wert der providerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setProviderParty(PartyType value) {
        this.providerParty = value;
    }

    /**
     * Ruft den Wert der loadingProofParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getLoadingProofParty() {
        return loadingProofParty;
    }

    /**
     * Legt den Wert der loadingProofParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setLoadingProofParty(PartyType value) {
        this.loadingProofParty = value;
    }

    /**
     * Ruft den Wert der supplierParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplierPartyType }
     *     
     */
    public SupplierPartyType getSupplierParty() {
        return supplierParty;
    }

    /**
     * Legt den Wert der supplierParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierPartyType }
     *     
     */
    public void setSupplierParty(SupplierPartyType value) {
        this.supplierParty = value;
    }

    /**
     * Ruft den Wert der ownerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOwnerParty() {
        return ownerParty;
    }

    /**
     * Legt den Wert der ownerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOwnerParty(PartyType value) {
        this.ownerParty = value;
    }

    /**
     * Ruft den Wert der operatingParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOperatingParty() {
        return operatingParty;
    }

    /**
     * Legt den Wert der operatingParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOperatingParty(PartyType value) {
        this.operatingParty = value;
    }

    /**
     * Ruft den Wert der loadingLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLoadingLocation() {
        return loadingLocation;
    }

    /**
     * Legt den Wert der loadingLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLoadingLocation(LocationType value) {
        this.loadingLocation = value;
    }

    /**
     * Ruft den Wert der unloadingLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getUnloadingLocation() {
        return unloadingLocation;
    }

    /**
     * Legt den Wert der unloadingLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setUnloadingLocation(LocationType value) {
        this.unloadingLocation = value;
    }

    /**
     * Ruft den Wert der storageLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getStorageLocation() {
        return storageLocation;
    }

    /**
     * Legt den Wert der storageLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setStorageLocation(LocationType value) {
        this.storageLocation = value;
    }

    /**
     * Gets the value of the positioningTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the positioningTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositioningTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getPositioningTransportEvent() {
        if (positioningTransportEvent == null) {
            positioningTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.positioningTransportEvent;
    }

    /**
     * Gets the value of the quarantineTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the quarantineTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuarantineTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getQuarantineTransportEvent() {
        if (quarantineTransportEvent == null) {
            quarantineTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.quarantineTransportEvent;
    }

    /**
     * Gets the value of the deliveryTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getDeliveryTransportEvent() {
        if (deliveryTransportEvent == null) {
            deliveryTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.deliveryTransportEvent;
    }

    /**
     * Gets the value of the pickupTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pickupTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPickupTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getPickupTransportEvent() {
        if (pickupTransportEvent == null) {
            pickupTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.pickupTransportEvent;
    }

    /**
     * Gets the value of the handlingTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the handlingTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHandlingTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getHandlingTransportEvent() {
        if (handlingTransportEvent == null) {
            handlingTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.handlingTransportEvent;
    }

    /**
     * Gets the value of the loadingTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loadingTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoadingTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getLoadingTransportEvent() {
        if (loadingTransportEvent == null) {
            loadingTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.loadingTransportEvent;
    }

    /**
     * Gets the value of the transportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getTransportEvent() {
        if (transportEvent == null) {
            transportEvent = new ArrayList<TransportEventType>();
        }
        return this.transportEvent;
    }

    /**
     * Ruft den Wert der applicableTransportMeans-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansType }
     *     
     */
    public TransportMeansType getApplicableTransportMeans() {
        return applicableTransportMeans;
    }

    /**
     * Legt den Wert der applicableTransportMeans-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansType }
     *     
     */
    public void setApplicableTransportMeans(TransportMeansType value) {
        this.applicableTransportMeans = value;
    }

    /**
     * Gets the value of the haulageTradingTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the haulageTradingTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHaulageTradingTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradingTermsType }
     * 
     * 
     */
    public List<TradingTermsType> getHaulageTradingTerms() {
        if (haulageTradingTerms == null) {
            haulageTradingTerms = new ArrayList<TradingTermsType>();
        }
        return this.haulageTradingTerms;
    }

    /**
     * Gets the value of the hazardousGoodsTransit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hazardousGoodsTransit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHazardousGoodsTransit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousGoodsTransitType }
     * 
     * 
     */
    public List<HazardousGoodsTransitType> getHazardousGoodsTransit() {
        if (hazardousGoodsTransit == null) {
            hazardousGoodsTransit = new ArrayList<HazardousGoodsTransitType>();
        }
        return this.hazardousGoodsTransit;
    }

    /**
     * Gets the value of the packagedTransportHandlingUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packagedTransportHandlingUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackagedTransportHandlingUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportHandlingUnitType }
     * 
     * 
     */
    public List<TransportHandlingUnitType> getPackagedTransportHandlingUnit() {
        if (packagedTransportHandlingUnit == null) {
            packagedTransportHandlingUnit = new ArrayList<TransportHandlingUnitType>();
        }
        return this.packagedTransportHandlingUnit;
    }

    /**
     * Gets the value of the serviceAllowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceAllowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getServiceAllowanceCharge() {
        if (serviceAllowanceCharge == null) {
            serviceAllowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.serviceAllowanceCharge;
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
     * Gets the value of the attachedTransportEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachedTransportEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachedTransportEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentType }
     * 
     * 
     */
    public List<TransportEquipmentType> getAttachedTransportEquipment() {
        if (attachedTransportEquipment == null) {
            attachedTransportEquipment = new ArrayList<TransportEquipmentType>();
        }
        return this.attachedTransportEquipment;
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
     * Gets the value of the shipmentDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getShipmentDocumentReference() {
        if (shipmentDocumentReference == null) {
            shipmentDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.shipmentDocumentReference;
    }

    /**
     * Gets the value of the containedInTransportEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containedInTransportEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainedInTransportEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentType }
     * 
     * 
     */
    public List<TransportEquipmentType> getContainedInTransportEquipment() {
        if (containedInTransportEquipment == null) {
            containedInTransportEquipment = new ArrayList<TransportEquipmentType>();
        }
        return this.containedInTransportEquipment;
    }

    /**
     * Gets the value of the package property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the package property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackageType }
     * 
     * 
     */
    public List<PackageType> getPackage() {
        if (_package == null) {
            _package = new ArrayList<PackageType>();
        }
        return this._package;
    }

    /**
     * Gets the value of the goodsItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the goodsItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGoodsItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GoodsItemType }
     * 
     * 
     */
    public List<GoodsItemType> getGoodsItem() {
        if (goodsItem == null) {
            goodsItem = new ArrayList<GoodsItemType>();
        }
        return this.goodsItem;
    }

}
