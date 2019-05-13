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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DutyCodeType;


/**
 * <p>Java-Klasse für DutyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DutyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Amount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Duty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DutyCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxCategory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DutyType", propOrder = {
    "amount",
    "duty",
    "dutyCode",
    "taxCategory"
})
public class DutyType {

    @XmlElement(name = "Amount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected AmountType amount;
    @XmlElement(name = "Duty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DutyType duty;
    @XmlElement(name = "DutyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DutyCodeType dutyCode;
    @XmlElement(name = "TaxCategory")
    protected TaxCategoryType taxCategory;

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
     * Ruft den Wert der duty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DutyType }
     *     
     */
    public oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DutyType getDuty() {
        return duty;
    }

    /**
     * Legt den Wert der duty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DutyType }
     *     
     */
    public void setDuty(oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DutyType value) {
        this.duty = value;
    }

    /**
     * Ruft den Wert der dutyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DutyCodeType }
     *     
     */
    public DutyCodeType getDutyCode() {
        return dutyCode;
    }

    /**
     * Legt den Wert der dutyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DutyCodeType }
     *     
     */
    public void setDutyCode(DutyCodeType value) {
        this.dutyCode = value;
    }

    /**
     * Ruft den Wert der taxCategory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxCategoryType }
     *     
     */
    public TaxCategoryType getTaxCategory() {
        return taxCategory;
    }

    /**
     * Legt den Wert der taxCategory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCategoryType }
     *     
     */
    public void setTaxCategory(TaxCategoryType value) {
        this.taxCategory = value;
    }

}
