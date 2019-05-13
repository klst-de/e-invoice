//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BestBeforeDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ManufactureDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ManufactureTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProductTraceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SerialIDType;


/**
 * <p>Java-Klasse für ItemInstanceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ItemInstanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProductTraceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ManufactureDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ManufactureTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BestBeforeDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SerialID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalItemProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LotIdentification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemInstanceType", propOrder = {
    "productTraceID",
    "manufactureDate",
    "manufactureTime",
    "bestBeforeDate",
    "registrationID",
    "serialID",
    "additionalItemProperty",
    "lotIdentification"
})
public class ItemInstanceType {

    @XmlElement(name = "ProductTraceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProductTraceIDType productTraceID;
    @XmlElement(name = "ManufactureDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ManufactureDateType manufactureDate;
    @XmlElement(name = "ManufactureTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ManufactureTimeType manufactureTime;
    @XmlElement(name = "BestBeforeDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BestBeforeDateType bestBeforeDate;
    @XmlElement(name = "RegistrationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationIDType registrationID;
    @XmlElement(name = "SerialID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SerialIDType serialID;
    @XmlElement(name = "AdditionalItemProperty")
    protected List<ItemPropertyType> additionalItemProperty;
    @XmlElement(name = "LotIdentification")
    protected LotIdentificationType lotIdentification;

    /**
     * Ruft den Wert der productTraceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProductTraceIDType }
     *     
     */
    public ProductTraceIDType getProductTraceID() {
        return productTraceID;
    }

    /**
     * Legt den Wert der productTraceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTraceIDType }
     *     
     */
    public void setProductTraceID(ProductTraceIDType value) {
        this.productTraceID = value;
    }

    /**
     * Ruft den Wert der manufactureDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ManufactureDateType }
     *     
     */
    public ManufactureDateType getManufactureDate() {
        return manufactureDate;
    }

    /**
     * Legt den Wert der manufactureDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ManufactureDateType }
     *     
     */
    public void setManufactureDate(ManufactureDateType value) {
        this.manufactureDate = value;
    }

    /**
     * Ruft den Wert der manufactureTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ManufactureTimeType }
     *     
     */
    public ManufactureTimeType getManufactureTime() {
        return manufactureTime;
    }

    /**
     * Legt den Wert der manufactureTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ManufactureTimeType }
     *     
     */
    public void setManufactureTime(ManufactureTimeType value) {
        this.manufactureTime = value;
    }

    /**
     * Ruft den Wert der bestBeforeDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BestBeforeDateType }
     *     
     */
    public BestBeforeDateType getBestBeforeDate() {
        return bestBeforeDate;
    }

    /**
     * Legt den Wert der bestBeforeDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BestBeforeDateType }
     *     
     */
    public void setBestBeforeDate(BestBeforeDateType value) {
        this.bestBeforeDate = value;
    }

    /**
     * Ruft den Wert der registrationID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationIDType }
     *     
     */
    public RegistrationIDType getRegistrationID() {
        return registrationID;
    }

    /**
     * Legt den Wert der registrationID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationIDType }
     *     
     */
    public void setRegistrationID(RegistrationIDType value) {
        this.registrationID = value;
    }

    /**
     * Ruft den Wert der serialID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SerialIDType }
     *     
     */
    public SerialIDType getSerialID() {
        return serialID;
    }

    /**
     * Legt den Wert der serialID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SerialIDType }
     *     
     */
    public void setSerialID(SerialIDType value) {
        this.serialID = value;
    }

    /**
     * Gets the value of the additionalItemProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalItemProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalItemProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemPropertyType }
     * 
     * 
     */
    public List<ItemPropertyType> getAdditionalItemProperty() {
        if (additionalItemProperty == null) {
            additionalItemProperty = new ArrayList<ItemPropertyType>();
        }
        return this.additionalItemProperty;
    }

    /**
     * Ruft den Wert der lotIdentification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LotIdentificationType }
     *     
     */
    public LotIdentificationType getLotIdentification() {
        return lotIdentification;
    }

    /**
     * Legt den Wert der lotIdentification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LotIdentificationType }
     *     
     */
    public void setLotIdentification(LotIdentificationType value) {
        this.lotIdentification = value;
    }

}
