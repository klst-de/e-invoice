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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpectedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LimitationDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumQuantityType;


/**
 * <p>Java-Klasse für EconomicOperatorShortListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EconomicOperatorShortListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LimitationDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExpectedQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PreSelectedParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EconomicOperatorShortListType", propOrder = {
    "limitationDescription",
    "expectedQuantity",
    "maximumQuantity",
    "minimumQuantity",
    "preSelectedParty"
})
public class EconomicOperatorShortListType {

    @XmlElement(name = "LimitationDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<LimitationDescriptionType> limitationDescription;
    @XmlElement(name = "ExpectedQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExpectedQuantityType expectedQuantity;
    @XmlElement(name = "MaximumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumQuantityType maximumQuantity;
    @XmlElement(name = "MinimumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumQuantityType minimumQuantity;
    @XmlElement(name = "PreSelectedParty")
    protected List<PartyType> preSelectedParty;

    /**
     * Gets the value of the limitationDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the limitationDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLimitationDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LimitationDescriptionType }
     * 
     * 
     */
    public List<LimitationDescriptionType> getLimitationDescription() {
        if (limitationDescription == null) {
            limitationDescription = new ArrayList<LimitationDescriptionType>();
        }
        return this.limitationDescription;
    }

    /**
     * Ruft den Wert der expectedQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpectedQuantityType }
     *     
     */
    public ExpectedQuantityType getExpectedQuantity() {
        return expectedQuantity;
    }

    /**
     * Legt den Wert der expectedQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpectedQuantityType }
     *     
     */
    public void setExpectedQuantity(ExpectedQuantityType value) {
        this.expectedQuantity = value;
    }

    /**
     * Ruft den Wert der maximumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumQuantityType }
     *     
     */
    public MaximumQuantityType getMaximumQuantity() {
        return maximumQuantity;
    }

    /**
     * Legt den Wert der maximumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumQuantityType }
     *     
     */
    public void setMaximumQuantity(MaximumQuantityType value) {
        this.maximumQuantity = value;
    }

    /**
     * Ruft den Wert der minimumQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumQuantityType }
     *     
     */
    public MinimumQuantityType getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * Legt den Wert der minimumQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumQuantityType }
     *     
     */
    public void setMinimumQuantity(MinimumQuantityType value) {
        this.minimumQuantity = value;
    }

    /**
     * Gets the value of the preSelectedParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preSelectedParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreSelectedParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getPreSelectedParty() {
        if (preSelectedParty == null) {
            preSelectedParty = new ArrayList<PartyType>();
        }
        return this.preSelectedParty;
    }

}
