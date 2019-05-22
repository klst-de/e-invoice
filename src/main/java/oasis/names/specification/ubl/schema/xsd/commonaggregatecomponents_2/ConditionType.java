//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AttributeIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumMeasureType;


/**
 * <p>Java-Klasse für ConditionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConditionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AttributeID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Measure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumMeasure" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionType", propOrder = {
    "attributeID",
    "measure",
    "description",
    "minimumMeasure",
    "maximumMeasure"
})
public class ConditionType {

    @XmlElement(name = "AttributeID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected AttributeIDType attributeID;
    @XmlElement(name = "Measure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeasureType measure;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "MinimumMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumMeasureType minimumMeasure;
    @XmlElement(name = "MaximumMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumMeasureType maximumMeasure;

    /**
     * Ruft den Wert der attributeID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AttributeIDType }
     *     
     */
    public AttributeIDType getAttributeID() {
        return attributeID;
    }

    /**
     * Legt den Wert der attributeID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeIDType }
     *     
     */
    public void setAttributeID(AttributeIDType value) {
        this.attributeID = value;
    }

    /**
     * Ruft den Wert der measure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMeasure() {
        return measure;
    }

    /**
     * Legt den Wert der measure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMeasure(MeasureType value) {
        this.measure = value;
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
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der minimumMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumMeasureType }
     *     
     */
    public MinimumMeasureType getMinimumMeasure() {
        return minimumMeasure;
    }

    /**
     * Legt den Wert der minimumMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumMeasureType }
     *     
     */
    public void setMinimumMeasure(MinimumMeasureType value) {
        this.minimumMeasure = value;
    }

    /**
     * Ruft den Wert der maximumMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumMeasureType }
     *     
     */
    public MaximumMeasureType getMaximumMeasure() {
        return maximumMeasure;
    }

    /**
     * Legt den Wert der maximumMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumMeasureType }
     *     
     */
    public void setMaximumMeasure(MaximumMeasureType value) {
        this.maximumMeasure = value;
    }

}
