//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompletionIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OccurrenceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OccurrenceTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TypeCodeType;


/**
 * <p>Java-Klasse für EventType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IdentificationID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OccurrenceDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OccurrenceTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompletionIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CurrentStatus" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Contact" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OccurenceLocation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventType", propOrder = {
    "identificationID",
    "occurrenceDate",
    "occurrenceTime",
    "typeCode",
    "description",
    "completionIndicator",
    "currentStatus",
    "contact",
    "occurenceLocation"
})
public class EventType {

    @XmlElement(name = "IdentificationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IdentificationIDType identificationID;
    @XmlElement(name = "OccurrenceDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OccurrenceDateType occurrenceDate;
    @XmlElement(name = "OccurrenceTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OccurrenceTimeType occurrenceTime;
    @XmlElement(name = "TypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TypeCodeType typeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "CompletionIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompletionIndicatorType completionIndicator;
    @XmlElement(name = "CurrentStatus")
    protected List<StatusType> currentStatus;
    @XmlElement(name = "Contact")
    protected List<ContactType> contact;
    @XmlElement(name = "OccurenceLocation")
    protected LocationType occurenceLocation;

    /**
     * Ruft den Wert der identificationID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationIDType }
     *     
     */
    public IdentificationIDType getIdentificationID() {
        return identificationID;
    }

    /**
     * Legt den Wert der identificationID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationIDType }
     *     
     */
    public void setIdentificationID(IdentificationIDType value) {
        this.identificationID = value;
    }

    /**
     * Ruft den Wert der occurrenceDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OccurrenceDateType }
     *     
     */
    public OccurrenceDateType getOccurrenceDate() {
        return occurrenceDate;
    }

    /**
     * Legt den Wert der occurrenceDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OccurrenceDateType }
     *     
     */
    public void setOccurrenceDate(OccurrenceDateType value) {
        this.occurrenceDate = value;
    }

    /**
     * Ruft den Wert der occurrenceTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OccurrenceTimeType }
     *     
     */
    public OccurrenceTimeType getOccurrenceTime() {
        return occurrenceTime;
    }

    /**
     * Legt den Wert der occurrenceTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OccurrenceTimeType }
     *     
     */
    public void setOccurrenceTime(OccurrenceTimeType value) {
        this.occurrenceTime = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TypeCodeType }
     *     
     */
    public TypeCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCodeType }
     *     
     */
    public void setTypeCode(TypeCodeType value) {
        this.typeCode = value;
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
     * Ruft den Wert der completionIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompletionIndicatorType }
     *     
     */
    public CompletionIndicatorType getCompletionIndicator() {
        return completionIndicator;
    }

    /**
     * Legt den Wert der completionIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletionIndicatorType }
     *     
     */
    public void setCompletionIndicator(CompletionIndicatorType value) {
        this.completionIndicator = value;
    }

    /**
     * Gets the value of the currentStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrentStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusType }
     * 
     * 
     */
    public List<StatusType> getCurrentStatus() {
        if (currentStatus == null) {
            currentStatus = new ArrayList<StatusType>();
        }
        return this.currentStatus;
    }

    /**
     * Gets the value of the contact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactType }
     * 
     * 
     */
    public List<ContactType> getContact() {
        if (contact == null) {
            contact = new ArrayList<ContactType>();
        }
        return this.contact;
    }

    /**
     * Ruft den Wert der occurenceLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getOccurenceLocation() {
        return occurenceLocation;
    }

    /**
     * Legt den Wert der occurenceLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setOccurenceLocation(LocationType value) {
        this.occurenceLocation = value;
    }

}
