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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PartyTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PartyTypeType;


/**
 * <p>Java-Klasse für ContractingPartyTypeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ContractingPartyTypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PartyTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PartyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractingPartyTypeType", propOrder = {
    "partyTypeCode",
    "partyType"
})
public class ContractingPartyTypeType {

    @XmlElement(name = "PartyTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PartyTypeCodeType partyTypeCode;
    @XmlElement(name = "PartyType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PartyTypeType partyType;

    /**
     * Ruft den Wert der partyTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyTypeCodeType }
     *     
     */
    public PartyTypeCodeType getPartyTypeCode() {
        return partyTypeCode;
    }

    /**
     * Legt den Wert der partyTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyTypeCodeType }
     *     
     */
    public void setPartyTypeCode(PartyTypeCodeType value) {
        this.partyTypeCode = value;
    }

    /**
     * Ruft den Wert der partyType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyTypeType }
     *     
     */
    public PartyTypeType getPartyType() {
        return partyType;
    }

    /**
     * Legt den Wert der partyType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyTypeType }
     *     
     */
    public void setPartyType(PartyTypeType value) {
        this.partyType = value;
    }

}
