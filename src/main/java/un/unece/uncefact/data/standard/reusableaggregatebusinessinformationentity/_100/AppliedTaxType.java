//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.RateType;


/**
 * <p>Java-Klasse für AppliedTaxType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AppliedTaxType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CalculatedAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="CalculatedRate" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}RateType" minOccurs="0"/&gt;
 *         &lt;element name="BasisAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="TaxPointDate" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppliedTaxType", propOrder = {
    "calculatedAmount",
    "typeCode",
    "calculatedRate",
    "basisAmount",
    "taxPointDate"
})
public class AppliedTaxType {

    @XmlElement(name = "CalculatedAmount")
    protected AmountType calculatedAmount;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "CalculatedRate")
    protected RateType calculatedRate;
    @XmlElement(name = "BasisAmount")
    protected AmountType basisAmount;
    @XmlElement(name = "TaxPointDate")
    protected DateType taxPointDate;

    /**
     * Ruft den Wert der calculatedAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getCalculatedAmount() {
        return calculatedAmount;
    }

    /**
     * Legt den Wert der calculatedAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setCalculatedAmount(AmountType value) {
        this.calculatedAmount = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setTypeCode(CodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der calculatedRate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RateType }
     *     
     */
    public RateType getCalculatedRate() {
        return calculatedRate;
    }

    /**
     * Legt den Wert der calculatedRate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RateType }
     *     
     */
    public void setCalculatedRate(RateType value) {
        this.calculatedRate = value;
    }

    /**
     * Ruft den Wert der basisAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getBasisAmount() {
        return basisAmount;
    }

    /**
     * Legt den Wert der basisAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setBasisAmount(AmountType value) {
        this.basisAmount = value;
    }

    /**
     * Ruft den Wert der taxPointDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * Legt den Wert der taxPointDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setTaxPointDate(DateType value) {
        this.taxPointDate = value;
    }

}
