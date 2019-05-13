//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für GroupedWorkItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GroupedWorkItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType"/>
 *         &lt;element name="PrimaryClassificationCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AlternativeClassificationCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Comment" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalQuantity" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}QuantityType" minOccurs="0"/>
 *         &lt;element name="Index" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
 *         &lt;element name="RequestedActionCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PriceListItemID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/>
 *         &lt;element name="ContractualLanguageCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="TotalCalculatedPrice" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}CalculatedPriceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemGroupedWorkItem" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}GroupedWorkItemType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemBasicWorkItem" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}BasicWorkItemType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ChangedRecordedStatus" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}RecordedStatusType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ActualWorkItemComplexDescription" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}WorkItemComplexDescriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReferencedSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupedWorkItemType", propOrder = {
    "id",
    "primaryClassificationCode",
    "alternativeClassificationCode",
    "typeCode",
    "comment",
    "totalQuantity",
    "index",
    "requestedActionCode",
    "priceListItemID",
    "contractualLanguageCode",
    "totalCalculatedPrice",
    "itemGroupedWorkItem",
    "itemBasicWorkItem",
    "changedRecordedStatus",
    "actualWorkItemComplexDescription",
    "referencedSpecifiedBinaryFile"
})
public class GroupedWorkItemType {

    @XmlElement(name = "ID", required = true)
    protected IDType id;
    @XmlElement(name = "PrimaryClassificationCode")
    protected List<CodeType> primaryClassificationCode;
    @XmlElement(name = "AlternativeClassificationCode")
    protected List<CodeType> alternativeClassificationCode;
    @XmlElement(name = "TypeCode")
    protected List<CodeType> typeCode;
    @XmlElement(name = "Comment")
    protected List<TextType> comment;
    @XmlElement(name = "TotalQuantity")
    protected QuantityType totalQuantity;
    @XmlElement(name = "Index")
    protected TextType index;
    @XmlElement(name = "RequestedActionCode")
    protected List<CodeType> requestedActionCode;
    @XmlElement(name = "PriceListItemID")
    protected IDType priceListItemID;
    @XmlElement(name = "ContractualLanguageCode")
    protected CodeType contractualLanguageCode;
    @XmlElement(name = "TotalCalculatedPrice")
    protected List<CalculatedPriceType> totalCalculatedPrice;
    @XmlElement(name = "ItemGroupedWorkItem")
    protected List<GroupedWorkItemType> itemGroupedWorkItem;
    @XmlElement(name = "ItemBasicWorkItem")
    protected List<BasicWorkItemType> itemBasicWorkItem;
    @XmlElement(name = "ChangedRecordedStatus")
    protected List<RecordedStatusType> changedRecordedStatus;
    @XmlElement(name = "ActualWorkItemComplexDescription")
    protected List<WorkItemComplexDescriptionType> actualWorkItemComplexDescription;
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
     * Ruft den Wert der totalQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * Legt den Wert der totalQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setTotalQuantity(QuantityType value) {
        this.totalQuantity = value;
    }

    /**
     * Ruft den Wert der index-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getIndex() {
        return index;
    }

    /**
     * Legt den Wert der index-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setIndex(TextType value) {
        this.index = value;
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
     * Ruft den Wert der priceListItemID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getPriceListItemID() {
        return priceListItemID;
    }

    /**
     * Legt den Wert der priceListItemID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setPriceListItemID(IDType value) {
        this.priceListItemID = value;
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
     * Gets the value of the actualWorkItemComplexDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actualWorkItemComplexDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActualWorkItemComplexDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkItemComplexDescriptionType }
     * 
     * 
     */
    public List<WorkItemComplexDescriptionType> getActualWorkItemComplexDescription() {
        if (actualWorkItemComplexDescription == null) {
            actualWorkItemComplexDescription = new ArrayList<WorkItemComplexDescriptionType>();
        }
        return this.actualWorkItemComplexDescription;
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
