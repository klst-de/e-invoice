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
import un.unece.uncefact.data.standard.qualifieddatatype._100.VolumeUnitMeasureType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.WeightUnitMeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;


/**
 * <p>Java-Klasse für SupplyChainConsignmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SupplyChainConsignmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrossWeightMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}WeightUnitMeasureType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="NetWeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="GrossVolumeMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}VolumeUnitMeasureType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="InsurancePremiumAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AssociatedInvoiceAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TotalChargeAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="DeclaredValueForCustomsAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="PackageQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="ConsignorTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="ConsigneeTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="CarrierTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="FreightForwarderTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="CustomsImportAgentTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="CustomsExportAgentTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="GroupingCentreTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TransportContractReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="AssociatedReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="IncludedSupplyChainConsignmentItem" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainConsignmentItemType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="UtilizedLogisticsTransportEquipment" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsTransportEquipmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SpecifiedLogisticsTransportMovement" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsTransportMovementType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainConsignmentType", propOrder = {
    "grossWeightMeasure",
    "netWeightMeasure",
    "grossVolumeMeasure",
    "insurancePremiumAmount",
    "associatedInvoiceAmount",
    "totalChargeAmount",
    "declaredValueForCustomsAmount",
    "packageQuantity",
    "consignorTradeParty",
    "consigneeTradeParty",
    "carrierTradeParty",
    "freightForwarderTradeParty",
    "deliveryTradeParty",
    "customsImportAgentTradeParty",
    "customsExportAgentTradeParty",
    "groupingCentreTradeParty",
    "transportContractReferencedDocument",
    "associatedReferencedDocument",
    "includedSupplyChainConsignmentItem",
    "utilizedLogisticsTransportEquipment",
    "specifiedLogisticsTransportMovement"
})
public class SupplyChainConsignmentType {

    @XmlElement(name = "GrossWeightMeasure")
    protected List<WeightUnitMeasureType> grossWeightMeasure;
    @XmlElement(name = "NetWeightMeasure")
    protected List<MeasureType> netWeightMeasure;
    @XmlElement(name = "GrossVolumeMeasure")
    protected List<VolumeUnitMeasureType> grossVolumeMeasure;
    @XmlElement(name = "InsurancePremiumAmount")
    protected AmountType insurancePremiumAmount;
    @XmlElement(name = "AssociatedInvoiceAmount")
    protected List<AmountType> associatedInvoiceAmount;
    @XmlElement(name = "TotalChargeAmount")
    protected AmountType totalChargeAmount;
    @XmlElement(name = "DeclaredValueForCustomsAmount")
    protected AmountType declaredValueForCustomsAmount;
    @XmlElement(name = "PackageQuantity")
    protected QuantityType packageQuantity;
    @XmlElement(name = "ConsignorTradeParty")
    protected TradePartyType consignorTradeParty;
    @XmlElement(name = "ConsigneeTradeParty")
    protected TradePartyType consigneeTradeParty;
    @XmlElement(name = "CarrierTradeParty")
    protected TradePartyType carrierTradeParty;
    @XmlElement(name = "FreightForwarderTradeParty")
    protected TradePartyType freightForwarderTradeParty;
    @XmlElement(name = "DeliveryTradeParty")
    protected TradePartyType deliveryTradeParty;
    @XmlElement(name = "CustomsImportAgentTradeParty")
    protected TradePartyType customsImportAgentTradeParty;
    @XmlElement(name = "CustomsExportAgentTradeParty")
    protected TradePartyType customsExportAgentTradeParty;
    @XmlElement(name = "GroupingCentreTradeParty")
    protected List<TradePartyType> groupingCentreTradeParty;
    @XmlElement(name = "TransportContractReferencedDocument")
    protected ReferencedDocumentType transportContractReferencedDocument;
    @XmlElement(name = "AssociatedReferencedDocument")
    protected List<ReferencedDocumentType> associatedReferencedDocument;
    @XmlElement(name = "IncludedSupplyChainConsignmentItem")
    protected List<SupplyChainConsignmentItemType> includedSupplyChainConsignmentItem;
    @XmlElement(name = "UtilizedLogisticsTransportEquipment")
    protected List<LogisticsTransportEquipmentType> utilizedLogisticsTransportEquipment;
    @XmlElement(name = "SpecifiedLogisticsTransportMovement")
    protected List<LogisticsTransportMovementType> specifiedLogisticsTransportMovement;

    /**
     * Gets the value of the grossWeightMeasure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grossWeightMeasure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrossWeightMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WeightUnitMeasureType }
     * 
     * 
     */
    public List<WeightUnitMeasureType> getGrossWeightMeasure() {
        if (grossWeightMeasure == null) {
            grossWeightMeasure = new ArrayList<WeightUnitMeasureType>();
        }
        return this.grossWeightMeasure;
    }

    /**
     * Gets the value of the netWeightMeasure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netWeightMeasure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetWeightMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureType }
     * 
     * 
     */
    public List<MeasureType> getNetWeightMeasure() {
        if (netWeightMeasure == null) {
            netWeightMeasure = new ArrayList<MeasureType>();
        }
        return this.netWeightMeasure;
    }

    /**
     * Gets the value of the grossVolumeMeasure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grossVolumeMeasure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrossVolumeMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VolumeUnitMeasureType }
     * 
     * 
     */
    public List<VolumeUnitMeasureType> getGrossVolumeMeasure() {
        if (grossVolumeMeasure == null) {
            grossVolumeMeasure = new ArrayList<VolumeUnitMeasureType>();
        }
        return this.grossVolumeMeasure;
    }

    /**
     * Ruft den Wert der insurancePremiumAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getInsurancePremiumAmount() {
        return insurancePremiumAmount;
    }

    /**
     * Legt den Wert der insurancePremiumAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setInsurancePremiumAmount(AmountType value) {
        this.insurancePremiumAmount = value;
    }

    /**
     * Gets the value of the associatedInvoiceAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedInvoiceAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedInvoiceAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getAssociatedInvoiceAmount() {
        if (associatedInvoiceAmount == null) {
            associatedInvoiceAmount = new ArrayList<AmountType>();
        }
        return this.associatedInvoiceAmount;
    }

    /**
     * Ruft den Wert der totalChargeAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTotalChargeAmount() {
        return totalChargeAmount;
    }

    /**
     * Legt den Wert der totalChargeAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTotalChargeAmount(AmountType value) {
        this.totalChargeAmount = value;
    }

    /**
     * Ruft den Wert der declaredValueForCustomsAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDeclaredValueForCustomsAmount() {
        return declaredValueForCustomsAmount;
    }

    /**
     * Legt den Wert der declaredValueForCustomsAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDeclaredValueForCustomsAmount(AmountType value) {
        this.declaredValueForCustomsAmount = value;
    }

    /**
     * Ruft den Wert der packageQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * Legt den Wert der packageQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setPackageQuantity(QuantityType value) {
        this.packageQuantity = value;
    }

    /**
     * Ruft den Wert der consignorTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getConsignorTradeParty() {
        return consignorTradeParty;
    }

    /**
     * Legt den Wert der consignorTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setConsignorTradeParty(TradePartyType value) {
        this.consignorTradeParty = value;
    }

    /**
     * Ruft den Wert der consigneeTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getConsigneeTradeParty() {
        return consigneeTradeParty;
    }

    /**
     * Legt den Wert der consigneeTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setConsigneeTradeParty(TradePartyType value) {
        this.consigneeTradeParty = value;
    }

    /**
     * Ruft den Wert der carrierTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getCarrierTradeParty() {
        return carrierTradeParty;
    }

    /**
     * Legt den Wert der carrierTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setCarrierTradeParty(TradePartyType value) {
        this.carrierTradeParty = value;
    }

    /**
     * Ruft den Wert der freightForwarderTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getFreightForwarderTradeParty() {
        return freightForwarderTradeParty;
    }

    /**
     * Legt den Wert der freightForwarderTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setFreightForwarderTradeParty(TradePartyType value) {
        this.freightForwarderTradeParty = value;
    }

    /**
     * Ruft den Wert der deliveryTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getDeliveryTradeParty() {
        return deliveryTradeParty;
    }

    /**
     * Legt den Wert der deliveryTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setDeliveryTradeParty(TradePartyType value) {
        this.deliveryTradeParty = value;
    }

    /**
     * Ruft den Wert der customsImportAgentTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getCustomsImportAgentTradeParty() {
        return customsImportAgentTradeParty;
    }

    /**
     * Legt den Wert der customsImportAgentTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setCustomsImportAgentTradeParty(TradePartyType value) {
        this.customsImportAgentTradeParty = value;
    }

    /**
     * Ruft den Wert der customsExportAgentTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getCustomsExportAgentTradeParty() {
        return customsExportAgentTradeParty;
    }

    /**
     * Legt den Wert der customsExportAgentTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setCustomsExportAgentTradeParty(TradePartyType value) {
        this.customsExportAgentTradeParty = value;
    }

    /**
     * Gets the value of the groupingCentreTradeParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupingCentreTradeParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupingCentreTradeParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradePartyType }
     * 
     * 
     */
    public List<TradePartyType> getGroupingCentreTradeParty() {
        if (groupingCentreTradeParty == null) {
            groupingCentreTradeParty = new ArrayList<TradePartyType>();
        }
        return this.groupingCentreTradeParty;
    }

    /**
     * Ruft den Wert der transportContractReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getTransportContractReferencedDocument() {
        return transportContractReferencedDocument;
    }

    /**
     * Legt den Wert der transportContractReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setTransportContractReferencedDocument(ReferencedDocumentType value) {
        this.transportContractReferencedDocument = value;
    }

    /**
     * Gets the value of the associatedReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getAssociatedReferencedDocument() {
        if (associatedReferencedDocument == null) {
            associatedReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.associatedReferencedDocument;
    }

    /**
     * Gets the value of the includedSupplyChainConsignmentItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedSupplyChainConsignmentItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedSupplyChainConsignmentItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyChainConsignmentItemType }
     * 
     * 
     */
    public List<SupplyChainConsignmentItemType> getIncludedSupplyChainConsignmentItem() {
        if (includedSupplyChainConsignmentItem == null) {
            includedSupplyChainConsignmentItem = new ArrayList<SupplyChainConsignmentItemType>();
        }
        return this.includedSupplyChainConsignmentItem;
    }

    /**
     * Gets the value of the utilizedLogisticsTransportEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the utilizedLogisticsTransportEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUtilizedLogisticsTransportEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogisticsTransportEquipmentType }
     * 
     * 
     */
    public List<LogisticsTransportEquipmentType> getUtilizedLogisticsTransportEquipment() {
        if (utilizedLogisticsTransportEquipment == null) {
            utilizedLogisticsTransportEquipment = new ArrayList<LogisticsTransportEquipmentType>();
        }
        return this.utilizedLogisticsTransportEquipment;
    }

    /**
     * Gets the value of the specifiedLogisticsTransportMovement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifiedLogisticsTransportMovement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifiedLogisticsTransportMovement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogisticsTransportMovementType }
     * 
     * 
     */
    public List<LogisticsTransportMovementType> getSpecifiedLogisticsTransportMovement() {
        if (specifiedLogisticsTransportMovement == null) {
            specifiedLogisticsTransportMovement = new ArrayList<LogisticsTransportMovementType>();
        }
        return this.specifiedLogisticsTransportMovement;
    }

}
