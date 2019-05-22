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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EffectiveDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EffectiveTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResponseCodeType;


/**
 * <p>Java-Klasse für ResponseType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResponseCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EffectiveDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EffectiveTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Status" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseType", propOrder = {
    "referenceID",
    "responseCode",
    "description",
    "effectiveDate",
    "effectiveTime",
    "status"
})
public class ResponseType {

    @XmlElement(name = "ReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReferenceIDType referenceID;
    @XmlElement(name = "ResponseCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ResponseCodeType responseCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "EffectiveDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EffectiveDateType effectiveDate;
    @XmlElement(name = "EffectiveTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EffectiveTimeType effectiveTime;
    @XmlElement(name = "Status")
    protected List<StatusType> status;

    /**
     * Ruft den Wert der referenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceIDType }
     *     
     */
    public ReferenceIDType getReferenceID() {
        return referenceID;
    }

    /**
     * Legt den Wert der referenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceIDType }
     *     
     */
    public void setReferenceID(ReferenceIDType value) {
        this.referenceID = value;
    }

    /**
     * Ruft den Wert der responseCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCodeType }
     *     
     */
    public ResponseCodeType getResponseCode() {
        return responseCode;
    }

    /**
     * Legt den Wert der responseCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCodeType }
     *     
     */
    public void setResponseCode(ResponseCodeType value) {
        this.responseCode = value;
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
     * Ruft den Wert der effectiveDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveDateType }
     *     
     */
    public EffectiveDateType getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Legt den Wert der effectiveDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveDateType }
     *     
     */
    public void setEffectiveDate(EffectiveDateType value) {
        this.effectiveDate = value;
    }

    /**
     * Ruft den Wert der effectiveTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveTimeType }
     *     
     */
    public EffectiveTimeType getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Legt den Wert der effectiveTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveTimeType }
     *     
     */
    public void setEffectiveTime(EffectiveTimeType value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusType }
     * 
     * 
     */
    public List<StatusType> getStatus() {
        if (status == null) {
            status = new ArrayList<StatusType>();
        }
        return this.status;
    }

}
