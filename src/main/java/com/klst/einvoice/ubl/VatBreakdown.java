package com.klst.einvoice.ubl;

import java.math.BigDecimal;

import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;

public class VatBreakdown extends TaxSubtotalType implements CoreInvoiceVatBreakdown {

	VatBreakdown() {
		super();
	}

	// copy ctor
	public VatBreakdown(TaxSubtotalType tradeTax) {
		this();
		init( new Amount(tradeTax.getTaxableAmount().getValue())
			, new Amount(tradeTax.getTaxAmount().getValue())
			, TaxCategoryCode.valueOf(tradeTax.getTaxCategory())
			, tradeTax.getTaxCategory().getPercent()==null ? null : tradeTax.getTaxCategory().getPercent().getValue()
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
		setTaxBaseAmount(taxableAmount);
		setCalculatedTaxAmount(taxAmount);
		setTaxCategoryCodeAndRate(codeEnum, percent);
	}

	@Override
	public void setTaxBaseAmount(Amount taxBaseAmount) {
		TaxableAmountType amount = new TaxableAmountType();
		taxBaseAmount.copyTo(amount);
		super.setTaxableAmount(amount);
	}

	@Override
	public Amount getTaxBaseAmount() {
		return new Amount(super.getTaxableAmount().getValue());
	}

	@Override
	public void setCalculatedTaxAmount(Amount taxAmount) {
		TaxAmountType amount = new TaxAmountType();
		taxAmount.copyTo(amount);
		super.setTaxAmount(amount);
	}

	@Override
	public Amount getCalculatedTaxAmount() {
		return new Amount(super.getTaxAmount().getValue());
	}

	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, String vat, Percent taxRate) {
		TaxCategoryType taxCategory = new TaxCategoryType();
		taxCategory.setID(Invoice.newIDType(codeEnum.getValue(), null));
		
		TaxSchemeType taxScheme = new TaxSchemeType();
		taxScheme.setID(Invoice.newIDType(vat, null)); // USt/VAT
		taxCategory.setTaxScheme(taxScheme);
		
		if(taxRate!=null) {
			taxCategory.setPercent(taxRate);
		}
            
		super.setTaxCategory(taxCategory);
	}

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
		return TaxCategoryCode.valueOf(super.getTaxCategory());
	}

	@Override
	public void setTaxCategoryRate(BigDecimal taxableAmount) {
		// use ctor
	}

	@Override
	public BigDecimal getTaxCategoryRate() {
		PercentType percent = super.getTaxCategory().getPercent();
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
