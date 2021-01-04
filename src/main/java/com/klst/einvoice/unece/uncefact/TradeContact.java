package com.klst.einvoice.unece.uncefact;

import com.klst.einvoice.IContact;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.UniversalCommunicationType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class TradeContact extends TradeContactType implements IContact {

	// copy ctor
	TradeContact(TradeContactType contact) {
		super();
		if(contact.getPersonName()!=null) {
			this.setContactPoint(contact.getPersonName().getValue());
		}
		UniversalCommunicationType universalCommunicationType = contact.getTelephoneUniversalCommunication();
		if(universalCommunicationType==null) {
			// darf nicht sein
		} else {
			this.setContactTelephone(universalCommunicationType.getCompleteNumber().getValue());
		}
		if(contact.getEmailURIUniversalCommunication()!=null) {
			this.setContactEmail(contact.getEmailURIUniversalCommunication().getURIID().getValue());
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
	TradeContact(String contactName, String contactTel, String contactMail) {
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
