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
import un.unece.uncefact.data.standard.qualifieddatatype._100.CountryIDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TradeAddressType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="PostcodeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="PostOfficeBox" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="BuildingName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineOne" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineTwo" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineThree" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineFour" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineFive" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="StreetName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CityName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CitySubDivisionName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CountryID" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CountryIDType" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CountrySubDivisionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="CountrySubDivisionName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AttentionOf" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CareOf" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="BuildingNumber" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="DepartmentName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="AdditionalStreetName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeAddressType", propOrder = {
    "id",
    "postcodeCode",
    "postOfficeBox",
    "buildingName",
    "lineOne",
    "lineTwo",
    "lineThree",
    "lineFour",
    "lineFive",
    "streetName",
    "cityName",
    "citySubDivisionName",
    "countryID",
    "countryName",
    "countrySubDivisionID",
    "countrySubDivisionName",
    "attentionOf",
    "careOf",
    "buildingNumber",
    "departmentName",
    "additionalStreetName"
})
public class TradeAddressType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "PostcodeCode")
    protected CodeType postcodeCode;
    @XmlElement(name = "PostOfficeBox")
    protected TextType postOfficeBox;
    @XmlElement(name = "BuildingName")
    protected TextType buildingName;
    @XmlElement(name = "LineOne")
    protected TextType lineOne;
    @XmlElement(name = "LineTwo")
    protected TextType lineTwo;
    @XmlElement(name = "LineThree")
    protected TextType lineThree;
    @XmlElement(name = "LineFour")
    protected TextType lineFour;
    @XmlElement(name = "LineFive")
    protected TextType lineFive;
    @XmlElement(name = "StreetName")
    protected TextType streetName;
    @XmlElement(name = "CityName")
    protected TextType cityName;
    @XmlElement(name = "CitySubDivisionName")
    protected TextType citySubDivisionName;
    @XmlElement(name = "CountryID")
    protected CountryIDType countryID;
    @XmlElement(name = "CountryName")
    protected List<TextType> countryName;
    @XmlElement(name = "CountrySubDivisionID")
    protected IDType countrySubDivisionID;
    @XmlElement(name = "CountrySubDivisionName")
    protected List<TextType> countrySubDivisionName;
    @XmlElement(name = "AttentionOf")
    protected TextType attentionOf;
    @XmlElement(name = "CareOf")
    protected TextType careOf;
    @XmlElement(name = "BuildingNumber")
    protected TextType buildingNumber;
    @XmlElement(name = "DepartmentName")
    protected TextType departmentName;
    @XmlElement(name = "AdditionalStreetName")
    protected TextType additionalStreetName;

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
     * Ruft den Wert der postcodeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getPostcodeCode() {
        return postcodeCode;
    }

    /**
     * Legt den Wert der postcodeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setPostcodeCode(CodeType value) {
        this.postcodeCode = value;
    }

    /**
     * Ruft den Wert der postOfficeBox-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPostOfficeBox() {
        return postOfficeBox;
    }

    /**
     * Legt den Wert der postOfficeBox-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPostOfficeBox(TextType value) {
        this.postOfficeBox = value;
    }

    /**
     * Ruft den Wert der buildingName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBuildingName() {
        return buildingName;
    }

    /**
     * Legt den Wert der buildingName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBuildingName(TextType value) {
        this.buildingName = value;
    }

    /**
     * Ruft den Wert der lineOne-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getLineOne() {
        return lineOne;
    }

    /**
     * Legt den Wert der lineOne-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setLineOne(TextType value) {
        this.lineOne = value;
    }

    /**
     * Ruft den Wert der lineTwo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getLineTwo() {
        return lineTwo;
    }

    /**
     * Legt den Wert der lineTwo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setLineTwo(TextType value) {
        this.lineTwo = value;
    }

    /**
     * Ruft den Wert der lineThree-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getLineThree() {
        return lineThree;
    }

    /**
     * Legt den Wert der lineThree-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setLineThree(TextType value) {
        this.lineThree = value;
    }

    /**
     * Ruft den Wert der lineFour-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getLineFour() {
        return lineFour;
    }

    /**
     * Legt den Wert der lineFour-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setLineFour(TextType value) {
        this.lineFour = value;
    }

    /**
     * Ruft den Wert der lineFive-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getLineFive() {
        return lineFive;
    }

    /**
     * Legt den Wert der lineFive-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setLineFive(TextType value) {
        this.lineFive = value;
    }

    /**
     * Ruft den Wert der streetName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStreetName() {
        return streetName;
    }

    /**
     * Legt den Wert der streetName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStreetName(TextType value) {
        this.streetName = value;
    }

    /**
     * Ruft den Wert der cityName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCityName() {
        return cityName;
    }

    /**
     * Legt den Wert der cityName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCityName(TextType value) {
        this.cityName = value;
    }

    /**
     * Ruft den Wert der citySubDivisionName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCitySubDivisionName() {
        return citySubDivisionName;
    }

    /**
     * Legt den Wert der citySubDivisionName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCitySubDivisionName(TextType value) {
        this.citySubDivisionName = value;
    }

    /**
     * Ruft den Wert der countryID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountryIDType }
     *     
     */
    public CountryIDType getCountryID() {
        return countryID;
    }

    /**
     * Legt den Wert der countryID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryIDType }
     *     
     */
    public void setCountryID(CountryIDType value) {
        this.countryID = value;
    }

    /**
     * Gets the value of the countryName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countryName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountryName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCountryName() {
        if (countryName == null) {
            countryName = new ArrayList<TextType>();
        }
        return this.countryName;
    }

    /**
     * Ruft den Wert der countrySubDivisionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getCountrySubDivisionID() {
        return countrySubDivisionID;
    }

    /**
     * Legt den Wert der countrySubDivisionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setCountrySubDivisionID(IDType value) {
        this.countrySubDivisionID = value;
    }

    /**
     * Gets the value of the countrySubDivisionName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countrySubDivisionName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountrySubDivisionName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCountrySubDivisionName() {
        if (countrySubDivisionName == null) {
            countrySubDivisionName = new ArrayList<TextType>();
        }
        return this.countrySubDivisionName;
    }

    /**
     * Ruft den Wert der attentionOf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAttentionOf() {
        return attentionOf;
    }

    /**
     * Legt den Wert der attentionOf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAttentionOf(TextType value) {
        this.attentionOf = value;
    }

    /**
     * Ruft den Wert der careOf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCareOf() {
        return careOf;
    }

    /**
     * Legt den Wert der careOf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCareOf(TextType value) {
        this.careOf = value;
    }

    /**
     * Ruft den Wert der buildingNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Legt den Wert der buildingNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBuildingNumber(TextType value) {
        this.buildingNumber = value;
    }

    /**
     * Ruft den Wert der departmentName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDepartmentName() {
        return departmentName;
    }

    /**
     * Legt den Wert der departmentName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDepartmentName(TextType value) {
        this.departmentName = value;
    }

    /**
     * Ruft den Wert der additionalStreetName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAdditionalStreetName() {
        return additionalStreetName;
    }

    /**
     * Legt den Wert der additionalStreetName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAdditionalStreetName(TextType value) {
        this.additionalStreetName = value;
    }

}
