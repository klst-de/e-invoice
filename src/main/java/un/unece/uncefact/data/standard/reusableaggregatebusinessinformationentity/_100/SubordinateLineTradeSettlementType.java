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


/**
 * <p>Java-Klasse für SubordinateLineTradeSettlementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SubordinateLineTradeSettlementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApplicableTradeTax" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeTaxType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubordinateLineTradeSettlementType", propOrder = {
    "applicableTradeTax"
})
public class SubordinateLineTradeSettlementType {

    @XmlElement(name = "ApplicableTradeTax")
    protected TradeTaxType applicableTradeTax;

    /**
     * Ruft den Wert der applicableTradeTax-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeTaxType }
     *     
     */
    public TradeTaxType getApplicableTradeTax() {
        return applicableTradeTax;
    }

    /**
     * Legt den Wert der applicableTradeTax-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeTaxType }
     *     
     */
    public void setApplicableTradeTax(TradeTaxType value) {
        this.applicableTradeTax = value;
    }

}
