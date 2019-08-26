package com.klst.einvoice;

import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;

/**
 * abstract-factory, aka Kit for BG-17 CREDIT TRANSFER
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */

/* Überweisung BG-17
 * 
 * 
 * 
 */

public interface CreditTransferFactory {
	
//	static final Logger LOG = Logger.getLogger(CreditTransferFactory.class.getName());
//
//	static final String NOT_IMPEMENTED = "NOT IMPEMENTED";
//
//	public static CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) { // SEPA Überweisung
//		LOG.warning(NOT_IMPEMENTED);
//		return null;
//	}
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic); // SEPA Überweisung
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic); // non SEPA
}
