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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für HeaderTradeAgreementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HeaderTradeAgreementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reference" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BuyerReference" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="SellerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="BuyerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="SalesAgentTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="BuyerRequisitionerTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BuyerAssignedAccountantTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="SellerAssignedAccountantTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="BuyerTaxRepresentativeTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="SellerTaxRepresentativeTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="ProductEndUserTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="ApplicableTradeDeliveryTerms" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeDeliveryTermsType" minOccurs="0"/>
 *         &lt;element name="SellerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="BuyerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="QuotationReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="OrderResponseReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="ContractReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="DemandForecastReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="SupplyInstructionReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="PromotionalDealReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="PriceListReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" minOccurs="0"/>
 *         &lt;element name="AdditionalReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RequisitionerReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BuyerAgentTradeParty" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradePartyType" minOccurs="0"/>
 *         &lt;element name="PurchaseConditionsReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedProcuringProject" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ProcuringProjectType" minOccurs="0"/>
 *         &lt;element name="UltimateCustomerOrderReferencedDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderTradeAgreementType", propOrder = {
    "reference",
    "buyerReference",
    "sellerTradeParty",
    "buyerTradeParty",
    "salesAgentTradeParty",
    "buyerRequisitionerTradeParty",
    "buyerAssignedAccountantTradeParty",
    "sellerAssignedAccountantTradeParty",
    "buyerTaxRepresentativeTradeParty",
    "sellerTaxRepresentativeTradeParty",
    "productEndUserTradeParty",
    "applicableTradeDeliveryTerms",
    "sellerOrderReferencedDocument",
    "buyerOrderReferencedDocument",
    "quotationReferencedDocument",
    "orderResponseReferencedDocument",
    "contractReferencedDocument",
    "demandForecastReferencedDocument",
    "supplyInstructionReferencedDocument",
    "promotionalDealReferencedDocument",
    "priceListReferencedDocument",
    "additionalReferencedDocument",
    "requisitionerReferencedDocument",
    "buyerAgentTradeParty",
    "purchaseConditionsReferencedDocument",
    "specifiedProcuringProject",
    "ultimateCustomerOrderReferencedDocument"
})
public class HeaderTradeAgreementType {

    @XmlElement(name = "Reference")
    protected List<TextType> reference;
    @XmlElement(name = "BuyerReference")
    protected TextType buyerReference;
    @XmlElement(name = "SellerTradeParty")
    protected TradePartyType sellerTradeParty;
    @XmlElement(name = "BuyerTradeParty")
    protected TradePartyType buyerTradeParty;
    @XmlElement(name = "SalesAgentTradeParty")
    protected TradePartyType salesAgentTradeParty;
    @XmlElement(name = "BuyerRequisitionerTradeParty")
    protected List<TradePartyType> buyerRequisitionerTradeParty;
    @XmlElement(name = "BuyerAssignedAccountantTradeParty")
    protected TradePartyType buyerAssignedAccountantTradeParty;
    @XmlElement(name = "SellerAssignedAccountantTradeParty")
    protected TradePartyType sellerAssignedAccountantTradeParty;
    @XmlElement(name = "BuyerTaxRepresentativeTradeParty")
    protected TradePartyType buyerTaxRepresentativeTradeParty;
    @XmlElement(name = "SellerTaxRepresentativeTradeParty")
    protected TradePartyType sellerTaxRepresentativeTradeParty;
    @XmlElement(name = "ProductEndUserTradeParty")
    protected TradePartyType productEndUserTradeParty;
    @XmlElement(name = "ApplicableTradeDeliveryTerms")
    protected TradeDeliveryTermsType applicableTradeDeliveryTerms;
    @XmlElement(name = "SellerOrderReferencedDocument")
    protected ReferencedDocumentType sellerOrderReferencedDocument;
    @XmlElement(name = "BuyerOrderReferencedDocument")
    protected ReferencedDocumentType buyerOrderReferencedDocument;
    @XmlElement(name = "QuotationReferencedDocument")
    protected ReferencedDocumentType quotationReferencedDocument;
    @XmlElement(name = "OrderResponseReferencedDocument")
    protected ReferencedDocumentType orderResponseReferencedDocument;
    @XmlElement(name = "ContractReferencedDocument")
    protected ReferencedDocumentType contractReferencedDocument;
    @XmlElement(name = "DemandForecastReferencedDocument")
    protected ReferencedDocumentType demandForecastReferencedDocument;
    @XmlElement(name = "SupplyInstructionReferencedDocument")
    protected ReferencedDocumentType supplyInstructionReferencedDocument;
    @XmlElement(name = "PromotionalDealReferencedDocument")
    protected ReferencedDocumentType promotionalDealReferencedDocument;
    @XmlElement(name = "PriceListReferencedDocument")
    protected ReferencedDocumentType priceListReferencedDocument;
    @XmlElement(name = "AdditionalReferencedDocument")
    protected List<ReferencedDocumentType> additionalReferencedDocument;
    @XmlElement(name = "RequisitionerReferencedDocument")
    protected List<ReferencedDocumentType> requisitionerReferencedDocument;
    @XmlElement(name = "BuyerAgentTradeParty")
    protected TradePartyType buyerAgentTradeParty;
    @XmlElement(name = "PurchaseConditionsReferencedDocument")
    protected List<ReferencedDocumentType> purchaseConditionsReferencedDocument;
    @XmlElement(name = "SpecifiedProcuringProject")
    protected ProcuringProjectType specifiedProcuringProject;
    @XmlElement(name = "UltimateCustomerOrderReferencedDocument")
    protected List<ReferencedDocumentType> ultimateCustomerOrderReferencedDocument;

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getReference() {
        if (reference == null) {
            reference = new ArrayList<TextType>();
        }
        return this.reference;
    }

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
     * Ruft den Wert der sellerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getSellerTradeParty() {
        return sellerTradeParty;
    }

    /**
     * Legt den Wert der sellerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setSellerTradeParty(TradePartyType value) {
        this.sellerTradeParty = value;
    }

    /**
     * Ruft den Wert der buyerTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getBuyerTradeParty() {
        return buyerTradeParty;
    }

    /**
     * Legt den Wert der buyerTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setBuyerTradeParty(TradePartyType value) {
        this.buyerTradeParty = value;
    }

    /**
     * Ruft den Wert der salesAgentTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getSalesAgentTradeParty() {
        return salesAgentTradeParty;
    }

    /**
     * Legt den Wert der salesAgentTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setSalesAgentTradeParty(TradePartyType value) {
        this.salesAgentTradeParty = value;
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
     * Ruft den Wert der buyerAssignedAccountantTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getBuyerAssignedAccountantTradeParty() {
        return buyerAssignedAccountantTradeParty;
    }

    /**
     * Legt den Wert der buyerAssignedAccountantTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setBuyerAssignedAccountantTradeParty(TradePartyType value) {
        this.buyerAssignedAccountantTradeParty = value;
    }

    /**
     * Ruft den Wert der sellerAssignedAccountantTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getSellerAssignedAccountantTradeParty() {
        return sellerAssignedAccountantTradeParty;
    }

    /**
     * Legt den Wert der sellerAssignedAccountantTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setSellerAssignedAccountantTradeParty(TradePartyType value) {
        this.sellerAssignedAccountantTradeParty = value;
    }

    /**
     * Ruft den Wert der buyerTaxRepresentativeTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getBuyerTaxRepresentativeTradeParty() {
        return buyerTaxRepresentativeTradeParty;
    }

    /**
     * Legt den Wert der buyerTaxRepresentativeTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setBuyerTaxRepresentativeTradeParty(TradePartyType value) {
        this.buyerTaxRepresentativeTradeParty = value;
    }

    /**
     * Ruft den Wert der sellerTaxRepresentativeTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getSellerTaxRepresentativeTradeParty() {
        return sellerTaxRepresentativeTradeParty;
    }

    /**
     * Legt den Wert der sellerTaxRepresentativeTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setSellerTaxRepresentativeTradeParty(TradePartyType value) {
        this.sellerTaxRepresentativeTradeParty = value;
    }

    /**
     * Ruft den Wert der productEndUserTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getProductEndUserTradeParty() {
        return productEndUserTradeParty;
    }

    /**
     * Legt den Wert der productEndUserTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setProductEndUserTradeParty(TradePartyType value) {
        this.productEndUserTradeParty = value;
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
     * Ruft den Wert der orderResponseReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getOrderResponseReferencedDocument() {
        return orderResponseReferencedDocument;
    }

    /**
     * Legt den Wert der orderResponseReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setOrderResponseReferencedDocument(ReferencedDocumentType value) {
        this.orderResponseReferencedDocument = value;
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
     * Ruft den Wert der supplyInstructionReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getSupplyInstructionReferencedDocument() {
        return supplyInstructionReferencedDocument;
    }

    /**
     * Legt den Wert der supplyInstructionReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setSupplyInstructionReferencedDocument(ReferencedDocumentType value) {
        this.supplyInstructionReferencedDocument = value;
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
     * Ruft den Wert der priceListReferencedDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public ReferencedDocumentType getPriceListReferencedDocument() {
        return priceListReferencedDocument;
    }

    /**
     * Legt den Wert der priceListReferencedDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedDocumentType }
     *     
     */
    public void setPriceListReferencedDocument(ReferencedDocumentType value) {
        this.priceListReferencedDocument = value;
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
     * Ruft den Wert der buyerAgentTradeParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradePartyType }
     *     
     */
    public TradePartyType getBuyerAgentTradeParty() {
        return buyerAgentTradeParty;
    }

    /**
     * Legt den Wert der buyerAgentTradeParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradePartyType }
     *     
     */
    public void setBuyerAgentTradeParty(TradePartyType value) {
        this.buyerAgentTradeParty = value;
    }

    /**
     * Gets the value of the purchaseConditionsReferencedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the purchaseConditionsReferencedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPurchaseConditionsReferencedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferencedDocumentType }
     * 
     * 
     */
    public List<ReferencedDocumentType> getPurchaseConditionsReferencedDocument() {
        if (purchaseConditionsReferencedDocument == null) {
            purchaseConditionsReferencedDocument = new ArrayList<ReferencedDocumentType>();
        }
        return this.purchaseConditionsReferencedDocument;
    }

    /**
     * Ruft den Wert der specifiedProcuringProject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProcuringProjectType }
     *     
     */
    public ProcuringProjectType getSpecifiedProcuringProject() {
        return specifiedProcuringProject;
    }

    /**
     * Legt den Wert der specifiedProcuringProject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcuringProjectType }
     *     
     */
    public void setSpecifiedProcuringProject(ProcuringProjectType value) {
        this.specifiedProcuringProject = value;
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
