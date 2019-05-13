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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AuctionConstraintIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AuctionURIType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConditionsDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ElectronicDeviceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.JustificationDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProcessDescriptionType;


/**
 * <p>Java-Klasse für AuctionTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AuctionTermsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AuctionConstraintIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}JustificationDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProcessDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConditionsDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ElectronicDeviceDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AuctionURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionTermsType", propOrder = {
    "auctionConstraintIndicator",
    "justificationDescription",
    "description",
    "processDescription",
    "conditionsDescription",
    "electronicDeviceDescription",
    "auctionURI"
})
public class AuctionTermsType {

    @XmlElement(name = "AuctionConstraintIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AuctionConstraintIndicatorType auctionConstraintIndicator;
    @XmlElement(name = "JustificationDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<JustificationDescriptionType> justificationDescription;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "ProcessDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ProcessDescriptionType> processDescription;
    @XmlElement(name = "ConditionsDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ConditionsDescriptionType> conditionsDescription;
    @XmlElement(name = "ElectronicDeviceDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ElectronicDeviceDescriptionType> electronicDeviceDescription;
    @XmlElement(name = "AuctionURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AuctionURIType auctionURI;

    /**
     * Ruft den Wert der auctionConstraintIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AuctionConstraintIndicatorType }
     *     
     */
    public AuctionConstraintIndicatorType getAuctionConstraintIndicator() {
        return auctionConstraintIndicator;
    }

    /**
     * Legt den Wert der auctionConstraintIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionConstraintIndicatorType }
     *     
     */
    public void setAuctionConstraintIndicator(AuctionConstraintIndicatorType value) {
        this.auctionConstraintIndicator = value;
    }

    /**
     * Gets the value of the justificationDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the justificationDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJustificationDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JustificationDescriptionType }
     * 
     * 
     */
    public List<JustificationDescriptionType> getJustificationDescription() {
        if (justificationDescription == null) {
            justificationDescription = new ArrayList<JustificationDescriptionType>();
        }
        return this.justificationDescription;
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
     * Gets the value of the processDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessDescriptionType }
     * 
     * 
     */
    public List<ProcessDescriptionType> getProcessDescription() {
        if (processDescription == null) {
            processDescription = new ArrayList<ProcessDescriptionType>();
        }
        return this.processDescription;
    }

    /**
     * Gets the value of the conditionsDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionsDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionsDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionsDescriptionType }
     * 
     * 
     */
    public List<ConditionsDescriptionType> getConditionsDescription() {
        if (conditionsDescription == null) {
            conditionsDescription = new ArrayList<ConditionsDescriptionType>();
        }
        return this.conditionsDescription;
    }

    /**
     * Gets the value of the electronicDeviceDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electronicDeviceDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectronicDeviceDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectronicDeviceDescriptionType }
     * 
     * 
     */
    public List<ElectronicDeviceDescriptionType> getElectronicDeviceDescription() {
        if (electronicDeviceDescription == null) {
            electronicDeviceDescription = new ArrayList<ElectronicDeviceDescriptionType>();
        }
        return this.electronicDeviceDescription;
    }

    /**
     * Ruft den Wert der auctionURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AuctionURIType }
     *     
     */
    public AuctionURIType getAuctionURI() {
        return auctionURI;
    }

    /**
     * Legt den Wert der auctionURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionURIType }
     *     
     */
    public void setAuctionURI(AuctionURIType value) {
        this.auctionURI = value;
    }

}
