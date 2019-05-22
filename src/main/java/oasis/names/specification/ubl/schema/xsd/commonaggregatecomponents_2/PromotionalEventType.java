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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FirstShipmentAvailibilityDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestProposalAcceptanceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PromotionalEventTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubmissionDateType;


/**
 * <p>Java-Klasse für PromotionalEventType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PromotionalEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PromotionalEventTypeCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubmissionDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FirstShipmentAvailibilityDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestProposalAcceptanceDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PromotionalSpecification" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromotionalEventType", propOrder = {
    "promotionalEventTypeCode",
    "submissionDate",
    "firstShipmentAvailibilityDate",
    "latestProposalAcceptanceDate",
    "promotionalSpecification"
})
public class PromotionalEventType {

    @XmlElement(name = "PromotionalEventTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PromotionalEventTypeCodeType promotionalEventTypeCode;
    @XmlElement(name = "SubmissionDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubmissionDateType submissionDate;
    @XmlElement(name = "FirstShipmentAvailibilityDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FirstShipmentAvailibilityDateType firstShipmentAvailibilityDate;
    @XmlElement(name = "LatestProposalAcceptanceDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestProposalAcceptanceDateType latestProposalAcceptanceDate;
    @XmlElement(name = "PromotionalSpecification", required = true)
    protected List<PromotionalSpecificationType> promotionalSpecification;

    /**
     * Ruft den Wert der promotionalEventTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PromotionalEventTypeCodeType }
     *     
     */
    public PromotionalEventTypeCodeType getPromotionalEventTypeCode() {
        return promotionalEventTypeCode;
    }

    /**
     * Legt den Wert der promotionalEventTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PromotionalEventTypeCodeType }
     *     
     */
    public void setPromotionalEventTypeCode(PromotionalEventTypeCodeType value) {
        this.promotionalEventTypeCode = value;
    }

    /**
     * Ruft den Wert der submissionDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubmissionDateType }
     *     
     */
    public SubmissionDateType getSubmissionDate() {
        return submissionDate;
    }

    /**
     * Legt den Wert der submissionDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmissionDateType }
     *     
     */
    public void setSubmissionDate(SubmissionDateType value) {
        this.submissionDate = value;
    }

    /**
     * Ruft den Wert der firstShipmentAvailibilityDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FirstShipmentAvailibilityDateType }
     *     
     */
    public FirstShipmentAvailibilityDateType getFirstShipmentAvailibilityDate() {
        return firstShipmentAvailibilityDate;
    }

    /**
     * Legt den Wert der firstShipmentAvailibilityDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FirstShipmentAvailibilityDateType }
     *     
     */
    public void setFirstShipmentAvailibilityDate(FirstShipmentAvailibilityDateType value) {
        this.firstShipmentAvailibilityDate = value;
    }

    /**
     * Ruft den Wert der latestProposalAcceptanceDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LatestProposalAcceptanceDateType }
     *     
     */
    public LatestProposalAcceptanceDateType getLatestProposalAcceptanceDate() {
        return latestProposalAcceptanceDate;
    }

    /**
     * Legt den Wert der latestProposalAcceptanceDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestProposalAcceptanceDateType }
     *     
     */
    public void setLatestProposalAcceptanceDate(LatestProposalAcceptanceDateType value) {
        this.latestProposalAcceptanceDate = value;
    }

    /**
     * Gets the value of the promotionalSpecification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionalSpecification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionalSpecification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionalSpecificationType }
     * 
     * 
     */
    public List<PromotionalSpecificationType> getPromotionalSpecification() {
        if (promotionalSpecification == null) {
            promotionalSpecification = new ArrayList<PromotionalSpecificationType>();
        }
        return this.promotionalSpecification;
    }

}
