package com.klst.einvoice;

import com.klst.einvoice.unece.uncefact.IBANId;

/**
 * abstract-factory, aka Kit for BG-19 DIRECT DEBIT
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */

/* Lastschriftverfahren BG-19
 * 
 * 
 * 
 */

public interface DirectDebitFactory {
	
	// alle para optional
	public DirectDebit createCreditTransfer(String mandateID, String bankAssignedCreditorID, IBANId iban);
	public DirectDebit createCreditTransfer(String mandateID, String bankAssignedCreditorID, String debitedAccountID);
}
