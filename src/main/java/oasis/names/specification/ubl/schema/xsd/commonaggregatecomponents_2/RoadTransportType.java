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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LicensePlateIDType;


/**
 * <p>Java-Klasse für RoadTransportType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RoadTransportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LicensePlateID"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
