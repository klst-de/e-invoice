package com.klst.einvoice;

import java.util.List;

import com.klst.edoc.api.ContactInfo;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.api.PostalAddress;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;

/**
 * A common interface for
 * 
 * <br> BG-4 + 1..1 SELLER 
 * <br> BG-7 + 1..1 BUYER
 * <br> BG-10 + 0..1 PAYEE
 * <br> BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
 * <br> BG-13 + 0..1 DELIVERY INFORMATION / BT-70 BT-71 ShipToTradeParty
 */

public interface BusinessParty extends BusinessPartyFactory {

	/* 
	 * a shortcut for getAddress()
	 */
	default PostalAddress getAddress() {
		return ((BusinessPartyAddress)this).getAddress();
	}

	/* 
	 * a shortcut for getIContact()
	 */
	default ContactInfo getBPContact() {
		return ((BusinessPartyContact)this).getContactInfo();
	}

	// use factory: createParty(String name, String tradingName, PostalAddress address, IContact contact);
	// instead setter:
//	public void setRegistrationName(String name);

	// BG-4.BT-27  1..1 Seller name
	// BG-7.BT-44  1..1 Buyer name
	// BG-10.BT-59 1..1 Payee name
	// BG-11.BT-62 1..1 Seller tax representative name
	// BG-13.BT-70 0..1 Deliver to party name
	/**
	 * The full formal name by which the Business Party is registered in the national registry of legal entities 
	 * or as a Taxable person or otherwise trades as a person or persons.
	 * 
	 * @return Business Party name
	 */
	public String getRegistrationName();
	
	// BG-4.BT-28  0..1 Seller trading name (also known as Business name)
	// BG-7.BT-45  0..1  Buyer trading name
	/**
	 * A name by which the Business Party is known, other than registration name 
	 * (also known as Business name). 
	 * This may be used if different from the registration name. 
	 * 
	 * @return Business Party trading name
	 */
	public String getBusinessName();
	public void setBusinessName(String name);
	
	// BG-4.BT-29  0..n Seller identifier
	// BG-7.BT-46  0..1  Buyer identifier
	// BG-10.BT-60 0..1  Payee identifier
	public String getId(); // kleingeschrieben, nicht ID!
	public Identifier getIdentifier();

	public void setId(String name, String schemeID);
	default void setId(String name) {
		setId(name, null);
	}
	default void setIdentifier(Identifier id) {
		if(id!=null) setId(id.getContent(), id.getSchemeIdentifier());
	}

	// BG-4.BT-30  0..1 Seller legal registration identifier 
	// BG-7.BT-47  0..1  Buyer legal registration identifier
	// BG-10.BT-61 0..1  Payee legal registration identifier
	public String getCompanyId();
	public Identifier getCompanyIdentifier();
	
	public void setCompanyId(String name, String schemeID);
	default void setCompanyId(String name) {
		setCompanyId(name, null);
	}
	default void setCompanyIdentifier(Identifier id) {
		if(id!=null) setCompanyId(id.getContent(), id.getSchemeIdentifier());
	}
	
	// BG-4.BT-31  0..1 Seller VAT identifier mit schemeID BT-31-0 "VA" in CII, aber "VAT" in UBL (BUG)
	// BG-4.BT-32  0..1 Seller tax registration identifier mit schemeID BT-32-0 "FC"
	// BG-7.BT-48  0..1  Buyer VAT identifier
	// BG-11.BT-63 1..1 Seller tax representative VAT identifier
	
	// usually the list contains one element, for BG-4 can be two BT-31+BT-32
	// in BG-7, BG-11 ist nur ein Eintrag ==> VAT
	public List<Identifier> getTaxRegistrationIdentifier();

	public void addTaxRegistrationId(String name, String schemeID);
	default void addTaxRegistrationIdentifier(Identifier id) {
		if(id!=null) addTaxRegistrationId(id.getContent(), id.getSchemeIdentifier());
	}

	/**
	 * Seller tax registration identifier
	 * <p>
	 * The local identification (defined by the Seller’s address) of the Seller for tax purposes or 
	 * a reference that enables the Seller to state his registered tax status.
	 * <p>
	 * This information may affect how the Buyer settles the payment (such as for social security fees). 
	 * E.g. in some countries, if the Seller is not registered as a tax paying entity 
	 * then the Buyer is required to withhold the amount of the tax and pay it on behalf of the Seller.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BG-4.BT-32
	 * <br>Rule ID: 	BR-S-2, BR-S-3, BR-S-4, BR-Z-2, BR-Z-3, BR-Z-4, 
	 *                  BR-E-2, BR-E-3, BR-E-4, BR-AE-2, BR-AE-3, BR-AE-4, 
	 *                  BR-IG-2, BR-IG-3, BR-IG-4, BR-IP-2, BR-IP-3, BR-IP-4,
	 * <br>Request ID: 	R47
	 * 
	 * @param name - tax registration identifier
	 * 
	 * @see BusinessParty#setVATRegistrationId(String)
	 */
	default void setTaxRegistrationId(String name) {
		addTaxRegistrationId(name, BG4_Seller.FC.getValue());
	}
	// BG-4.BT-32 ++ 0..1 Seller tax registration identifier , @see BT-31
	default String getTaxRegistrationId() {
		List<Identifier> list = getTaxRegistrationIdentifier();
		if(list.isEmpty()) return null;
//		if(list.size()==1) return list.get(0).getContent();
		for (int i=0; i<list.size(); i++) {
			Identifier id = list.get(i);
			if(id.getSchemeIdentifier().startsWith(BG4_Seller.FC.getValue())) return id.getContent();
		}
		return null;
	}

	// BG-4.BT-30 0..1 Seller legal registration identifier
	// BG-7.BT-47 0..1 Buyer legal registration identifier
	public String getCompanyLegalForm();
	public void setCompanyLegalForm(String name);
	
	/**
	 * VAT identifier - The VAT identifier (also known as VAT identification number).
	 * <p>
	 * A VAT registered Supplier (seller) shall include his VAT ID, except when he uses a tax representative.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BG-4.BT-31 , BG-7.BT-48 , BG-11.BT-63
	 * <br>Rule ID: 	BR-CO-9, BR-AE-2, BR-AE-3, BR-AE-4, BR-S-2, BR-S-3, BR-S-4,
	 *                  BR-IC-2, BR-IC-3, BR-IC-4, BR-O-2, BR-O-3, BR-O-4, BR-56, 
	 *                  BR-Z-2, BR-Z-3, BR-Z-4, BR-E-2, BR-E-3, BR-E-4
	 * <br>Request ID: 	R45, R52, R57
	 * 
	 * @param name - <A HREF="https://en.wikipedia.org/wiki/VAT_identification_number"">VAT identification number</A>
	 *  prefixed by a country code based on EN ISO 3166-1 "Codes for the representation of names of countries and their subdivisions"
	 * 
	 * @see BG4_Seller#setTaxRegistrationId(String)
	 */
	default void setVATRegistrationId(String name) {
		if(this instanceof PartyType) {
			addTaxRegistrationId(name, "VAT");
		} else {
			addTaxRegistrationId(name, "VA");
		}		
	}
	
	// in BG-4 gibt es set/getTaxRegistrationId() für BT-32 , für alle BP BT-31:
	default String getVATRegistrationId() {
		List<Identifier> list = getTaxRegistrationIdentifier();
		if(list.isEmpty()) return null;
		if(list.size()==1) return list.get(0).getContent();
		for (int i=0; i<list.size(); i++) {
			Identifier id = list.get(i);
			if(id.getSchemeIdentifier().startsWith("VA")) return id.getContent();
			// similar to:
//			if(this instanceof PartyType) {
//				if(id.getSchemeIdentifier().equals("VAT")) return id.getContent();
//			} else {
//				if(id.getSchemeIdentifier().equals("VA")) return id.getContent();
//			}		
		}
		return null;
	}

	// BG-4.BT-34 Seller electronic address
	// BG-7.BT-49 Buyer electronic address
	public Identifier getUriUniversalCommunication(); // kleingeschrieben, nicht URI!
	
	/**
	 * set electronic address for Seller (BG-4.BT-34) or Buyer (BG-7.BT-49)
	 * <p>
	 * Identifies the Seller's electronic address to which the application level response 
	 * to the invoice may be delivered.
	 * <p>
	 * Identifies the Buyer's electronic address to which the invoice is delivered.
	 * 
	 * @param name - electronic address
	 * @param schemeID - shall be chosen from a list to be maintained by the Connecting Europe Facility.
	 */
	public void setUriUniversalCommunication(String name, String schemeID);
	default void setUriUniversalCommunication(Identifier id) {
		if(id!=null) setUriUniversalCommunication(id.getContent(), id.getSchemeIdentifier());
	}
	
}
