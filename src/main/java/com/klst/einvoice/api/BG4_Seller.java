package com.klst.einvoice.api;

import com.klst.edoc.api.BusinessParty;
import com.klst.edoc.api.ContactInfo;
import com.klst.edoc.api.PostalAddress;

/**
 * BG-4 + 1..1 SELLER 
 * <p>
 * A group of business terms providing information about the Seller.
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-4
 * <br>Rule ID: 	
 * <br>Request ID: 	R48
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*   (en) rules
 * 
 * BR-6  Target / context: Seller, Business term / group: BT-87
 * An Invoice shall contain the Seller name (BT-27).
 * 
 * BR-8 
 * An Invoice shall contain the Seller postal address (BG-5).
 * 
 * BR-CO-26   Target / context: Seller, Business term / group: BT-29, BT-30, BT-31
 * In order for the buyer to automatically identify a supplier, 
 * Seller identifier (BT-29), the Seller legal registration identifier (BT-30) 
 * and/or the Seller VAT identifier (BT-31) shall be present.
 *
 *  (de) rules / Geschäftsregel:
 * 
 * BR-6     : Verkäufer 
 * Eine Rechnung muss den Namen des Verkäufers (BT-27) enthalten.
 * 
 * ... 
 * 
 */
public interface BG4_Seller {
	
	// BG-4.BT-27 1..1 Seller name
	// ...
	// BG-4.BT-31 0..1 Seller VAT identifier z.B. DE 123456789 / <ram:SpecifiedTaxRegistration><ram:ID> / <cac:PartyTaxScheme><cbc:CompanyID>
//	Umsatzsteueridentnummer des Verkäufers BT-31
//	Steuernummer des Verkäufers            BT-32
//	Die betriebswirtschaftlichen Begriffe werden über einen Scheme identifier unterschieden. 
//	Code Codename 
//	VA . Umsatzsteuernummer
//	FC . Steuernummer 	

	// BG-5 1..1 SELLER POSTAL ADDRESS
	// BG-6 0..1 SELLER CONTACT
	
	public void setSeller(String name, PostalAddress address, ContactInfo contact, String companyId, String companyLegalForm);
	public void setSeller(BusinessParty party);
	public BusinessParty getSeller();

		
}
