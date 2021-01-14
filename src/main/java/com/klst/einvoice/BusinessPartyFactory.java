package com.klst.einvoice;

/**
 * abstract-factory, aka Kit for BusinessParty (BP) 
 * <br> BG-4 + 1..1 SELLER 
 * <br> BG-7 + 1..1 BUYER
 * <br> BG-10 + 0..1 PAYEE
 * <br> BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
 * <br> BG-13 + 0..1 DELIVERY INFORMATION / BT-70 BT-71 ShipToTradeParty
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 * @see BusinessParty
 */

public interface BusinessPartyFactory {
	
	/**
	 * ctor for BusinessParty, use this factory method to create SELLER party or BUYER party. Add optional attributes if needed. 
	 * 
	 * @param registrationName - full formal name by which the BP is registered in the national registry of legal entities 
	 *                           or as a Taxable person or otherwise trades as a person or persons
	 * @param tradingName - an optional name by which the BP is known, other than registrationName
	 *                       (also known as Business name).
	 * @param PostalAddress address
	 * @param IContact contact
	 * 
	 * @see BusinessParty
	 * @see PostalAddress
	 * @see IContact
	 */
	public BusinessParty createParty(String name, String tradingName, PostalAddress address, IContact contact);
	default BusinessParty createParty(String name, PostalAddress address, IContact contact) {
		return createParty(name, null, address, contact);
	}
	
	/**
	 * copy BusinessParty
	 * 
	 */
	public BusinessParty createParty(BusinessParty party);
}
