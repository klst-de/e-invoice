package com.klst.einvoice;

/* @see European standard EN 16931-1:2017
 * 
 * 
ID    | Level | Cardinality | Business Term         | Description | Usage Note | Req.ID | Semantic data type
BG-6  | ++    | 0..1        | SELLER CONTACT        | A group of business terms providing contact information about the Seller. 
                                                                               | R57
BG-9  | ++    | 0..1        | BUYER CONTACT         | A group of business terms providing contact information relevant for the Buyer.
                                                                  | Contact details can be given by the Buyer at the time of the ordering 
                                                                    or as master data exchanged prior to ordering. 
                                                                    Contact details should not be used for the purpose of routing the 
                                                                    received Invoice internally by the recipient; 
                                                                    the Buyer reference identifier should be used for this purpose.
                                                                               | R57

BT-41 | +++   | 0..1        | Seller contact point  | A contact point for a legal entity or person.
                                                                  | Such as person name, contact identification, department or office identification. 
BT-42 | +++   | 0..1        | Seller contact telephone number     | A phone number for the contact point.
BT-43 | +++   | 0..1        | Seller contact email address        | An e-mail address for the contact point.

BT-56 | +++   | 0..1        | Buyer contact point                 | A contact point for a legal entity or person.
BT-57 | +++   | 0..1        | Buyer contact telephone number      | A phone number for the contact point.
BT-58 | +++   | 0..1        | Buyer contact email address         | An e-mail address for the contact point.
 */
public interface IContact {

	public void setContactPoint(String name);
	public void setContactTelephone(String contactTel);
	public void setContactEmail(String contactMail);

	public String getContactPoint();
	public String getContactTelephone();
	public String getContactEmail();

}
