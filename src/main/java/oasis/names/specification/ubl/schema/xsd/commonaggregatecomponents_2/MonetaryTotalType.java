//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAlternativeAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableRoundingAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrepaidAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;


/**
 * <p>Java-Klasse für MonetaryTotalType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MonetaryTotalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineExtensionAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxExclusiveAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxInclusiveAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AllowanceTotalAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChargeTotalAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrepaidAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PayableRoundingAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PayableAmount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PayableAlternativeAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonetaryTotalType", propOrder = {
    "lineExtensionAmount",
    "taxExclusiveAmount",
    "taxInclusiveAmount",
    "allowanceTotalAmount",
    "chargeTotalAmount",
    "prepaidAmount",
    "payableRoundingAmount",
    "payableAmount",
    "payableAlternativeAmount"
})
public class MonetaryTotalType {

    @XmlElement(name = "LineExtensionAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineExtensionAmountType lineExtensionAmount;
    @XmlElement(name = "TaxExclusiveAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxExclusiveAmountType taxExclusiveAmount;
    @XmlElement(name = "TaxInclusiveAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxInclusiveAmountType taxInclusiveAmount;
    @XmlElement(name = "AllowanceTotalAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AllowanceTotalAmountType allowanceTotalAmount;
    @XmlElement(name = "ChargeTotalAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ChargeTotalAmountType chargeTotalAmount;
    @XmlElement(name = "PrepaidAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrepaidAmountType prepaidAmount;
    @XmlElement(name = "PayableRoundingAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PayableRoundingAmountType payableRoundingAmount;
    @XmlElement(name = "PayableAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PayableAmountType payableAmount;
    @XmlElement(name = "PayableAlternativeAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PayableAlternativeAmountType payableAlternativeAmount;

    /**
     * Ruft den Wert der lineExtensionAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public LineExtensionAmountType getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    /**
     * Legt den Wert der lineExtensionAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public void setLineExtensionAmount(LineExtensionAmountType value) {
        this.lineExtensionAmount = value;
    }

    /**
     * Ruft den Wert der taxExclusiveAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxExclusiveAmountType }
     *     
     */
    public TaxExclusiveAmountType getTaxExclusiveAmount() {
        return taxExclusiveAmount;
    }

    /**
     * Legt den Wert der taxExclusiveAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxExclusiveAmountType }
     *     
     */
    public void setTaxExclusiveAmount(TaxExclusiveAmountType value) {
        this.taxExclusiveAmount = value;
    }

    /**
     * Ruft den Wert der taxInclusiveAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxInclusiveAmountType }
     *     
     */
    public TaxInclusiveAmountType getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }

    /**
     * Legt den Wert der taxInclusiveAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxInclusiveAmountType }
     *     
     */
    public void setTaxInclusiveAmount(TaxInclusiveAmountType value) {
        this.taxInclusiveAmount = value;
    }

    /**
     * Ruft den Wert der allowanceTotalAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AllowanceTotalAmountType }
     *     
     */
    public AllowanceTotalAmountType getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    /**
     * Legt den Wert der allowanceTotalAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowanceTotalAmountType }
     *     
     */
    public void setAllowanceTotalAmount(AllowanceTotalAmountType value) {
        this.allowanceTotalAmount = value;
    }

    /**
     * Ruft den Wert der chargeTotalAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeTotalAmountType }
     *     
     */
    public ChargeTotalAmountType getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    /**
     * Legt den Wert der chargeTotalAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeTotalAmountType }
     *     
     */
    public void setChargeTotalAmount(ChargeTotalAmountType value) {
        this.chargeTotalAmount = value;
    }

    /**
     * Ruft den Wert der prepaidAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PrepaidAmountType }
     *     
     */
    public PrepaidAmountType getPrepaidAmount() {
        return prepaidAmount;
    }

    /**
     * Legt den Wert der prepaidAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PrepaidAmountType }
     *     
     */
    public void setPrepaidAmount(PrepaidAmountType value) {
        this.prepaidAmount = value;
    }

    /**
     * Ruft den Wert der payableRoundingAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PayableRoundingAmountType }
     *     
     */
    public PayableRoundingAmountType getPayableRoundingAmount() {
        return payableRoundingAmount;
    }

    /**
     * Legt den Wert der payableRoundingAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PayableRoundingAmountType }
     *     
     */
    public void setPayableRoundingAmount(PayableRoundingAmountType value) {
        this.payableRoundingAmount = value;
    }

    /**
     * Ruft den Wert der payableAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PayableAmountType }
     *     
     */
    public PayableAmountType getPayableAmount() {
        return payableAmount;
    }

    /**
     * Legt den Wert der payableAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PayableAmountType }
     *     
     */
    public void setPayableAmount(PayableAmountType value) {
        this.payableAmount = value;
    }

    /**
     * Ruft den Wert der payableAlternativeAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PayableAlternativeAmountType }
     *     
     */
    public PayableAlternativeAmountType getPayableAlternativeAmount() {
        return payableAlternativeAmount;
    }

    /**
     * Legt den Wert der payableAlternativeAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PayableAlternativeAmountType }
     *     
     */
    public void setPayableAlternativeAmount(PayableAlternativeAmountType value) {
        this.payableAlternativeAmount = value;
    }

}
