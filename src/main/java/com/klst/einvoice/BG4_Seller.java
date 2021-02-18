package com.klst.einvoice;

import java.util.List;

import com.klst.untdid.codelist.ReferenceCode;

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

/*   (en) rules
 * 
 * BR-6  Target / context: Seller, Business term / group: BT-87
 * An Invoice shall contain the Seller name (BT-27).
 * 
 * BR-8 
 * An Invoice shall contain the Seller postal address (BG-5).
 * 
 * BR-CO-26   Target / context: Seller, Business term / group: BT-29, BT-30, BT-31
 * In order for the buyer to automatically identify a supplier, 
 * Seller identifier (BT-29), the Seller legal registration identifier (BT-30) 
 * and/or the Seller VAT identifier (BT-31) shall be present.
 *
 *  (de) rules / Geschäftsregel:
 * 
 * BR-6     : Verkäufer 
 * Eine Rechnung muss den Namen des Verkäufers (BT-27) enthalten.
 * 
 * ... 
 * 
 */
public interface BG4_Seller extends BusinessParty, PostalAddressFactory, BG6_SellerContact {
	
	// BT-27 ++ 1..1 Seller name / ram:Name / UBL: <cac:PartyName><cbc:Name> 

	// BT-28 ++ 0..1 Seller trading name / ram:TradingBusinessName / UBL: <cac:PartyLegalEntity><cbc:RegistrationName>

	// BT-29 ++ 0..n Seller identifier / <ram:ID><ram:GlobalID> / <cac:PartyIdentification><cbc:ID>

	// BT-30 ++ 0..1 Seller legal registration identifier [HRA-Eintrag] / <ram:SpecifiedLegalOrganization><ram:ID> / cbc:CompanyID

	// BT-31 ++ 0..1 Seller VAT identifier z.B. DE 123456789 / <ram:SpecifiedTaxRegistration><ram:ID> / <cac:PartyTaxScheme><cbc:CompanyID>
//	Umsatzsteueridentnummer des Verkäufers BT-31
//	Steuernummer des Verkäufers            BT-32
//	Die betriebswirtschaftlichen Begriffe werden über einen Scheme identifier unterschieden. 
//	Code Codename 
//	VA . Umsatzsteuernummer
//	FC . Steuernummer 	

	static final ReferenceCode FC = ReferenceCode.FiscalNumber;
	
	/**
	 * Seller tax registration identifier
	 * <p>
	 * The local identification (defined by the Seller’s address) of the Seller for tax purposes or 
	 * a reference that enables the Seller to state his registered tax status.
	 * <p>
	 * This information may affect how the Buyer settles the payment (such as for social security fees). 
	 * E.g. in some countries, if the Seller is not registered as a tax paying entity 
	 * then the Buyer is required to withhold the amount of the tax and pay it on behalf of the Seller.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BG-4.BT-32
	 * <br>Rule ID: 	BR-S-2, BR-S-3, BR-S-4, BR-Z-2, BR-Z-3, BR-Z-4, 
	 *                  BR-E-2, BR-E-3, BR-E-4, BR-AE-2, BR-AE-3, BR-AE-4, 
	 *                  BR-IG-2, BR-IG-3, BR-IG-4, BR-IP-2, BR-IP-3, BR-IP-4,
	 * <br>Request ID: 	R47
	 * 
	 * @param name - tax registration identifier
	 * 
	 * @see BusinessParty#setVATRegistrationId(String)
	 */
	default void setTaxRegistrationId(String name) {
		addTaxRegistrationId(name, FC.getValue());
	}
	
	// BT-32 ++ 0..1 Seller tax registration identifier , @see BT-31
	default String getTaxRegistrationId() {
		List<Identifier> list = getTaxRegistrationIdentifier();
		if(list.isEmpty()) return null;
//		if(list.size()==1) return list.get(0).getContent();
		for (int i=0; i<list.size(); i++) {
			Identifier id = list.get(i);
			if(id.getSchemeIdentifier().startsWith(FC.getValue())) return id.getContent();
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

	// BG-6 0..1 SELLER CONTACT
//	public IContact getIContact();
//	public void setIContact(IContact contact);
	
}
