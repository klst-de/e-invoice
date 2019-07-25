package com.klst.einvoice;

/**
 * BG-18 ++ 0..1 PAYMENT CARD INFORMATION
 * <p>
 * A group of business terms providing information about card used for payment contemporaneous with invoice issuance.
 * <p>
 * Only used if the Buyer had opted to pay by using a payment card such as a credit or debit card.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-18
 * <br>Rule ID: 	
 * <br>Request ID: 	R64
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

//0 .. 1 ApplicableTradeSettlementFinancialCard Informationen zur Zahlungskarte  BG-18 xs:sequence 
//1 .. 1 ID Zahlungskartennummer                                                 BT-87 
//0 .. 1 CardholderName Name des Zahlungskarteninhabers                          BT-88

/*  (de) rules / Geschäftsregel:
 * 
 * BR-DE-13 : Lastschriftverfahren: Gläubiger-ID
 * In der Rechnung müssen Angaben zu genau einer der drei Gruppen „CREDIT TRANSFER“ (BG-17), 
 * „PAYMENT CARD INFORMATION“ (BG-18) oder „DIRECT DEBIT“ (BG-19) übermittelt werden.
 * 
 */

public interface PaymentCard {
	
	/**
	 * Payment card primary account number
	 * <p>
	 * Unique identifier assigned by the Payee for referencing the direct debit mandate.
	 * <p>
	 * In accordance with card payments security standards an invoice should never include a full card primary account number. 
	 * At the moment PCI Security Standards Council has defined that the first 6 digits and last 4 digits 
	 * are the maximum number of digits to be shown.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BT-87
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R64
	 * 
	 * @return Text
	 */
	public String getCardAccountID();
	public void setCardAccountID(String id);

	/**
	 * Payment card holder name
 	 * <p>
	 * The name of the payment card holder.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BT-88
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R64
	 * 
	 * @return Text
	 */
	public String getCardHolderName();
	public void setCardHolderName(String name);
		
}
