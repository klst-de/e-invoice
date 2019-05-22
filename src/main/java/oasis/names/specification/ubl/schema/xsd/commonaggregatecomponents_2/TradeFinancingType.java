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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FinancingInstrumentCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;


/**
 * <p>Java-Klasse für TradeFinancingType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeFinancingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FinancingInstrumentCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinancingParty"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinancingFinancialAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Clause" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeFinancingType", propOrder = {
    "id",
    "financingInstrumentCode",
    "contractDocumentReference",
    "documentReference",
    "financingParty",
    "financingFinancialAccount",
    "clause"
})
public class TradeFinancingType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "FinancingInstrumentCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FinancingInstrumentCodeType financingInstrumentCode;
    @XmlElement(name = "ContractDocumentReference")
    protected DocumentReferenceType contractDocumentReference;
    @XmlElement(name = "DocumentReference")
    protected List<DocumentReferenceType> documentReference;
    @XmlElement(name = "FinancingParty", required = true)
    protected PartyType financingParty;
    @XmlElement(name = "FinancingFinancialAccount")
    protected FinancialAccountType financingFinancialAccount;
    @XmlElement(name = "Clause")
    protected List<ClauseType> clause;

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
     * Ruft den Wert der financingInstrumentCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancingInstrumentCodeType }
     *     
     */
    public FinancingInstrumentCodeType getFinancingInstrumentCode() {
        return financingInstrumentCode;
    }

    /**
     * Legt den Wert der financingInstrumentCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancingInstrumentCodeType }
     *     
     */
    public void setFinancingInstrumentCode(FinancingInstrumentCodeType value) {
        this.financingInstrumentCode = value;
    }

    /**
     * Ruft den Wert der contractDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getContractDocumentReference() {
        return contractDocumentReference;
    }

    /**
     * Legt den Wert der contractDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setContractDocumentReference(DocumentReferenceType value) {
        this.contractDocumentReference = value;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.documentReference;
    }

    /**
     * Ruft den Wert der financingParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getFinancingParty() {
        return financingParty;
    }

    /**
     * Legt den Wert der financingParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setFinancingParty(PartyType value) {
        this.financingParty = value;
    }

    /**
     * Ruft den Wert der financingFinancialAccount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancialAccountType }
     *     
     */
    public FinancialAccountType getFinancingFinancialAccount() {
        return financingFinancialAccount;
    }

    /**
     * Legt den Wert der financingFinancialAccount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAccountType }
     *     
     */
    public void setFinancingFinancialAccount(FinancialAccountType value) {
        this.financingFinancialAccount = value;
    }

    /**
     * Gets the value of the clause property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clause property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClause().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseType }
     * 
     * 
     */
    public List<ClauseType> getClause() {
        if (clause == null) {
            clause = new ArrayList<ClauseType>();
        }
        return this.clause;
    }

}
