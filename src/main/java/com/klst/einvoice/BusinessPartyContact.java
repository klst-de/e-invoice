package com.klst.einvoice;

import com.klst.edoc.api.ContactInfo;

/**
 * SELLER or BUYER CONTACT
 */
public interface BusinessPartyContact extends ContactInfo {
	
	public ContactInfo getIContact();
	public void setIContact(ContactInfo contact);

	@Override
	default String getContactPoint() {
		return getIContact()==null ? null : getIContact().getContactPoint();
	}
	@Override
	default String getContactTelephone() {
		return getIContact()==null ? null : getIContact().getContactTelephone();
	}
	@Override
	default String getContactEmail() {
		return getIContact()==null ? null : getIContact().getContactEmail();
	}

}
