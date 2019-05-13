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
import un.unece.uncefact.data.standard.qualifieddatatype._100.WeightUnitMeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;


/**
 * <p>Java-Klasse für LineTradeDeliveryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LineTradeDeliveryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestedQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="ReceivedQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="BilledQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="ChargeFreeQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="PackageQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="ProductUnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="PerPackageUnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="NetWeightMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}WeightUnitMeasureType" minOccurs="0"/>
 *         &lt;element name="GrossWeightMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}WeightUnitMeasureType" minOccurs="0"/>
 *         &lt;element name="TheoreticalWeightMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}WeightUnitMeasureType" minOccurs="0"/>
 *         &lt;element name="DespatchedQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="SpecifiedDeliveryAdjustment" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DeliveryAdjustmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IncludedSupplyChainPackaging" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainPackagingType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RelatedSupplyChainConsignment" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainConsignmentType" minOccurs="0"/>
 *         &lt;element name="ShipToTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="UltimateShipToTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="ShipFromTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="ActualDespatchSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="ActualPickUpSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="RequestedDeliverySupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="ActualDeliverySupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="ActualReceiptSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="AdditionalReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DespatchAdviceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="ReceivingAdviceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="DeliveryNoteReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="ConsumptionReportReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="PackingListReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineTradeDeliveryType", propOrder = {
    "requestedQuantity",
    "receivedQuantity",
    "billedQuantity",
    "chargeFreeQuantity",
    "packageQuantity",
    "productUnitQuantity",
    "perPackageUnitQuantity",
    "netWeightMeasure",
    "grossWeightMeasure",
    "theoreticalWeightMeasure",
    "despatchedQuantity",
    "specifiedDeliveryAdjustment",
    "includedSupplyChainPackaging",
    "relatedSupplyChainConsignment",
    "shipToTradeParty",
    "ultimateShipToTradeParty",
    "shipFromTradeParty",
    "actualDespatchSupplyChainEvent",
    "actualPickUpSupplyChainEvent",
    "requestedDeliverySupplyChainEvent",
    "actualDeliverySupplyChainEvent",
    "actualReceiptSupplyChainEvent",
    "additionalReferencedDocument",
    "despatchAdviceReferencedDocument",
    "receivingAdviceReferencedDocument",
    "deliveryNoteReferencedDocument",
    "consumptionReportReferencedDocument",
    "packingListReferencedDocument"
})
public class LineTradeDeliveryType {

    @XmlElement(name = "RequestedQuantity")
    protected QuantityType requestedQuantity;
    @XmlElement(name = "ReceivedQuantity")
    protected QuantityType receivedQuantity;
    @XmlElement(name = "BilledQuantity")
    protected QuantityType billedQuantity;
    @XmlElement(name = "ChargeFreeQuantity")
    protected QuantityType chargeFreeQuantity;
    @XmlElement(name = "PackageQuantity")
    protected QuantityType packageQuantity;
    @XmlElement(name = "ProductUnitQuantity")
    protected QuantityType productUnitQuantity;
    @XmlElement(name = "PerPackageUnitQuantity")
    protected QuantityType perPackageUnitQuantity;
    @XmlElement(name = "NetWeightMeasure")
    protected WeightUnitMeasureType netWeightMeasure;
    @XmlElement(name = "GrossWeightMeasure")
    protected WeightUnitMeasureType grossWeightMeasure;
    @XmlElement(name = "TheoreticalWeightMeasure")
    protected WeightUnitMeasureType theoreticalWeightMeasure;
    @XmlElement(name = "DespatchedQuantity")
    protected QuantityType despatchedQuantity;
    @XmlElement(name = "SpecifiedDeliveryAdjustment")
    protected List<DeliveryAdjustmentType> specifiedDeliveryAdjustment;
    @XmlElement(name = "IncludedSupplyChainPackaging")
    protected List<SupplyChainPackagingType> includedSupplyChainPackaging;
    @XmlElement(name = "RelatedSupplyChainConsignment")
    protected SupplyChainConsignmentType relatedSupplyChainConsignment;
    @XmlElement(name = "ShipToTradeParty")
    protected TradePartyType shipToTradeParty;
    @XmlElement(name = "UltimateShipToTradeParty")
    protected TradePartyType ultimateShipToTradeParty;
    @XmlElement(name = "ShipFromTradeParty")
    protected TradePartyType shipFromTradeParty;
    @XmlElement(name = "ActualDespatchSupplyChainEvent")
    protected SupplyChainEventType actualDespatchSupplyChainEvent;
    @XmlElement(name = "ActualPickUpSupplyChainEvent")
    protected SupplyChainEventType actualPickUpSupplyChainEvent;
    @XmlElement(name = "RequestedDeliverySupplyChainEvent")
    protected SupplyChainEventType requestedDeliverySupplyChainEvent;
    @XmlElement(name = "ActualDeliverySupplyChainEvent")
    protected SupplyChainEventType actualDeliverySupplyChainEvent;
    @XmlElement(name = "ActualReceiptSupplyChainEvent")
    protected SupplyChainEventType actualReceiptSupplyChainEvent;
    @XmlElement(name = "AdditionalReferencedDocument")
    protected List<ReferencedDocumentType> additionalReferencedDocument;
    @XmlElement(name = "DespatchAdviceReferencedDocument")
    protected ReferencedDocumentType despatchAdviceReferencedDocument;
    @XmlElement(name = "ReceivingAdviceReferencedDocument")
    protected ReferencedDocumentType receivingAdviceReferencedDocument;
    @XmlElement(name = "DeliveryNoteReferencedDocument")
    protected ReferencedDocumentType deliveryNoteReferencedDocument;
    @XmlElement(name = "ConsumptionReportReferencedDocument")
    protected ReferencedDocumentType consumptionReportReferencedDocument;
    @XmlElement(name = "PackingListReferencedDocument")
    protected ReferencedDocumentType packingListReferencedDocument;

    /**
     * Ruft den Wert der requestedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getRequestedQuantity() {
        return requestedQuantity;
    }

    /**
     * Legt den Wert der requestedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setRequestedQuantity(QuantityType value) {
        this.requestedQuantity = value;
    }

    /**
     * Ruft den Wert der receivedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getReceivedQuantity() {
        return receivedQuantity;
    }

    /**
     * Legt den Wert der receivedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setReceivedQuantity(QuantityType value) {
        this.receivedQuantity = value;
    }

    /**
     * Ruft den Wert der billedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getBilledQuantity() {
        return billedQuantity;
    }

    /**
     * Legt den Wert der billedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setBilledQuantity(QuantityType value) {
        this.billedQuantity = value;
    }

    /**
     * Ruft den Wert der chargeFreeQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getChargeFreeQuantity() {
        return chargeFreeQuantity;
    }

    /**
     * Legt den Wert der chargeFreeQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setChargeFreeQuantity(QuantityType value) {
        this.chargeFreeQuantity = value;
    }

    /**
     * Ruft den Wert der packageQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * Legt den Wert der packageQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setPackageQuantity(QuantityType value) {
        this.packageQuantity = value;
    }

    /**
     * Ruft den Wert der productUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getProductUnitQuantity() {
        return productUnitQuantity;
    }

    /**
     * Legt den Wert der productUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setProductUnitQuantity(QuantityType value) {
        this.productUnitQuantity = value;
    }

    /**
     * Ruft den Wert der perPackageUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getPerPackageUnitQuantity() {
        return perPackageUnitQuantity;
    }

    /**
     * Legt den Wert der perPackageUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setPerPackageUnitQuantity(QuantityType value) {
        this.perPackageUnitQuantity = value;
    }

    /**
     * Ruft den Wert der netWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public WeightUnitMeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    /**
     * Legt den Wert der netWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public void setNetWeightMeasure(WeightUnitMeasureType value) {
        this.netWeightMeasure = value;
    }

    /**
     * Ruft den Wert der grossWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public WeightUnitMeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    /**
     * Legt den Wert der grossWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public void setGrossWeightMeasure(WeightUnitMeasureType value) {
        this.grossWeightMeasure = value;
    }

    /**
     * Ruft den Wert der theoreticalWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public WeightUnitMeasureType getTheoreticalWeightMeasure() {
        return theoreticalWeightMeasure;
    }

    /**
     * Legt den Wert der theoreticalWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public void setTheoreticalWeightMeasure(WeightUnitMeasureType value) {
        this.theoreticalWeightMeasure = value;
    }

    /**
     * Ruft den Wert der despatchedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getDespatchedQuantity() {
        return despatchedQuantity;
    }

    /**
     * Legt den Wert der despatchedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setDespatchedQuantity(QuantityType value) {
        this.despatchedQuantity = value;
    }

    /**
     * Gets the value of the specifiedDeliveryAdjustment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedDeliveryAdjustment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedDeliveryAdjustment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryAdjustmentType }
     * 
     * 
     */
    public List<DeliveryAdjustmentType> getSpecifiedDeliveryAdjustment() {
        if (specifiedDeliveryAdjustment == null) {
            specifiedDeliveryAdjustment = new ArrayList<DeliveryAdjustmentType>();
        }
        return this.specifiedDeliveryAdjustment;
    }

    /**
     * Gets the value of the includedSupplyChainPackaging property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedSupplyChainPackaging property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedSupplyChainPackaging().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyChainPackagingType }
     * 
     * 
     */
    public List<SupplyChainPackagingType> getIncludedSupplyChainPackaging() {
        if (includedSupplyChainPackaging == null) {
            includedSupplyChainPackaging = new ArrayList<SupplyChainPackagingType>();
        }
        return this.includedSupplyChainPackaging;
    }

    /**
     * Ruft den Wert der relatedSupplyChainConsignment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainConsignmentType }
     *     
     */
    public SupplyChainConsignmentType getRelatedSupplyChainConsignment() {
        return relatedSupplyChainConsignment;
    }

    /**
     * Legt den Wert der relatedSupplyChainConsignment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainConsignmentType }
     *     
     */
    public void setRelatedSupplyChainConsignment(SupplyChainConsignmentType value) {
        this.relatedSupplyChainConsignment = value;
    }

    /**
     * Ruft den Wert der shipToTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getShipToTradeParty() {
        return shipToTradeParty;
    }

    /**
     * Legt den Wert der shipToTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setShipToTradeParty(TradePartyType value) {
        this.shipToTradeParty = value;
    }

    /**
     * Ruft den Wert der ultimateShipToTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getUltimateShipToTradeParty() {
        return ultimateShipToTradeParty;
    }

    /**
     * Legt den Wert der ultimateShipToTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setUltimateShipToTradeParty(TradePartyType value) {
        this.ultimateShipToTradeParty = value;
    }

    /**
     * Ruft den Wert der shipFromTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getShipFromTradeParty() {
        return shipFromTradeParty;
    }

    /**
     * Legt den Wert der shipFromTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setShipFromTradeParty(TradePartyType value) {
        this.shipFromTradeParty = value;
    }

    /**
     * Ruft den Wert der actualDespatchSupplyChainEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainEventType }
     *     
     */
    public SupplyChainEventType getActualDespatchSupplyChainEvent() {
        return actualDespatchSupplyChainEvent;
    }

    /**
     * Legt den Wert der actualDespatchSupplyChainEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainEventType }
     *     
     */
    public void setActualDespatchSupplyChainEvent(SupplyChainEventType value) {
        this.actualDespatchSupplyChainEvent = value;
    }

    /**
     * Ruft den Wert der actualPickUpSupplyChainEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainEventType }
     *     
     */
    public SupplyChainEventType getActualPickUpSupplyChainEvent() {
        return actualPickUpSupplyChainEvent;
    }

    /**
     * Legt den Wert der actualPickUpSupplyChainEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainEventType }
     *     
     */
    public void setActualPickUpSupplyChainEvent(SupplyChainEventType value) {
        this.actualPickUpSupplyChainEvent = value;
    }

    /**
     * Ruft den Wert der requestedDeliverySupplyChainEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainEventType }
     *     
     */
    public SupplyChainEventType getRequestedDeliverySupplyChainEvent() {
        return requestedDeliverySupplyChainEvent;
    }

    /**
     * Legt den Wert der requestedDeliverySupplyChainEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainEventType }
     *     
     */
    public void setRequestedDeliverySupplyChainEvent(SupplyChainEventType value) {
        this.requestedDeliverySupplyChainEvent = value;
    }

    /**
     * Ruft den Wert der actualDeliverySupplyChainEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainEventType }
     *     
     */
    public SupplyChainEventType getActualDeliverySupplyChainEvent() {
        return actualDeliverySupplyChainEvent;
    }

    /**
     * Legt den Wert der actualDeliverySupplyChainEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainEventType }
     *     
     */
    public void setActualDeliverySupplyChainEvent(SupplyChainEventType value) {
        this.actualDeliverySupplyChainEvent = value;
    }

    /**
     * Ruft den Wert der actualReceiptSupplyChainEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainEventType }
     *     
     */
    public SupplyChainEventType getActualReceiptSupplyChainEvent() {
        return actualReceiptSupplyChainEvent;
    }

    /**
     * Legt den Wert der actualReceiptSupplyChainEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainEventType }
     *     
     */
    public void setActualReceiptSupplyChainEvent(SupplyChainEventType value) {
        this.actualReceiptSupplyChainEvent = value;
    }

    /**
     * Gets the value of the additionalReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getAdditionalReferencedDocument() {
        if (additionalReferencedDocument == null) {
            additionalReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.additionalReferencedDocument;
    }

    /**
     * Ruft den Wert der despatchAdviceReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getDespatchAdviceReferencedDocument() {
        return despatchAdviceReferencedDocument;
    }

    /**
     * Legt den Wert der despatchAdviceReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setDespatchAdviceReferencedDocument(ReferencedDocumentType value) {
        this.despatchAdviceReferencedDocument = value;
    }

    /**
     * Ruft den Wert der receivingAdviceReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getReceivingAdviceReferencedDocument() {
        return receivingAdviceReferencedDocument;
    }

    /**
     * Legt den Wert der receivingAdviceReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setReceivingAdviceReferencedDocument(ReferencedDocumentType value) {
        this.receivingAdviceReferencedDocument = value;
    }

    /**
     * Ruft den Wert der deliveryNoteReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getDeliveryNoteReferencedDocument() {
        return deliveryNoteReferencedDocument;
    }

    /**
     * Legt den Wert der deliveryNoteReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setDeliveryNoteReferencedDocument(ReferencedDocumentType value) {
        this.deliveryNoteReferencedDocument = value;
    }

    /**
     * Ruft den Wert der consumptionReportReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getConsumptionReportReferencedDocument() {
        return consumptionReportReferencedDocument;
    }

    /**
     * Legt den Wert der consumptionReportReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setConsumptionReportReferencedDocument(ReferencedDocumentType value) {
        this.consumptionReportReferencedDocument = value;
    }

    /**
     * Ruft den Wert der packingListReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getPackingListReferencedDocument() {
        return packingListReferencedDocument;
    }

    /**
     * Legt den Wert der packingListReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setPackingListReferencedDocument(ReferencedDocumentType value) {
        this.packingListReferencedDocument = value;
    }

}
