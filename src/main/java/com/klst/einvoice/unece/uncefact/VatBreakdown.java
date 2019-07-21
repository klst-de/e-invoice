package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;

import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;

public class VatBreakdown extends TradeTaxType implements CoreInvoiceVatBreakdown {

	VatBreakdown() {
		super();
	}

	// copy ctor
	public VatBreakdown(TradeTaxType tradeTax) {
		this();
		init( new Amount(tradeTax.getBasisAmount().get(0).getValue())
			, new Amount(tradeTax.getCalculatedAmount().get(0).getValue())
			, TaxCategoryCode.valueOf(tradeTax.getCategoryCode())
			, tradeTax.getRateApplicablePercent()==null ? null : tradeTax.getRateApplicablePercent().getValue()
			);
		setTaxExemption(tradeTax.getExemptionReason()==null ? null : tradeTax.getExemptionReason().getValue()
				, tradeTax.getExemptionReasonCode()==null ? null : tradeTax.getExemptionReasonCode().getValue());
	}

	public VatBreakdown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal percent) {
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
	
	/* BT-118 1..1 CategoryCode
	 * BT-119 0..1 RateApplicablePercent, wg BR-DE-14 1.1
	 * 
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxCategoryAndRate(com.klst.untdid.codelist.TaxCategoryCode, java.math.BigDecimal)
	 */
	@Override
	public void setTaxCategoryCodeAndRate(TaxCategoryCode codeEnum, BigDecimal taxRate) {
		setTaxCategoryAndRate(codeEnum, CoreInvoiceVatBreakdown.VAT, taxRate==null ? null : new Percent(taxRate));
	}

	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCodeAndRate(code, null);	
	}

	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return TaxCategoryCode.valueOf(super.getCategoryCode());
	}

	@Override
	public void setTaxCategoryRate(BigDecimal taxableAmount) {
		// TODO Auto-generated method stub
		// use ctor
	}

	@Override
	public BigDecimal getTaxCategoryRate() {
		PercentType percent = super.getRateApplicablePercent();
		return percent==null ? null : percent.getValue();
	}

/*

            <ram:ApplicableTradeTax>
                <ram:CalculatedAmount>0</ram:CalculatedAmount>
                <ram:TypeCode>VAT</ram:TypeCode>
                <ram:ExemptionReason>als gemeinnützig anerkannt</ram:ExemptionReason>
                <ram:BasisAmount>120</ram:BasisAmount>
                <ram:CategoryCode>O</ram:CategoryCode>
                <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
            </ram:ApplicableTradeTax>


 */
	/**
	 * VAT exemption reason text and code
	 *
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxExemption(java.lang.String, java.lang.String)
	 */
	@Override
	public void setTaxExemption(String text, String id) {
		if(text!=null) {
			super.setExemptionReason(CrossIndustryInvoice.newTextType(text));
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

}
