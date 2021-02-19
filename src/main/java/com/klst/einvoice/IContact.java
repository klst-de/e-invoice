package com.klst.einvoice;

/**
 * BG-6 , BG-9 CONTACT
 * <p>
 * A group (BG) of business terms (BT) providing contact information relevant for the business partner.
 * 
 * @see IContactFactory#createContact(String, String, String)
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for BGs, BTs, rules and request IDs
 */
public interface IContact extends IContactFactory {

	// use factory to set props

	/**
	 * optional contact point 
	 * <p>
	 * A contact point for a legal entity or person.
	 * Such as person name, contact identification, department or office identification.
	 * 
	 * @return null or contact point
	 */
	public String getContactPoint();
	
	/**
	 * optional contact telephone number
	 * <p>
	 * A phone number for the contact point.
	 * 
	 * @return null or contact phone number
	 */
	public String getContactTelephone();
	
	/**
	 * optional contact email address
	 * <p>
	 * An e-mail address for the contact point.
	 * 
	 * @return null or contact email address
	 */
	public String getContactEmail();

}
