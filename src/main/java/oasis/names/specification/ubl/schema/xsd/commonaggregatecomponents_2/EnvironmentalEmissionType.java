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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EnvironmentalEmissionTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueMeasureType;


/**
 * <p>Java-Klasse für EnvironmentalEmissionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EnvironmentalEmissionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EnvironmentalEmissionTypeCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueMeasure"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EmissionCalculationMethod" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvironmentalEmissionType", propOrder = {
    "environmentalEmissionTypeCode",
    "valueMeasure",
    "description",
    "emissionCalculationMethod"
})
public class EnvironmentalEmissionType {

    @XmlElement(name = "EnvironmentalEmissionTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected EnvironmentalEmissionTypeCodeType environmentalEmissionTypeCode;
    @XmlElement(name = "ValueMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ValueMeasureType valueMeasure;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "EmissionCalculationMethod")
    protected List<EmissionCalculationMethodType> emissionCalculationMethod;

    /**
     * Ruft den Wert der environmentalEmissionTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EnvironmentalEmissionTypeCodeType }
     *     
     */
    public EnvironmentalEmissionTypeCodeType getEnvironmentalEmissionTypeCode() {
        return environmentalEmissionTypeCode;
    }

    /**
     * Legt den Wert der environmentalEmissionTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvironmentalEmissionTypeCodeType }
     *     
     */
    public void setEnvironmentalEmissionTypeCode(EnvironmentalEmissionTypeCodeType value) {
        this.environmentalEmissionTypeCode = value;
    }

    /**
     * Ruft den Wert der valueMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValueMeasureType }
     *     
     */
    public ValueMeasureType getValueMeasure() {
        return valueMeasure;
    }

    /**
     * Legt den Wert der valueMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueMeasureType }
     *     
     */
    public void setValueMeasure(ValueMeasureType value) {
        this.valueMeasure = value;
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
     * Gets the value of the emissionCalculationMethod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emissionCalculationMethod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmissionCalculationMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmissionCalculationMethodType }
     * 
     * 
     */
    public List<EmissionCalculationMethodType> getEmissionCalculationMethod() {
        if (emissionCalculationMethod == null) {
            emissionCalculationMethod = new ArrayList<EmissionCalculationMethodType>();
        }
        return this.emissionCalculationMethod;
    }

}
