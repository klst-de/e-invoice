package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.untdid.codelist.TaxCategoryCode;

/**
 * used in
 * <br> AllowancesAndCharges, DOCUMENT LEVEL ALLOWANCES (BG-20) and CHARGES (BG-21)
 * <br> BG-23 VAT BREAKDOWN : BT-118 , BT-119
 * <br> BG-30 LINE VAT INFORMATION : BT-151
 */
public interface ITaxCategory extends ITaxType {
	
	// ALLOWANCES (BG-20) and CHARGES (BG-21) BT-95-0, BT-102-0
	// VAT BREAKDOWN BG-23.BT-118-0
	// LINE VAT INFORMATION : BG-30.BT-151-0
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTaxType(String type);
	@Override
	public String getTaxType();
	
	// ALLOWANCES (BG-20) and CHARGES (BG-21) BT-95, BT-102 (mandatory) Document level allowance/charge VAT category code
	// VAT BREAKDOWN BG-23.BT-118
	public void setTaxCategoryCode(String code);
	public void setTaxCategoryCode(TaxCategoryCode code);
	public TaxCategoryCode getTaxCategoryCode();
	
	// ALLOWANCES (BG-20) and CHARGES (BG-21) BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	// VAT BREAKDOWN BG-23.BT-119
	public void setTaxPercentage(BigDecimal percentage);
	public BigDecimal getTaxPercentage();
	
}
