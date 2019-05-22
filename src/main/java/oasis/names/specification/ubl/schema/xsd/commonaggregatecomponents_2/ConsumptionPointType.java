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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalDeliveredQuantityType;


/**
 * <p>Java-Klasse für ConsumptionPointType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionPointType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalDeliveredQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Address" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WebSiteAccess" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UtilityMeter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionPointType", propOrder = {
    "id",
    "description",
    "subscriberID",
    "subscriberType",
    "subscriberTypeCode",
    "totalDeliveredQuantity",
    "address",
    "webSiteAccess",
    "utilityMeter"
})
public class ConsumptionPointType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "SubscriberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberIDType subscriberID;
    @XmlElement(name = "SubscriberType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberTypeType subscriberType;
    @XmlElement(name = "SubscriberTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberTypeCodeType subscriberTypeCode;
    @XmlElement(name = "TotalDeliveredQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalDeliveredQuantityType totalDeliveredQuantity;
    @XmlElement(name = "Address")
    protected AddressType address;
    @XmlElement(name = "WebSiteAccess")
    protected WebSiteAccessType webSiteAccess;
    @XmlElement(name = "UtilityMeter")
    protected List<MeterType> utilityMeter;

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
     * Ruft den Wert der totalDeliveredQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalDeliveredQuantityType }
     *     
     */
    public TotalDeliveredQuantityType getTotalDeliveredQuantity() {
        return totalDeliveredQuantity;
    }

    /**
     * Legt den Wert der totalDeliveredQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalDeliveredQuantityType }
     *     
     */
    public void setTotalDeliveredQuantity(TotalDeliveredQuantityType value) {
        this.totalDeliveredQuantity = value;
    }

    /**
     * Ruft den Wert der address-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Legt den Wert der address-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Ruft den Wert der webSiteAccess-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WebSiteAccessType }
     *     
     */
    public WebSiteAccessType getWebSiteAccess() {
        return webSiteAccess;
    }

    /**
     * Legt den Wert der webSiteAccess-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WebSiteAccessType }
     *     
     */
    public void setWebSiteAccess(WebSiteAccessType value) {
        this.webSiteAccess = value;
    }

    /**
     * Gets the value of the utilityMeter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the utilityMeter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUtilityMeter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeterType }
     * 
     * 
     */
    public List<MeterType> getUtilityMeter() {
        if (utilityMeter == null) {
            utilityMeter = new ArrayList<MeterType>();
        }
        return this.utilityMeter;
    }

}
