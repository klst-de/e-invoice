package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.util.logging.Logger;

import com.klst.einvoice.BG23_VatBreakdown;
import com.klst.einvoice.ITaxCategory;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;

/*  verwendet in

EN16931-ID: BT-151-0         - BG-30 LINE VAT INFORMATION
EN16931-ID: BT-118-0         - BG-23 VAT BREAKDOWN
EN16931-ID: BT-95-0 BT-102-0 - DOCUMENT LEVEL ALLOWANCES (BG-20) and CHARGES (BG-21)

01.04a-INVOICE_uncefact.xml :
...
            <ram:SpecifiedLineTradeSettlement>
                <ram:ApplicableTradeTax>                                              <!-- BG-30 LINE VAT INFORMATION -->
                    <ram:TypeCode>VAT</ram:TypeCode>
                    <ram:CategoryCode>O</ram:CategoryCode>
                </ram:ApplicableTradeTax>
                <ram:SpecifiedTradeSettlementLineMonetarySummation>
                    <ram:LineTotalAmount>120</ram:LineTotalAmount>
                </ram:SpecifiedTradeSettlementLineMonetarySummation>
            </ram:SpecifiedLineTradeSettlement>
        </ram:IncludedSupplyChainTradeLineItem>

        <ram:ApplicableHeaderTradeSettlement>
... 
            <ram:ApplicableTradeTax>                                                  <!-- BG-23 VAT BREAKDOWN -->
                <ram:CalculatedAmount>0</ram:CalculatedAmount>
                <ram:TypeCode>VAT</ram:TypeCode>
                <ram:ExemptionReason>als gemeinnützig anerkannt</ram:ExemptionReason> <!-- BT-120 -->
                <ram:BasisAmount>120</ram:BasisAmount>
                <ram:CategoryCode>O</ram:CategoryCode>
                <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
            </ram:ApplicableTradeTax>

0..n ApplicableTradeTax  BG-23 VAT BREAKDOWN 
     Umsatzsteueraufschlüsselung
1 .. 1 CalculatedAmount           Kategoriespezifischer Steuerbetrag                             BT-117
1 .. 1 TypeCode                   Code der Umsatzsteuerkategorie                                 BT-118-0
0 .. 1 ExemptionReason            Grund der Steuerbefreiung (Freitext)                           BT-120
1 .. 1 BasisAmount                Steuerbasisbetrag                                              BT-116
0 .. 1 LineTotalBasisAmount       Warenbetrag des Steuersatzes
0 .. 1 AllowanceChargeBasisAmount Gesamtbetrag Zu- und Abschläge des Steuersatzes auf Dokumentenebene
1 .. 1 CategoryCode               Codierte Bezeichnung einer Umsatzsteuerkategorie               BT-118
0 .. 1 ExemptionReasonCode        Code für den Umsatzsteuerbefreiungsgrund                       BT-121
0 .. 1 TaxPointDate               Datum der Steuerfälligkeit xs:choice
1 .. 1 DateString                 Datum der Steuerfälligkeit, Wert                               BT-7 
required format                   Datum, Format                                                  BT-7-0
0 .. 1 DueDateTypeCode            Code für das Datum der Steuerfälligkeit                        BT-8
0 .. 1 RateApplicablePercent      Kategoriespezifischer Umsatzsteuersatz                         BT-119

     
1..n ApplicableTradeTax  BG-30 LINE VAT INFORMATION
     Umsatzsteuerinformationen auf der Ebene der Rechnungsposition 
0 .. 1 CalculatedAmount      Steuerbetrag
1 .. 1 TypeCode              Steuerart (Code)                                                    BT-151-0
0 .. 1 ExemptionReason       Grund der Steuerbefreiung (Freitext)
1 .. 1 CategoryCode          Code der Umsatzsteuerkategorie des in Rechnung gestellten Artikels  BT-151
0 .. 1 ExemptionReasonCode   Code für den Umsatzsteuerbefreiungsgrund
0 .. 1 RateApplicablePercent Umsatzsteuersatz für den in Rechnung gestellten Artikel             BT-152

Beispiel  ALLOWANCES (BG-20) and CHARGES (BG-21) :

CII: ApplicableHeaderTradeSettlement ...
            <ram:SpecifiedTradeAllowanceCharge>                    <!-- DOCUMENT LEVEL ALLOWANCES (BG-20) / CHARGES (BG-21)
                <ram:ChargeIndicator>
                    <udt:Indicator>true</udt:Indicator>            <!-- true ==> CHARGE = true
                </ram:ChargeIndicator>
                <ram:CalculationPercent>0</ram:CalculationPercent>
                <ram:BasisAmount>0</ram:BasisAmount>
                <ram:ActualAmount>0</ram:ActualAmount>
                <ram:ReasonCode>TAC</ram:ReasonCode>
                <ram:Reason>Testing</ram:Reason>
                <ram:CategoryTradeTax>                             <!-- BT-95-0 BT-102-0 
                    <ram:TypeCode>VAT</ram:TypeCode>
                    <ram:CategoryCode>E</ram:CategoryCode>
                    <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
                </ram:CategoryTradeTax>
            </ram:SpecifiedTradeAllowanceCharge>
            
            <ram:SpecifiedTradeAllowanceCharge>
                <ram:ChargeIndicator>
                    <udt:Indicator>false</udt:Indicator>            <!-- false ==> ALLOWANCE
                </ram:ChargeIndicator>
                <ram:CalculationPercent>0</ram:CalculationPercent>
                <ram:BasisAmount>0</ram:BasisAmount>
                <ram:ActualAmount>0</ram:ActualAmount>
                <ram:ReasonCode>102</ram:ReasonCode>
                <ram:Reason>Fixed long term</ram:Reason>
                <ram:CategoryTradeTax>
                    <ram:TypeCode>VAT</ram:TypeCode>
                    <ram:CategoryCode>E</ram:CategoryCode>
                    <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
                </ram:CategoryTradeTax>
            </ram:SpecifiedTradeAllowanceCharge>

 */

// replaces ApplicableTradeTax and CategoryTradeTax
public class TradeTax extends TradeTaxType implements BG23_VatBreakdown, ITaxCategory {

	// factory for VatBreakdown
	static BG23_VatBreakdown createVATBreakDown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode taxCode, BigDecimal taxRate) {
		return new TradeTax(taxableAmount, taxAmount, taxCode, taxRate);
	}

	/**
	 * factory methods to be used for TradeAllowanceCharge (which implements AllowancesAndCharges)
	 * 
	 * @param taxType
	 * @param taxCode
	 * @param taxRate or taxPercent
	 * @return
	 */ 
	static ITaxCategory createTaxCategory(TaxTypeCode taxType, TaxCategoryCode taxCode, Percent taxPercent) {
		return new TradeTax(taxType.getValue(), taxCode, taxPercent);
	}
	static ITaxCategory createTaxCategory(TaxCategoryCode taxCode, Percent taxPercent) {
		return new TradeTax(TaxTypeCode.ValueAddedTax.getValue(), taxCode, taxPercent);
	}
	static ITaxCategory createTaxCategory(String taxType, TaxCategoryCode taxCode, BigDecimal taxRate) {
		return new TradeTax(taxType, taxCode, taxRate);
	}

	private static final Logger LOG = Logger.getLogger(TradeTax.class.getName());

	private TradeTax(Amount taxableAmount, Amount taxAmount, TaxCategoryCode taxCode, BigDecimal taxRate) {
		setTaxBaseAmount(taxableAmount);
		setCalculatedTaxAmount(taxAmount);
		setTaxCategoryCodeAndRate(taxCode, taxRate);
		
	}
	private TradeTax(String taxType, TaxCategoryCode taxCode, Percent taxPercent) {
		super();
		setTaxType(taxType);
		setTaxCategoryCode(taxCode);
		setTaxPercentage(taxPercent);
	}
	
	private TradeTax(String taxType, TaxCategoryCode taxCode, BigDecimal taxRate) {
		super();
		setTaxType(taxType);
		setTaxCategoryCode(taxCode);
		setTaxPercentage(taxRate);
	}
	
	// copy ctor
	TradeTax(TradeTaxType doc) {
		super();
		if(doc!=null) {
			CopyCtor.invokeCopy(this, doc);
		}
		LOG.info("--------------------copy ctor:"+this);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[TaxBaseAmount:");
		stringBuilder.append(getTaxBaseAmount()==null ? "null" : getTaxBaseAmount());
		stringBuilder.append(", CalculatedTaxAmount:");
		stringBuilder.append(getCalculatedTaxAmount()==null ? "null" : getCalculatedTaxAmount());
		stringBuilder.append(", TaxCategoryCode:");
		stringBuilder.append(getTaxCategoryCode()==null ? "null" : getTaxCategoryCode());
		stringBuilder.append(", TaxCategoryRate:");
		stringBuilder.append(getTaxPercentage()==null ? "null" : getTaxPercentage());
		if(this.getTaxPointDate()!=null) {
			stringBuilder.append(", TaxPointDate:");
			stringBuilder.append(ApplicableHeaderTradeSettlement.taxPointDateAsTimestamp(getTaxPointDate()));			
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	// BT-116 1..1 BasisAmount Steuerbasisbetrag
	@Override
	public void setTaxBaseAmount(Amount taxBaseAmount) {
		AmountType basisAmount = new AmountType();
		taxBaseAmount.copyTo(basisAmount);
		super.getBasisAmount().add(basisAmount);
	}
	@Override
	public Amount getTaxBaseAmount() {
		return new Amount(super.getBasisAmount().get(0).getValue());
	}

	// BT-117 1..1 CalculatedAmount Kategoriespezifischer Steuerbetrag
	@Override
	public void setCalculatedTaxAmount(Amount taxAmount) {
		AmountType calculatedAmount = new AmountType();
		taxAmount.copyTo(calculatedAmount);
		super.getCalculatedAmount().add(calculatedAmount);		
	}

	@Override
	public Amount getCalculatedTaxAmount() {
		return new Amount(super.getCalculatedAmount().get(0).getValue());
	}

	// ALLOWANCES (BG-20.BT-95-0) and CHARGES (BG-21.BT-102-0)
	// BG-23.BT-118-0
	@Override
	public void setTaxType(String code) {
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue(code);
		super.setTypeCode(taxTypeCode);		
	}

	@Override
	public String getTaxType() {
		return super.getTypeCode().getValue();
	}

	// BT-95, BT-102 (mandatory) Document level allowance/charge VAT category code
	// BG-23.BT-118 (mandatory)
	@Override
	public void setTaxCategoryCode(String code) {
		TaxCategoryCodeType taxCategoryCode = new TaxCategoryCodeType();
		taxCategoryCode.setValue(code);
		super.setCategoryCode(taxCategoryCode);
	}
	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCode(code.getValue());  // TODO default in IF
	}
	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return TaxCategoryCode.valueOf(super.getCategoryCode());
	}

	/* BT-118 1..1 CategoryCode
	 * BT-119 0..1 RateApplicablePercent, wg BR-DE-14 1.1
	 * 
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxCategoryAndRate(com.klst.untdid.codelist.TaxCategoryCode, java.math.BigDecimal)
	 */
	@Override
	public void setTaxCategoryCodeAndRate(TaxCategoryCode codeEnum, BigDecimal taxRate) {
		setTaxCategoryAndRate(TaxTypeCode.VAT, codeEnum, taxRate);
	}
	/* 
	 * BT-118-0 TypeCode Code der Umsatzsteuerkategorie, Hinweis: Fester Wert = "VAT"
	 * BT-118   CategoryCode
	 * BT-119   RateApplicablePercent, EN16931 0..1 (optional), wg BR-DE-14 1.1
	 */
	void setTaxCategoryAndRate(String type, TaxCategoryCode code, BigDecimal rate) {
		setTaxCategoryCode(code.getValue());
		setTaxType(type);	
		setTaxPercentage(rate);
	}

	// BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	// BG-23.BT-119
	@Override
	public void setTaxPercentage(BigDecimal taxRate) {
		setTaxPercentage(new Percent(taxRate));
	}
	public void setTaxPercentage(Percent rate) {
		if(rate!=null) super.setRateApplicablePercent(rate);
	}

	@Override
	public BigDecimal getTaxPercentage() {
		return super.getRateApplicablePercent()==null? null : getRateApplicablePercent().getValue();
	}

	/**
	 * VAT exemption reason text (BT-120) and code (BT-121)
	 *
	 * @see com.klst.einvoice.BG23_VatBreakdown#setTaxExemption(java.lang.String, java.lang.String)
	 */
	@Override
	public void setTaxExemption(String text, String codeId) {
		if(text!=null) {
			super.setExemptionReason(new Text(text));
		}
		if(codeId!=null) {
			CodeType code = new CodeType();
			code.setValue(codeId);
			super.setExemptionReasonCode(code);
		}
	}

	@Override
	public String getTaxExemptionReasonText() {
		return super.getExemptionReason()==null ? null : super.getExemptionReason().getValue();
	}

	@Override
	public String getTaxExemptionReasonCode() {
		return super.getExemptionReasonCode()==null ? null : super.getExemptionReasonCode().getValue();
	}

}