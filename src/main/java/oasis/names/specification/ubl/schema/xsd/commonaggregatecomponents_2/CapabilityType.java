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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CapabilityTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueQuantityType;


/**
 * <p>Java-Klasse für CapabilityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CapabilityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CapabilityTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EvidenceSupplied" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapabilityType", propOrder = {
    "capabilityTypeCode",
    "description",
    "valueAmount",
    "valueQuantity",
    "evidenceSupplied",
    "validityPeriod"
})
public class CapabilityType {

    @XmlElement(name = "CapabilityTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CapabilityTypeCodeType capabilityTypeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "ValueAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValueAmountType valueAmount;
    @XmlElement(name = "ValueQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValueQuantityType valueQuantity;
    @XmlElement(name = "EvidenceSupplied")
    protected List<EvidenceSuppliedType> evidenceSupplied;
    @XmlElement(name = "ValidityPeriod")
    protected PeriodType validityPeriod;

    /**
     * Ruft den Wert der capabilityTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CapabilityTypeCodeType }
     *     
     */
    public CapabilityTypeCodeType getCapabilityTypeCode() {
        return capabilityTypeCode;
    }

    /**
     * Legt den Wert der capabilityTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilityTypeCodeType }
     *     
     */
    public void setCapabilityTypeCode(CapabilityTypeCodeType value) {
        this.capabilityTypeCode = value;
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
     * Ruft den Wert der valueAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValueAmountType }
     *     
     */
    public ValueAmountType getValueAmount() {
        return valueAmount;
    }

    /**
     * Legt den Wert der valueAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueAmountType }
     *     
     */
    public void setValueAmount(ValueAmountType value) {
        this.valueAmount = value;
    }

    /**
     * Ruft den Wert der valueQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValueQuantityType }
     *     
     */
    public ValueQuantityType getValueQuantity() {
        return valueQuantity;
    }

    /**
     * Legt den Wert der valueQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueQuantityType }
     *     
     */
    public void setValueQuantity(ValueQuantityType value) {
        this.valueQuantity = value;
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
     * Ruft den Wert der validityPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Legt den Wert der validityPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setValidityPeriod(PeriodType value) {
        this.validityPeriod = value;
    }

}
