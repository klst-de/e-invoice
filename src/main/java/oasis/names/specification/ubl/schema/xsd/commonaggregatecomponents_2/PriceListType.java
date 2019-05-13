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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StatusCodeType;


/**
 * <p>Java-Klasse für PriceListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PriceListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}StatusCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PreviousPriceList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceListType", propOrder = {
    "id",
    "statusCode",
    "validityPeriod",
    "previousPriceList"
})
public class PriceListType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "StatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected StatusCodeType statusCode;
    @XmlElement(name = "ValidityPeriod")
    protected List<PeriodType> validityPeriod;
    @XmlElement(name = "PreviousPriceList")
    protected PriceListType previousPriceList;

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
     * Ruft den Wert der statusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StatusCodeType }
     *     
     */
    public StatusCodeType getStatusCode() {
        return statusCode;
    }

    /**
     * Legt den Wert der statusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusCodeType }
     *     
     */
    public void setStatusCode(StatusCodeType value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the validityPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validityPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidityPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getValidityPeriod() {
        if (validityPeriod == null) {
            validityPeriod = new ArrayList<PeriodType>();
        }
        return this.validityPeriod;
    }

    /**
     * Ruft den Wert der previousPriceList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceListType }
     *     
     */
    public PriceListType getPreviousPriceList() {
        return previousPriceList;
    }

    /**
     * Legt den Wert der previousPriceList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceListType }
     *     
     */
    public void setPreviousPriceList(PriceListType value) {
        this.previousPriceList = value;
    }

}
