package com.klst.einvoice;

/**
 * BUYER POSTAL ADDRESS
 * <p>
 * A group of business terms providing information about the postal address for the Buyer.
 * 
 * Sufficient components of the address are to be filled to comply with legal requirements.
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-8
 * <br>Rule ID: 	
 * <br>Request ID: 	R53
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*   (en) rules
 * 
 * BR-10  Target / context: Buyer, Business term / group: BG-8
 * An Invoice shall contain the Buyer postal address (BG-8).
 * 
 * BR-11  Target / context: Buyer Postal Address, Business term / group: BT-55
 * The Buyer postal address shall contain a Buyer country code (BT-55).
 * 
 *   (de) rules / Geschäftsregel:
 * 
 * BR-10    : Käufer
 * Eine Rechnung muss die Postanschrift des Käufers (BG-8) enthalten.
 * 
 * BR-11    : Postanschrift des Käufers
 * Die Postanschrift des Käufers muss einen Ländercode der Käuferanschrift (BT-55) enthalten.
 * 
 */
public interface BG8_BuyerPostalAddress extends PostalAddress {
	
	// BG-8 1..1 BUYER POSTAL ADDRESS
	public PostalAddress getAddress();
	public void setAddress(PostalAddress address);
	
}
