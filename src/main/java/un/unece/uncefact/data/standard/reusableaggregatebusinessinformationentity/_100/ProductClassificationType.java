//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
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
 * <p>Java-Klasse für ProductClassificationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ProductClassificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SystemID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="SystemName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ClassCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ClassName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SubClassCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ClassProductCharacteristic" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ProductCharacteristicType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicableReferencedStandard" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}ReferencedStandardType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductClassificationType", propOrder = {
    "systemID",
    "systemName",
    "classCode",
    "className",
    "subClassCode",
    "classProductCharacteristic",
    "applicableReferencedStandard"
})
public class ProductClassificationType {

    @XmlElement(name = "SystemID")
    protected IDType systemID;
    @XmlElement(name = "SystemName")
    protected List<TextType> systemName;
    @XmlElement(name = "ClassCode")
    protected CodeType classCode;
    @XmlElement(name = "ClassName")
    protected List<TextType> className;
    @XmlElement(name = "SubClassCode")
    protected CodeType subClassCode;
    @XmlElement(name = "ClassProductCharacteristic")
    protected List<ProductCharacteristicType> classProductCharacteristic;
    @XmlElement(name = "ApplicableReferencedStandard")
    protected ReferencedStandardType applicableReferencedStandard;

    /**
     * Ruft den Wert der systemID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSystemID() {
        return systemID;
    }

    /**
     * Legt den Wert der systemID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSystemID(IDType value) {
        this.systemID = value;
    }

    /**
     * Gets the value of the systemName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the systemName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystemName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getSystemName() {
        if (systemName == null) {
            systemName = new ArrayList<TextType>();
        }
        return this.systemName;
    }

    /**
     * Ruft den Wert der classCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getClassCode() {
        return classCode;
    }

    /**
     * Legt den Wert der classCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setClassCode(CodeType value) {
        this.classCode = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the className property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getClassName() {
        if (className == null) {
            className = new ArrayList<TextType>();
        }
        return this.className;
    }

    /**
     * Ruft den Wert der subClassCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getSubClassCode() {
        return subClassCode;
    }

    /**
     * Legt den Wert der subClassCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setSubClassCode(CodeType value) {
        this.subClassCode = value;
    }

    /**
     * Gets the value of the classProductCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classProductCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassProductCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductCharacteristicType }
     * 
     * 
     */
    public List<ProductCharacteristicType> getClassProductCharacteristic() {
        if (classProductCharacteristic == null) {
            classProductCharacteristic = new ArrayList<ProductCharacteristicType>();
        }
        return this.classProductCharacteristic;
    }

    /**
     * Ruft den Wert der applicableReferencedStandard-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferencedStandardType }
     *     
     */
    public ReferencedStandardType getApplicableReferencedStandard() {
        return applicableReferencedStandard;
    }

    /**
     * Legt den Wert der applicableReferencedStandard-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencedStandardType }
     *     
     */
    public void setApplicableReferencedStandard(ReferencedStandardType value) {
        this.applicableReferencedStandard = value;
    }

}
