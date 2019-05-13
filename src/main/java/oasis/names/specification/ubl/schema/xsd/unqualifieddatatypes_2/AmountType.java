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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdvertisementAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AnnualAverageAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AverageAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AverageSubsequentContractAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BalanceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallBaseAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorporateStockAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorrectionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorrectionUnitAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditLineAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DebitLineAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredCarriageValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredCustomsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredForCarriageValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeclaredStatisticsValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentationFeeAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedOverallContractAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FaceValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FeeAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreeOnBoardValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HigherTenderAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InsurancePremiumAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InsuranceValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InventoryValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LiabilityAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LowerTenderAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarketValueAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumAdvertisementAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumPaidAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PartyCapacityAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAlternativeAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableRoundingAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PenaltyAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerUnitAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrepaidAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredFeeAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoundingAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SettlementDiscountAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyBalanceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyOnAccountAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThresholdAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalBalanceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalCreditAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalDebitAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalInvoiceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalPaymentAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalTaskAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TotalTaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransactionCurrencyTaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueAmountType;


/**
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT000001&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Amount. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A number of monetary units specified using a given unit of currency.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Amount&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 *             
 * 
 * <p>Java-Klasse für AmountType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AmountType">
 *   &lt;simpleContent>
 *     &lt;restriction base="&lt;urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2>AmountType">
 *       &lt;attribute name="currencyID" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *     &lt;/restriction>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType")
@XmlSeeAlso({
    BaseAmountType.class,
    DeclaredStatisticsValueAmountType.class,
    PayableAlternativeAmountType.class,
    PayableAmountType.class,
    MaximumAdvertisementAmountType.class,
    TaxEnergyAmountType.class,
    EstimatedOverallContractAmountType.class,
    InventoryValueAmountType.class,
    DocumentationFeeAmountType.class,
    PayableRoundingAmountType.class,
    MaximumAmountType.class,
    oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType.class,
    HigherTenderAmountType.class,
    DeclaredCarriageValueAmountType.class,
    ChargeTotalAmountType.class,
    FeeAmountType.class,
    TotalPaymentAmountType.class,
    TaxEnergyOnAccountAmountType.class,
    TaxExclusiveAmountType.class,
    TaxInclusiveAmountType.class,
    LineExtensionAmountType.class,
    DebitLineAmountType.class,
    PartyCapacityAmountType.class,
    ValueAmountType.class,
    CorrectionAmountType.class,
    PriceAmountType.class,
    RoundingAmountType.class,
    PenaltyAmountType.class,
    LowerTenderAmountType.class,
    CorrectionUnitAmountType.class,
    BalanceAmountType.class,
    AllowanceTotalAmountType.class,
    TaxAmountType.class,
    AverageSubsequentContractAmountType.class,
    LiabilityAmountType.class,
    TransactionCurrencyTaxAmountType.class,
    TotalTaxAmountType.class,
    CallBaseAmountType.class,
    MaximumPaidAmountType.class,
    TotalAmountType.class,
    CorporateStockAmountType.class,
    RequiredFeeAmountType.class,
    AdvertisementAmountType.class,
    PaidAmountType.class,
    TotalInvoiceAmountType.class,
    ThresholdAmountType.class,
    TaxableAmountType.class,
    InsurancePremiumAmountType.class,
    FreeOnBoardValueAmountType.class,
    PerUnitAmountType.class,
    CallExtensionAmountType.class,
    CreditLineAmountType.class,
    PrepaidAmountType.class,
    AnnualAverageAmountType.class,
    DeclaredForCarriageValueAmountType.class,
    MinimumAmountType.class,
    FaceValueAmountType.class,
    SettlementDiscountAmountType.class,
    TotalTaskAmountType.class,
    TotalCreditAmountType.class,
    EstimatedAmountType.class,
    TotalBalanceAmountType.class,
    TaxEnergyBalanceAmountType.class,
    InsuranceValueAmountType.class,
    AverageAmountType.class,
    TotalDebitAmountType.class,
    MarketValueAmountType.class,
    DeclaredCustomsValueAmountType.class
})
public class AmountType
    extends un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.AmountType
{


}
