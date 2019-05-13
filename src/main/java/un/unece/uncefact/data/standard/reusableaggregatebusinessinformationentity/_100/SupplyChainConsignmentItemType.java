//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.GoodsTypeCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.GoodsTypeExtensionCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.WeightUnitMeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;


/**
 * <p>Java-Klasse für SupplyChainConsignmentItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SupplyChainConsignmentItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}GoodsTypeCodeType" minOccurs="0"/>
 *         &lt;element name="TypeExtensionCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}GoodsTypeExtensionCodeType" minOccurs="0"/>
 *         &lt;element name="DeclaredValueForCustomsAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/>
 *         &lt;element name="DeclaredValueForStatisticsAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/>
 *         &lt;element name="InvoiceAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrossWeightMeasure" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}WeightUnitMeasureType" minOccurs="0"/>
 *         &lt;element name="NetWeightMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="TariffQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="NatureIdentificationTransportCargo" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TransportCargoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainConsignmentItemType", propOrder = {
    "typeCode",
    "typeExtensionCode",
    "declaredValueForCustomsAmount",
    "declaredValueForStatisticsAmount",
    "invoiceAmount",
    "grossWeightMeasure",
    "netWeightMeasure",
    "tariffQuantity",
    "natureIdentificationTransportCargo"
})
public class SupplyChainConsignmentItemType {

    @XmlElement(name = "TypeCode")
    protected GoodsTypeCodeType typeCode;
    @XmlElement(name = "TypeExtensionCode")
    protected GoodsTypeExtensionCodeType typeExtensionCode;
    @XmlElement(name = "DeclaredValueForCustomsAmount")
    protected AmountType declaredValueForCustomsAmount;
    @XmlElement(name = "DeclaredValueForStatisticsAmount")
    protected AmountType declaredValueForStatisticsAmount;
    @XmlElement(name = "InvoiceAmount")
    protected List<AmountType> invoiceAmount;
    @XmlElement(name = "GrossWeightMeasure")
    protected WeightUnitMeasureType grossWeightMeasure;
    @XmlElement(name = "NetWeightMeasure")
    protected MeasureType netWeightMeasure;
    @XmlElement(name = "TariffQuantity")
    protected QuantityType tariffQuantity;
    @XmlElement(name = "NatureIdentificationTransportCargo")
    protected TransportCargoType natureIdentificationTransportCargo;

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GoodsTypeCodeType }
     *     
     */
    public GoodsTypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GoodsTypeCodeType }
     *     
     */
    public void setTypeCode(GoodsTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der typeExtensionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GoodsTypeExtensionCodeType }
     *     
     */
    public GoodsTypeExtensionCodeType getTypeExtensionCode() {
        return typeExtensionCode;
    }

    /**
     * Legt den Wert der typeExtensionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GoodsTypeExtensionCodeType }
     *     
     */
    public void setTypeExtensionCode(GoodsTypeExtensionCodeType value) {
        this.typeExtensionCode = value;
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
     * Ruft den Wert der declaredValueForStatisticsAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDeclaredValueForStatisticsAmount() {
        return declaredValueForStatisticsAmount;
    }

    /**
     * Legt den Wert der declaredValueForStatisticsAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDeclaredValueForStatisticsAmount(AmountType value) {
        this.declaredValueForStatisticsAmount = value;
    }

    /**
     * Gets the value of the invoiceAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getInvoiceAmount() {
        if (invoiceAmount == null) {
            invoiceAmount = new ArrayList<AmountType>();
        }
        return this.invoiceAmount;
    }

    /**
     * Ruft den Wert der grossWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public WeightUnitMeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    /**
     * Legt den Wert der grossWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightUnitMeasureType }
     *     
     */
    public void setGrossWeightMeasure(WeightUnitMeasureType value) {
        this.grossWeightMeasure = value;
    }

    /**
     * Ruft den Wert der netWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    /**
     * Legt den Wert der netWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setNetWeightMeasure(MeasureType value) {
        this.netWeightMeasure = value;
    }

    /**
     * Ruft den Wert der tariffQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getTariffQuantity() {
        return tariffQuantity;
    }

    /**
     * Legt den Wert der tariffQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setTariffQuantity(QuantityType value) {
        this.tariffQuantity = value;
    }

    /**
     * Ruft den Wert der natureIdentificationTransportCargo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportCargoType }
     *     
     */
    public TransportCargoType getNatureIdentificationTransportCargo() {
        return natureIdentificationTransportCargo;
    }

    /**
     * Legt den Wert der natureIdentificationTransportCargo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportCargoType }
     *     
     */
    public void setNatureIdentificationTransportCargo(TransportCargoType value) {
        this.natureIdentificationTransportCargo = value;
    }

}
