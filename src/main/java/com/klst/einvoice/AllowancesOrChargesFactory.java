package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.einvoice.unece.uncefact.Amount;

public interface AllowancesOrChargesFactory {

	public AllowancesAndCharges createAllowance(Amount amount, Amount baseAmount, BigDecimal percentage);
	public AllowancesAndCharges createCharge(Amount amount, Amount baseAmount, BigDecimal percentage);
	// demnächst:
//	public AllowancesAndCharges createAllowance(IAmount amount, IAmount baseAmount, BigDecimal percentage);
//	public AllowancesAndCharges createCharge(IAmount amount, IAmount baseAmount, BigDecimal percentage);

}
