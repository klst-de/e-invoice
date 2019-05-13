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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für ReferencedProductType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReferencedProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GlobalID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SellerAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="BuyerAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="ManufacturerAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IndustryAssignedID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RelationshipTypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UnitQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencedProductType", propOrder = {
    "id",
    "globalID",
    "sellerAssignedID",
    "buyerAssignedID",
    "manufacturerAssignedID",
    "industryAssignedID",
    "name",
    "description",
    "relationshipTypeCode",
    "unitQuantity"
})
public class ReferencedProductType {

    @XmlElement(name = "ID")
    protected List<IDType> id;
    @XmlElement(name = "GlobalID")
    protected List<IDType> globalID;
    @XmlElement(name = "SellerAssignedID")
    protected IDType sellerAssignedID;
    @XmlElement(name = "BuyerAssignedID")
    protected IDType buyerAssignedID;
    @XmlElement(name = "ManufacturerAssignedID")
    protected List<IDType> manufacturerAssignedID;
    @XmlElement(name = "IndustryAssignedID")
    protected List<IDType> industryAssignedID;
    @XmlElement(name = "Name")
    protected List<TextType> name;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "RelationshipTypeCode")
    protected List<CodeType> relationshipTypeCode;
    @XmlElement(name = "UnitQuantity")
    protected List<QuantityType> unitQuantity;

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
     * Gets the value of the globalID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the globalID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlobalID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getGlobalID() {
        if (globalID == null) {
            globalID = new ArrayList<IDType>();
        }
        return this.globalID;
    }

    /**
     * Ruft den Wert der sellerAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSellerAssignedID() {
        return sellerAssignedID;
    }

    /**
     * Legt den Wert der sellerAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSellerAssignedID(IDType value) {
        this.sellerAssignedID = value;
    }

    /**
     * Ruft den Wert der buyerAssignedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getBuyerAssignedID() {
        return buyerAssignedID;
    }

    /**
     * Legt den Wert der buyerAssignedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setBuyerAssignedID(IDType value) {
        this.buyerAssignedID = value;
    }

    /**
     * Gets the value of the manufacturerAssignedID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manufacturerAssignedID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManufacturerAssignedID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getManufacturerAssignedID() {
        if (manufacturerAssignedID == null) {
            manufacturerAssignedID = new ArrayList<IDType>();
        }
        return this.manufacturerAssignedID;
    }

    /**
     * Gets the value of the industryAssignedID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the industryAssignedID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndustryAssignedID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getIndustryAssignedID() {
        if (industryAssignedID == null) {
            industryAssignedID = new ArrayList<IDType>();
        }
        return this.industryAssignedID;
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
     * Gets the value of the relationshipTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relationshipTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationshipTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getRelationshipTypeCode() {
        if (relationshipTypeCode == null) {
            relationshipTypeCode = new ArrayList<CodeType>();
        }
        return this.relationshipTypeCode;
    }

    /**
     * Gets the value of the unitQuantity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unitQuantity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnitQuantity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantityType }
     * 
     * 
     */
    public List<QuantityType> getUnitQuantity() {
        if (unitQuantity == null) {
            unitQuantity = new ArrayList<QuantityType>();
        }
        return this.unitQuantity;
    }

}
