package com.klst.einvoice;

import java.sql.Timestamp;

/**
 * BG-13 + 0..1 DELIVERY INFORMATION
 * <p>
 * A group of business terms providing information about where and when the goods and services invoiced are delivered.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-13
 * <br>Rule ID: 	
 * <br>Request ID: 	R31, R32, R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

/*  (de) rules / Geschäftsregel:
 * 
 * BR-DE-10 : Stadt der Lieferanschrift (gehört nach PostalAddress)
 * Das Element „Deliver to city“ (BT-77) muss übermittelt werden, 
 * wenn die Gruppe „DELIVER TO ADDRESS“ (BG-15) übermittelt wird.
 * 
 * BR-DE-11 : Postleitzahl der Lieferanschrift (gehört nach PostalAddress)
 * Das Element „Deliver to post code“ (BT-78) muss übermittelt werden, 
 * wenn die Gruppe „DELIVER TO ADDRESS“ (BG-15) übermittelt wird.
 * 
 * BR-DE-12 :
 * Mit dem Element „Deliver to post code“ (BT-78) muss eine Postleitzahl übermittelt werden.
 */
//TODO Idee runter zu ubl und cii und public raus ?!
public interface BG13_DeliveryInformation extends BG_Party {
	
	// BT-70 ++ 0..1 Deliver to party name
	
	// BT-71 ++ 0..1 Deliver to location identifier
	
	// BT-72 ++ 0..1 Actual delivery date
	public void setActualDate(String ymd);
	public void setActualDate(Timestamp ts);
	public Timestamp getActualDate();
	
	// BG-15 ++ 0..1 DELIVER TO ADDRESS
	public PostalAddress getAddress();
	public void setAddress(PostalAddress address);

}
