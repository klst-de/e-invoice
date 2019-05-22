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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;


/**
 * <p>Java-Klasse für ReferencePriceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReferencePriceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChargeAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="BasisQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="NetPriceIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ComparisonMethodCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencePriceType", propOrder = {
    "chargeAmount",
    "basisQuantity",
    "netPriceIndicator",
    "comparisonMethodCode"
})
public class ReferencePriceType {

    @XmlElement(name = "ChargeAmount")
    protected AmountType chargeAmount;
    @XmlElement(name = "BasisQuantity")
    protected List<QuantityType> basisQuantity;
    @XmlElement(name = "NetPriceIndicator")
    protected List<IndicatorType> netPriceIndicator;
    @XmlElement(name = "ComparisonMethodCode")
    protected CodeType comparisonMethodCode;

    /**
     * Ruft den Wert der chargeAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getChargeAmount() {
        return chargeAmount;
    }

    /**
     * Legt den Wert der chargeAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setChargeAmount(AmountType value) {
        this.chargeAmount = value;
    }

    /**
     * Gets the value of the basisQuantity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the basisQuantity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBasisQuantity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantityType }
     * 
     * 
     */
    public List<QuantityType> getBasisQuantity() {
        if (basisQuantity == null) {
            basisQuantity = new ArrayList<QuantityType>();
        }
        return this.basisQuantity;
    }

    /**
     * Gets the value of the netPriceIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netPriceIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetPriceIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndicatorType }
     * 
     * 
     */
    public List<IndicatorType> getNetPriceIndicator() {
        if (netPriceIndicator == null) {
            netPriceIndicator = new ArrayList<IndicatorType>();
        }
        return this.netPriceIndicator;
    }

    /**
     * Ruft den Wert der comparisonMethodCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getComparisonMethodCode() {
        return comparisonMethodCode;
    }

    /**
     * Legt den Wert der comparisonMethodCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setComparisonMethodCode(CodeType value) {
        this.comparisonMethodCode = value;
    }

}
