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


/**
 * <p>Java-Klasse für EnergyWaterSupplyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EnergyWaterSupplyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsumptionReport" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnergyTaxReport" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsumptionAverage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnergyWaterConsumptionCorrection" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyWaterSupplyType", propOrder = {
    "consumptionReport",
    "energyTaxReport",
    "consumptionAverage",
    "energyWaterConsumptionCorrection"
})
public class EnergyWaterSupplyType {

    @XmlElement(name = "ConsumptionReport")
    protected List<ConsumptionReportType> consumptionReport;
    @XmlElement(name = "EnergyTaxReport")
    protected List<EnergyTaxReportType> energyTaxReport;
    @XmlElement(name = "ConsumptionAverage")
    protected List<ConsumptionAverageType> consumptionAverage;
    @XmlElement(name = "EnergyWaterConsumptionCorrection")
    protected List<ConsumptionCorrectionType> energyWaterConsumptionCorrection;

    /**
     * Gets the value of the consumptionReport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionReport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionReportType }
     * 
     * 
     */
    public List<ConsumptionReportType> getConsumptionReport() {
        if (consumptionReport == null) {
            consumptionReport = new ArrayList<ConsumptionReportType>();
        }
        return this.consumptionReport;
    }

    /**
     * Gets the value of the energyTaxReport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the energyTaxReport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnergyTaxReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnergyTaxReportType }
     * 
     * 
     */
    public List<EnergyTaxReportType> getEnergyTaxReport() {
        if (energyTaxReport == null) {
            energyTaxReport = new ArrayList<EnergyTaxReportType>();
        }
        return this.energyTaxReport;
    }

    /**
     * Gets the value of the consumptionAverage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionAverage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionAverage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionAverageType }
     * 
     * 
     */
    public List<ConsumptionAverageType> getConsumptionAverage() {
        if (consumptionAverage == null) {
            consumptionAverage = new ArrayList<ConsumptionAverageType>();
        }
        return this.consumptionAverage;
    }

    /**
     * Gets the value of the energyWaterConsumptionCorrection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the energyWaterConsumptionCorrection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnergyWaterConsumptionCorrection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionCorrectionType }
     * 
     * 
     */
    public List<ConsumptionCorrectionType> getEnergyWaterConsumptionCorrection() {
        if (energyWaterConsumptionCorrection == null) {
            energyWaterConsumptionCorrection = new ArrayList<ConsumptionCorrectionType>();
        }
        return this.energyWaterConsumptionCorrection;
    }

}
