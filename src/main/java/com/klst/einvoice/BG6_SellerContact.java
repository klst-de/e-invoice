package com.klst.einvoice;

/**
 * SELLER CONTACT
 * <p>
 * A group of business terms providing contact information about the Seller.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-6
 * <br>Rule ID: 	
 * <br>Request ID: 	R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
public interface BG6_SellerContact extends IContact {
	
	// BG-6 0..1 SELLER CONTACT
	public IContact getIContact();
	public void setIContact(IContact contact);
	
}
