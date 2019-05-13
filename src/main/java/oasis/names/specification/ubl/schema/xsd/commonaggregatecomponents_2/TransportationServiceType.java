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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreightRateClassCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriorityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TariffClassCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportServiceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportationServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportationServiceDetailsURIType;


/**
 * <p>Java-Klasse für TransportationServiceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportationServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportServiceCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TariffClassCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Priority" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FreightRateClassCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportationServiceDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportationServiceDetailsURI" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NominationDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NominationTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEquipment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupportedTransportEquipment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UnsupportedTransportEquipment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CommodityClassification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupportedCommodityClassification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UnsupportedCommodityClassification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TotalCapacityDimension" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShipmentStage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportEvent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ResponsibleTransportServiceProviderParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnvironmentalEmission" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EstimatedDurationPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ScheduledServiceFrequency" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportationServiceType", propOrder = {
    "transportServiceCode",
    "tariffClassCode",
    "priority",
    "freightRateClassCode",
    "transportationServiceDescription",
    "transportationServiceDetailsURI",
    "nominationDate",
    "nominationTime",
    "name",
    "sequenceNumeric",
    "transportEquipment",
    "supportedTransportEquipment",
    "unsupportedTransportEquipment",
    "commodityClassification",
    "supportedCommodityClassification",
    "unsupportedCommodityClassification",
    "totalCapacityDimension",
    "shipmentStage",
    "transportEvent",
    "responsibleTransportServiceProviderParty",
    "environmentalEmission",
    "estimatedDurationPeriod",
    "scheduledServiceFrequency"
})
public class TransportationServiceType {

    @XmlElement(name = "TransportServiceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TransportServiceCodeType transportServiceCode;
    @XmlElement(name = "TariffClassCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TariffClassCodeType tariffClassCode;
    @XmlElement(name = "Priority", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriorityType priority;
    @XmlElement(name = "FreightRateClassCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FreightRateClassCodeType freightRateClassCode;
    @XmlElement(name = "TransportationServiceDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TransportationServiceDescriptionType> transportationServiceDescription;
    @XmlElement(name = "TransportationServiceDetailsURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportationServiceDetailsURIType transportationServiceDetailsURI;
    @XmlElement(name = "NominationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NominationDateType nominationDate;
    @XmlElement(name = "NominationTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NominationTimeType nominationTime;
    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameType name;
    @XmlElement(name = "SequenceNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SequenceNumericType sequenceNumeric;
    @XmlElement(name = "TransportEquipment")
    protected List<TransportEquipmentType> transportEquipment;
    @XmlElement(name = "SupportedTransportEquipment")
    protected List<TransportEquipmentType> supportedTransportEquipment;
    @XmlElement(name = "UnsupportedTransportEquipment")
    protected List<TransportEquipmentType> unsupportedTransportEquipment;
    @XmlElement(name = "CommodityClassification")
    protected List<CommodityClassificationType> commodityClassification;
    @XmlElement(name = "SupportedCommodityClassification")
    protected List<CommodityClassificationType> supportedCommodityClassification;
    @XmlElement(name = "UnsupportedCommodityClassification")
    protected List<CommodityClassificationType> unsupportedCommodityClassification;
    @XmlElement(name = "TotalCapacityDimension")
    protected DimensionType totalCapacityDimension;
    @XmlElement(name = "ShipmentStage")
    protected List<ShipmentStageType> shipmentStage;
    @XmlElement(name = "TransportEvent")
    protected List<TransportEventType> transportEvent;
    @XmlElement(name = "ResponsibleTransportServiceProviderParty")
    protected PartyType responsibleTransportServiceProviderParty;
    @XmlElement(name = "EnvironmentalEmission")
    protected List<EnvironmentalEmissionType> environmentalEmission;
    @XmlElement(name = "EstimatedDurationPeriod")
    protected PeriodType estimatedDurationPeriod;
    @XmlElement(name = "ScheduledServiceFrequency")
    protected List<ServiceFrequencyType> scheduledServiceFrequency;

    /**
     * Ruft den Wert der transportServiceCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportServiceCodeType }
     *     
     */
    public TransportServiceCodeType getTransportServiceCode() {
        return transportServiceCode;
    }

    /**
     * Legt den Wert der transportServiceCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportServiceCodeType }
     *     
     */
    public void setTransportServiceCode(TransportServiceCodeType value) {
        this.transportServiceCode = value;
    }

    /**
     * Ruft den Wert der tariffClassCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TariffClassCodeType }
     *     
     */
    public TariffClassCodeType getTariffClassCode() {
        return tariffClassCode;
    }

    /**
     * Legt den Wert der tariffClassCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffClassCodeType }
     *     
     */
    public void setTariffClassCode(TariffClassCodeType value) {
        this.tariffClassCode = value;
    }

    /**
     * Ruft den Wert der priority-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriorityType }
     *     
     */
    public PriorityType getPriority() {
        return priority;
    }

    /**
     * Legt den Wert der priority-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriorityType }
     *     
     */
    public void setPriority(PriorityType value) {
        this.priority = value;
    }

    /**
     * Ruft den Wert der freightRateClassCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FreightRateClassCodeType }
     *     
     */
    public FreightRateClassCodeType getFreightRateClassCode() {
        return freightRateClassCode;
    }

    /**
     * Legt den Wert der freightRateClassCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightRateClassCodeType }
     *     
     */
    public void setFreightRateClassCode(FreightRateClassCodeType value) {
        this.freightRateClassCode = value;
    }

    /**
     * Gets the value of the transportationServiceDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportationServiceDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportationServiceDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportationServiceDescriptionType }
     * 
     * 
     */
    public List<TransportationServiceDescriptionType> getTransportationServiceDescription() {
        if (transportationServiceDescription == null) {
            transportationServiceDescription = new ArrayList<TransportationServiceDescriptionType>();
        }
        return this.transportationServiceDescription;
    }

    /**
     * Ruft den Wert der transportationServiceDetailsURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceDetailsURIType }
     *     
     */
    public TransportationServiceDetailsURIType getTransportationServiceDetailsURI() {
        return transportationServiceDetailsURI;
    }

    /**
     * Legt den Wert der transportationServiceDetailsURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceDetailsURIType }
     *     
     */
    public void setTransportationServiceDetailsURI(TransportationServiceDetailsURIType value) {
        this.transportationServiceDetailsURI = value;
    }

    /**
     * Ruft den Wert der nominationDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NominationDateType }
     *     
     */
    public NominationDateType getNominationDate() {
        return nominationDate;
    }

    /**
     * Legt den Wert der nominationDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NominationDateType }
     *     
     */
    public void setNominationDate(NominationDateType value) {
        this.nominationDate = value;
    }

    /**
     * Ruft den Wert der nominationTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NominationTimeType }
     *     
     */
    public NominationTimeType getNominationTime() {
        return nominationTime;
    }

    /**
     * Legt den Wert der nominationTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NominationTimeType }
     *     
     */
    public void setNominationTime(NominationTimeType value) {
        this.nominationTime = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setName(NameType value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der sequenceNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SequenceNumericType }
     *     
     */
    public SequenceNumericType getSequenceNumeric() {
        return sequenceNumeric;
    }

    /**
     * Legt den Wert der sequenceNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceNumericType }
     *     
     */
    public void setSequenceNumeric(SequenceNumericType value) {
        this.sequenceNumeric = value;
    }

    /**
     * Gets the value of the transportEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentType }
     * 
     * 
     */
    public List<TransportEquipmentType> getTransportEquipment() {
        if (transportEquipment == null) {
            transportEquipment = new ArrayList<TransportEquipmentType>();
        }
        return this.transportEquipment;
    }

    /**
     * Gets the value of the supportedTransportEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedTransportEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedTransportEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentType }
     * 
     * 
     */
    public List<TransportEquipmentType> getSupportedTransportEquipment() {
        if (supportedTransportEquipment == null) {
            supportedTransportEquipment = new ArrayList<TransportEquipmentType>();
        }
        return this.supportedTransportEquipment;
    }

    /**
     * Gets the value of the unsupportedTransportEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unsupportedTransportEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnsupportedTransportEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportEquipmentType }
     * 
     * 
     */
    public List<TransportEquipmentType> getUnsupportedTransportEquipment() {
        if (unsupportedTransportEquipment == null) {
            unsupportedTransportEquipment = new ArrayList<TransportEquipmentType>();
        }
        return this.unsupportedTransportEquipment;
    }

    /**
     * Gets the value of the commodityClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commodityClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommodityClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityClassificationType }
     * 
     * 
     */
    public List<CommodityClassificationType> getCommodityClassification() {
        if (commodityClassification == null) {
            commodityClassification = new ArrayList<CommodityClassificationType>();
        }
        return this.commodityClassification;
    }

    /**
     * Gets the value of the supportedCommodityClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedCommodityClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedCommodityClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityClassificationType }
     * 
     * 
     */
    public List<CommodityClassificationType> getSupportedCommodityClassification() {
        if (supportedCommodityClassification == null) {
            supportedCommodityClassification = new ArrayList<CommodityClassificationType>();
        }
        return this.supportedCommodityClassification;
    }

    /**
     * Gets the value of the unsupportedCommodityClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unsupportedCommodityClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnsupportedCommodityClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityClassificationType }
     * 
     * 
     */
    public List<CommodityClassificationType> getUnsupportedCommodityClassification() {
        if (unsupportedCommodityClassification == null) {
            unsupportedCommodityClassification = new ArrayList<CommodityClassificationType>();
        }
        return this.unsupportedCommodityClassification;
    }

    /**
     * Ruft den Wert der totalCapacityDimension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DimensionType }
     *     
     */
    public DimensionType getTotalCapacityDimension() {
        return totalCapacityDimension;
    }

    /**
     * Legt den Wert der totalCapacityDimension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionType }
     *     
     */
    public void setTotalCapacityDimension(DimensionType value) {
        this.totalCapacityDimension = value;
    }

    /**
     * Gets the value of the shipmentStage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentStage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentStage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentStageType }
     * 
     * 
     */
    public List<ShipmentStageType> getShipmentStage() {
        if (shipmentStage == null) {
            shipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.shipmentStage;
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
     * Ruft den Wert der responsibleTransportServiceProviderParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getResponsibleTransportServiceProviderParty() {
        return responsibleTransportServiceProviderParty;
    }

    /**
     * Legt den Wert der responsibleTransportServiceProviderParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setResponsibleTransportServiceProviderParty(PartyType value) {
        this.responsibleTransportServiceProviderParty = value;
    }

    /**
     * Gets the value of the environmentalEmission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the environmentalEmission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvironmentalEmission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvironmentalEmissionType }
     * 
     * 
     */
    public List<EnvironmentalEmissionType> getEnvironmentalEmission() {
        if (environmentalEmission == null) {
            environmentalEmission = new ArrayList<EnvironmentalEmissionType>();
        }
        return this.environmentalEmission;
    }

    /**
     * Ruft den Wert der estimatedDurationPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getEstimatedDurationPeriod() {
        return estimatedDurationPeriod;
    }

    /**
     * Legt den Wert der estimatedDurationPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setEstimatedDurationPeriod(PeriodType value) {
        this.estimatedDurationPeriod = value;
    }

    /**
     * Gets the value of the scheduledServiceFrequency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scheduledServiceFrequency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScheduledServiceFrequency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceFrequencyType }
     * 
     * 
     */
    public List<ServiceFrequencyType> getScheduledServiceFrequency() {
        if (scheduledServiceFrequency == null) {
            scheduledServiceFrequency = new ArrayList<ServiceFrequencyType>();
        }
        return this.scheduledServiceFrequency;
    }

}
