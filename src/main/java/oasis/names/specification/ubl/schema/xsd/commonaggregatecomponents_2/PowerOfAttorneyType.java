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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueTimeType;


/**
 * <p>Java-Klasse für PowerOfAttorneyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PowerOfAttorneyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IssueDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IssueTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}NotaryParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AgentParty"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WitnessParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MandateDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerOfAttorneyType", propOrder = {
    "id",
    "issueDate",
    "issueTime",
    "description",
    "notaryParty",
    "agentParty",
    "witnessParty",
    "mandateDocumentReference"
})
public class PowerOfAttorneyType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "IssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IssueDateType issueDate;
    @XmlElement(name = "IssueTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IssueTimeType issueTime;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "NotaryParty")
    protected PartyType notaryParty;
    @XmlElement(name = "AgentParty", required = true)
    protected PartyType agentParty;
    @XmlElement(name = "WitnessParty")
    protected List<PartyType> witnessParty;
    @XmlElement(name = "MandateDocumentReference")
    protected List<DocumentReferenceType> mandateDocumentReference;

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
     * Ruft den Wert der issueDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IssueDateType }
     *     
     */
    public IssueDateType getIssueDate() {
        return issueDate;
    }

    /**
     * Legt den Wert der issueDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueDateType }
     *     
     */
    public void setIssueDate(IssueDateType value) {
        this.issueDate = value;
    }

    /**
     * Ruft den Wert der issueTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IssueTimeType }
     *     
     */
    public IssueTimeType getIssueTime() {
        return issueTime;
    }

    /**
     * Legt den Wert der issueTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueTimeType }
     *     
     */
    public void setIssueTime(IssueTimeType value) {
        this.issueTime = value;
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
     * Ruft den Wert der notaryParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getNotaryParty() {
        return notaryParty;
    }

    /**
     * Legt den Wert der notaryParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setNotaryParty(PartyType value) {
        this.notaryParty = value;
    }

    /**
     * Ruft den Wert der agentParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getAgentParty() {
        return agentParty;
    }

    /**
     * Legt den Wert der agentParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setAgentParty(PartyType value) {
        this.agentParty = value;
    }

    /**
     * Gets the value of the witnessParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the witnessParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWitnessParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getWitnessParty() {
        if (witnessParty == null) {
            witnessParty = new ArrayList<PartyType>();
        }
        return this.witnessParty;
    }

    /**
     * Gets the value of the mandateDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mandateDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMandateDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getMandateDocumentReference() {
        if (mandateDocumentReference == null) {
            mandateDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.mandateDocumentReference;
    }

}
