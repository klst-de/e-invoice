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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackageLevelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackagingTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackingMaterialType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReturnableMaterialIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TraceIDType;


/**
 * <p>Java-Klasse für PackageType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PackageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReturnableMaterialIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackageLevelCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackagingTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackingMaterial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TraceID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContainedPackage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContainingTransportEquipment" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}GoodsItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementDimension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryUnit" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Delivery" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Pickup" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Despatch" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageType", propOrder = {
    "id",
    "quantity",
    "returnableMaterialIndicator",
    "packageLevelCode",
    "packagingTypeCode",
    "packingMaterial",
    "traceID",
    "containedPackage",
    "containingTransportEquipment",
    "goodsItem",
    "measurementDimension",
    "deliveryUnit",
    "delivery",
    "pickup",
    "despatch"
})
public class PackageType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "ReturnableMaterialIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReturnableMaterialIndicatorType returnableMaterialIndicator;
    @XmlElement(name = "PackageLevelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackageLevelCodeType packageLevelCode;
    @XmlElement(name = "PackagingTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackagingTypeCodeType packagingTypeCode;
    @XmlElement(name = "PackingMaterial", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PackingMaterialType> packingMaterial;
    @XmlElement(name = "TraceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TraceIDType traceID;
    @XmlElement(name = "ContainedPackage")
    protected List<PackageType> containedPackage;
    @XmlElement(name = "ContainingTransportEquipment")
    protected TransportEquipmentType containingTransportEquipment;
    @XmlElement(name = "GoodsItem")
    protected List<GoodsItemType> goodsItem;
    @XmlElement(name = "MeasurementDimension")
    protected List<DimensionType> measurementDimension;
    @XmlElement(name = "DeliveryUnit")
    protected List<DeliveryUnitType> deliveryUnit;
    @XmlElement(name = "Delivery")
    protected DeliveryType delivery;
    @XmlElement(name = "Pickup")
    protected PickupType pickup;
    @XmlElement(name = "Despatch")
    protected DespatchType despatch;

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
     * Ruft den Wert der returnableMaterialIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReturnableMaterialIndicatorType }
     *     
     */
    public ReturnableMaterialIndicatorType getReturnableMaterialIndicator() {
        return returnableMaterialIndicator;
    }

    /**
     * Legt den Wert der returnableMaterialIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnableMaterialIndicatorType }
     *     
     */
    public void setReturnableMaterialIndicator(ReturnableMaterialIndicatorType value) {
        this.returnableMaterialIndicator = value;
    }

    /**
     * Ruft den Wert der packageLevelCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PackageLevelCodeType }
     *     
     */
    public PackageLevelCodeType getPackageLevelCode() {
        return packageLevelCode;
    }

    /**
     * Legt den Wert der packageLevelCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageLevelCodeType }
     *     
     */
    public void setPackageLevelCode(PackageLevelCodeType value) {
        this.packageLevelCode = value;
    }

    /**
     * Ruft den Wert der packagingTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PackagingTypeCodeType }
     *     
     */
    public PackagingTypeCodeType getPackagingTypeCode() {
        return packagingTypeCode;
    }

    /**
     * Legt den Wert der packagingTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PackagingTypeCodeType }
     *     
     */
    public void setPackagingTypeCode(PackagingTypeCodeType value) {
        this.packagingTypeCode = value;
    }

    /**
     * Gets the value of the packingMaterial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packingMaterial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackingMaterial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackingMaterialType }
     * 
     * 
     */
    public List<PackingMaterialType> getPackingMaterial() {
        if (packingMaterial == null) {
            packingMaterial = new ArrayList<PackingMaterialType>();
        }
        return this.packingMaterial;
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
     * Gets the value of the containedPackage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containedPackage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainedPackage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackageType }
     * 
     * 
     */
    public List<PackageType> getContainedPackage() {
        if (containedPackage == null) {
            containedPackage = new ArrayList<PackageType>();
        }
        return this.containedPackage;
    }

    /**
     * Ruft den Wert der containingTransportEquipment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportEquipmentType }
     *     
     */
    public TransportEquipmentType getContainingTransportEquipment() {
        return containingTransportEquipment;
    }

    /**
     * Legt den Wert der containingTransportEquipment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEquipmentType }
     *     
     */
    public void setContainingTransportEquipment(TransportEquipmentType value) {
        this.containingTransportEquipment = value;
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
     * Gets the value of the deliveryUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryUnitType }
     * 
     * 
     */
    public List<DeliveryUnitType> getDeliveryUnit() {
        if (deliveryUnit == null) {
            deliveryUnit = new ArrayList<DeliveryUnitType>();
        }
        return this.deliveryUnit;
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

}
