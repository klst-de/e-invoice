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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnnualAverageAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PartyCapacityAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalTaskAmountType;


/**
 * <p>Java-Klasse für CompletedTaskType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CompletedTaskType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AnnualAverageAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalTaskAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PartyCapacityAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EvidenceSupplied" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Period" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RecipientCustomerParty" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedTaskType", propOrder = {
    "annualAverageAmount",
    "totalTaskAmount",
    "partyCapacityAmount",
    "description",
    "evidenceSupplied",
    "period",
    "recipientCustomerParty"
})
public class CompletedTaskType {

    @XmlElement(name = "AnnualAverageAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AnnualAverageAmountType annualAverageAmount;
    @XmlElement(name = "TotalTaskAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalTaskAmountType totalTaskAmount;
    @XmlElement(name = "PartyCapacityAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PartyCapacityAmountType partyCapacityAmount;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "EvidenceSupplied")
    protected List<EvidenceSuppliedType> evidenceSupplied;
    @XmlElement(name = "Period")
    protected PeriodType period;
    @XmlElement(name = "RecipientCustomerParty")
    protected CustomerPartyType recipientCustomerParty;

    /**
     * Ruft den Wert der annualAverageAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AnnualAverageAmountType }
     *     
     */
    public AnnualAverageAmountType getAnnualAverageAmount() {
        return annualAverageAmount;
    }

    /**
     * Legt den Wert der annualAverageAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnualAverageAmountType }
     *     
     */
    public void setAnnualAverageAmount(AnnualAverageAmountType value) {
        this.annualAverageAmount = value;
    }

    /**
     * Ruft den Wert der totalTaskAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalTaskAmountType }
     *     
     */
    public TotalTaskAmountType getTotalTaskAmount() {
        return totalTaskAmount;
    }

    /**
     * Legt den Wert der totalTaskAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalTaskAmountType }
     *     
     */
    public void setTotalTaskAmount(TotalTaskAmountType value) {
        this.totalTaskAmount = value;
    }

    /**
     * Ruft den Wert der partyCapacityAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyCapacityAmountType }
     *     
     */
    public PartyCapacityAmountType getPartyCapacityAmount() {
        return partyCapacityAmount;
    }

    /**
     * Legt den Wert der partyCapacityAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyCapacityAmountType }
     *     
     */
    public void setPartyCapacityAmount(PartyCapacityAmountType value) {
        this.partyCapacityAmount = value;
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
     * Gets the value of the evidenceSupplied property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evidenceSupplied property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvidenceSupplied().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvidenceSuppliedType }
     * 
     * 
     */
    public List<EvidenceSuppliedType> getEvidenceSupplied() {
        if (evidenceSupplied == null) {
            evidenceSupplied = new ArrayList<EvidenceSuppliedType>();
        }
        return this.evidenceSupplied;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPeriod(PeriodType value) {
        this.period = value;
    }

    /**
     * Ruft den Wert der recipientCustomerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CustomerPartyType }
     *     
     */
    public CustomerPartyType getRecipientCustomerParty() {
        return recipientCustomerParty;
    }

    /**
     * Legt den Wert der recipientCustomerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPartyType }
     *     
     */
    public void setRecipientCustomerParty(CustomerPartyType value) {
        this.recipientCustomerParty = value;
    }

}
