//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConditionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SealIssuerTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SealStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SealingPartyTypeType;


/**
 * <p>Java-Klasse für TransportEquipmentSealType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportEquipmentSealType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SealIssuerTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Condition" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SealStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SealingPartyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportEquipmentSealType", propOrder = {
    "id",
    "sealIssuerTypeCode",
    "condition",
    "sealStatusCode",
    "sealingPartyType"
})
public class TransportEquipmentSealType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "SealIssuerTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SealIssuerTypeCodeType sealIssuerTypeCode;
    @XmlElement(name = "Condition", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConditionType condition;
    @XmlElement(name = "SealStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SealStatusCodeType sealStatusCode;
    @XmlElement(name = "SealingPartyType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SealingPartyTypeType sealingPartyType;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der sealIssuerTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SealIssuerTypeCodeType }
     *     
     */
    public SealIssuerTypeCodeType getSealIssuerTypeCode() {
        return sealIssuerTypeCode;
    }

    /**
     * Legt den Wert der sealIssuerTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SealIssuerTypeCodeType }
     *     
     */
    public void setSealIssuerTypeCode(SealIssuerTypeCodeType value) {
        this.sealIssuerTypeCode = value;
    }

    /**
     * Ruft den Wert der condition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConditionType }
     *     
     */
    public ConditionType getCondition() {
        return condition;
    }

    /**
     * Legt den Wert der condition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionType }
     *     
     */
    public void setCondition(ConditionType value) {
        this.condition = value;
    }

    /**
     * Ruft den Wert der sealStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SealStatusCodeType }
     *     
     */
    public SealStatusCodeType getSealStatusCode() {
        return sealStatusCode;
    }

    /**
     * Legt den Wert der sealStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SealStatusCodeType }
     *     
     */
    public void setSealStatusCode(SealStatusCodeType value) {
        this.sealStatusCode = value;
    }

    /**
     * Ruft den Wert der sealingPartyType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SealingPartyTypeType }
     *     
     */
    public SealingPartyTypeType getSealingPartyType() {
        return sealingPartyType;
    }

    /**
     * Legt den Wert der sealingPartyType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SealingPartyTypeType }
     *     
     */
    public void setSealingPartyType(SealingPartyTypeType value) {
        this.sealingPartyType = value;
    }

}
