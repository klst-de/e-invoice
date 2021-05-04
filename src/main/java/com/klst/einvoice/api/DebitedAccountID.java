package com.klst.einvoice.api;

import com.klst.einvoice.unece.uncefact.IBANId;

/*
 *  a part of BG-19 0..1 DIRECT DEBIT 
 *  
 *  for the full definition of BG-19
 *  @see BG19_DirectDebit 
 */
public interface DebitedAccountID {
	
	/**
	 * Debited account identifier
	 * <p>
	 * The account to be debited by the direct debit.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BG-19.BT-91
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R69
	 * 
	 * @return Identifier IBAN aka bank account
	 */
	// BT-91 +++ 0..1 Debited account identifier
	// IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos
	public String getDebitedAccountID();
	public void setDebitedAccountID(IBANId iban);
	public void setDebitedAccountID(String accountId);
	
}
