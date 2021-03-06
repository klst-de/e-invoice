package com.klst.einvoice;

/**
 * BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
 * <p>
 * A group of business terms providing information about the Seller's tax representative.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-11
 * <br>Rule ID: 	
 * <br>Request ID: 	R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

/*  (de) rules / Geschäftsregel:
 * 
 * BR-18    : Steuerbevollmächtigter des Verkäufers 
 * Falls sich der Verkäufer (BG-4) durch einen Steuerbevollmächtigten (BG-11) vertreten lässt, 
 * muss dessen Name (BT-62) in der Rechnung angegeben werden.
 * 
 * BR-19    : Steuerbevollmächtigter des Verkäufers 
 * Falls sich der Verkäufer (BG-4) durch einen Steuerbevollmächtigten (BG-11) vertreten lässt, 
 * muss die Postanschrift des Steuerbevollmächtigten des Verkäufers (BG-12) in der Rechnung angegeben werden.
 * 
 * BR-20    : Postanschrift des Steuerbevollmächtigten des Verkäufers 
 * Falls sich der Verkäufer (BG-4) durch einen Steuerbevollmächtigtenr (BG-11) vertreten lässt, 
 * muss die Postanschrift des Steuerbevollmächtigten des Verkäufers (BG-12) den Ländercode der Steuerbevollmächtigtenanschrift (BT-69) enthalten.
 * 
 * BR-56    : Steuerbevollmächtigter des Verkäufers 
 * Jeder Steuerbevollmächtigte des Verkäufers (BG-11) muss über eine Umsatzsteuer-Identifikationsnummer 
 * des Steuerbevollmächtigten des Verkäufers (BT-63) verfügen.
 * 
 * BR-CO-9  : Umsatzsteuer-Identifikationsnummern 
 * Den Umsatzsteuer-Identifikationsnummern des Verkäufers (BT-31), des Steuerbevollmächtigten des Verkäufers (BT-63) und des Käufers (BT-48) 
 * muss zur Kennzeichnung des Landes, das sie erteilt hat, jeweils ein Präfix nach ISO 3166-1 Alpha-2 vorangestellt werden, 
 * durch das das Ausstellerland identifiziert werden kann. 
 * Griechenland wird jedoch ermächtigt, das Präfix „EL“ zu verwenden.
 * 
 * BR-DE-16 : Steuervertreter des Verkäufers
 * In der Rechnung muss mindestens eines der Elemente „Seller VAT identifier“ (BT-31),
 *  „Seller tax registration identifier“ (BT-32) oder „SELLER TAX REPRESENTATIVE PARTY“ (BG-11) übermittelt werden.
 */
public interface BG11_SellerTaxRepresentative extends BusinessParty, BG12_SellerTaxRepresentativeAddress {
	
	// BT-62 ++ 1..1 Seller tax representative name
	
	// BG-12 ++ 1..1 SELLER TAX REPRESENTATIVE POSTAL ADDRESS
	
	// BT-63 ++ 1..1 Seller tax representative VAT identifier
	
}
