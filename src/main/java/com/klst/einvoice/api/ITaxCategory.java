package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.edoc.untdid.TaxCategoryCode;

/**
 * TaxCategory contains a category code and a rate
 * <p>
 * 
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
	
	/**
	 * VAT/tax category code 
	 * <p>
	 * Coded identification of a VAT/tax category, entries of UNTDID 5305
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-23.BT-118, also used in BG-20.BT-95 , BG-21.BT-102 and BG-30.BT-151
	 * <br>Rule ID: 	BR-47
	 * <br>Request ID: 	R38, R45, R49
	 * 
	 * @param code typically S for StandardRate
	 * 
	 * @see TaxCategoryCode defined in codelist UNTDID 5305
	 */
	// ALLOWANCES (BG-20) and CHARGES (BG-21) BT-95, BT-102 (mandatory) Document level allowance/charge VAT category code
	// VAT BREAKDOWN BG-23.BT-118
	public void setTaxCategoryCode(String code);
	default void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCode(code.getValue());
	}
	public TaxCategoryCode getTaxCategoryCode();
	
	/**
	 * VAT/tax category rate
	 * <p>
	 * The VAT /tax rate, represented as percentage that applies for the relevant VAT/tax category.
	 *  The VAT category code and the rate shall be consistent.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BG-23.BT-119, also used in BG-20.BT-96 , BG-21.BT-103 and BG-30.BT-152
	 * <br>Rule ID: 	BR-48 , BR-DE-14 (mandatory)
	 * <br>Request ID: 	R38, R49
	 * 
	 * @param taxRate
	 */
	/* BT-119 RateApplicablePercent Kategoriespezifischer Umsatzsteuersatz
	 * Besonderheit der XRechnung :
	 * Geschäftsregel: BR-DE-14 Das Element „VAT category rate“ (BT-119) muss übermittelt werden.
	 */
	// ALLOWANCES (BG-20) and CHARGES (BG-21) BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	// VAT BREAKDOWN BG-23.BT-119
	public void setTaxPercentage(BigDecimal taxRate);
	public BigDecimal getTaxPercentage();
	
}
