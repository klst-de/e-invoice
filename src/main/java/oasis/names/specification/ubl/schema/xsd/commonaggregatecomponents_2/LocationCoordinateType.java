//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AltitudeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CoordinateSystemCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeDegreesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeDirectionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeMinutesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeDegreesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeDirectionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeMinutesMeasureType;


/**
 * <p>Java-Klasse für LocationCoordinateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LocationCoordinateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CoordinateSystemCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatitudeDegreesMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatitudeMinutesMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatitudeDirectionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LongitudeDegreesMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LongitudeMinutesMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LongitudeDirectionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AltitudeMeasure" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationCoordinateType", propOrder = {
    "coordinateSystemCode",
    "latitudeDegreesMeasure",
    "latitudeMinutesMeasure",
    "latitudeDirectionCode",
    "longitudeDegreesMeasure",
    "longitudeMinutesMeasure",
    "longitudeDirectionCode",
    "altitudeMeasure"
})
public class LocationCoordinateType {

    @XmlElement(name = "CoordinateSystemCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CoordinateSystemCodeType coordinateSystemCode;
    @XmlElement(name = "LatitudeDegreesMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatitudeDegreesMeasureType latitudeDegreesMeasure;
    @XmlElement(name = "LatitudeMinutesMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatitudeMinutesMeasureType latitudeMinutesMeasure;
    @XmlElement(name = "LatitudeDirectionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatitudeDirectionCodeType latitudeDirectionCode;
    @XmlElement(name = "LongitudeDegreesMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LongitudeDegreesMeasureType longitudeDegreesMeasure;
    @XmlElement(name = "LongitudeMinutesMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LongitudeMinutesMeasureType longitudeMinutesMeasure;
    @XmlElement(name = "LongitudeDirectionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LongitudeDirectionCodeType longitudeDirectionCode;
    @XmlElement(name = "AltitudeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AltitudeMeasureType altitudeMeasure;

    /**
     * Ruft den Wert der coordinateSystemCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoordinateSystemCodeType }
     *     
     */
    public CoordinateSystemCodeType getCoordinateSystemCode() {
        return coordinateSystemCode;
    }

    /**
     * Legt den Wert der coordinateSystemCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinateSystemCodeType }
     *     
     */
    public void setCoordinateSystemCode(CoordinateSystemCodeType value) {
        this.coordinateSystemCode = value;
    }

    /**
     * Ruft den Wert der latitudeDegreesMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LatitudeDegreesMeasureType }
     *     
     */
    public LatitudeDegreesMeasureType getLatitudeDegreesMeasure() {
        return latitudeDegreesMeasure;
    }

    /**
     * Legt den Wert der latitudeDegreesMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LatitudeDegreesMeasureType }
     *     
     */
    public void setLatitudeDegreesMeasure(LatitudeDegreesMeasureType value) {
        this.latitudeDegreesMeasure = value;
    }

    /**
     * Ruft den Wert der latitudeMinutesMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LatitudeMinutesMeasureType }
     *     
     */
    public LatitudeMinutesMeasureType getLatitudeMinutesMeasure() {
        return latitudeMinutesMeasure;
    }

    /**
     * Legt den Wert der latitudeMinutesMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LatitudeMinutesMeasureType }
     *     
     */
    public void setLatitudeMinutesMeasure(LatitudeMinutesMeasureType value) {
        this.latitudeMinutesMeasure = value;
    }

    /**
     * Ruft den Wert der latitudeDirectionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LatitudeDirectionCodeType }
     *     
     */
    public LatitudeDirectionCodeType getLatitudeDirectionCode() {
        return latitudeDirectionCode;
    }

    /**
     * Legt den Wert der latitudeDirectionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LatitudeDirectionCodeType }
     *     
     */
    public void setLatitudeDirectionCode(LatitudeDirectionCodeType value) {
        this.latitudeDirectionCode = value;
    }

    /**
     * Ruft den Wert der longitudeDegreesMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LongitudeDegreesMeasureType }
     *     
     */
    public LongitudeDegreesMeasureType getLongitudeDegreesMeasure() {
        return longitudeDegreesMeasure;
    }

    /**
     * Legt den Wert der longitudeDegreesMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LongitudeDegreesMeasureType }
     *     
     */
    public void setLongitudeDegreesMeasure(LongitudeDegreesMeasureType value) {
        this.longitudeDegreesMeasure = value;
    }

    /**
     * Ruft den Wert der longitudeMinutesMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LongitudeMinutesMeasureType }
     *     
     */
    public LongitudeMinutesMeasureType getLongitudeMinutesMeasure() {
        return longitudeMinutesMeasure;
    }

    /**
     * Legt den Wert der longitudeMinutesMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LongitudeMinutesMeasureType }
     *     
     */
    public void setLongitudeMinutesMeasure(LongitudeMinutesMeasureType value) {
        this.longitudeMinutesMeasure = value;
    }

    /**
     * Ruft den Wert der longitudeDirectionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LongitudeDirectionCodeType }
     *     
     */
    public LongitudeDirectionCodeType getLongitudeDirectionCode() {
        return longitudeDirectionCode;
    }

    /**
     * Legt den Wert der longitudeDirectionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LongitudeDirectionCodeType }
     *     
     */
    public void setLongitudeDirectionCode(LongitudeDirectionCodeType value) {
        this.longitudeDirectionCode = value;
    }

    /**
     * Ruft den Wert der altitudeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AltitudeMeasureType }
     *     
     */
    public AltitudeMeasureType getAltitudeMeasure() {
        return altitudeMeasure;
    }

    /**
     * Legt den Wert der altitudeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AltitudeMeasureType }
     *     
     */
    public void setAltitudeMeasure(AltitudeMeasureType value) {
        this.altitudeMeasure = value;
    }

}
