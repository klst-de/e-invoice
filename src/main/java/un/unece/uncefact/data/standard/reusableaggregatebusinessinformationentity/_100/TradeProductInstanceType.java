//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;


/**
 * <p>Java-Klasse für TradeProductInstanceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeProductInstanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GlobalSerialID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="BatchID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="KanbanID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="SupplierAssignedSerialID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="BestBeforeDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="ExpiryDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="SellByDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="SerialID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ProductionSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/&gt;
 *         &lt;element name="PackagingSupplyChainEvent" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainEventType" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableMaterialGoodsCharacteristic" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}MaterialGoodsCharacteristicType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableProductCharacteristic" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ProductCharacteristicType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeProductInstanceType", propOrder = {
    "globalSerialID",
    "batchID",
    "kanbanID",
    "supplierAssignedSerialID",
    "bestBeforeDateTime",
    "expiryDateTime",
    "sellByDateTime",
    "serialID",
    "registrationID",
    "productionSupplyChainEvent",
    "packagingSupplyChainEvent",
    "applicableMaterialGoodsCharacteristic",
    "applicableProductCharacteristic"
})
public class TradeProductInstanceType {

    @XmlElement(name = "GlobalSerialID")
    protected IDType globalSerialID;
    @XmlElement(name = "BatchID")
    protected IDType batchID;
    @XmlElement(name = "KanbanID")
    protected IDType kanbanID;
    @XmlElement(name = "SupplierAssignedSerialID")
    protected IDType supplierAssignedSerialID;
    @XmlElement(name = "BestBeforeDateTime")
    protected DateTimeType bestBeforeDateTime;
    @XmlElement(name = "ExpiryDateTime")
    protected DateTimeType expiryDateTime;
    @XmlElement(name = "SellByDateTime")
    protected DateTimeType sellByDateTime;
    @XmlElement(name = "SerialID")
    protected List<IDType> serialID;
    @XmlElement(name = "RegistrationID")
    protected List<IDType> registrationID;
    @XmlElement(name = "ProductionSupplyChainEvent")
    protected SupplyChainEventType productionSupplyChainEvent;
    @XmlElement(name = "PackagingSupplyChainEvent")
    protected SupplyChainEventType packagingSupplyChainEvent;
    @XmlElement(name = "ApplicableMaterialGoodsCharacteristic")
    protected List<MaterialGoodsCharacteristicType> applicableMaterialGoodsCharacteristic;
    @XmlElement(name = "ApplicableProductCharacteristic")
    protected List<ProductCharacteristicType> applicableProductCharacteristic;

    /**
     * Ruft den Wert der globalSerialID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getGlobalSerialID() {
        return globalSerialID;
    }

    /**
     * Legt den Wert der globalSerialID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setGlobalSerialID(IDType value) {
        this.globalSerialID = value;
    }

    /**
     * Ruft den Wert der batchID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getBatchID() {
        return batchID;
    }

    /**
     * Legt den Wert der batchID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setBatchID(IDType value) {
        this.batchID = value;
    }

    /**
     * Ruft den Wert der kanbanID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getKanbanID() {
        return kanbanID;
    }

    /**
     * Legt den Wert der kanbanID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setKanbanID(IDType value) {
        this.kanbanID = value;
    }

    /**
     * Ruft den Wert der supplierAssignedSerialID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSupplierAssignedSerialID() {
        return supplierAssignedSerialID;
    }

    /**
     * Legt den Wert der supplierAssignedSerialID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSupplierAssignedSerialID(IDType value) {
        this.supplierAssignedSerialID = value;
    }

    /**
     * Ruft den Wert der bestBeforeDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getBestBeforeDateTime() {
        return bestBeforeDateTime;
    }

    /**
     * Legt den Wert der bestBeforeDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setBestBeforeDateTime(DateTimeType value) {
        this.bestBeforeDateTime = value;
    }

    /**
     * Ruft den Wert der expiryDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getExpiryDateTime() {
        return expiryDateTime;
    }

    /**
     * Legt den Wert der expiryDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setExpiryDateTime(DateTimeType value) {
        this.expiryDateTime = value;
    }

    /**
     * Ruft den Wert der sellByDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getSellByDateTime() {
        return sellByDateTime;
    }

    /**
     * Legt den Wert der sellByDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setSellByDateTime(DateTimeType value) {
        this.sellByDateTime = value;
    }

    /**
     * Gets the value of the serialID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serialID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSerialID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getSerialID() {
        if (serialID == null) {
            serialID = new ArrayList<IDType>();
        }
        return this.serialID;
    }

    /**
     * Gets the value of the registrationID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registrationID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistrationID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getRegistrationID() {
        if (registrationID == null) {
            registrationID = new ArrayList<IDType>();
        }
        return this.registrationID;
    }

    /**
     * Ruft den Wert der productionSupplyChainEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainEventType }
     *     
     */
    public SupplyChainEventType getProductionSupplyChainEvent() {
        return productionSupplyChainEvent;
    }

    /**
     * Legt den Wert der productionSupplyChainEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainEventType }
     *     
     */
    public void setProductionSupplyChainEvent(SupplyChainEventType value) {
        this.productionSupplyChainEvent = value;
    }

    /**
     * Ruft den Wert der packagingSupplyChainEvent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainEventType }
     *     
     */
    public SupplyChainEventType getPackagingSupplyChainEvent() {
        return packagingSupplyChainEvent;
    }

    /**
     * Legt den Wert der packagingSupplyChainEvent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainEventType }
     *     
     */
    public void setPackagingSupplyChainEvent(SupplyChainEventType value) {
        this.packagingSupplyChainEvent = value;
    }

    /**
     * Gets the value of the applicableMaterialGoodsCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableMaterialGoodsCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableMaterialGoodsCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaterialGoodsCharacteristicType }
     * 
     * 
     */
    public List<MaterialGoodsCharacteristicType> getApplicableMaterialGoodsCharacteristic() {
        if (applicableMaterialGoodsCharacteristic == null) {
            applicableMaterialGoodsCharacteristic = new ArrayList<MaterialGoodsCharacteristicType>();
        }
        return this.applicableMaterialGoodsCharacteristic;
    }

    /**
     * Gets the value of the applicableProductCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableProductCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableProductCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductCharacteristicType }
     * 
     * 
     */
    public List<ProductCharacteristicType> getApplicableProductCharacteristic() {
        if (applicableProductCharacteristic == null) {
            applicableProductCharacteristic = new ArrayList<ProductCharacteristicType>();
        }
        return this.applicableProductCharacteristic;
    }

}
