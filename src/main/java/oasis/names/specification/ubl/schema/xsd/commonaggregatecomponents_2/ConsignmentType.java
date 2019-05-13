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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnimalFoodIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BrokerAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BulkCargoIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CarrierAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CarrierServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeableWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChildConsignmentQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsigneeAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsignmentQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsignorAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsolidatableIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ContainerizedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ContractedCarrierAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomsClearanceServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredCustomsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredForCarriageValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredStatisticsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeliveryInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForwarderServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreeOnBoardValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreightForwarderAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GeneralCargoIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HandlingCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HandlingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HaulageInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousRiskIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumanFoodIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InsurancePremiumAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InsuranceValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LivestockIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingLengthMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingSequenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetNetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerformingCarrierAssignedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RemarksType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ShippingPriorityLevelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialSecurityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialServiceInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SplitConsignmentIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SummaryDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TariffCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TariffDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThirdPartyPayerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalGoodsItemQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalInvoiceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalPackagesQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalTransportHandlingUnitQuantityType;


/**
 * <p>Java-Klasse für ConsignmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConsignmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CarrierAssignedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsigneeAssignedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsignorAssignedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FreightForwarderAssignedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BrokerAssignedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ContractedCarrierAssignedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PerformingCarrierAssignedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SummaryDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalInvoiceAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredCustomsValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TariffDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TariffCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InsurancePremiumAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetNetWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChargeableWeightMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossVolumeMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetVolumeMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LoadingLengthMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Remarks" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousRiskIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AnimalFoodIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HumanFoodIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LivestockIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BulkCargoIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ContainerizedIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GeneralCargoIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialSecurityIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ThirdPartyPayerIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CarrierServiceInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomsClearanceServiceInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForwarderServiceInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialServiceInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ShippingPriorityLevelCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HandlingCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HandlingInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Information" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalGoodsItemQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalTransportHandlingUnitQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InsuranceValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredForCarriageValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeclaredStatisticsValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FreeOnBoardValueAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SplitConsignmentIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeliveryInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsignmentQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsolidatableIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HaulageInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LoadingSequenceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChildConsignmentQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalPackagesQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsolidatedShipment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CustomsDeclaration" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestedPickupTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestedDeliveryTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PlannedPickupTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PlannedDeliveryTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Status" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ChildConsignment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsigneeParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExporterParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsignorParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ImporterParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CarrierParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightForwarderParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}NotifyParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginalDespatchParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinalDeliveryParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PerformingCarrierParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SubstituteCarrierParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LogisticsOperatorParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportAdvisorParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HazardousItemNotificationParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}InsuranceParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MortgageHolderParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BillOfLadingHolderParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginalDepartureCountry" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinalDestinationCountry" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransitCountry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportContract" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEvent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginalDespatchTransportationService" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinalDeliveryTransportationService" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CollectPaymentTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DisbursementPaymentTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PrepaidPaymentTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExtraAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MainCarriageShipmentStage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PreCarriageShipmentStage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OnCarriageShipmentStage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportHandlingUnit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FirstArrivalPortLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LastExitPortLocation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsignmentType", propOrder = {
    "id",
    "carrierAssignedID",
    "consigneeAssignedID",
    "consignorAssignedID",
    "freightForwarderAssignedID",
    "brokerAssignedID",
    "contractedCarrierAssignedID",
    "performingCarrierAssignedID",
    "summaryDescription",
    "totalInvoiceAmount",
    "declaredCustomsValueAmount",
    "tariffDescription",
    "tariffCode",
    "insurancePremiumAmount",
    "grossWeightMeasure",
    "netWeightMeasure",
    "netNetWeightMeasure",
    "chargeableWeightMeasure",
    "grossVolumeMeasure",
    "netVolumeMeasure",
    "loadingLengthMeasure",
    "remarks",
    "hazardousRiskIndicator",
    "animalFoodIndicator",
    "humanFoodIndicator",
    "livestockIndicator",
    "bulkCargoIndicator",
    "containerizedIndicator",
    "generalCargoIndicator",
    "specialSecurityIndicator",
    "thirdPartyPayerIndicator",
    "carrierServiceInstructions",
    "customsClearanceServiceInstructions",
    "forwarderServiceInstructions",
    "specialServiceInstructions",
    "sequenceID",
    "shippingPriorityLevelCode",
    "handlingCode",
    "handlingInstructions",
    "information",
    "totalGoodsItemQuantity",
    "totalTransportHandlingUnitQuantity",
    "insuranceValueAmount",
    "declaredForCarriageValueAmount",
    "declaredStatisticsValueAmount",
    "freeOnBoardValueAmount",
    "specialInstructions",
    "splitConsignmentIndicator",
    "deliveryInstructions",
    "consignmentQuantity",
    "consolidatableIndicator",
    "haulageInstructions",
    "loadingSequenceID",
    "childConsignmentQuantity",
    "totalPackagesQuantity",
    "consolidatedShipment",
    "customsDeclaration",
    "requestedPickupTransportEvent",
    "requestedDeliveryTransportEvent",
    "plannedPickupTransportEvent",
    "plannedDeliveryTransportEvent",
    "status",
    "childConsignment",
    "consigneeParty",
    "exporterParty",
    "consignorParty",
    "importerParty",
    "carrierParty",
    "freightForwarderParty",
    "notifyParty",
    "originalDespatchParty",
    "finalDeliveryParty",
    "performingCarrierParty",
    "substituteCarrierParty",
    "logisticsOperatorParty",
    "transportAdvisorParty",
    "hazardousItemNotificationParty",
    "insuranceParty",
    "mortgageHolderParty",
    "billOfLadingHolderParty",
    "originalDepartureCountry",
    "finalDestinationCountry",
    "transitCountry",
    "transportContract",
    "transportEvent",
    "originalDespatchTransportationService",
    "finalDeliveryTransportationService",
    "deliveryTerms",
    "paymentTerms",
    "collectPaymentTerms",
    "disbursementPaymentTerms",
    "prepaidPaymentTerms",
    "freightAllowanceCharge",
    "extraAllowanceCharge",
    "mainCarriageShipmentStage",
    "preCarriageShipmentStage",
    "onCarriageShipmentStage",
    "transportHandlingUnit",
    "firstArrivalPortLocation",
    "lastExitPortLocation"
})
public class ConsignmentType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "CarrierAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CarrierAssignedIDType carrierAssignedID;
    @XmlElement(name = "ConsigneeAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsigneeAssignedIDType consigneeAssignedID;
    @XmlElement(name = "ConsignorAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsignorAssignedIDType consignorAssignedID;
    @XmlElement(name = "FreightForwarderAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FreightForwarderAssignedIDType freightForwarderAssignedID;
    @XmlElement(name = "BrokerAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BrokerAssignedIDType brokerAssignedID;
    @XmlElement(name = "ContractedCarrierAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ContractedCarrierAssignedIDType contractedCarrierAssignedID;
    @XmlElement(name = "PerformingCarrierAssignedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PerformingCarrierAssignedIDType performingCarrierAssignedID;
    @XmlElement(name = "SummaryDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<SummaryDescriptionType> summaryDescription;
    @XmlElement(name = "TotalInvoiceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalInvoiceAmountType totalInvoiceAmount;
    @XmlElement(name = "DeclaredCustomsValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredCustomsValueAmountType declaredCustomsValueAmount;
    @XmlElement(name = "TariffDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TariffDescriptionType> tariffDescription;
    @XmlElement(name = "TariffCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TariffCodeType tariffCode;
    @XmlElement(name = "InsurancePremiumAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InsurancePremiumAmountType insurancePremiumAmount;
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
    @XmlElement(name = "LoadingLengthMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LoadingLengthMeasureType loadingLengthMeasure;
    @XmlElement(name = "Remarks", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RemarksType> remarks;
    @XmlElement(name = "HazardousRiskIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousRiskIndicatorType hazardousRiskIndicator;
    @XmlElement(name = "AnimalFoodIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AnimalFoodIndicatorType animalFoodIndicator;
    @XmlElement(name = "HumanFoodIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HumanFoodIndicatorType humanFoodIndicator;
    @XmlElement(name = "LivestockIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LivestockIndicatorType livestockIndicator;
    @XmlElement(name = "BulkCargoIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BulkCargoIndicatorType bulkCargoIndicator;
    @XmlElement(name = "ContainerizedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ContainerizedIndicatorType containerizedIndicator;
    @XmlElement(name = "GeneralCargoIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GeneralCargoIndicatorType generalCargoIndicator;
    @XmlElement(name = "SpecialSecurityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecialSecurityIndicatorType specialSecurityIndicator;
    @XmlElement(name = "ThirdPartyPayerIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ThirdPartyPayerIndicatorType thirdPartyPayerIndicator;
    @XmlElement(name = "CarrierServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<CarrierServiceInstructionsType> carrierServiceInstructions;
    @XmlElement(name = "CustomsClearanceServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<CustomsClearanceServiceInstructionsType> customsClearanceServiceInstructions;
    @XmlElement(name = "ForwarderServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ForwarderServiceInstructionsType> forwarderServiceInstructions;
    @XmlElement(name = "SpecialServiceInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<SpecialServiceInstructionsType> specialServiceInstructions;
    @XmlElement(name = "SequenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SequenceIDType sequenceID;
    @XmlElement(name = "ShippingPriorityLevelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ShippingPriorityLevelCodeType shippingPriorityLevelCode;
    @XmlElement(name = "HandlingCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HandlingCodeType handlingCode;
    @XmlElement(name = "HandlingInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<HandlingInstructionsType> handlingInstructions;
    @XmlElement(name = "Information", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<InformationType> information;
    @XmlElement(name = "TotalGoodsItemQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalGoodsItemQuantityType totalGoodsItemQuantity;
    @XmlElement(name = "TotalTransportHandlingUnitQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalTransportHandlingUnitQuantityType totalTransportHandlingUnitQuantity;
    @XmlElement(name = "InsuranceValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InsuranceValueAmountType insuranceValueAmount;
    @XmlElement(name = "DeclaredForCarriageValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredForCarriageValueAmountType declaredForCarriageValueAmount;
    @XmlElement(name = "DeclaredStatisticsValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeclaredStatisticsValueAmountType declaredStatisticsValueAmount;
    @XmlElement(name = "FreeOnBoardValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FreeOnBoardValueAmountType freeOnBoardValueAmount;
    @XmlElement(name = "SpecialInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<SpecialInstructionsType> specialInstructions;
    @XmlElement(name = "SplitConsignmentIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SplitConsignmentIndicatorType splitConsignmentIndicator;
    @XmlElement(name = "DeliveryInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DeliveryInstructionsType> deliveryInstructions;
    @XmlElement(name = "ConsignmentQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsignmentQuantityType consignmentQuantity;
    @XmlElement(name = "ConsolidatableIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsolidatableIndicatorType consolidatableIndicator;
    @XmlElement(name = "HaulageInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<HaulageInstructionsType> haulageInstructions;
    @XmlElement(name = "LoadingSequenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LoadingSequenceIDType loadingSequenceID;
    @XmlElement(name = "ChildConsignmentQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ChildConsignmentQuantityType childConsignmentQuantity;
    @XmlElement(name = "TotalPackagesQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalPackagesQuantityType totalPackagesQuantity;
    @XmlElement(name = "ConsolidatedShipment")
    protected List<ShipmentType> consolidatedShipment;
    @XmlElement(name = "CustomsDeclaration")
    protected List<CustomsDeclarationType> customsDeclaration;
    @XmlElement(name = "RequestedPickupTransportEvent")
    protected TransportEventType requestedPickupTransportEvent;
    @XmlElement(name = "RequestedDeliveryTransportEvent")
    protected TransportEventType requestedDeliveryTransportEvent;
    @XmlElement(name = "PlannedPickupTransportEvent")
    protected TransportEventType plannedPickupTransportEvent;
    @XmlElement(name = "PlannedDeliveryTransportEvent")
    protected TransportEventType plannedDeliveryTransportEvent;
    @XmlElement(name = "Status")
    protected List<StatusType> status;
    @XmlElement(name = "ChildConsignment")
    protected List<ConsignmentType> childConsignment;
    @XmlElement(name = "ConsigneeParty")
    protected PartyType consigneeParty;
    @XmlElement(name = "ExporterParty")
    protected PartyType exporterParty;
    @XmlElement(name = "ConsignorParty")
    protected PartyType consignorParty;
    @XmlElement(name = "ImporterParty")
    protected PartyType importerParty;
    @XmlElement(name = "CarrierParty")
    protected PartyType carrierParty;
    @XmlElement(name = "FreightForwarderParty")
    protected PartyType freightForwarderParty;
    @XmlElement(name = "NotifyParty")
    protected PartyType notifyParty;
    @XmlElement(name = "OriginalDespatchParty")
    protected PartyType originalDespatchParty;
    @XmlElement(name = "FinalDeliveryParty")
    protected PartyType finalDeliveryParty;
    @XmlElement(name = "PerformingCarrierParty")
    protected PartyType performingCarrierParty;
    @XmlElement(name = "SubstituteCarrierParty")
    protected PartyType substituteCarrierParty;
    @XmlElement(name = "LogisticsOperatorParty")
    protected PartyType logisticsOperatorParty;
    @XmlElement(name = "TransportAdvisorParty")
    protected PartyType transportAdvisorParty;
    @XmlElement(name = "HazardousItemNotificationParty")
    protected PartyType hazardousItemNotificationParty;
    @XmlElement(name = "InsuranceParty")
    protected PartyType insuranceParty;
    @XmlElement(name = "MortgageHolderParty")
    protected PartyType mortgageHolderParty;
    @XmlElement(name = "BillOfLadingHolderParty")
    protected PartyType billOfLadingHolderParty;
    @XmlElement(name = "OriginalDepartureCountry")
    protected CountryType originalDepartureCountry;
    @XmlElement(name = "FinalDestinationCountry")
    protected CountryType finalDestinationCountry;
    @XmlElement(name = "TransitCountry")
    protected List<CountryType> transitCountry;
    @XmlElement(name = "TransportContract")
    protected ContractType transportContract;
    @XmlElement(name = "TransportEvent")
    protected List<TransportEventType> transportEvent;
    @XmlElement(name = "OriginalDespatchTransportationService")
    protected TransportationServiceType originalDespatchTransportationService;
    @XmlElement(name = "FinalDeliveryTransportationService")
    protected TransportationServiceType finalDeliveryTransportationService;
    @XmlElement(name = "DeliveryTerms")
    protected DeliveryTermsType deliveryTerms;
    @XmlElement(name = "PaymentTerms")
    protected PaymentTermsType paymentTerms;
    @XmlElement(name = "CollectPaymentTerms")
    protected PaymentTermsType collectPaymentTerms;
    @XmlElement(name = "DisbursementPaymentTerms")
    protected PaymentTermsType disbursementPaymentTerms;
    @XmlElement(name = "PrepaidPaymentTerms")
    protected PaymentTermsType prepaidPaymentTerms;
    @XmlElement(name = "FreightAllowanceCharge")
    protected List<AllowanceChargeType> freightAllowanceCharge;
    @XmlElement(name = "ExtraAllowanceCharge")
    protected List<AllowanceChargeType> extraAllowanceCharge;
    @XmlElement(name = "MainCarriageShipmentStage")
    protected List<ShipmentStageType> mainCarriageShipmentStage;
    @XmlElement(name = "PreCarriageShipmentStage")
    protected List<ShipmentStageType> preCarriageShipmentStage;
    @XmlElement(name = "OnCarriageShipmentStage")
    protected List<ShipmentStageType> onCarriageShipmentStage;
    @XmlElement(name = "TransportHandlingUnit")
    protected List<TransportHandlingUnitType> transportHandlingUnit;
    @XmlElement(name = "FirstArrivalPortLocation")
    protected LocationType firstArrivalPortLocation;
    @XmlElement(name = "LastExitPortLocation")
    protected LocationType lastExitPortLocation;

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
     * Ruft den Wert der carrierAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CarrierAssignedIDType }
     *     
     */
    public CarrierAssignedIDType getCarrierAssignedID() {
        return carrierAssignedID;
    }

    /**
     * Legt den Wert der carrierAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierAssignedIDType }
     *     
     */
    public void setCarrierAssignedID(CarrierAssignedIDType value) {
        this.carrierAssignedID = value;
    }

    /**
     * Ruft den Wert der consigneeAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsigneeAssignedIDType }
     *     
     */
    public ConsigneeAssignedIDType getConsigneeAssignedID() {
        return consigneeAssignedID;
    }

    /**
     * Legt den Wert der consigneeAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsigneeAssignedIDType }
     *     
     */
    public void setConsigneeAssignedID(ConsigneeAssignedIDType value) {
        this.consigneeAssignedID = value;
    }

    /**
     * Ruft den Wert der consignorAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsignorAssignedIDType }
     *     
     */
    public ConsignorAssignedIDType getConsignorAssignedID() {
        return consignorAssignedID;
    }

    /**
     * Legt den Wert der consignorAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsignorAssignedIDType }
     *     
     */
    public void setConsignorAssignedID(ConsignorAssignedIDType value) {
        this.consignorAssignedID = value;
    }

    /**
     * Ruft den Wert der freightForwarderAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FreightForwarderAssignedIDType }
     *     
     */
    public FreightForwarderAssignedIDType getFreightForwarderAssignedID() {
        return freightForwarderAssignedID;
    }

    /**
     * Legt den Wert der freightForwarderAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightForwarderAssignedIDType }
     *     
     */
    public void setFreightForwarderAssignedID(FreightForwarderAssignedIDType value) {
        this.freightForwarderAssignedID = value;
    }

    /**
     * Ruft den Wert der brokerAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BrokerAssignedIDType }
     *     
     */
    public BrokerAssignedIDType getBrokerAssignedID() {
        return brokerAssignedID;
    }

    /**
     * Legt den Wert der brokerAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BrokerAssignedIDType }
     *     
     */
    public void setBrokerAssignedID(BrokerAssignedIDType value) {
        this.brokerAssignedID = value;
    }

    /**
     * Ruft den Wert der contractedCarrierAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContractedCarrierAssignedIDType }
     *     
     */
    public ContractedCarrierAssignedIDType getContractedCarrierAssignedID() {
        return contractedCarrierAssignedID;
    }

    /**
     * Legt den Wert der contractedCarrierAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractedCarrierAssignedIDType }
     *     
     */
    public void setContractedCarrierAssignedID(ContractedCarrierAssignedIDType value) {
        this.contractedCarrierAssignedID = value;
    }

    /**
     * Ruft den Wert der performingCarrierAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PerformingCarrierAssignedIDType }
     *     
     */
    public PerformingCarrierAssignedIDType getPerformingCarrierAssignedID() {
        return performingCarrierAssignedID;
    }

    /**
     * Legt den Wert der performingCarrierAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformingCarrierAssignedIDType }
     *     
     */
    public void setPerformingCarrierAssignedID(PerformingCarrierAssignedIDType value) {
        this.performingCarrierAssignedID = value;
    }

    /**
     * Gets the value of the summaryDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the summaryDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSummaryDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SummaryDescriptionType }
     * 
     * 
     */
    public List<SummaryDescriptionType> getSummaryDescription() {
        if (summaryDescription == null) {
            summaryDescription = new ArrayList<SummaryDescriptionType>();
        }
        return this.summaryDescription;
    }

    /**
     * Ruft den Wert der totalInvoiceAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalInvoiceAmountType }
     *     
     */
    public TotalInvoiceAmountType getTotalInvoiceAmount() {
        return totalInvoiceAmount;
    }

    /**
     * Legt den Wert der totalInvoiceAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalInvoiceAmountType }
     *     
     */
    public void setTotalInvoiceAmount(TotalInvoiceAmountType value) {
        this.totalInvoiceAmount = value;
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
     * Gets the value of the tariffDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariffDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariffDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TariffDescriptionType }
     * 
     * 
     */
    public List<TariffDescriptionType> getTariffDescription() {
        if (tariffDescription == null) {
            tariffDescription = new ArrayList<TariffDescriptionType>();
        }
        return this.tariffDescription;
    }

    /**
     * Ruft den Wert der tariffCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TariffCodeType }
     *     
     */
    public TariffCodeType getTariffCode() {
        return tariffCode;
    }

    /**
     * Legt den Wert der tariffCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffCodeType }
     *     
     */
    public void setTariffCode(TariffCodeType value) {
        this.tariffCode = value;
    }

    /**
     * Ruft den Wert der insurancePremiumAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InsurancePremiumAmountType }
     *     
     */
    public InsurancePremiumAmountType getInsurancePremiumAmount() {
        return insurancePremiumAmount;
    }

    /**
     * Legt den Wert der insurancePremiumAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InsurancePremiumAmountType }
     *     
     */
    public void setInsurancePremiumAmount(InsurancePremiumAmountType value) {
        this.insurancePremiumAmount = value;
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
     * Ruft den Wert der loadingLengthMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LoadingLengthMeasureType }
     *     
     */
    public LoadingLengthMeasureType getLoadingLengthMeasure() {
        return loadingLengthMeasure;
    }

    /**
     * Legt den Wert der loadingLengthMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadingLengthMeasureType }
     *     
     */
    public void setLoadingLengthMeasure(LoadingLengthMeasureType value) {
        this.loadingLengthMeasure = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemarks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemarksType }
     * 
     * 
     */
    public List<RemarksType> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<RemarksType>();
        }
        return this.remarks;
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
     * Ruft den Wert der animalFoodIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AnimalFoodIndicatorType }
     *     
     */
    public AnimalFoodIndicatorType getAnimalFoodIndicator() {
        return animalFoodIndicator;
    }

    /**
     * Legt den Wert der animalFoodIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AnimalFoodIndicatorType }
     *     
     */
    public void setAnimalFoodIndicator(AnimalFoodIndicatorType value) {
        this.animalFoodIndicator = value;
    }

    /**
     * Ruft den Wert der humanFoodIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HumanFoodIndicatorType }
     *     
     */
    public HumanFoodIndicatorType getHumanFoodIndicator() {
        return humanFoodIndicator;
    }

    /**
     * Legt den Wert der humanFoodIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HumanFoodIndicatorType }
     *     
     */
    public void setHumanFoodIndicator(HumanFoodIndicatorType value) {
        this.humanFoodIndicator = value;
    }

    /**
     * Ruft den Wert der livestockIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LivestockIndicatorType }
     *     
     */
    public LivestockIndicatorType getLivestockIndicator() {
        return livestockIndicator;
    }

    /**
     * Legt den Wert der livestockIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LivestockIndicatorType }
     *     
     */
    public void setLivestockIndicator(LivestockIndicatorType value) {
        this.livestockIndicator = value;
    }

    /**
     * Ruft den Wert der bulkCargoIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BulkCargoIndicatorType }
     *     
     */
    public BulkCargoIndicatorType getBulkCargoIndicator() {
        return bulkCargoIndicator;
    }

    /**
     * Legt den Wert der bulkCargoIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkCargoIndicatorType }
     *     
     */
    public void setBulkCargoIndicator(BulkCargoIndicatorType value) {
        this.bulkCargoIndicator = value;
    }

    /**
     * Ruft den Wert der containerizedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContainerizedIndicatorType }
     *     
     */
    public ContainerizedIndicatorType getContainerizedIndicator() {
        return containerizedIndicator;
    }

    /**
     * Legt den Wert der containerizedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerizedIndicatorType }
     *     
     */
    public void setContainerizedIndicator(ContainerizedIndicatorType value) {
        this.containerizedIndicator = value;
    }

    /**
     * Ruft den Wert der generalCargoIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeneralCargoIndicatorType }
     *     
     */
    public GeneralCargoIndicatorType getGeneralCargoIndicator() {
        return generalCargoIndicator;
    }

    /**
     * Legt den Wert der generalCargoIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralCargoIndicatorType }
     *     
     */
    public void setGeneralCargoIndicator(GeneralCargoIndicatorType value) {
        this.generalCargoIndicator = value;
    }

    /**
     * Ruft den Wert der specialSecurityIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecialSecurityIndicatorType }
     *     
     */
    public SpecialSecurityIndicatorType getSpecialSecurityIndicator() {
        return specialSecurityIndicator;
    }

    /**
     * Legt den Wert der specialSecurityIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialSecurityIndicatorType }
     *     
     */
    public void setSpecialSecurityIndicator(SpecialSecurityIndicatorType value) {
        this.specialSecurityIndicator = value;
    }

    /**
     * Ruft den Wert der thirdPartyPayerIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThirdPartyPayerIndicatorType }
     *     
     */
    public ThirdPartyPayerIndicatorType getThirdPartyPayerIndicator() {
        return thirdPartyPayerIndicator;
    }

    /**
     * Legt den Wert der thirdPartyPayerIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThirdPartyPayerIndicatorType }
     *     
     */
    public void setThirdPartyPayerIndicator(ThirdPartyPayerIndicatorType value) {
        this.thirdPartyPayerIndicator = value;
    }

    /**
     * Gets the value of the carrierServiceInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the carrierServiceInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCarrierServiceInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CarrierServiceInstructionsType }
     * 
     * 
     */
    public List<CarrierServiceInstructionsType> getCarrierServiceInstructions() {
        if (carrierServiceInstructions == null) {
            carrierServiceInstructions = new ArrayList<CarrierServiceInstructionsType>();
        }
        return this.carrierServiceInstructions;
    }

    /**
     * Gets the value of the customsClearanceServiceInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customsClearanceServiceInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomsClearanceServiceInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomsClearanceServiceInstructionsType }
     * 
     * 
     */
    public List<CustomsClearanceServiceInstructionsType> getCustomsClearanceServiceInstructions() {
        if (customsClearanceServiceInstructions == null) {
            customsClearanceServiceInstructions = new ArrayList<CustomsClearanceServiceInstructionsType>();
        }
        return this.customsClearanceServiceInstructions;
    }

    /**
     * Gets the value of the forwarderServiceInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forwarderServiceInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForwarderServiceInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ForwarderServiceInstructionsType }
     * 
     * 
     */
    public List<ForwarderServiceInstructionsType> getForwarderServiceInstructions() {
        if (forwarderServiceInstructions == null) {
            forwarderServiceInstructions = new ArrayList<ForwarderServiceInstructionsType>();
        }
        return this.forwarderServiceInstructions;
    }

    /**
     * Gets the value of the specialServiceInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialServiceInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialServiceInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecialServiceInstructionsType }
     * 
     * 
     */
    public List<SpecialServiceInstructionsType> getSpecialServiceInstructions() {
        if (specialServiceInstructions == null) {
            specialServiceInstructions = new ArrayList<SpecialServiceInstructionsType>();
        }
        return this.specialServiceInstructions;
    }

    /**
     * Ruft den Wert der sequenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SequenceIDType }
     *     
     */
    public SequenceIDType getSequenceID() {
        return sequenceID;
    }

    /**
     * Legt den Wert der sequenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceIDType }
     *     
     */
    public void setSequenceID(SequenceIDType value) {
        this.sequenceID = value;
    }

    /**
     * Ruft den Wert der shippingPriorityLevelCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShippingPriorityLevelCodeType }
     *     
     */
    public ShippingPriorityLevelCodeType getShippingPriorityLevelCode() {
        return shippingPriorityLevelCode;
    }

    /**
     * Legt den Wert der shippingPriorityLevelCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingPriorityLevelCodeType }
     *     
     */
    public void setShippingPriorityLevelCode(ShippingPriorityLevelCodeType value) {
        this.shippingPriorityLevelCode = value;
    }

    /**
     * Ruft den Wert der handlingCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HandlingCodeType }
     *     
     */
    public HandlingCodeType getHandlingCode() {
        return handlingCode;
    }

    /**
     * Legt den Wert der handlingCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HandlingCodeType }
     *     
     */
    public void setHandlingCode(HandlingCodeType value) {
        this.handlingCode = value;
    }

    /**
     * Gets the value of the handlingInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the handlingInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHandlingInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HandlingInstructionsType }
     * 
     * 
     */
    public List<HandlingInstructionsType> getHandlingInstructions() {
        if (handlingInstructions == null) {
            handlingInstructions = new ArrayList<HandlingInstructionsType>();
        }
        return this.handlingInstructions;
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
     * Ruft den Wert der totalGoodsItemQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalGoodsItemQuantityType }
     *     
     */
    public TotalGoodsItemQuantityType getTotalGoodsItemQuantity() {
        return totalGoodsItemQuantity;
    }

    /**
     * Legt den Wert der totalGoodsItemQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalGoodsItemQuantityType }
     *     
     */
    public void setTotalGoodsItemQuantity(TotalGoodsItemQuantityType value) {
        this.totalGoodsItemQuantity = value;
    }

    /**
     * Ruft den Wert der totalTransportHandlingUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalTransportHandlingUnitQuantityType }
     *     
     */
    public TotalTransportHandlingUnitQuantityType getTotalTransportHandlingUnitQuantity() {
        return totalTransportHandlingUnitQuantity;
    }

    /**
     * Legt den Wert der totalTransportHandlingUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalTransportHandlingUnitQuantityType }
     *     
     */
    public void setTotalTransportHandlingUnitQuantity(TotalTransportHandlingUnitQuantityType value) {
        this.totalTransportHandlingUnitQuantity = value;
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
     * Gets the value of the specialInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecialInstructionsType }
     * 
     * 
     */
    public List<SpecialInstructionsType> getSpecialInstructions() {
        if (specialInstructions == null) {
            specialInstructions = new ArrayList<SpecialInstructionsType>();
        }
        return this.specialInstructions;
    }

    /**
     * Ruft den Wert der splitConsignmentIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SplitConsignmentIndicatorType }
     *     
     */
    public SplitConsignmentIndicatorType getSplitConsignmentIndicator() {
        return splitConsignmentIndicator;
    }

    /**
     * Legt den Wert der splitConsignmentIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SplitConsignmentIndicatorType }
     *     
     */
    public void setSplitConsignmentIndicator(SplitConsignmentIndicatorType value) {
        this.splitConsignmentIndicator = value;
    }

    /**
     * Gets the value of the deliveryInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryInstructionsType }
     * 
     * 
     */
    public List<DeliveryInstructionsType> getDeliveryInstructions() {
        if (deliveryInstructions == null) {
            deliveryInstructions = new ArrayList<DeliveryInstructionsType>();
        }
        return this.deliveryInstructions;
    }

    /**
     * Ruft den Wert der consignmentQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsignmentQuantityType }
     *     
     */
    public ConsignmentQuantityType getConsignmentQuantity() {
        return consignmentQuantity;
    }

    /**
     * Legt den Wert der consignmentQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsignmentQuantityType }
     *     
     */
    public void setConsignmentQuantity(ConsignmentQuantityType value) {
        this.consignmentQuantity = value;
    }

    /**
     * Ruft den Wert der consolidatableIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsolidatableIndicatorType }
     *     
     */
    public ConsolidatableIndicatorType getConsolidatableIndicator() {
        return consolidatableIndicator;
    }

    /**
     * Legt den Wert der consolidatableIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsolidatableIndicatorType }
     *     
     */
    public void setConsolidatableIndicator(ConsolidatableIndicatorType value) {
        this.consolidatableIndicator = value;
    }

    /**
     * Gets the value of the haulageInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the haulageInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHaulageInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HaulageInstructionsType }
     * 
     * 
     */
    public List<HaulageInstructionsType> getHaulageInstructions() {
        if (haulageInstructions == null) {
            haulageInstructions = new ArrayList<HaulageInstructionsType>();
        }
        return this.haulageInstructions;
    }

    /**
     * Ruft den Wert der loadingSequenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LoadingSequenceIDType }
     *     
     */
    public LoadingSequenceIDType getLoadingSequenceID() {
        return loadingSequenceID;
    }

    /**
     * Legt den Wert der loadingSequenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadingSequenceIDType }
     *     
     */
    public void setLoadingSequenceID(LoadingSequenceIDType value) {
        this.loadingSequenceID = value;
    }

    /**
     * Ruft den Wert der childConsignmentQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChildConsignmentQuantityType }
     *     
     */
    public ChildConsignmentQuantityType getChildConsignmentQuantity() {
        return childConsignmentQuantity;
    }

    /**
     * Legt den Wert der childConsignmentQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChildConsignmentQuantityType }
     *     
     */
    public void setChildConsignmentQuantity(ChildConsignmentQuantityType value) {
        this.childConsignmentQuantity = value;
    }

    /**
     * Ruft den Wert der totalPackagesQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalPackagesQuantityType }
     *     
     */
    public TotalPackagesQuantityType getTotalPackagesQuantity() {
        return totalPackagesQuantity;
    }

    /**
     * Legt den Wert der totalPackagesQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalPackagesQuantityType }
     *     
     */
    public void setTotalPackagesQuantity(TotalPackagesQuantityType value) {
        this.totalPackagesQuantity = value;
    }

    /**
     * Gets the value of the consolidatedShipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consolidatedShipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsolidatedShipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentType }
     * 
     * 
     */
    public List<ShipmentType> getConsolidatedShipment() {
        if (consolidatedShipment == null) {
            consolidatedShipment = new ArrayList<ShipmentType>();
        }
        return this.consolidatedShipment;
    }

    /**
     * Gets the value of the customsDeclaration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customsDeclaration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomsDeclaration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomsDeclarationType }
     * 
     * 
     */
    public List<CustomsDeclarationType> getCustomsDeclaration() {
        if (customsDeclaration == null) {
            customsDeclaration = new ArrayList<CustomsDeclarationType>();
        }
        return this.customsDeclaration;
    }

    /**
     * Ruft den Wert der requestedPickupTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getRequestedPickupTransportEvent() {
        return requestedPickupTransportEvent;
    }

    /**
     * Legt den Wert der requestedPickupTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setRequestedPickupTransportEvent(TransportEventType value) {
        this.requestedPickupTransportEvent = value;
    }

    /**
     * Ruft den Wert der requestedDeliveryTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getRequestedDeliveryTransportEvent() {
        return requestedDeliveryTransportEvent;
    }

    /**
     * Legt den Wert der requestedDeliveryTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setRequestedDeliveryTransportEvent(TransportEventType value) {
        this.requestedDeliveryTransportEvent = value;
    }

    /**
     * Ruft den Wert der plannedPickupTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getPlannedPickupTransportEvent() {
        return plannedPickupTransportEvent;
    }

    /**
     * Legt den Wert der plannedPickupTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setPlannedPickupTransportEvent(TransportEventType value) {
        this.plannedPickupTransportEvent = value;
    }

    /**
     * Ruft den Wert der plannedDeliveryTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getPlannedDeliveryTransportEvent() {
        return plannedDeliveryTransportEvent;
    }

    /**
     * Legt den Wert der plannedDeliveryTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setPlannedDeliveryTransportEvent(TransportEventType value) {
        this.plannedDeliveryTransportEvent = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusType }
     * 
     * 
     */
    public List<StatusType> getStatus() {
        if (status == null) {
            status = new ArrayList<StatusType>();
        }
        return this.status;
    }

    /**
     * Gets the value of the childConsignment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childConsignment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildConsignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsignmentType }
     * 
     * 
     */
    public List<ConsignmentType> getChildConsignment() {
        if (childConsignment == null) {
            childConsignment = new ArrayList<ConsignmentType>();
        }
        return this.childConsignment;
    }

    /**
     * Ruft den Wert der consigneeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getConsigneeParty() {
        return consigneeParty;
    }

    /**
     * Legt den Wert der consigneeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setConsigneeParty(PartyType value) {
        this.consigneeParty = value;
    }

    /**
     * Ruft den Wert der exporterParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getExporterParty() {
        return exporterParty;
    }

    /**
     * Legt den Wert der exporterParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setExporterParty(PartyType value) {
        this.exporterParty = value;
    }

    /**
     * Ruft den Wert der consignorParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getConsignorParty() {
        return consignorParty;
    }

    /**
     * Legt den Wert der consignorParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setConsignorParty(PartyType value) {
        this.consignorParty = value;
    }

    /**
     * Ruft den Wert der importerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getImporterParty() {
        return importerParty;
    }

    /**
     * Legt den Wert der importerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setImporterParty(PartyType value) {
        this.importerParty = value;
    }

    /**
     * Ruft den Wert der carrierParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getCarrierParty() {
        return carrierParty;
    }

    /**
     * Legt den Wert der carrierParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setCarrierParty(PartyType value) {
        this.carrierParty = value;
    }

    /**
     * Ruft den Wert der freightForwarderParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getFreightForwarderParty() {
        return freightForwarderParty;
    }

    /**
     * Legt den Wert der freightForwarderParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setFreightForwarderParty(PartyType value) {
        this.freightForwarderParty = value;
    }

    /**
     * Ruft den Wert der notifyParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getNotifyParty() {
        return notifyParty;
    }

    /**
     * Legt den Wert der notifyParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setNotifyParty(PartyType value) {
        this.notifyParty = value;
    }

    /**
     * Ruft den Wert der originalDespatchParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOriginalDespatchParty() {
        return originalDespatchParty;
    }

    /**
     * Legt den Wert der originalDespatchParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOriginalDespatchParty(PartyType value) {
        this.originalDespatchParty = value;
    }

    /**
     * Ruft den Wert der finalDeliveryParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getFinalDeliveryParty() {
        return finalDeliveryParty;
    }

    /**
     * Legt den Wert der finalDeliveryParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setFinalDeliveryParty(PartyType value) {
        this.finalDeliveryParty = value;
    }

    /**
     * Ruft den Wert der performingCarrierParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPerformingCarrierParty() {
        return performingCarrierParty;
    }

    /**
     * Legt den Wert der performingCarrierParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPerformingCarrierParty(PartyType value) {
        this.performingCarrierParty = value;
    }

    /**
     * Ruft den Wert der substituteCarrierParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getSubstituteCarrierParty() {
        return substituteCarrierParty;
    }

    /**
     * Legt den Wert der substituteCarrierParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setSubstituteCarrierParty(PartyType value) {
        this.substituteCarrierParty = value;
    }

    /**
     * Ruft den Wert der logisticsOperatorParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getLogisticsOperatorParty() {
        return logisticsOperatorParty;
    }

    /**
     * Legt den Wert der logisticsOperatorParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setLogisticsOperatorParty(PartyType value) {
        this.logisticsOperatorParty = value;
    }

    /**
     * Ruft den Wert der transportAdvisorParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTransportAdvisorParty() {
        return transportAdvisorParty;
    }

    /**
     * Legt den Wert der transportAdvisorParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTransportAdvisorParty(PartyType value) {
        this.transportAdvisorParty = value;
    }

    /**
     * Ruft den Wert der hazardousItemNotificationParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getHazardousItemNotificationParty() {
        return hazardousItemNotificationParty;
    }

    /**
     * Legt den Wert der hazardousItemNotificationParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setHazardousItemNotificationParty(PartyType value) {
        this.hazardousItemNotificationParty = value;
    }

    /**
     * Ruft den Wert der insuranceParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getInsuranceParty() {
        return insuranceParty;
    }

    /**
     * Legt den Wert der insuranceParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setInsuranceParty(PartyType value) {
        this.insuranceParty = value;
    }

    /**
     * Ruft den Wert der mortgageHolderParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getMortgageHolderParty() {
        return mortgageHolderParty;
    }

    /**
     * Legt den Wert der mortgageHolderParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setMortgageHolderParty(PartyType value) {
        this.mortgageHolderParty = value;
    }

    /**
     * Ruft den Wert der billOfLadingHolderParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getBillOfLadingHolderParty() {
        return billOfLadingHolderParty;
    }

    /**
     * Legt den Wert der billOfLadingHolderParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setBillOfLadingHolderParty(PartyType value) {
        this.billOfLadingHolderParty = value;
    }

    /**
     * Ruft den Wert der originalDepartureCountry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getOriginalDepartureCountry() {
        return originalDepartureCountry;
    }

    /**
     * Legt den Wert der originalDepartureCountry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setOriginalDepartureCountry(CountryType value) {
        this.originalDepartureCountry = value;
    }

    /**
     * Ruft den Wert der finalDestinationCountry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getFinalDestinationCountry() {
        return finalDestinationCountry;
    }

    /**
     * Legt den Wert der finalDestinationCountry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setFinalDestinationCountry(CountryType value) {
        this.finalDestinationCountry = value;
    }

    /**
     * Gets the value of the transitCountry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transitCountry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransitCountry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CountryType }
     * 
     * 
     */
    public List<CountryType> getTransitCountry() {
        if (transitCountry == null) {
            transitCountry = new ArrayList<CountryType>();
        }
        return this.transitCountry;
    }

    /**
     * Ruft den Wert der transportContract-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getTransportContract() {
        return transportContract;
    }

    /**
     * Legt den Wert der transportContract-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setTransportContract(ContractType value) {
        this.transportContract = value;
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
     * Ruft den Wert der originalDespatchTransportationService-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceType }
     *     
     */
    public TransportationServiceType getOriginalDespatchTransportationService() {
        return originalDespatchTransportationService;
    }

    /**
     * Legt den Wert der originalDespatchTransportationService-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceType }
     *     
     */
    public void setOriginalDespatchTransportationService(TransportationServiceType value) {
        this.originalDespatchTransportationService = value;
    }

    /**
     * Ruft den Wert der finalDeliveryTransportationService-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceType }
     *     
     */
    public TransportationServiceType getFinalDeliveryTransportationService() {
        return finalDeliveryTransportationService;
    }

    /**
     * Legt den Wert der finalDeliveryTransportationService-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceType }
     *     
     */
    public void setFinalDeliveryTransportationService(TransportationServiceType value) {
        this.finalDeliveryTransportationService = value;
    }

    /**
     * Ruft den Wert der deliveryTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryTermsType }
     *     
     */
    public DeliveryTermsType getDeliveryTerms() {
        return deliveryTerms;
    }

    /**
     * Legt den Wert der deliveryTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryTermsType }
     *     
     */
    public void setDeliveryTerms(DeliveryTermsType value) {
        this.deliveryTerms = value;
    }

    /**
     * Ruft den Wert der paymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * Legt den Wert der paymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setPaymentTerms(PaymentTermsType value) {
        this.paymentTerms = value;
    }

    /**
     * Ruft den Wert der collectPaymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getCollectPaymentTerms() {
        return collectPaymentTerms;
    }

    /**
     * Legt den Wert der collectPaymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setCollectPaymentTerms(PaymentTermsType value) {
        this.collectPaymentTerms = value;
    }

    /**
     * Ruft den Wert der disbursementPaymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getDisbursementPaymentTerms() {
        return disbursementPaymentTerms;
    }

    /**
     * Legt den Wert der disbursementPaymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setDisbursementPaymentTerms(PaymentTermsType value) {
        this.disbursementPaymentTerms = value;
    }

    /**
     * Ruft den Wert der prepaidPaymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getPrepaidPaymentTerms() {
        return prepaidPaymentTerms;
    }

    /**
     * Legt den Wert der prepaidPaymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setPrepaidPaymentTerms(PaymentTermsType value) {
        this.prepaidPaymentTerms = value;
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
     * Gets the value of the extraAllowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraAllowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getExtraAllowanceCharge() {
        if (extraAllowanceCharge == null) {
            extraAllowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.extraAllowanceCharge;
    }

    /**
     * Gets the value of the mainCarriageShipmentStage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mainCarriageShipmentStage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMainCarriageShipmentStage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentStageType }
     * 
     * 
     */
    public List<ShipmentStageType> getMainCarriageShipmentStage() {
        if (mainCarriageShipmentStage == null) {
            mainCarriageShipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.mainCarriageShipmentStage;
    }

    /**
     * Gets the value of the preCarriageShipmentStage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preCarriageShipmentStage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreCarriageShipmentStage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentStageType }
     * 
     * 
     */
    public List<ShipmentStageType> getPreCarriageShipmentStage() {
        if (preCarriageShipmentStage == null) {
            preCarriageShipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.preCarriageShipmentStage;
    }

    /**
     * Gets the value of the onCarriageShipmentStage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onCarriageShipmentStage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnCarriageShipmentStage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentStageType }
     * 
     * 
     */
    public List<ShipmentStageType> getOnCarriageShipmentStage() {
        if (onCarriageShipmentStage == null) {
            onCarriageShipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.onCarriageShipmentStage;
    }

    /**
     * Gets the value of the transportHandlingUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportHandlingUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportHandlingUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportHandlingUnitType }
     * 
     * 
     */
    public List<TransportHandlingUnitType> getTransportHandlingUnit() {
        if (transportHandlingUnit == null) {
            transportHandlingUnit = new ArrayList<TransportHandlingUnitType>();
        }
        return this.transportHandlingUnit;
    }

    /**
     * Ruft den Wert der firstArrivalPortLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getFirstArrivalPortLocation() {
        return firstArrivalPortLocation;
    }

    /**
     * Legt den Wert der firstArrivalPortLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setFirstArrivalPortLocation(LocationType value) {
        this.firstArrivalPortLocation = value;
    }

    /**
     * Ruft den Wert der lastExitPortLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLastExitPortLocation() {
        return lastExitPortLocation;
    }

    /**
     * Legt den Wert der lastExitPortLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLastExitPortLocation(LocationType value) {
        this.lastExitPortLocation = value;
    }

}
