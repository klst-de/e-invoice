package com.klst.einvoice.unece.uncefact;

import java.util.List;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.PostalAddress;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CountryIDType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class TradeAddress extends TradeAddressType implements PostalAddress {

	@Override // implements PostalAddressFactory
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return create(countryCode, postalCode, city);
	}
	
	static TradeAddress create(String countryCode, String postalCode, String city) {
		return new TradeAddress(countryCode, postalCode, city, null);
	}

	static TradeAddress create() {
		return create((TradeAddressType)null);
	}
	// copy factory
	static TradeAddress create(TradeAddressType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof TradeAddressType && object.getClass()!=TradeAddressType.class) {
			// object is instance of a subclass of TradeAddressType, but not TradeAddressType itself
			return (TradeAddress)object;
		} else {
			return new TradeAddress(object); 
		}
	}

	// copy ctor
	private TradeAddress(TradeAddressType address) {
		super();
		if(address!=null) {
			SCopyCtor.getInstance().invokeCopy(this, address);
		}
	}
	
	private TradeAddress(String countryCode, String postalCode, String city, String street) {
		this(countryCode, null, postalCode, city, street, null);
	}
	
	// building nicht in XRechnung-v1-2-0.pdf dokumentiert
	private TradeAddress(String countryCode, String postalCode, String city, String street, String building) {
		this(countryCode, null, postalCode, city, street, building);
	}
	
	private TradeAddress(String countryCode, String regionCode, String postalCode, String city, String street, String building) {
		super();
		setCountryCode(countryCode);
		
		if(regionCode!=null) {
			setCountrySubdivision(regionCode);
		}
		
		setPostCode(postalCode);
		setCity(city);
		
		// wg.  	[CII-DT-094] - BuildingNumber shall not be used.
		String mStreet = street;
		if(mStreet==null) {
			mStreet = building;
		} else {
			if(building!=null) {
				mStreet = mStreet + " " + building;
			}
		}
		if(mStreet!=null) {
			// wg.  	[CII-DT-088] - StreetName shall not be used.
			setAddressLine3(mStreet);
		}
		
	}

	@Override
	public void setAddressLine1(String addressLine) {
		super.setLineOne(Text.create(addressLine));
	}

	@Override
	public void setAddressLine2(String addressLine) {
		super.setLineTwo(Text.create(addressLine));
	}

	@Override
	public void setAddressLine3(String addressLine) {
		super.setLineThree(Text.create(addressLine));
	}

	private void setCity(String city) {
		super.setCityName(Text.create(city));
	}

	private void setPostCode(String postCode) {
		CodeType postcode = new CodeType();
		postcode.setValue(postCode);
		this.setPostcodeCode(postcode);
	}

	@Override
	public void setCountrySubdivision(String countrySubdivision) {
		TextType region = new TextType();
		region.setValue(countrySubdivision);
		this.getCountrySubDivisionName().add(region);
	}

	private void setCountryCode(String countryCode) {
		CountryIDType countryID = new CountryIDType();
		countryID.setValue(countryCode);
//		countryID.setSchemeID("ISO 3166-1"); // countryCode mit ISO check in qualifieddatatype._103
		this.setCountryID(countryID);
	}

	@Override
	public String getAddressLine1() {
		TextType line = super.getLineOne();
		return line==null ? null : line.getValue();
	}
	
	@Override
	public String getAddressLine2() {
		TextType line = super.getLineTwo();
		return line==null ? null : line.getValue();
	}
	
	@Override
	public String getAddressLine3() {
		TextType line = super.getLineThree();
		return line==null ? null : line.getValue();
	}
	
	@Override
	public String getCity() {
		return super.getCityName()==null ? null : super.getCityName().getValue();
	}
	
	@Override
	public String getPostCode() {
		return super.getPostcodeCode()==null ? null : super.getPostcodeCode().getValue();
	}
	
	@Override
	public String getCountrySubdivision() {
		List<TextType> regions = super.getCountrySubDivisionName();
		return regions.isEmpty() ? null : regions.get(0).getValue();
	}

	@Override
	public String getCountryCode() {
		return super.getCountryID()==null ? null : super.getCountryID().getValue();
	}

//	@Override
	public String getStreet() {
		return super.getStreetName()==null ? null : super.getStreetName().getValue();
	}

//	@Override
	public String getBuilding() {
		return super.getBuildingNumber()==null ? null : super.getBuildingNumber().getValue();
	}
	
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
