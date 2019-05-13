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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossTonnageMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetTonnageMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RadioCallSignIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ShipsRequirementsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.VesselIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.VesselNameType;


/**
 * <p>Java-Klasse für MaritimeTransportType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MaritimeTransportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}VesselID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}VesselName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RadioCallSignID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ShipsRequirements" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossTonnageMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetTonnageMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RegistryCertificateDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RegistryPortLocation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaritimeTransportType", propOrder = {
    "vesselID",
    "vesselName",
    "radioCallSignID",
    "shipsRequirements",
    "grossTonnageMeasure",
    "netTonnageMeasure",
    "registryCertificateDocumentReference",
    "registryPortLocation"
})
public class MaritimeTransportType {

    @XmlElement(name = "VesselID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected VesselIDType vesselID;
    @XmlElement(name = "VesselName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected VesselNameType vesselName;
    @XmlElement(name = "RadioCallSignID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RadioCallSignIDType radioCallSignID;
    @XmlElement(name = "ShipsRequirements", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ShipsRequirementsType> shipsRequirements;
    @XmlElement(name = "GrossTonnageMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossTonnageMeasureType grossTonnageMeasure;
    @XmlElement(name = "NetTonnageMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetTonnageMeasureType netTonnageMeasure;
    @XmlElement(name = "RegistryCertificateDocumentReference")
    protected DocumentReferenceType registryCertificateDocumentReference;
    @XmlElement(name = "RegistryPortLocation")
    protected LocationType registryPortLocation;

    /**
     * Ruft den Wert der vesselID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VesselIDType }
     *     
     */
    public VesselIDType getVesselID() {
        return vesselID;
    }

    /**
     * Legt den Wert der vesselID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VesselIDType }
     *     
     */
    public void setVesselID(VesselIDType value) {
        this.vesselID = value;
    }

    /**
     * Ruft den Wert der vesselName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VesselNameType }
     *     
     */
    public VesselNameType getVesselName() {
        return vesselName;
    }

    /**
     * Legt den Wert der vesselName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VesselNameType }
     *     
     */
    public void setVesselName(VesselNameType value) {
        this.vesselName = value;
    }

    /**
     * Ruft den Wert der radioCallSignID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RadioCallSignIDType }
     *     
     */
    public RadioCallSignIDType getRadioCallSignID() {
        return radioCallSignID;
    }

    /**
     * Legt den Wert der radioCallSignID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioCallSignIDType }
     *     
     */
    public void setRadioCallSignID(RadioCallSignIDType value) {
        this.radioCallSignID = value;
    }

    /**
     * Gets the value of the shipsRequirements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipsRequirements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipsRequirements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipsRequirementsType }
     * 
     * 
     */
    public List<ShipsRequirementsType> getShipsRequirements() {
        if (shipsRequirements == null) {
            shipsRequirements = new ArrayList<ShipsRequirementsType>();
        }
        return this.shipsRequirements;
    }

    /**
     * Ruft den Wert der grossTonnageMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GrossTonnageMeasureType }
     *     
     */
    public GrossTonnageMeasureType getGrossTonnageMeasure() {
        return grossTonnageMeasure;
    }

    /**
     * Legt den Wert der grossTonnageMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GrossTonnageMeasureType }
     *     
     */
    public void setGrossTonnageMeasure(GrossTonnageMeasureType value) {
        this.grossTonnageMeasure = value;
    }

    /**
     * Ruft den Wert der netTonnageMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetTonnageMeasureType }
     *     
     */
    public NetTonnageMeasureType getNetTonnageMeasure() {
        return netTonnageMeasure;
    }

    /**
     * Legt den Wert der netTonnageMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetTonnageMeasureType }
     *     
     */
    public void setNetTonnageMeasure(NetTonnageMeasureType value) {
        this.netTonnageMeasure = value;
    }

    /**
     * Ruft den Wert der registryCertificateDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getRegistryCertificateDocumentReference() {
        return registryCertificateDocumentReference;
    }

    /**
     * Legt den Wert der registryCertificateDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setRegistryCertificateDocumentReference(DocumentReferenceType value) {
        this.registryCertificateDocumentReference = value;
    }

    /**
     * Ruft den Wert der registryPortLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getRegistryPortLocation() {
        return registryPortLocation;
    }

    /**
     * Legt den Wert der registryPortLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setRegistryPortLocation(LocationType value) {
        this.registryPortLocation = value;
    }

}
