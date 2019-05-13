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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LotNumberIDType;


/**
 * <p>Java-Klasse für LotIdentificationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LotIdentificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LotNumberID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExpiryDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalItemProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LotIdentificationType", propOrder = {
    "lotNumberID",
    "expiryDate",
    "additionalItemProperty"
})
public class LotIdentificationType {

    @XmlElement(name = "LotNumberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LotNumberIDType lotNumberID;
    @XmlElement(name = "ExpiryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExpiryDateType expiryDate;
    @XmlElement(name = "AdditionalItemProperty")
    protected List<ItemPropertyType> additionalItemProperty;

    /**
     * Ruft den Wert der lotNumberID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LotNumberIDType }
     *     
     */
    public LotNumberIDType getLotNumberID() {
        return lotNumberID;
    }

    /**
     * Legt den Wert der lotNumberID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LotNumberIDType }
     *     
     */
    public void setLotNumberID(LotNumberIDType value) {
        this.lotNumberID = value;
    }

    /**
     * Ruft den Wert der expiryDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpiryDateType }
     *     
     */
    public ExpiryDateType getExpiryDate() {
        return expiryDate;
    }

    /**
     * Legt den Wert der expiryDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpiryDateType }
     *     
     */
    public void setExpiryDate(ExpiryDateType value) {
        this.expiryDate = value;
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

}
