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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparisonDataSourceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DataSourceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForecastPurposeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForecastTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimeDeltaDaysQuantityType;


/**
 * <p>Java-Klasse für ForecastExceptionCriterionLineType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ForecastExceptionCriterionLineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForecastPurposeCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForecastTypeCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ComparisonDataSourceCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DataSourceCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimeDeltaDaysQuantity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForecastExceptionCriterionLineType", propOrder = {
    "forecastPurposeCode",
    "forecastTypeCode",
    "comparisonDataSourceCode",
    "dataSourceCode",
    "timeDeltaDaysQuantity"
})
public class ForecastExceptionCriterionLineType {

    @XmlElement(name = "ForecastPurposeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ForecastPurposeCodeType forecastPurposeCode;
    @XmlElement(name = "ForecastTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ForecastTypeCodeType forecastTypeCode;
    @XmlElement(name = "ComparisonDataSourceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ComparisonDataSourceCodeType comparisonDataSourceCode;
    @XmlElement(name = "DataSourceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected DataSourceCodeType dataSourceCode;
    @XmlElement(name = "TimeDeltaDaysQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimeDeltaDaysQuantityType timeDeltaDaysQuantity;

    /**
     * Ruft den Wert der forecastPurposeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ForecastPurposeCodeType }
     *     
     */
    public ForecastPurposeCodeType getForecastPurposeCode() {
        return forecastPurposeCode;
    }

    /**
     * Legt den Wert der forecastPurposeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastPurposeCodeType }
     *     
     */
    public void setForecastPurposeCode(ForecastPurposeCodeType value) {
        this.forecastPurposeCode = value;
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
     * Ruft den Wert der comparisonDataSourceCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ComparisonDataSourceCodeType }
     *     
     */
    public ComparisonDataSourceCodeType getComparisonDataSourceCode() {
        return comparisonDataSourceCode;
    }

    /**
     * Legt den Wert der comparisonDataSourceCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ComparisonDataSourceCodeType }
     *     
     */
    public void setComparisonDataSourceCode(ComparisonDataSourceCodeType value) {
        this.comparisonDataSourceCode = value;
    }

    /**
     * Ruft den Wert der dataSourceCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataSourceCodeType }
     *     
     */
    public DataSourceCodeType getDataSourceCode() {
        return dataSourceCode;
    }

    /**
     * Legt den Wert der dataSourceCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSourceCodeType }
     *     
     */
    public void setDataSourceCode(DataSourceCodeType value) {
        this.dataSourceCode = value;
    }

    /**
     * Ruft den Wert der timeDeltaDaysQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TimeDeltaDaysQuantityType }
     *     
     */
    public TimeDeltaDaysQuantityType getTimeDeltaDaysQuantity() {
        return timeDeltaDaysQuantity;
    }

    /**
     * Legt den Wert der timeDeltaDaysQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeDeltaDaysQuantityType }
     *     
     */
    public void setTimeDeltaDaysQuantity(TimeDeltaDaysQuantityType value) {
        this.timeDeltaDaysQuantity = value;
    }

}
