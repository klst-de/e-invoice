//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationMethodCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FullnessIndicationCodeType;


/**
 * <p>Java-Klasse für EmissionCalculationMethodType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EmissionCalculationMethodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CalculationMethodCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FullnessIndicationCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementFromLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementToLocation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmissionCalculationMethodType", propOrder = {
    "calculationMethodCode",
    "fullnessIndicationCode",
    "measurementFromLocation",
    "measurementToLocation"
})
public class EmissionCalculationMethodType {

    @XmlElement(name = "CalculationMethodCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CalculationMethodCodeType calculationMethodCode;
    @XmlElement(name = "FullnessIndicationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FullnessIndicationCodeType fullnessIndicationCode;
    @XmlElement(name = "MeasurementFromLocation")
    protected LocationType measurementFromLocation;
    @XmlElement(name = "MeasurementToLocation")
    protected LocationType measurementToLocation;

    /**
     * Ruft den Wert der calculationMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CalculationMethodCodeType }
     *     
     */
    public CalculationMethodCodeType getCalculationMethodCode() {
        return calculationMethodCode;
    }

    /**
     * Legt den Wert der calculationMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculationMethodCodeType }
     *     
     */
    public void setCalculationMethodCode(CalculationMethodCodeType value) {
        this.calculationMethodCode = value;
    }

    /**
     * Ruft den Wert der fullnessIndicationCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FullnessIndicationCodeType }
     *     
     */
    public FullnessIndicationCodeType getFullnessIndicationCode() {
        return fullnessIndicationCode;
    }

    /**
     * Legt den Wert der fullnessIndicationCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FullnessIndicationCodeType }
     *     
     */
    public void setFullnessIndicationCode(FullnessIndicationCodeType value) {
        this.fullnessIndicationCode = value;
    }

    /**
     * Ruft den Wert der measurementFromLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getMeasurementFromLocation() {
        return measurementFromLocation;
    }

    /**
     * Legt den Wert der measurementFromLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setMeasurementFromLocation(LocationType value) {
        this.measurementFromLocation = value;
    }

    /**
     * Ruft den Wert der measurementToLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getMeasurementToLocation() {
        return measurementToLocation;
    }

    /**
     * Legt den Wert der measurementToLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setMeasurementToLocation(LocationType value) {
        this.measurementToLocation = value;
    }

}
