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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecificationTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalMeteredQuantityType;


/**
 * <p>Java-Klasse für SubscriberConsumptionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SubscriberConsumptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecificationTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalMeteredQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SubscriberParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UtilityConsumptionPoint"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OnAccountPayment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Consumption" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupplierConsumption" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberConsumptionType", propOrder = {
    "consumptionID",
    "specificationTypeCode",
    "note",
    "totalMeteredQuantity",
    "subscriberParty",
    "utilityConsumptionPoint",
    "onAccountPayment",
    "consumption",
    "supplierConsumption"
})
public class SubscriberConsumptionType {

    @XmlElement(name = "ConsumptionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionIDType consumptionID;
    @XmlElement(name = "SpecificationTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecificationTypeCodeType specificationTypeCode;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "TotalMeteredQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalMeteredQuantityType totalMeteredQuantity;
    @XmlElement(name = "SubscriberParty")
    protected PartyType subscriberParty;
    @XmlElement(name = "UtilityConsumptionPoint", required = true)
    protected ConsumptionPointType utilityConsumptionPoint;
    @XmlElement(name = "OnAccountPayment")
    protected List<OnAccountPaymentType> onAccountPayment;
    @XmlElement(name = "Consumption")
    protected ConsumptionType consumption;
    @XmlElement(name = "SupplierConsumption")
    protected List<SupplierConsumptionType> supplierConsumption;

    /**
     * Ruft den Wert der consumptionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionIDType }
     *     
     */
    public ConsumptionIDType getConsumptionID() {
        return consumptionID;
    }

    /**
     * Legt den Wert der consumptionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionIDType }
     *     
     */
    public void setConsumptionID(ConsumptionIDType value) {
        this.consumptionID = value;
    }

    /**
     * Ruft den Wert der specificationTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecificationTypeCodeType }
     *     
     */
    public SpecificationTypeCodeType getSpecificationTypeCode() {
        return specificationTypeCode;
    }

    /**
     * Legt den Wert der specificationTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificationTypeCodeType }
     *     
     */
    public void setSpecificationTypeCode(SpecificationTypeCodeType value) {
        this.specificationTypeCode = value;
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
     * Ruft den Wert der totalMeteredQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalMeteredQuantityType }
     *     
     */
    public TotalMeteredQuantityType getTotalMeteredQuantity() {
        return totalMeteredQuantity;
    }

    /**
     * Legt den Wert der totalMeteredQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalMeteredQuantityType }
     *     
     */
    public void setTotalMeteredQuantity(TotalMeteredQuantityType value) {
        this.totalMeteredQuantity = value;
    }

    /**
     * Ruft den Wert der subscriberParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getSubscriberParty() {
        return subscriberParty;
    }

    /**
     * Legt den Wert der subscriberParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setSubscriberParty(PartyType value) {
        this.subscriberParty = value;
    }

    /**
     * Ruft den Wert der utilityConsumptionPoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionPointType }
     *     
     */
    public ConsumptionPointType getUtilityConsumptionPoint() {
        return utilityConsumptionPoint;
    }

    /**
     * Legt den Wert der utilityConsumptionPoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionPointType }
     *     
     */
    public void setUtilityConsumptionPoint(ConsumptionPointType value) {
        this.utilityConsumptionPoint = value;
    }

    /**
     * Gets the value of the onAccountPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onAccountPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnAccountPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OnAccountPaymentType }
     * 
     * 
     */
    public List<OnAccountPaymentType> getOnAccountPayment() {
        if (onAccountPayment == null) {
            onAccountPayment = new ArrayList<OnAccountPaymentType>();
        }
        return this.onAccountPayment;
    }

    /**
     * Ruft den Wert der consumption-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionType }
     *     
     */
    public ConsumptionType getConsumption() {
        return consumption;
    }

    /**
     * Legt den Wert der consumption-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionType }
     *     
     */
    public void setConsumption(ConsumptionType value) {
        this.consumption = value;
    }

    /**
     * Gets the value of the supplierConsumption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supplierConsumption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupplierConsumption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplierConsumptionType }
     * 
     * 
     */
    public List<SupplierConsumptionType> getSupplierConsumption() {
        if (supplierConsumption == null) {
            supplierConsumption = new ArrayList<SupplierConsumptionType>();
        }
        return this.supplierConsumption;
    }

}
