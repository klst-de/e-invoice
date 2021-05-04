package com.klst.einvoice.api;

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

// Customization Anwendung: 
// Profil EXTENDED: urn:cen.eu:EN16931:2017#conformant#urn:zugferd.de:2p0:extended 
//                  urn:cen.eu:en16931:2017#conformant#urn:factur-x.eu:1p0:extended
// Profil EN 16931 (COMFORT): urn:cen.eu:EN16931:2017     - konform zu EN16931
//                            urn:cen.eu:en16931:2017 
// Profil BASIC: urn:cen.eu:EN16931:2017#compliant#urn:zugferd.de:2p0:basic
//               urn:cen.eu:en16931:2017#compliant#urn:factur-x.eu:1p0:basic
// Besonderheit der XRechnung Spezifikationskennung 
// Einschränkung: urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_2.0  - ZUGFeRD 2.1
//                urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2  - ZUGFeRD 2.0
//                urn:cen.eu:en16931:2017:xoev-de:kosit:standard:xrechnung_1.1                - ZUGFeRD 1.0 ?

/*  (de) rules / Geschäftsregel:
 * 
 * BR-1 An Invoice shall have a Specification identifier (BT-24).
 * 
 * BR-1 Prozesssteuerung 
 * Eine Rechnung muss eine Spezifikationskennung (BT-24) haben.
 * 
 */
public interface BG2_ProcessControl {
	
	public static final String PROFILE_EXTENDED  = "urn:cen.eu:en16931:2017#conformant#urn:factur-x.eu:1p0:extended";
	public static final String PROFILE_EN_16931  = "urn:cen.eu:en16931:2017";
	public static final String PROFILE_COMFORT   = PROFILE_EN_16931;
	public static final String PROFILE_BASIC     = "urn:cen.eu:en16931:2017#compliant#urn:factur-x.eu:1p0:basic";
	public static final String PROFILE_XRECHNUNG     = "urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_2.0";
//	@Deprecated
//	public static final String PROFILE_XRECHNUNG_2p0 = "urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_2.0";	                                                
//	@Deprecated
//	public static final String PROFILE_XRECHNUNG_1p2 = "urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2";	                                                
	
	/**
	 * Business process type
	 * <p>
	 * Identifies the business process context in which the transaction appears, 
	 * to enable the Buyer to process the Invoice in an appropriate way.
	 * To be specified by the Buyer.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-2.BT-23
	 * <br>Rule ID:
	 * <br>Req.ID:      R44
	 * 
	 * @return Textstring identifying the business process context
	 */
	public String getProcessType();
	
	/**
	 * Specification identifier aka PROFILE
	 * <p>
	 * An identification of the specification containing the total set of rules regarding semantic content,
	 * cardinalities and business rules to which the data contained in the instance document conforms.
	 * 
	 * This identifies compliance or conformance to this document. 
	 * Compliant invoices specify: urn:cen.eu:en16931:2017 (PROFILE_EN_16931)
	 * Invoices, compliant to a user specification may identify that user specification here.
	 * No identification scheme is to be used.
	 * <p>
	 * Cardinality: 	1..1 mandatory
	 * <br>EN16931-ID: 	BG-2.BT-24
	 * <br>Rule ID:
	 * <br>Req.ID:      R44
	 * 
	 * @return PROFILE Identifier String, f.i. PROFILE_EN_16931
	 * 
	 * This BT maps to ubl: CustomizationID , cii: GuidelineSpecifiedDocumentContextParameter:ID
	 */
	public String getCustomization();

	default String getProfile() {
		return getCustomization();
	}

}
