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


/**
 * <p>Java-Klasse für SubordinateLineTradeAgreementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SubordinateLineTradeAgreementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SellerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="BuyerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="GrossPriceProductTradePrice" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePriceType" minOccurs="0"/&gt;
 *         &lt;element name="NetPriceProductTradePrice" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePriceType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubordinateLineTradeAgreementType", propOrder = {
    "sellerOrderReferencedDocument",
    "buyerOrderReferencedDocument",
    "additionalReferencedDocument",
    "grossPriceProductTradePrice",
    "netPriceProductTradePrice"
})
public class SubordinateLineTradeAgreementType {

    @XmlElement(name = "SellerOrderReferencedDocument")
    protected ReferencedDocumentType sellerOrderReferencedDocument;
    @XmlElement(name = "BuyerOrderReferencedDocument")
    protected ReferencedDocumentType buyerOrderReferencedDocument;
    @XmlElement(name = "AdditionalReferencedDocument")
    protected List<ReferencedDocumentType> additionalReferencedDocument;
    @XmlElement(name = "GrossPriceProductTradePrice")
    protected TradePriceType grossPriceProductTradePrice;
    @XmlElement(name = "NetPriceProductTradePrice")
    protected TradePriceType netPriceProductTradePrice;

    /**
     * Ruft den Wert der sellerOrderReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getSellerOrderReferencedDocument() {
        return sellerOrderReferencedDocument;
    }

    /**
     * Legt den Wert der sellerOrderReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setSellerOrderReferencedDocument(ReferencedDocumentType value) {
        this.sellerOrderReferencedDocument = value;
    }

    /**
     * Ruft den Wert der buyerOrderReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getBuyerOrderReferencedDocument() {
        return buyerOrderReferencedDocument;
    }

    /**
     * Legt den Wert der buyerOrderReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setBuyerOrderReferencedDocument(ReferencedDocumentType value) {
        this.buyerOrderReferencedDocument = value;
    }

    /**
     * Gets the value of the additionalReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getAdditionalReferencedDocument() {
        if (additionalReferencedDocument == null) {
            additionalReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.additionalReferencedDocument;
    }

    /**
     * Ruft den Wert der grossPriceProductTradePrice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePriceType }
     *     
     */
    public TradePriceType getGrossPriceProductTradePrice() {
        return grossPriceProductTradePrice;
    }

    /**
     * Legt den Wert der grossPriceProductTradePrice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePriceType }
     *     
     */
    public void setGrossPriceProductTradePrice(TradePriceType value) {
        this.grossPriceProductTradePrice = value;
    }

    /**
     * Ruft den Wert der netPriceProductTradePrice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePriceType }
     *     
     */
    public TradePriceType getNetPriceProductTradePrice() {
        return netPriceProductTradePrice;
    }

    /**
     * Legt den Wert der netPriceProductTradePrice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePriceType }
     *     
     */
    public void setNetPriceProductTradePrice(TradePriceType value) {
        this.netPriceProductTradePrice = value;
    }

}
