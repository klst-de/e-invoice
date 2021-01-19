package com.klst.einvoice;

import com.klst.einvoice.unece.uncefact.IBANId;

/**
 * BG-19 ++ 0..1 DIRECT DEBIT 
 * <p>
 * A group of business terms to specify a direct debit.
 * <p>
 * This group may be used to give prior notice in the invoice that payment will be made through a SEPA or other direct debit
 * initiated by the Seller, in accordance with the rules of the SEPA or other direct debit scheme.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-19
 * <br>Rule ID: 	
 * <br>Request ID: 	R69
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

// CII:
// 0 .. 1 DirectDebitMandateID Kennung der Mandatsreferenz               BG-19/ BT-89
// 0 .. 1 CreditorReferenceID Kennung des Gläubigers                     BG-19/ BT-90
// 1 .. 1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos BG-19/ BT-91

/*  (de) rules / Geschäftsregel:
 * 
 * BR-DE-13 : Lastschriftverfahren: Gläubiger-ID
 * In der Rechnung müssen Angaben zu genau einer der drei Gruppen „CREDIT TRANSFER“ (BG-17), 
 * „PAYMENT CARD INFORMATION“ (BG-18) oder „DIRECT DEBIT“ (BG-19) übermittelt werden.
 * 
 */

public interface BG19_DirectDebit extends DirectDebit {
	
	/**
	 * Mandate reference identifier
	 * <p>
	 * Unique identifier assigned by the Payee for referencing the direct debit mandate.
	 * <p>
	 * Used in order to pre-notify the Buyer of a SEPA direct debit.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BG-19.BT-89
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R69
	 * 
	 * @return Identifier
	 */
	// BG-19.BT-89 0..1 Mandate reference identifier, DirectDebitMandateID, Kennung der Mandatsreferenz
	public String getMandateReferencedID();
	public void setMandateReferencedID(String id);

	// BG-19.BT-90 0..1 Bank assigned creditor identifier, CreditorReferenceID, Kennung des Gläubigers
	// Hinweis: Wird verwendet, um den Käufer vorweg über eine SEPA-Lastschrift in Kenntnis zu setzen.
	public String getBankAssignedCreditorID();
	public void setBankAssignedCreditorID(String id);
	
	// BG-19.BT-91 0..1 Debited account identifier
	// IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos
	public String getDebitedAccountID();
	public void setDebitedAccountID(String id); // non iban ist nicht vorgesehen, oder doch? "SEPA or other direct debit"
	public void setDebitedAccountID(IBANId iban);
	
}
