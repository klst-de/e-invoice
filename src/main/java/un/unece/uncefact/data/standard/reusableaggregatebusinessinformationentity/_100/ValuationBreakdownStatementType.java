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
import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für ValuationBreakdownStatementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ValuationBreakdownStatementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType"/&gt;
 *         &lt;element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType"/&gt;
 *         &lt;element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="MeasurementMethodID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CreationDateTime" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}DateTimeType"/&gt;
 *         &lt;element name="DefaultCurrencyCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}CurrencyCodeType"/&gt;
 *         &lt;element name="DefaultLanguageCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType"/&gt;
 *         &lt;element name="Comment" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RequestedActionCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PriceListID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="ContractualLanguageCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ItemGroupedWorkItem" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}GroupedWorkItemType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemBasicWorkItem" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}BasicWorkItemType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TotalCalculatedPrice" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}CalculatedPriceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ChangedRecordedStatus" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}RecordedStatusType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CreationSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ReaderSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ReferencedSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValuationBreakdownStatementType", propOrder = {
    "id",
    "name",
    "description",
    "measurementMethodID",
    "creationDateTime",
    "defaultCurrencyCode",
    "defaultLanguageCode",
    "comment",
    "typeCode",
    "requestedActionCode",
    "priceListID",
    "contractualLanguageCode",
    "itemGroupedWorkItem",
    "itemBasicWorkItem",
    "totalCalculatedPrice",
    "changedRecordedStatus",
    "creationSpecifiedBinaryFile",
    "readerSpecifiedBinaryFile",
    "referencedSpecifiedBinaryFile"
})
public class ValuationBreakdownStatementType {

    @XmlElement(name = "ID", required = true)
    protected IDType id;
    @XmlElement(name = "Name", required = true)
    protected TextType name;
    @XmlElement(name = "Description")
    protected List<TextType> description;
    @XmlElement(name = "MeasurementMethodID")
    protected List<IDType> measurementMethodID;
    @XmlElement(name = "CreationDateTime", required = true)
    protected DateTimeType creationDateTime;
    @XmlElement(name = "DefaultCurrencyCode", required = true)
    protected CurrencyCodeType defaultCurrencyCode;
    @XmlElement(name = "DefaultLanguageCode", required = true)
    protected CodeType defaultLanguageCode;
    @XmlElement(name = "Comment")
    protected List<TextType> comment;
    @XmlElement(name = "TypeCode")
    protected List<CodeType> typeCode;
    @XmlElement(name = "RequestedActionCode")
    protected List<CodeType> requestedActionCode;
    @XmlElement(name = "PriceListID")
    protected IDType priceListID;
    @XmlElement(name = "ContractualLanguageCode")
    protected CodeType contractualLanguageCode;
    @XmlElement(name = "ItemGroupedWorkItem")
    protected List<GroupedWorkItemType> itemGroupedWorkItem;
    @XmlElement(name = "ItemBasicWorkItem")
    protected List<BasicWorkItemType> itemBasicWorkItem;
    @XmlElement(name = "TotalCalculatedPrice")
    protected List<CalculatedPriceType> totalCalculatedPrice;
    @XmlElement(name = "ChangedRecordedStatus")
    protected List<RecordedStatusType> changedRecordedStatus;
    @XmlElement(name = "CreationSpecifiedBinaryFile")
    protected List<SpecifiedBinaryFileType> creationSpecifiedBinaryFile;
    @XmlElement(name = "ReaderSpecifiedBinaryFile")
    protected List<SpecifiedBinaryFileType> readerSpecifiedBinaryFile;
    @XmlElement(name = "ReferencedSpecifiedBinaryFile")
    protected List<SpecifiedBinaryFileType> referencedSpecifiedBinaryFile;

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
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setName(TextType value) {
        this.name = value;
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
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDescription() {
        if (description == null) {
            description = new ArrayList<TextType>();
        }
        return this.description;
    }

    /**
     * Gets the value of the measurementMethodID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measurementMethodID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasurementMethodID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getMeasurementMethodID() {
        if (measurementMethodID == null) {
            measurementMethodID = new ArrayList<IDType>();
        }
        return this.measurementMethodID;
    }

    /**
     * Ruft den Wert der creationDateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Legt den Wert der creationDateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setCreationDateTime(DateTimeType value) {
        this.creationDateTime = value;
    }

    /**
     * Ruft den Wert der defaultCurrencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeType }
     *     
     */
    public CurrencyCodeType getDefaultCurrencyCode() {
        return defaultCurrencyCode;
    }

    /**
     * Legt den Wert der defaultCurrencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeType }
     *     
     */
    public void setDefaultCurrencyCode(CurrencyCodeType value) {
        this.defaultCurrencyCode = value;
    }

    /**
     * Ruft den Wert der defaultLanguageCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getDefaultLanguageCode() {
        return defaultLanguageCode;
    }

    /**
     * Legt den Wert der defaultLanguageCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setDefaultLanguageCode(CodeType value) {
        this.defaultLanguageCode = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getComment() {
        if (comment == null) {
            comment = new ArrayList<TextType>();
        }
        return this.comment;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getTypeCode() {
        if (typeCode == null) {
            typeCode = new ArrayList<CodeType>();
        }
        return this.typeCode;
    }

    /**
     * Gets the value of the requestedActionCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestedActionCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestedActionCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getRequestedActionCode() {
        if (requestedActionCode == null) {
            requestedActionCode = new ArrayList<CodeType>();
        }
        return this.requestedActionCode;
    }

    /**
     * Ruft den Wert der priceListID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getPriceListID() {
        return priceListID;
    }

    /**
     * Legt den Wert der priceListID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setPriceListID(IDType value) {
        this.priceListID = value;
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
     * Gets the value of the itemGroupedWorkItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemGroupedWorkItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemGroupedWorkItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupedWorkItemType }
     * 
     * 
     */
    public List<GroupedWorkItemType> getItemGroupedWorkItem() {
        if (itemGroupedWorkItem == null) {
            itemGroupedWorkItem = new ArrayList<GroupedWorkItemType>();
        }
        return this.itemGroupedWorkItem;
    }

    /**
     * Gets the value of the itemBasicWorkItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemBasicWorkItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemBasicWorkItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BasicWorkItemType }
     * 
     * 
     */
    public List<BasicWorkItemType> getItemBasicWorkItem() {
        if (itemBasicWorkItem == null) {
            itemBasicWorkItem = new ArrayList<BasicWorkItemType>();
        }
        return this.itemBasicWorkItem;
    }

    /**
     * Gets the value of the totalCalculatedPrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalCalculatedPrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalCalculatedPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalculatedPriceType }
     * 
     * 
     */
    public List<CalculatedPriceType> getTotalCalculatedPrice() {
        if (totalCalculatedPrice == null) {
            totalCalculatedPrice = new ArrayList<CalculatedPriceType>();
        }
        return this.totalCalculatedPrice;
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

    /**
     * Gets the value of the creationSpecifiedBinaryFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creationSpecifiedBinaryFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreationSpecifiedBinaryFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecifiedBinaryFileType }
     * 
     * 
     */
    public List<SpecifiedBinaryFileType> getCreationSpecifiedBinaryFile() {
        if (creationSpecifiedBinaryFile == null) {
            creationSpecifiedBinaryFile = new ArrayList<SpecifiedBinaryFileType>();
        }
        return this.creationSpecifiedBinaryFile;
    }

    /**
     * Gets the value of the readerSpecifiedBinaryFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the readerSpecifiedBinaryFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReaderSpecifiedBinaryFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecifiedBinaryFileType }
     * 
     * 
     */
    public List<SpecifiedBinaryFileType> getReaderSpecifiedBinaryFile() {
        if (readerSpecifiedBinaryFile == null) {
            readerSpecifiedBinaryFile = new ArrayList<SpecifiedBinaryFileType>();
        }
        return this.readerSpecifiedBinaryFile;
    }

    /**
     * Gets the value of the referencedSpecifiedBinaryFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referencedSpecifiedBinaryFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferencedSpecifiedBinaryFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecifiedBinaryFileType }
     * 
     * 
     */
    public List<SpecifiedBinaryFileType> getReferencedSpecifiedBinaryFile() {
        if (referencedSpecifiedBinaryFile == null) {
            referencedSpecifiedBinaryFile = new ArrayList<SpecifiedBinaryFileType>();
        }
        return this.referencedSpecifiedBinaryFile;
    }

}
