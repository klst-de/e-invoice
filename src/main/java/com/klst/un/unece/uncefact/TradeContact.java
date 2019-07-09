package com.klst.un.unece.uncefact;

import com.klst.cius.IContact;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.UniversalCommunicationType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class TradeContact extends TradeContactType implements IContact {

	TradeContact() {
		super();
	}

	// copy ctor
	public TradeContact(TradeContactType contact) {
		this();
//		this.setContactPoint(((TradeContact)contact).getContactPoint());
//		this.setContactTelephone(((TradeContact)contact).getContactTelephone());
//		this.setContactEmail(((TradeContact)contact).getContactEmail());
		this.setContactPoint(contact.getPersonName().getValue());
		UniversalCommunicationType universalCommunicationType = contact.getTelephoneUniversalCommunication();
		if(universalCommunicationType==null) {
			// darf nicht sein
		} else {
			this.setContactTelephone(universalCommunicationType.getCompleteNumber().getValue());
		}
		this.setContactEmail(contact.getEmailURIUniversalCommunication().getURIID().getValue());
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
	public TradeContact(String contactName, String contactTel, String contactMail) {
		setContactPoint(contactName);
		setContactTelephone(contactTel);
		setContactEmail(contactMail);
	}
	
	TradeContact(IContact contact) {
		this(contact.getContactPoint(), contact.getContactTelephone(), contact.getContactEmail());
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
}
