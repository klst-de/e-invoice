//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.AutomaticDataCaptureMethodCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PackagingMarkingCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für PackagingMarkingType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PackagingMarkingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PackagingMarkingCodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Content" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ContentDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="ContentAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="BarcodeTypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ContentCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AutomaticDataCaptureMethodTypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}AutomaticDataCaptureMethodCodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackagingMarkingType", propOrder = {
    "typeCode",
    "content",
    "contentDateTime",
    "contentAmount",
    "barcodeTypeCode",
    "contentCode",
    "automaticDataCaptureMethodTypeCode"
})
public class PackagingMarkingType {

    @XmlElement(name = "TypeCode")
    protected List<PackagingMarkingCodeType> typeCode;
    @XmlElement(name = "Content")
    protected List<TextType> content;
    @XmlElement(name = "ContentDateTime")
    protected DateTimeType contentDateTime;
    @XmlElement(name = "ContentAmount")
    protected List<AmountType> contentAmount;
    @XmlElement(name = "BarcodeTypeCode")
    protected List<CodeType> barcodeTypeCode;
    @XmlElement(name = "ContentCode")
    protected List<CodeType> contentCode;
    @XmlElement(name = "AutomaticDataCaptureMethodTypeCode")
    protected List<AutomaticDataCaptureMethodCodeType> automaticDataCaptureMethodTypeCode;

    /**
     * Gets the value of the typeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackagingMarkingCodeType }
     * 
     * 
     */
    public List<PackagingMarkingCodeType> getTypeCode() {
        if (typeCode == null) {
            typeCode = new ArrayList<PackagingMarkingCodeType>();
        }
        return this.typeCode;
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
     * Ruft den Wert der contentDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getContentDateTime() {
        return contentDateTime;
    }

    /**
     * Legt den Wert der contentDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setContentDateTime(DateTimeType value) {
        this.contentDateTime = value;
    }

    /**
     * Gets the value of the contentAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getContentAmount() {
        if (contentAmount == null) {
            contentAmount = new ArrayList<AmountType>();
        }
        return this.contentAmount;
    }

    /**
     * Gets the value of the barcodeTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the barcodeTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBarcodeTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getBarcodeTypeCode() {
        if (barcodeTypeCode == null) {
            barcodeTypeCode = new ArrayList<CodeType>();
        }
        return this.barcodeTypeCode;
    }

    /**
     * Gets the value of the contentCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getContentCode() {
        if (contentCode == null) {
            contentCode = new ArrayList<CodeType>();
        }
        return this.contentCode;
    }

    /**
     * Gets the value of the automaticDataCaptureMethodTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the automaticDataCaptureMethodTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutomaticDataCaptureMethodTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AutomaticDataCaptureMethodCodeType }
     * 
     * 
     */
    public List<AutomaticDataCaptureMethodCodeType> getAutomaticDataCaptureMethodTypeCode() {
        if (automaticDataCaptureMethodTypeCode == null) {
            automaticDataCaptureMethodTypeCode = new ArrayList<AutomaticDataCaptureMethodCodeType>();
        }
        return this.automaticDataCaptureMethodTypeCode;
    }

}
