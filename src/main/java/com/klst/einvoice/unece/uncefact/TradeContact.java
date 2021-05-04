package com.klst.einvoice.unece.uncefact;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.ContactInfo;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;

public class TradeContact extends TradeContactType implements ContactInfo {

	@Override // Factory
	public ContactInfo createContactInfo(String contactName, String contactTel, String contactMail) {
		return create(contactName, contactTel, contactMail);
	}
	
	static TradeContact create(String contactName, String contactTel, String contactMail) {
		return new TradeContact(contactName, contactTel, contactMail);
	}
	
	static TradeContact create() {
		return create((TradeContactType)null);
	}
	// copy factory
	static TradeContact create(TradeContactType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof TradeContactType && object.getClass()!=TradeContactType.class) {
			// object is instance of a subclass of TradeContactType, but not TradeContactType itself
			return (TradeContact)object;
		} else {
			return new TradeContact(object); 
		}
	}

	// copy ctor
	private TradeContact(TradeContactType contact) {
		super();
		if(contact!=null) {
			SCopyCtor.getInstance().invokeCopy(this, contact);
		}
	}

	/**
	 * ctor for Seller or Buyer Contact
	 * 
	 * @param contactName
	 * @param contactTel
	 * @param contactMail
	 */
	private TradeContact(String contactName, String contactTel, String contactMail) {
		setContactPoint(contactName);
		setContactTelephone(contactTel);
		setContactEmail(contactMail);
	}
	
	private void setContactPoint(String name) {
		super.setPersonName(Text.create(name));
	}

	private void setContactTelephone(String contactTel) {
		SCopyCtor.getInstance().newFieldInstance(this, "telephoneUniversalCommunication", contactTel);
		SCopyCtor.getInstance().set(getTelephoneUniversalCommunication(), "completeNumber", contactTel);
	}

	public void setContactEmail(String contactMail) {
		SCopyCtor.getInstance().newFieldInstance(this, "emailURIUniversalCommunication", contactMail);
		SCopyCtor.getInstance().set(getEmailURIUniversalCommunication(), "uriid", contactMail);
	}
	
	@Override
	public String getContactPoint() {
		return super.getPersonName().getValue();
	}
	
	@Override
	public String getContactTelephone() {
		return super.getTelephoneUniversalCommunication().getCompleteNumber().getValue();
	}
	
	@Override
	public String getContactEmail() {
		return super.getEmailURIUniversalCommunication().getURIID().getValue();
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(getContactPoint()==null ? "null" : getContactPoint());
		stringBuilder.append(", ");
		stringBuilder.append(getContactTelephone()==null ? "null" : getContactTelephone());
		stringBuilder.append(", ");
		stringBuilder.append(getContactEmail()==null ? "null" : getContactEmail());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
