package com.klst.cius;

/*
 * 
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
	// TODO testen in beiden Unterklassen
	public String getAddressLine1();
	public String getAddressLine2();
	public String getAddressLine3();
	public String getCity();
	public String getPostCode();
	public String getCountrySubdivision();
	public String getCountryCode();
}
