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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für WorkItemDimensionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WorkItemDimensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="ValueMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType"/>
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType"/>
 *         &lt;element name="ContractualLanguageCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ComponentWorkItemDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}WorkItemDimensionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkItemDimensionType", propOrder = {
    "id",
    "valueMeasure",
    "description",
    "typeCode",
    "contractualLanguageCode",
    "componentWorkItemDimension"
})
public class WorkItemDimensionType {

    @XmlElement(name = "ID")
    protected IDType id;
    @XmlElement(name = "ValueMeasure", required = true)
    protected MeasureType valueMeasure;
    @XmlElement(name = "Description")
    protected TextType description;
    @XmlElement(name = "TypeCode", required = true)
    protected CodeType typeCode;
    @XmlElement(name = "ContractualLanguageCode")
    protected CodeType contractualLanguageCode;
    @XmlElement(name = "ComponentWorkItemDimension")
    protected List<WorkItemDimensionType> componentWorkItemDimension;

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
     * Ruft den Wert der valueMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getValueMeasure() {
        return valueMeasure;
    }

    /**
     * Legt den Wert der valueMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setValueMeasure(MeasureType value) {
        this.valueMeasure = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDescription(TextType value) {
        this.description = value;
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
     * Ruft den Wert der contractualLanguageCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getContractualLanguageCode() {
        return contractualLanguageCode;
    }

    /**
     * Legt den Wert der contractualLanguageCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setContractualLanguageCode(CodeType value) {
        this.contractualLanguageCode = value;
    }

    /**
     * Gets the value of the componentWorkItemDimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentWorkItemDimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentWorkItemDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkItemDimensionType }
     * 
     * 
     */
    public List<WorkItemDimensionType> getComponentWorkItemDimension() {
        if (componentWorkItemDimension == null) {
            componentWorkItemDimension = new ArrayList<WorkItemDimensionType>();
        }
        return this.componentWorkItemDimension;
    }

}
