package com.klst.einvoice;

/**
 * BG-5 , BG-8 : POSTAL ADDRESS
 * <p>
 * A group (BG) of business terms (BT) providing information about the business partner.
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for BGs, BTs, rules and request IDs
 */

/*  (de) rules / Geschäftsregel:
 * 
 * BR-8     : Verkäufer 
 * Eine Rechnung muss die Postanschrift des Verkäufers (BG-5) enthalten.
 * 
 * BR-9     : Postanschrift des Verkäufers 
 * Eine Postanschrift des Verkäufers (BG-5) muss einen Ländercode der Verkäuferanschrift (BT-40) enthalten.
 * 
 * BR-10    : Käufer 
 * Eine Rechnung muss die Postanschrift des Käufers (BG-8) enthalten.
 * 
 * BR-11    : Postanschrift des Käufers 
 * Die Postanschrift des Käufers muss einen Ländercode der Käuferanschrift (BT-55) enthalten.
 * 
 * BR-DE-3  : Stadt der Verkäuferanschrift
 * Das Element „Seller city“ (BT-37) muss übermittelt werden.
 * 
 * BR-DE-4  : Postleitzahl der Verkäuferanschrift
 * Das Element „Seller post code“ (BT-38) muss übermittelt werden.
 * 
 * BR-DE-8  : Stadt der Erwerberanschrift
 * Das Element „Buyer city“ (BT-52) muss übermittelt werden.
 * 
 * BR-DE-9  : Postleitzahl der Erwerberanschrift
 * Das Element „Buyer post code“ (BT-53) muss übermittelt werden.
 * 

ID    | Level | Cardinality | Business Term         | Description | Usage Note | Req.ID | Semantic data type
BG-5  | ++    | 1..1        | SELLER POSTAL ADDRESS | A group of business terms providing information about the address of the Seller.
                                                                  | Sufficient components of the address are to be filled to comply with legal requirements. 
                                                                               | R53
BG-8  | ++    | 1..1        | BUYER POSTAL ADDRESS  | A group of business terms providing information about the postal address for the Buyer.
                                                                  | Sufficient components of the address are to be filled to comply with legal requirements. 
                                                                               | R53

BT-35 | +++  | 0..1        | Seller address line 1 | The main address line in an address
BT-36 | +++  | 0..1        | Seller address line 2
BT-162| +++  | 0..1        | Seller address line 3
BT-37 | +++  | 0..1        | Seller city           | The common name of the city, town or village, where the Seller address is located.
BT-38 | +++  | 0..1        | Seller post code      | The identifier for an addressable group of properties according to the relevant postal service.
                                                                 | Such as a ZIP code or a post code.
BT-39 | +++  | 0..1        | Seller country subdivision | The subdivision of a country. | Such as a region, a county, a state, a province, etc.
BT-40 | +++  | 1..1        | Seller country code   | A code that identifies the country. | 
If no tax representative is specified, this is
the country where VAT is liable. The lists of
valid countries are registered with the
EN ISO 3166-1 Maintenance agency, “Codes
for the representation of names of
countries and their subdivisions”.
                                                              
 */
public interface PostalAddress {

	public void setAddressLine1(String addressLine);
	public void setAddressLine2(String addressLine);
	public void setAddressLine3(String addressLine);
	public void setCity(String city);
	public void setPostCode(String postCode);
	public void setCountrySubdivision(String countrySubdivision);
	public void setCountryCode(String countryCode);

	public String getAddressLine1();
	public String getAddressLine2();
	public String getAddressLine3();
	public String getCity();
	public String getPostCode();
	public String getCountrySubdivision();
	public String getCountryCode();
	
	// do not use:
	public String getStreet(); // [CII-DT-088] - StreetName shall not be used.
	public String getBuilding(); // [CII-DT-094] - BuildingNumber shall not be used.
}
