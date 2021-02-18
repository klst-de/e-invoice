package com.klst.einvoice.unece.uncefact;

import com.klst.einvoice.IContact;
import com.klst.einvoice.reflection.CopyCtor;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.UniversalCommunicationType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class TradeContact extends TradeContactType implements IContact {

	@Override // implements IContactFactory
	public IContact createContact(String contactName, String contactTel, String contactMail) {
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
			CopyCtor.invokeCopy(this, contact);
		}
	}

	/**
	 * ctor for Seller Contact which is mandatory group / BG-6
	 * 
	 * BUYER CONTACT group / BG-9 is optional 0..1
	 * 
	 * @param contactName mandatory text
	 * @param contactTel mandatory text
	 * @param contactMail mandatory text
	 */
	private TradeContact(String contactName, String contactTel, String contactMail) {
		setContactPoint(contactName);
		setContactTelephone(contactTel);
		setContactEmail(contactMail);
	}
	
	@Override
	public void setContactPoint(String name) {
		TextType cName = new TextType();
		cName.setValue(name);	
		super.setPersonName(cName);
	}

	@Override
	public void setContactTelephone(String contactTel) {
		TextType telephoneNo = new TextType();
		telephoneNo.setValue(contactTel);	
		UniversalCommunicationType telephone = new UniversalCommunicationType();
		telephone.setCompleteNumber(telephoneNo);
		super.setTelephoneUniversalCommunication(telephone);
	}

	@Override
	public void setContactEmail(String contactMail) {
		IDType uri = new IDType();
		uri.setValue(contactMail);
		UniversalCommunicationType electronicMail = new UniversalCommunicationType();
		electronicMail.setURIID(uri);
		super.setEmailURIUniversalCommunication(electronicMail);
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
