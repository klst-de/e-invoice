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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AcceptedVariantsDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalConditionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardingMethodTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentationFeeAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EconomicOperatorRegistryURIType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FundingProgramCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FundingProgramType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestSecurityClearanceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumAdvertisementAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumVariantQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OtherConditionsIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentFrequencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceEvaluationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceRevisionFormulaDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredCurriculaIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.VariantConstraintIndicatorType;


/**
 * <p>Java-Klasse für TenderingTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TenderingTermsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AwardingMethodTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceEvaluationCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumVariantQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}VariantConstraintIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AcceptedVariantsDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceRevisionFormulaDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FundingProgramCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FundingProgram" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumAdvertisementAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentFrequencyCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EconomicOperatorRegistryURI" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequiredCurriculaIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OtherConditionsIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalConditions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestSecurityClearanceDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DocumentationFeeAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PenaltyClause" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequiredFinancialGuarantee" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProcurementLegislationDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FiscalLegislationDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnvironmentalLegislationDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EmploymentLegislationDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractualDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CallForTendersDocumentReference" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WarrantyValidityPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentTerms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TendererQualificationRequest" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowedSubcontractTerms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderPreparation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractExecutionRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AwardingTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalInformationParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentProviderParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderRecipientParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractResponsibleParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderEvaluationParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderValidityPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractAcceptancePeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AppealTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Language" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BudgetAccountLine" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReplacedNoticeDocumentReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TenderingTermsType", propOrder = {
    "awardingMethodTypeCode",
    "priceEvaluationCode",
    "maximumVariantQuantity",
    "variantConstraintIndicator",
    "acceptedVariantsDescription",
    "priceRevisionFormulaDescription",
    "fundingProgramCode",
    "fundingProgram",
    "maximumAdvertisementAmount",
    "note",
    "paymentFrequencyCode",
    "economicOperatorRegistryURI",
    "requiredCurriculaIndicator",
    "otherConditionsIndicator",
    "additionalConditions",
    "latestSecurityClearanceDate",
    "documentationFeeAmount",
    "penaltyClause",
    "requiredFinancialGuarantee",
    "procurementLegislationDocumentReference",
    "fiscalLegislationDocumentReference",
    "environmentalLegislationDocumentReference",
    "employmentLegislationDocumentReference",
    "contractualDocumentReference",
    "callForTendersDocumentReference",
    "warrantyValidityPeriod",
    "paymentTerms",
    "tendererQualificationRequest",
    "allowedSubcontractTerms",
    "tenderPreparation",
    "contractExecutionRequirement",
    "awardingTerms",
    "additionalInformationParty",
    "documentProviderParty",
    "tenderRecipientParty",
    "contractResponsibleParty",
    "tenderEvaluationParty",
    "tenderValidityPeriod",
    "contractAcceptancePeriod",
    "appealTerms",
    "language",
    "budgetAccountLine",
    "replacedNoticeDocumentReference"
})
public class TenderingTermsType {

    @XmlElement(name = "AwardingMethodTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AwardingMethodTypeCodeType awardingMethodTypeCode;
    @XmlElement(name = "PriceEvaluationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriceEvaluationCodeType priceEvaluationCode;
    @XmlElement(name = "MaximumVariantQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumVariantQuantityType maximumVariantQuantity;
    @XmlElement(name = "VariantConstraintIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected VariantConstraintIndicatorType variantConstraintIndicator;
    @XmlElement(name = "AcceptedVariantsDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<AcceptedVariantsDescriptionType> acceptedVariantsDescription;
    @XmlElement(name = "PriceRevisionFormulaDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PriceRevisionFormulaDescriptionType> priceRevisionFormulaDescription;
    @XmlElement(name = "FundingProgramCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FundingProgramCodeType fundingProgramCode;
    @XmlElement(name = "FundingProgram", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<FundingProgramType> fundingProgram;
    @XmlElement(name = "MaximumAdvertisementAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumAdvertisementAmountType maximumAdvertisementAmount;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "PaymentFrequencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentFrequencyCodeType paymentFrequencyCode;
    @XmlElement(name = "EconomicOperatorRegistryURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EconomicOperatorRegistryURIType economicOperatorRegistryURI;
    @XmlElement(name = "RequiredCurriculaIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequiredCurriculaIndicatorType requiredCurriculaIndicator;
    @XmlElement(name = "OtherConditionsIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OtherConditionsIndicatorType otherConditionsIndicator;
    @XmlElement(name = "AdditionalConditions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<AdditionalConditionsType> additionalConditions;
    @XmlElement(name = "LatestSecurityClearanceDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestSecurityClearanceDateType latestSecurityClearanceDate;
    @XmlElement(name = "DocumentationFeeAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DocumentationFeeAmountType documentationFeeAmount;
    @XmlElement(name = "PenaltyClause")
    protected List<ClauseType> penaltyClause;
    @XmlElement(name = "RequiredFinancialGuarantee")
    protected List<FinancialGuaranteeType> requiredFinancialGuarantee;
    @XmlElement(name = "ProcurementLegislationDocumentReference")
    protected DocumentReferenceType procurementLegislationDocumentReference;
    @XmlElement(name = "FiscalLegislationDocumentReference")
    protected DocumentReferenceType fiscalLegislationDocumentReference;
    @XmlElement(name = "EnvironmentalLegislationDocumentReference")
    protected DocumentReferenceType environmentalLegislationDocumentReference;
    @XmlElement(name = "EmploymentLegislationDocumentReference")
    protected DocumentReferenceType employmentLegislationDocumentReference;
    @XmlElement(name = "ContractualDocumentReference")
    protected List<DocumentReferenceType> contractualDocumentReference;
    @XmlElement(name = "CallForTendersDocumentReference")
    protected DocumentReferenceType callForTendersDocumentReference;
    @XmlElement(name = "WarrantyValidityPeriod")
    protected PeriodType warrantyValidityPeriod;
    @XmlElement(name = "PaymentTerms")
    protected List<PaymentTermsType> paymentTerms;
    @XmlElement(name = "TendererQualificationRequest")
    protected List<TendererQualificationRequestType> tendererQualificationRequest;
    @XmlElement(name = "AllowedSubcontractTerms")
    protected List<SubcontractTermsType> allowedSubcontractTerms;
    @XmlElement(name = "TenderPreparation")
    protected List<TenderPreparationType> tenderPreparation;
    @XmlElement(name = "ContractExecutionRequirement")
    protected List<ContractExecutionRequirementType> contractExecutionRequirement;
    @XmlElement(name = "AwardingTerms")
    protected AwardingTermsType awardingTerms;
    @XmlElement(name = "AdditionalInformationParty")
    protected PartyType additionalInformationParty;
    @XmlElement(name = "DocumentProviderParty")
    protected PartyType documentProviderParty;
    @XmlElement(name = "TenderRecipientParty")
    protected PartyType tenderRecipientParty;
    @XmlElement(name = "ContractResponsibleParty")
    protected PartyType contractResponsibleParty;
    @XmlElement(name = "TenderEvaluationParty")
    protected List<PartyType> tenderEvaluationParty;
    @XmlElement(name = "TenderValidityPeriod")
    protected PeriodType tenderValidityPeriod;
    @XmlElement(name = "ContractAcceptancePeriod")
    protected PeriodType contractAcceptancePeriod;
    @XmlElement(name = "AppealTerms")
    protected AppealTermsType appealTerms;
    @XmlElement(name = "Language")
    protected List<LanguageType> language;
    @XmlElement(name = "BudgetAccountLine")
    protected List<BudgetAccountLineType> budgetAccountLine;
    @XmlElement(name = "ReplacedNoticeDocumentReference")
    protected DocumentReferenceType replacedNoticeDocumentReference;

    /**
     * Ruft den Wert der awardingMethodTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AwardingMethodTypeCodeType }
     *     
     */
    public AwardingMethodTypeCodeType getAwardingMethodTypeCode() {
        return awardingMethodTypeCode;
    }

    /**
     * Legt den Wert der awardingMethodTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardingMethodTypeCodeType }
     *     
     */
    public void setAwardingMethodTypeCode(AwardingMethodTypeCodeType value) {
        this.awardingMethodTypeCode = value;
    }

    /**
     * Ruft den Wert der priceEvaluationCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceEvaluationCodeType }
     *     
     */
    public PriceEvaluationCodeType getPriceEvaluationCode() {
        return priceEvaluationCode;
    }

    /**
     * Legt den Wert der priceEvaluationCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceEvaluationCodeType }
     *     
     */
    public void setPriceEvaluationCode(PriceEvaluationCodeType value) {
        this.priceEvaluationCode = value;
    }

    /**
     * Ruft den Wert der maximumVariantQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumVariantQuantityType }
     *     
     */
    public MaximumVariantQuantityType getMaximumVariantQuantity() {
        return maximumVariantQuantity;
    }

    /**
     * Legt den Wert der maximumVariantQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumVariantQuantityType }
     *     
     */
    public void setMaximumVariantQuantity(MaximumVariantQuantityType value) {
        this.maximumVariantQuantity = value;
    }

    /**
     * Ruft den Wert der variantConstraintIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VariantConstraintIndicatorType }
     *     
     */
    public VariantConstraintIndicatorType getVariantConstraintIndicator() {
        return variantConstraintIndicator;
    }

    /**
     * Legt den Wert der variantConstraintIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VariantConstraintIndicatorType }
     *     
     */
    public void setVariantConstraintIndicator(VariantConstraintIndicatorType value) {
        this.variantConstraintIndicator = value;
    }

    /**
     * Gets the value of the acceptedVariantsDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acceptedVariantsDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcceptedVariantsDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AcceptedVariantsDescriptionType }
     * 
     * 
     */
    public List<AcceptedVariantsDescriptionType> getAcceptedVariantsDescription() {
        if (acceptedVariantsDescription == null) {
            acceptedVariantsDescription = new ArrayList<AcceptedVariantsDescriptionType>();
        }
        return this.acceptedVariantsDescription;
    }

    /**
     * Gets the value of the priceRevisionFormulaDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceRevisionFormulaDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceRevisionFormulaDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceRevisionFormulaDescriptionType }
     * 
     * 
     */
    public List<PriceRevisionFormulaDescriptionType> getPriceRevisionFormulaDescription() {
        if (priceRevisionFormulaDescription == null) {
            priceRevisionFormulaDescription = new ArrayList<PriceRevisionFormulaDescriptionType>();
        }
        return this.priceRevisionFormulaDescription;
    }

    /**
     * Ruft den Wert der fundingProgramCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FundingProgramCodeType }
     *     
     */
    public FundingProgramCodeType getFundingProgramCode() {
        return fundingProgramCode;
    }

    /**
     * Legt den Wert der fundingProgramCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FundingProgramCodeType }
     *     
     */
    public void setFundingProgramCode(FundingProgramCodeType value) {
        this.fundingProgramCode = value;
    }

    /**
     * Gets the value of the fundingProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fundingProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFundingProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FundingProgramType }
     * 
     * 
     */
    public List<FundingProgramType> getFundingProgram() {
        if (fundingProgram == null) {
            fundingProgram = new ArrayList<FundingProgramType>();
        }
        return this.fundingProgram;
    }

    /**
     * Ruft den Wert der maximumAdvertisementAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaximumAdvertisementAmountType }
     *     
     */
    public MaximumAdvertisementAmountType getMaximumAdvertisementAmount() {
        return maximumAdvertisementAmount;
    }

    /**
     * Legt den Wert der maximumAdvertisementAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumAdvertisementAmountType }
     *     
     */
    public void setMaximumAdvertisementAmount(MaximumAdvertisementAmountType value) {
        this.maximumAdvertisementAmount = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Ruft den Wert der paymentFrequencyCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentFrequencyCodeType }
     *     
     */
    public PaymentFrequencyCodeType getPaymentFrequencyCode() {
        return paymentFrequencyCode;
    }

    /**
     * Legt den Wert der paymentFrequencyCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentFrequencyCodeType }
     *     
     */
    public void setPaymentFrequencyCode(PaymentFrequencyCodeType value) {
        this.paymentFrequencyCode = value;
    }

    /**
     * Ruft den Wert der economicOperatorRegistryURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EconomicOperatorRegistryURIType }
     *     
     */
    public EconomicOperatorRegistryURIType getEconomicOperatorRegistryURI() {
        return economicOperatorRegistryURI;
    }

    /**
     * Legt den Wert der economicOperatorRegistryURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EconomicOperatorRegistryURIType }
     *     
     */
    public void setEconomicOperatorRegistryURI(EconomicOperatorRegistryURIType value) {
        this.economicOperatorRegistryURI = value;
    }

    /**
     * Ruft den Wert der requiredCurriculaIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequiredCurriculaIndicatorType }
     *     
     */
    public RequiredCurriculaIndicatorType getRequiredCurriculaIndicator() {
        return requiredCurriculaIndicator;
    }

    /**
     * Legt den Wert der requiredCurriculaIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredCurriculaIndicatorType }
     *     
     */
    public void setRequiredCurriculaIndicator(RequiredCurriculaIndicatorType value) {
        this.requiredCurriculaIndicator = value;
    }

    /**
     * Ruft den Wert der otherConditionsIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OtherConditionsIndicatorType }
     *     
     */
    public OtherConditionsIndicatorType getOtherConditionsIndicator() {
        return otherConditionsIndicator;
    }

    /**
     * Legt den Wert der otherConditionsIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherConditionsIndicatorType }
     *     
     */
    public void setOtherConditionsIndicator(OtherConditionsIndicatorType value) {
        this.otherConditionsIndicator = value;
    }

    /**
     * Gets the value of the additionalConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalConditionsType }
     * 
     * 
     */
    public List<AdditionalConditionsType> getAdditionalConditions() {
        if (additionalConditions == null) {
            additionalConditions = new ArrayList<AdditionalConditionsType>();
        }
        return this.additionalConditions;
    }

    /**
     * Ruft den Wert der latestSecurityClearanceDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LatestSecurityClearanceDateType }
     *     
     */
    public LatestSecurityClearanceDateType getLatestSecurityClearanceDate() {
        return latestSecurityClearanceDate;
    }

    /**
     * Legt den Wert der latestSecurityClearanceDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestSecurityClearanceDateType }
     *     
     */
    public void setLatestSecurityClearanceDate(LatestSecurityClearanceDateType value) {
        this.latestSecurityClearanceDate = value;
    }

    /**
     * Ruft den Wert der documentationFeeAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentationFeeAmountType }
     *     
     */
    public DocumentationFeeAmountType getDocumentationFeeAmount() {
        return documentationFeeAmount;
    }

    /**
     * Legt den Wert der documentationFeeAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentationFeeAmountType }
     *     
     */
    public void setDocumentationFeeAmount(DocumentationFeeAmountType value) {
        this.documentationFeeAmount = value;
    }

    /**
     * Gets the value of the penaltyClause property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the penaltyClause property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPenaltyClause().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseType }
     * 
     * 
     */
    public List<ClauseType> getPenaltyClause() {
        if (penaltyClause == null) {
            penaltyClause = new ArrayList<ClauseType>();
        }
        return this.penaltyClause;
    }

    /**
     * Gets the value of the requiredFinancialGuarantee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredFinancialGuarantee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredFinancialGuarantee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinancialGuaranteeType }
     * 
     * 
     */
    public List<FinancialGuaranteeType> getRequiredFinancialGuarantee() {
        if (requiredFinancialGuarantee == null) {
            requiredFinancialGuarantee = new ArrayList<FinancialGuaranteeType>();
        }
        return this.requiredFinancialGuarantee;
    }

    /**
     * Ruft den Wert der procurementLegislationDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getProcurementLegislationDocumentReference() {
        return procurementLegislationDocumentReference;
    }

    /**
     * Legt den Wert der procurementLegislationDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setProcurementLegislationDocumentReference(DocumentReferenceType value) {
        this.procurementLegislationDocumentReference = value;
    }

    /**
     * Ruft den Wert der fiscalLegislationDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getFiscalLegislationDocumentReference() {
        return fiscalLegislationDocumentReference;
    }

    /**
     * Legt den Wert der fiscalLegislationDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setFiscalLegislationDocumentReference(DocumentReferenceType value) {
        this.fiscalLegislationDocumentReference = value;
    }

    /**
     * Ruft den Wert der environmentalLegislationDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getEnvironmentalLegislationDocumentReference() {
        return environmentalLegislationDocumentReference;
    }

    /**
     * Legt den Wert der environmentalLegislationDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setEnvironmentalLegislationDocumentReference(DocumentReferenceType value) {
        this.environmentalLegislationDocumentReference = value;
    }

    /**
     * Ruft den Wert der employmentLegislationDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getEmploymentLegislationDocumentReference() {
        return employmentLegislationDocumentReference;
    }

    /**
     * Legt den Wert der employmentLegislationDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setEmploymentLegislationDocumentReference(DocumentReferenceType value) {
        this.employmentLegislationDocumentReference = value;
    }

    /**
     * Gets the value of the contractualDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractualDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractualDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getContractualDocumentReference() {
        if (contractualDocumentReference == null) {
            contractualDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.contractualDocumentReference;
    }

    /**
     * Ruft den Wert der callForTendersDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getCallForTendersDocumentReference() {
        return callForTendersDocumentReference;
    }

    /**
     * Legt den Wert der callForTendersDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setCallForTendersDocumentReference(DocumentReferenceType value) {
        this.callForTendersDocumentReference = value;
    }

    /**
     * Ruft den Wert der warrantyValidityPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getWarrantyValidityPeriod() {
        return warrantyValidityPeriod;
    }

    /**
     * Legt den Wert der warrantyValidityPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setWarrantyValidityPeriod(PeriodType value) {
        this.warrantyValidityPeriod = value;
    }

    /**
     * Gets the value of the paymentTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTermsType }
     * 
     * 
     */
    public List<PaymentTermsType> getPaymentTerms() {
        if (paymentTerms == null) {
            paymentTerms = new ArrayList<PaymentTermsType>();
        }
        return this.paymentTerms;
    }

    /**
     * Gets the value of the tendererQualificationRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tendererQualificationRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTendererQualificationRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TendererQualificationRequestType }
     * 
     * 
     */
    public List<TendererQualificationRequestType> getTendererQualificationRequest() {
        if (tendererQualificationRequest == null) {
            tendererQualificationRequest = new ArrayList<TendererQualificationRequestType>();
        }
        return this.tendererQualificationRequest;
    }

    /**
     * Gets the value of the allowedSubcontractTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedSubcontractTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedSubcontractTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubcontractTermsType }
     * 
     * 
     */
    public List<SubcontractTermsType> getAllowedSubcontractTerms() {
        if (allowedSubcontractTerms == null) {
            allowedSubcontractTerms = new ArrayList<SubcontractTermsType>();
        }
        return this.allowedSubcontractTerms;
    }

    /**
     * Gets the value of the tenderPreparation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tenderPreparation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTenderPreparation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TenderPreparationType }
     * 
     * 
     */
    public List<TenderPreparationType> getTenderPreparation() {
        if (tenderPreparation == null) {
            tenderPreparation = new ArrayList<TenderPreparationType>();
        }
        return this.tenderPreparation;
    }

    /**
     * Gets the value of the contractExecutionRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractExecutionRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractExecutionRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContractExecutionRequirementType }
     * 
     * 
     */
    public List<ContractExecutionRequirementType> getContractExecutionRequirement() {
        if (contractExecutionRequirement == null) {
            contractExecutionRequirement = new ArrayList<ContractExecutionRequirementType>();
        }
        return this.contractExecutionRequirement;
    }

    /**
     * Ruft den Wert der awardingTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AwardingTermsType }
     *     
     */
    public AwardingTermsType getAwardingTerms() {
        return awardingTerms;
    }

    /**
     * Legt den Wert der awardingTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardingTermsType }
     *     
     */
    public void setAwardingTerms(AwardingTermsType value) {
        this.awardingTerms = value;
    }

    /**
     * Ruft den Wert der additionalInformationParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getAdditionalInformationParty() {
        return additionalInformationParty;
    }

    /**
     * Legt den Wert der additionalInformationParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setAdditionalInformationParty(PartyType value) {
        this.additionalInformationParty = value;
    }

    /**
     * Ruft den Wert der documentProviderParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getDocumentProviderParty() {
        return documentProviderParty;
    }

    /**
     * Legt den Wert der documentProviderParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setDocumentProviderParty(PartyType value) {
        this.documentProviderParty = value;
    }

    /**
     * Ruft den Wert der tenderRecipientParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTenderRecipientParty() {
        return tenderRecipientParty;
    }

    /**
     * Legt den Wert der tenderRecipientParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTenderRecipientParty(PartyType value) {
        this.tenderRecipientParty = value;
    }

    /**
     * Ruft den Wert der contractResponsibleParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getContractResponsibleParty() {
        return contractResponsibleParty;
    }

    /**
     * Legt den Wert der contractResponsibleParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setContractResponsibleParty(PartyType value) {
        this.contractResponsibleParty = value;
    }

    /**
     * Gets the value of the tenderEvaluationParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tenderEvaluationParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTenderEvaluationParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getTenderEvaluationParty() {
        if (tenderEvaluationParty == null) {
            tenderEvaluationParty = new ArrayList<PartyType>();
        }
        return this.tenderEvaluationParty;
    }

    /**
     * Ruft den Wert der tenderValidityPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getTenderValidityPeriod() {
        return tenderValidityPeriod;
    }

    /**
     * Legt den Wert der tenderValidityPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setTenderValidityPeriod(PeriodType value) {
        this.tenderValidityPeriod = value;
    }

    /**
     * Ruft den Wert der contractAcceptancePeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getContractAcceptancePeriod() {
        return contractAcceptancePeriod;
    }

    /**
     * Legt den Wert der contractAcceptancePeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setContractAcceptancePeriod(PeriodType value) {
        this.contractAcceptancePeriod = value;
    }

    /**
     * Ruft den Wert der appealTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AppealTermsType }
     *     
     */
    public AppealTermsType getAppealTerms() {
        return appealTerms;
    }

    /**
     * Legt den Wert der appealTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AppealTermsType }
     *     
     */
    public void setAppealTerms(AppealTermsType value) {
        this.appealTerms = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the language property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LanguageType }
     * 
     * 
     */
    public List<LanguageType> getLanguage() {
        if (language == null) {
            language = new ArrayList<LanguageType>();
        }
        return this.language;
    }

    /**
     * Gets the value of the budgetAccountLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budgetAccountLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudgetAccountLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetAccountLineType }
     * 
     * 
     */
    public List<BudgetAccountLineType> getBudgetAccountLine() {
        if (budgetAccountLine == null) {
            budgetAccountLine = new ArrayList<BudgetAccountLineType>();
        }
        return this.budgetAccountLine;
    }

    /**
     * Ruft den Wert der replacedNoticeDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getReplacedNoticeDocumentReference() {
        return replacedNoticeDocumentReference;
    }

    /**
     * Legt den Wert der replacedNoticeDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setReplacedNoticeDocumentReference(DocumentReferenceType value) {
        this.replacedNoticeDocumentReference = value;
    }

}
