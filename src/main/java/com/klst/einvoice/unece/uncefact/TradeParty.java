package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.BusinessPartyAddress;
import com.klst.edoc.api.BusinessPartyContact;
import com.klst.edoc.api.ContactInfo;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.api.PostalAddress;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.BusinessPartyFactory;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LegalOrganizationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TaxRegistrationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.UniversalCommunicationType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

// BG-4 + 1..1 SELLER
// BG-7 + 1..1 BUYER
// BG-10 + 0..1 PAYEE
// BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
public class TradeParty extends TradePartyType implements BusinessParty, BusinessPartyAddress, BusinessPartyContact { 

	@Override  // implements BusinessPartyFactory
	public BusinessParty createParty(String name, String tradingName, PostalAddress address, ContactInfo contact) {
		return create(name, tradingName, address, contact);
	}
	static TradeParty create(String name, String tradingName, PostalAddress address, ContactInfo contact) {
		return new TradeParty(name, tradingName, address, contact);
	}

	static TradeParty create() { // aka factory
		return new TradeParty((TradePartyType)null);
	}
	// copy factory
	static TradeParty create(TradePartyType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof TradePartyType && object.getClass()!=TradePartyType.class) {
			// object is instance of a subclass of TradePartyType, but not TradePartyType itself
			return (TradeParty)object;
		} else {
			return new TradeParty(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(TradeParty.class.getName());

	// copy ctor
	private TradeParty(TradePartyType doc) {
		super();
		if(doc!=null) {
			SCopyCtor.getInstance().invokeCopy(this, doc);
			LOG.config("copy ctor:"+this);
		}
	}

	/**
	 * ctor for BusinessParty - use BusinessPartyFactory method
	 * 
	 * @param (registration)Name BT-27 1..1 Name des Verkäufers   / BT-44 1..1 Name des Käufers
	 * @param businessName       BT-28 0..1 Handelsname des Verkäufers / Seller trading name
	 * @param address            BG-5  1..1 SELLER POSTAL ADDRESS / BG-8  1..1 BUYER POSTAL ADDRESS
	 * @param contact            BG-6  0..1 SELLER CONTACT        / BG-9  0..1 BUYER CONTACT
	 * 
	 * @see BusinessPartyFactory
	 */
	private TradeParty(String registrationName, String businessName, PostalAddress address, ContactInfo contact) {
		super();
		setRegistrationName(registrationName);
		setBusinessName(businessName);
		setAddress(address);
		if(contact!=null) setContactInfo(contact);
	}

	// PostalAddress
	@Override
	public PostalAddress getAddress() {
		TradeAddressType address = super.getPostalTradeAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return TradeAddress.create(address);
	}

	@Override
	public void setAddress(PostalAddress address) {
		if(address!=null) super.setPostalTradeAddress((TradeAddress)address);
	}
	
	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return TradeAddress.create(countryCode, postalCode, city);
	}


	// Contact
	@Override
	public ContactInfo getContactInfo() {
		List<TradeContactType> tradeContactList = super.getDefinedTradeContact();
		return tradeContactList.isEmpty() ? null : TradeContact.create(tradeContactList.get(0));
	}

	@Override
	public void setContactInfo(ContactInfo contact) {
		super.getDefinedTradeContact().add((TradeContact)contact);	
	}

	@Override
	public ContactInfo createContactInfo(String contactName, String contactTel, String contactMail) {
		return TradeContact.create(contactName, contactTel, contactMail);
	}

	// (registration)Name
	// BG-4.BT-27  1..1 Seller name
	// BG-7.BT-44  1..1 Buyer name
	// BG-10.BT-59 1..1 Payee name
	// BG-11.BT-62 1..1 Seller tax representative name
	// BG-13.BT-70 0..1 Deliver to party name
	@Override
	public String getRegistrationName() {
		return super.getName()==null ? null : getName().getValue();
	}
	// nicht public, da im ctor
	void setRegistrationName(String name) {
		if(name==null) return;
		super.setName(Text.create(name));
	}

	// businessName
	// BG-4.BT-28  0..1 Seller trading name (also known as Business name)
	// BG-7.BT-45  0..1  Buyer trading name
	@Override
	public String getBusinessName() {
		TextType text = super.getSpecifiedLegalOrganization()==null ? null : getSpecifiedLegalOrganization().getTradingBusinessName();
		return text==null ? null : text.getValue();
	}
	@Override
	public void setBusinessName(String name) {
		if(name==null) return;
		if(super.getSpecifiedLegalOrganization()==null) {
			setSpecifiedLegalOrganization(new LegalOrganizationType());
		}
		getSpecifiedLegalOrganization().setTradingBusinessName(Text.create(name));
	}

	// BG-4.BT-29  0..n Seller identifier
	// BG-7.BT-46  0..1  Buyer identifier
	// BG-10.BT-60 0..1  Payee identifier
	@Override // 0..n returns the first
/*
ID vs GlobalID
Anwendung: 
Wenn der Verkäufer eine Global ID hat, soll diese genutzt werden. 
Ansonsten wird das Feld ID genutzt.
 */
	public Identifier getIdentifier() {
		List<IDType> listGlobalID = super.getGlobalID();
		if(listGlobalID.isEmpty()) { // Ansonsten wird das Feld ID genutzt:
			List<IDType> list = this.getID();
			return list.isEmpty() ? null : new ID(list.get(0).getValue(), list.get(0).getSchemeID());
		} else {
			return listGlobalID.isEmpty() ? null : new ID(listGlobalID.get(0).getValue(), listGlobalID.get(0).getSchemeID());
		}
	}
	@Override
	public String getId() {
		List<IDType> listGlobalID = super.getGlobalID();
		if(listGlobalID.isEmpty()) { // Ansonsten wird das Feld ID genutzt:
			List<IDType> list = this.getID();
			return list.isEmpty() ? null : list.get(0).getValue();
		} else {
			// wenn getSchemeID existiert, dann macht weglassen wenig Sinn!
			return listGlobalID.isEmpty() ? null : listGlobalID.get(0).getValue();
		}
	}
	@Override
	public void setId(String name, String schemeID) {
		addId(name, schemeID);
	}
	@Override
	public void addId(String name, String schemeID) {
		if(name==null) return;
		// mit schemeID ==> GlobalID
		if(schemeID==null) {
			super.getID().add(new ID(name, schemeID));
		} else {
			super.getGlobalID().add(new ID(name, schemeID));
		}
	}

	// BG-4.BT-30  0..1 Seller legal registration identifier 
	// BG-7.BT-47  0..1  Buyer legal registration identifier
	// BG-10.BT-61 0..1  Payee legal registration identifier
	@Override
	public String getCompanyId() {
		IDType id = super.getSpecifiedLegalOrganization()==null ? null : getSpecifiedLegalOrganization().getID();
		return id==null ? null : id.getValue();
	}
	@Override
	public Identifier getCompanyIdentifier() {
		IDType id = super.getSpecifiedLegalOrganization()==null ? null : getSpecifiedLegalOrganization().getID();
		return id==null ? null : new ID(id.getValue(), id.getSchemeID());
	}

	@Override
	public void setCompanyId(String name, String schemeID) {
		if(name==null) return;
		if(super.getSpecifiedLegalOrganization()==null) {
			setSpecifiedLegalOrganization(new LegalOrganizationType());
		}
		getSpecifiedLegalOrganization().setID(new ID(name, schemeID));
	}

	// BG-4.BT-31  0..1 Seller VAT identifier mit schemeID BT-31-0 "VA"
	// BG-4.BT-32  0..1 Seller tax registration identifier mit schemeID BT-32-0 "FC"
	// BG-7.BT-48  0..1  Buyer VAT identifier
	// BG-11.BT-63 1..1 Seller tax representative VAT identifier
	@Override
	public List<Identifier> getTaxRegistrationIdentifier() {
		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
		List<Identifier> result = new ArrayList<Identifier>(taxRegistrationList.size());
		if(taxRegistrationList.isEmpty()) return result;
		taxRegistrationList.forEach(taxRegistration -> {
			result.add(new ID(taxRegistration.getID()));
		});
		return result;
	}
	
	@Override
	public void setTaxRegistrationId(String name, String schemeID) {
		addTaxRegistrationId(name, schemeID);
	}
	@Override
	public void addTaxRegistrationId(String name, String schemeID) {
		if(name==null) return;
		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
		TaxRegistrationType taxRegistration = new TaxRegistrationType();
		taxRegistration.setID(new ID(name, schemeID));
		taxRegistrationList.add(taxRegistration);
	}

	// BG-4.BT-33 0..1 Seller additional legal information
	@Override // 0..1 also genügt der erste
	public String getCompanyLegalForm() {
		List<TextType> textList = super.getDescription();
		return textList.isEmpty() ? null : textList.get(0).getValue();
	}

	@Override
	public void setCompanyLegalForm(String name) {
		if(name==null) return;
		super.getDescription().add(Text.create(name));
	}

	// BG-4.BT-34 Seller electronic address
	// BG-7.BT-49 Buyer electronic address
	@Override // 0..1 also genügt der erste
	public Identifier getUriUniversalCommunication() {
		List<UniversalCommunicationType> uriList = super.getURIUniversalCommunication();
		if(uriList.isEmpty()) return null;
		return new ID(uriList.get(0).getURIID().getValue(), uriList.get(0).getURIID().getSchemeID()); 
	}

	@Override
	public void setUriUniversalCommunication(String name, String schemeID) {
		if(name==null) return;
		UniversalCommunicationType universalCommunicationType = new UniversalCommunicationType();
		universalCommunicationType.setURIID(new ID(name, schemeID));
		super.getURIUniversalCommunication().add(universalCommunicationType);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[RegistrationName:");
		stringBuilder.append(getRegistrationName()==null ? "null" : getRegistrationName());
		stringBuilder.append(", BusinessName:");
		stringBuilder.append(getBusinessName()==null ? "null" : getBusinessName());
		stringBuilder.append(", Id:");
		stringBuilder.append(getId()==null ? "null" : getId());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
