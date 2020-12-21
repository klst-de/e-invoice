package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;

import com.klst.einvoice.BG23_VatBreakdown;
import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;

/*
 * BG-23 VAT BREAKDOWN 
 * <p>
 * A group of business terms providing information about VAT breakdown by different 
 * categories, rates and exemption reasons
 * 
 * <p>
 * BG-30 LINE VAT INFORMATION
 * <p>
 * A group of business terms providing information about the VAT applicable 
 * for the goods and services invoiced on the Invoice line.

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

 */
public class ApplicableTradeTax extends TradeTaxType implements BG23_VatBreakdown {

	ApplicableTradeTax() {
		super();
	}

	// copy ctor
	ApplicableTradeTax(TradeTaxType tradeTax) {
		this();
		init( new Amount(tradeTax.getBasisAmount().get(0).getValue())
			, new Amount(tradeTax.getCalculatedAmount().get(0).getValue())
			, TaxCategoryCode.valueOf(tradeTax.getCategoryCode())
			, tradeTax.getRateApplicablePercent()==null ? null : tradeTax.getRateApplicablePercent().getValue()
			);
		setTaxExemption(tradeTax.getExemptionReason()==null ? null : tradeTax.getExemptionReason().getValue()
				, tradeTax.getExemptionReasonCode()==null ? null : tradeTax.getExemptionReasonCode().getValue());
	}

	ApplicableTradeTax(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal percent) {
		this();
		init(taxableAmount, taxAmount, codeEnum, percent);
	}

	/**
	 * mandatory elements of VAT BREAKDOWN BG-23
	 * 
	 * @param taxableAmount BT-116 BasisAmount
	 * @param taxAmount     BT-117 CalculatedAmount
	 * @param codeEnum      BT-118 CategoryCode
	 * @param percent       BT-119 RateApplicablePercent
	 */
	void init(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal percent) {
		setTaxBaseAmount(taxableAmount);
		setCalculatedTaxAmount(taxAmount);
		setTaxCategoryCodeAndRate(codeEnum, percent);
	}

	/* BT-116 1..1 BasisAmount Steuerbasisbetrag
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxBaseAmount(com.klst.einvoice.unece.uncefact.Amount)
	 */
	@Override
	public void setTaxBaseAmount(Amount taxableAmount) {
		AmountType basisAmount = new AmountType();
		taxableAmount.copyTo(basisAmount);
		super.getBasisAmount().add(basisAmount);
	}

	@Override
	public Amount getTaxBaseAmount() {
		return new Amount(super.getBasisAmount().get(0).getValue());
	}

	/* BT-117 1..1 CalculatedAmount Kategoriespezifischer Steuerbetrag
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setCalculatedTaxAmount(com.klst.einvoice.unece.uncefact.Amount)
	 */
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

	/* BT-118   CategoryCode
	 * BT-118-0 TypeCode Code der Umsatzsteuerkategorie, Hinweis: Fester Wert = "VAT"
	 * BT-119   RateApplicablePercent, EN16931 0..1 (optional), wg BR-DE-14 1.1
	 */
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, String typeCode, Percent taxRate) {
		TaxCategoryCodeType taxCategory = new TaxCategoryCodeType();
		taxCategory.setValue(codeEnum.getValue());
		super.setCategoryCode(taxCategory);
		
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue(typeCode); // USt/VAT
		super.setTypeCode(taxTypeCode);
		
		if(taxRate!=null) {
			super.setRateApplicablePercent(taxRate);
		}
	}

	@Override
	public void setTaxCategoryCode(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTaxType(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTaxType() {
		// TODO Auto-generated method stub
		return null;
	}


	/* BT-118 1..1 CategoryCode
	 * BT-119 0..1 RateApplicablePercent, wg BR-DE-14 1.1
	 * 
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxCategoryAndRate(com.klst.untdid.codelist.TaxCategoryCode, java.math.BigDecimal)
	 */
	@Override
	public void setTaxCategoryCodeAndRate(TaxCategoryCode codeEnum, BigDecimal taxRate) {
		setTaxCategoryAndRate(codeEnum, TaxTypeCode.VAT, taxRate==null ? null : new Percent(taxRate));
	}

	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCodeAndRate(code, null);	
	}

//	@Override
//	public TaxCategoryCode getTaxCategoryCode() {
//		return TaxCategoryCode.valueOf(super.getCategoryCode());
//	}

	@Override
	public void setTaxPercentage(BigDecimal taxableAmount) {
		// TODO Auto-generated method stub
		// use ctor
	}

	@Override
	public BigDecimal getTaxPercentage() {
		PercentType percent = super.getRateApplicablePercent();
		return percent==null ? null : percent.getValue();
	}

/*
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

 */
	/**
	 * VAT exemption reason text (BT-120) and code (BT-121)
	 *
	 * @see com.klst.einvoice.BG23_VatBreakdown#setTaxExemption(java.lang.String, java.lang.String)
	 */
	@Override
	public void setTaxExemption(String text, String id) {
		if(text!=null) {
			super.setExemptionReason(new Text(text));
		}
		if(id!=null) {
			CodeType code = new CodeType();
			code.setValue(id);
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

}
