//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DirectionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.JourneyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNationalityIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNationalityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TradeServiceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportMeansTypeCodeType;


/**
 * <p>Java-Klasse für TransportMeansType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportMeansType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}JourneyID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationNationalityID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationNationality" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DirectionCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportMeansTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TradeServiceCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Stowage" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AirTransport" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RoadTransport" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RailTransport" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MaritimeTransport" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OwnerParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MeasurementDimension" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportMeansType", propOrder = {
    "journeyID",
    "registrationNationalityID",
    "registrationNationality",
    "directionCode",
    "transportMeansTypeCode",
    "tradeServiceCode",
    "stowage",
    "airTransport",
    "roadTransport",
    "railTransport",
    "maritimeTransport",
    "ownerParty",
    "measurementDimension"
})
public class TransportMeansType {

    @XmlElement(name = "JourneyID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected JourneyIDType journeyID;
    @XmlElement(name = "RegistrationNationalityID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationNationalityIDType registrationNationalityID;
    @XmlElement(name = "RegistrationNationality", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RegistrationNationalityType> registrationNationality;
    @XmlElement(name = "DirectionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DirectionCodeType directionCode;
    @XmlElement(name = "TransportMeansTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportMeansTypeCodeType transportMeansTypeCode;
    @XmlElement(name = "TradeServiceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TradeServiceCodeType tradeServiceCode;
    @XmlElement(name = "Stowage")
    protected StowageType stowage;
    @XmlElement(name = "AirTransport")
    protected AirTransportType airTransport;
    @XmlElement(name = "RoadTransport")
    protected RoadTransportType roadTransport;
    @XmlElement(name = "RailTransport")
    protected RailTransportType railTransport;
    @XmlElement(name = "MaritimeTransport")
    protected MaritimeTransportType maritimeTransport;
    @XmlElement(name = "OwnerParty")
    protected PartyType ownerParty;
    @XmlElement(name = "MeasurementDimension")
    protected List<DimensionType> measurementDimension;

    /**
     * Ruft den Wert der journeyID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JourneyIDType }
     *     
     */
    public JourneyIDType getJourneyID() {
        return journeyID;
    }

    /**
     * Legt den Wert der journeyID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyIDType }
     *     
     */
    public void setJourneyID(JourneyIDType value) {
        this.journeyID = value;
    }

    /**
     * Ruft den Wert der registrationNationalityID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationNationalityIDType }
     *     
     */
    public RegistrationNationalityIDType getRegistrationNationalityID() {
        return registrationNationalityID;
    }

    /**
     * Legt den Wert der registrationNationalityID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationNationalityIDType }
     *     
     */
    public void setRegistrationNationalityID(RegistrationNationalityIDType value) {
        this.registrationNationalityID = value;
    }

    /**
     * Gets the value of the registrationNationality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registrationNationality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistrationNationality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegistrationNationalityType }
     * 
     * 
     */
    public List<RegistrationNationalityType> getRegistrationNationality() {
        if (registrationNationality == null) {
            registrationNationality = new ArrayList<RegistrationNationalityType>();
        }
        return this.registrationNationality;
    }

    /**
     * Ruft den Wert der directionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DirectionCodeType }
     *     
     */
    public DirectionCodeType getDirectionCode() {
        return directionCode;
    }

    /**
     * Legt den Wert der directionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionCodeType }
     *     
     */
    public void setDirectionCode(DirectionCodeType value) {
        this.directionCode = value;
    }

    /**
     * Ruft den Wert der transportMeansTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public TransportMeansTypeCodeType getTransportMeansTypeCode() {
        return transportMeansTypeCode;
    }

    /**
     * Legt den Wert der transportMeansTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public void setTransportMeansTypeCode(TransportMeansTypeCodeType value) {
        this.transportMeansTypeCode = value;
    }

    /**
     * Ruft den Wert der tradeServiceCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TradeServiceCodeType }
     *     
     */
    public TradeServiceCodeType getTradeServiceCode() {
        return tradeServiceCode;
    }

    /**
     * Legt den Wert der tradeServiceCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeServiceCodeType }
     *     
     */
    public void setTradeServiceCode(TradeServiceCodeType value) {
        this.tradeServiceCode = value;
    }

    /**
     * Ruft den Wert der stowage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StowageType }
     *     
     */
    public StowageType getStowage() {
        return stowage;
    }

    /**
     * Legt den Wert der stowage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StowageType }
     *     
     */
    public void setStowage(StowageType value) {
        this.stowage = value;
    }

    /**
     * Ruft den Wert der airTransport-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AirTransportType }
     *     
     */
    public AirTransportType getAirTransport() {
        return airTransport;
    }

    /**
     * Legt den Wert der airTransport-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AirTransportType }
     *     
     */
    public void setAirTransport(AirTransportType value) {
        this.airTransport = value;
    }

    /**
     * Ruft den Wert der roadTransport-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RoadTransportType }
     *     
     */
    public RoadTransportType getRoadTransport() {
        return roadTransport;
    }

    /**
     * Legt den Wert der roadTransport-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RoadTransportType }
     *     
     */
    public void setRoadTransport(RoadTransportType value) {
        this.roadTransport = value;
    }

    /**
     * Ruft den Wert der railTransport-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RailTransportType }
     *     
     */
    public RailTransportType getRailTransport() {
        return railTransport;
    }

    /**
     * Legt den Wert der railTransport-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RailTransportType }
     *     
     */
    public void setRailTransport(RailTransportType value) {
        this.railTransport = value;
    }

    /**
     * Ruft den Wert der maritimeTransport-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaritimeTransportType }
     *     
     */
    public MaritimeTransportType getMaritimeTransport() {
        return maritimeTransport;
    }

    /**
     * Legt den Wert der maritimeTransport-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaritimeTransportType }
     *     
     */
    public void setMaritimeTransport(MaritimeTransportType value) {
        this.maritimeTransport = value;
    }

    /**
     * Ruft den Wert der ownerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOwnerParty() {
        return ownerParty;
    }

    /**
     * Legt den Wert der ownerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOwnerParty(PartyType value) {
        this.ownerParty = value;
    }

    /**
     * Gets the value of the measurementDimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measurementDimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasurementDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionType }
     * 
     * 
     */
    public List<DimensionType> getMeasurementDimension() {
        if (measurementDimension == null) {
            measurementDimension = new ArrayList<DimensionType>();
        }
        return this.measurementDimension;
    }

}
