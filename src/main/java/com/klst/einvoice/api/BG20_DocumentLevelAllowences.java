package com.klst.einvoice;

import java.math.BigDecimal;
import java.util.List;

import com.klst.einvoice.unece.uncefact.Amount;

/**
 * Common Interface for optional DOCUMENT LEVEL ALLOWANCES (BG-20) and CHARGES (BG-21) and
 *                               INVOICE LINE ALLOWANCES (BG-27) and CHARGES (BG-28)
 * <p>
 * BG-20 0..n DOCUMENT LEVEL ALLOWANCES / ABSCHLÄGE
 * <br>
 * BG-21 0..n DOCUMENT LEVEL CHARGES / ZUSCHLÄGE
 * <br>
 * BG-27 0..n INVOICE LINE ALLOWANCES / ABSCHLÄGE
 * <br>
 * BG-28 0..n INVOICE LINE CHARGES / ZUSCHLÄGE
 * 
 * <p>
 * <p>
 * Cardinality: 	0..n
 * <br>EN16931-ID: 	BG-20 / BG-21 / BG-27 / BG-28
 * <br>Rule ID: 	
 * <br>Request ID: 	R15, R18
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
public interface BG20_DocumentLevelAllowences extends AllowancesOrChargesFactory {

	/**
	 * add an allowance or charge
	 * 
	 * @param allowanceOrCharge
	 */
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge);
	
	public List<AllowancesAndCharges> getAllowancesAndCharges();

	default void addAllowance(Amount amount, Amount baseAmount, BigDecimal percentage) {
		addAllowanceCharge(createAllowance(amount, baseAmount, percentage));
	}
	
	default void addCharge(Amount amount, Amount baseAmount, BigDecimal percentage) {
		addAllowanceCharge(createCharge(amount, baseAmount, percentage));
	}
	
}
