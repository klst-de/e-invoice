package com.klst.einvoice;

import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;

/**
 * abstract-factory, aka Kit for BG-17 CREDIT TRANSFER
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */

/** CreditTransfer - Überweisung BG-17
 * 
 * A group of business terms to specify credit transfer payments
 * 
 * BT-84 1..1 Payment account identifier. A unique identifier of the financial payment account, 
 *            at a payment service provider, to which payment should be made. 
 *            Such as IBAN (in case of a SEPA payment) or a national account number.
 *            Rule R61, R65 Identifier
 * BT-85 0..1 Payment account name. The name of the payment account, at a payment service provider, 
 *            to which payment should be made.
 *            Rule R61, R65 Text
 * BT-86 0..1 Payment service provider identifier. An identifier for the payment service provider 
 *            where a payment account is located. 
 *            Such as a BIC or a national clearing code where required. 
 *            No identification scheme to be used.
 *            Rule R61, R65 Identifier
 */
public interface CreditTransferFactory {
	
	/**
	 * a SEPA payment
	 * 
	 * @param iban, BT-84 - IBAN Payment account identifier
	 * @param accountName, optional
	 * @param bic, optional SwiftCode
	 * @return CreditTransfer object
	 */
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic); // SEPA Überweisung
	
	/**
	 * non SEPA payment
	 * 
	 * @param accountId, BT-84 -  national account number
	 * @param accountName, optional
	 * @param bic, optional SwiftCode
	 * @return CreditTransfer object
	 */
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic); // non SEPA
}
