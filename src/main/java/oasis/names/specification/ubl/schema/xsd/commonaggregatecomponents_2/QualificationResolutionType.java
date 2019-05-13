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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdmissionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExclusionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionType;


/**
 * <p>Java-Klasse für QualificationResolutionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="QualificationResolutionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdmissionCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExclusionReason" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Resolution" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResolutionDate"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResolutionTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProcurementProjectLot" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QualificationResolutionType", propOrder = {
    "admissionCode",
    "exclusionReason",
    "resolution",
    "resolutionDate",
    "resolutionTime",
    "procurementProjectLot"
})
public class QualificationResolutionType {

    @XmlElement(name = "AdmissionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected AdmissionCodeType admissionCode;
    @XmlElement(name = "ExclusionReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ExclusionReasonType> exclusionReason;
    @XmlElement(name = "Resolution", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ResolutionType> resolution;
    @XmlElement(name = "ResolutionDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ResolutionDateType resolutionDate;
    @XmlElement(name = "ResolutionTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ResolutionTimeType resolutionTime;
    @XmlElement(name = "ProcurementProjectLot")
    protected ProcurementProjectLotType procurementProjectLot;

    /**
     * Ruft den Wert der admissionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AdmissionCodeType }
     *     
     */
    public AdmissionCodeType getAdmissionCode() {
        return admissionCode;
    }

    /**
     * Legt den Wert der admissionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AdmissionCodeType }
     *     
     */
    public void setAdmissionCode(AdmissionCodeType value) {
        this.admissionCode = value;
    }

    /**
     * Gets the value of the exclusionReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exclusionReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExclusionReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExclusionReasonType }
     * 
     * 
     */
    public List<ExclusionReasonType> getExclusionReason() {
        if (exclusionReason == null) {
            exclusionReason = new ArrayList<ExclusionReasonType>();
        }
        return this.exclusionReason;
    }

    /**
     * Gets the value of the resolution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resolution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResolution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResolutionType }
     * 
     * 
     */
    public List<ResolutionType> getResolution() {
        if (resolution == null) {
            resolution = new ArrayList<ResolutionType>();
        }
        return this.resolution;
    }

    /**
     * Ruft den Wert der resolutionDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResolutionDateType }
     *     
     */
    public ResolutionDateType getResolutionDate() {
        return resolutionDate;
    }

    /**
     * Legt den Wert der resolutionDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolutionDateType }
     *     
     */
    public void setResolutionDate(ResolutionDateType value) {
        this.resolutionDate = value;
    }

    /**
     * Ruft den Wert der resolutionTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResolutionTimeType }
     *     
     */
    public ResolutionTimeType getResolutionTime() {
        return resolutionTime;
    }

    /**
     * Legt den Wert der resolutionTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolutionTimeType }
     *     
     */
    public void setResolutionTime(ResolutionTimeType value) {
        this.resolutionTime = value;
    }

    /**
     * Ruft den Wert der procurementProjectLot-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProcurementProjectLotType }
     *     
     */
    public ProcurementProjectLotType getProcurementProjectLot() {
        return procurementProjectLot;
    }

    /**
     * Legt den Wert der procurementProjectLot-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementProjectLotType }
     *     
     */
    public void setProcurementProjectLot(ProcurementProjectLotType value) {
        this.procurementProjectLot = value;
    }

}
