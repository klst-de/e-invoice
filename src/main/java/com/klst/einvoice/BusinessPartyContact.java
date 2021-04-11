package com.klst.einvoice;

import com.klst.edoc.api.ContactInfo;

/**
 * SELLER or BUYER CONTACT
 */
public interface BusinessPartyContact extends ContactInfo {
	
	public ContactInfo getContactInfo();
	public void setContactInfo(ContactInfo contact);

	@Override
	default String getContactPoint() {
		return getContactInfo()==null ? null : getContactInfo().getContactPoint();
	}
	@Override
	default String getContactTelephone() {
		return getContactInfo()==null ? null : getContactInfo().getContactTelephone();
	}
	@Override
	default String getContactEmail() {
		return getContactInfo()==null ? null : getContactInfo().getContactEmail();
	}

}
