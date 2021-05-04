package com.klst.einvoice;

import com.klst.edoc.api.BusinessPartyAddress;

/**
 * DELIVER TO ADDRESS
 * <p>
 * A group of business terms providing information about the address to which goods and services invoiced were 
 * or are delivered.
 * 
 * In the case of pick-up, the deliver to address is the pick-up address. 
 * Sufficient components of the address are to be filled to comply with legal requirements.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-15
 * <br>Rule ID: 	
 * <br>Request ID: 	R32
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*   (en) rules
 * 
 * BR-57  Target / context: Deliver to address, Business term / group: BT-80
 * Each Deliver to address (BG-15) shall contain a Deliver to country code (BT-80).
 * 
 *   (de) rules / Geschäftsregel:
 * 
 * BR-57    : Lieferanschrift
 * Jede Lieferanschrift (BG-15) muss einen Ländercode der Lieferanschrift (BT-80) enthalten.
 * 
 */
public interface BG15_DeliverToAddress extends BusinessPartyAddress {
	
}
