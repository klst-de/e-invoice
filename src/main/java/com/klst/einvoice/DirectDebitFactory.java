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
	
	/**
	 * 
	 * @param mandateID              - BG-19.BT-89 Mandate reference identifier
	 * @param bankAssignedCreditorID - BG-19.BT-90
	 * @param iban                   - BG-19.BT-90
	 * 
	 * @return DirectDebit object
	 */
	public BG19_DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, IBANId iban);
	public BG19_DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, String debitedAccountID);
}
