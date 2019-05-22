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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardingCriterionTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationExpressionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationExpressionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumImprovementBidType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeightNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeightType;


/**
 * <p>Java-Klasse für AwardingCriterionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AwardingCriterionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AwardingCriterionTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeightNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Weight" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CalculationExpression" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CalculationExpressionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumImprovementBid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SubordinateAwardingCriterion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AwardingCriterionType", propOrder = {
    "id",
    "awardingCriterionTypeCode",
    "description",
    "weightNumeric",
    "weight",
    "calculationExpression",
    "calculationExpressionCode",
    "minimumQuantity",
    "maximumQuantity",
    "minimumAmount",
    "maximumAmount",
    "minimumImprovementBid",
    "subordinateAwardingCriterion"
})
public class AwardingCriterionType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "AwardingCriterionTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AwardingCriterionTypeCodeType awardingCriterionTypeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "WeightNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WeightNumericType weightNumeric;
    @XmlElement(name = "Weight", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<WeightType> weight;
    @XmlElement(name = "CalculationExpression", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<CalculationExpressionType> calculationExpression;
    @XmlElement(name = "CalculationExpressionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CalculationExpressionCodeType calculationExpressionCode;
    @XmlElement(name = "MinimumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumQuantityType minimumQuantity;
    @XmlElement(name = "MaximumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumQuantityType maximumQuantity;
    @XmlElement(name = "MinimumAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumAmountType minimumAmount;
    @XmlElement(name = "MaximumAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumAmountType maximumAmount;
    @XmlElement(name = "MinimumImprovementBid", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<MinimumImprovementBidType> minimumImprovementBid;
    @XmlElement(name = "SubordinateAwardingCriterion")
    protected List<AwardingCriterionType> subordinateAwardingCriterion;

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
     * Ruft den Wert der awardingCriterionTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AwardingCriterionTypeCodeType }
     *     
     */
    public AwardingCriterionTypeCodeType getAwardingCriterionTypeCode() {
        return awardingCriterionTypeCode;
    }

    /**
     * Legt den Wert der awardingCriterionTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardingCriterionTypeCodeType }
     *     
     */
    public void setAwardingCriterionTypeCode(AwardingCriterionTypeCodeType value) {
        this.awardingCriterionTypeCode = value;
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
     * Ruft den Wert der weightNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeightNumericType }
     *     
     */
    public WeightNumericType getWeightNumeric() {
        return weightNumeric;
    }

    /**
     * Legt den Wert der weightNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightNumericType }
     *     
     */
    public void setWeightNumeric(WeightNumericType value) {
        this.weightNumeric = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weight property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WeightType }
     * 
     * 
     */
    public List<WeightType> getWeight() {
        if (weight == null) {
            weight = new ArrayList<WeightType>();
        }
        return this.weight;
    }

    /**
     * Gets the value of the calculationExpression property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calculationExpression property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalculationExpression().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalculationExpressionType }
     * 
     * 
     */
    public List<CalculationExpressionType> getCalculationExpression() {
        if (calculationExpression == null) {
            calculationExpression = new ArrayList<CalculationExpressionType>();
        }
        return this.calculationExpression;
    }

    /**
     * Ruft den Wert der calculationExpressionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CalculationExpressionCodeType }
     *     
     */
    public CalculationExpressionCodeType getCalculationExpressionCode() {
        return calculationExpressionCode;
    }

    /**
     * Legt den Wert der calculationExpressionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculationExpressionCodeType }
     *     
     */
    public void setCalculationExpressionCode(CalculationExpressionCodeType value) {
        this.calculationExpressionCode = value;
    }

    /**
     * Ruft den Wert der minimumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumQuantityType }
     *     
     */
    public MinimumQuantityType getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * Legt den Wert der minimumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumQuantityType }
     *     
     */
    public void setMinimumQuantity(MinimumQuantityType value) {
        this.minimumQuantity = value;
    }

    /**
     * Ruft den Wert der maximumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumQuantityType }
     *     
     */
    public MaximumQuantityType getMaximumQuantity() {
        return maximumQuantity;
    }

    /**
     * Legt den Wert der maximumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumQuantityType }
     *     
     */
    public void setMaximumQuantity(MaximumQuantityType value) {
        this.maximumQuantity = value;
    }

    /**
     * Ruft den Wert der minimumAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumAmountType }
     *     
     */
    public MinimumAmountType getMinimumAmount() {
        return minimumAmount;
    }

    /**
     * Legt den Wert der minimumAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumAmountType }
     *     
     */
    public void setMinimumAmount(MinimumAmountType value) {
        this.minimumAmount = value;
    }

    /**
     * Ruft den Wert der maximumAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumAmountType }
     *     
     */
    public MaximumAmountType getMaximumAmount() {
        return maximumAmount;
    }

    /**
     * Legt den Wert der maximumAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumAmountType }
     *     
     */
    public void setMaximumAmount(MaximumAmountType value) {
        this.maximumAmount = value;
    }

    /**
     * Gets the value of the minimumImprovementBid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the minimumImprovementBid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMinimumImprovementBid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MinimumImprovementBidType }
     * 
     * 
     */
    public List<MinimumImprovementBidType> getMinimumImprovementBid() {
        if (minimumImprovementBid == null) {
            minimumImprovementBid = new ArrayList<MinimumImprovementBidType>();
        }
        return this.minimumImprovementBid;
    }

    /**
     * Gets the value of the subordinateAwardingCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subordinateAwardingCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubordinateAwardingCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AwardingCriterionType }
     * 
     * 
     */
    public List<AwardingCriterionType> getSubordinateAwardingCriterion() {
        if (subordinateAwardingCriterion == null) {
            subordinateAwardingCriterion = new ArrayList<AwardingCriterionType>();
        }
        return this.subordinateAwardingCriterion;
    }

}
