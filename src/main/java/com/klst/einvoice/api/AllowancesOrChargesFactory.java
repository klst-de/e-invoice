package com.klst.einvoice.api;

import java.math.BigDecimal;

import com.klst.edoc.api.IAmount;

public interface AllowancesOrChargesFactory {

	public AllowancesAndCharges createAllowance(IAmount amount, IAmount baseAmount, BigDecimal percentage);
	public AllowancesAndCharges createCharge(IAmount amount, IAmount baseAmount, BigDecimal percentage);

}
