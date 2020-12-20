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

	CategoryTradeTax(String type, String code, Percent rate) {
		this();
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue(type);
		super.setTypeCode(taxTypeCode);
		
		TaxCategoryCodeType taxCategoryCode = new TaxCategoryCodeType();
		taxCategoryCode.setValue(code);
		super.setCategoryCode(taxCategoryCode);
		
		if(rate!=null) super.setRateApplicablePercent(rate);;
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
	
	// BT-95, BT-102 (mandatory) Document level allowance/charge VAT category code
	@Override
	public void setVATCategory(String code) {
		
	}
	@Override
	public String getVATCategory() {
		return super.getCategoryCode().getValue();
	}
	// BT-95-0, BT-102-0
	@Override
	public void setVATCode(String code) {
		
	}
	@Override
	public String getVATCode() {
		return super.getTypeCode().getValue();
	}

	// BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	@Override
	public void setVATPercentage(BigDecimal percentage) {
		
	}
	
	@Override
	public BigDecimal getVATPercentage() {
		return super.getRateApplicablePercent()==null? null : getRateApplicablePercent().getValue();
	}

}
