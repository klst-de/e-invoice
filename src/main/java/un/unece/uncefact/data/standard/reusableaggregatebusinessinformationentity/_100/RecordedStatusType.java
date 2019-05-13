//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für RecordedStatusType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RecordedStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConditionCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType"/>
 *         &lt;element name="ChangerName" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="ChangedDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordedStatusType", propOrder = {
    "conditionCode",
    "changerName",
    "changedDateTime"
})
public class RecordedStatusType {

    @XmlElement(name = "ConditionCode", required = true)
    protected CodeType conditionCode;
    @XmlElement(name = "ChangerName")
    protected TextType changerName;
    @XmlElement(name = "ChangedDateTime", required = true)
    protected DateTimeType changedDateTime;

    /**
     * Ruft den Wert der conditionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getConditionCode() {
        return conditionCode;
    }

    /**
     * Legt den Wert der conditionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setConditionCode(CodeType value) {
        this.conditionCode = value;
    }

    /**
     * Ruft den Wert der changerName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChangerName() {
        return changerName;
    }

    /**
     * Legt den Wert der changerName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChangerName(TextType value) {
        this.changerName = value;
    }

    /**
     * Ruft den Wert der changedDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getChangedDateTime() {
        return changedDateTime;
    }

    /**
     * Legt den Wert der changedDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setChangedDateTime(DateTimeType value) {
        this.changedDateTime = value;
    }

}
