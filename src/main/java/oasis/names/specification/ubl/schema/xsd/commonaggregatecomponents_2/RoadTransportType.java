//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LicensePlateIDType;


/**
 * <p>Java-Klasse f�r RoadTransportType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RoadTransportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LicensePlateID"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoadTransportType", propOrder = {
    "licensePlateID"
})
public class RoadTransportType {

    @XmlElement(name = "LicensePlateID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LicensePlateIDType licensePlateID;

    /**
     * Ruft den Wert der licensePlateID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LicensePlateIDType }
     *     
     */
    public LicensePlateIDType getLicensePlateID() {
        return licensePlateID;
    }

    /**
     * Legt den Wert der licensePlateID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LicensePlateIDType }
     *     
     */
    public void setLicensePlateID(LicensePlateIDType value) {
        this.licensePlateID = value;
    }

}