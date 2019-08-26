package com.klst.einvoice;

/**
 * abstract-factory, aka Kit for 
 * BG-6 SELLER CONTACT ,
 * BG-9 BUYER CONTACT 
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */

public interface IContactFactory {
	
	/**
	 * ctor for Contact
	 * 
	 * @param contactName text
	 * @param contactTel text
	 * @param contactMail text
	 */
	public IContact createContact(String contactName, String contactTel, String contactMail);
	
	/**
	 * copy Contact
	 * 
	 */
	public IContact createContact(IContact contact);
}
