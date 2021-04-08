package com.klst.einvoice.ubl;

import java.util.List;
import java.util.logging.Logger;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.einvoice.PostalAddress;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalStreetNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuildingNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostalZoneType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StreetNameType;

/* Gruppe BUYER POSTAL ADDRESS
 * Eine Gruppe von Informationselementen, die Informationen über die Anschrift des Erwerbers liefern.
 */
/* Gruppe SELLER POSTAL ADDRESS
 * Eine Gruppe von Informationselementen, die Informationen über die Verkäuferanschrift liefern.

Name                                        ID    Semantischer Datentyp Anz. 
Seller address line 1                       BT-35 Text                  0..1 
Die Hauptzeile in einer Anschrift. 
Üblicherweise ist dies entweder Strasse und Hausnummer oder der Text "Postfach" gefolgt von der Postfachnummer.
Seller address line 2                       BT-36 Text                  0..1
Eine zusätzliche Adresszeile in einer Anschrift, die verwendet werden kann, um weitere Einzelheiten in Ergänzung zur Hauptzeile anzugeben.
Seller address line 3                       BT-162 Text                 0..1
Eine zusätzliche Adresszeile in einer Anschrift, die verwendet werden kann, um weitere Einzelheiten in Ergänzung zur Hauptzeile anzugeben.
Seller city                                 BT-37 Text                  1
Die Bezeichnung der Stadt oder Gemeinde, in der sich die Verkäuferanschrift befindet.
Seller post code                            BT-38 Text                  1
Die Postleitzahl.
Seller country subdivision                  BT-39 Text                  0..1
Die Unterteilung eines Landes (wie Region, Bundesland, Provinz etc.).
Seller country code                         BT-40 Code                  1
Ein Code, mit dem das Land bezeichnet wird.
Anmerkung: Die Liste der zulässigen Länder ist bei der ISO 3166-1 „Codes for the representation of names of countries and their subdivisions“ erhältlich.

 */
public class Address extends AddressType implements PostalAddress {

	@Override // implements PostalAddressFactory
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return create(countryCode, postalCode, city);
	}
	
	static Address create(String countryCode, String postalCode, String city) {
		return new Address(countryCode, postalCode, city, null);
	}

	static Address create() {
		return create((AddressType)null);
	}
	// copy factory
	public static PostalAddress createPostalAddress(AddressType object) {
		return create(object);
	}
	static Address create(AddressType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof AddressType && object.getClass()!=AddressType.class) {
			// object is instance of a subclass of AddressType, but not AddressType itself
			return (Address)object;
		} else {
			return new Address(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(Address.class.getName());

	// copy ctor
	private Address(AddressType address) {
		super();
		if(address!=null) {
			SCopyCtor.getInstance().invokeCopy(this, address);
		}
	}
	
	// [CII-DT-088] - StreetName shall not be used.
	private	Address(String countryCode, String postalCode, String city, String street) {
		this(countryCode, null, postalCode, city, street, null);
	}
	
	// building nicht in XRechnung-v1-2-0.pdf dokumentiert, [CII-DT-094] - BuildingNumber shall not be used.
	private Address(String countryCode, String postalCode, String city, String street, String building) {
		this(countryCode, null, postalCode, city, street, building);
	}
	
	private Address(String countryCode, String regionCode, String postalCode, String city, String street, String building) {
		super();
		setCountryCode(countryCode);

		if(regionCode!=null) {
			setCountrySubdivision(regionCode);
		}

		setPostCode(postalCode);
		setCity(city);
		
		if(street!=null) {
			StreetNameType streetName = new StreetNameType();
			streetName.setValue(street);
			this.setStreetName(streetName);
		}
		
		if(building!=null) {
			BuildingNameType buildingName = new BuildingNameType();
			buildingName.setValue(building);
			this.setBuildingName(buildingName);
		}
	}

	public String getStreet() {
		StreetNameType streetName = super.getStreetName();
		if(streetName==null) {
			return null;
		}
		return streetName.getValue();
	}
	
	public String getAdditionalStreet() { // optional, nicht in XRechnung
		AdditionalStreetNameType streetName = super.getAdditionalStreetName();
		if(streetName==null) {
			return null;
		}
		return streetName.getValue();
	}
	public void setAdditionalStreet(String streetName) {
		AdditionalStreetNameType additionalStreetName = new AdditionalStreetNameType();
		additionalStreetName.setValue(streetName);
		super.setAdditionalStreetName(additionalStreetName);
	}
	
	public String getBuilding() {
		BuildingNameType buildingName = super.getBuildingName();
		if(buildingName==null) {
			return null;
		}
		return buildingName.getValue();
	}
	
	private void setAddressLine(int lineNo, String addressLine) {
		List<AddressLineType> addressLines = super.getAddressLine();
		LOG.info(addressLine + " addressLines.size="+addressLines.size() + " lineNo="+lineNo);
		AddressLineType address = new AddressLineType();
		LineType line = new LineType();
		line.setValue(addressLine);
		address.setLine(line);
		if(addressLines.size()>=lineNo) {
			addressLines.add(lineNo-1, address);
		} else {
			addressLines.add(address);
		}
	}
	
	@Override
	public void setAddressLine1(String addressLine) {
		setAddressLine(1, addressLine);
	}

	@Override
	public void setAddressLine2(String addressLine) {
		setAddressLine(2, addressLine);
	}

	@Override
	public void setAddressLine3(String addressLine) {
		setAddressLine(3, addressLine);
	}

//	@Override
	private void setCity(String city) {
		CityNameType cityName = new CityNameType();
		cityName.setValue(city);
		this.setCityName(cityName);
	}

//	@Override
	private void setPostCode(String postCode) {
		PostalZoneType postalZone = new PostalZoneType();
		postalZone.setValue(postCode);
		this.setPostalZone(postalZone);
	}

	@Override
	public void setCountrySubdivision(String name) {
		if(name==null) return;
		CountrySubentityType countrySubentity = new CountrySubentityType();
		countrySubentity.setValue(name);
		super.setCountrySubentity(countrySubentity);
	}

//	@Override
	private void setCountryCode(String countryCode) {
		CountryType country = new CountryType();
		IdentificationCodeType identificationCode = new IdentificationCodeType();
		identificationCode.setValue(countryCode);
//		identificationCode.setListSchemeURI("ISO 3166-1");   // TODO countryCode mit ISO ==?== setSchemeID("ISO 3166-1") in cii
		country.setIdentificationCode(identificationCode);
		this.setCountry(country);
	}

	@Override
	public String getAddressLine1() {
		List<AddressLineType> addressLines = super.getAddressLine();
		return addressLines.size()==0 ? null : addressLines.get(0).getLine().getValue();
	}
	
	@Override
	public String getAddressLine2() {
		List<AddressLineType> addressLines = super.getAddressLine();
		return addressLines.size()<=1 ? null : addressLines.get(1).getLine().getValue();
	}
	
	@Override
	public String getAddressLine3() {
		List<AddressLineType> addressLines = super.getAddressLine();
		return addressLines.size()<=2 ? null : addressLines.get(2).getLine().getValue();
	}
	
	/**
	 * Seller/Buyer city
	 * <p>
	 * The common name of the city, town or village, where the address is located.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-37 / BT-52
	 * <br>Req.ID: R53
	 *  
	 * @return Text
	 */
	@Override
	public String getCity() {
		CityNameType cityName = super.getCityName();
		if(cityName==null) return null; 
		return cityName.getValue();
	}
	
	@Override
	public String getPostCode() {
		return super.getPostalZone()==null ? null : super.getPostalZone().getValue();
	}
	
	@Override
	public String getCountrySubdivision() {
		CountrySubentityType countrySubentity = super.getCountrySubentity();
		return countrySubentity==null ? null : countrySubentity.getValue();
	}
	
	@Override
	public String getCountryCode() {
		CountryType country = super.getCountry();
		// eigentlich ist BT-40 1..1 Seller country code und BT-55 1..1 Buyer country code mandatory
		// aber in ubl003.xml ist es null!!! daher defensiv:
		if(country==null) return null; 
		return country.getIdentificationCode().getValue();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(getCountryCode()==null ? "null" : getCountryCode());
		stringBuilder.append(getCountrySubdivision()==null ? "" : " ("+getCountrySubdivision()+")");
		stringBuilder.append(", ");
		stringBuilder.append(getPostCode()==null ? "null" : getPostCode());
		stringBuilder.append(", ");
		stringBuilder.append(getCity()==null ? "null" : getCity());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
