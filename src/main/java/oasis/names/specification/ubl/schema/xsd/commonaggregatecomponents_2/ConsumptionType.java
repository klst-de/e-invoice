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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UtilityStatementTypeCodeType;


/**
 * <p>Java-Klasse für ConsumptionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UtilityStatementTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MainPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnergyWaterSupply" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TelecommunicationsSupply" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LegalMonetaryTotal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionType", propOrder = {
    "utilityStatementTypeCode",
    "mainPeriod",
    "allowanceCharge",
    "taxTotal",
    "energyWaterSupply",
    "telecommunicationsSupply",
    "legalMonetaryTotal"
})
public class ConsumptionType {

    @XmlElement(name = "UtilityStatementTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UtilityStatementTypeCodeType utilityStatementTypeCode;
    @XmlElement(name = "MainPeriod")
    protected PeriodType mainPeriod;
    @XmlElement(name = "AllowanceCharge")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "TaxTotal")
    protected List<TaxTotalType> taxTotal;
    @XmlElement(name = "EnergyWaterSupply")
    protected EnergyWaterSupplyType energyWaterSupply;
    @XmlElement(name = "TelecommunicationsSupply")
    protected TelecommunicationsSupplyType telecommunicationsSupply;
    @XmlElement(name = "LegalMonetaryTotal", required = true)
    protected MonetaryTotalType legalMonetaryTotal;

    /**
     * Ruft den Wert der utilityStatementTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UtilityStatementTypeCodeType }
     *     
     */
    public UtilityStatementTypeCodeType getUtilityStatementTypeCode() {
        return utilityStatementTypeCode;
    }

    /**
     * Legt den Wert der utilityStatementTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilityStatementTypeCodeType }
     *     
     */
    public void setUtilityStatementTypeCode(UtilityStatementTypeCodeType value) {
        this.utilityStatementTypeCode = value;
    }

    /**
     * Ruft den Wert der mainPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getMainPeriod() {
        return mainPeriod;
    }

    /**
     * Legt den Wert der mainPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setMainPeriod(PeriodType value) {
        this.mainPeriod = value;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    /**
     * Gets the value of the taxTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxTotalType }
     * 
     * 
     */
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    /**
     * Ruft den Wert der energyWaterSupply-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EnergyWaterSupplyType }
     *     
     */
    public EnergyWaterSupplyType getEnergyWaterSupply() {
        return energyWaterSupply;
    }

    /**
     * Legt den Wert der energyWaterSupply-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EnergyWaterSupplyType }
     *     
     */
    public void setEnergyWaterSupply(EnergyWaterSupplyType value) {
        this.energyWaterSupply = value;
    }

    /**
     * Ruft den Wert der telecommunicationsSupply-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsSupplyType }
     *     
     */
    public TelecommunicationsSupplyType getTelecommunicationsSupply() {
        return telecommunicationsSupply;
    }

    /**
     * Legt den Wert der telecommunicationsSupply-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsSupplyType }
     *     
     */
    public void setTelecommunicationsSupply(TelecommunicationsSupplyType value) {
        this.telecommunicationsSupply = value;
    }

    /**
     * Ruft den Wert der legalMonetaryTotal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MonetaryTotalType }
     *     
     */
    public MonetaryTotalType getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    /**
     * Legt den Wert der legalMonetaryTotal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryTotalType }
     *     
     */
    public void setLegalMonetaryTotal(MonetaryTotalType value) {
        this.legalMonetaryTotal = value;
    }

}
