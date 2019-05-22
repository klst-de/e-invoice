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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SalesOrderLineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;


/**
 * <p>Java-Klasse für OrderLineReferenceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OrderLineReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SalesOrderLineID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OrderReference" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderLineReferenceType", propOrder = {
    "lineID",
    "salesOrderLineID",
    "uuid",
    "lineStatusCode",
    "orderReference"
})
public class OrderLineReferenceType {

    @XmlElement(name = "LineID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LineIDType lineID;
    @XmlElement(name = "SalesOrderLineID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SalesOrderLineIDType salesOrderLineID;
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UUIDType uuid;
    @XmlElement(name = "LineStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineStatusCodeType lineStatusCode;
    @XmlElement(name = "OrderReference")
    protected OrderReferenceType orderReference;

    /**
     * Ruft den Wert der lineID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineIDType }
     *     
     */
    public LineIDType getLineID() {
        return lineID;
    }

    /**
     * Legt den Wert der lineID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineIDType }
     *     
     */
    public void setLineID(LineIDType value) {
        this.lineID = value;
    }

    /**
     * Ruft den Wert der salesOrderLineID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SalesOrderLineIDType }
     *     
     */
    public SalesOrderLineIDType getSalesOrderLineID() {
        return salesOrderLineID;
    }

    /**
     * Legt den Wert der salesOrderLineID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesOrderLineIDType }
     *     
     */
    public void setSalesOrderLineID(SalesOrderLineIDType value) {
        this.salesOrderLineID = value;
    }

    /**
     * Ruft den Wert der uuid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UUIDType }
     *     
     */
    public UUIDType getUUID() {
        return uuid;
    }

    /**
     * Legt den Wert der uuid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UUIDType }
     *     
     */
    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    /**
     * Ruft den Wert der lineStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineStatusCodeType }
     *     
     */
    public LineStatusCodeType getLineStatusCode() {
        return lineStatusCode;
    }

    /**
     * Legt den Wert der lineStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStatusCodeType }
     *     
     */
    public void setLineStatusCode(LineStatusCodeType value) {
        this.lineStatusCode = value;
    }

    /**
     * Ruft den Wert der orderReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrderReferenceType }
     *     
     */
    public OrderReferenceType getOrderReference() {
        return orderReference;
    }

    /**
     * Legt den Wert der orderReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReferenceType }
     *     
     */
    public void setOrderReference(OrderReferenceType value) {
        this.orderReference = value;
    }

}
