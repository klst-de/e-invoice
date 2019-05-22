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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrivacyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TelecommunicationsSupplyTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TelecommunicationsSupplyTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalAmountType;


/**
 * <p>Java-Klasse für TelecommunicationsSupplyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TelecommunicationsSupplyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TelecommunicationsSupplyType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TelecommunicationsSupplyTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrivacyCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TelecommunicationsSupplyLine" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelecommunicationsSupplyType", propOrder = {
    "telecommunicationsSupplyType",
    "telecommunicationsSupplyTypeCode",
    "privacyCode",
    "description",
    "totalAmount",
    "telecommunicationsSupplyLine"
})
public class TelecommunicationsSupplyType {

    @XmlElement(name = "TelecommunicationsSupplyType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TelecommunicationsSupplyTypeType telecommunicationsSupplyType;
    @XmlElement(name = "TelecommunicationsSupplyTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TelecommunicationsSupplyTypeCodeType telecommunicationsSupplyTypeCode;
    @XmlElement(name = "PrivacyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PrivacyCodeType privacyCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "TotalAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalAmountType totalAmount;
    @XmlElement(name = "TelecommunicationsSupplyLine", required = true)
    protected List<TelecommunicationsSupplyLineType> telecommunicationsSupplyLine;

    /**
     * Ruft den Wert der telecommunicationsSupplyType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsSupplyTypeType }
     *     
     */
    public TelecommunicationsSupplyTypeType getTelecommunicationsSupplyType() {
        return telecommunicationsSupplyType;
    }

    /**
     * Legt den Wert der telecommunicationsSupplyType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsSupplyTypeType }
     *     
     */
    public void setTelecommunicationsSupplyType(TelecommunicationsSupplyTypeType value) {
        this.telecommunicationsSupplyType = value;
    }

    /**
     * Ruft den Wert der telecommunicationsSupplyTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsSupplyTypeCodeType }
     *     
     */
    public TelecommunicationsSupplyTypeCodeType getTelecommunicationsSupplyTypeCode() {
        return telecommunicationsSupplyTypeCode;
    }

    /**
     * Legt den Wert der telecommunicationsSupplyTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsSupplyTypeCodeType }
     *     
     */
    public void setTelecommunicationsSupplyTypeCode(TelecommunicationsSupplyTypeCodeType value) {
        this.telecommunicationsSupplyTypeCode = value;
    }

    /**
     * Ruft den Wert der privacyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PrivacyCodeType }
     *     
     */
    public PrivacyCodeType getPrivacyCode() {
        return privacyCode;
    }

    /**
     * Legt den Wert der privacyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivacyCodeType }
     *     
     */
    public void setPrivacyCode(PrivacyCodeType value) {
        this.privacyCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der totalAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalAmountType }
     *     
     */
    public TotalAmountType getTotalAmount() {
        return totalAmount;
    }

    /**
     * Legt den Wert der totalAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalAmountType }
     *     
     */
    public void setTotalAmount(TotalAmountType value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the telecommunicationsSupplyLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telecommunicationsSupplyLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelecommunicationsSupplyLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TelecommunicationsSupplyLineType }
     * 
     * 
     */
    public List<TelecommunicationsSupplyLineType> getTelecommunicationsSupplyLine() {
        if (telecommunicationsSupplyLine == null) {
            telecommunicationsSupplyLine = new ArrayList<TelecommunicationsSupplyLineType>();
        }
        return this.telecommunicationsSupplyLine;
    }

}
