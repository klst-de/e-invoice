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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für SpecifiedMarketplaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpecifiedMarketplaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="VirtualIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="WebsiteURIID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SalesMethodCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="OrderingAvailablePeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}AvailablePeriodType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecifiedMarketplaceType", propOrder = {
    "id",
    "name",
    "virtualIndicator",
    "websiteURIID",
    "salesMethodCode",
    "orderingAvailablePeriod"
})
public class SpecifiedMarketplaceType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "Name")
    protected TextType name;
    @XmlElement(name = "VirtualIndicator")
    protected IndicatorType virtualIndicator;
    @XmlElement(name = "WebsiteURIID")
    protected List<IDType> websiteURIID;
    @XmlElement(name = "SalesMethodCode")
    protected CodeType salesMethodCode;
    @XmlElement(name = "OrderingAvailablePeriod")
    protected List<AvailablePeriodType> orderingAvailablePeriod;

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
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setName(TextType value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der virtualIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getVirtualIndicator() {
        return virtualIndicator;
    }

    /**
     * Legt den Wert der virtualIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setVirtualIndicator(IndicatorType value) {
        this.virtualIndicator = value;
    }

    /**
     * Gets the value of the websiteURIID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the websiteURIID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWebsiteURIID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getWebsiteURIID() {
        if (websiteURIID == null) {
            websiteURIID = new ArrayList<IDType>();
        }
        return this.websiteURIID;
    }

    /**
     * Ruft den Wert der salesMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getSalesMethodCode() {
        return salesMethodCode;
    }

    /**
     * Legt den Wert der salesMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setSalesMethodCode(CodeType value) {
        this.salesMethodCode = value;
    }

    /**
     * Gets the value of the orderingAvailablePeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderingAvailablePeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderingAvailablePeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailablePeriodType }
     * 
     * 
     */
    public List<AvailablePeriodType> getOrderingAvailablePeriod() {
        if (orderingAvailablePeriod == null) {
            orderingAvailablePeriod = new ArrayList<AvailablePeriodType>();
        }
        return this.orderingAvailablePeriod;
    }

}
