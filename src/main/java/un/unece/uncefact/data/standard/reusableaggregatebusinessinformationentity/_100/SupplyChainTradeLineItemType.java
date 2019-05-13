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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;


/**
 * <p>Java-Klasse für SupplyChainTradeLineItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SupplyChainTradeLineItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DescriptionCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="AssociatedDocumentLineDocument" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentLineDocumentType"/>
 *         &lt;element name="SpecifiedTradeProduct" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeProductType" minOccurs="0"/>
 *         &lt;element name="SpecifiedLineTradeAgreement" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LineTradeAgreementType" minOccurs="0"/>
 *         &lt;element name="SpecifiedLineTradeDelivery" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LineTradeDeliveryType" minOccurs="0"/>
 *         &lt;element name="SpecifiedLineTradeSettlement" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LineTradeSettlementType"/>
 *         &lt;element name="IncludedSubordinateTradeLineItem" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SubordinateTradeLineItemType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyChainTradeLineItemType", propOrder = {
    "descriptionCode",
    "associatedDocumentLineDocument",
    "specifiedTradeProduct",
    "specifiedLineTradeAgreement",
    "specifiedLineTradeDelivery",
    "specifiedLineTradeSettlement",
    "includedSubordinateTradeLineItem"
})
public class SupplyChainTradeLineItemType {

    @XmlElement(name = "DescriptionCode")
    protected CodeType descriptionCode;
    @XmlElement(name = "AssociatedDocumentLineDocument", required = true)
    protected DocumentLineDocumentType associatedDocumentLineDocument;
    @XmlElement(name = "SpecifiedTradeProduct")
    protected TradeProductType specifiedTradeProduct;
    @XmlElement(name = "SpecifiedLineTradeAgreement")
    protected LineTradeAgreementType specifiedLineTradeAgreement;
    @XmlElement(name = "SpecifiedLineTradeDelivery")
    protected LineTradeDeliveryType specifiedLineTradeDelivery;
    @XmlElement(name = "SpecifiedLineTradeSettlement", required = true)
    protected LineTradeSettlementType specifiedLineTradeSettlement;
    @XmlElement(name = "IncludedSubordinateTradeLineItem")
    protected List<SubordinateTradeLineItemType> includedSubordinateTradeLineItem;

    /**
     * Ruft den Wert der descriptionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getDescriptionCode() {
        return descriptionCode;
    }

    /**
     * Legt den Wert der descriptionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setDescriptionCode(CodeType value) {
        this.descriptionCode = value;
    }

    /**
     * Ruft den Wert der associatedDocumentLineDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentLineDocumentType }
     *     
     */
    public DocumentLineDocumentType getAssociatedDocumentLineDocument() {
        return associatedDocumentLineDocument;
    }

    /**
     * Legt den Wert der associatedDocumentLineDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentLineDocumentType }
     *     
     */
    public void setAssociatedDocumentLineDocument(DocumentLineDocumentType value) {
        this.associatedDocumentLineDocument = value;
    }

    /**
     * Ruft den Wert der specifiedTradeProduct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeProductType }
     *     
     */
    public TradeProductType getSpecifiedTradeProduct() {
        return specifiedTradeProduct;
    }

    /**
     * Legt den Wert der specifiedTradeProduct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeProductType }
     *     
     */
    public void setSpecifiedTradeProduct(TradeProductType value) {
        this.specifiedTradeProduct = value;
    }

    /**
     * Ruft den Wert der specifiedLineTradeAgreement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineTradeAgreementType }
     *     
     */
    public LineTradeAgreementType getSpecifiedLineTradeAgreement() {
        return specifiedLineTradeAgreement;
    }

    /**
     * Legt den Wert der specifiedLineTradeAgreement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineTradeAgreementType }
     *     
     */
    public void setSpecifiedLineTradeAgreement(LineTradeAgreementType value) {
        this.specifiedLineTradeAgreement = value;
    }

    /**
     * Ruft den Wert der specifiedLineTradeDelivery-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineTradeDeliveryType }
     *     
     */
    public LineTradeDeliveryType getSpecifiedLineTradeDelivery() {
        return specifiedLineTradeDelivery;
    }

    /**
     * Legt den Wert der specifiedLineTradeDelivery-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineTradeDeliveryType }
     *     
     */
    public void setSpecifiedLineTradeDelivery(LineTradeDeliveryType value) {
        this.specifiedLineTradeDelivery = value;
    }

    /**
     * Ruft den Wert der specifiedLineTradeSettlement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineTradeSettlementType }
     *     
     */
    public LineTradeSettlementType getSpecifiedLineTradeSettlement() {
        return specifiedLineTradeSettlement;
    }

    /**
     * Legt den Wert der specifiedLineTradeSettlement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineTradeSettlementType }
     *     
     */
    public void setSpecifiedLineTradeSettlement(LineTradeSettlementType value) {
        this.specifiedLineTradeSettlement = value;
    }

    /**
     * Gets the value of the includedSubordinateTradeLineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedSubordinateTradeLineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedSubordinateTradeLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubordinateTradeLineItemType }
     * 
     * 
     */
    public List<SubordinateTradeLineItemType> getIncludedSubordinateTradeLineItem() {
        if (includedSubordinateTradeLineItem == null) {
            includedSubordinateTradeLineItem = new ArrayList<SubordinateTradeLineItemType>();
        }
        return this.includedSubordinateTradeLineItem;
    }

}
