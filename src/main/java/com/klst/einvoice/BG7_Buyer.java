package com.klst.einvoice;

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

// CII:
// 1 .. 1 BuyerTradeParty  Käufer                                        BG-7

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
// TODO Idee runter zu ubl und cii und public raus ?!
public interface BG7_Buyer extends BG_Party, PostalAddressFactory, IContactFactory {
	
/*

            <ram:BuyerTradeParty>
                <ram:ID>138</ram:ID>
                <ram:Name>[Buyer name]</ram:Name>
                <ram:SpecifiedLegalOrganization>
                    <ram:ID>GmbH</ram:ID>
                </ram:SpecifiedLegalOrganization>
                <ram:DefinedTradeContact> ... </ram:DefinedTradeContact>
                <ram:PostalTradeAddress> ... </ram:PostalTradeAddress>
                <ram:SpecifiedTaxRegistration>
                    <ram:ID schemeID="VA">DE12345ABC</ram:ID>
                </ram:SpecifiedTaxRegistration>
            </ram:BuyerTradeParty>



 */
	// BT-44 ++ 1..1 Buyer name / ram:Name / UBL: <cac:PartyLegalEntity><cbc:RegistrationName>
	// ...
	
	// BG-8 ++ 1..1 BUYER POSTAL ADDRESS
	public PostalAddress getAddress();
	public void setAddress(PostalAddress address);
	
	// BG-9 ++ 0..1 BUYER CONTACT
	public IContact getIContact();
	public void setIContact(IContact contact);

}
