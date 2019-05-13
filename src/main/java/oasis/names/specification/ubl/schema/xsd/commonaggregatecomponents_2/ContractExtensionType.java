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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumNumberNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumNumberNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OptionsDescriptionType;


/**
 * <p>Java-Klasse für ContractExtensionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ContractExtensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OptionsDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumNumberNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumNumberNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OptionValidityPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Renewal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractExtensionType", propOrder = {
    "optionsDescription",
    "minimumNumberNumeric",
    "maximumNumberNumeric",
    "optionValidityPeriod",
    "renewal"
})
public class ContractExtensionType {

    @XmlElement(name = "OptionsDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<OptionsDescriptionType> optionsDescription;
    @XmlElement(name = "MinimumNumberNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumNumberNumericType minimumNumberNumeric;
    @XmlElement(name = "MaximumNumberNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumNumberNumericType maximumNumberNumeric;
    @XmlElement(name = "OptionValidityPeriod")
    protected PeriodType optionValidityPeriod;
    @XmlElement(name = "Renewal")
    protected List<RenewalType> renewal;

    /**
     * Gets the value of the optionsDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optionsDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionsDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionsDescriptionType }
     * 
     * 
     */
    public List<OptionsDescriptionType> getOptionsDescription() {
        if (optionsDescription == null) {
            optionsDescription = new ArrayList<OptionsDescriptionType>();
        }
        return this.optionsDescription;
    }

    /**
     * Ruft den Wert der minimumNumberNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MinimumNumberNumericType }
     *     
     */
    public MinimumNumberNumericType getMinimumNumberNumeric() {
        return minimumNumberNumeric;
    }

    /**
     * Legt den Wert der minimumNumberNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumNumberNumericType }
     *     
     */
    public void setMinimumNumberNumeric(MinimumNumberNumericType value) {
        this.minimumNumberNumeric = value;
    }

    /**
     * Ruft den Wert der maximumNumberNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumNumberNumericType }
     *     
     */
    public MaximumNumberNumericType getMaximumNumberNumeric() {
        return maximumNumberNumeric;
    }

    /**
     * Legt den Wert der maximumNumberNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumNumberNumericType }
     *     
     */
    public void setMaximumNumberNumeric(MaximumNumberNumericType value) {
        this.maximumNumberNumeric = value;
    }

    /**
     * Ruft den Wert der optionValidityPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getOptionValidityPeriod() {
        return optionValidityPeriod;
    }

    /**
     * Legt den Wert der optionValidityPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setOptionValidityPeriod(PeriodType value) {
        this.optionValidityPeriod = value;
    }

    /**
     * Gets the value of the renewal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the renewal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenewal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RenewalType }
     * 
     * 
     */
    public List<RenewalType> getRenewal() {
        if (renewal == null) {
            renewal = new ArrayList<RenewalType>();
        }
        return this.renewal;
    }

}
