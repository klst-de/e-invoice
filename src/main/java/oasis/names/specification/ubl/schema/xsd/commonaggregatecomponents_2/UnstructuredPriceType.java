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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimeAmountType;


/**
 * <p>Java-Klasse für UnstructuredPriceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="UnstructuredPriceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimeAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnstructuredPriceType", propOrder = {
    "priceAmount",
    "timeAmount"
})
public class UnstructuredPriceType {

    @XmlElement(name = "PriceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriceAmountType priceAmount;
    @XmlElement(name = "TimeAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimeAmountType timeAmount;

    /**
     * Ruft den Wert der priceAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceAmountType }
     *     
     */
    public PriceAmountType getPriceAmount() {
        return priceAmount;
    }

    /**
     * Legt den Wert der priceAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceAmountType }
     *     
     */
    public void setPriceAmount(PriceAmountType value) {
        this.priceAmount = value;
    }

    /**
     * Ruft den Wert der timeAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TimeAmountType }
     *     
     */
    public TimeAmountType getTimeAmount() {
        return timeAmount;
    }

    /**
     * Legt den Wert der timeAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeAmountType }
     *     
     */
    public void setTimeAmount(TimeAmountType value) {
        this.timeAmount = value;
    }

}
