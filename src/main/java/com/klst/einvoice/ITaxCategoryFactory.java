package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

public interface ITaxCategoryFactory {
	
	/**
	 * VAT/TaxCategory contains tax type, a category code and a rate
	 * <p>
	 * used in EN16931-IDs BG-23 VAT BREAKDOWN , 
	 * DOCUMENT LEVEL ALLOWANCES (BG-20) and CHARGES (BG-21) 
	 * and BG-30 LINE VAT INFORMATION
	 * <p>
	 * The VAT category code and the rate shall be consistent.
	 * 
	 * @param taxType BG-23.BT-118-0 , default is VAT
	 * @param taxCode BG-23.BT-118
	 * @param taxRate BG-23.BT-119
	 * 
	 * @return Tax category code and a rate
	 * 
	 * @see TaxTypeCode
	 * @see TaxCategoryCode
	 */
	public ITaxCategory createTaxCategory(TaxTypeCode taxType, TaxCategoryCode taxCode, BigDecimal taxRate);
	
	default ITaxCategory createTaxCategory(TaxCategoryCode taxCode, BigDecimal taxRate) {
		return createTaxCategory(TaxTypeCode.ValueAddedTax, taxCode, taxRate);
	}
}
