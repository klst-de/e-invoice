//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecificationIDType;


/**
 * <p>Java-Klasse für PromotionalSpecificationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PromotionalSpecificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecificationID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PromotionalEventLineItem" maxOccurs="unbounded"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EventTactic" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromotionalSpecificationType", propOrder = {
    "specificationID",
    "promotionalEventLineItem",
    "eventTactic"
})
public class PromotionalSpecificationType {

    @XmlElement(name = "SpecificationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecificationIDType specificationID;
    @XmlElement(name = "PromotionalEventLineItem", required = true)
    protected List<PromotionalEventLineItemType> promotionalEventLineItem;
    @XmlElement(name = "EventTactic")
    protected List<EventTacticType> eventTactic;

    /**
     * Ruft den Wert der specificationID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecificationIDType }
     *     
     */
    public SpecificationIDType getSpecificationID() {
        return specificationID;
    }

    /**
     * Legt den Wert der specificationID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificationIDType }
     *     
     */
    public void setSpecificationID(SpecificationIDType value) {
        this.specificationID = value;
    }

    /**
     * Gets the value of the promotionalEventLineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionalEventLineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionalEventLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionalEventLineItemType }
     * 
     * 
     */
    public List<PromotionalEventLineItemType> getPromotionalEventLineItem() {
        if (promotionalEventLineItem == null) {
            promotionalEventLineItem = new ArrayList<PromotionalEventLineItemType>();
        }
        return this.promotionalEventLineItem;
    }

    /**
     * Gets the value of the eventTactic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventTactic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventTactic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventTacticType }
     * 
     * 
     */
    public List<EventTacticType> getEventTactic() {
        if (eventTactic == null) {
            eventTactic = new ArrayList<EventTacticType>();
        }
        return this.eventTactic;
    }

}
