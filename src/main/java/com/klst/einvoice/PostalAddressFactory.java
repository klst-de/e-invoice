package com.klst.einvoice;

/**
 * abstract-factory, aka Kit for 
 * BG-5 SELLER POSTAL ADDRESS ,
 * BG-8 BUYER POSTAL ADDRESS 
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for BGs, BTs, rules and request IDs
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */
public interface PostalAddressFactory {
	
	/**
	 * factory for PostalAddress
	 * 
	 * @param countryCode according to ISO 3166-1
	 * @param postalCode such as a ZIP code or a post code
	 * @param city - the city, town or village, where the address is located
	 */
	public PostalAddress createAddress(String countryCode, String postalCode, String city);
	
}
