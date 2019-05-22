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


/**
 * <p>Java-Klasse für PricingReferenceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PricingReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginalItemLocationQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AlternativeConditionPrice" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PricingReferenceType", propOrder = {
    "originalItemLocationQuantity",
    "alternativeConditionPrice"
})
public class PricingReferenceType {

    @XmlElement(name = "OriginalItemLocationQuantity")
    protected ItemLocationQuantityType originalItemLocationQuantity;
    @XmlElement(name = "AlternativeConditionPrice")
    protected List<PriceType> alternativeConditionPrice;

    /**
     * Ruft den Wert der originalItemLocationQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemLocationQuantityType }
     *     
     */
    public ItemLocationQuantityType getOriginalItemLocationQuantity() {
        return originalItemLocationQuantity;
    }

    /**
     * Legt den Wert der originalItemLocationQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemLocationQuantityType }
     *     
     */
    public void setOriginalItemLocationQuantity(ItemLocationQuantityType value) {
        this.originalItemLocationQuantity = value;
    }

    /**
     * Gets the value of the alternativeConditionPrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternativeConditionPrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternativeConditionPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceType }
     * 
     * 
     */
    public List<PriceType> getAlternativeConditionPrice() {
        if (alternativeConditionPrice == null) {
            alternativeConditionPrice = new ArrayList<PriceType>();
        }
        return this.alternativeConditionPrice;
    }

}
