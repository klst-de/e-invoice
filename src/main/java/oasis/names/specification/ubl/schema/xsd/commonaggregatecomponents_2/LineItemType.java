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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BackOrderAllowedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InspectionMethodCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumBackorderQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumBackorderQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PartialDeliveryIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SalesOrderIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalTaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WarrantyInformationType;


/**
 * <p>Java-Klasse für LineItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LineItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SalesOrderID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineExtensionAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalTaxAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumBackorderQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumBackorderQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InspectionMethodCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PartialDeliveryIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BackOrderAllowedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCostCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCost" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WarrantyInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Delivery" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryTerms" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginatorParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OrderedShipment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PricingReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Price" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Item"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SubLineItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WarrantyValidityPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WarrantyParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ItemPriceExtension" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LineReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineItemType", propOrder = {
    "id",
    "salesOrderID",
    "uuid",
    "note",
    "lineStatusCode",
    "quantity",
    "lineExtensionAmount",
    "totalTaxAmount",
    "minimumQuantity",
    "maximumQuantity",
    "minimumBackorderQuantity",
    "maximumBackorderQuantity",
    "inspectionMethodCode",
    "partialDeliveryIndicator",
    "backOrderAllowedIndicator",
    "accountingCostCode",
    "accountingCost",
    "warrantyInformation",
    "delivery",
    "deliveryTerms",
    "originatorParty",
    "orderedShipment",
    "pricingReference",
    "allowanceCharge",
    "price",
    "item",
    "subLineItem",
    "warrantyValidityPeriod",
    "warrantyParty",
    "taxTotal",
    "itemPriceExtension",
    "lineReference"
})
public class LineItemType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "SalesOrderID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SalesOrderIDType salesOrderID;
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UUIDType uuid;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "LineStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineStatusCodeType lineStatusCode;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "LineExtensionAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineExtensionAmountType lineExtensionAmount;
    @XmlElement(name = "TotalTaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalTaxAmountType totalTaxAmount;
    @XmlElement(name = "MinimumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumQuantityType minimumQuantity;
    @XmlElement(name = "MaximumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumQuantityType maximumQuantity;
    @XmlElement(name = "MinimumBackorderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumBackorderQuantityType minimumBackorderQuantity;
    @XmlElement(name = "MaximumBackorderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumBackorderQuantityType maximumBackorderQuantity;
    @XmlElement(name = "InspectionMethodCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InspectionMethodCodeType inspectionMethodCode;
    @XmlElement(name = "PartialDeliveryIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PartialDeliveryIndicatorType partialDeliveryIndicator;
    @XmlElement(name = "BackOrderAllowedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BackOrderAllowedIndicatorType backOrderAllowedIndicator;
    @XmlElement(name = "AccountingCostCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostCodeType accountingCostCode;
    @XmlElement(name = "AccountingCost", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostType accountingCost;
    @XmlElement(name = "WarrantyInformation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<WarrantyInformationType> warrantyInformation;
    @XmlElement(name = "Delivery")
    protected List<DeliveryType> delivery;
    @XmlElement(name = "DeliveryTerms")
    protected DeliveryTermsType deliveryTerms;
    @XmlElement(name = "OriginatorParty")
    protected PartyType originatorParty;
    @XmlElement(name = "OrderedShipment")
    protected List<OrderedShipmentType> orderedShipment;
    @XmlElement(name = "PricingReference")
    protected PricingReferenceType pricingReference;
    @XmlElement(name = "AllowanceCharge")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "Price")
    protected PriceType price;
    @XmlElement(name = "Item", required = true)
    protected ItemType item;
    @XmlElement(name = "SubLineItem")
    protected List<LineItemType> subLineItem;
    @XmlElement(name = "WarrantyValidityPeriod")
    protected PeriodType warrantyValidityPeriod;
    @XmlElement(name = "WarrantyParty")
    protected PartyType warrantyParty;
    @XmlElement(name = "TaxTotal")
    protected List<TaxTotalType> taxTotal;
    @XmlElement(name = "ItemPriceExtension")
    protected PriceExtensionType itemPriceExtension;
    @XmlElement(name = "LineReference")
    protected List<LineReferenceType> lineReference;

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
     * Ruft den Wert der salesOrderID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SalesOrderIDType }
     *     
     */
    public SalesOrderIDType getSalesOrderID() {
        return salesOrderID;
    }

    /**
     * Legt den Wert der salesOrderID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesOrderIDType }
     *     
     */
    public void setSalesOrderID(SalesOrderIDType value) {
        this.salesOrderID = value;
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
     * Ruft den Wert der lineStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineStatusCodeType }
     *     
     */
    public LineStatusCodeType getLineStatusCode() {
        return lineStatusCode;
    }

    /**
     * Legt den Wert der lineStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStatusCodeType }
     *     
     */
    public void setLineStatusCode(LineStatusCodeType value) {
        this.lineStatusCode = value;
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
     * Ruft den Wert der lineExtensionAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public LineExtensionAmountType getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    /**
     * Legt den Wert der lineExtensionAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public void setLineExtensionAmount(LineExtensionAmountType value) {
        this.lineExtensionAmount = value;
    }

    /**
     * Ruft den Wert der totalTaxAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalTaxAmountType }
     *     
     */
    public TotalTaxAmountType getTotalTaxAmount() {
        return totalTaxAmount;
    }

    /**
     * Legt den Wert der totalTaxAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalTaxAmountType }
     *     
     */
    public void setTotalTaxAmount(TotalTaxAmountType value) {
        this.totalTaxAmount = value;
    }

    /**
     * Ruft den Wert der minimumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumQuantityType }
     *     
     */
    public MinimumQuantityType getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * Legt den Wert der minimumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumQuantityType }
     *     
     */
    public void setMinimumQuantity(MinimumQuantityType value) {
        this.minimumQuantity = value;
    }

    /**
     * Ruft den Wert der maximumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumQuantityType }
     *     
     */
    public MaximumQuantityType getMaximumQuantity() {
        return maximumQuantity;
    }

    /**
     * Legt den Wert der maximumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumQuantityType }
     *     
     */
    public void setMaximumQuantity(MaximumQuantityType value) {
        this.maximumQuantity = value;
    }

    /**
     * Ruft den Wert der minimumBackorderQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumBackorderQuantityType }
     *     
     */
    public MinimumBackorderQuantityType getMinimumBackorderQuantity() {
        return minimumBackorderQuantity;
    }

    /**
     * Legt den Wert der minimumBackorderQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumBackorderQuantityType }
     *     
     */
    public void setMinimumBackorderQuantity(MinimumBackorderQuantityType value) {
        this.minimumBackorderQuantity = value;
    }

    /**
     * Ruft den Wert der maximumBackorderQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumBackorderQuantityType }
     *     
     */
    public MaximumBackorderQuantityType getMaximumBackorderQuantity() {
        return maximumBackorderQuantity;
    }

    /**
     * Legt den Wert der maximumBackorderQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumBackorderQuantityType }
     *     
     */
    public void setMaximumBackorderQuantity(MaximumBackorderQuantityType value) {
        this.maximumBackorderQuantity = value;
    }

    /**
     * Ruft den Wert der inspectionMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InspectionMethodCodeType }
     *     
     */
    public InspectionMethodCodeType getInspectionMethodCode() {
        return inspectionMethodCode;
    }

    /**
     * Legt den Wert der inspectionMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionMethodCodeType }
     *     
     */
    public void setInspectionMethodCode(InspectionMethodCodeType value) {
        this.inspectionMethodCode = value;
    }

    /**
     * Ruft den Wert der partialDeliveryIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartialDeliveryIndicatorType }
     *     
     */
    public PartialDeliveryIndicatorType getPartialDeliveryIndicator() {
        return partialDeliveryIndicator;
    }

    /**
     * Legt den Wert der partialDeliveryIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartialDeliveryIndicatorType }
     *     
     */
    public void setPartialDeliveryIndicator(PartialDeliveryIndicatorType value) {
        this.partialDeliveryIndicator = value;
    }

    /**
     * Ruft den Wert der backOrderAllowedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BackOrderAllowedIndicatorType }
     *     
     */
    public BackOrderAllowedIndicatorType getBackOrderAllowedIndicator() {
        return backOrderAllowedIndicator;
    }

    /**
     * Legt den Wert der backOrderAllowedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BackOrderAllowedIndicatorType }
     *     
     */
    public void setBackOrderAllowedIndicator(BackOrderAllowedIndicatorType value) {
        this.backOrderAllowedIndicator = value;
    }

    /**
     * Ruft den Wert der accountingCostCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * Legt den Wert der accountingCostCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    /**
     * Ruft den Wert der accountingCost-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostType }
     *     
     */
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    /**
     * Legt den Wert der accountingCost-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostType }
     *     
     */
    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    /**
     * Gets the value of the warrantyInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warrantyInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarrantyInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarrantyInformationType }
     * 
     * 
     */
    public List<WarrantyInformationType> getWarrantyInformation() {
        if (warrantyInformation == null) {
            warrantyInformation = new ArrayList<WarrantyInformationType>();
        }
        return this.warrantyInformation;
    }

    /**
     * Gets the value of the delivery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delivery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelivery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryType }
     * 
     * 
     */
    public List<DeliveryType> getDelivery() {
        if (delivery == null) {
            delivery = new ArrayList<DeliveryType>();
        }
        return this.delivery;
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
     * Ruft den Wert der originatorParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOriginatorParty() {
        return originatorParty;
    }

    /**
     * Legt den Wert der originatorParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOriginatorParty(PartyType value) {
        this.originatorParty = value;
    }

    /**
     * Gets the value of the orderedShipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderedShipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderedShipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderedShipmentType }
     * 
     * 
     */
    public List<OrderedShipmentType> getOrderedShipment() {
        if (orderedShipment == null) {
            orderedShipment = new ArrayList<OrderedShipmentType>();
        }
        return this.orderedShipment;
    }

    /**
     * Ruft den Wert der pricingReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PricingReferenceType }
     *     
     */
    public PricingReferenceType getPricingReference() {
        return pricingReference;
    }

    /**
     * Legt den Wert der pricingReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PricingReferenceType }
     *     
     */
    public void setPricingReference(PricingReferenceType value) {
        this.pricingReference = value;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    /**
     * Ruft den Wert der price-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getPrice() {
        return price;
    }

    /**
     * Legt den Wert der price-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setPrice(PriceType value) {
        this.price = value;
    }

    /**
     * Ruft den Wert der item-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemType }
     *     
     */
    public ItemType getItem() {
        return item;
    }

    /**
     * Legt den Wert der item-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType }
     *     
     */
    public void setItem(ItemType value) {
        this.item = value;
    }

    /**
     * Gets the value of the subLineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subLineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineItemType }
     * 
     * 
     */
    public List<LineItemType> getSubLineItem() {
        if (subLineItem == null) {
            subLineItem = new ArrayList<LineItemType>();
        }
        return this.subLineItem;
    }

    /**
     * Ruft den Wert der warrantyValidityPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getWarrantyValidityPeriod() {
        return warrantyValidityPeriod;
    }

    /**
     * Legt den Wert der warrantyValidityPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setWarrantyValidityPeriod(PeriodType value) {
        this.warrantyValidityPeriod = value;
    }

    /**
     * Ruft den Wert der warrantyParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getWarrantyParty() {
        return warrantyParty;
    }

    /**
     * Legt den Wert der warrantyParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setWarrantyParty(PartyType value) {
        this.warrantyParty = value;
    }

    /**
     * Gets the value of the taxTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxTotalType }
     * 
     * 
     */
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    /**
     * Ruft den Wert der itemPriceExtension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceExtensionType }
     *     
     */
    public PriceExtensionType getItemPriceExtension() {
        return itemPriceExtension;
    }

    /**
     * Legt den Wert der itemPriceExtension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceExtensionType }
     *     
     */
    public void setItemPriceExtension(PriceExtensionType value) {
        this.itemPriceExtension = value;
    }

    /**
     * Gets the value of the lineReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineReferenceType }
     * 
     * 
     */
    public List<LineReferenceType> getLineReference() {
        if (lineReference == null) {
            lineReference = new ArrayList<LineReferenceType>();
        }
        return this.lineReference;
    }

}
