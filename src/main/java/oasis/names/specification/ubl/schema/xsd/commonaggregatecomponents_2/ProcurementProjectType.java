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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedOverallContractQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FeeDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProcurementSubTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProcurementTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QualityControlCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredFeeAmountType;


/**
 * <p>Java-Klasse für ProcurementProjectType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ProcurementProjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name" maxOccurs="unbounded"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProcurementTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProcurementSubTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}QualityControlCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequiredFeeAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FeeDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequestedDeliveryDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EstimatedOverallContractQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestedTenderTotal" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MainCommodityClassification" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalCommodityClassification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RealizedLocation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PlannedPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractExtension" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestForTenderLine" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcurementProjectType", propOrder = {
    "id",
    "name",
    "description",
    "procurementTypeCode",
    "procurementSubTypeCode",
    "qualityControlCode",
    "requiredFeeAmount",
    "feeDescription",
    "requestedDeliveryDate",
    "estimatedOverallContractQuantity",
    "note",
    "requestedTenderTotal",
    "mainCommodityClassification",
    "additionalCommodityClassification",
    "realizedLocation",
    "plannedPeriod",
    "contractExtension",
    "requestForTenderLine"
})
public class ProcurementProjectType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected List<NameType> name;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "ProcurementTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProcurementTypeCodeType procurementTypeCode;
    @XmlElement(name = "ProcurementSubTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProcurementSubTypeCodeType procurementSubTypeCode;
    @XmlElement(name = "QualityControlCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QualityControlCodeType qualityControlCode;
    @XmlElement(name = "RequiredFeeAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequiredFeeAmountType requiredFeeAmount;
    @XmlElement(name = "FeeDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<FeeDescriptionType> feeDescription;
    @XmlElement(name = "RequestedDeliveryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequestedDeliveryDateType requestedDeliveryDate;
    @XmlElement(name = "EstimatedOverallContractQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EstimatedOverallContractQuantityType estimatedOverallContractQuantity;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "RequestedTenderTotal")
    protected RequestedTenderTotalType requestedTenderTotal;
    @XmlElement(name = "MainCommodityClassification")
    protected CommodityClassificationType mainCommodityClassification;
    @XmlElement(name = "AdditionalCommodityClassification")
    protected List<CommodityClassificationType> additionalCommodityClassification;
    @XmlElement(name = "RealizedLocation")
    protected List<LocationType> realizedLocation;
    @XmlElement(name = "PlannedPeriod")
    protected PeriodType plannedPeriod;
    @XmlElement(name = "ContractExtension")
    protected ContractExtensionType contractExtension;
    @XmlElement(name = "RequestForTenderLine")
    protected List<RequestForTenderLineType> requestForTenderLine;

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
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     * 
     * 
     */
    public List<NameType> getName() {
        if (name == null) {
            name = new ArrayList<NameType>();
        }
        return this.name;
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
     * Ruft den Wert der procurementTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProcurementTypeCodeType }
     *     
     */
    public ProcurementTypeCodeType getProcurementTypeCode() {
        return procurementTypeCode;
    }

    /**
     * Legt den Wert der procurementTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementTypeCodeType }
     *     
     */
    public void setProcurementTypeCode(ProcurementTypeCodeType value) {
        this.procurementTypeCode = value;
    }

    /**
     * Ruft den Wert der procurementSubTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProcurementSubTypeCodeType }
     *     
     */
    public ProcurementSubTypeCodeType getProcurementSubTypeCode() {
        return procurementSubTypeCode;
    }

    /**
     * Legt den Wert der procurementSubTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementSubTypeCodeType }
     *     
     */
    public void setProcurementSubTypeCode(ProcurementSubTypeCodeType value) {
        this.procurementSubTypeCode = value;
    }

    /**
     * Ruft den Wert der qualityControlCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QualityControlCodeType }
     *     
     */
    public QualityControlCodeType getQualityControlCode() {
        return qualityControlCode;
    }

    /**
     * Legt den Wert der qualityControlCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityControlCodeType }
     *     
     */
    public void setQualityControlCode(QualityControlCodeType value) {
        this.qualityControlCode = value;
    }

    /**
     * Ruft den Wert der requiredFeeAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequiredFeeAmountType }
     *     
     */
    public RequiredFeeAmountType getRequiredFeeAmount() {
        return requiredFeeAmount;
    }

    /**
     * Legt den Wert der requiredFeeAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredFeeAmountType }
     *     
     */
    public void setRequiredFeeAmount(RequiredFeeAmountType value) {
        this.requiredFeeAmount = value;
    }

    /**
     * Gets the value of the feeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeDescriptionType }
     * 
     * 
     */
    public List<FeeDescriptionType> getFeeDescription() {
        if (feeDescription == null) {
            feeDescription = new ArrayList<FeeDescriptionType>();
        }
        return this.feeDescription;
    }

    /**
     * Ruft den Wert der requestedDeliveryDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequestedDeliveryDateType }
     *     
     */
    public RequestedDeliveryDateType getRequestedDeliveryDate() {
        return requestedDeliveryDate;
    }

    /**
     * Legt den Wert der requestedDeliveryDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedDeliveryDateType }
     *     
     */
    public void setRequestedDeliveryDate(RequestedDeliveryDateType value) {
        this.requestedDeliveryDate = value;
    }

    /**
     * Ruft den Wert der estimatedOverallContractQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EstimatedOverallContractQuantityType }
     *     
     */
    public EstimatedOverallContractQuantityType getEstimatedOverallContractQuantity() {
        return estimatedOverallContractQuantity;
    }

    /**
     * Legt den Wert der estimatedOverallContractQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedOverallContractQuantityType }
     *     
     */
    public void setEstimatedOverallContractQuantity(EstimatedOverallContractQuantityType value) {
        this.estimatedOverallContractQuantity = value;
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
     * Ruft den Wert der requestedTenderTotal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequestedTenderTotalType }
     *     
     */
    public RequestedTenderTotalType getRequestedTenderTotal() {
        return requestedTenderTotal;
    }

    /**
     * Legt den Wert der requestedTenderTotal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedTenderTotalType }
     *     
     */
    public void setRequestedTenderTotal(RequestedTenderTotalType value) {
        this.requestedTenderTotal = value;
    }

    /**
     * Ruft den Wert der mainCommodityClassification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CommodityClassificationType }
     *     
     */
    public CommodityClassificationType getMainCommodityClassification() {
        return mainCommodityClassification;
    }

    /**
     * Legt den Wert der mainCommodityClassification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityClassificationType }
     *     
     */
    public void setMainCommodityClassification(CommodityClassificationType value) {
        this.mainCommodityClassification = value;
    }

    /**
     * Gets the value of the additionalCommodityClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalCommodityClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalCommodityClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityClassificationType }
     * 
     * 
     */
    public List<CommodityClassificationType> getAdditionalCommodityClassification() {
        if (additionalCommodityClassification == null) {
            additionalCommodityClassification = new ArrayList<CommodityClassificationType>();
        }
        return this.additionalCommodityClassification;
    }

    /**
     * Gets the value of the realizedLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realizedLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealizedLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationType }
     * 
     * 
     */
    public List<LocationType> getRealizedLocation() {
        if (realizedLocation == null) {
            realizedLocation = new ArrayList<LocationType>();
        }
        return this.realizedLocation;
    }

    /**
     * Ruft den Wert der plannedPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPlannedPeriod() {
        return plannedPeriod;
    }

    /**
     * Legt den Wert der plannedPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPlannedPeriod(PeriodType value) {
        this.plannedPeriod = value;
    }

    /**
     * Ruft den Wert der contractExtension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContractExtensionType }
     *     
     */
    public ContractExtensionType getContractExtension() {
        return contractExtension;
    }

    /**
     * Legt den Wert der contractExtension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractExtensionType }
     *     
     */
    public void setContractExtension(ContractExtensionType value) {
        this.contractExtension = value;
    }

    /**
     * Gets the value of the requestForTenderLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestForTenderLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestForTenderLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestForTenderLineType }
     * 
     * 
     */
    public List<RequestForTenderLineType> getRequestForTenderLine() {
        if (requestForTenderLine == null) {
            requestForTenderLine = new ArrayList<RequestForTenderLineType>();
        }
        return this.requestForTenderLine;
    }

}
