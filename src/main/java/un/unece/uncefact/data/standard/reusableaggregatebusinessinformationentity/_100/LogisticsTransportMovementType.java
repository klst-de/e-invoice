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
import un.unece.uncefact.data.standard.qualifieddatatype._100.TransportModeCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TransportMovementStageCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für LogisticsTransportMovementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LogisticsTransportMovementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StageCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TransportMovementStageCodeType" minOccurs="0"/>
 *         &lt;element name="ModeCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}TransportModeCodeType" minOccurs="0"/>
 *         &lt;element name="Mode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="UsedLogisticsTransportMeans" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LogisticsTransportMeansType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogisticsTransportMovementType", propOrder = {
    "stageCode",
    "modeCode",
    "mode",
    "usedLogisticsTransportMeans"
})
public class LogisticsTransportMovementType {

    @XmlElement(name = "StageCode")
    protected TransportMovementStageCodeType stageCode;
    @XmlElement(name = "ModeCode")
    protected TransportModeCodeType modeCode;
    @XmlElement(name = "Mode")
    protected TextType mode;
    @XmlElement(name = "UsedLogisticsTransportMeans")
    protected LogisticsTransportMeansType usedLogisticsTransportMeans;

    /**
     * Ruft den Wert der stageCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportMovementStageCodeType }
     *     
     */
    public TransportMovementStageCodeType getStageCode() {
        return stageCode;
    }

    /**
     * Legt den Wert der stageCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMovementStageCodeType }
     *     
     */
    public void setStageCode(TransportMovementStageCodeType value) {
        this.stageCode = value;
    }

    /**
     * Ruft den Wert der modeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportModeCodeType }
     *     
     */
    public TransportModeCodeType getModeCode() {
        return modeCode;
    }

    /**
     * Legt den Wert der modeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportModeCodeType }
     *     
     */
    public void setModeCode(TransportModeCodeType value) {
        this.modeCode = value;
    }

    /**
     * Ruft den Wert der mode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getMode() {
        return mode;
    }

    /**
     * Legt den Wert der mode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setMode(TextType value) {
        this.mode = value;
    }

    /**
     * Ruft den Wert der usedLogisticsTransportMeans-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LogisticsTransportMeansType }
     *     
     */
    public LogisticsTransportMeansType getUsedLogisticsTransportMeans() {
        return usedLogisticsTransportMeans;
    }

    /**
     * Legt den Wert der usedLogisticsTransportMeans-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LogisticsTransportMeansType }
     *     
     */
    public void setUsedLogisticsTransportMeans(LogisticsTransportMeansType value) {
        this.usedLogisticsTransportMeans = value;
    }

}
