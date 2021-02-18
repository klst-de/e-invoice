package com.klst.einvoice;

/**
 * SELLER TAX REPRESENTATIVE POSTAL ADDRESS
 * <p>
 * A group of business terms providing information about the postal address for the tax representative party.
 * 
 * The Seller tax representative name/postal address shall be provided in the invoice, if the Seller has 
 * a tax representative who is liable to pay the VAT due.
 * Sufficient components of the address are to be filled to comply with legal requirements.
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-12
 * <br>Rule ID: 	
 * <br>Request ID: 	R53
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*   (en) rules
 * 
 * BR-19  Target / context: Seller tax representative, Business term / group: BG-12
 * The Seller tax representative postal address (BG-12) shall be provided in the Invoice, 
 * if the Seller (BG-4) has a Seller tax representative party (BG-11).
 * 
 * BR-20  Target / context: Seller tax representative postal address, Business term / group: BT-69
 * The Seller tax representative postal address (BG-12) shall contain a Tax representative country code (BT-69), 
 * if the Seller (BG-4) has a Seller tax representative party (BG-11).
 * 
 *   (de) rules / Geschäftsregel:
 * 
 * BR-19    : Steuerbevollmächtigter des Verkäufers
 * Falls sich der Verkäufer (BG-4) durch einen Steuerbevollmächtigten (BG-11) vertreten lässt, 
 * muss die Postanschrift des Steuerbevollmächtigten des Verkäufers (BG-12) in der Rechnung angegeben werden.
 * 
 * BR-20    : Postanschrift des Steuerbevollmächtigten des Verkäufers
 * Falls sich der Verkäufer (BG-4) durch einen Steuerbevollmächtigten (BG-11) vertreten lässt, 
 * muss die Postanschrift des Steuerbevollmächtigten des Verkäufers (BG-12) den Ländercode der
 * Steuerbevollmächtigtenanschrift (BT-69) enthalten.
 * 
 */
public interface BG12_SellerTaxRepresentativeAddress extends BusinessPartnerAddress {
	
}
