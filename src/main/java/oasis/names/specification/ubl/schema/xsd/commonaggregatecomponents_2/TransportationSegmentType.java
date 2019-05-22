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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportExecutionPlanReferenceIDType;


/**
 * <p>Java-Klasse für TransportationSegmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportationSegmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceNumeric"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportExecutionPlanReferenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportationService"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportServiceProviderParty"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReferencedConsignment" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShipmentStage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportationSegmentType", propOrder = {
    "sequenceNumeric",
    "transportExecutionPlanReferenceID",
    "transportationService",
    "transportServiceProviderParty",
    "referencedConsignment",
    "shipmentStage"
})
public class TransportationSegmentType {

    @XmlElement(name = "SequenceNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected SequenceNumericType sequenceNumeric;
    @XmlElement(name = "TransportExecutionPlanReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportExecutionPlanReferenceIDType transportExecutionPlanReferenceID;
    @XmlElement(name = "TransportationService", required = true)
    protected TransportationServiceType transportationService;
    @XmlElement(name = "TransportServiceProviderParty", required = true)
    protected PartyType transportServiceProviderParty;
    @XmlElement(name = "ReferencedConsignment")
    protected ConsignmentType referencedConsignment;
    @XmlElement(name = "ShipmentStage")
    protected List<ShipmentStageType> shipmentStage;

    /**
     * Ruft den Wert der sequenceNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SequenceNumericType }
     *     
     */
    public SequenceNumericType getSequenceNumeric() {
        return sequenceNumeric;
    }

    /**
     * Legt den Wert der sequenceNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceNumericType }
     *     
     */
    public void setSequenceNumeric(SequenceNumericType value) {
        this.sequenceNumeric = value;
    }

    /**
     * Ruft den Wert der transportExecutionPlanReferenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportExecutionPlanReferenceIDType }
     *     
     */
    public TransportExecutionPlanReferenceIDType getTransportExecutionPlanReferenceID() {
        return transportExecutionPlanReferenceID;
    }

    /**
     * Legt den Wert der transportExecutionPlanReferenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportExecutionPlanReferenceIDType }
     *     
     */
    public void setTransportExecutionPlanReferenceID(TransportExecutionPlanReferenceIDType value) {
        this.transportExecutionPlanReferenceID = value;
    }

    /**
     * Ruft den Wert der transportationService-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceType }
     *     
     */
    public TransportationServiceType getTransportationService() {
        return transportationService;
    }

    /**
     * Legt den Wert der transportationService-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceType }
     *     
     */
    public void setTransportationService(TransportationServiceType value) {
        this.transportationService = value;
    }

    /**
     * Ruft den Wert der transportServiceProviderParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTransportServiceProviderParty() {
        return transportServiceProviderParty;
    }

    /**
     * Legt den Wert der transportServiceProviderParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTransportServiceProviderParty(PartyType value) {
        this.transportServiceProviderParty = value;
    }

    /**
     * Ruft den Wert der referencedConsignment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConsignmentType }
     *     
     */
    public ConsignmentType getReferencedConsignment() {
        return referencedConsignment;
    }

    /**
     * Legt den Wert der referencedConsignment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsignmentType }
     *     
     */
    public void setReferencedConsignment(ConsignmentType value) {
        this.referencedConsignment = value;
    }

    /**
     * Gets the value of the shipmentStage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentStage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentStage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentStageType }
     * 
     * 
     */
    public List<ShipmentStageType> getShipmentStage() {
        if (shipmentStage == null) {
            shipmentStage = new ArrayList<ShipmentStageType>();
        }
        return this.shipmentStage;
    }

}
