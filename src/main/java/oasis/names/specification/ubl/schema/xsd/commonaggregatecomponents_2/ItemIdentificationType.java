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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BarcodeSymbologyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExtendedIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;


/**
 * <p>Java-Klasse für ItemIdentificationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ItemIdentificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExtendedID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BarcodeSymbologyID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PhysicalAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementDimension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}IssuerParty" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemIdentificationType", propOrder = {
    "id",
    "extendedID",
    "barcodeSymbologyID",
    "physicalAttribute",
    "measurementDimension",
    "issuerParty"
})
public class ItemIdentificationType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "ExtendedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExtendedIDType extendedID;
    @XmlElement(name = "BarcodeSymbologyID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BarcodeSymbologyIDType barcodeSymbologyID;
    @XmlElement(name = "PhysicalAttribute")
    protected List<PhysicalAttributeType> physicalAttribute;
    @XmlElement(name = "MeasurementDimension")
    protected List<DimensionType> measurementDimension;
    @XmlElement(name = "IssuerParty")
    protected PartyType issuerParty;

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
     * Ruft den Wert der extendedID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedIDType }
     *     
     */
    public ExtendedIDType getExtendedID() {
        return extendedID;
    }

    /**
     * Legt den Wert der extendedID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedIDType }
     *     
     */
    public void setExtendedID(ExtendedIDType value) {
        this.extendedID = value;
    }

    /**
     * Ruft den Wert der barcodeSymbologyID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BarcodeSymbologyIDType }
     *     
     */
    public BarcodeSymbologyIDType getBarcodeSymbologyID() {
        return barcodeSymbologyID;
    }

    /**
     * Legt den Wert der barcodeSymbologyID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BarcodeSymbologyIDType }
     *     
     */
    public void setBarcodeSymbologyID(BarcodeSymbologyIDType value) {
        this.barcodeSymbologyID = value;
    }

    /**
     * Gets the value of the physicalAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physicalAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysicalAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalAttributeType }
     * 
     * 
     */
    public List<PhysicalAttributeType> getPhysicalAttribute() {
        if (physicalAttribute == null) {
            physicalAttribute = new ArrayList<PhysicalAttributeType>();
        }
        return this.physicalAttribute;
    }

    /**
     * Gets the value of the measurementDimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measurementDimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasurementDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionType }
     * 
     * 
     */
    public List<DimensionType> getMeasurementDimension() {
        if (measurementDimension == null) {
            measurementDimension = new ArrayList<DimensionType>();
        }
        return this.measurementDimension;
    }

    /**
     * Ruft den Wert der issuerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getIssuerParty() {
        return issuerParty;
    }

    /**
     * Legt den Wert der issuerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setIssuerParty(PartyType value) {
        this.issuerParty = value;
    }

}
