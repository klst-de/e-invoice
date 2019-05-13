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
import un.unece.uncefact.data.standard.qualifieddatatype._100.ChargePayingPartyRoleCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.FreightChargeTariffClassCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.FreightChargeTypeIDType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.LogisticsChargeCalculationBasisCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für LogisticsServiceChargeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LogisticsServiceChargeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}FreightChargeTypeIDType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PaymentArrangementCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="TariffClassCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}FreightChargeTariffClassCodeType" minOccurs="0"/>
 *         &lt;element name="ChargeCategoryCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ServiceCategoryCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="DisbursementAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AppliedAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AllowanceCharge" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="PayingPartyRoleCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}ChargePayingPartyRoleCodeType" minOccurs="0"/>
 *         &lt;element name="CalculationBasisCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}LogisticsChargeCalculationBasisCodeType" minOccurs="0"/>
 *         &lt;element name="CalculationBasis" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="TransportPaymentMethodCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="PaymentPlaceLogisticsLocation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsLocationType" minOccurs="0"/>
 *         &lt;element name="AppliedFromLogisticsLocation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsLocationType" minOccurs="0"/>
 *         &lt;element name="AppliedToLogisticsLocation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsLocationType" minOccurs="0"/>
 *         &lt;element name="AppliedTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogisticsServiceChargeType", propOrder = {
    "id",
    "description",
    "paymentArrangementCode",
    "tariffClassCode",
    "chargeCategoryCode",
    "serviceCategoryCode",
    "disbursementAmount",
    "appliedAmount",
    "allowanceCharge",
    "payingPartyRoleCode",
    "calculationBasisCode",
    "calculationBasis",
    "transportPaymentMethodCode",
    "paymentPlaceLogisticsLocation",
    "appliedFromLogisticsLocation",
    "appliedToLogisticsLocation",
    "appliedTradeTax"
})
public class LogisticsServiceChargeType {

    @XmlElement(name = "ID")
    protected FreightChargeTypeIDType id;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "PaymentArrangementCode")
    protected CodeType paymentArrangementCode;
    @XmlElement(name = "TariffClassCode")
    protected FreightChargeTariffClassCodeType tariffClassCode;
    @XmlElement(name = "ChargeCategoryCode")
    protected CodeType chargeCategoryCode;
    @XmlElement(name = "ServiceCategoryCode")
    protected CodeType serviceCategoryCode;
    @XmlElement(name = "DisbursementAmount")
    protected List<AmountType> disbursementAmount;
    @XmlElement(name = "AppliedAmount")
    protected List<AmountType> appliedAmount;
    @XmlElement(name = "AllowanceCharge")
    protected TextType allowanceCharge;
    @XmlElement(name = "PayingPartyRoleCode")
    protected ChargePayingPartyRoleCodeType payingPartyRoleCode;
    @XmlElement(name = "CalculationBasisCode")
    protected LogisticsChargeCalculationBasisCodeType calculationBasisCode;
    @XmlElement(name = "CalculationBasis")
    protected TextType calculationBasis;
    @XmlElement(name = "TransportPaymentMethodCode")
    protected CodeType transportPaymentMethodCode;
    @XmlElement(name = "PaymentPlaceLogisticsLocation")
    protected LogisticsLocationType paymentPlaceLogisticsLocation;
    @XmlElement(name = "AppliedFromLogisticsLocation")
    protected LogisticsLocationType appliedFromLogisticsLocation;
    @XmlElement(name = "AppliedToLogisticsLocation")
    protected LogisticsLocationType appliedToLogisticsLocation;
    @XmlElement(name = "AppliedTradeTax")
    protected List<TradeTaxType> appliedTradeTax;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FreightChargeTypeIDType }
     *     
     */
    public FreightChargeTypeIDType getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightChargeTypeIDType }
     *     
     */
    public void setID(FreightChargeTypeIDType value) {
        this.id = value;
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
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDescription() {
        if (description == null) {
            description = new ArrayList<TextType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der paymentArrangementCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getPaymentArrangementCode() {
        return paymentArrangementCode;
    }

    /**
     * Legt den Wert der paymentArrangementCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setPaymentArrangementCode(CodeType value) {
        this.paymentArrangementCode = value;
    }

    /**
     * Ruft den Wert der tariffClassCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FreightChargeTariffClassCodeType }
     *     
     */
    public FreightChargeTariffClassCodeType getTariffClassCode() {
        return tariffClassCode;
    }

    /**
     * Legt den Wert der tariffClassCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightChargeTariffClassCodeType }
     *     
     */
    public void setTariffClassCode(FreightChargeTariffClassCodeType value) {
        this.tariffClassCode = value;
    }

    /**
     * Ruft den Wert der chargeCategoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getChargeCategoryCode() {
        return chargeCategoryCode;
    }

    /**
     * Legt den Wert der chargeCategoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setChargeCategoryCode(CodeType value) {
        this.chargeCategoryCode = value;
    }

    /**
     * Ruft den Wert der serviceCategoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getServiceCategoryCode() {
        return serviceCategoryCode;
    }

    /**
     * Legt den Wert der serviceCategoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setServiceCategoryCode(CodeType value) {
        this.serviceCategoryCode = value;
    }

    /**
     * Gets the value of the disbursementAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disbursementAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisbursementAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getDisbursementAmount() {
        if (disbursementAmount == null) {
            disbursementAmount = new ArrayList<AmountType>();
        }
        return this.disbursementAmount;
    }

    /**
     * Gets the value of the appliedAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appliedAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppliedAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getAppliedAmount() {
        if (appliedAmount == null) {
            appliedAmount = new ArrayList<AmountType>();
        }
        return this.appliedAmount;
    }

    /**
     * Ruft den Wert der allowanceCharge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAllowanceCharge() {
        return allowanceCharge;
    }

    /**
     * Legt den Wert der allowanceCharge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAllowanceCharge(TextType value) {
        this.allowanceCharge = value;
    }

    /**
     * Ruft den Wert der payingPartyRoleCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargePayingPartyRoleCodeType }
     *     
     */
    public ChargePayingPartyRoleCodeType getPayingPartyRoleCode() {
        return payingPartyRoleCode;
    }

    /**
     * Legt den Wert der payingPartyRoleCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargePayingPartyRoleCodeType }
     *     
     */
    public void setPayingPartyRoleCode(ChargePayingPartyRoleCodeType value) {
        this.payingPartyRoleCode = value;
    }

    /**
     * Ruft den Wert der calculationBasisCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LogisticsChargeCalculationBasisCodeType }
     *     
     */
    public LogisticsChargeCalculationBasisCodeType getCalculationBasisCode() {
        return calculationBasisCode;
    }

    /**
     * Legt den Wert der calculationBasisCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LogisticsChargeCalculationBasisCodeType }
     *     
     */
    public void setCalculationBasisCode(LogisticsChargeCalculationBasisCodeType value) {
        this.calculationBasisCode = value;
    }

    /**
     * Ruft den Wert der calculationBasis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCalculationBasis() {
        return calculationBasis;
    }

    /**
     * Legt den Wert der calculationBasis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCalculationBasis(TextType value) {
        this.calculationBasis = value;
    }

    /**
     * Ruft den Wert der transportPaymentMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getTransportPaymentMethodCode() {
        return transportPaymentMethodCode;
    }

    /**
     * Legt den Wert der transportPaymentMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setTransportPaymentMethodCode(CodeType value) {
        this.transportPaymentMethodCode = value;
    }

    /**
     * Ruft den Wert der paymentPlaceLogisticsLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LogisticsLocationType }
     *     
     */
    public LogisticsLocationType getPaymentPlaceLogisticsLocation() {
        return paymentPlaceLogisticsLocation;
    }

    /**
     * Legt den Wert der paymentPlaceLogisticsLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LogisticsLocationType }
     *     
     */
    public void setPaymentPlaceLogisticsLocation(LogisticsLocationType value) {
        this.paymentPlaceLogisticsLocation = value;
    }

    /**
     * Ruft den Wert der appliedFromLogisticsLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LogisticsLocationType }
     *     
     */
    public LogisticsLocationType getAppliedFromLogisticsLocation() {
        return appliedFromLogisticsLocation;
    }

    /**
     * Legt den Wert der appliedFromLogisticsLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LogisticsLocationType }
     *     
     */
    public void setAppliedFromLogisticsLocation(LogisticsLocationType value) {
        this.appliedFromLogisticsLocation = value;
    }

    /**
     * Ruft den Wert der appliedToLogisticsLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LogisticsLocationType }
     *     
     */
    public LogisticsLocationType getAppliedToLogisticsLocation() {
        return appliedToLogisticsLocation;
    }

    /**
     * Legt den Wert der appliedToLogisticsLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LogisticsLocationType }
     *     
     */
    public void setAppliedToLogisticsLocation(LogisticsLocationType value) {
        this.appliedToLogisticsLocation = value;
    }

    /**
     * Gets the value of the appliedTradeTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appliedTradeTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppliedTradeTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeTaxType }
     * 
     * 
     */
    public List<TradeTaxType> getAppliedTradeTax() {
        if (appliedTradeTax == null) {
            appliedTradeTax = new ArrayList<TradeTaxType>();
        }
        return this.appliedTradeTax;
    }

}
