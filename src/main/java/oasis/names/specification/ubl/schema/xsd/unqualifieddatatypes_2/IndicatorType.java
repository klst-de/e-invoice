//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AcceptedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdValoremIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnimalFoodApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnimalFoodIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AuctionConstraintIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BackOrderAllowedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BalanceBroughtForwardIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BasedOnConsensusIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BindingOnBuyerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BulkCargoIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CandidateReductionConstraintIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CatalogueIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompletionIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsolidatableIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ContainerizedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CopyIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomsImportClassifiedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DangerousGoodsApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FollowupContractIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreeOfChargeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FrozenDocumentIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FullyPaidSharesIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GeneralCargoIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GovernmentAgreementConstraintIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousRiskIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumanFoodApprovedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HumanFoodIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IndicationIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemUpdateRequestIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LegalStatusIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LivestockIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkAttentionIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkCareIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OnCarriageIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OptionalLineItemIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderableIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OtherConditionsIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PartialDeliveryIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PowerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreCarriageIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrepaidIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PricingUpdateRequestIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrizeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PublishAwardIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RefrigeratedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RefrigerationOnIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredCurriculaIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReturnabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReturnableMaterialIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SoleProprietorshipIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialSecurityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SplitConsignmentIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StatusAvailableIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEvidenceIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxIncludedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThirdPartyPayerIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ToOrderIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UnknownPriceIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.VariantConstraintIndicatorType;


/**
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000012&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Indicator. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A list of two mutually exclusive Boolean values that express the only possible states
 *                     of a property.
 *                 &lt;/ccts:Definition&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Indicator&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 *             
 * 
 * <p>Java-Klasse für IndicatorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="IndicatorType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>boolean">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndicatorType", propOrder = {
    "value"
})
@XmlSeeAlso({
    MarkAttentionIndicatorType.class,
    AnimalFoodApprovedIndicatorType.class,
    LegalStatusIndicatorType.class,
    RefrigerationOnIndicatorType.class,
    RequiredCurriculaIndicatorType.class,
    VariantConstraintIndicatorType.class,
    IndicationIndicatorType.class,
    ToOrderIndicatorType.class,
    PartialDeliveryIndicatorType.class,
    PowerIndicatorType.class,
    BalanceBroughtForwardIndicatorType.class,
    BindingOnBuyerIndicatorType.class,
    AuctionConstraintIndicatorType.class,
    CandidateReductionConstraintIndicatorType.class,
    StatusAvailableIndicatorType.class,
    HumanFoodApprovedIndicatorType.class,
    SoleProprietorshipIndicatorType.class,
    PricingUpdateRequestIndicatorType.class,
    BackOrderAllowedIndicatorType.class,
    ThirdPartyPayerIndicatorType.class,
    FullyPaidSharesIndicatorType.class,
    CompletionIndicatorType.class,
    AcceptedIndicatorType.class,
    AnimalFoodIndicatorType.class,
    FreeOfChargeIndicatorType.class,
    SpecialSecurityIndicatorType.class,
    FollowupContractIndicatorType.class,
    TaxEvidenceIndicatorType.class,
    DangerousGoodsApprovedIndicatorType.class,
    OptionalLineItemIndicatorType.class,
    ReturnabilityIndicatorType.class,
    OrderableIndicatorType.class,
    CopyIndicatorType.class,
    SplitConsignmentIndicatorType.class,
    HazardousRiskIndicatorType.class,
    PrizeIndicatorType.class,
    UnknownPriceIndicatorType.class,
    TaxIncludedIndicatorType.class,
    ItemUpdateRequestIndicatorType.class,
    CustomsImportClassifiedIndicatorType.class,
    ChargeIndicatorType.class,
    MarkCareIndicatorType.class,
    BulkCargoIndicatorType.class,
    GeneralCargoIndicatorType.class,
    PublishAwardIndicatorType.class,
    FrozenDocumentIndicatorType.class,
    LivestockIndicatorType.class,
    GovernmentAgreementConstraintIndicatorType.class,
    HumanFoodIndicatorType.class,
    ConsolidatableIndicatorType.class,
    OtherConditionsIndicatorType.class,
    RefrigeratedIndicatorType.class,
    ReturnableMaterialIndicatorType.class,
    PreCarriageIndicatorType.class,
    OnCarriageIndicatorType.class,
    ContainerizedIndicatorType.class,
    AdValoremIndicatorType.class,
    CatalogueIndicatorType.class,
    PrepaidIndicatorType.class,
    BasedOnConsensusIndicatorType.class
})
public class IndicatorType {

    @XmlValue
    protected boolean value;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     */
    public boolean isValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     */
    public void setValue(boolean value) {
        this.value = value;
    }

}
