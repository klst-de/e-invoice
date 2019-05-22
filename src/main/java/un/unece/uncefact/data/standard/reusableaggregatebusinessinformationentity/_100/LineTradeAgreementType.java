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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für LineTradeAgreementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LineTradeAgreementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BuyerReference" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="BuyerRequisitionerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableTradeDeliveryTerms" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeDeliveryTermsType" minOccurs="0"/&gt;
 *         &lt;element name="SellerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="BuyerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="QuotationReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="ContractReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="DemandForecastReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="PromotionalDealReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="GrossPriceProductTradePrice" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePriceType" minOccurs="0"/&gt;
 *         &lt;element name="NetPriceProductTradePrice" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePriceType" minOccurs="0"/&gt;
 *         &lt;element name="RequisitionerReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemSellerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="ItemBuyerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/&gt;
 *         &lt;element name="IncludedSpecifiedMarketplace" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedMarketplaceType" minOccurs="0"/&gt;
 *         &lt;element name="UltimateCustomerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineTradeAgreementType", propOrder = {
    "buyerReference",
    "buyerRequisitionerTradeParty",
    "applicableTradeDeliveryTerms",
    "sellerOrderReferencedDocument",
    "buyerOrderReferencedDocument",
    "quotationReferencedDocument",
    "contractReferencedDocument",
    "demandForecastReferencedDocument",
    "promotionalDealReferencedDocument",
    "additionalReferencedDocument",
    "grossPriceProductTradePrice",
    "netPriceProductTradePrice",
    "requisitionerReferencedDocument",
    "itemSellerTradeParty",
    "itemBuyerTradeParty",
    "includedSpecifiedMarketplace",
    "ultimateCustomerOrderReferencedDocument"
})
public class LineTradeAgreementType {

    @XmlElement(name = "BuyerReference")
    protected TextType buyerReference;
    @XmlElement(name = "BuyerRequisitionerTradeParty")
    protected List<TradePartyType> buyerRequisitionerTradeParty;
    @XmlElement(name = "ApplicableTradeDeliveryTerms")
    protected TradeDeliveryTermsType applicableTradeDeliveryTerms;
    @XmlElement(name = "SellerOrderReferencedDocument")
    protected ReferencedDocumentType sellerOrderReferencedDocument;
    @XmlElement(name = "BuyerOrderReferencedDocument")
    protected ReferencedDocumentType buyerOrderReferencedDocument;
    @XmlElement(name = "QuotationReferencedDocument")
    protected ReferencedDocumentType quotationReferencedDocument;
    @XmlElement(name = "ContractReferencedDocument")
    protected ReferencedDocumentType contractReferencedDocument;
    @XmlElement(name = "DemandForecastReferencedDocument")
    protected ReferencedDocumentType demandForecastReferencedDocument;
    @XmlElement(name = "PromotionalDealReferencedDocument")
    protected ReferencedDocumentType promotionalDealReferencedDocument;
    @XmlElement(name = "AdditionalReferencedDocument")
    protected List<ReferencedDocumentType> additionalReferencedDocument;
    @XmlElement(name = "GrossPriceProductTradePrice")
    protected TradePriceType grossPriceProductTradePrice;
    @XmlElement(name = "NetPriceProductTradePrice")
    protected TradePriceType netPriceProductTradePrice;
    @XmlElement(name = "RequisitionerReferencedDocument")
    protected List<ReferencedDocumentType> requisitionerReferencedDocument;
    @XmlElement(name = "ItemSellerTradeParty")
    protected TradePartyType itemSellerTradeParty;
    @XmlElement(name = "ItemBuyerTradeParty")
    protected TradePartyType itemBuyerTradeParty;
    @XmlElement(name = "IncludedSpecifiedMarketplace")
    protected SpecifiedMarketplaceType includedSpecifiedMarketplace;
    @XmlElement(name = "UltimateCustomerOrderReferencedDocument")
    protected List<ReferencedDocumentType> ultimateCustomerOrderReferencedDocument;

    /**
     * Ruft den Wert der buyerReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBuyerReference() {
        return buyerReference;
    }

    /**
     * Legt den Wert der buyerReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBuyerReference(TextType value) {
        this.buyerReference = value;
    }

    /**
     * Gets the value of the buyerRequisitionerTradeParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buyerRequisitionerTradeParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuyerRequisitionerTradeParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradePartyType }
     * 
     * 
     */
    public List<TradePartyType> getBuyerRequisitionerTradeParty() {
        if (buyerRequisitionerTradeParty == null) {
            buyerRequisitionerTradeParty = new ArrayList<TradePartyType>();
        }
        return this.buyerRequisitionerTradeParty;
    }

    /**
     * Ruft den Wert der applicableTradeDeliveryTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeDeliveryTermsType }
     *     
     */
    public TradeDeliveryTermsType getApplicableTradeDeliveryTerms() {
        return applicableTradeDeliveryTerms;
    }

    /**
     * Legt den Wert der applicableTradeDeliveryTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeDeliveryTermsType }
     *     
     */
    public void setApplicableTradeDeliveryTerms(TradeDeliveryTermsType value) {
        this.applicableTradeDeliveryTerms = value;
    }

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
     * Ruft den Wert der quotationReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getQuotationReferencedDocument() {
        return quotationReferencedDocument;
    }

    /**
     * Legt den Wert der quotationReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setQuotationReferencedDocument(ReferencedDocumentType value) {
        this.quotationReferencedDocument = value;
    }

    /**
     * Ruft den Wert der contractReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getContractReferencedDocument() {
        return contractReferencedDocument;
    }

    /**
     * Legt den Wert der contractReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setContractReferencedDocument(ReferencedDocumentType value) {
        this.contractReferencedDocument = value;
    }

    /**
     * Ruft den Wert der demandForecastReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getDemandForecastReferencedDocument() {
        return demandForecastReferencedDocument;
    }

    /**
     * Legt den Wert der demandForecastReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setDemandForecastReferencedDocument(ReferencedDocumentType value) {
        this.demandForecastReferencedDocument = value;
    }

    /**
     * Ruft den Wert der promotionalDealReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getPromotionalDealReferencedDocument() {
        return promotionalDealReferencedDocument;
    }

    /**
     * Legt den Wert der promotionalDealReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setPromotionalDealReferencedDocument(ReferencedDocumentType value) {
        this.promotionalDealReferencedDocument = value;
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

    /**
     * Gets the value of the requisitionerReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requisitionerReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequisitionerReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getRequisitionerReferencedDocument() {
        if (requisitionerReferencedDocument == null) {
            requisitionerReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.requisitionerReferencedDocument;
    }

    /**
     * Ruft den Wert der itemSellerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getItemSellerTradeParty() {
        return itemSellerTradeParty;
    }

    /**
     * Legt den Wert der itemSellerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setItemSellerTradeParty(TradePartyType value) {
        this.itemSellerTradeParty = value;
    }

    /**
     * Ruft den Wert der itemBuyerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getItemBuyerTradeParty() {
        return itemBuyerTradeParty;
    }

    /**
     * Legt den Wert der itemBuyerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setItemBuyerTradeParty(TradePartyType value) {
        this.itemBuyerTradeParty = value;
    }

    /**
     * Ruft den Wert der includedSpecifiedMarketplace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedMarketplaceType }
     *     
     */
    public SpecifiedMarketplaceType getIncludedSpecifiedMarketplace() {
        return includedSpecifiedMarketplace;
    }

    /**
     * Legt den Wert der includedSpecifiedMarketplace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedMarketplaceType }
     *     
     */
    public void setIncludedSpecifiedMarketplace(SpecifiedMarketplaceType value) {
        this.includedSpecifiedMarketplace = value;
    }

    /**
     * Gets the value of the ultimateCustomerOrderReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ultimateCustomerOrderReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUltimateCustomerOrderReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getUltimateCustomerOrderReferencedDocument() {
        if (ultimateCustomerOrderReferencedDocument == null) {
            ultimateCustomerOrderReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.ultimateCustomerOrderReferencedDocument;
    }

}
