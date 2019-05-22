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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;


/**
 * <p>Java-Klasse für SupplierConsumptionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SupplierConsumptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UtilitySupplierParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UtilityCustomerParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Consumption"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Contract" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsumptionLine" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplierConsumptionType", propOrder = {
    "description",
    "utilitySupplierParty",
    "utilityCustomerParty",
    "consumption",
    "contract",
    "consumptionLine"
})
public class SupplierConsumptionType {

    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "UtilitySupplierParty")
    protected PartyType utilitySupplierParty;
    @XmlElement(name = "UtilityCustomerParty")
    protected PartyType utilityCustomerParty;
    @XmlElement(name = "Consumption", required = true)
    protected ConsumptionType consumption;
    @XmlElement(name = "Contract")
    protected ContractType contract;
    @XmlElement(name = "ConsumptionLine", required = true)
    protected List<ConsumptionLineType> consumptionLine;

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
     * Ruft den Wert der utilitySupplierParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getUtilitySupplierParty() {
        return utilitySupplierParty;
    }

    /**
     * Legt den Wert der utilitySupplierParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setUtilitySupplierParty(PartyType value) {
        this.utilitySupplierParty = value;
    }

    /**
     * Ruft den Wert der utilityCustomerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getUtilityCustomerParty() {
        return utilityCustomerParty;
    }

    /**
     * Legt den Wert der utilityCustomerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setUtilityCustomerParty(PartyType value) {
        this.utilityCustomerParty = value;
    }

    /**
     * Ruft den Wert der consumption-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionType }
     *     
     */
    public ConsumptionType getConsumption() {
        return consumption;
    }

    /**
     * Legt den Wert der consumption-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionType }
     *     
     */
    public void setConsumption(ConsumptionType value) {
        this.consumption = value;
    }

    /**
     * Ruft den Wert der contract-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getContract() {
        return contract;
    }

    /**
     * Legt den Wert der contract-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setContract(ContractType value) {
        this.contract = value;
    }

    /**
     * Gets the value of the consumptionLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionLineType }
     * 
     * 
     */
    public List<ConsumptionLineType> getConsumptionLine() {
        if (consumptionLine == null) {
            consumptionLine = new ArrayList<ConsumptionLineType>();
        }
        return this.consumptionLine;
    }

}
