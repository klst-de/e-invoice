package com.klst.einvoice;

import java.math.BigDecimal;

/**
 * used in
 * <br> AllowancesAndCharges, DOCUMENT LEVEL ALLOWANCES (BG-20) and CHARGES (BG-21)
 * <br> BG-23 VAT BREAKDOWN
 * <br> BG-30 LINE VAT INFORMATION
 */
public interface ITaxCategory {
	
	// ALLOWANCES (BG-20) and CHARGES (BG-21)
	// BT-95, BT-102 (mandatory) Document level allowance/charge VAT category code
	public void setVATCategory(String code);
	public String getVATCategory();
	
	// ALLOWANCES (BG-20) and CHARGES (BG-21)
	// BT-95-0, BT-102-0
	// nur CII, UBL const "VAT"
	public void setVATCode(String code);
	public String getVATCode();
	
	// ALLOWANCES (BG-20) and CHARGES (BG-21)
	// BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	public void setVATPercentage(BigDecimal percentage);
	public BigDecimal getVATPercentage();
	
}
