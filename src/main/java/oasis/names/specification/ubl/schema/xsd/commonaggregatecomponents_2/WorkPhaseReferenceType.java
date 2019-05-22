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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProgressPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WorkPhaseCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WorkPhaseType;


/**
 * <p>Java-Klasse für WorkPhaseReferenceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WorkPhaseReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WorkPhaseCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WorkPhase" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProgressPercent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}StartDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EndDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WorkOrderDocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkPhaseReferenceType", propOrder = {
    "id",
    "workPhaseCode",
    "workPhase",
    "progressPercent",
    "startDate",
    "endDate",
    "workOrderDocumentReference"
})
public class WorkPhaseReferenceType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "WorkPhaseCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WorkPhaseCodeType workPhaseCode;
    @XmlElement(name = "WorkPhase", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<WorkPhaseType> workPhase;
    @XmlElement(name = "ProgressPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProgressPercentType progressPercent;
    @XmlElement(name = "StartDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected StartDateType startDate;
    @XmlElement(name = "EndDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EndDateType endDate;
    @XmlElement(name = "WorkOrderDocumentReference")
    protected List<DocumentReferenceType> workOrderDocumentReference;

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
     * Ruft den Wert der workPhaseCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WorkPhaseCodeType }
     *     
     */
    public WorkPhaseCodeType getWorkPhaseCode() {
        return workPhaseCode;
    }

    /**
     * Legt den Wert der workPhaseCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkPhaseCodeType }
     *     
     */
    public void setWorkPhaseCode(WorkPhaseCodeType value) {
        this.workPhaseCode = value;
    }

    /**
     * Gets the value of the workPhase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workPhase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkPhase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkPhaseType }
     * 
     * 
     */
    public List<WorkPhaseType> getWorkPhase() {
        if (workPhase == null) {
            workPhase = new ArrayList<WorkPhaseType>();
        }
        return this.workPhase;
    }

    /**
     * Ruft den Wert der progressPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProgressPercentType }
     *     
     */
    public ProgressPercentType getProgressPercent() {
        return progressPercent;
    }

    /**
     * Legt den Wert der progressPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgressPercentType }
     *     
     */
    public void setProgressPercent(ProgressPercentType value) {
        this.progressPercent = value;
    }

    /**
     * Ruft den Wert der startDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StartDateType }
     *     
     */
    public StartDateType getStartDate() {
        return startDate;
    }

    /**
     * Legt den Wert der startDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StartDateType }
     *     
     */
    public void setStartDate(StartDateType value) {
        this.startDate = value;
    }

    /**
     * Ruft den Wert der endDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EndDateType }
     *     
     */
    public EndDateType getEndDate() {
        return endDate;
    }

    /**
     * Legt den Wert der endDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EndDateType }
     *     
     */
    public void setEndDate(EndDateType value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the workOrderDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workOrderDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkOrderDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getWorkOrderDocumentReference() {
        if (workOrderDocumentReference == null) {
            workOrderDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.workOrderDocumentReference;
    }

}
