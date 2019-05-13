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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BasicConsumedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumersEnergyLevelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumersEnergyLevelType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HeatingTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HeatingTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResidenceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResidenceTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResidentOccupantsNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalConsumedQuantityType;


/**
 * <p>Java-Klasse für ConsumptionReportType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalConsumedQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BasicConsumedQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResidentOccupantsNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumersEnergyLevelCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumersEnergyLevel" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResidenceType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResidenceTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HeatingType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HeatingTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Period" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}GuidanceDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsumptionReportReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsumptionHistory" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionReportType", propOrder = {
    "id",
    "consumptionType",
    "consumptionTypeCode",
    "description",
    "totalConsumedQuantity",
    "basicConsumedQuantity",
    "residentOccupantsNumeric",
    "consumersEnergyLevelCode",
    "consumersEnergyLevel",
    "residenceType",
    "residenceTypeCode",
    "heatingType",
    "heatingTypeCode",
    "period",
    "guidanceDocumentReference",
    "documentReference",
    "consumptionReportReference",
    "consumptionHistory"
})
public class ConsumptionReportType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "ConsumptionType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeType consumptionType;
    @XmlElement(name = "ConsumptionTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeCodeType consumptionTypeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "TotalConsumedQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalConsumedQuantityType totalConsumedQuantity;
    @XmlElement(name = "BasicConsumedQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BasicConsumedQuantityType basicConsumedQuantity;
    @XmlElement(name = "ResidentOccupantsNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ResidentOccupantsNumericType residentOccupantsNumeric;
    @XmlElement(name = "ConsumersEnergyLevelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumersEnergyLevelCodeType consumersEnergyLevelCode;
    @XmlElement(name = "ConsumersEnergyLevel", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumersEnergyLevelType consumersEnergyLevel;
    @XmlElement(name = "ResidenceType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ResidenceTypeType residenceType;
    @XmlElement(name = "ResidenceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ResidenceTypeCodeType residenceTypeCode;
    @XmlElement(name = "HeatingType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HeatingTypeType heatingType;
    @XmlElement(name = "HeatingTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HeatingTypeCodeType heatingTypeCode;
    @XmlElement(name = "Period")
    protected PeriodType period;
    @XmlElement(name = "GuidanceDocumentReference")
    protected DocumentReferenceType guidanceDocumentReference;
    @XmlElement(name = "DocumentReference")
    protected DocumentReferenceType documentReference;
    @XmlElement(name = "ConsumptionReportReference")
    protected List<ConsumptionReportReferenceType> consumptionReportReference;
    @XmlElement(name = "ConsumptionHistory")
    protected List<ConsumptionHistoryType> consumptionHistory;

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
     * Ruft den Wert der totalConsumedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalConsumedQuantityType }
     *     
     */
    public TotalConsumedQuantityType getTotalConsumedQuantity() {
        return totalConsumedQuantity;
    }

    /**
     * Legt den Wert der totalConsumedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalConsumedQuantityType }
     *     
     */
    public void setTotalConsumedQuantity(TotalConsumedQuantityType value) {
        this.totalConsumedQuantity = value;
    }

    /**
     * Ruft den Wert der basicConsumedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BasicConsumedQuantityType }
     *     
     */
    public BasicConsumedQuantityType getBasicConsumedQuantity() {
        return basicConsumedQuantity;
    }

    /**
     * Legt den Wert der basicConsumedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicConsumedQuantityType }
     *     
     */
    public void setBasicConsumedQuantity(BasicConsumedQuantityType value) {
        this.basicConsumedQuantity = value;
    }

    /**
     * Ruft den Wert der residentOccupantsNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResidentOccupantsNumericType }
     *     
     */
    public ResidentOccupantsNumericType getResidentOccupantsNumeric() {
        return residentOccupantsNumeric;
    }

    /**
     * Legt den Wert der residentOccupantsNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentOccupantsNumericType }
     *     
     */
    public void setResidentOccupantsNumeric(ResidentOccupantsNumericType value) {
        this.residentOccupantsNumeric = value;
    }

    /**
     * Ruft den Wert der consumersEnergyLevelCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumersEnergyLevelCodeType }
     *     
     */
    public ConsumersEnergyLevelCodeType getConsumersEnergyLevelCode() {
        return consumersEnergyLevelCode;
    }

    /**
     * Legt den Wert der consumersEnergyLevelCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumersEnergyLevelCodeType }
     *     
     */
    public void setConsumersEnergyLevelCode(ConsumersEnergyLevelCodeType value) {
        this.consumersEnergyLevelCode = value;
    }

    /**
     * Ruft den Wert der consumersEnergyLevel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumersEnergyLevelType }
     *     
     */
    public ConsumersEnergyLevelType getConsumersEnergyLevel() {
        return consumersEnergyLevel;
    }

    /**
     * Legt den Wert der consumersEnergyLevel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumersEnergyLevelType }
     *     
     */
    public void setConsumersEnergyLevel(ConsumersEnergyLevelType value) {
        this.consumersEnergyLevel = value;
    }

    /**
     * Ruft den Wert der residenceType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResidenceTypeType }
     *     
     */
    public ResidenceTypeType getResidenceType() {
        return residenceType;
    }

    /**
     * Legt den Wert der residenceType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidenceTypeType }
     *     
     */
    public void setResidenceType(ResidenceTypeType value) {
        this.residenceType = value;
    }

    /**
     * Ruft den Wert der residenceTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResidenceTypeCodeType }
     *     
     */
    public ResidenceTypeCodeType getResidenceTypeCode() {
        return residenceTypeCode;
    }

    /**
     * Legt den Wert der residenceTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidenceTypeCodeType }
     *     
     */
    public void setResidenceTypeCode(ResidenceTypeCodeType value) {
        this.residenceTypeCode = value;
    }

    /**
     * Ruft den Wert der heatingType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HeatingTypeType }
     *     
     */
    public HeatingTypeType getHeatingType() {
        return heatingType;
    }

    /**
     * Legt den Wert der heatingType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HeatingTypeType }
     *     
     */
    public void setHeatingType(HeatingTypeType value) {
        this.heatingType = value;
    }

    /**
     * Ruft den Wert der heatingTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HeatingTypeCodeType }
     *     
     */
    public HeatingTypeCodeType getHeatingTypeCode() {
        return heatingTypeCode;
    }

    /**
     * Legt den Wert der heatingTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HeatingTypeCodeType }
     *     
     */
    public void setHeatingTypeCode(HeatingTypeCodeType value) {
        this.heatingTypeCode = value;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPeriod(PeriodType value) {
        this.period = value;
    }

    /**
     * Ruft den Wert der guidanceDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getGuidanceDocumentReference() {
        return guidanceDocumentReference;
    }

    /**
     * Legt den Wert der guidanceDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setGuidanceDocumentReference(DocumentReferenceType value) {
        this.guidanceDocumentReference = value;
    }

    /**
     * Ruft den Wert der documentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getDocumentReference() {
        return documentReference;
    }

    /**
     * Legt den Wert der documentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setDocumentReference(DocumentReferenceType value) {
        this.documentReference = value;
    }

    /**
     * Gets the value of the consumptionReportReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionReportReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionReportReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionReportReferenceType }
     * 
     * 
     */
    public List<ConsumptionReportReferenceType> getConsumptionReportReference() {
        if (consumptionReportReference == null) {
            consumptionReportReference = new ArrayList<ConsumptionReportReferenceType>();
        }
        return this.consumptionReportReference;
    }

    /**
     * Gets the value of the consumptionHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionHistoryType }
     * 
     * 
     */
    public List<ConsumptionHistoryType> getConsumptionHistory() {
        if (consumptionHistory == null) {
            consumptionHistory = new ArrayList<ConsumptionHistoryType>();
        }
        return this.consumptionHistory;
    }

}
