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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionLevelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionLevelType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterNumberType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;


/**
 * <p>Java-Klasse für ConsumptionHistoryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionHistoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterNumber" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Amount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionLevelCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionLevel" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Period"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionHistoryType", propOrder = {
    "meterNumber",
    "quantity",
    "amount",
    "consumptionLevelCode",
    "consumptionLevel",
    "description",
    "period"
})
public class ConsumptionHistoryType {

    @XmlElement(name = "MeterNumber", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterNumberType meterNumber;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected QuantityType quantity;
    @XmlElement(name = "Amount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AmountType amount;
    @XmlElement(name = "ConsumptionLevelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionLevelCodeType consumptionLevelCode;
    @XmlElement(name = "ConsumptionLevel", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionLevelType consumptionLevel;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "Period", required = true)
    protected PeriodType period;

    /**
     * Ruft den Wert der meterNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeterNumberType }
     *     
     */
    public MeterNumberType getMeterNumber() {
        return meterNumber;
    }

    /**
     * Legt den Wert der meterNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterNumberType }
     *     
     */
    public void setMeterNumber(MeterNumberType value) {
        this.meterNumber = value;
    }

    /**
     * Ruft den Wert der quantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Legt den Wert der quantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * Ruft den Wert der amount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Legt den Wert der amount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * Ruft den Wert der consumptionLevelCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionLevelCodeType }
     *     
     */
    public ConsumptionLevelCodeType getConsumptionLevelCode() {
        return consumptionLevelCode;
    }

    /**
     * Legt den Wert der consumptionLevelCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionLevelCodeType }
     *     
     */
    public void setConsumptionLevelCode(ConsumptionLevelCodeType value) {
        this.consumptionLevelCode = value;
    }

    /**
     * Ruft den Wert der consumptionLevel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionLevelType }
     *     
     */
    public ConsumptionLevelType getConsumptionLevel() {
        return consumptionLevel;
    }

    /**
     * Legt den Wert der consumptionLevel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionLevelType }
     *     
     */
    public void setConsumptionLevel(ConsumptionLevelType value) {
        this.consumptionLevel = value;
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
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPeriod(PeriodType value) {
        this.period = value;
    }

}
