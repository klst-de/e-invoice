//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für NoteType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="NoteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Subject" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="ContentCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="Content" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubjectCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoteType", propOrder = {
    "subject",
    "contentCode",
    "content",
    "subjectCode",
    "id"
})
public class NoteType {

    @XmlElement(name = "Subject")
    protected TextType subject;
    @XmlElement(name = "ContentCode")
    protected CodeType contentCode;
    @XmlElement(name = "Content")
    protected List<TextType> content;
    @XmlElement(name = "SubjectCode")
    protected CodeType subjectCode;
    @XmlElement(name = "ID")
    protected IDType id;

    /**
     * Ruft den Wert der subject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSubject() {
        return subject;
    }

    /**
     * Legt den Wert der subject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSubject(TextType value) {
        this.subject = value;
    }

    /**
     * Ruft den Wert der contentCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getContentCode() {
        return contentCode;
    }

    /**
     * Legt den Wert der contentCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setContentCode(CodeType value) {
        this.contentCode = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getContent() {
        if (content == null) {
            content = new ArrayList<TextType>();
        }
        return this.content;
    }

    /**
     * Ruft den Wert der subjectCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getSubjectCode() {
        return subjectCode;
    }

    /**
     * Legt den Wert der subjectCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setSubjectCode(CodeType value) {
        this.subjectCode = value;
    }

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

}
