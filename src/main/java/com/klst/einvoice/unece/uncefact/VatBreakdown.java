package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;

import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;

public class VatBreakdown extends TradeTaxType implements CoreInvoiceVatBreakdown{

	VatBreakdown() {
		super();
	}
	
	// copy ctor
	public VatBreakdown(TradeTaxType tradeTax) {
		this();
		// ...
	}

	public VatBreakdown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal percent) {
		this();
		init(taxableAmount, taxAmount, codeEnum, percent);
	}

//	private TradeTaxType makeTradeTaxType(TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
//		TradeTaxType tradeTax = new TradeTaxType();
//		
//		// USt/VAT
//		TaxTypeCodeType vat = new TaxTypeCodeType();
//		vat.setValue("VAT"); // TODO
//		tradeTax.setTypeCode(vat);
//		// taxCategory:
//		TaxCategoryCodeType taxCategory = new TaxCategoryCodeType();
//		taxCategory.setValue(taxCategoryCode.getValue());
//		tradeTax.setCategoryCode(taxCategory);
//		// taxRate:
//		PercentType percent = new PercentType();
//		percent.setValue(taxRate);
//		tradeTax.setRateApplicablePercent(percent);
//		
//		return tradeTax;
//	}


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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	/* BT-118   CategoryCode
	 * BT-118-0 TypeCode Code der Umsatzsteuerkategorie, Hinweis: Fester Wert = "VAT"
	 * BT-119   RateApplicablePercent, EN16931 0..1 (optional), wg BR-DE-14 1.1
	 */
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, String typeCode, Percent taxRate) {
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaxCategoryCode getTaxCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTaxCategoryRate(BigDecimal taxableAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getTaxCategoryRate() {
		// TODO Auto-generated method stub
		return null;
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
