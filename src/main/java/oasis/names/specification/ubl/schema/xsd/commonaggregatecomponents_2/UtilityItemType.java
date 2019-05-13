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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CurrentChargeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CurrentChargeTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OneTimeChargeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OneTimeChargeTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackSizeNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberTypeType;


/**
 * <p>Java-Klasse für UtilityItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="UtilityItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackSizeNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CurrentChargeType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CurrentChargeTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OneTimeChargeType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OneTimeChargeTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxCategory" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Contract" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtilityItemType", propOrder = {
    "id",
    "subscriberID",
    "subscriberType",
    "subscriberTypeCode",
    "description",
    "packQuantity",
    "packSizeNumeric",
    "consumptionType",
    "consumptionTypeCode",
    "currentChargeType",
    "currentChargeTypeCode",
    "oneTimeChargeType",
    "oneTimeChargeTypeCode",
    "taxCategory",
    "contract"
})
public class UtilityItemType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "SubscriberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberIDType subscriberID;
    @XmlElement(name = "SubscriberType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberTypeType subscriberType;
    @XmlElement(name = "SubscriberTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberTypeCodeType subscriberTypeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "PackQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackQuantityType packQuantity;
    @XmlElement(name = "PackSizeNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackSizeNumericType packSizeNumeric;
    @XmlElement(name = "ConsumptionType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeType consumptionType;
    @XmlElement(name = "ConsumptionTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeCodeType consumptionTypeCode;
    @XmlElement(name = "CurrentChargeType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CurrentChargeTypeType currentChargeType;
    @XmlElement(name = "CurrentChargeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CurrentChargeTypeCodeType currentChargeTypeCode;
    @XmlElement(name = "OneTimeChargeType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OneTimeChargeTypeType oneTimeChargeType;
    @XmlElement(name = "OneTimeChargeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OneTimeChargeTypeCodeType oneTimeChargeTypeCode;
    @XmlElement(name = "TaxCategory")
    protected TaxCategoryType taxCategory;
    @XmlElement(name = "Contract")
    protected ContractType contract;

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
     * Ruft den Wert der subscriberID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberIDType }
     *     
     */
    public SubscriberIDType getSubscriberID() {
        return subscriberID;
    }

    /**
     * Legt den Wert der subscriberID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberIDType }
     *     
     */
    public void setSubscriberID(SubscriberIDType value) {
        this.subscriberID = value;
    }

    /**
     * Ruft den Wert der subscriberType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberTypeType }
     *     
     */
    public SubscriberTypeType getSubscriberType() {
        return subscriberType;
    }

    /**
     * Legt den Wert der subscriberType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberTypeType }
     *     
     */
    public void setSubscriberType(SubscriberTypeType value) {
        this.subscriberType = value;
    }

    /**
     * Ruft den Wert der subscriberTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberTypeCodeType }
     *     
     */
    public SubscriberTypeCodeType getSubscriberTypeCode() {
        return subscriberTypeCode;
    }

    /**
     * Legt den Wert der subscriberTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberTypeCodeType }
     *     
     */
    public void setSubscriberTypeCode(SubscriberTypeCodeType value) {
        this.subscriberTypeCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der packQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PackQuantityType }
     *     
     */
    public PackQuantityType getPackQuantity() {
        return packQuantity;
    }

    /**
     * Legt den Wert der packQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PackQuantityType }
     *     
     */
    public void setPackQuantity(PackQuantityType value) {
        this.packQuantity = value;
    }

    /**
     * Ruft den Wert der packSizeNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PackSizeNumericType }
     *     
     */
    public PackSizeNumericType getPackSizeNumeric() {
        return packSizeNumeric;
    }

    /**
     * Legt den Wert der packSizeNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PackSizeNumericType }
     *     
     */
    public void setPackSizeNumeric(PackSizeNumericType value) {
        this.packSizeNumeric = value;
    }

    /**
     * Ruft den Wert der consumptionType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionTypeType }
     *     
     */
    public ConsumptionTypeType getConsumptionType() {
        return consumptionType;
    }

    /**
     * Legt den Wert der consumptionType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionTypeType }
     *     
     */
    public void setConsumptionType(ConsumptionTypeType value) {
        this.consumptionType = value;
    }

    /**
     * Ruft den Wert der consumptionTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionTypeCodeType }
     *     
     */
    public ConsumptionTypeCodeType getConsumptionTypeCode() {
        return consumptionTypeCode;
    }

    /**
     * Legt den Wert der consumptionTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionTypeCodeType }
     *     
     */
    public void setConsumptionTypeCode(ConsumptionTypeCodeType value) {
        this.consumptionTypeCode = value;
    }

    /**
     * Ruft den Wert der currentChargeType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrentChargeTypeType }
     *     
     */
    public CurrentChargeTypeType getCurrentChargeType() {
        return currentChargeType;
    }

    /**
     * Legt den Wert der currentChargeType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentChargeTypeType }
     *     
     */
    public void setCurrentChargeType(CurrentChargeTypeType value) {
        this.currentChargeType = value;
    }

    /**
     * Ruft den Wert der currentChargeTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrentChargeTypeCodeType }
     *     
     */
    public CurrentChargeTypeCodeType getCurrentChargeTypeCode() {
        return currentChargeTypeCode;
    }

    /**
     * Legt den Wert der currentChargeTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentChargeTypeCodeType }
     *     
     */
    public void setCurrentChargeTypeCode(CurrentChargeTypeCodeType value) {
        this.currentChargeTypeCode = value;
    }

    /**
     * Ruft den Wert der oneTimeChargeType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OneTimeChargeTypeType }
     *     
     */
    public OneTimeChargeTypeType getOneTimeChargeType() {
        return oneTimeChargeType;
    }

    /**
     * Legt den Wert der oneTimeChargeType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OneTimeChargeTypeType }
     *     
     */
    public void setOneTimeChargeType(OneTimeChargeTypeType value) {
        this.oneTimeChargeType = value;
    }

    /**
     * Ruft den Wert der oneTimeChargeTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OneTimeChargeTypeCodeType }
     *     
     */
    public OneTimeChargeTypeCodeType getOneTimeChargeTypeCode() {
        return oneTimeChargeTypeCode;
    }

    /**
     * Legt den Wert der oneTimeChargeTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OneTimeChargeTypeCodeType }
     *     
     */
    public void setOneTimeChargeTypeCode(OneTimeChargeTypeCodeType value) {
        this.oneTimeChargeTypeCode = value;
    }

    /**
     * Ruft den Wert der taxCategory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxCategoryType }
     *     
     */
    public TaxCategoryType getTaxCategory() {
        return taxCategory;
    }

    /**
     * Legt den Wert der taxCategory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCategoryType }
     *     
     */
    public void setTaxCategory(TaxCategoryType value) {
        this.taxCategory = value;
    }

    /**
     * Ruft den Wert der contract-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getContract() {
        return contract;
    }

    /**
     * Legt den Wert der contract-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setContract(ContractType value) {
        this.contract = value;
    }

}
