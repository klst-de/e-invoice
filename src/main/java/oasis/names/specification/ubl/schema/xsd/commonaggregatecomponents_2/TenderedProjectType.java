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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FeeAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FeeDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TenderEnvelopeIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TenderEnvelopeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.VariantIDType;


/**
 * <p>Java-Klasse für TenderedProjectType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TenderedProjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}VariantID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FeeAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FeeDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TenderEnvelopeID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TenderEnvelopeTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProcurementProjectLot" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EvidenceDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LegalMonetaryTotal" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderLine" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AwardingCriterionResponse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TenderedProjectType", propOrder = {
    "variantID",
    "feeAmount",
    "feeDescription",
    "tenderEnvelopeID",
    "tenderEnvelopeTypeCode",
    "procurementProjectLot",
    "evidenceDocumentReference",
    "taxTotal",
    "legalMonetaryTotal",
    "tenderLine",
    "awardingCriterionResponse"
})
public class TenderedProjectType {

    @XmlElement(name = "VariantID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected VariantIDType variantID;
    @XmlElement(name = "FeeAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FeeAmountType feeAmount;
    @XmlElement(name = "FeeDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<FeeDescriptionType> feeDescription;
    @XmlElement(name = "TenderEnvelopeID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TenderEnvelopeIDType tenderEnvelopeID;
    @XmlElement(name = "TenderEnvelopeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TenderEnvelopeTypeCodeType tenderEnvelopeTypeCode;
    @XmlElement(name = "ProcurementProjectLot")
    protected ProcurementProjectLotType procurementProjectLot;
    @XmlElement(name = "EvidenceDocumentReference")
    protected List<DocumentReferenceType> evidenceDocumentReference;
    @XmlElement(name = "TaxTotal")
    protected List<TaxTotalType> taxTotal;
    @XmlElement(name = "LegalMonetaryTotal")
    protected MonetaryTotalType legalMonetaryTotal;
    @XmlElement(name = "TenderLine")
    protected List<TenderLineType> tenderLine;
    @XmlElement(name = "AwardingCriterionResponse")
    protected List<AwardingCriterionResponseType> awardingCriterionResponse;

    /**
     * Ruft den Wert der variantID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VariantIDType }
     *     
     */
    public VariantIDType getVariantID() {
        return variantID;
    }

    /**
     * Legt den Wert der variantID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VariantIDType }
     *     
     */
    public void setVariantID(VariantIDType value) {
        this.variantID = value;
    }

    /**
     * Ruft den Wert der feeAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FeeAmountType }
     *     
     */
    public FeeAmountType getFeeAmount() {
        return feeAmount;
    }

    /**
     * Legt den Wert der feeAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FeeAmountType }
     *     
     */
    public void setFeeAmount(FeeAmountType value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the feeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeDescriptionType }
     * 
     * 
     */
    public List<FeeDescriptionType> getFeeDescription() {
        if (feeDescription == null) {
            feeDescription = new ArrayList<FeeDescriptionType>();
        }
        return this.feeDescription;
    }

    /**
     * Ruft den Wert der tenderEnvelopeID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TenderEnvelopeIDType }
     *     
     */
    public TenderEnvelopeIDType getTenderEnvelopeID() {
        return tenderEnvelopeID;
    }

    /**
     * Legt den Wert der tenderEnvelopeID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TenderEnvelopeIDType }
     *     
     */
    public void setTenderEnvelopeID(TenderEnvelopeIDType value) {
        this.tenderEnvelopeID = value;
    }

    /**
     * Ruft den Wert der tenderEnvelopeTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TenderEnvelopeTypeCodeType }
     *     
     */
    public TenderEnvelopeTypeCodeType getTenderEnvelopeTypeCode() {
        return tenderEnvelopeTypeCode;
    }

    /**
     * Legt den Wert der tenderEnvelopeTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TenderEnvelopeTypeCodeType }
     *     
     */
    public void setTenderEnvelopeTypeCode(TenderEnvelopeTypeCodeType value) {
        this.tenderEnvelopeTypeCode = value;
    }

    /**
     * Ruft den Wert der procurementProjectLot-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProcurementProjectLotType }
     *     
     */
    public ProcurementProjectLotType getProcurementProjectLot() {
        return procurementProjectLot;
    }

    /**
     * Legt den Wert der procurementProjectLot-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementProjectLotType }
     *     
     */
    public void setProcurementProjectLot(ProcurementProjectLotType value) {
        this.procurementProjectLot = value;
    }

    /**
     * Gets the value of the evidenceDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evidenceDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvidenceDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getEvidenceDocumentReference() {
        if (evidenceDocumentReference == null) {
            evidenceDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.evidenceDocumentReference;
    }

    /**
     * Gets the value of the taxTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxTotalType }
     * 
     * 
     */
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    /**
     * Ruft den Wert der legalMonetaryTotal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MonetaryTotalType }
     *     
     */
    public MonetaryTotalType getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    /**
     * Legt den Wert der legalMonetaryTotal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryTotalType }
     *     
     */
    public void setLegalMonetaryTotal(MonetaryTotalType value) {
        this.legalMonetaryTotal = value;
    }

    /**
     * Gets the value of the tenderLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tenderLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTenderLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TenderLineType }
     * 
     * 
     */
    public List<TenderLineType> getTenderLine() {
        if (tenderLine == null) {
            tenderLine = new ArrayList<TenderLineType>();
        }
        return this.tenderLine;
    }

    /**
     * Gets the value of the awardingCriterionResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awardingCriterionResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAwardingCriterionResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AwardingCriterionResponseType }
     * 
     * 
     */
    public List<AwardingCriterionResponseType> getAwardingCriterionResponse() {
        if (awardingCriterionResponse == null) {
            awardingCriterionResponse = new ArrayList<AwardingCriterionResponseType>();
        }
        return this.awardingCriterionResponse;
    }

}
