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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.MeasureType;


/**
 * <p>Java-Klasse für GeographicalCoordinateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GeographicalCoordinateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AltitudeMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="LatitudeMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="LongitudeMeasure" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}MeasureType" minOccurs="0"/>
 *         &lt;element name="SystemID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicalCoordinateType", propOrder = {
    "altitudeMeasure",
    "latitudeMeasure",
    "longitudeMeasure",
    "systemID"
})
public class GeographicalCoordinateType {

    @XmlElement(name = "AltitudeMeasure")
    protected MeasureType altitudeMeasure;
    @XmlElement(name = "LatitudeMeasure")
    protected MeasureType latitudeMeasure;
    @XmlElement(name = "LongitudeMeasure")
    protected MeasureType longitudeMeasure;
    @XmlElement(name = "SystemID")
    protected IDType systemID;

    /**
     * Ruft den Wert der altitudeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getAltitudeMeasure() {
        return altitudeMeasure;
    }

    /**
     * Legt den Wert der altitudeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setAltitudeMeasure(MeasureType value) {
        this.altitudeMeasure = value;
    }

    /**
     * Ruft den Wert der latitudeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getLatitudeMeasure() {
        return latitudeMeasure;
    }

    /**
     * Legt den Wert der latitudeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setLatitudeMeasure(MeasureType value) {
        this.latitudeMeasure = value;
    }

    /**
     * Ruft den Wert der longitudeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getLongitudeMeasure() {
        return longitudeMeasure;
    }

    /**
     * Legt den Wert der longitudeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setLongitudeMeasure(MeasureType value) {
        this.longitudeMeasure = value;
    }

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

}
