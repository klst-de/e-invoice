package com.klst.einvoice;

import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;

/**
 * BG-17 0..n CREDIT TRANSFER
 * <p>
 * A group of business terms to specify credit transfer payments.
 * <p>
 * Cardinality: 0..n
 * <br>EN16931-ID: 	BG-17
 * <br>Rule ID: 	
 * <br>Request ID: 	R58
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

// 0 .. 1 PayeePartyCreditorFinancialAccount Überweisung BG-17

/*  (de) rules / Geschäftsregel:
 * 
 * BR-DE-13 : Lastschriftverfahren: Gläubiger-ID
 * In der Rechnung müssen Angaben zu genau einer der drei Gruppen „CREDIT TRANSFER“ (BG-17), 
 * „PAYMENT CARD INFORMATION“ (BG-18) oder „DIRECT DEBIT“ (BG-19) übermittelt werden.
 * 
 * BR-50 : Kontoinformationen 
 * Falls in der Rechnung Überweisungsinformationen (BG-17) angegeben sind, muss eine Kennung des Zahlungskontos (BT-84) vorhanden sein. 
 * ANMERKUNG: In der EN 16931-1 wird an dieser Stelle auf die BG-16 verwiesen. 
 * Diese Kombination exisitiert so nicht (Die Gruppe BG-16 heißt Zahlungsanweisungen). Daher wurde hier eine Korrektur auf BG-17 vorgenommen.
 * 
 * BR-61 : Zahlungsanweisungen 
 * Ist der Zahlungsmitteltyp (BT-81) eine SEPA-Überweisung, eine örtliche Überweisung oder eine internationale Überweisung ohne SEPA, 
 * muss die Kennung des Zahlungskontos (BT-84) angegeben werden.
 */

public interface CreditTransfer {
	
	/**
	 * Payment account identifier
	 * <p>
	 * A unique identifier of the financial payment account, at a payment service provider, to which payment should be made.
	 * <p>
	 * Such as IBAN (in case of a SEPA payment) or a national account number.
	 * <p>
	 * Cardinality: 	1..1
	 * <br>EN16931-ID: 	BT-84 BT-84-0
	 * <br>Rule ID: 	BR-50 BR-61
	 * <br>Request ID: 	R61, R65
	 * 
	 * @return Identifier
	 */
	public String getPaymentAccountID(); // CII: ProprietaryID Nationale Kontonummer (nicht für SEPA) BT-84-0
	// BT-84   IBANID        Kennung des Zahlungskontos
	public void setPaymentAccountID(IBANId iban);
	// BT-84-0 ProprietaryID Nationale Kontonummer (nicht für SEPA)
	public void setPaymentAccountID(String accountId);

// BT-85 +++ 0..1 Payment account name
// AccountName Name des Zahlungskontos
	public String getPaymentAccountName();
	public void setPaymentAccountName(String name);
	
// BT-86 +++ 0..1 Payment service provider identifier
// BICID Kennung des Zahlungsdienstleisters
	public String getPaymentServiceProviderID();
	public void setPaymentServiceProviderID(BICId id);
	public void setPaymentServiceProviderID(String id);
	
//	-- zur INfo:
// BG-18 ++ 0..1 PAYMENT CARD INFORMATION
// BG-19 ++ 0..1 DIRECT DEBIT
	// BT-89 +++ 0..1 Mandate reference identifier
	// BT-90 +++ 0..1 Bank assigned creditor identifier
	// BT-91 +++ 0..1 Debited account identifier
}
