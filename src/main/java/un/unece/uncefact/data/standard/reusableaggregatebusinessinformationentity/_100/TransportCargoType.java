//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.CargoCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.CargoCommodityCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.CargoOperationalCategoryCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für TransportCargoType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportCargoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CargoCategoryCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Identification" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="OperationalCategoryCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CargoOperationalCategoryCodeType" minOccurs="0"/&gt;
 *         &lt;element name="StatisticalClassificationCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CargoCommodityCategoryCodeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportCargoType", propOrder = {
    "typeCode",
    "identification",
    "operationalCategoryCode",
    "statisticalClassificationCode"
})
public class TransportCargoType {

    @XmlElement(name = "TypeCode")
    protected CargoCategoryCodeType typeCode;
    @XmlElement(name = "Identification")
    protected TextType identification;
    @XmlElement(name = "OperationalCategoryCode")
    protected CargoOperationalCategoryCodeType operationalCategoryCode;
    @XmlElement(name = "StatisticalClassificationCode")
    protected CargoCommodityCategoryCodeType statisticalClassificationCode;

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CargoCategoryCodeType }
     *     
     */
    public CargoCategoryCodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CargoCategoryCodeType }
     *     
     */
    public void setTypeCode(CargoCategoryCodeType value) {
        this.typeCode = value;
    }

    /**
     * Ruft den Wert der identification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getIdentification() {
        return identification;
    }

    /**
     * Legt den Wert der identification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setIdentification(TextType value) {
        this.identification = value;
    }

    /**
     * Ruft den Wert der operationalCategoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CargoOperationalCategoryCodeType }
     *     
     */
    public CargoOperationalCategoryCodeType getOperationalCategoryCode() {
        return operationalCategoryCode;
    }

    /**
     * Legt den Wert der operationalCategoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CargoOperationalCategoryCodeType }
     *     
     */
    public void setOperationalCategoryCode(CargoOperationalCategoryCodeType value) {
        this.operationalCategoryCode = value;
    }

    /**
     * Ruft den Wert der statisticalClassificationCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CargoCommodityCategoryCodeType }
     *     
     */
    public CargoCommodityCategoryCodeType getStatisticalClassificationCode() {
        return statisticalClassificationCode;
    }

    /**
     * Legt den Wert der statisticalClassificationCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CargoCommodityCategoryCodeType }
     *     
     */
    public void setStatisticalClassificationCode(CargoCommodityCategoryCodeType value) {
        this.statisticalClassificationCode = value;
    }

}
