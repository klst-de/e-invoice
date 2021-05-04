package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.edoc.api.IAmount;
import com.klst.edoc.untdid.TaxCategoryCode;

public interface VatBreakdownFactory {
	
	/**
	 * Factory method to create a Business Group VAT BREAKDOWN BG-23
	 * 
	 * @param taxableAmount BT-116 1..1 (mandatory) VAT category taxable amount
	 * @param taxAmount     BT-117 1..1 (mandatory) VAT category tax amount
	 * @param code          BT-118 1..1 (mandatory) VAT category code
	 * @param taxRate       BT-119 0..1 (optional)  VAT category rate
	 * 
	 * @return VATBreakdown object
	 */
	public VatBreakdown createVATBreakDown(IAmount taxableAmount, IAmount taxAmount, TaxCategoryCode code, BigDecimal taxRate);

}
