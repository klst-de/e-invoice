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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;


/**
 * <p>Java-Klasse für SubordinateTradeLineItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SubordinateTradeLineItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedReferencedProduct" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedProductType" minOccurs="0"/>
 *         &lt;element name="ApplicableTradeProduct" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeProductType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecifiedSubordinateLineTradeAgreement" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SubordinateLineTradeAgreementType" minOccurs="0"/>
 *         &lt;element name="SpecifiedSubordinateLineTradeDelivery" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SubordinateLineTradeDeliveryType" minOccurs="0"/>
 *         &lt;element name="SpecifiedSubordinateLineTradeSettlement" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SubordinateLineTradeSettlementType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubordinateTradeLineItemType", propOrder = {
    "id",
    "specifiedReferencedProduct",
    "applicableTradeProduct",
    "specifiedSubordinateLineTradeAgreement",
    "specifiedSubordinateLineTradeDelivery",
    "specifiedSubordinateLineTradeSettlement"
})
public class SubordinateTradeLineItemType {

    @XmlElement(name = "ID")
    protected List<IDType> id;
    @XmlElement(name = "SpecifiedReferencedProduct")
    protected ReferencedProductType specifiedReferencedProduct;
    @XmlElement(name = "ApplicableTradeProduct")
    protected List<TradeProductType> applicableTradeProduct;
    @XmlElement(name = "SpecifiedSubordinateLineTradeAgreement")
    protected SubordinateLineTradeAgreementType specifiedSubordinateLineTradeAgreement;
    @XmlElement(name = "SpecifiedSubordinateLineTradeDelivery")
    protected SubordinateLineTradeDeliveryType specifiedSubordinateLineTradeDelivery;
    @XmlElement(name = "SpecifiedSubordinateLineTradeSettlement")
    protected SubordinateLineTradeSettlementType specifiedSubordinateLineTradeSettlement;

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getID() {
        if (id == null) {
            id = new ArrayList<IDType>();
        }
        return this.id;
    }

    /**
     * Ruft den Wert der specifiedReferencedProduct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedProductType }
     *     
     */
    public ReferencedProductType getSpecifiedReferencedProduct() {
        return specifiedReferencedProduct;
    }

    /**
     * Legt den Wert der specifiedReferencedProduct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedProductType }
     *     
     */
    public void setSpecifiedReferencedProduct(ReferencedProductType value) {
        this.specifiedReferencedProduct = value;
    }

    /**
     * Gets the value of the applicableTradeProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicableTradeProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicableTradeProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeProductType }
     * 
     * 
     */
    public List<TradeProductType> getApplicableTradeProduct() {
        if (applicableTradeProduct == null) {
            applicableTradeProduct = new ArrayList<TradeProductType>();
        }
        return this.applicableTradeProduct;
    }

    /**
     * Ruft den Wert der specifiedSubordinateLineTradeAgreement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubordinateLineTradeAgreementType }
     *     
     */
    public SubordinateLineTradeAgreementType getSpecifiedSubordinateLineTradeAgreement() {
        return specifiedSubordinateLineTradeAgreement;
    }

    /**
     * Legt den Wert der specifiedSubordinateLineTradeAgreement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubordinateLineTradeAgreementType }
     *     
     */
    public void setSpecifiedSubordinateLineTradeAgreement(SubordinateLineTradeAgreementType value) {
        this.specifiedSubordinateLineTradeAgreement = value;
    }

    /**
     * Ruft den Wert der specifiedSubordinateLineTradeDelivery-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubordinateLineTradeDeliveryType }
     *     
     */
    public SubordinateLineTradeDeliveryType getSpecifiedSubordinateLineTradeDelivery() {
        return specifiedSubordinateLineTradeDelivery;
    }

    /**
     * Legt den Wert der specifiedSubordinateLineTradeDelivery-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubordinateLineTradeDeliveryType }
     *     
     */
    public void setSpecifiedSubordinateLineTradeDelivery(SubordinateLineTradeDeliveryType value) {
        this.specifiedSubordinateLineTradeDelivery = value;
    }

    /**
     * Ruft den Wert der specifiedSubordinateLineTradeSettlement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubordinateLineTradeSettlementType }
     *     
     */
    public SubordinateLineTradeSettlementType getSpecifiedSubordinateLineTradeSettlement() {
        return specifiedSubordinateLineTradeSettlement;
    }

    /**
     * Legt den Wert der specifiedSubordinateLineTradeSettlement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubordinateLineTradeSettlementType }
     *     
     */
    public void setSpecifiedSubordinateLineTradeSettlement(SubordinateLineTradeSettlementType value) {
        this.specifiedSubordinateLineTradeSettlement = value;
    }

}
