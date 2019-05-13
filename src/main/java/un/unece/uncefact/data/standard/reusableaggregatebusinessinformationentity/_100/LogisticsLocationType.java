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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für LogisticsLocationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LogisticsLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PhysicalGeographicalCoordinate" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}GeographicalCoordinateType" minOccurs="0"/>
 *         &lt;element name="PostalTradeAddress" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAddressType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogisticsLocationType", propOrder = {
    "id",
    "name",
    "typeCode",
    "description",
    "physicalGeographicalCoordinate",
    "postalTradeAddress"
})
public class LogisticsLocationType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "Name")
    protected List<TextType> name;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "PhysicalGeographicalCoordinate")
    protected GeographicalCoordinateType physicalGeographicalCoordinate;
    @XmlElement(name = "PostalTradeAddress")
    protected TradeAddressType postalTradeAddress;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getName() {
        if (name == null) {
            name = new ArrayList<TextType>();
        }
        return this.name;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setTypeCode(CodeType value) {
        this.typeCode = value;
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
     * Ruft den Wert der physicalGeographicalCoordinate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeographicalCoordinateType }
     *     
     */
    public GeographicalCoordinateType getPhysicalGeographicalCoordinate() {
        return physicalGeographicalCoordinate;
    }

    /**
     * Legt den Wert der physicalGeographicalCoordinate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicalCoordinateType }
     *     
     */
    public void setPhysicalGeographicalCoordinate(GeographicalCoordinateType value) {
        this.physicalGeographicalCoordinate = value;
    }

    /**
     * Ruft den Wert der postalTradeAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeAddressType }
     *     
     */
    public TradeAddressType getPostalTradeAddress() {
        return postalTradeAddress;
    }

    /**
     * Legt den Wert der postalTradeAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAddressType }
     *     
     */
    public void setPostalTradeAddress(TradeAddressType value) {
        this.postalTradeAddress = value;
    }

}
