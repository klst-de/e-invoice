//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;


/**
 * <p>Java-Klasse für AdvancePaymentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AdvancePaymentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaidAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType"/>
 *         &lt;element name="FormattedReceivedDateTime" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}FormattedDateTimeType" minOccurs="0"/>
 *         &lt;element name="IncludedTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdvancePaymentType", propOrder = {
    "paidAmount",
    "formattedReceivedDateTime",
    "includedTradeTax"
})
public class AdvancePaymentType {

    @XmlElement(name = "PaidAmount", required = true)
    protected AmountType paidAmount;
    @XmlElement(name = "FormattedReceivedDateTime")
    protected FormattedDateTimeType formattedReceivedDateTime;
    @XmlElement(name = "IncludedTradeTax")
    protected List<TradeTaxType> includedTradeTax;

    /**
     * Ruft den Wert der paidAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getPaidAmount() {
        return paidAmount;
    }

    /**
     * Legt den Wert der paidAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setPaidAmount(AmountType value) {
        this.paidAmount = value;
    }

    /**
     * Ruft den Wert der formattedReceivedDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public FormattedDateTimeType getFormattedReceivedDateTime() {
        return formattedReceivedDateTime;
    }

    /**
     * Legt den Wert der formattedReceivedDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedDateTimeType }
     *     
     */
    public void setFormattedReceivedDateTime(FormattedDateTimeType value) {
        this.formattedReceivedDateTime = value;
    }

    /**
     * Gets the value of the includedTradeTax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedTradeTax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedTradeTax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeTaxType }
     * 
     * 
     */
    public List<TradeTaxType> getIncludedTradeTax() {
        if (includedTradeTax == null) {
            includedTradeTax = new ArrayList<TradeTaxType>();
        }
        return this.includedTradeTax;
    }

}
