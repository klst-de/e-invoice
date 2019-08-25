package com.klst.einvoice;

/**
 * BG-2 PROCESS CONTROL
 * <p>
 * A group of business terms providing information on the business process and rules applicable to the Invoice document.
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-2
 * <br>Rule ID: 	BR-1
 * <br>Request ID: 	R44
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */

// Anwendung: 
// Profil EXTENDED: urn:cen.eu:EN16931:2017#conformant#urn:zugferd.de:2p0:extended 
// Profil EN 16931 (COMFORT): urn:cen.eu:EN16931:2017     - konform zu EN16931
// Profil BASIC: urn:cen.eu:EN16931:2017#compliant#urn:zugferd.de:2p0:basic
// Besonderheit der XRechnung Spezifikationskennung 
// Einschränkung: urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2  - ZUGFeRD 2.0
//                urn:cen.eu:en16931:2017:xoev-de:kosit:standard:xrechnung_1.1                - ZUGFeRD 1.0 ?

/*  (de) rules / Geschäftsregel:
 * 
 * BR-1 Prozesssteuerung 
 * Eine Rechnung muss eine Spezifikationskennung (BT-24) haben.
 * 
 */
// TODO Idee runter zu ubl und cii und public raus ?!
public interface BG2_ProcessControl {
	
	public static final String PROFILE_EXTENDED  = "urn:cen.eu:EN16931:2017#conformant#urn:zugferd.de:2p0:extended";
	public static final String PROFILE_EN_16931  = "urn:cen.eu:EN16931:2017";
	public static final String PROFILE_COMFORT   = PROFILE_EN_16931;
	public static final String PROFILE_BASIC     = "urn:cen.eu:EN16931:2017#compliant#urn:zugferd.de:2p0:basic";
	public static final String PROFILE_XRECHNUNG = "urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2";	                                                
	
	// BT-23 ++ 0..1 Business process type
	public String getProfile();
	
	// BT-24 ++ 1..1 Specification identifier
	public String getCustomization();
	
	/**
	 * PROCESS CONTROL
	 * <p>
	 * A group of business terms providing information on the business process and rules applicable to the Invoice document.
	 * Contains ProfileID (BT-23 0..1) and CustomizationID/Specification identifier (BT-24 1..1)
	 * <br>
	 * ProfileID identifies what business process a given message is part of, 
	 * and CustomizationID identifies the kind of message and the rules applied.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-2 , BT-23 , BT-24
	 * <br>Rule ID: 	BR-1
	 * <br>Req.ID: R44
	 * <p>
	 * ProfileID/Business process type - Identifies the business process context in which the transaction appears, 
	 * to enable the Buyer to process the Invoice in an appropriate way.
	 * <p>
	 * Specification identifier - An identification of the specification containing the total set of rules regarding semantic content,
	 * cardinalities and business rules to which the data contained in the instance document conforms.
	 * This identifies compliance or conformance to this document. 
	 * Compliant invoices specify: urn:cen.eu:en16931:2017. Invoices, compliant to a user specification may identify that user specification here.
	 * No identification scheme is to be used.
	 * 
	 * @param customization, not null
	 * @param profile (optional)
	 */
	// non public - use ctor
//	void setProcessControl(String customization, String profile);

}
