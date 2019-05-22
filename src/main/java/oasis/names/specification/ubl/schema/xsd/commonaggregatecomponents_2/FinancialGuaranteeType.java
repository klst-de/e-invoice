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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GuaranteeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LiabilityAmountType;


/**
 * <p>Java-Klasse für FinancialGuaranteeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FinancialGuaranteeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GuaranteeTypeCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LiabilityAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AmountRate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConstitutionPeriod" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialGuaranteeType", propOrder = {
    "guaranteeTypeCode",
    "description",
    "liabilityAmount",
    "amountRate",
    "constitutionPeriod"
})
public class FinancialGuaranteeType {

    @XmlElement(name = "GuaranteeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected GuaranteeTypeCodeType guaranteeTypeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "LiabilityAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LiabilityAmountType liabilityAmount;
    @XmlElement(name = "AmountRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AmountRateType amountRate;
    @XmlElement(name = "ConstitutionPeriod")
    protected PeriodType constitutionPeriod;

    /**
     * Ruft den Wert der guaranteeTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GuaranteeTypeCodeType }
     *     
     */
    public GuaranteeTypeCodeType getGuaranteeTypeCode() {
        return guaranteeTypeCode;
    }

    /**
     * Legt den Wert der guaranteeTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GuaranteeTypeCodeType }
     *     
     */
    public void setGuaranteeTypeCode(GuaranteeTypeCodeType value) {
        this.guaranteeTypeCode = value;
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
     * Ruft den Wert der liabilityAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LiabilityAmountType }
     *     
     */
    public LiabilityAmountType getLiabilityAmount() {
        return liabilityAmount;
    }

    /**
     * Legt den Wert der liabilityAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LiabilityAmountType }
     *     
     */
    public void setLiabilityAmount(LiabilityAmountType value) {
        this.liabilityAmount = value;
    }

    /**
     * Ruft den Wert der amountRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountRateType }
     *     
     */
    public AmountRateType getAmountRate() {
        return amountRate;
    }

    /**
     * Legt den Wert der amountRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountRateType }
     *     
     */
    public void setAmountRate(AmountRateType value) {
        this.amountRate = value;
    }

    /**
     * Ruft den Wert der constitutionPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getConstitutionPeriod() {
        return constitutionPeriod;
    }

    /**
     * Legt den Wert der constitutionPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setConstitutionPeriod(PeriodType value) {
        this.constitutionPeriod = value;
    }

}
