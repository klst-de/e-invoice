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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyBalanceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyOnAccountAmountType;


/**
 * <p>Java-Klasse für EnergyTaxReportType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EnergyTaxReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEnergyAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEnergyOnAccountAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEnergyBalanceAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxScheme"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyTaxReportType", propOrder = {
    "taxEnergyAmount",
    "taxEnergyOnAccountAmount",
    "taxEnergyBalanceAmount",
    "taxScheme"
})
public class EnergyTaxReportType {

    @XmlElement(name = "TaxEnergyAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxEnergyAmountType taxEnergyAmount;
    @XmlElement(name = "TaxEnergyOnAccountAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxEnergyOnAccountAmountType taxEnergyOnAccountAmount;
    @XmlElement(name = "TaxEnergyBalanceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxEnergyBalanceAmountType taxEnergyBalanceAmount;
    @XmlElement(name = "TaxScheme", required = true)
    protected TaxSchemeType taxScheme;

    /**
     * Ruft den Wert der taxEnergyAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxEnergyAmountType }
     *     
     */
    public TaxEnergyAmountType getTaxEnergyAmount() {
        return taxEnergyAmount;
    }

    /**
     * Legt den Wert der taxEnergyAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEnergyAmountType }
     *     
     */
    public void setTaxEnergyAmount(TaxEnergyAmountType value) {
        this.taxEnergyAmount = value;
    }

    /**
     * Ruft den Wert der taxEnergyOnAccountAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxEnergyOnAccountAmountType }
     *     
     */
    public TaxEnergyOnAccountAmountType getTaxEnergyOnAccountAmount() {
        return taxEnergyOnAccountAmount;
    }

    /**
     * Legt den Wert der taxEnergyOnAccountAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEnergyOnAccountAmountType }
     *     
     */
    public void setTaxEnergyOnAccountAmount(TaxEnergyOnAccountAmountType value) {
        this.taxEnergyOnAccountAmount = value;
    }

    /**
     * Ruft den Wert der taxEnergyBalanceAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxEnergyBalanceAmountType }
     *     
     */
    public TaxEnergyBalanceAmountType getTaxEnergyBalanceAmount() {
        return taxEnergyBalanceAmount;
    }

    /**
     * Legt den Wert der taxEnergyBalanceAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEnergyBalanceAmountType }
     *     
     */
    public void setTaxEnergyBalanceAmount(TaxEnergyBalanceAmountType value) {
        this.taxEnergyBalanceAmount = value;
    }

    /**
     * Ruft den Wert der taxScheme-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxSchemeType }
     *     
     */
    public TaxSchemeType getTaxScheme() {
        return taxScheme;
    }

    /**
     * Legt den Wert der taxScheme-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxSchemeType }
     *     
     */
    public void setTaxScheme(TaxSchemeType value) {
        this.taxScheme = value;
    }

}
