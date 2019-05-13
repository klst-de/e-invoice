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


/**
 * <p>Java-Klasse für HeaderTradeDeliveryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HeaderTradeDeliveryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelatedSupplyChainConsignment" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainConsignmentType" minOccurs="0"/>
 *         &lt;element name="ShipToTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="UltimateShipToTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="ShipFromTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="ActualDespatchSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="ActualPickUpSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="ActualDeliverySupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="ActualReceiptSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/>
 *         &lt;element name="AdditionalReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DespatchAdviceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="ReceivingAdviceReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="DeliveryNoteReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="ConsumptionReportReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="PreviousDeliverySupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "HeaderTradeDeliveryType", propOrder = {
    "relatedSupplyChainConsignment",
    "shipToTradeParty",
    "ultimateShipToTradeParty",
    "shipFromTradeParty",
    "actualDespatchSupplyChainEvent",
    "actualPickUpSupplyChainEvent",
    "actualDeliverySupplyChainEvent",
    "actualReceiptSupplyChainEvent",
    "additionalReferencedDocument",
    "despatchAdviceReferencedDocument",
    "receivingAdviceReferencedDocument",
    "deliveryNoteReferencedDocument",
    "consumptionReportReferencedDocument",
    "previousDeliverySupplyChainEvent",
    "packingListReferencedDocument"
})
public class HeaderTradeDeliveryType {

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
    @XmlElement(name = "PreviousDeliverySupplyChainEvent")
    protected List<SupplyChainEventType> previousDeliverySupplyChainEvent;
    @XmlElement(name = "PackingListReferencedDocument")
    protected ReferencedDocumentType packingListReferencedDocument;

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
     * Gets the value of the previousDeliverySupplyChainEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previousDeliverySupplyChainEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreviousDeliverySupplyChainEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyChainEventType }
     * 
     * 
     */
    public List<SupplyChainEventType> getPreviousDeliverySupplyChainEvent() {
        if (previousDeliverySupplyChainEvent == null) {
            previousDeliverySupplyChainEvent = new ArrayList<SupplyChainEventType>();
        }
        return this.previousDeliverySupplyChainEvent;
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
