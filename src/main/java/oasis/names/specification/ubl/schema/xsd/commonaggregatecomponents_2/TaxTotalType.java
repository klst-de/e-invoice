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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoundingAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEvidenceIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxIncludedIndicatorType;


/**
 * <p>Java-Klasse für TaxTotalType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TaxTotalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxAmount"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RoundingAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEvidenceIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxIncludedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxSubtotal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxTotalType", propOrder = {
    "taxAmount",
    "roundingAmount",
    "taxEvidenceIndicator",
    "taxIncludedIndicator",
    "taxSubtotal"
})
public class TaxTotalType {

    @XmlElement(name = "TaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TaxAmountType taxAmount;
    @XmlElement(name = "RoundingAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RoundingAmountType roundingAmount;
    @XmlElement(name = "TaxEvidenceIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxEvidenceIndicatorType taxEvidenceIndicator;
    @XmlElement(name = "TaxIncludedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxIncludedIndicatorType taxIncludedIndicator;
    @XmlElement(name = "TaxSubtotal")
    protected List<TaxSubtotalType> taxSubtotal;

    /**
     * Ruft den Wert der taxAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxAmountType }
     *     
     */
    public TaxAmountType getTaxAmount() {
        return taxAmount;
    }

    /**
     * Legt den Wert der taxAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAmountType }
     *     
     */
    public void setTaxAmount(TaxAmountType value) {
        this.taxAmount = value;
    }

    /**
     * Ruft den Wert der roundingAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RoundingAmountType }
     *     
     */
    public RoundingAmountType getRoundingAmount() {
        return roundingAmount;
    }

    /**
     * Legt den Wert der roundingAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RoundingAmountType }
     *     
     */
    public void setRoundingAmount(RoundingAmountType value) {
        this.roundingAmount = value;
    }

    /**
     * Ruft den Wert der taxEvidenceIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxEvidenceIndicatorType }
     *     
     */
    public TaxEvidenceIndicatorType getTaxEvidenceIndicator() {
        return taxEvidenceIndicator;
    }

    /**
     * Legt den Wert der taxEvidenceIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEvidenceIndicatorType }
     *     
     */
    public void setTaxEvidenceIndicator(TaxEvidenceIndicatorType value) {
        this.taxEvidenceIndicator = value;
    }

    /**
     * Ruft den Wert der taxIncludedIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxIncludedIndicatorType }
     *     
     */
    public TaxIncludedIndicatorType getTaxIncludedIndicator() {
        return taxIncludedIndicator;
    }

    /**
     * Legt den Wert der taxIncludedIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxIncludedIndicatorType }
     *     
     */
    public void setTaxIncludedIndicator(TaxIncludedIndicatorType value) {
        this.taxIncludedIndicator = value;
    }

    /**
     * Gets the value of the taxSubtotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxSubtotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxSubtotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxSubtotalType }
     * 
     * 
     */
    public List<TaxSubtotalType> getTaxSubtotal() {
        if (taxSubtotal == null) {
            taxSubtotal = new ArrayList<TaxSubtotalType>();
        }
        return this.taxSubtotal;
    }

}
