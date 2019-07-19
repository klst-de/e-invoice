package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;

import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;

public class VatBreakdown extends TradeTaxType implements CoreInvoiceVatBreakdown{

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
		setTaxableAmount(taxableAmount);
		setTaxAmount(taxAmount);
		setTaxCategoryAndRate(codeEnum, percent);
	}

	/* BT-116 1..1 BasisAmount Steuerbasisbetrag
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxableAmount(com.klst.einvoice.unece.uncefact.Amount)
	 */
	@Override
	public void setTaxableAmount(Amount taxableAmount) {
		AmountType basisAmount = new AmountType();
		taxableAmount.copyTo(basisAmount);
		super.getBasisAmount().add(basisAmount);
	}

	@Override
	public Amount getTaxableAmount() {
//		super.getBasisAmount().get(0); // wg. 1.1 möglich
		return new Amount(super.getBasisAmount().get(0).getValue());
	}

	/* BT-117 1..1 CalculatedAmount Kategoriespezifischer Steuerbetrag
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxAmount(com.klst.einvoice.unece.uncefact.Amount)
	 */
	@Override
	public void setTaxAmount(Amount taxAmount) {
		AmountType calculatedAmount = new AmountType();
		taxAmount.copyTo(calculatedAmount);
		super.getCalculatedAmount().add(calculatedAmount);		
	}

	@Override
	public Amount getTaxAmount() {
		return new Amount(super.getCalculatedAmount().get(0).getValue());
	}

	/* BT-118   CategoryCode
	 * BT-118-0 TypeCode Code der Umsatzsteuerkategorie, Hinweis: Fester Wert = "VAT"
	 * BT-119   RateApplicablePercent, EN16931 0..1 (optional), wg BR-DE-14 1.1
	 */
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, String typeCode, Percent taxRate) {
		TaxCategoryCodeType taxCategory = new TaxCategoryCodeType();
		taxCategory.setValue(codeEnum.getValue());
		this.setCategoryCode(taxCategory);
		
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
	public void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal taxRate) {
		setTaxCategoryAndRate(codeEnum, CoreInvoiceVatBreakdown.VAT, taxRate==null ? null : new Percent(taxRate));
	}

	@Override
	public void setTaxCategory(TaxCategoryCode code) {
		setTaxCategoryAndRate(code, null);	
	}

	@Override
	public TaxCategoryCode getTaxCategory() {
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

	@Override
	public void setTaxExemption(String text, String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTaxExemptionReasonText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaxExemptionReasonCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
