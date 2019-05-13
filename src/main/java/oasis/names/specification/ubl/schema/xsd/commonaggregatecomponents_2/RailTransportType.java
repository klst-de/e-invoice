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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RailCarIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TrainIDType;


/**
 * <p>Java-Klasse für RailTransportType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RailTransportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TrainID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RailCarID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RailTransportType", propOrder = {
    "trainID",
    "railCarID"
})
public class RailTransportType {

    @XmlElement(name = "TrainID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TrainIDType trainID;
    @XmlElement(name = "RailCarID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RailCarIDType railCarID;

    /**
     * Ruft den Wert der trainID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrainIDType }
     *     
     */
    public TrainIDType getTrainID() {
        return trainID;
    }

    /**
     * Legt den Wert der trainID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainIDType }
     *     
     */
    public void setTrainID(TrainIDType value) {
        this.trainID = value;
    }

    /**
     * Ruft den Wert der railCarID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RailCarIDType }
     *     
     */
    public RailCarIDType getRailCarID() {
        return railCarID;
    }

    /**
     * Legt den Wert der railCarID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RailCarIDType }
     *     
     */
    public void setRailCarID(RailCarIDType value) {
        this.railCarID = value;
    }

}
