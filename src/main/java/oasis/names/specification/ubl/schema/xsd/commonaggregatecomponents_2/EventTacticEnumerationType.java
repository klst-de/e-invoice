//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumerIncentiveTacticTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DisplayTacticTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FeatureTacticTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TradeItemPackingLabelingTypeCodeType;


/**
 * <p>Java-Klasse für EventTacticEnumerationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EventTacticEnumerationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumerIncentiveTacticTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DisplayTacticTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FeatureTacticTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TradeItemPackingLabelingTypeCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventTacticEnumerationType", propOrder = {
    "consumerIncentiveTacticTypeCode",
    "displayTacticTypeCode",
    "featureTacticTypeCode",
    "tradeItemPackingLabelingTypeCode"
})
public class EventTacticEnumerationType {

    @XmlElement(name = "ConsumerIncentiveTacticTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumerIncentiveTacticTypeCodeType consumerIncentiveTacticTypeCode;
    @XmlElement(name = "DisplayTacticTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DisplayTacticTypeCodeType displayTacticTypeCode;
    @XmlElement(name = "FeatureTacticTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FeatureTacticTypeCodeType featureTacticTypeCode;
    @XmlElement(name = "TradeItemPackingLabelingTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TradeItemPackingLabelingTypeCodeType tradeItemPackingLabelingTypeCode;

    /**
     * Ruft den Wert der consumerIncentiveTacticTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumerIncentiveTacticTypeCodeType }
     *     
     */
    public ConsumerIncentiveTacticTypeCodeType getConsumerIncentiveTacticTypeCode() {
        return consumerIncentiveTacticTypeCode;
    }

    /**
     * Legt den Wert der consumerIncentiveTacticTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerIncentiveTacticTypeCodeType }
     *     
     */
    public void setConsumerIncentiveTacticTypeCode(ConsumerIncentiveTacticTypeCodeType value) {
        this.consumerIncentiveTacticTypeCode = value;
    }

    /**
     * Ruft den Wert der displayTacticTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DisplayTacticTypeCodeType }
     *     
     */
    public DisplayTacticTypeCodeType getDisplayTacticTypeCode() {
        return displayTacticTypeCode;
    }

    /**
     * Legt den Wert der displayTacticTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayTacticTypeCodeType }
     *     
     */
    public void setDisplayTacticTypeCode(DisplayTacticTypeCodeType value) {
        this.displayTacticTypeCode = value;
    }

    /**
     * Ruft den Wert der featureTacticTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FeatureTacticTypeCodeType }
     *     
     */
    public FeatureTacticTypeCodeType getFeatureTacticTypeCode() {
        return featureTacticTypeCode;
    }

    /**
     * Legt den Wert der featureTacticTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureTacticTypeCodeType }
     *     
     */
    public void setFeatureTacticTypeCode(FeatureTacticTypeCodeType value) {
        this.featureTacticTypeCode = value;
    }

    /**
     * Ruft den Wert der tradeItemPackingLabelingTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeItemPackingLabelingTypeCodeType }
     *     
     */
    public TradeItemPackingLabelingTypeCodeType getTradeItemPackingLabelingTypeCode() {
        return tradeItemPackingLabelingTypeCode;
    }

    /**
     * Legt den Wert der tradeItemPackingLabelingTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeItemPackingLabelingTypeCodeType }
     *     
     */
    public void setTradeItemPackingLabelingTypeCode(TradeItemPackingLabelingTypeCodeType value) {
        this.tradeItemPackingLabelingTypeCode = value;
    }

}
