//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.AdjustmentReasonCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für DeliveryAdjustmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DeliveryAdjustmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReasonCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}AdjustmentReasonCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Reason" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ActualAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ActualQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="ActualDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryAdjustmentType", propOrder = {
    "reasonCode",
    "reason",
    "actualAmount",
    "actualQuantity",
    "actualDateTime"
})
public class DeliveryAdjustmentType {

    @XmlElement(name = "ReasonCode")
    protected AdjustmentReasonCodeType reasonCode;
    @XmlElement(name = "Reason")
    protected List<TextType> reason;
    @XmlElement(name = "ActualAmount")
    protected List<AmountType> actualAmount;
    @XmlElement(name = "ActualQuantity")
    protected QuantityType actualQuantity;
    @XmlElement(name = "ActualDateTime")
    protected DateTimeType actualDateTime;

    /**
     * Ruft den Wert der reasonCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AdjustmentReasonCodeType }
     *     
     */
    public AdjustmentReasonCodeType getReasonCode() {
        return reasonCode;
    }

    /**
     * Legt den Wert der reasonCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AdjustmentReasonCodeType }
     *     
     */
    public void setReasonCode(AdjustmentReasonCodeType value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getReason() {
        if (reason == null) {
            reason = new ArrayList<TextType>();
        }
        return this.reason;
    }

    /**
     * Gets the value of the actualAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actualAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActualAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getActualAmount() {
        if (actualAmount == null) {
            actualAmount = new ArrayList<AmountType>();
        }
        return this.actualAmount;
    }

    /**
     * Ruft den Wert der actualQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getActualQuantity() {
        return actualQuantity;
    }

    /**
     * Legt den Wert der actualQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setActualQuantity(QuantityType value) {
        this.actualQuantity = value;
    }

    /**
     * Ruft den Wert der actualDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getActualDateTime() {
        return actualDateTime;
    }

    /**
     * Legt den Wert der actualDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setActualDateTime(DateTimeType value) {
        this.actualDateTime = value;
    }

}
