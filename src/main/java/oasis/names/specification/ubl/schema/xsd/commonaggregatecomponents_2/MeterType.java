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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterConstantCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterConstantType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterNumberType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalDeliveredQuantityType;


/**
 * <p>Java-Klasse für MeterType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MeterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterConstant" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterConstantCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TotalDeliveredQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeterReading" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeterProperty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterType", propOrder = {
    "meterNumber",
    "meterName",
    "meterConstant",
    "meterConstantCode",
    "totalDeliveredQuantity",
    "meterReading",
    "meterProperty"
})
public class MeterType {

    @XmlElement(name = "MeterNumber", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterNumberType meterNumber;
    @XmlElement(name = "MeterName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterNameType meterName;
    @XmlElement(name = "MeterConstant", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterConstantType meterConstant;
    @XmlElement(name = "MeterConstantCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterConstantCodeType meterConstantCode;
    @XmlElement(name = "TotalDeliveredQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TotalDeliveredQuantityType totalDeliveredQuantity;
    @XmlElement(name = "MeterReading")
    protected List<MeterReadingType> meterReading;
    @XmlElement(name = "MeterProperty")
    protected List<MeterPropertyType> meterProperty;

    /**
     * Ruft den Wert der meterNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeterNumberType }
     *     
     */
    public MeterNumberType getMeterNumber() {
        return meterNumber;
    }

    /**
     * Legt den Wert der meterNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterNumberType }
     *     
     */
    public void setMeterNumber(MeterNumberType value) {
        this.meterNumber = value;
    }

    /**
     * Ruft den Wert der meterName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeterNameType }
     *     
     */
    public MeterNameType getMeterName() {
        return meterName;
    }

    /**
     * Legt den Wert der meterName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterNameType }
     *     
     */
    public void setMeterName(MeterNameType value) {
        this.meterName = value;
    }

    /**
     * Ruft den Wert der meterConstant-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeterConstantType }
     *     
     */
    public MeterConstantType getMeterConstant() {
        return meterConstant;
    }

    /**
     * Legt den Wert der meterConstant-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterConstantType }
     *     
     */
    public void setMeterConstant(MeterConstantType value) {
        this.meterConstant = value;
    }

    /**
     * Ruft den Wert der meterConstantCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeterConstantCodeType }
     *     
     */
    public MeterConstantCodeType getMeterConstantCode() {
        return meterConstantCode;
    }

    /**
     * Legt den Wert der meterConstantCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterConstantCodeType }
     *     
     */
    public void setMeterConstantCode(MeterConstantCodeType value) {
        this.meterConstantCode = value;
    }

    /**
     * Ruft den Wert der totalDeliveredQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TotalDeliveredQuantityType }
     *     
     */
    public TotalDeliveredQuantityType getTotalDeliveredQuantity() {
        return totalDeliveredQuantity;
    }

    /**
     * Legt den Wert der totalDeliveredQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalDeliveredQuantityType }
     *     
     */
    public void setTotalDeliveredQuantity(TotalDeliveredQuantityType value) {
        this.totalDeliveredQuantity = value;
    }

    /**
     * Gets the value of the meterReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meterReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeterReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeterReadingType }
     * 
     * 
     */
    public List<MeterReadingType> getMeterReading() {
        if (meterReading == null) {
            meterReading = new ArrayList<MeterReadingType>();
        }
        return this.meterReading;
    }

    /**
     * Gets the value of the meterProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meterProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeterProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeterPropertyType }
     * 
     * 
     */
    public List<MeterPropertyType> getMeterProperty() {
        if (meterProperty == null) {
            meterProperty = new ArrayList<MeterPropertyType>();
        }
        return this.meterProperty;
    }

}
