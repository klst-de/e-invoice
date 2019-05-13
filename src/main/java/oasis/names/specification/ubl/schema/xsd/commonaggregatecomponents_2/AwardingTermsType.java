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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BindingOnBuyerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FollowupContractIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LowTendersDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrizeDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrizeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TechnicalCommitteeDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeightingAlgorithmCodeType;


/**
 * <p>Java-Klasse für AwardingTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AwardingTermsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeightingAlgorithmCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TechnicalCommitteeDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LowTendersDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrizeIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrizeDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FollowupContractIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BindingOnBuyerIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AwardingCriterion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TechnicalCommitteePerson" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AwardingTermsType", propOrder = {
    "weightingAlgorithmCode",
    "description",
    "technicalCommitteeDescription",
    "lowTendersDescription",
    "prizeIndicator",
    "prizeDescription",
    "paymentDescription",
    "followupContractIndicator",
    "bindingOnBuyerIndicator",
    "awardingCriterion",
    "technicalCommitteePerson"
})
public class AwardingTermsType {

    @XmlElement(name = "WeightingAlgorithmCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WeightingAlgorithmCodeType weightingAlgorithmCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "TechnicalCommitteeDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TechnicalCommitteeDescriptionType> technicalCommitteeDescription;
    @XmlElement(name = "LowTendersDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<LowTendersDescriptionType> lowTendersDescription;
    @XmlElement(name = "PrizeIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrizeIndicatorType prizeIndicator;
    @XmlElement(name = "PrizeDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PrizeDescriptionType> prizeDescription;
    @XmlElement(name = "PaymentDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PaymentDescriptionType> paymentDescription;
    @XmlElement(name = "FollowupContractIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FollowupContractIndicatorType followupContractIndicator;
    @XmlElement(name = "BindingOnBuyerIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BindingOnBuyerIndicatorType bindingOnBuyerIndicator;
    @XmlElement(name = "AwardingCriterion")
    protected List<AwardingCriterionType> awardingCriterion;
    @XmlElement(name = "TechnicalCommitteePerson")
    protected List<PersonType> technicalCommitteePerson;

    /**
     * Ruft den Wert der weightingAlgorithmCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WeightingAlgorithmCodeType }
     *     
     */
    public WeightingAlgorithmCodeType getWeightingAlgorithmCode() {
        return weightingAlgorithmCode;
    }

    /**
     * Legt den Wert der weightingAlgorithmCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightingAlgorithmCodeType }
     *     
     */
    public void setWeightingAlgorithmCode(WeightingAlgorithmCodeType value) {
        this.weightingAlgorithmCode = value;
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
     * Gets the value of the technicalCommitteeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technicalCommitteeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnicalCommitteeDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TechnicalCommitteeDescriptionType }
     * 
     * 
     */
    public List<TechnicalCommitteeDescriptionType> getTechnicalCommitteeDescription() {
        if (technicalCommitteeDescription == null) {
            technicalCommitteeDescription = new ArrayList<TechnicalCommitteeDescriptionType>();
        }
        return this.technicalCommitteeDescription;
    }

    /**
     * Gets the value of the lowTendersDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lowTendersDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLowTendersDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LowTendersDescriptionType }
     * 
     * 
     */
    public List<LowTendersDescriptionType> getLowTendersDescription() {
        if (lowTendersDescription == null) {
            lowTendersDescription = new ArrayList<LowTendersDescriptionType>();
        }
        return this.lowTendersDescription;
    }

    /**
     * Ruft den Wert der prizeIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PrizeIndicatorType }
     *     
     */
    public PrizeIndicatorType getPrizeIndicator() {
        return prizeIndicator;
    }

    /**
     * Legt den Wert der prizeIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PrizeIndicatorType }
     *     
     */
    public void setPrizeIndicator(PrizeIndicatorType value) {
        this.prizeIndicator = value;
    }

    /**
     * Gets the value of the prizeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prizeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrizeDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrizeDescriptionType }
     * 
     * 
     */
    public List<PrizeDescriptionType> getPrizeDescription() {
        if (prizeDescription == null) {
            prizeDescription = new ArrayList<PrizeDescriptionType>();
        }
        return this.prizeDescription;
    }

    /**
     * Gets the value of the paymentDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentDescriptionType }
     * 
     * 
     */
    public List<PaymentDescriptionType> getPaymentDescription() {
        if (paymentDescription == null) {
            paymentDescription = new ArrayList<PaymentDescriptionType>();
        }
        return this.paymentDescription;
    }

    /**
     * Ruft den Wert der followupContractIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FollowupContractIndicatorType }
     *     
     */
    public FollowupContractIndicatorType getFollowupContractIndicator() {
        return followupContractIndicator;
    }

    /**
     * Legt den Wert der followupContractIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FollowupContractIndicatorType }
     *     
     */
    public void setFollowupContractIndicator(FollowupContractIndicatorType value) {
        this.followupContractIndicator = value;
    }

    /**
     * Ruft den Wert der bindingOnBuyerIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BindingOnBuyerIndicatorType }
     *     
     */
    public BindingOnBuyerIndicatorType getBindingOnBuyerIndicator() {
        return bindingOnBuyerIndicator;
    }

    /**
     * Legt den Wert der bindingOnBuyerIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BindingOnBuyerIndicatorType }
     *     
     */
    public void setBindingOnBuyerIndicator(BindingOnBuyerIndicatorType value) {
        this.bindingOnBuyerIndicator = value;
    }

    /**
     * Gets the value of the awardingCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awardingCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAwardingCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AwardingCriterionType }
     * 
     * 
     */
    public List<AwardingCriterionType> getAwardingCriterion() {
        if (awardingCriterion == null) {
            awardingCriterion = new ArrayList<AwardingCriterionType>();
        }
        return this.awardingCriterion;
    }

    /**
     * Gets the value of the technicalCommitteePerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technicalCommitteePerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnicalCommitteePerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getTechnicalCommitteePerson() {
        if (technicalCommitteePerson == null) {
            technicalCommitteePerson = new ArrayList<PersonType>();
        }
        return this.technicalCommitteePerson;
    }

}
