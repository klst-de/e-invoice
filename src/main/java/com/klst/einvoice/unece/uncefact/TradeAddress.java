package com.klst.einvoice.unece.uncefact;

import com.klst.einvoice.PostalAddress;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CountryIDType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class TradeAddress extends TradeAddressType implements PostalAddress {

	TradeAddress() {
		super();
	}

	// copy ctor
	public TradeAddress(TradeAddressType address) {
		this();
		// TODO testen
//		this.setCountryCode(((TradeAddress)address).getCountryCode());
		// ==
		this.setCountryCode(address.getCountryID().getValue());
		
		IDType region = address.getCountrySubDivisionID();
		if(region!=null) this.setCountrySubdivision(region.getValue());
//		this.setCountrySubdivision(((TradeAddress)address).getCountrySubdivision());
		
//		this.setPostCode(((TradeAddress)address).getPostCode());
		this.setPostCode(address.getPostcodeCode().getValue());
		
//		this.setCity(((TradeAddress)address).getCity());
		this.setCity(address.getCityName().getValue());
		
		super.setStreetName(address.getStreetName());
		super.setBuildingName(address.getBuildingName());
		super.setBuildingNumber(address.getBuildingNumber());
		
		this.setAddressLine1( address.getLineOne()==null ? null : address.getLineOne().getValue() );
		this.setAddressLine2( address.getLineTwo()==null ? null : address.getLineTwo().getValue() );
		this.setAddressLine3( address.getLineThree()==null ? null : address.getLineThree().getValue() );
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
		if(mStreet!=null) {
			// wg.  	[CII-DT-088] - StreetName shall not be used.
			setAddressLine3(mStreet);
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
		return region==null ? null : region.getValue();
	}

	@Override
	public String getCountryCode() {
		return super.getCountryID().getValue();
	}

	@Override
	public String getStreet() {
		return super.getStreetName()==null ? null : super.getStreetName().getValue();
	}

	@Override
	public String getBuilding() {
		return super.getBuildingNumber()==null ? null : super.getBuildingNumber().getValue();
	}

}
