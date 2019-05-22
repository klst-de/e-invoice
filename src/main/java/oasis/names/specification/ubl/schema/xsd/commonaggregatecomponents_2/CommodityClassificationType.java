//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CargoTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CommodityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemClassificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NatureCodeType;


/**
 * <p>Java-Klasse für CommodityClassificationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CommodityClassificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NatureCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CargoTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CommodityCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ItemClassificationCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommodityClassificationType", propOrder = {
    "natureCode",
    "cargoTypeCode",
    "commodityCode",
    "itemClassificationCode"
})
public class CommodityClassificationType {

    @XmlElement(name = "NatureCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NatureCodeType natureCode;
    @XmlElement(name = "CargoTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CargoTypeCodeType cargoTypeCode;
    @XmlElement(name = "CommodityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CommodityCodeType commodityCode;
    @XmlElement(name = "ItemClassificationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ItemClassificationCodeType itemClassificationCode;

    /**
     * Ruft den Wert der natureCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NatureCodeType }
     *     
     */
    public NatureCodeType getNatureCode() {
        return natureCode;
    }

    /**
     * Legt den Wert der natureCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NatureCodeType }
     *     
     */
    public void setNatureCode(NatureCodeType value) {
        this.natureCode = value;
    }

    /**
     * Ruft den Wert der cargoTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CargoTypeCodeType }
     *     
     */
    public CargoTypeCodeType getCargoTypeCode() {
        return cargoTypeCode;
    }

    /**
     * Legt den Wert der cargoTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CargoTypeCodeType }
     *     
     */
    public void setCargoTypeCode(CargoTypeCodeType value) {
        this.cargoTypeCode = value;
    }

    /**
     * Ruft den Wert der commodityCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CommodityCodeType }
     *     
     */
    public CommodityCodeType getCommodityCode() {
        return commodityCode;
    }

    /**
     * Legt den Wert der commodityCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityCodeType }
     *     
     */
    public void setCommodityCode(CommodityCodeType value) {
        this.commodityCode = value;
    }

    /**
     * Ruft den Wert der itemClassificationCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemClassificationCodeType }
     *     
     */
    public ItemClassificationCodeType getItemClassificationCode() {
        return itemClassificationCode;
    }

    /**
     * Legt den Wert der itemClassificationCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemClassificationCodeType }
     *     
     */
    public void setItemClassificationCode(ItemClassificationCodeType value) {
        this.itemClassificationCode = value;
    }

}
