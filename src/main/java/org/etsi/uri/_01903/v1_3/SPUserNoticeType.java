//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SPUserNoticeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SPUserNoticeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NoticeRef" type="{http://uri.etsi.org/01903/v1.3.2#}NoticeReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="ExplicitText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SPUserNoticeType", propOrder = {
    "noticeRef",
    "explicitText"
})
public class SPUserNoticeType {

    @XmlElement(name = "NoticeRef")
    protected NoticeReferenceType noticeRef;
    @XmlElement(name = "ExplicitText")
    protected String explicitText;

    /**
     * Ruft den Wert der noticeRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NoticeReferenceType }
     *     
     */
    public NoticeReferenceType getNoticeRef() {
        return noticeRef;
    }

    /**
     * Legt den Wert der noticeRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NoticeReferenceType }
     *     
     */
    public void setNoticeRef(NoticeReferenceType value) {
        this.noticeRef = value;
    }

    /**
     * Ruft den Wert der explicitText-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExplicitText() {
        return explicitText;
    }

    /**
     * Legt den Wert der explicitText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExplicitText(String value) {
        this.explicitText = value;
    }

}
