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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;


/**
 * <p>Java-Klasse für ExchangedDocumentContextType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ExchangedDocumentContextType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SpecifiedTransactionID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" minOccurs="0"/&gt;
 *         &lt;element name="TestIndicator" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessProcessSpecifiedDocumentContextParameter" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentContextParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="BIMSpecifiedDocumentContextParameter" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentContextParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ScenarioSpecifiedDocumentContextParameter" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentContextParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ApplicationSpecifiedDocumentContextParameter" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentContextParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="GuidelineSpecifiedDocumentContextParameter" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentContextParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SubsetSpecifiedDocumentContextParameter" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentContextParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="MessageStandardSpecifiedDocumentContextParameter" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}DocumentContextParameterType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangedDocumentContextType", propOrder = {
    "specifiedTransactionID",
    "testIndicator",
    "businessProcessSpecifiedDocumentContextParameter",
    "bimSpecifiedDocumentContextParameter",
    "scenarioSpecifiedDocumentContextParameter",
    "applicationSpecifiedDocumentContextParameter",
    "guidelineSpecifiedDocumentContextParameter",
    "subsetSpecifiedDocumentContextParameter",
    "messageStandardSpecifiedDocumentContextParameter"
})
public class ExchangedDocumentContextType {

    @XmlElement(name = "SpecifiedTransactionID")
    protected IDType specifiedTransactionID;
    @XmlElement(name = "TestIndicator")
    protected IndicatorType testIndicator;
    @XmlElement(name = "BusinessProcessSpecifiedDocumentContextParameter")
    protected List<DocumentContextParameterType> businessProcessSpecifiedDocumentContextParameter;
    @XmlElement(name = "BIMSpecifiedDocumentContextParameter")
    protected List<DocumentContextParameterType> bimSpecifiedDocumentContextParameter;
    @XmlElement(name = "ScenarioSpecifiedDocumentContextParameter")
    protected List<DocumentContextParameterType> scenarioSpecifiedDocumentContextParameter;
    @XmlElement(name = "ApplicationSpecifiedDocumentContextParameter")
    protected List<DocumentContextParameterType> applicationSpecifiedDocumentContextParameter;
    @XmlElement(name = "GuidelineSpecifiedDocumentContextParameter")
    protected List<DocumentContextParameterType> guidelineSpecifiedDocumentContextParameter;
    @XmlElement(name = "SubsetSpecifiedDocumentContextParameter")
    protected List<DocumentContextParameterType> subsetSpecifiedDocumentContextParameter;
    @XmlElement(name = "MessageStandardSpecifiedDocumentContextParameter")
    protected DocumentContextParameterType messageStandardSpecifiedDocumentContextParameter;

    /**
     * Ruft den Wert der specifiedTransactionID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getSpecifiedTransactionID() {
        return specifiedTransactionID;
    }

    /**
     * Legt den Wert der specifiedTransactionID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setSpecifiedTransactionID(IDType value) {
        this.specifiedTransactionID = value;
    }

    /**
     * Ruft den Wert der testIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorType }
     *     
     */
    public IndicatorType getTestIndicator() {
        return testIndicator;
    }

    /**
     * Legt den Wert der testIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorType }
     *     
     */
    public void setTestIndicator(IndicatorType value) {
        this.testIndicator = value;
    }

    /**
     * Gets the value of the businessProcessSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessProcessSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessProcessSpecifiedDocumentContextParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentContextParameterType }
     * 
     * 
     */
    public List<DocumentContextParameterType> getBusinessProcessSpecifiedDocumentContextParameter() {
        if (businessProcessSpecifiedDocumentContextParameter == null) {
            businessProcessSpecifiedDocumentContextParameter = new ArrayList<DocumentContextParameterType>();
        }
        return this.businessProcessSpecifiedDocumentContextParameter;
    }

    /**
     * Gets the value of the bimSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bimSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBIMSpecifiedDocumentContextParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentContextParameterType }
     * 
     * 
     */
    public List<DocumentContextParameterType> getBIMSpecifiedDocumentContextParameter() {
        if (bimSpecifiedDocumentContextParameter == null) {
            bimSpecifiedDocumentContextParameter = new ArrayList<DocumentContextParameterType>();
        }
        return this.bimSpecifiedDocumentContextParameter;
    }

    /**
     * Gets the value of the scenarioSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scenarioSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScenarioSpecifiedDocumentContextParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentContextParameterType }
     * 
     * 
     */
    public List<DocumentContextParameterType> getScenarioSpecifiedDocumentContextParameter() {
        if (scenarioSpecifiedDocumentContextParameter == null) {
            scenarioSpecifiedDocumentContextParameter = new ArrayList<DocumentContextParameterType>();
        }
        return this.scenarioSpecifiedDocumentContextParameter;
    }

    /**
     * Gets the value of the applicationSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicationSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicationSpecifiedDocumentContextParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentContextParameterType }
     * 
     * 
     */
    public List<DocumentContextParameterType> getApplicationSpecifiedDocumentContextParameter() {
        if (applicationSpecifiedDocumentContextParameter == null) {
            applicationSpecifiedDocumentContextParameter = new ArrayList<DocumentContextParameterType>();
        }
        return this.applicationSpecifiedDocumentContextParameter;
    }

    /**
     * Gets the value of the guidelineSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guidelineSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuidelineSpecifiedDocumentContextParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentContextParameterType }
     * 
     * 
     */
    public List<DocumentContextParameterType> getGuidelineSpecifiedDocumentContextParameter() {
        if (guidelineSpecifiedDocumentContextParameter == null) {
            guidelineSpecifiedDocumentContextParameter = new ArrayList<DocumentContextParameterType>();
        }
        return this.guidelineSpecifiedDocumentContextParameter;
    }

    /**
     * Gets the value of the subsetSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subsetSpecifiedDocumentContextParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubsetSpecifiedDocumentContextParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentContextParameterType }
     * 
     * 
     */
    public List<DocumentContextParameterType> getSubsetSpecifiedDocumentContextParameter() {
        if (subsetSpecifiedDocumentContextParameter == null) {
            subsetSpecifiedDocumentContextParameter = new ArrayList<DocumentContextParameterType>();
        }
        return this.subsetSpecifiedDocumentContextParameter;
    }

    /**
     * Ruft den Wert der messageStandardSpecifiedDocumentContextParameter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentContextParameterType }
     *     
     */
    public DocumentContextParameterType getMessageStandardSpecifiedDocumentContextParameter() {
        return messageStandardSpecifiedDocumentContextParameter;
    }

    /**
     * Legt den Wert der messageStandardSpecifiedDocumentContextParameter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentContextParameterType }
     *     
     */
    public void setMessageStandardSpecifiedDocumentContextParameter(DocumentContextParameterType value) {
        this.messageStandardSpecifiedDocumentContextParameter = value;
    }

}
