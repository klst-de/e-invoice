package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BG10_Payee;
import com.klst.einvoice.BG11_SellerTaxRepresentativeParty;
import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessPartyFactory;
import com.klst.einvoice.IContact;
import com.klst.einvoice.Identifier;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.reflection.CopyCtor;

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
public class TradeParty extends TradePartyType implements BG4_Seller, BG7_Buyer, BG10_Payee, BG11_SellerTaxRepresentativeParty { 

	static TradeParty create() {
		return create((TradePartyType)null);
	}
	// copy factory
	static TradeParty create(TradePartyType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof TradePartyType && object.getClass()!=TradePartyType.class) {
			// object is instance of a subclass of TradeTaxType, but not TradeTaxType itself
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
			CopyCtor.invokeCopy(this, doc);
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
	TradeParty(String name, String businessName, PostalAddress address, IContact contact) {
		super();
		init(name, businessName, address, contact);
	}
	
	void init(String registrationName, String businessName, PostalAddress address, IContact contact) {
		setPartyName(registrationName);
		setBusinessName(businessName);
		setAddress(address);
		if(contact!=null) setIContact(contact);
	}

	// PostalAddress
	@Override
	public PostalAddress getAddress() {
		TradeAddressType address = super.getPostalTradeAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return new TradeAddress(address);
	}

	@Override
	public void setAddress(PostalAddress address) {
		if(address!=null) setAddress((TradeAddressType)address);
	}
	void setAddress(TradeAddressType address) {
		super.setPostalTradeAddress(address);
	}
	
	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return new TradeAddress(countryCode, postalCode, city, null);
	}

	@Override
	public PostalAddress createAddress(PostalAddress address) {
		return new TradeAddress((TradeAddressType)address);
	}

	// Contact
	@Override
	public IContact getIContact() {
		List<TradeContactType> tradeContactList = super.getDefinedTradeContact();
		return tradeContactList.isEmpty() ? null : new TradeContact(tradeContactList.get(0));
	}

	@Override
	public void setIContact(IContact contact) {
		super.getDefinedTradeContact().add((TradeContact)contact);	
	}

	@Override
	public IContact createContact(String contactName, String contactTel, String contactMail) {
		return new TradeContact(contactName, contactTel, contactMail);
	}

	@Override
	public IContact createContact(IContact contact) {
		return new TradeContact((TradeContactType)contact);
	}

	String getPartyName() {
		return super.getName()==null ? null : getName().getValue();
	}

	void setPartyName(String name) {
		if(name==null) return;
		super.setName(new Text(name));
	}
	
	@Override
	public String getRegistrationName() {
		return getPartyName();
	}

	@Override
	public void setRegistrationName(String name) {
		setPartyName(name);
	}

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
		getSpecifiedLegalOrganization().setTradingBusinessName(new Text(name));
	}

	@Override // 0..n returns the first
	public Identifier getIdentifier() {
		List<IDType> list = this.getID();
		return list.isEmpty() ? null : new ID(list.get(0).getValue(), list.get(0).getSchemeID());
	}
	public String getId() {
		List<IDType> list = this.getID();
		return list.isEmpty() ? null : list.get(0).getValue();
	}

	@Override
	public void setId(String name) {
		setId(name, null);
	}
	@Override
	public void setIdentifier(Identifier id) {
		if(id==null) return;
		setId(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void setId(String name, String schemeID) {
		if(name==null) return;
		super.getID().add(new ID(name, schemeID));
	}

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
	public void setCompanyIdentifier(Identifier id) {
		if(id==null) return;
		setCompanyId(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void setCompanyId(String name) {
		setCompanyId(name, null);
	}
	@Override
	public void setCompanyId(String name, String schemeID) {
		if(name==null) return;
		if(super.getSpecifiedLegalOrganization()==null) {
			setSpecifiedLegalOrganization(new LegalOrganizationType());
		}
		getSpecifiedLegalOrganization().setID(new ID(name, schemeID));
	}

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
	public void addTaxRegistrationIdentifier(Identifier id) {
		if(id==null) return;
		addTaxRegistrationId(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void addTaxRegistrationId(String name, String schemeID) {
		if(name==null) return;
		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
		TaxRegistrationType taxRegistration = new TaxRegistrationType();
		taxRegistration.setID(new ID(name, schemeID));
		taxRegistrationList.add(taxRegistration);
	}

	@Override // 0..1 also genügt der erste
	public String getCompanyLegalForm() {
		List<TextType> textList = super.getDescription();
		return textList.isEmpty() ? null : textList.get(0).getValue();
	}

	@Override
	public void setCompanyLegalForm(String name) {
		if(name==null) return;
		super.getDescription().add(new Text(name));
	}

	@Override // 0..1 also genügt der erste
	public Identifier getUriUniversalCommunication() {
		List<UniversalCommunicationType> uriList = super.getURIUniversalCommunication();
		if(uriList.isEmpty()) return null;
		return new ID(uriList.get(0).getURIID().getValue(), uriList.get(0).getURIID().getSchemeID()); 
	}

	@Override
	public void setUriUniversalCommunication(Identifier id) {
		if(id==null) return;
		setUriUniversalCommunication(id.getContent(), id.getSchemeIdentifier());
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
