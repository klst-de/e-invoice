package com.klst.einvoice;

/**
 * SELLER POSTAL ADDRESS
 * <p>
 * A group of business terms providing information about the address of the Seller.
 * 
 * Sufficient components of the address are to be filled to comply with legal requirements.
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-5
 * <br>Rule ID: 	BR-8 : An Invoice shall contain the Seller postal address.
 * <br>Request ID: 	R53
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*   (en) rules
 * 
 * BR-8  Target / context: Seller, Business term / group: BG-5
 * An Invoice shall contain the Seller postal address (BG-5).
 * 
 * BR-9  Target / context: Seller Postal Address, Business term / group: BT-40
 * The Seller postal address (BG-5) shall contain a Seller country code (BT-40).
 * 
 *   (de) rules / Geschäftsregel:
 * 
 * BR-8     : Verkäufer
 * Eine Rechnung muss die Postanschrift des Verkäufers (BG-5) enthalten.
 * 
 * BR-9     : Postanschrift des Verkäufers
 * Eine Postanschrift des Verkäufers (BG-5) muss einen Ländercode der Verkäuferanschrift (BT-40) enthalten.
 * 
 */
public interface BG5_SellerPostalAddress extends PostalAddress {
	
	// BG-5 1..1 SELLER POSTAL ADDRESS
	public PostalAddress getAddress();
	public void setAddress(PostalAddress address);
	
}
