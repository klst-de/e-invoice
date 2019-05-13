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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für WorkItemComplexDescriptionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WorkItemComplexDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Abstract" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Content" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ContractualLanguageCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/>
 *         &lt;element name="RequestingSpecificationQuery" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecificationQueryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RespondingSpecificationResponse" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecificationResponseType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubsetWorkItemComplexDescription" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}WorkItemComplexDescriptionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkItemComplexDescriptionType", propOrder = {
    "_abstract",
    "content",
    "contractualLanguageCode",
    "requestingSpecificationQuery",
    "respondingSpecificationResponse",
    "subsetWorkItemComplexDescription"
})
public class WorkItemComplexDescriptionType {

    @XmlElement(name = "Abstract")
    protected List<TextType> _abstract;
    @XmlElement(name = "Content")
    protected List<TextType> content;
    @XmlElement(name = "ContractualLanguageCode")
    protected CodeType contractualLanguageCode;
    @XmlElement(name = "RequestingSpecificationQuery")
    protected List<SpecificationQueryType> requestingSpecificationQuery;
    @XmlElement(name = "RespondingSpecificationResponse")
    protected List<SpecificationResponseType> respondingSpecificationResponse;
    @XmlElement(name = "SubsetWorkItemComplexDescription")
    protected WorkItemComplexDescriptionType subsetWorkItemComplexDescription;

    /**
     * Gets the value of the abstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getAbstract() {
        if (_abstract == null) {
            _abstract = new ArrayList<TextType>();
        }
        return this._abstract;
    }

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getContent() {
        if (content == null) {
            content = new ArrayList<TextType>();
        }
        return this.content;
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
     * Gets the value of the requestingSpecificationQuery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestingSpecificationQuery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestingSpecificationQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificationQueryType }
     * 
     * 
     */
    public List<SpecificationQueryType> getRequestingSpecificationQuery() {
        if (requestingSpecificationQuery == null) {
            requestingSpecificationQuery = new ArrayList<SpecificationQueryType>();
        }
        return this.requestingSpecificationQuery;
    }

    /**
     * Gets the value of the respondingSpecificationResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the respondingSpecificationResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRespondingSpecificationResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificationResponseType }
     * 
     * 
     */
    public List<SpecificationResponseType> getRespondingSpecificationResponse() {
        if (respondingSpecificationResponse == null) {
            respondingSpecificationResponse = new ArrayList<SpecificationResponseType>();
        }
        return this.respondingSpecificationResponse;
    }

    /**
     * Ruft den Wert der subsetWorkItemComplexDescription-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WorkItemComplexDescriptionType }
     *     
     */
    public WorkItemComplexDescriptionType getSubsetWorkItemComplexDescription() {
        return subsetWorkItemComplexDescription;
    }

    /**
     * Legt den Wert der subsetWorkItemComplexDescription-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkItemComplexDescriptionType }
     *     
     */
    public void setSubsetWorkItemComplexDescription(WorkItemComplexDescriptionType value) {
        this.subsetWorkItemComplexDescription = value;
    }

}
