package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;

import com.klst.einvoice.ITaxCategory;
import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;

//<ram:TypeCode>VAT</ram:TypeCode>
//<ram:CategoryCode>E</ram:CategoryCode>
//<ram:RateApplicablePercent>0</ram:RateApplicablePercent>

/*  verwendet in

EN16931-ID: BT-151-0         - BG-30 LINE VAT INFORMATION
EN16931-ID: BT-118-0         - BG-23 VAT BREAKDOWN
EN16931-ID: BT-95-0 BT-102-0 - DOCUMENT LEVEL ALLOWANCES (BG-20) and CHARGES (BG-21)

 */
public class CategoryTradeTax extends TradeTaxType implements ITaxCategory {

	CategoryTradeTax() {
		super();
	}

	// copy ctor
	CategoryTradeTax(TradeTaxType tradeTaxType) {
		this();
		setTaxType(tradeTaxType.getTypeCode().getValue());
		setTaxCategoryCode(tradeTaxType.getCategoryCode().getValue());
		if(tradeTaxType.getRateApplicablePercent()==null) return;
		setTaxPercentage(tradeTaxType.getRateApplicablePercent().getValue());
	}
	
	CategoryTradeTax(String type, String code, Percent rate) {
		this();
		setTaxType(type);
		setTaxCategoryCode(code);
		setTaxPercentage(rate);
	}
	
	CategoryTradeTax(String type, String code, BigDecimal rate) {
		this(type, code, rate==null? null : new Percent(rate));
	}
	
	public CategoryTradeTax(TaxTypeCode type, TaxCategoryCode code, Percent rate) {
		this(type.getValue(), code.getValue(), rate);
	}
	
	public CategoryTradeTax(TaxCategoryCode code, Percent rate) {
		this(TaxTypeCode.ValueAddedTax, code, rate);
	}
	
	// ALLOWANCES (BG-20.BT-95-0) and CHARGES (BG-21.BT-102-0)
	// BG-23.BT-118-0
	@Override
	public void setTaxType(String type) {
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue(type);
		super.setTypeCode(taxTypeCode);		
	}
	@Override
	public String getTaxType() {
		return super.getTypeCode().getValue();
	}
	
	// BT-95, BT-102 (mandatory) Document level allowance/charge VAT category code
	// BG-23.BT-118
	@Override
	public void setTaxCategoryCode(String code) {
		TaxCategoryCodeType taxCategoryCode = new TaxCategoryCodeType();
		taxCategoryCode.setValue(code);
		super.setCategoryCode(taxCategoryCode);
	}
	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCode(code.getValue());
	}
	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return TaxCategoryCode.valueOf(super.getCategoryCode());
	}

	// BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	// BG-23.BT-119
	@Override
	public void setTaxPercentage(BigDecimal rate) {
		setTaxPercentage(new Percent(rate));
	}
	public void setTaxPercentage(Percent rate) {
		if(rate!=null) super.setRateApplicablePercent(rate);
	}
	
	@Override
	public BigDecimal getTaxPercentage() {
		return super.getRateApplicablePercent()==null? null : getRateApplicablePercent().getValue();
	}

}
