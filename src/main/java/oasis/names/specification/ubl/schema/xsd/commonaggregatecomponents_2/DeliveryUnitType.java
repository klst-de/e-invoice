//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BatchQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumerUnitQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousRiskIndicatorType;


/**
 * <p>Java-Klasse f�r DeliveryUnitType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DeliveryUnitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BatchQuantity"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumerUnitQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousRiskIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryUnitType", propOrder = {
    "batchQuantity",
    "consumerUnitQuantity",
    "hazardousRiskIndicator"
})
public class DeliveryUnitType {

    @XmlElement(name = "BatchQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected BatchQuantityType batchQuantity;
    @XmlElement(name = "ConsumerUnitQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumerUnitQuantityType consumerUnitQuantity;
    @XmlElement(name = "HazardousRiskIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousRiskIndicatorType hazardousRiskIndicator;

    /**
     * Ruft den Wert der batchQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BatchQuantityType }
     *     
     */
    public BatchQuantityType getBatchQuantity() {
        return batchQuantity;
    }

    /**
     * Legt den Wert der batchQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchQuantityType }
     *     
     */
    public void setBatchQuantity(BatchQuantityType value) {
        this.batchQuantity = value;
    }

    /**
     * Ruft den Wert der consumerUnitQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumerUnitQuantityType }
     *     
     */
    public ConsumerUnitQuantityType getConsumerUnitQuantity() {
        return consumerUnitQuantity;
    }

    /**
     * Legt den Wert der consumerUnitQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerUnitQuantityType }
     *     
     */
    public void setConsumerUnitQuantity(ConsumerUnitQuantityType value) {
        this.consumerUnitQuantity = value;
    }

    /**
     * Ruft den Wert der hazardousRiskIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public HazardousRiskIndicatorType getHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    /**
     * Legt den Wert der hazardousRiskIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public void setHazardousRiskIndicator(HazardousRiskIndicatorType value) {
        this.hazardousRiskIndicator = value;
    }

}
