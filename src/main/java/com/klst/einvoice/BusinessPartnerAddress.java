package com.klst.einvoice;

/**
 * SELLER or BUYER POSTAL ADDRESS
 */
public interface BusinessPartnerAddress extends PostalAddress {
	
	public PostalAddress getAddress();
	public void setAddress(PostalAddress address);

	@Override
	default void setAddressLine1(String addressLine) {
		PostalAddress address = getAddress();
		if(address!=null) {
			address.setAddressLine1(addressLine);
		}	
	}
	@Override
	default void setAddressLine2(String addressLine) {
		PostalAddress address = getAddress();
		if(address!=null) {
			address.setAddressLine2(addressLine);
		}	
	}
	@Override
	default void setAddressLine3(String addressLine) {
		PostalAddress address = getAddress();
		if(address!=null) {
			address.setAddressLine3(addressLine);
		}	
	}
	@Override
	default void setCountrySubdivision(String countrySubdivision) {
		PostalAddress address = getAddress();
		if(address!=null) {
			address.setCountrySubdivision(countrySubdivision);
		}	
	}

	@Override
	default String getAddressLine1() {
		return getAddress()==null ? null : getAddress().getAddressLine1();
	}
	@Override
	default String getAddressLine2() {
		return getAddress()==null ? null : getAddress().getAddressLine2();
	}
	@Override
	default String getAddressLine3() {
		return getAddress()==null ? null : getAddress().getAddressLine3();
	}
	@Override
	default String getCity() {
		return getAddress()==null ? null : getAddress().getCity();
	}
	@Override
	default String getPostCode() {
		return getAddress()==null ? null : getAddress().getPostCode();
	}
	@Override
	default String getCountrySubdivision() {
		return getAddress()==null ? null : getAddress().getCountrySubdivision();
	}
	@Override
	default String getCountryCode() {
		return getAddress()==null ? null : getAddress().getCountryCode();
	}

	// do not use (not defined in EN_16931_1)
	@Override
	default String getStreet() {
		return getAddress()==null ? null : getAddress().getStreet();
	}
	@Override
	default String getBuilding() {
		return getAddress()==null ? null : getAddress().getBuilding();
	}

}
