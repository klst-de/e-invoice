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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForecastTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FrozenDocumentIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;


/**
 * <p>Java-Klasse für ForecastLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ForecastLineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FrozenDocumentIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForecastTypeCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ForecastPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SalesItem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForecastLineType", propOrder = {
    "id",
    "note",
    "frozenDocumentIndicator",
    "forecastTypeCode",
    "forecastPeriod",
    "salesItem"
})
public class ForecastLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "FrozenDocumentIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FrozenDocumentIndicatorType frozenDocumentIndicator;
    @XmlElement(name = "ForecastTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ForecastTypeCodeType forecastTypeCode;
    @XmlElement(name = "ForecastPeriod")
    protected PeriodType forecastPeriod;
    @XmlElement(name = "SalesItem")
    protected SalesItemType salesItem;

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
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Ruft den Wert der frozenDocumentIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FrozenDocumentIndicatorType }
     *     
     */
    public FrozenDocumentIndicatorType getFrozenDocumentIndicator() {
        return frozenDocumentIndicator;
    }

    /**
     * Legt den Wert der frozenDocumentIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FrozenDocumentIndicatorType }
     *     
     */
    public void setFrozenDocumentIndicator(FrozenDocumentIndicatorType value) {
        this.frozenDocumentIndicator = value;
    }

    /**
     * Ruft den Wert der forecastTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ForecastTypeCodeType }
     *     
     */
    public ForecastTypeCodeType getForecastTypeCode() {
        return forecastTypeCode;
    }

    /**
     * Legt den Wert der forecastTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastTypeCodeType }
     *     
     */
    public void setForecastTypeCode(ForecastTypeCodeType value) {
        this.forecastTypeCode = value;
    }

    /**
     * Ruft den Wert der forecastPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getForecastPeriod() {
        return forecastPeriod;
    }

    /**
     * Legt den Wert der forecastPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setForecastPeriod(PeriodType value) {
        this.forecastPeriod = value;
    }

    /**
     * Ruft den Wert der salesItem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SalesItemType }
     *     
     */
    public SalesItemType getSalesItem() {
        return salesItem;
    }

    /**
     * Legt den Wert der salesItem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesItemType }
     *     
     */
    public void setSalesItem(SalesItemType value) {
        this.salesItem = value;
    }

}
