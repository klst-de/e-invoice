package com.klst.un.unece.uncefact;

import com.klst.cius.PostalAddress;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CountryIDType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class TradeAddress extends TradeAddressType implements PostalAddress {

	TradeAddress() {
		super();
	}

	public TradeAddress(String countryCode, String postalCode, String city, String street) {
		this(countryCode, null, postalCode, city, street, null);
	}
	
	// building nicht in XRechnung-v1-2-0.pdf dokumentiert
	public TradeAddress(String countryCode, String postalCode, String city, String street, String building) {
		this(countryCode, null, postalCode, city, street, building);
	}
	
	public TradeAddress(String countryCode, String regionCode, String postalCode, String city, String street, String building) {
		this();
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
//		if(building!=null) {
//			TextType buildingName = new TextType();
//			buildingName.setValue(building);
//			this.setBuildingNumber(buildingName);
//		}
		if(mStreet!=null) {
			// wg.  	[CII-DT-088] - StreetName shall not be used.
//			TextType streetName = new TextType();
//			streetName.setValue(street);
//			this.setStreetName(streetName);
			setAddressLine3(street);
		}
		
	}

	@Override
	public void setAddressLine1(String addressLine) {
		TextType line = new TextType();
		line.setValue(addressLine);
		super.setLineOne(line);
	}

	@Override
	public void setAddressLine2(String addressLine) {
		TextType line = new TextType();
		line.setValue(addressLine);
		super.setLineTwo(line);
	}

	@Override
	public void setAddressLine3(String addressLine) {
		TextType line = new TextType();
		line.setValue(addressLine);
		super.setLineThree(line);
	}

	@Override
	public void setCity(String city) {
		TextType cityName = new TextType();
		cityName.setValue(city);
		this.setCityName(cityName);
	}

	@Override
	public void setPostCode(String postCode) {
		CodeType postcode = new CodeType();
		postcode.setValue(postCode);
		this.setPostcodeCode(postcode);
	}

	@Override
	public void setCountrySubdivision(String countrySubdivision) {
		IDType region = new IDType();
		region.setValue(countrySubdivision);
		this.setCountrySubDivisionID(region);
	}

	@Override
	public void setCountryCode(String countryCode) {
		CountryIDType countryID = new CountryIDType();
		countryID.setValue(countryCode);
//		countryID.setSchemeID("ISO 3166-1"); // TODO countryCode mit ISO
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
		return super.getCityName().getValue();
	}
	
	@Override
	public String getPostCode() {
		return super.getPostcodeCode().getValue();
	}
	
	@Override
	public String getCountrySubdivision() {
		IDType region = super.getCountrySubDivisionID();
		if(region==null) {
			return null;
		}
		return region.getValue();
	}

	@Override
	public String getCountryCode() {
		return super.getCountryID().getValue();
	}

}