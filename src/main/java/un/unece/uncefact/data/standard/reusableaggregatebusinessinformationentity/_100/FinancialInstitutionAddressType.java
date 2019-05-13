//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für FinancialInstitutionAddressType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PostcodeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="BuildingNumber" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineOne" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineTwo" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineThree" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineFour" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="LineFive" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="StreetName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CityName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CountrySubDivisionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="CountryID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="DepartmentName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="PostOfficeBox" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CityID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="CountrySubDivisionName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionAddressType", propOrder = {
    "postcodeCode",
    "buildingNumber",
    "lineOne",
    "lineTwo",
    "lineThree",
    "lineFour",
    "lineFive",
    "streetName",
    "cityName",
    "countrySubDivisionID",
    "countryID",
    "typeCode",
    "departmentName",
    "postOfficeBox",
    "cityID",
    "countrySubDivisionName",
    "countryName"
})
public class FinancialInstitutionAddressType {

    @XmlElement(name = "PostcodeCode")
    protected CodeType postcodeCode;
    @XmlElement(name = "BuildingNumber")
    protected TextType buildingNumber;
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
    @XmlElement(name = "CountrySubDivisionID")
    protected IDType countrySubDivisionID;
    @XmlElement(name = "CountryID")
    protected IDType countryID;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "DepartmentName")
    protected TextType departmentName;
    @XmlElement(name = "PostOfficeBox")
    protected TextType postOfficeBox;
    @XmlElement(name = "CityID")
    protected IDType cityID;
    @XmlElement(name = "CountrySubDivisionName")
    protected TextType countrySubDivisionName;
    @XmlElement(name = "CountryName")
    protected TextType countryName;

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
     * Ruft den Wert der countryID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getCountryID() {
        return countryID;
    }

    /**
     * Legt den Wert der countryID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setCountryID(IDType value) {
        this.countryID = value;
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
     * Ruft den Wert der cityID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getCityID() {
        return cityID;
    }

    /**
     * Legt den Wert der cityID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setCityID(IDType value) {
        this.cityID = value;
    }

    /**
     * Ruft den Wert der countrySubDivisionName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCountrySubDivisionName() {
        return countrySubDivisionName;
    }

    /**
     * Legt den Wert der countrySubDivisionName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCountrySubDivisionName(TextType value) {
        this.countrySubDivisionName = value;
    }

    /**
     * Ruft den Wert der countryName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCountryName() {
        return countryName;
    }

    /**
     * Legt den Wert der countryName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCountryName(TextType value) {
        this.countryName = value;
    }

}
