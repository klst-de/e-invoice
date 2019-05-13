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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpectedOperatorQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FrequencyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.JustificationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumOperatorQuantityType;


/**
 * <p>Java-Klasse für FrameworkAgreementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FrameworkAgreementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExpectedOperatorQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumOperatorQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Justification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Frequency" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DurationPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SubsequentProcessTenderRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FrameworkAgreementType", propOrder = {
    "expectedOperatorQuantity",
    "maximumOperatorQuantity",
    "justification",
    "frequency",
    "durationPeriod",
    "subsequentProcessTenderRequirement"
})
public class FrameworkAgreementType {

    @XmlElement(name = "ExpectedOperatorQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExpectedOperatorQuantityType expectedOperatorQuantity;
    @XmlElement(name = "MaximumOperatorQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumOperatorQuantityType maximumOperatorQuantity;
    @XmlElement(name = "Justification", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<JustificationType> justification;
    @XmlElement(name = "Frequency", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<FrequencyType> frequency;
    @XmlElement(name = "DurationPeriod")
    protected PeriodType durationPeriod;
    @XmlElement(name = "SubsequentProcessTenderRequirement")
    protected List<TenderRequirementType> subsequentProcessTenderRequirement;

    /**
     * Ruft den Wert der expectedOperatorQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpectedOperatorQuantityType }
     *     
     */
    public ExpectedOperatorQuantityType getExpectedOperatorQuantity() {
        return expectedOperatorQuantity;
    }

    /**
     * Legt den Wert der expectedOperatorQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpectedOperatorQuantityType }
     *     
     */
    public void setExpectedOperatorQuantity(ExpectedOperatorQuantityType value) {
        this.expectedOperatorQuantity = value;
    }

    /**
     * Ruft den Wert der maximumOperatorQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumOperatorQuantityType }
     *     
     */
    public MaximumOperatorQuantityType getMaximumOperatorQuantity() {
        return maximumOperatorQuantity;
    }

    /**
     * Legt den Wert der maximumOperatorQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumOperatorQuantityType }
     *     
     */
    public void setMaximumOperatorQuantity(MaximumOperatorQuantityType value) {
        this.maximumOperatorQuantity = value;
    }

    /**
     * Gets the value of the justification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the justification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJustification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JustificationType }
     * 
     * 
     */
    public List<JustificationType> getJustification() {
        if (justification == null) {
            justification = new ArrayList<JustificationType>();
        }
        return this.justification;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the frequency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFrequency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FrequencyType }
     * 
     * 
     */
    public List<FrequencyType> getFrequency() {
        if (frequency == null) {
            frequency = new ArrayList<FrequencyType>();
        }
        return this.frequency;
    }

    /**
     * Ruft den Wert der durationPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getDurationPeriod() {
        return durationPeriod;
    }

    /**
     * Legt den Wert der durationPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setDurationPeriod(PeriodType value) {
        this.durationPeriod = value;
    }

    /**
     * Gets the value of the subsequentProcessTenderRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subsequentProcessTenderRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubsequentProcessTenderRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TenderRequirementType }
     * 
     * 
     */
    public List<TenderRequirementType> getSubsequentProcessTenderRequirement() {
        if (subsequentProcessTenderRequirement == null) {
            subsequentProcessTenderRequirement = new ArrayList<TenderRequirementType>();
        }
        return this.subsequentProcessTenderRequirement;
    }

}
