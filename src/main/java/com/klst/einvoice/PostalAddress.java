package com.klst.einvoice;

/**
 * BG-5 , BG-8 , BG-12 : POSTAL ADDRESS
 * <p>
 * A group (BG) of business terms (BT) providing information about the business partner.
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for BGs, BTs, rules and request IDs
 */
public interface PostalAddress extends PostalAddressFactory {

	// use factory: createAddress(String countryCode, String postalCode, String city);

	public void setAddressLine1(String addressLine);
	public void setAddressLine2(String addressLine);
	public void setAddressLine3(String addressLine);
//	public void setCity(String city);
//	public void setPostCode(String postCode);
	public void setCountrySubdivision(String countrySubdivision);
//	public void setCountryCode(String countryCode);

	public String getAddressLine1();
	public String getAddressLine2();
	public String getAddressLine3();
	public String getCity();
	public String getPostCode();
	public String getCountrySubdivision();
	public String getCountryCode();
	
	// do not use (not defined in EN_16931_1)
	public String getStreet(); // [CII-DT-088] - StreetName shall not be used.
	public String getBuilding(); // [CII-DT-094] - BuildingNumber shall not be used.
}
