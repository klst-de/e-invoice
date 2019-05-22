//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für WorkItemQuantityAnalysisType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WorkItemQuantityAnalysisType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType"/&gt;
 *         &lt;element name="ActualQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/&gt;
 *         &lt;element name="ActualQuantityPercent" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}PercentType" minOccurs="0"/&gt;
 *         &lt;element name="StatusCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="PrimaryClassificationCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AlternativeClassificationCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ContractualLanguageCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ActualQuantityWorkItemDimension" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}WorkItemDimensionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="BreakdownWorkItemQuantityAnalysis" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}WorkItemQuantityAnalysisType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ChangedRecordedStatus" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}RecordedStatusType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkItemQuantityAnalysisType", propOrder = {
    "id",
    "actualQuantity",
    "description",
    "actualQuantityPercent",
    "statusCode",
    "typeCode",
    "primaryClassificationCode",
    "alternativeClassificationCode",
    "contractualLanguageCode",
    "actualQuantityWorkItemDimension",
    "breakdownWorkItemQuantityAnalysis",
    "changedRecordedStatus"
})
public class WorkItemQuantityAnalysisType {

    @XmlElement(name = "ID", required = true)
    protected IDType id;
    @XmlElement(name = "ActualQuantity")
    protected QuantityType actualQuantity;
    @XmlElement(name = "Description")
    protected TextType description;
    @XmlElement(name = "ActualQuantityPercent")
    protected PercentType actualQuantityPercent;
    @XmlElement(name = "StatusCode")
    protected CodeType statusCode;
    @XmlElement(name = "TypeCode")
    protected CodeType typeCode;
    @XmlElement(name = "PrimaryClassificationCode")
    protected List<CodeType> primaryClassificationCode;
    @XmlElement(name = "AlternativeClassificationCode")
    protected List<CodeType> alternativeClassificationCode;
    @XmlElement(name = "ContractualLanguageCode")
    protected CodeType contractualLanguageCode;
    @XmlElement(name = "ActualQuantityWorkItemDimension")
    protected List<WorkItemDimensionType> actualQuantityWorkItemDimension;
    @XmlElement(name = "BreakdownWorkItemQuantityAnalysis")
    protected List<WorkItemQuantityAnalysisType> breakdownWorkItemQuantityAnalysis;
    @XmlElement(name = "ChangedRecordedStatus")
    protected List<RecordedStatusType> changedRecordedStatus;

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
     * Ruft den Wert der actualQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getActualQuantity() {
        return actualQuantity;
    }

    /**
     * Legt den Wert der actualQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setActualQuantity(QuantityType value) {
        this.actualQuantity = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDescription(TextType value) {
        this.description = value;
    }

    /**
     * Ruft den Wert der actualQuantityPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PercentType }
     *     
     */
    public PercentType getActualQuantityPercent() {
        return actualQuantityPercent;
    }

    /**
     * Legt den Wert der actualQuantityPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PercentType }
     *     
     */
    public void setActualQuantityPercent(PercentType value) {
        this.actualQuantityPercent = value;
    }

    /**
     * Ruft den Wert der statusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getStatusCode() {
        return statusCode;
    }

    /**
     * Legt den Wert der statusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setStatusCode(CodeType value) {
        this.statusCode = value;
    }

    /**
     * Ruft den Wert der typeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getTypeCode() {
        return typeCode;
    }

    /**
     * Legt den Wert der typeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setTypeCode(CodeType value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the primaryClassificationCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the primaryClassificationCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrimaryClassificationCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getPrimaryClassificationCode() {
        if (primaryClassificationCode == null) {
            primaryClassificationCode = new ArrayList<CodeType>();
        }
        return this.primaryClassificationCode;
    }

    /**
     * Gets the value of the alternativeClassificationCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternativeClassificationCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternativeClassificationCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getAlternativeClassificationCode() {
        if (alternativeClassificationCode == null) {
            alternativeClassificationCode = new ArrayList<CodeType>();
        }
        return this.alternativeClassificationCode;
    }

    /**
     * Ruft den Wert der contractualLanguageCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getContractualLanguageCode() {
        return contractualLanguageCode;
    }

    /**
     * Legt den Wert der contractualLanguageCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setContractualLanguageCode(CodeType value) {
        this.contractualLanguageCode = value;
    }

    /**
     * Gets the value of the actualQuantityWorkItemDimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actualQuantityWorkItemDimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActualQuantityWorkItemDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkItemDimensionType }
     * 
     * 
     */
    public List<WorkItemDimensionType> getActualQuantityWorkItemDimension() {
        if (actualQuantityWorkItemDimension == null) {
            actualQuantityWorkItemDimension = new ArrayList<WorkItemDimensionType>();
        }
        return this.actualQuantityWorkItemDimension;
    }

    /**
     * Gets the value of the breakdownWorkItemQuantityAnalysis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the breakdownWorkItemQuantityAnalysis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBreakdownWorkItemQuantityAnalysis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkItemQuantityAnalysisType }
     * 
     * 
     */
    public List<WorkItemQuantityAnalysisType> getBreakdownWorkItemQuantityAnalysis() {
        if (breakdownWorkItemQuantityAnalysis == null) {
            breakdownWorkItemQuantityAnalysis = new ArrayList<WorkItemQuantityAnalysisType>();
        }
        return this.breakdownWorkItemQuantityAnalysis;
    }

    /**
     * Gets the value of the changedRecordedStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changedRecordedStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangedRecordedStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordedStatusType }
     * 
     * 
     */
    public List<RecordedStatusType> getChangedRecordedStatus() {
        if (changedRecordedStatus == null) {
            changedRecordedStatus = new ArrayList<RecordedStatusType>();
        }
        return this.changedRecordedStatus;
    }

}
