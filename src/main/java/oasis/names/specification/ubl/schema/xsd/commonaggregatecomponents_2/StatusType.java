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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConditionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IndicationIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReliabilityPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StatusReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StatusReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TextType;


/**
 * <p>Java-Klasse für StatusType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConditionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferenceDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferenceTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}StatusReasonCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}StatusReason" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Text" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IndicationIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Percent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReliabilityPercent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Condition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusType", propOrder = {
    "conditionCode",
    "referenceDate",
    "referenceTime",
    "description",
    "statusReasonCode",
    "statusReason",
    "sequenceID",
    "text",
    "indicationIndicator",
    "percent",
    "reliabilityPercent",
    "condition"
})
public class StatusType {

    @XmlElement(name = "ConditionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConditionCodeType conditionCode;
    @XmlElement(name = "ReferenceDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReferenceDateType referenceDate;
    @XmlElement(name = "ReferenceTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReferenceTimeType referenceTime;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "StatusReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected StatusReasonCodeType statusReasonCode;
    @XmlElement(name = "StatusReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<StatusReasonType> statusReason;
    @XmlElement(name = "SequenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SequenceIDType sequenceID;
    @XmlElement(name = "Text", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TextType> text;
    @XmlElement(name = "IndicationIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IndicationIndicatorType indicationIndicator;
    @XmlElement(name = "Percent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PercentType percent;
    @XmlElement(name = "ReliabilityPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReliabilityPercentType reliabilityPercent;
    @XmlElement(name = "Condition")
    protected List<ConditionType> condition;

    /**
     * Ruft den Wert der conditionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConditionCodeType }
     *     
     */
    public ConditionCodeType getConditionCode() {
        return conditionCode;
    }

    /**
     * Legt den Wert der conditionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionCodeType }
     *     
     */
    public void setConditionCode(ConditionCodeType value) {
        this.conditionCode = value;
    }

    /**
     * Ruft den Wert der referenceDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDateType }
     *     
     */
    public ReferenceDateType getReferenceDate() {
        return referenceDate;
    }

    /**
     * Legt den Wert der referenceDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDateType }
     *     
     */
    public void setReferenceDate(ReferenceDateType value) {
        this.referenceDate = value;
    }

    /**
     * Ruft den Wert der referenceTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceTimeType }
     *     
     */
    public ReferenceTimeType getReferenceTime() {
        return referenceTime;
    }

    /**
     * Legt den Wert der referenceTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceTimeType }
     *     
     */
    public void setReferenceTime(ReferenceTimeType value) {
        this.referenceTime = value;
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
     * Ruft den Wert der statusReasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StatusReasonCodeType }
     *     
     */
    public StatusReasonCodeType getStatusReasonCode() {
        return statusReasonCode;
    }

    /**
     * Legt den Wert der statusReasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusReasonCodeType }
     *     
     */
    public void setStatusReasonCode(StatusReasonCodeType value) {
        this.statusReasonCode = value;
    }

    /**
     * Gets the value of the statusReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusReasonType }
     * 
     * 
     */
    public List<StatusReasonType> getStatusReason() {
        if (statusReason == null) {
            statusReason = new ArrayList<StatusReasonType>();
        }
        return this.statusReason;
    }

    /**
     * Ruft den Wert der sequenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SequenceIDType }
     *     
     */
    public SequenceIDType getSequenceID() {
        return sequenceID;
    }

    /**
     * Legt den Wert der sequenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceIDType }
     *     
     */
    public void setSequenceID(SequenceIDType value) {
        this.sequenceID = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the text property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getText() {
        if (text == null) {
            text = new ArrayList<TextType>();
        }
        return this.text;
    }

    /**
     * Ruft den Wert der indicationIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicationIndicatorType }
     *     
     */
    public IndicationIndicatorType getIndicationIndicator() {
        return indicationIndicator;
    }

    /**
     * Legt den Wert der indicationIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicationIndicatorType }
     *     
     */
    public void setIndicationIndicator(IndicationIndicatorType value) {
        this.indicationIndicator = value;
    }

    /**
     * Ruft den Wert der percent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PercentType }
     *     
     */
    public PercentType getPercent() {
        return percent;
    }

    /**
     * Legt den Wert der percent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PercentType }
     *     
     */
    public void setPercent(PercentType value) {
        this.percent = value;
    }

    /**
     * Ruft den Wert der reliabilityPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReliabilityPercentType }
     *     
     */
    public ReliabilityPercentType getReliabilityPercent() {
        return reliabilityPercent;
    }

    /**
     * Legt den Wert der reliabilityPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReliabilityPercentType }
     *     
     */
    public void setReliabilityPercent(ReliabilityPercentType value) {
        this.reliabilityPercent = value;
    }

    /**
     * Gets the value of the condition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the condition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionType }
     * 
     * 
     */
    public List<ConditionType> getCondition() {
        if (condition == null) {
            condition = new ArrayList<ConditionType>();
        }
        return this.condition;
    }

}
