package com.klst.einvoice;

/**
 * SELLER or BUYER CONTACT
 */
public interface BusinessPartyContact extends IContact {
	
	public IContact getIContact();
	public void setIContact(IContact contact);

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
