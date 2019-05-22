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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalInformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CategoryNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EmergencyProceduresCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardClassIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousCategoryCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LowerOrangeHazardPlacardIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkingIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MedicalFirstAidGuideCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlacardEndorsementType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlacardNotationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TechnicalNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UNDGCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UpperOrangeHazardPlacardIDType;


/**
 * <p>Java-Klasse für HazardousItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HazardousItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PlacardNotation" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PlacardEndorsement" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UNDGCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EmergencyProceduresCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MedicalFirstAidGuideCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TechnicalName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CategoryName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousCategoryCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UpperOrangeHazardPlacardID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LowerOrangeHazardPlacardID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkingID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardClassID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetWeightMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetVolumeMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContactParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SecondaryHazard" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HazardousGoodsTransit" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EmergencyTemperature" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FlashpointTemperature" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalTemperature" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HazardousItemType", propOrder = {
    "id",
    "placardNotation",
    "placardEndorsement",
    "additionalInformation",
    "undgCode",
    "emergencyProceduresCode",
    "medicalFirstAidGuideCode",
    "technicalName",
    "categoryName",
    "hazardousCategoryCode",
    "upperOrangeHazardPlacardID",
    "lowerOrangeHazardPlacardID",
    "markingID",
    "hazardClassID",
    "netWeightMeasure",
    "netVolumeMeasure",
    "quantity",
    "contactParty",
    "secondaryHazard",
    "hazardousGoodsTransit",
    "emergencyTemperature",
    "flashpointTemperature",
    "additionalTemperature"
})
public class HazardousItemType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "PlacardNotation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PlacardNotationType placardNotation;
    @XmlElement(name = "PlacardEndorsement", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PlacardEndorsementType placardEndorsement;
    @XmlElement(name = "AdditionalInformation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<AdditionalInformationType> additionalInformation;
    @XmlElement(name = "UNDGCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UNDGCodeType undgCode;
    @XmlElement(name = "EmergencyProceduresCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EmergencyProceduresCodeType emergencyProceduresCode;
    @XmlElement(name = "MedicalFirstAidGuideCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MedicalFirstAidGuideCodeType medicalFirstAidGuideCode;
    @XmlElement(name = "TechnicalName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TechnicalNameType technicalName;
    @XmlElement(name = "CategoryName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CategoryNameType categoryName;
    @XmlElement(name = "HazardousCategoryCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousCategoryCodeType hazardousCategoryCode;
    @XmlElement(name = "UpperOrangeHazardPlacardID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UpperOrangeHazardPlacardIDType upperOrangeHazardPlacardID;
    @XmlElement(name = "LowerOrangeHazardPlacardID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LowerOrangeHazardPlacardIDType lowerOrangeHazardPlacardID;
    @XmlElement(name = "MarkingID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkingIDType markingID;
    @XmlElement(name = "HazardClassID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardClassIDType hazardClassID;
    @XmlElement(name = "NetWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetWeightMeasureType netWeightMeasure;
    @XmlElement(name = "NetVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetVolumeMeasureType netVolumeMeasure;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "ContactParty")
    protected PartyType contactParty;
    @XmlElement(name = "SecondaryHazard")
    protected List<SecondaryHazardType> secondaryHazard;
    @XmlElement(name = "HazardousGoodsTransit")
    protected List<HazardousGoodsTransitType> hazardousGoodsTransit;
    @XmlElement(name = "EmergencyTemperature")
    protected TemperatureType emergencyTemperature;
    @XmlElement(name = "FlashpointTemperature")
    protected TemperatureType flashpointTemperature;
    @XmlElement(name = "AdditionalTemperature")
    protected List<TemperatureType> additionalTemperature;

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
     * Ruft den Wert der placardNotation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PlacardNotationType }
     *     
     */
    public PlacardNotationType getPlacardNotation() {
        return placardNotation;
    }

    /**
     * Legt den Wert der placardNotation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacardNotationType }
     *     
     */
    public void setPlacardNotation(PlacardNotationType value) {
        this.placardNotation = value;
    }

    /**
     * Ruft den Wert der placardEndorsement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PlacardEndorsementType }
     *     
     */
    public PlacardEndorsementType getPlacardEndorsement() {
        return placardEndorsement;
    }

    /**
     * Legt den Wert der placardEndorsement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacardEndorsementType }
     *     
     */
    public void setPlacardEndorsement(PlacardEndorsementType value) {
        this.placardEndorsement = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalInformationType }
     * 
     * 
     */
    public List<AdditionalInformationType> getAdditionalInformation() {
        if (additionalInformation == null) {
            additionalInformation = new ArrayList<AdditionalInformationType>();
        }
        return this.additionalInformation;
    }

    /**
     * Ruft den Wert der undgCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UNDGCodeType }
     *     
     */
    public UNDGCodeType getUNDGCode() {
        return undgCode;
    }

    /**
     * Legt den Wert der undgCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UNDGCodeType }
     *     
     */
    public void setUNDGCode(UNDGCodeType value) {
        this.undgCode = value;
    }

    /**
     * Ruft den Wert der emergencyProceduresCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EmergencyProceduresCodeType }
     *     
     */
    public EmergencyProceduresCodeType getEmergencyProceduresCode() {
        return emergencyProceduresCode;
    }

    /**
     * Legt den Wert der emergencyProceduresCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EmergencyProceduresCodeType }
     *     
     */
    public void setEmergencyProceduresCode(EmergencyProceduresCodeType value) {
        this.emergencyProceduresCode = value;
    }

    /**
     * Ruft den Wert der medicalFirstAidGuideCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MedicalFirstAidGuideCodeType }
     *     
     */
    public MedicalFirstAidGuideCodeType getMedicalFirstAidGuideCode() {
        return medicalFirstAidGuideCode;
    }

    /**
     * Legt den Wert der medicalFirstAidGuideCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MedicalFirstAidGuideCodeType }
     *     
     */
    public void setMedicalFirstAidGuideCode(MedicalFirstAidGuideCodeType value) {
        this.medicalFirstAidGuideCode = value;
    }

    /**
     * Ruft den Wert der technicalName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalNameType }
     *     
     */
    public TechnicalNameType getTechnicalName() {
        return technicalName;
    }

    /**
     * Legt den Wert der technicalName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalNameType }
     *     
     */
    public void setTechnicalName(TechnicalNameType value) {
        this.technicalName = value;
    }

    /**
     * Ruft den Wert der categoryName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CategoryNameType }
     *     
     */
    public CategoryNameType getCategoryName() {
        return categoryName;
    }

    /**
     * Legt den Wert der categoryName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryNameType }
     *     
     */
    public void setCategoryName(CategoryNameType value) {
        this.categoryName = value;
    }

    /**
     * Ruft den Wert der hazardousCategoryCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCategoryCodeType }
     *     
     */
    public HazardousCategoryCodeType getHazardousCategoryCode() {
        return hazardousCategoryCode;
    }

    /**
     * Legt den Wert der hazardousCategoryCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCategoryCodeType }
     *     
     */
    public void setHazardousCategoryCode(HazardousCategoryCodeType value) {
        this.hazardousCategoryCode = value;
    }

    /**
     * Ruft den Wert der upperOrangeHazardPlacardID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UpperOrangeHazardPlacardIDType }
     *     
     */
    public UpperOrangeHazardPlacardIDType getUpperOrangeHazardPlacardID() {
        return upperOrangeHazardPlacardID;
    }

    /**
     * Legt den Wert der upperOrangeHazardPlacardID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UpperOrangeHazardPlacardIDType }
     *     
     */
    public void setUpperOrangeHazardPlacardID(UpperOrangeHazardPlacardIDType value) {
        this.upperOrangeHazardPlacardID = value;
    }

    /**
     * Ruft den Wert der lowerOrangeHazardPlacardID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LowerOrangeHazardPlacardIDType }
     *     
     */
    public LowerOrangeHazardPlacardIDType getLowerOrangeHazardPlacardID() {
        return lowerOrangeHazardPlacardID;
    }

    /**
     * Legt den Wert der lowerOrangeHazardPlacardID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LowerOrangeHazardPlacardIDType }
     *     
     */
    public void setLowerOrangeHazardPlacardID(LowerOrangeHazardPlacardIDType value) {
        this.lowerOrangeHazardPlacardID = value;
    }

    /**
     * Ruft den Wert der markingID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MarkingIDType }
     *     
     */
    public MarkingIDType getMarkingID() {
        return markingID;
    }

    /**
     * Legt den Wert der markingID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkingIDType }
     *     
     */
    public void setMarkingID(MarkingIDType value) {
        this.markingID = value;
    }

    /**
     * Ruft den Wert der hazardClassID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HazardClassIDType }
     *     
     */
    public HazardClassIDType getHazardClassID() {
        return hazardClassID;
    }

    /**
     * Legt den Wert der hazardClassID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardClassIDType }
     *     
     */
    public void setHazardClassID(HazardClassIDType value) {
        this.hazardClassID = value;
    }

    /**
     * Ruft den Wert der netWeightMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public NetWeightMeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    /**
     * Legt den Wert der netWeightMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public void setNetWeightMeasure(NetWeightMeasureType value) {
        this.netWeightMeasure = value;
    }

    /**
     * Ruft den Wert der netVolumeMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public NetVolumeMeasureType getNetVolumeMeasure() {
        return netVolumeMeasure;
    }

    /**
     * Legt den Wert der netVolumeMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public void setNetVolumeMeasure(NetVolumeMeasureType value) {
        this.netVolumeMeasure = value;
    }

    /**
     * Ruft den Wert der quantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Legt den Wert der quantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * Ruft den Wert der contactParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getContactParty() {
        return contactParty;
    }

    /**
     * Legt den Wert der contactParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setContactParty(PartyType value) {
        this.contactParty = value;
    }

    /**
     * Gets the value of the secondaryHazard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the secondaryHazard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecondaryHazard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecondaryHazardType }
     * 
     * 
     */
    public List<SecondaryHazardType> getSecondaryHazard() {
        if (secondaryHazard == null) {
            secondaryHazard = new ArrayList<SecondaryHazardType>();
        }
        return this.secondaryHazard;
    }

    /**
     * Gets the value of the hazardousGoodsTransit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hazardousGoodsTransit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHazardousGoodsTransit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousGoodsTransitType }
     * 
     * 
     */
    public List<HazardousGoodsTransitType> getHazardousGoodsTransit() {
        if (hazardousGoodsTransit == null) {
            hazardousGoodsTransit = new ArrayList<HazardousGoodsTransitType>();
        }
        return this.hazardousGoodsTransit;
    }

    /**
     * Ruft den Wert der emergencyTemperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getEmergencyTemperature() {
        return emergencyTemperature;
    }

    /**
     * Legt den Wert der emergencyTemperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setEmergencyTemperature(TemperatureType value) {
        this.emergencyTemperature = value;
    }

    /**
     * Ruft den Wert der flashpointTemperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getFlashpointTemperature() {
        return flashpointTemperature;
    }

    /**
     * Legt den Wert der flashpointTemperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setFlashpointTemperature(TemperatureType value) {
        this.flashpointTemperature = value;
    }

    /**
     * Gets the value of the additionalTemperature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalTemperature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalTemperature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TemperatureType }
     * 
     * 
     */
    public List<TemperatureType> getAdditionalTemperature() {
        if (additionalTemperature == null) {
            additionalTemperature = new ArrayList<TemperatureType>();
        }
        return this.additionalTemperature;
    }

}
