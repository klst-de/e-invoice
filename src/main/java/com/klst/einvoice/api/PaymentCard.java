package com.klst.einvoice.api;

/**
 * BG-18 ++ 0..1 PAYMENT CARD INFORMATION
 * <p>
 * A group of business terms providing information about card used for payment contemporaneous with invoice issuance.
 * <p>
 * Only used if the Buyer had opted to pay by using a payment card such as a credit or debit card.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-18
 * <br>Rule ID: 	BR-51
 * <br>Request ID: 	R64 information for relating an invoice to a payment card used for settlement
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*   (en) rules
 * 
 * BR-51  Target / context: Card information, Business term / group: BT-87
 * The last 4 to 6 digits of the Payment card primary account number (BT-87) shall be present 
 * if Payment card information (BG-18) is provided in the Invoice.
 * 
 *   (de) rules / Geschäftsregel:
 * 
 * BR-51 Karteninformationen
 * Falls in der Rechnung Informationen zur verwendeten Zahlungskarte (BG-18) angegeben sind, 
 * müssen die letzten 4 bis 6 Ziffern der Zahlungskartennummer (BT-87) angezeigt werden.
 * 
 */
public interface PaymentCard {

	/**
	 * Payment card primary account number
	 * <p>
	 * The Primary Account Number (PAN) of the card used for payment.
	 * <p>
	 * In accordance with card payments security standards an invoice should never include a full card primary account number. 
	 * At the moment PCI Security Standards Council has defined that the first 6 digits and last 4 digits 
	 * are the maximum number of digits to be shown.
	 * <p>
	 * Cardinality: 	1..1
	 * <br>EN16931-ID: 	BG-18.BT-87
	 * <br>Rule ID: 	BR-51
	 * <br>Request ID: 	R64 information for relating an invoice to a payment card used for settlement
	 * 
	 * @return Text
	 */
	public String getCardAccountID();
	
	/**
	 * 
	 * @param pan - (mandatory) Payment card primary account number (pan)
	 */
	public void setCardAccountID(String pan);

	/**
	 * Payment card holder name
 	 * <p>
	 * The name of the payment card holder.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BG-18.BT-88
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R64 information for relating an invoice to a payment card used for settlement
	 * 
	 * @return Text
	 */
	public String getCardHolderName();
	
	/**
	 * 
	 * @param name - (optional) name of the payment card holder
	 */
	public void setCardHolderName(String name);
		
}
