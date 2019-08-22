package com.klst.einvoice;

/**
 * BG-10 + 0..1 PAYEE 
 * <p>
 * A group of business terms providing information about the Payee, i.e. the role that receives the payment.
 * <p>
 * The role of Payee may be fulfilled by another party than the Seller, e.g. a factoring service.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-10
 * <br>Rule ID: 	
 * <br>Request ID: 	R1, R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

/*  (de) rules / Geschäftsregel:
 * 
 * BR-17    : Zahlungsempfänger 
 * Falls der Zahlungsempfänger (BG-10) nicht mit dem Verkäufer (BG-4) identisch ist, 
 * muss seine Firmierung/sein Name in der Rechnung (BT-59) angegeben werden.
 * 
 */
//TODO Idee runter zu ubl und cii und public raus ?!
public interface BG10_Payee extends BG_Party {
	
	// BT-59 ++ 1..1 Payee name / ram:Name
	
	// BT-60 ++ 0..1 Payee identifier / PayeeTradeParty <ram:ID><ram:GlobalID>
	
	// BT-61 ++ 0..1 Payee legal registration identifier / <ram:SpecifiedLegalOrganization><ram:ID>

}
