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
import un.unece.uncefact.data.standard.qualifieddatatype._100.DeliveryTermsCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeDeliveryTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeDeliveryTermsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DeliveryTypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}DeliveryTermsCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RelevantTradeLocation" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeLocationType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeDeliveryTermsType", propOrder = {
    "deliveryTypeCode",
    "description",
    "relevantTradeLocation"
})
public class TradeDeliveryTermsType {

    @XmlElement(name = "DeliveryTypeCode")
    protected DeliveryTermsCodeType deliveryTypeCode;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "RelevantTradeLocation")
    protected TradeLocationType relevantTradeLocation;

    /**
     * Ruft den Wert der deliveryTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryTermsCodeType }
     *     
     */
    public DeliveryTermsCodeType getDeliveryTypeCode() {
        return deliveryTypeCode;
    }

    /**
     * Legt den Wert der deliveryTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryTermsCodeType }
     *     
     */
    public void setDeliveryTypeCode(DeliveryTermsCodeType value) {
        this.deliveryTypeCode = value;
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
     * Ruft den Wert der relevantTradeLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeLocationType }
     *     
     */
    public TradeLocationType getRelevantTradeLocation() {
        return relevantTradeLocation;
    }

    /**
     * Legt den Wert der relevantTradeLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeLocationType }
     *     
     */
    public void setRelevantTradeLocation(TradeLocationType value) {
        this.relevantTradeLocation = value;
    }

}
