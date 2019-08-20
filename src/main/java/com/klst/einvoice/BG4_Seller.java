package com.klst.einvoice;

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
	    <ram:Name>[Seller name]</ram:Name>
	    <ram:Description>123/456/7890, HRA-Eintrag in […]</ram:Description>
	    <ram:SpecifiedLegalOrganization>
	        <ram:ID>[HRA-Eintrag]</ram:ID>
	        <ram:TradingBusinessName>[Seller trading name]</ram:TradingBusinessName>
	    </ram:SpecifiedLegalOrganization>
	    <ram:DefinedTradeContact>
	        <ram:PersonName>nicht vorhanden</ram:PersonName>
	        <ram:TelephoneUniversalCommunication>
	            <ram:CompleteNumber>+49 1234-5678</ram:CompleteNumber>
	        </ram:TelephoneUniversalCommunication>
	        <ram:EmailURIUniversalCommunication>
	            <ram:URIID>seller@email.de</ram:URIID>
	        </ram:EmailURIUniversalCommunication>
	    </ram:DefinedTradeContact>
	    <ram:PostalTradeAddress>
	        <ram:PostcodeCode>12345</ram:PostcodeCode>
	        <ram:LineOne>[Seller address line 1]</ram:LineOne>
	        <ram:CityName>[Seller city]</ram:CityName>
	        <ram:CountryID>DE</ram:CountryID>
	    </ram:PostalTradeAddress>
	    <ram:SpecifiedTaxRegistration>
	        <ram:ID schemeID="VA">DE 123456789</ram:ID>
	    </ram:SpecifiedTaxRegistration>
	</ram:SellerTradeParty>

dto UBL:
    <cac:AccountingSupplierParty>
        <cac:Party>
            <cac:PartyName>
                <cbc:Name>[Seller trading name]</cbc:Name>
            </cac:PartyName>
            <cac:PostalAddress>
                <cbc:StreetName>[Seller address line 1]</cbc:StreetName>
                <cbc:CityName>[Seller city]</cbc:CityName>
                <cbc:PostalZone>12345</cbc:PostalZone>
                <cac:Country>
                    <cbc:IdentificationCode>DE</cbc:IdentificationCode>
                </cac:Country>
            </cac:PostalAddress>
            <cac:PartyTaxScheme>
                <cbc:CompanyID>DE 123456789</cbc:CompanyID>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
                </cac:TaxScheme>
            </cac:PartyTaxScheme>
            <cac:PartyLegalEntity>
                <cbc:RegistrationName>[Seller name]</cbc:RegistrationName>
                <cbc:CompanyID>[HRA-Eintrag]</cbc:CompanyID>
                <cbc:CompanyLegalForm>123/456/7890, HRA-Eintrag in […]</cbc:CompanyLegalForm>
            </cac:PartyLegalEntity>
            <cac:Contact>
                <cbc:Name>nicht vorhanden</cbc:Name>
                <cbc:Telephone>+49 1234-5678</cbc:Telephone>
                <cbc:ElectronicMail>seller@email.de</cbc:ElectronicMail>
            </cac:Contact>
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
public interface BG4_Seller extends BG_Party {
	
	// BT-27 ++ 1..1 Seller name / ram:Name / UBL: <cac:PartyLegalEntity><cbc:RegistrationName>

	// BT-28 ++ 0..1 Seller trading name / ram:TradingBusinessName / UBL: <cac:PartyName><cbc:Name>

	// BT-29 ++ 0..n Seller identifier / <ram:ID><ram:GlobalID> / <cac:PartyIdentification><cbc:ID>

	// BT-30 ++ 0..1 Seller legal registration identifier [HRA-Eintrag] / <ram:SpecifiedLegalOrganization><ram:ID> / cbc:CompanyID

	// BT-31 ++ 0..1 Seller VAT identifier z.B. DE 123456789 / <ram:SpecifiedTaxRegistration><ram:ID> / <cac:PartyTaxScheme><cbc:CompanyID>
//	Steuernummer des Verkäufers            BT-31
//	Umsatzsteueridentnummer des Verkäufers BT-32
//	Die betriebswirtschaftlichen Begriffe werden über einen Scheme identifier unterschieden. 
//	Code Codename 
//	FC . Steuernummer 
//	VA . Umsatzsteuernummer

	// BT-32 ++ 0..1 Seller tax registration identifier , @see BT-31
	
	// BT-33 ++ 0..1 Seller additional legal information / <ram:Description> / <cac:PartyLegalEntity><cbc:CompanyLegalForm>
	
	// BT-34 ++ 0..1 Seller electronic address / URIUniversalCommunication / <cac:Contact><cbc:ElectronicMail>
	// CII in Doku steht : DefinedTradeContact.URIUniversalCommunication
	//     in Beispielen : <ram:DefinedTradeContact><ram:EmailURIUniversalCommunication><ram:URIID>
		
}
