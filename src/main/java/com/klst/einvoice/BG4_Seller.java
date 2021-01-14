package com.klst.einvoice;

import java.util.List;

/**
 * BG-4 + 1..1 SELLER 
 * <p>
 * A group of business terms providing information about the Seller.
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-4
 * <br>Rule ID: 	
 * <br>Request ID: 	R48
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

/* 01.01a-INVOICE_uncefact.xml :
	<ram:SellerTradeParty>
	    <ram:Name>[Seller name]</ram:Name>                                            -- BT-27 BusinessName
	    <ram:Description>123/456/7890, HRA-Eintrag in […]</ram:Description>
	    <ram:SpecifiedLegalOrganization>
	        <ram:ID>[HRA-Eintrag]</ram:ID>
	        <ram:TradingBusinessName>[Seller trading name]</ram:TradingBusinessName>
	    </ram:SpecifiedLegalOrganization>
	    <ram:DefinedTradeContact> ... </ram:DefinedTradeContact>
	    <ram:PostalTradeAddress> ...</ram:PostalTradeAddress>
	    <ram:SpecifiedTaxRegistration>
	        <ram:ID schemeID="VA">DE 123456789</ram:ID>
	    </ram:SpecifiedTaxRegistration>
	</ram:SellerTradeParty>

dto UBL:
    <cac:AccountingSupplierParty>
        <cac:Party>
            <cac:PartyName>                                                           -- BT-27 BusinessName                                                      -- 
                <cbc:Name>[Seller trading name]</cbc:Name>
            </cac:PartyName>
            <cac:PostalAddress> ... </cac:PostalAddress>
            <cac:PartyTaxScheme>
                <cbc:CompanyID>DE 123456789</cbc:CompanyID>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
                </cac:TaxScheme>
            </cac:PartyTaxScheme>
            <cac:PartyLegalEntity>
                <cbc:RegistrationName>[Seller name]</cbc:RegistrationName>                           registrationName
                <cbc:CompanyID>[HRA-Eintrag]</cbc:CompanyID>
                <cbc:CompanyLegalForm>123/456/7890, HRA-Eintrag in […]</cbc:CompanyLegalForm>
            </cac:PartyLegalEntity>
            <cac:Contact> ... </cac:Contact>
        </cac:Party>
    </cac:AccountingSupplierParty>

*/

// CII:
// 1 .. 1 SellerTradeParty Verkäufer                                     BG-4

/*  (de) rules / Geschäftsregel:
 * 
 * BR-6     : Verkäufer 
 * Eine Rechnung muss den Namen des Verkäufers (BT-27) enthalten.
 * 
 * ... TODO
 * 
 */
//TODO Idee runter zu ubl und cii und public raus ?!
public interface BG4_Seller extends BusinessParty, PostalAddressFactory, IContactFactory {
	
	// BT-27 ++ 1..1 Seller name / ram:Name / UBL: <cac:PartyName><cbc:Name> 

	// BT-28 ++ 0..1 Seller trading name / ram:TradingBusinessName / UBL: <cac:PartyLegalEntity><cbc:RegistrationName>

	// BT-29 ++ 0..n Seller identifier / <ram:ID><ram:GlobalID> / <cac:PartyIdentification><cbc:ID>

	// BT-30 ++ 0..1 Seller legal registration identifier [HRA-Eintrag] / <ram:SpecifiedLegalOrganization><ram:ID> / cbc:CompanyID

	// BT-31 ++ 0..1 Seller VAT identifier z.B. DE 123456789 / <ram:SpecifiedTaxRegistration><ram:ID> / <cac:PartyTaxScheme><cbc:CompanyID>
//	Umsatzsteueridentnummer des Verkäufers BT-32
//	Steuernummer des Verkäufers            BT-31
//	Die betriebswirtschaftlichen Begriffe werden über einen Scheme identifier unterschieden. 
//	Code Codename 
//	VA . Umsatzsteuernummer
//	FC . Steuernummer 	

	// BT-32 ++ 0..1 Seller tax registration identifier , @see BT-31
	default String getTaxRegistrationId() {
		List<Identifier> list = getTaxRegistrationIdentifier();
		if(list.isEmpty()) return null;
//		if(list.size()==1) return list.get(0).getContent();
		for (int i=0; i<list.size(); i++) {
			Identifier id = list.get(i);
			if(id.getSchemeIdentifier().startsWith("FC")) return id.getContent();
		}
		return null;
	}
	
	// BT-33 ++ 0..1 Seller additional legal information / <ram:Description> / <cac:PartyLegalEntity><cbc:CompanyLegalForm>
	
	// BT-34 ++ 0..1 Seller electronic address / URIUniversalCommunication / <cac:Contact><cbc:ElectronicMail>
	// CII in Doku steht : DefinedTradeContact.URIUniversalCommunication
	//     in Beispielen : <ram:DefinedTradeContact><ram:EmailURIUniversalCommunication><ram:URIID>
	
	// BG-5 ++ 1..1 SELLER POSTAL ADDRESS
	public PostalAddress getAddress();
	public void setAddress(PostalAddress address);

	// BG-6 ++ 0..1 SELLER CONTACT
	public IContact getIContact();
	public void setIContact(IContact contact);
	
}
