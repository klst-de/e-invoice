package com.klst.einvoice;

/**
 * BUYER CONTACT
 * <p>
 * A group of business terms providing contact information relevant for the Buyer.
 * Contact details can be given by the Buyer at the time of the ordering or as master data exchanged prior to ordering.
 *  
 * Contact details should not be used for the purpose of routing the received Invoice internally by the recipient; 
 * the Buyer reference identifier should be used for this purpose.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-9
 * <br>Rule ID: 	
 * <br>Request ID: 	R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
public interface BG9_BuyerContact extends IContact {
	
	// BG-9 0..1 BUYER CONTACT
	public IContact getIContact();
	public void setIContact(IContact contact);

}
