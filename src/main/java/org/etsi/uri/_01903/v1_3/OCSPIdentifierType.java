//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für OCSPIdentifierType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OCSPIdentifierType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponderID" type="{http://uri.etsi.org/01903/v1.3.2#}ResponderIDType"/&gt;
 *         &lt;element name="ProducedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OCSPIdentifierType", propOrder = {
    "responderID",
    "producedAt"
})
public class OCSPIdentifierType {

    @XmlElement(name = "ResponderID", required = true)
    protected ResponderIDType responderID;
    @XmlElement(name = "ProducedAt", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar producedAt;
    @XmlAttribute(name = "URI")
    @XmlSchemaType(name = "anyURI")
    protected String uri;

    /**
     * Ruft den Wert der responderID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResponderIDType }
     *     
     */
    public ResponderIDType getResponderID() {
        return responderID;
    }

    /**
     * Legt den Wert der responderID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponderIDType }
     *     
     */
    public void setResponderID(ResponderIDType value) {
        this.responderID = value;
    }

    /**
     * Ruft den Wert der producedAt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProducedAt() {
        return producedAt;
    }

    /**
     * Legt den Wert der producedAt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProducedAt(XMLGregorianCalendar value) {
        this.producedAt = value;
    }

    /**
     * Ruft den Wert der uri-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURI() {
        return uri;
    }

    /**
     * Legt den Wert der uri-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURI(String value) {
        this.uri = value;
    }

}
