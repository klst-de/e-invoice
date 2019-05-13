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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;


/**
 * <p>Java-Klasse für SubordinateLineTradeDeliveryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SubordinateLineTradeDeliveryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="ProductUnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="PerPackageUnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="IncludedSupplyChainPackaging" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SupplyChainPackagingType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubordinateLineTradeDeliveryType", propOrder = {
    "packageQuantity",
    "productUnitQuantity",
    "perPackageUnitQuantity",
    "includedSupplyChainPackaging"
})
public class SubordinateLineTradeDeliveryType {

    @XmlElement(name = "PackageQuantity")
    protected QuantityType packageQuantity;
    @XmlElement(name = "ProductUnitQuantity")
    protected QuantityType productUnitQuantity;
    @XmlElement(name = "PerPackageUnitQuantity")
    protected QuantityType perPackageUnitQuantity;
    @XmlElement(name = "IncludedSupplyChainPackaging")
    protected List<SupplyChainPackagingType> includedSupplyChainPackaging;

    /**
     * Ruft den Wert der packageQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * Legt den Wert der packageQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setPackageQuantity(QuantityType value) {
        this.packageQuantity = value;
    }

    /**
     * Ruft den Wert der productUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getProductUnitQuantity() {
        return productUnitQuantity;
    }

    /**
     * Legt den Wert der productUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setProductUnitQuantity(QuantityType value) {
        this.productUnitQuantity = value;
    }

    /**
     * Ruft den Wert der perPackageUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getPerPackageUnitQuantity() {
        return perPackageUnitQuantity;
    }

    /**
     * Legt den Wert der perPackageUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setPerPackageUnitQuantity(QuantityType value) {
        this.perPackageUnitQuantity = value;
    }

    /**
     * Gets the value of the includedSupplyChainPackaging property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedSupplyChainPackaging property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedSupplyChainPackaging().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyChainPackagingType }
     * 
     * 
     */
    public List<SupplyChainPackagingType> getIncludedSupplyChainPackaging() {
        if (includedSupplyChainPackaging == null) {
            includedSupplyChainPackaging = new ArrayList<SupplyChainPackagingType>();
        }
        return this.includedSupplyChainPackaging;
    }

}
