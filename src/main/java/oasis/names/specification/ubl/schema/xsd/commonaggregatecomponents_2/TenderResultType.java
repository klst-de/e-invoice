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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdvertisementAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HigherTenderAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LowerTenderAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedElectronicTenderQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedForeignTenderQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedTenderQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TenderResultCodeType;


/**
 * <p>Java-Klasse für TenderResultType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TenderResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TenderResultCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdvertisementAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AwardDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AwardTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReceivedTenderQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LowerTenderAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HigherTenderAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}StartDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReceivedElectronicTenderQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReceivedForeignTenderQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Contract" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AwardedTenderedProject" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractFormalizationPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SubcontractTerms" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WinningParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TenderResultType", propOrder = {
    "tenderResultCode",
    "description",
    "advertisementAmount",
    "awardDate",
    "awardTime",
    "receivedTenderQuantity",
    "lowerTenderAmount",
    "higherTenderAmount",
    "startDate",
    "receivedElectronicTenderQuantity",
    "receivedForeignTenderQuantity",
    "contract",
    "awardedTenderedProject",
    "contractFormalizationPeriod",
    "subcontractTerms",
    "winningParty"
})
public class TenderResultType {

    @XmlElement(name = "TenderResultCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TenderResultCodeType tenderResultCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "AdvertisementAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AdvertisementAmountType advertisementAmount;
    @XmlElement(name = "AwardDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected AwardDateType awardDate;
    @XmlElement(name = "AwardTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AwardTimeType awardTime;
    @XmlElement(name = "ReceivedTenderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReceivedTenderQuantityType receivedTenderQuantity;
    @XmlElement(name = "LowerTenderAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LowerTenderAmountType lowerTenderAmount;
    @XmlElement(name = "HigherTenderAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HigherTenderAmountType higherTenderAmount;
    @XmlElement(name = "StartDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected StartDateType startDate;
    @XmlElement(name = "ReceivedElectronicTenderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReceivedElectronicTenderQuantityType receivedElectronicTenderQuantity;
    @XmlElement(name = "ReceivedForeignTenderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReceivedForeignTenderQuantityType receivedForeignTenderQuantity;
    @XmlElement(name = "Contract")
    protected ContractType contract;
    @XmlElement(name = "AwardedTenderedProject")
    protected TenderedProjectType awardedTenderedProject;
    @XmlElement(name = "ContractFormalizationPeriod")
    protected PeriodType contractFormalizationPeriod;
    @XmlElement(name = "SubcontractTerms")
    protected List<SubcontractTermsType> subcontractTerms;
    @XmlElement(name = "WinningParty")
    protected List<WinningPartyType> winningParty;

    /**
     * Ruft den Wert der tenderResultCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TenderResultCodeType }
     *     
     */
    public TenderResultCodeType getTenderResultCode() {
        return tenderResultCode;
    }

    /**
     * Legt den Wert der tenderResultCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TenderResultCodeType }
     *     
     */
    public void setTenderResultCode(TenderResultCodeType value) {
        this.tenderResultCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der advertisementAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AdvertisementAmountType }
     *     
     */
    public AdvertisementAmountType getAdvertisementAmount() {
        return advertisementAmount;
    }

    /**
     * Legt den Wert der advertisementAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvertisementAmountType }
     *     
     */
    public void setAdvertisementAmount(AdvertisementAmountType value) {
        this.advertisementAmount = value;
    }

    /**
     * Ruft den Wert der awardDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AwardDateType }
     *     
     */
    public AwardDateType getAwardDate() {
        return awardDate;
    }

    /**
     * Legt den Wert der awardDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardDateType }
     *     
     */
    public void setAwardDate(AwardDateType value) {
        this.awardDate = value;
    }

    /**
     * Ruft den Wert der awardTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AwardTimeType }
     *     
     */
    public AwardTimeType getAwardTime() {
        return awardTime;
    }

    /**
     * Legt den Wert der awardTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardTimeType }
     *     
     */
    public void setAwardTime(AwardTimeType value) {
        this.awardTime = value;
    }

    /**
     * Ruft den Wert der receivedTenderQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReceivedTenderQuantityType }
     *     
     */
    public ReceivedTenderQuantityType getReceivedTenderQuantity() {
        return receivedTenderQuantity;
    }

    /**
     * Legt den Wert der receivedTenderQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivedTenderQuantityType }
     *     
     */
    public void setReceivedTenderQuantity(ReceivedTenderQuantityType value) {
        this.receivedTenderQuantity = value;
    }

    /**
     * Ruft den Wert der lowerTenderAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LowerTenderAmountType }
     *     
     */
    public LowerTenderAmountType getLowerTenderAmount() {
        return lowerTenderAmount;
    }

    /**
     * Legt den Wert der lowerTenderAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LowerTenderAmountType }
     *     
     */
    public void setLowerTenderAmount(LowerTenderAmountType value) {
        this.lowerTenderAmount = value;
    }

    /**
     * Ruft den Wert der higherTenderAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HigherTenderAmountType }
     *     
     */
    public HigherTenderAmountType getHigherTenderAmount() {
        return higherTenderAmount;
    }

    /**
     * Legt den Wert der higherTenderAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HigherTenderAmountType }
     *     
     */
    public void setHigherTenderAmount(HigherTenderAmountType value) {
        this.higherTenderAmount = value;
    }

    /**
     * Ruft den Wert der startDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StartDateType }
     *     
     */
    public StartDateType getStartDate() {
        return startDate;
    }

    /**
     * Legt den Wert der startDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StartDateType }
     *     
     */
    public void setStartDate(StartDateType value) {
        this.startDate = value;
    }

    /**
     * Ruft den Wert der receivedElectronicTenderQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReceivedElectronicTenderQuantityType }
     *     
     */
    public ReceivedElectronicTenderQuantityType getReceivedElectronicTenderQuantity() {
        return receivedElectronicTenderQuantity;
    }

    /**
     * Legt den Wert der receivedElectronicTenderQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivedElectronicTenderQuantityType }
     *     
     */
    public void setReceivedElectronicTenderQuantity(ReceivedElectronicTenderQuantityType value) {
        this.receivedElectronicTenderQuantity = value;
    }

    /**
     * Ruft den Wert der receivedForeignTenderQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReceivedForeignTenderQuantityType }
     *     
     */
    public ReceivedForeignTenderQuantityType getReceivedForeignTenderQuantity() {
        return receivedForeignTenderQuantity;
    }

    /**
     * Legt den Wert der receivedForeignTenderQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivedForeignTenderQuantityType }
     *     
     */
    public void setReceivedForeignTenderQuantity(ReceivedForeignTenderQuantityType value) {
        this.receivedForeignTenderQuantity = value;
    }

    /**
     * Ruft den Wert der contract-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getContract() {
        return contract;
    }

    /**
     * Legt den Wert der contract-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setContract(ContractType value) {
        this.contract = value;
    }

    /**
     * Ruft den Wert der awardedTenderedProject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TenderedProjectType }
     *     
     */
    public TenderedProjectType getAwardedTenderedProject() {
        return awardedTenderedProject;
    }

    /**
     * Legt den Wert der awardedTenderedProject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TenderedProjectType }
     *     
     */
    public void setAwardedTenderedProject(TenderedProjectType value) {
        this.awardedTenderedProject = value;
    }

    /**
     * Ruft den Wert der contractFormalizationPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getContractFormalizationPeriod() {
        return contractFormalizationPeriod;
    }

    /**
     * Legt den Wert der contractFormalizationPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setContractFormalizationPeriod(PeriodType value) {
        this.contractFormalizationPeriod = value;
    }

    /**
     * Gets the value of the subcontractTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subcontractTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubcontractTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubcontractTermsType }
     * 
     * 
     */
    public List<SubcontractTermsType> getSubcontractTerms() {
        if (subcontractTerms == null) {
            subcontractTerms = new ArrayList<SubcontractTermsType>();
        }
        return this.subcontractTerms;
    }

    /**
     * Gets the value of the winningParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the winningParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWinningParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WinningPartyType }
     * 
     * 
     */
    public List<WinningPartyType> getWinningParty() {
        if (winningParty == null) {
            winningParty = new ArrayList<WinningPartyType>();
        }
        return this.winningParty;
    }

}
