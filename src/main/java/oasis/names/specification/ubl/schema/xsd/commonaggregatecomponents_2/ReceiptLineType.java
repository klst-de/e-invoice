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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OversupplyQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityDiscrepancyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RejectActionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RejectReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RejectReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RejectedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ShortQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ShortageActionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimingComplaintCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimingComplaintType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;


/**
 * <p>Java-Klasse für ReceiptLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReceiptLineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReceivedQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ShortQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ShortageActionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RejectedQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RejectReasonCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RejectReason" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RejectActionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}QuantityDiscrepancyCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OversupplyQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReceivedDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimingComplaintCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimingComplaint" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OrderLineReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DespatchLineReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Item" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Shipment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReceiptLineType", propOrder = {
    "id",
    "uuid",
    "note",
    "receivedQuantity",
    "shortQuantity",
    "shortageActionCode",
    "rejectedQuantity",
    "rejectReasonCode",
    "rejectReason",
    "rejectActionCode",
    "quantityDiscrepancyCode",
    "oversupplyQuantity",
    "receivedDate",
    "timingComplaintCode",
    "timingComplaint",
    "orderLineReference",
    "despatchLineReference",
    "documentReference",
    "item",
    "shipment"
})
public class ReceiptLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UUIDType uuid;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "ReceivedQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReceivedQuantityType receivedQuantity;
    @XmlElement(name = "ShortQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ShortQuantityType shortQuantity;
    @XmlElement(name = "ShortageActionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ShortageActionCodeType shortageActionCode;
    @XmlElement(name = "RejectedQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RejectedQuantityType rejectedQuantity;
    @XmlElement(name = "RejectReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RejectReasonCodeType rejectReasonCode;
    @XmlElement(name = "RejectReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RejectReasonType> rejectReason;
    @XmlElement(name = "RejectActionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RejectActionCodeType rejectActionCode;
    @XmlElement(name = "QuantityDiscrepancyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityDiscrepancyCodeType quantityDiscrepancyCode;
    @XmlElement(name = "OversupplyQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OversupplyQuantityType oversupplyQuantity;
    @XmlElement(name = "ReceivedDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReceivedDateType receivedDate;
    @XmlElement(name = "TimingComplaintCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimingComplaintCodeType timingComplaintCode;
    @XmlElement(name = "TimingComplaint", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimingComplaintType timingComplaint;
    @XmlElement(name = "OrderLineReference")
    protected OrderLineReferenceType orderLineReference;
    @XmlElement(name = "DespatchLineReference")
    protected List<LineReferenceType> despatchLineReference;
    @XmlElement(name = "DocumentReference")
    protected List<DocumentReferenceType> documentReference;
    @XmlElement(name = "Item")
    protected List<ItemType> item;
    @XmlElement(name = "Shipment")
    protected List<ShipmentType> shipment;

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
     * Ruft den Wert der uuid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UUIDType }
     *     
     */
    public UUIDType getUUID() {
        return uuid;
    }

    /**
     * Legt den Wert der uuid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UUIDType }
     *     
     */
    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Ruft den Wert der receivedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReceivedQuantityType }
     *     
     */
    public ReceivedQuantityType getReceivedQuantity() {
        return receivedQuantity;
    }

    /**
     * Legt den Wert der receivedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivedQuantityType }
     *     
     */
    public void setReceivedQuantity(ReceivedQuantityType value) {
        this.receivedQuantity = value;
    }

    /**
     * Ruft den Wert der shortQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShortQuantityType }
     *     
     */
    public ShortQuantityType getShortQuantity() {
        return shortQuantity;
    }

    /**
     * Legt den Wert der shortQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortQuantityType }
     *     
     */
    public void setShortQuantity(ShortQuantityType value) {
        this.shortQuantity = value;
    }

    /**
     * Ruft den Wert der shortageActionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShortageActionCodeType }
     *     
     */
    public ShortageActionCodeType getShortageActionCode() {
        return shortageActionCode;
    }

    /**
     * Legt den Wert der shortageActionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortageActionCodeType }
     *     
     */
    public void setShortageActionCode(ShortageActionCodeType value) {
        this.shortageActionCode = value;
    }

    /**
     * Ruft den Wert der rejectedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RejectedQuantityType }
     *     
     */
    public RejectedQuantityType getRejectedQuantity() {
        return rejectedQuantity;
    }

    /**
     * Legt den Wert der rejectedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectedQuantityType }
     *     
     */
    public void setRejectedQuantity(RejectedQuantityType value) {
        this.rejectedQuantity = value;
    }

    /**
     * Ruft den Wert der rejectReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RejectReasonCodeType }
     *     
     */
    public RejectReasonCodeType getRejectReasonCode() {
        return rejectReasonCode;
    }

    /**
     * Legt den Wert der rejectReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectReasonCodeType }
     *     
     */
    public void setRejectReasonCode(RejectReasonCodeType value) {
        this.rejectReasonCode = value;
    }

    /**
     * Gets the value of the rejectReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rejectReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRejectReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RejectReasonType }
     * 
     * 
     */
    public List<RejectReasonType> getRejectReason() {
        if (rejectReason == null) {
            rejectReason = new ArrayList<RejectReasonType>();
        }
        return this.rejectReason;
    }

    /**
     * Ruft den Wert der rejectActionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RejectActionCodeType }
     *     
     */
    public RejectActionCodeType getRejectActionCode() {
        return rejectActionCode;
    }

    /**
     * Legt den Wert der rejectActionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectActionCodeType }
     *     
     */
    public void setRejectActionCode(RejectActionCodeType value) {
        this.rejectActionCode = value;
    }

    /**
     * Ruft den Wert der quantityDiscrepancyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityDiscrepancyCodeType }
     *     
     */
    public QuantityDiscrepancyCodeType getQuantityDiscrepancyCode() {
        return quantityDiscrepancyCode;
    }

    /**
     * Legt den Wert der quantityDiscrepancyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityDiscrepancyCodeType }
     *     
     */
    public void setQuantityDiscrepancyCode(QuantityDiscrepancyCodeType value) {
        this.quantityDiscrepancyCode = value;
    }

    /**
     * Ruft den Wert der oversupplyQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OversupplyQuantityType }
     *     
     */
    public OversupplyQuantityType getOversupplyQuantity() {
        return oversupplyQuantity;
    }

    /**
     * Legt den Wert der oversupplyQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OversupplyQuantityType }
     *     
     */
    public void setOversupplyQuantity(OversupplyQuantityType value) {
        this.oversupplyQuantity = value;
    }

    /**
     * Ruft den Wert der receivedDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReceivedDateType }
     *     
     */
    public ReceivedDateType getReceivedDate() {
        return receivedDate;
    }

    /**
     * Legt den Wert der receivedDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivedDateType }
     *     
     */
    public void setReceivedDate(ReceivedDateType value) {
        this.receivedDate = value;
    }

    /**
     * Ruft den Wert der timingComplaintCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TimingComplaintCodeType }
     *     
     */
    public TimingComplaintCodeType getTimingComplaintCode() {
        return timingComplaintCode;
    }

    /**
     * Legt den Wert der timingComplaintCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TimingComplaintCodeType }
     *     
     */
    public void setTimingComplaintCode(TimingComplaintCodeType value) {
        this.timingComplaintCode = value;
    }

    /**
     * Ruft den Wert der timingComplaint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TimingComplaintType }
     *     
     */
    public TimingComplaintType getTimingComplaint() {
        return timingComplaint;
    }

    /**
     * Legt den Wert der timingComplaint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TimingComplaintType }
     *     
     */
    public void setTimingComplaint(TimingComplaintType value) {
        this.timingComplaint = value;
    }

    /**
     * Ruft den Wert der orderLineReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrderLineReferenceType }
     *     
     */
    public OrderLineReferenceType getOrderLineReference() {
        return orderLineReference;
    }

    /**
     * Legt den Wert der orderLineReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderLineReferenceType }
     *     
     */
    public void setOrderLineReference(OrderLineReferenceType value) {
        this.orderLineReference = value;
    }

    /**
     * Gets the value of the despatchLineReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the despatchLineReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDespatchLineReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineReferenceType }
     * 
     * 
     */
    public List<LineReferenceType> getDespatchLineReference() {
        if (despatchLineReference == null) {
            despatchLineReference = new ArrayList<LineReferenceType>();
        }
        return this.despatchLineReference;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.documentReference;
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
     * Gets the value of the shipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentType }
     * 
     * 
     */
    public List<ShipmentType> getShipment() {
        if (shipment == null) {
            shipment = new ArrayList<ShipmentType>();
        }
        return this.shipment;
    }

}
