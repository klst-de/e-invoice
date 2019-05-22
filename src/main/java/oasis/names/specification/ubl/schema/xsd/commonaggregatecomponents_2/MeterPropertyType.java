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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueQualifierType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueType;


/**
 * <p>Java-Klasse für MeterPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MeterPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NameCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Value" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueQualifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterPropertyType", propOrder = {
    "name",
    "nameCode",
    "value",
    "valueQuantity",
    "valueQualifier"
})
public class MeterPropertyType {

    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameType name;
    @XmlElement(name = "NameCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameCodeType nameCode;
    @XmlElement(name = "Value", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValueType value;
    @XmlElement(name = "ValueQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValueQuantityType valueQuantity;
    @XmlElement(name = "ValueQualifier", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ValueQualifierType> valueQualifier;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setName(NameType value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der nameCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameCodeType }
     *     
     */
    public NameCodeType getNameCode() {
        return nameCode;
    }

    /**
     * Legt den Wert der nameCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameCodeType }
     *     
     */
    public void setNameCode(NameCodeType value) {
        this.nameCode = value;
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValueType }
     *     
     */
    public ValueType getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueType }
     *     
     */
    public void setValue(ValueType value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der valueQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValueQuantityType }
     *     
     */
    public ValueQuantityType getValueQuantity() {
        return valueQuantity;
    }

    /**
     * Legt den Wert der valueQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueQuantityType }
     *     
     */
    public void setValueQuantity(ValueQuantityType value) {
        this.valueQuantity = value;
    }

    /**
     * Gets the value of the valueQualifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueQualifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueQualifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueQualifierType }
     * 
     * 
     */
    public List<ValueQualifierType> getValueQualifier() {
        if (valueQualifier == null) {
            valueQualifier = new ArrayList<ValueQualifierType>();
        }
        return this.valueQualifier;
    }

}
