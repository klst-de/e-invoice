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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FrozenPeriodDaysNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumInventoryQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MultipleOrderQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderIntervalDaysNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReplenishmentOwnerDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetInventoryQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetServicePercentType;


/**
 * <p>Java-Klasse für ItemManagementProfileType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ItemManagementProfileType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FrozenPeriodDaysNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumInventoryQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MultipleOrderQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OrderIntervalDaysNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReplenishmentOwnerDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetServicePercent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetInventoryQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EffectivePeriod"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Item"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ItemLocationQuantity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemManagementProfileType", propOrder = {
    "frozenPeriodDaysNumeric",
    "minimumInventoryQuantity",
    "multipleOrderQuantity",
    "orderIntervalDaysNumeric",
    "replenishmentOwnerDescription",
    "targetServicePercent",
    "targetInventoryQuantity",
    "effectivePeriod",
    "item",
    "itemLocationQuantity"
})
public class ItemManagementProfileType {

    @XmlElement(name = "FrozenPeriodDaysNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FrozenPeriodDaysNumericType frozenPeriodDaysNumeric;
    @XmlElement(name = "MinimumInventoryQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumInventoryQuantityType minimumInventoryQuantity;
    @XmlElement(name = "MultipleOrderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MultipleOrderQuantityType multipleOrderQuantity;
    @XmlElement(name = "OrderIntervalDaysNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OrderIntervalDaysNumericType orderIntervalDaysNumeric;
    @XmlElement(name = "ReplenishmentOwnerDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ReplenishmentOwnerDescriptionType> replenishmentOwnerDescription;
    @XmlElement(name = "TargetServicePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TargetServicePercentType targetServicePercent;
    @XmlElement(name = "TargetInventoryQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TargetInventoryQuantityType targetInventoryQuantity;
    @XmlElement(name = "EffectivePeriod", required = true)
    protected PeriodType effectivePeriod;
    @XmlElement(name = "Item", required = true)
    protected ItemType item;
    @XmlElement(name = "ItemLocationQuantity")
    protected ItemLocationQuantityType itemLocationQuantity;

    /**
     * Ruft den Wert der frozenPeriodDaysNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FrozenPeriodDaysNumericType }
     *     
     */
    public FrozenPeriodDaysNumericType getFrozenPeriodDaysNumeric() {
        return frozenPeriodDaysNumeric;
    }

    /**
     * Legt den Wert der frozenPeriodDaysNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FrozenPeriodDaysNumericType }
     *     
     */
    public void setFrozenPeriodDaysNumeric(FrozenPeriodDaysNumericType value) {
        this.frozenPeriodDaysNumeric = value;
    }

    /**
     * Ruft den Wert der minimumInventoryQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumInventoryQuantityType }
     *     
     */
    public MinimumInventoryQuantityType getMinimumInventoryQuantity() {
        return minimumInventoryQuantity;
    }

    /**
     * Legt den Wert der minimumInventoryQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumInventoryQuantityType }
     *     
     */
    public void setMinimumInventoryQuantity(MinimumInventoryQuantityType value) {
        this.minimumInventoryQuantity = value;
    }

    /**
     * Ruft den Wert der multipleOrderQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultipleOrderQuantityType }
     *     
     */
    public MultipleOrderQuantityType getMultipleOrderQuantity() {
        return multipleOrderQuantity;
    }

    /**
     * Legt den Wert der multipleOrderQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultipleOrderQuantityType }
     *     
     */
    public void setMultipleOrderQuantity(MultipleOrderQuantityType value) {
        this.multipleOrderQuantity = value;
    }

    /**
     * Ruft den Wert der orderIntervalDaysNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrderIntervalDaysNumericType }
     *     
     */
    public OrderIntervalDaysNumericType getOrderIntervalDaysNumeric() {
        return orderIntervalDaysNumeric;
    }

    /**
     * Legt den Wert der orderIntervalDaysNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderIntervalDaysNumericType }
     *     
     */
    public void setOrderIntervalDaysNumeric(OrderIntervalDaysNumericType value) {
        this.orderIntervalDaysNumeric = value;
    }

    /**
     * Gets the value of the replenishmentOwnerDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the replenishmentOwnerDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplenishmentOwnerDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReplenishmentOwnerDescriptionType }
     * 
     * 
     */
    public List<ReplenishmentOwnerDescriptionType> getReplenishmentOwnerDescription() {
        if (replenishmentOwnerDescription == null) {
            replenishmentOwnerDescription = new ArrayList<ReplenishmentOwnerDescriptionType>();
        }
        return this.replenishmentOwnerDescription;
    }

    /**
     * Ruft den Wert der targetServicePercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TargetServicePercentType }
     *     
     */
    public TargetServicePercentType getTargetServicePercent() {
        return targetServicePercent;
    }

    /**
     * Legt den Wert der targetServicePercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetServicePercentType }
     *     
     */
    public void setTargetServicePercent(TargetServicePercentType value) {
        this.targetServicePercent = value;
    }

    /**
     * Ruft den Wert der targetInventoryQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TargetInventoryQuantityType }
     *     
     */
    public TargetInventoryQuantityType getTargetInventoryQuantity() {
        return targetInventoryQuantity;
    }

    /**
     * Legt den Wert der targetInventoryQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetInventoryQuantityType }
     *     
     */
    public void setTargetInventoryQuantity(TargetInventoryQuantityType value) {
        this.targetInventoryQuantity = value;
    }

    /**
     * Ruft den Wert der effectivePeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * Legt den Wert der effectivePeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setEffectivePeriod(PeriodType value) {
        this.effectivePeriod = value;
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
     * Ruft den Wert der itemLocationQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemLocationQuantityType }
     *     
     */
    public ItemLocationQuantityType getItemLocationQuantity() {
        return itemLocationQuantity;
    }

    /**
     * Legt den Wert der itemLocationQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemLocationQuantityType }
     *     
     */
    public void setItemLocationQuantity(ItemLocationQuantityType value) {
        this.itemLocationQuantity = value;
    }

}
