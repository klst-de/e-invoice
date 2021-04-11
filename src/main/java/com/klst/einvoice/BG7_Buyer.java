package com.klst.einvoice;

import com.klst.edoc.api.PostalAddress;

/**
 * BG-7 + 1..1 BUYER
 * <p>
 * A group of business terms providing information about the Buyer.
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-7
 * <br>Rule ID: 	
 * <br>Request ID: 	R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*  (de) rules / Geschäftsregel:
 * 
 * BR-7     : Käufer 
 * Eine Rechnung muss den Namen des Käufers (BT-44) enthalten
 * 
 * BR-11 Postanschrift des Käufers (PostalAddress)
 * Die Postanschrift des Käufers muss einen Ländercode der Käuferanschrift (BT-55) enthalten.
 * 
 * BR-63 Elektronische Adresse des Käufers 
 * Die Elektronische Adresse des Käufers (BT-49) muss über eine Kennung des Schemas verfügen.
 * 
 * BR-CO-9 Umsatzsteuer-Identifikationsnummern 
 * Den Umsatzsteuer-Identifikationsnummern des Verkäufers (BT-31), des Steuerbevollmächtigten des Verkäufers (BT-63) und des Käufers (BT-48) 
 * muss zur Kennzeichnung des Landes, das sie erteilt hat, jeweils ein Präfix nach ISO 3166-1 Alpha-2 vorangestellt werden, 
 * durch das das Ausstellerland identifiziert werden kann. 
 * Griechenland wird jedoch ermächtigt, das Präfix „EL“ zu verwenden.
 * 
 * BR-DE-8  : Stadt der Erwerberanschrift (gehört nach PostalAddress)
 * Das Element „Buyer city“ (BT-52) muss übermittelt werden.
 * 
 * BR-DE-9  : Postleitzahl der Erwerberanschrift
 * Das Element „Buyer post code“ (BT-53) muss übermittelt werden.
 */
public interface BG7_Buyer {
	
	public void setBuyer(String name, PostalAddress address, IContact contact);
	public void setBuyer(BusinessParty party);
	public BusinessParty getBuyer();

}
