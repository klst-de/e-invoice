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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CrewQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DemurrageInstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDeliveryTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingSequenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OnCarriageIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PassengerQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreCarriageIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredDeliveryTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SuccessiveSequenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransitDirectionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportMeansTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportModeCodeType;


/**
 * <p>Java-Klasse für ShipmentStageType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ShipmentStageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportModeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportMeansTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransitDirectionCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreCarriageIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OnCarriageIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EstimatedDeliveryDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EstimatedDeliveryTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequiredDeliveryDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequiredDeliveryTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LoadingSequenceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SuccessiveSequenceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Instructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DemurrageInstructions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CrewQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PassengerQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransitPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CarrierParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportMeans" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingPortLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UnloadingPortLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransshipPortLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LoadingTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExaminationTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AvailabilityTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExportationTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DischargeTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WarehousingTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TakeoverTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OptionalTakeoverTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DropoffTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ActualPickupTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReceiptTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}StorageTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AcceptanceTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TerminalOperatorParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CustomsAgentParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EstimatedTransitPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightAllowanceCharge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FreightChargeLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DetentionTransportEvent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestedDepartureTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestedArrivalTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestedWaypointTransportEvent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PlannedDepartureTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PlannedArrivalTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PlannedWaypointTransportEvent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ActualDepartureTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ActualWaypointTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ActualArrivalTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEvent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EstimatedDepartureTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EstimatedArrivalTransportEvent" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PassengerPerson" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DriverPerson" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReportingPerson" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CrewMemberPerson" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SecurityOfficerPerson" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MasterPerson" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShipsSurgeonPerson" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentStageType", propOrder = {
    "id",
    "transportModeCode",
    "transportMeansTypeCode",
    "transitDirectionCode",
    "preCarriageIndicator",
    "onCarriageIndicator",
    "estimatedDeliveryDate",
    "estimatedDeliveryTime",
    "requiredDeliveryDate",
    "requiredDeliveryTime",
    "loadingSequenceID",
    "successiveSequenceID",
    "instructions",
    "demurrageInstructions",
    "crewQuantity",
    "passengerQuantity",
    "transitPeriod",
    "carrierParty",
    "transportMeans",
    "loadingPortLocation",
    "unloadingPortLocation",
    "transshipPortLocation",
    "loadingTransportEvent",
    "examinationTransportEvent",
    "availabilityTransportEvent",
    "exportationTransportEvent",
    "dischargeTransportEvent",
    "warehousingTransportEvent",
    "takeoverTransportEvent",
    "optionalTakeoverTransportEvent",
    "dropoffTransportEvent",
    "actualPickupTransportEvent",
    "deliveryTransportEvent",
    "receiptTransportEvent",
    "storageTransportEvent",
    "acceptanceTransportEvent",
    "terminalOperatorParty",
    "customsAgentParty",
    "estimatedTransitPeriod",
    "freightAllowanceCharge",
    "freightChargeLocation",
    "detentionTransportEvent",
    "requestedDepartureTransportEvent",
    "requestedArrivalTransportEvent",
    "requestedWaypointTransportEvent",
    "plannedDepartureTransportEvent",
    "plannedArrivalTransportEvent",
    "plannedWaypointTransportEvent",
    "actualDepartureTransportEvent",
    "actualWaypointTransportEvent",
    "actualArrivalTransportEvent",
    "transportEvent",
    "estimatedDepartureTransportEvent",
    "estimatedArrivalTransportEvent",
    "passengerPerson",
    "driverPerson",
    "reportingPerson",
    "crewMemberPerson",
    "securityOfficerPerson",
    "masterPerson",
    "shipsSurgeonPerson"
})
public class ShipmentStageType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "TransportModeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportModeCodeType transportModeCode;
    @XmlElement(name = "TransportMeansTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportMeansTypeCodeType transportMeansTypeCode;
    @XmlElement(name = "TransitDirectionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransitDirectionCodeType transitDirectionCode;
    @XmlElement(name = "PreCarriageIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreCarriageIndicatorType preCarriageIndicator;
    @XmlElement(name = "OnCarriageIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OnCarriageIndicatorType onCarriageIndicator;
    @XmlElement(name = "EstimatedDeliveryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EstimatedDeliveryDateType estimatedDeliveryDate;
    @XmlElement(name = "EstimatedDeliveryTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EstimatedDeliveryTimeType estimatedDeliveryTime;
    @XmlElement(name = "RequiredDeliveryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequiredDeliveryDateType requiredDeliveryDate;
    @XmlElement(name = "RequiredDeliveryTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequiredDeliveryTimeType requiredDeliveryTime;
    @XmlElement(name = "LoadingSequenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LoadingSequenceIDType loadingSequenceID;
    @XmlElement(name = "SuccessiveSequenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SuccessiveSequenceIDType successiveSequenceID;
    @XmlElement(name = "Instructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<InstructionsType> instructions;
    @XmlElement(name = "DemurrageInstructions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DemurrageInstructionsType> demurrageInstructions;
    @XmlElement(name = "CrewQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CrewQuantityType crewQuantity;
    @XmlElement(name = "PassengerQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PassengerQuantityType passengerQuantity;
    @XmlElement(name = "TransitPeriod")
    protected PeriodType transitPeriod;
    @XmlElement(name = "CarrierParty")
    protected List<PartyType> carrierParty;
    @XmlElement(name = "TransportMeans")
    protected TransportMeansType transportMeans;
    @XmlElement(name = "LoadingPortLocation")
    protected LocationType loadingPortLocation;
    @XmlElement(name = "UnloadingPortLocation")
    protected LocationType unloadingPortLocation;
    @XmlElement(name = "TransshipPortLocation")
    protected LocationType transshipPortLocation;
    @XmlElement(name = "LoadingTransportEvent")
    protected TransportEventType loadingTransportEvent;
    @XmlElement(name = "ExaminationTransportEvent")
    protected TransportEventType examinationTransportEvent;
    @XmlElement(name = "AvailabilityTransportEvent")
    protected TransportEventType availabilityTransportEvent;
    @XmlElement(name = "ExportationTransportEvent")
    protected TransportEventType exportationTransportEvent;
    @XmlElement(name = "DischargeTransportEvent")
    protected TransportEventType dischargeTransportEvent;
    @XmlElement(name = "WarehousingTransportEvent")
    protected TransportEventType warehousingTransportEvent;
    @XmlElement(name = "TakeoverTransportEvent")
    protected TransportEventType takeoverTransportEvent;
    @XmlElement(name = "OptionalTakeoverTransportEvent")
    protected TransportEventType optionalTakeoverTransportEvent;
    @XmlElement(name = "DropoffTransportEvent")
    protected TransportEventType dropoffTransportEvent;
    @XmlElement(name = "ActualPickupTransportEvent")
    protected TransportEventType actualPickupTransportEvent;
    @XmlElement(name = "DeliveryTransportEvent")
    protected TransportEventType deliveryTransportEvent;
    @XmlElement(name = "ReceiptTransportEvent")
    protected TransportEventType receiptTransportEvent;
    @XmlElement(name = "StorageTransportEvent")
    protected TransportEventType storageTransportEvent;
    @XmlElement(name = "AcceptanceTransportEvent")
    protected TransportEventType acceptanceTransportEvent;
    @XmlElement(name = "TerminalOperatorParty")
    protected PartyType terminalOperatorParty;
    @XmlElement(name = "CustomsAgentParty")
    protected PartyType customsAgentParty;
    @XmlElement(name = "EstimatedTransitPeriod")
    protected PeriodType estimatedTransitPeriod;
    @XmlElement(name = "FreightAllowanceCharge")
    protected List<AllowanceChargeType> freightAllowanceCharge;
    @XmlElement(name = "FreightChargeLocation")
    protected LocationType freightChargeLocation;
    @XmlElement(name = "DetentionTransportEvent")
    protected List<TransportEventType> detentionTransportEvent;
    @XmlElement(name = "RequestedDepartureTransportEvent")
    protected TransportEventType requestedDepartureTransportEvent;
    @XmlElement(name = "RequestedArrivalTransportEvent")
    protected TransportEventType requestedArrivalTransportEvent;
    @XmlElement(name = "RequestedWaypointTransportEvent")
    protected List<TransportEventType> requestedWaypointTransportEvent;
    @XmlElement(name = "PlannedDepartureTransportEvent")
    protected TransportEventType plannedDepartureTransportEvent;
    @XmlElement(name = "PlannedArrivalTransportEvent")
    protected TransportEventType plannedArrivalTransportEvent;
    @XmlElement(name = "PlannedWaypointTransportEvent")
    protected List<TransportEventType> plannedWaypointTransportEvent;
    @XmlElement(name = "ActualDepartureTransportEvent")
    protected TransportEventType actualDepartureTransportEvent;
    @XmlElement(name = "ActualWaypointTransportEvent")
    protected TransportEventType actualWaypointTransportEvent;
    @XmlElement(name = "ActualArrivalTransportEvent")
    protected TransportEventType actualArrivalTransportEvent;
    @XmlElement(name = "TransportEvent")
    protected List<TransportEventType> transportEvent;
    @XmlElement(name = "EstimatedDepartureTransportEvent")
    protected TransportEventType estimatedDepartureTransportEvent;
    @XmlElement(name = "EstimatedArrivalTransportEvent")
    protected TransportEventType estimatedArrivalTransportEvent;
    @XmlElement(name = "PassengerPerson")
    protected List<PersonType> passengerPerson;
    @XmlElement(name = "DriverPerson")
    protected List<PersonType> driverPerson;
    @XmlElement(name = "ReportingPerson")
    protected PersonType reportingPerson;
    @XmlElement(name = "CrewMemberPerson")
    protected List<PersonType> crewMemberPerson;
    @XmlElement(name = "SecurityOfficerPerson")
    protected PersonType securityOfficerPerson;
    @XmlElement(name = "MasterPerson")
    protected PersonType masterPerson;
    @XmlElement(name = "ShipsSurgeonPerson")
    protected PersonType shipsSurgeonPerson;

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
     * Ruft den Wert der transportModeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportModeCodeType }
     *     
     */
    public TransportModeCodeType getTransportModeCode() {
        return transportModeCode;
    }

    /**
     * Legt den Wert der transportModeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportModeCodeType }
     *     
     */
    public void setTransportModeCode(TransportModeCodeType value) {
        this.transportModeCode = value;
    }

    /**
     * Ruft den Wert der transportMeansTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public TransportMeansTypeCodeType getTransportMeansTypeCode() {
        return transportMeansTypeCode;
    }

    /**
     * Legt den Wert der transportMeansTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public void setTransportMeansTypeCode(TransportMeansTypeCodeType value) {
        this.transportMeansTypeCode = value;
    }

    /**
     * Ruft den Wert der transitDirectionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransitDirectionCodeType }
     *     
     */
    public TransitDirectionCodeType getTransitDirectionCode() {
        return transitDirectionCode;
    }

    /**
     * Legt den Wert der transitDirectionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitDirectionCodeType }
     *     
     */
    public void setTransitDirectionCode(TransitDirectionCodeType value) {
        this.transitDirectionCode = value;
    }

    /**
     * Ruft den Wert der preCarriageIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PreCarriageIndicatorType }
     *     
     */
    public PreCarriageIndicatorType getPreCarriageIndicator() {
        return preCarriageIndicator;
    }

    /**
     * Legt den Wert der preCarriageIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PreCarriageIndicatorType }
     *     
     */
    public void setPreCarriageIndicator(PreCarriageIndicatorType value) {
        this.preCarriageIndicator = value;
    }

    /**
     * Ruft den Wert der onCarriageIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OnCarriageIndicatorType }
     *     
     */
    public OnCarriageIndicatorType getOnCarriageIndicator() {
        return onCarriageIndicator;
    }

    /**
     * Legt den Wert der onCarriageIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OnCarriageIndicatorType }
     *     
     */
    public void setOnCarriageIndicator(OnCarriageIndicatorType value) {
        this.onCarriageIndicator = value;
    }

    /**
     * Ruft den Wert der estimatedDeliveryDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EstimatedDeliveryDateType }
     *     
     */
    public EstimatedDeliveryDateType getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    /**
     * Legt den Wert der estimatedDeliveryDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedDeliveryDateType }
     *     
     */
    public void setEstimatedDeliveryDate(EstimatedDeliveryDateType value) {
        this.estimatedDeliveryDate = value;
    }

    /**
     * Ruft den Wert der estimatedDeliveryTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EstimatedDeliveryTimeType }
     *     
     */
    public EstimatedDeliveryTimeType getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    /**
     * Legt den Wert der estimatedDeliveryTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedDeliveryTimeType }
     *     
     */
    public void setEstimatedDeliveryTime(EstimatedDeliveryTimeType value) {
        this.estimatedDeliveryTime = value;
    }

    /**
     * Ruft den Wert der requiredDeliveryDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequiredDeliveryDateType }
     *     
     */
    public RequiredDeliveryDateType getRequiredDeliveryDate() {
        return requiredDeliveryDate;
    }

    /**
     * Legt den Wert der requiredDeliveryDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredDeliveryDateType }
     *     
     */
    public void setRequiredDeliveryDate(RequiredDeliveryDateType value) {
        this.requiredDeliveryDate = value;
    }

    /**
     * Ruft den Wert der requiredDeliveryTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequiredDeliveryTimeType }
     *     
     */
    public RequiredDeliveryTimeType getRequiredDeliveryTime() {
        return requiredDeliveryTime;
    }

    /**
     * Legt den Wert der requiredDeliveryTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredDeliveryTimeType }
     *     
     */
    public void setRequiredDeliveryTime(RequiredDeliveryTimeType value) {
        this.requiredDeliveryTime = value;
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
     * Ruft den Wert der successiveSequenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SuccessiveSequenceIDType }
     *     
     */
    public SuccessiveSequenceIDType getSuccessiveSequenceID() {
        return successiveSequenceID;
    }

    /**
     * Legt den Wert der successiveSequenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SuccessiveSequenceIDType }
     *     
     */
    public void setSuccessiveSequenceID(SuccessiveSequenceIDType value) {
        this.successiveSequenceID = value;
    }

    /**
     * Gets the value of the instructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstructionsType }
     * 
     * 
     */
    public List<InstructionsType> getInstructions() {
        if (instructions == null) {
            instructions = new ArrayList<InstructionsType>();
        }
        return this.instructions;
    }

    /**
     * Gets the value of the demurrageInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the demurrageInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDemurrageInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DemurrageInstructionsType }
     * 
     * 
     */
    public List<DemurrageInstructionsType> getDemurrageInstructions() {
        if (demurrageInstructions == null) {
            demurrageInstructions = new ArrayList<DemurrageInstructionsType>();
        }
        return this.demurrageInstructions;
    }

    /**
     * Ruft den Wert der crewQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CrewQuantityType }
     *     
     */
    public CrewQuantityType getCrewQuantity() {
        return crewQuantity;
    }

    /**
     * Legt den Wert der crewQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CrewQuantityType }
     *     
     */
    public void setCrewQuantity(CrewQuantityType value) {
        this.crewQuantity = value;
    }

    /**
     * Ruft den Wert der passengerQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PassengerQuantityType }
     *     
     */
    public PassengerQuantityType getPassengerQuantity() {
        return passengerQuantity;
    }

    /**
     * Legt den Wert der passengerQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PassengerQuantityType }
     *     
     */
    public void setPassengerQuantity(PassengerQuantityType value) {
        this.passengerQuantity = value;
    }

    /**
     * Ruft den Wert der transitPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getTransitPeriod() {
        return transitPeriod;
    }

    /**
     * Legt den Wert der transitPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setTransitPeriod(PeriodType value) {
        this.transitPeriod = value;
    }

    /**
     * Gets the value of the carrierParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the carrierParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCarrierParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getCarrierParty() {
        if (carrierParty == null) {
            carrierParty = new ArrayList<PartyType>();
        }
        return this.carrierParty;
    }

    /**
     * Ruft den Wert der transportMeans-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansType }
     *     
     */
    public TransportMeansType getTransportMeans() {
        return transportMeans;
    }

    /**
     * Legt den Wert der transportMeans-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansType }
     *     
     */
    public void setTransportMeans(TransportMeansType value) {
        this.transportMeans = value;
    }

    /**
     * Ruft den Wert der loadingPortLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLoadingPortLocation() {
        return loadingPortLocation;
    }

    /**
     * Legt den Wert der loadingPortLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLoadingPortLocation(LocationType value) {
        this.loadingPortLocation = value;
    }

    /**
     * Ruft den Wert der unloadingPortLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getUnloadingPortLocation() {
        return unloadingPortLocation;
    }

    /**
     * Legt den Wert der unloadingPortLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setUnloadingPortLocation(LocationType value) {
        this.unloadingPortLocation = value;
    }

    /**
     * Ruft den Wert der transshipPortLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getTransshipPortLocation() {
        return transshipPortLocation;
    }

    /**
     * Legt den Wert der transshipPortLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setTransshipPortLocation(LocationType value) {
        this.transshipPortLocation = value;
    }

    /**
     * Ruft den Wert der loadingTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getLoadingTransportEvent() {
        return loadingTransportEvent;
    }

    /**
     * Legt den Wert der loadingTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setLoadingTransportEvent(TransportEventType value) {
        this.loadingTransportEvent = value;
    }

    /**
     * Ruft den Wert der examinationTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getExaminationTransportEvent() {
        return examinationTransportEvent;
    }

    /**
     * Legt den Wert der examinationTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setExaminationTransportEvent(TransportEventType value) {
        this.examinationTransportEvent = value;
    }

    /**
     * Ruft den Wert der availabilityTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getAvailabilityTransportEvent() {
        return availabilityTransportEvent;
    }

    /**
     * Legt den Wert der availabilityTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setAvailabilityTransportEvent(TransportEventType value) {
        this.availabilityTransportEvent = value;
    }

    /**
     * Ruft den Wert der exportationTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getExportationTransportEvent() {
        return exportationTransportEvent;
    }

    /**
     * Legt den Wert der exportationTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setExportationTransportEvent(TransportEventType value) {
        this.exportationTransportEvent = value;
    }

    /**
     * Ruft den Wert der dischargeTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getDischargeTransportEvent() {
        return dischargeTransportEvent;
    }

    /**
     * Legt den Wert der dischargeTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setDischargeTransportEvent(TransportEventType value) {
        this.dischargeTransportEvent = value;
    }

    /**
     * Ruft den Wert der warehousingTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getWarehousingTransportEvent() {
        return warehousingTransportEvent;
    }

    /**
     * Legt den Wert der warehousingTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setWarehousingTransportEvent(TransportEventType value) {
        this.warehousingTransportEvent = value;
    }

    /**
     * Ruft den Wert der takeoverTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getTakeoverTransportEvent() {
        return takeoverTransportEvent;
    }

    /**
     * Legt den Wert der takeoverTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setTakeoverTransportEvent(TransportEventType value) {
        this.takeoverTransportEvent = value;
    }

    /**
     * Ruft den Wert der optionalTakeoverTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getOptionalTakeoverTransportEvent() {
        return optionalTakeoverTransportEvent;
    }

    /**
     * Legt den Wert der optionalTakeoverTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setOptionalTakeoverTransportEvent(TransportEventType value) {
        this.optionalTakeoverTransportEvent = value;
    }

    /**
     * Ruft den Wert der dropoffTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getDropoffTransportEvent() {
        return dropoffTransportEvent;
    }

    /**
     * Legt den Wert der dropoffTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setDropoffTransportEvent(TransportEventType value) {
        this.dropoffTransportEvent = value;
    }

    /**
     * Ruft den Wert der actualPickupTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getActualPickupTransportEvent() {
        return actualPickupTransportEvent;
    }

    /**
     * Legt den Wert der actualPickupTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setActualPickupTransportEvent(TransportEventType value) {
        this.actualPickupTransportEvent = value;
    }

    /**
     * Ruft den Wert der deliveryTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getDeliveryTransportEvent() {
        return deliveryTransportEvent;
    }

    /**
     * Legt den Wert der deliveryTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setDeliveryTransportEvent(TransportEventType value) {
        this.deliveryTransportEvent = value;
    }

    /**
     * Ruft den Wert der receiptTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getReceiptTransportEvent() {
        return receiptTransportEvent;
    }

    /**
     * Legt den Wert der receiptTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setReceiptTransportEvent(TransportEventType value) {
        this.receiptTransportEvent = value;
    }

    /**
     * Ruft den Wert der storageTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getStorageTransportEvent() {
        return storageTransportEvent;
    }

    /**
     * Legt den Wert der storageTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setStorageTransportEvent(TransportEventType value) {
        this.storageTransportEvent = value;
    }

    /**
     * Ruft den Wert der acceptanceTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getAcceptanceTransportEvent() {
        return acceptanceTransportEvent;
    }

    /**
     * Legt den Wert der acceptanceTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setAcceptanceTransportEvent(TransportEventType value) {
        this.acceptanceTransportEvent = value;
    }

    /**
     * Ruft den Wert der terminalOperatorParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTerminalOperatorParty() {
        return terminalOperatorParty;
    }

    /**
     * Legt den Wert der terminalOperatorParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTerminalOperatorParty(PartyType value) {
        this.terminalOperatorParty = value;
    }

    /**
     * Ruft den Wert der customsAgentParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getCustomsAgentParty() {
        return customsAgentParty;
    }

    /**
     * Legt den Wert der customsAgentParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setCustomsAgentParty(PartyType value) {
        this.customsAgentParty = value;
    }

    /**
     * Ruft den Wert der estimatedTransitPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getEstimatedTransitPeriod() {
        return estimatedTransitPeriod;
    }

    /**
     * Legt den Wert der estimatedTransitPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setEstimatedTransitPeriod(PeriodType value) {
        this.estimatedTransitPeriod = value;
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
     * Ruft den Wert der freightChargeLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getFreightChargeLocation() {
        return freightChargeLocation;
    }

    /**
     * Legt den Wert der freightChargeLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setFreightChargeLocation(LocationType value) {
        this.freightChargeLocation = value;
    }

    /**
     * Gets the value of the detentionTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detentionTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetentionTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getDetentionTransportEvent() {
        if (detentionTransportEvent == null) {
            detentionTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.detentionTransportEvent;
    }

    /**
     * Ruft den Wert der requestedDepartureTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getRequestedDepartureTransportEvent() {
        return requestedDepartureTransportEvent;
    }

    /**
     * Legt den Wert der requestedDepartureTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setRequestedDepartureTransportEvent(TransportEventType value) {
        this.requestedDepartureTransportEvent = value;
    }

    /**
     * Ruft den Wert der requestedArrivalTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getRequestedArrivalTransportEvent() {
        return requestedArrivalTransportEvent;
    }

    /**
     * Legt den Wert der requestedArrivalTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setRequestedArrivalTransportEvent(TransportEventType value) {
        this.requestedArrivalTransportEvent = value;
    }

    /**
     * Gets the value of the requestedWaypointTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestedWaypointTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestedWaypointTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getRequestedWaypointTransportEvent() {
        if (requestedWaypointTransportEvent == null) {
            requestedWaypointTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.requestedWaypointTransportEvent;
    }

    /**
     * Ruft den Wert der plannedDepartureTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getPlannedDepartureTransportEvent() {
        return plannedDepartureTransportEvent;
    }

    /**
     * Legt den Wert der plannedDepartureTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setPlannedDepartureTransportEvent(TransportEventType value) {
        this.plannedDepartureTransportEvent = value;
    }

    /**
     * Ruft den Wert der plannedArrivalTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getPlannedArrivalTransportEvent() {
        return plannedArrivalTransportEvent;
    }

    /**
     * Legt den Wert der plannedArrivalTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setPlannedArrivalTransportEvent(TransportEventType value) {
        this.plannedArrivalTransportEvent = value;
    }

    /**
     * Gets the value of the plannedWaypointTransportEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plannedWaypointTransportEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlannedWaypointTransportEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEventType }
     * 
     * 
     */
    public List<TransportEventType> getPlannedWaypointTransportEvent() {
        if (plannedWaypointTransportEvent == null) {
            plannedWaypointTransportEvent = new ArrayList<TransportEventType>();
        }
        return this.plannedWaypointTransportEvent;
    }

    /**
     * Ruft den Wert der actualDepartureTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getActualDepartureTransportEvent() {
        return actualDepartureTransportEvent;
    }

    /**
     * Legt den Wert der actualDepartureTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setActualDepartureTransportEvent(TransportEventType value) {
        this.actualDepartureTransportEvent = value;
    }

    /**
     * Ruft den Wert der actualWaypointTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getActualWaypointTransportEvent() {
        return actualWaypointTransportEvent;
    }

    /**
     * Legt den Wert der actualWaypointTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setActualWaypointTransportEvent(TransportEventType value) {
        this.actualWaypointTransportEvent = value;
    }

    /**
     * Ruft den Wert der actualArrivalTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getActualArrivalTransportEvent() {
        return actualArrivalTransportEvent;
    }

    /**
     * Legt den Wert der actualArrivalTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setActualArrivalTransportEvent(TransportEventType value) {
        this.actualArrivalTransportEvent = value;
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
     * Ruft den Wert der estimatedDepartureTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getEstimatedDepartureTransportEvent() {
        return estimatedDepartureTransportEvent;
    }

    /**
     * Legt den Wert der estimatedDepartureTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setEstimatedDepartureTransportEvent(TransportEventType value) {
        this.estimatedDepartureTransportEvent = value;
    }

    /**
     * Ruft den Wert der estimatedArrivalTransportEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEventType }
     *     
     */
    public TransportEventType getEstimatedArrivalTransportEvent() {
        return estimatedArrivalTransportEvent;
    }

    /**
     * Legt den Wert der estimatedArrivalTransportEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEventType }
     *     
     */
    public void setEstimatedArrivalTransportEvent(TransportEventType value) {
        this.estimatedArrivalTransportEvent = value;
    }

    /**
     * Gets the value of the passengerPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the passengerPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPassengerPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getPassengerPerson() {
        if (passengerPerson == null) {
            passengerPerson = new ArrayList<PersonType>();
        }
        return this.passengerPerson;
    }

    /**
     * Gets the value of the driverPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the driverPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDriverPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getDriverPerson() {
        if (driverPerson == null) {
            driverPerson = new ArrayList<PersonType>();
        }
        return this.driverPerson;
    }

    /**
     * Ruft den Wert der reportingPerson-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getReportingPerson() {
        return reportingPerson;
    }

    /**
     * Legt den Wert der reportingPerson-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setReportingPerson(PersonType value) {
        this.reportingPerson = value;
    }

    /**
     * Gets the value of the crewMemberPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crewMemberPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrewMemberPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getCrewMemberPerson() {
        if (crewMemberPerson == null) {
            crewMemberPerson = new ArrayList<PersonType>();
        }
        return this.crewMemberPerson;
    }

    /**
     * Ruft den Wert der securityOfficerPerson-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getSecurityOfficerPerson() {
        return securityOfficerPerson;
    }

    /**
     * Legt den Wert der securityOfficerPerson-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setSecurityOfficerPerson(PersonType value) {
        this.securityOfficerPerson = value;
    }

    /**
     * Ruft den Wert der masterPerson-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getMasterPerson() {
        return masterPerson;
    }

    /**
     * Legt den Wert der masterPerson-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setMasterPerson(PersonType value) {
        this.masterPerson = value;
    }

    /**
     * Ruft den Wert der shipsSurgeonPerson-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getShipsSurgeonPerson() {
        return shipsSurgeonPerson;
    }

    /**
     * Legt den Wert der shipsSurgeonPerson-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setShipsSurgeonPerson(PersonType value) {
        this.shipsSurgeonPerson = value;
    }

}
