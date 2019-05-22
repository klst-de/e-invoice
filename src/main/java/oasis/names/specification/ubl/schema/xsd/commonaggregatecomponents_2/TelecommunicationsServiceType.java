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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallBaseAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MovieTitleType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayPerViewType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoamingPartnerNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ServiceNumberCalledType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TelecommunicationsServiceCallCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TelecommunicationsServiceCallType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TelecommunicationsServiceCategoryCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TelecommunicationsServiceCategoryType;


/**
 * <p>Java-Klasse für TelecommunicationsServiceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TelecommunicationsServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CallDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CallTime"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ServiceNumberCalled"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TelecommunicationsServiceCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TelecommunicationsServiceCategoryCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MovieTitle" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RoamingPartnerName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PayPerView" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TelecommunicationsServiceCall" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TelecommunicationsServiceCallCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CallBaseAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CallExtensionAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Price" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Country" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExchangeRate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CallDuty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TimeDuty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelecommunicationsServiceType", propOrder = {
    "id",
    "callDate",
    "callTime",
    "serviceNumberCalled",
    "telecommunicationsServiceCategory",
    "telecommunicationsServiceCategoryCode",
    "movieTitle",
    "roamingPartnerName",
    "payPerView",
    "quantity",
    "telecommunicationsServiceCall",
    "telecommunicationsServiceCallCode",
    "callBaseAmount",
    "callExtensionAmount",
    "price",
    "country",
    "exchangeRate",
    "allowanceCharge",
    "taxTotal",
    "callDuty",
    "timeDuty"
})
public class TelecommunicationsServiceType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "CallDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected CallDateType callDate;
    @XmlElement(name = "CallTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected CallTimeType callTime;
    @XmlElement(name = "ServiceNumberCalled", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ServiceNumberCalledType serviceNumberCalled;
    @XmlElement(name = "TelecommunicationsServiceCategory", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TelecommunicationsServiceCategoryType telecommunicationsServiceCategory;
    @XmlElement(name = "TelecommunicationsServiceCategoryCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TelecommunicationsServiceCategoryCodeType telecommunicationsServiceCategoryCode;
    @XmlElement(name = "MovieTitle", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MovieTitleType movieTitle;
    @XmlElement(name = "RoamingPartnerName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RoamingPartnerNameType roamingPartnerName;
    @XmlElement(name = "PayPerView", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PayPerViewType payPerView;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "TelecommunicationsServiceCall", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TelecommunicationsServiceCallType telecommunicationsServiceCall;
    @XmlElement(name = "TelecommunicationsServiceCallCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TelecommunicationsServiceCallCodeType telecommunicationsServiceCallCode;
    @XmlElement(name = "CallBaseAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CallBaseAmountType callBaseAmount;
    @XmlElement(name = "CallExtensionAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CallExtensionAmountType callExtensionAmount;
    @XmlElement(name = "Price")
    protected PriceType price;
    @XmlElement(name = "Country")
    protected CountryType country;
    @XmlElement(name = "ExchangeRate")
    protected List<ExchangeRateType> exchangeRate;
    @XmlElement(name = "AllowanceCharge")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "TaxTotal")
    protected List<TaxTotalType> taxTotal;
    @XmlElement(name = "CallDuty")
    protected List<DutyType> callDuty;
    @XmlElement(name = "TimeDuty")
    protected List<DutyType> timeDuty;

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
     * Ruft den Wert der callDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CallDateType }
     *     
     */
    public CallDateType getCallDate() {
        return callDate;
    }

    /**
     * Legt den Wert der callDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CallDateType }
     *     
     */
    public void setCallDate(CallDateType value) {
        this.callDate = value;
    }

    /**
     * Ruft den Wert der callTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CallTimeType }
     *     
     */
    public CallTimeType getCallTime() {
        return callTime;
    }

    /**
     * Legt den Wert der callTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CallTimeType }
     *     
     */
    public void setCallTime(CallTimeType value) {
        this.callTime = value;
    }

    /**
     * Ruft den Wert der serviceNumberCalled-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ServiceNumberCalledType }
     *     
     */
    public ServiceNumberCalledType getServiceNumberCalled() {
        return serviceNumberCalled;
    }

    /**
     * Legt den Wert der serviceNumberCalled-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceNumberCalledType }
     *     
     */
    public void setServiceNumberCalled(ServiceNumberCalledType value) {
        this.serviceNumberCalled = value;
    }

    /**
     * Ruft den Wert der telecommunicationsServiceCategory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsServiceCategoryType }
     *     
     */
    public TelecommunicationsServiceCategoryType getTelecommunicationsServiceCategory() {
        return telecommunicationsServiceCategory;
    }

    /**
     * Legt den Wert der telecommunicationsServiceCategory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsServiceCategoryType }
     *     
     */
    public void setTelecommunicationsServiceCategory(TelecommunicationsServiceCategoryType value) {
        this.telecommunicationsServiceCategory = value;
    }

    /**
     * Ruft den Wert der telecommunicationsServiceCategoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsServiceCategoryCodeType }
     *     
     */
    public TelecommunicationsServiceCategoryCodeType getTelecommunicationsServiceCategoryCode() {
        return telecommunicationsServiceCategoryCode;
    }

    /**
     * Legt den Wert der telecommunicationsServiceCategoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsServiceCategoryCodeType }
     *     
     */
    public void setTelecommunicationsServiceCategoryCode(TelecommunicationsServiceCategoryCodeType value) {
        this.telecommunicationsServiceCategoryCode = value;
    }

    /**
     * Ruft den Wert der movieTitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MovieTitleType }
     *     
     */
    public MovieTitleType getMovieTitle() {
        return movieTitle;
    }

    /**
     * Legt den Wert der movieTitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MovieTitleType }
     *     
     */
    public void setMovieTitle(MovieTitleType value) {
        this.movieTitle = value;
    }

    /**
     * Ruft den Wert der roamingPartnerName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RoamingPartnerNameType }
     *     
     */
    public RoamingPartnerNameType getRoamingPartnerName() {
        return roamingPartnerName;
    }

    /**
     * Legt den Wert der roamingPartnerName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RoamingPartnerNameType }
     *     
     */
    public void setRoamingPartnerName(RoamingPartnerNameType value) {
        this.roamingPartnerName = value;
    }

    /**
     * Ruft den Wert der payPerView-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PayPerViewType }
     *     
     */
    public PayPerViewType getPayPerView() {
        return payPerView;
    }

    /**
     * Legt den Wert der payPerView-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PayPerViewType }
     *     
     */
    public void setPayPerView(PayPerViewType value) {
        this.payPerView = value;
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
     * Ruft den Wert der telecommunicationsServiceCall-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsServiceCallType }
     *     
     */
    public TelecommunicationsServiceCallType getTelecommunicationsServiceCall() {
        return telecommunicationsServiceCall;
    }

    /**
     * Legt den Wert der telecommunicationsServiceCall-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsServiceCallType }
     *     
     */
    public void setTelecommunicationsServiceCall(TelecommunicationsServiceCallType value) {
        this.telecommunicationsServiceCall = value;
    }

    /**
     * Ruft den Wert der telecommunicationsServiceCallCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsServiceCallCodeType }
     *     
     */
    public TelecommunicationsServiceCallCodeType getTelecommunicationsServiceCallCode() {
        return telecommunicationsServiceCallCode;
    }

    /**
     * Legt den Wert der telecommunicationsServiceCallCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsServiceCallCodeType }
     *     
     */
    public void setTelecommunicationsServiceCallCode(TelecommunicationsServiceCallCodeType value) {
        this.telecommunicationsServiceCallCode = value;
    }

    /**
     * Ruft den Wert der callBaseAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CallBaseAmountType }
     *     
     */
    public CallBaseAmountType getCallBaseAmount() {
        return callBaseAmount;
    }

    /**
     * Legt den Wert der callBaseAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CallBaseAmountType }
     *     
     */
    public void setCallBaseAmount(CallBaseAmountType value) {
        this.callBaseAmount = value;
    }

    /**
     * Ruft den Wert der callExtensionAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CallExtensionAmountType }
     *     
     */
    public CallExtensionAmountType getCallExtensionAmount() {
        return callExtensionAmount;
    }

    /**
     * Legt den Wert der callExtensionAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CallExtensionAmountType }
     *     
     */
    public void setCallExtensionAmount(CallExtensionAmountType value) {
        this.callExtensionAmount = value;
    }

    /**
     * Ruft den Wert der price-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getPrice() {
        return price;
    }

    /**
     * Legt den Wert der price-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setPrice(PriceType value) {
        this.price = value;
    }

    /**
     * Ruft den Wert der country-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Legt den Wert der country-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exchangeRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExchangeRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExchangeRateType }
     * 
     * 
     */
    public List<ExchangeRateType> getExchangeRate() {
        if (exchangeRate == null) {
            exchangeRate = new ArrayList<ExchangeRateType>();
        }
        return this.exchangeRate;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    /**
     * Gets the value of the taxTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxTotalType }
     * 
     * 
     */
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    /**
     * Gets the value of the callDuty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the callDuty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCallDuty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DutyType }
     * 
     * 
     */
    public List<DutyType> getCallDuty() {
        if (callDuty == null) {
            callDuty = new ArrayList<DutyType>();
        }
        return this.callDuty;
    }

    /**
     * Gets the value of the timeDuty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeDuty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeDuty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DutyType }
     * 
     * 
     */
    public List<DutyType> getTimeDuty() {
        if (timeDuty == null) {
            timeDuty = new ArrayList<DutyType>();
        }
        return this.timeDuty;
    }

}
