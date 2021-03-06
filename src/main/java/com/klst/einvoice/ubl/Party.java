package com.klst.einvoice.ubl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.BusinessParty;
import com.klst.edoc.api.BusinessPartyAddress;
import com.klst.edoc.api.BusinessPartyContact;
import com.klst.edoc.api.BusinessPartyFactory;
import com.klst.edoc.api.ContactInfo;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.api.PostalAddress;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyTaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLegalFormType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndpointIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;

/*
 * PartyName
 * PostalAddress
 * Contact
 * PartyTaxScheme
 * PartyLegalEntity
 */
public class Party extends PartyType implements BusinessParty, BusinessPartyAddress, BusinessPartyContact {

	@Override  // implements BusinessPartyFactory
	public BusinessParty createParty(String name, String tradingName, PostalAddress address, ContactInfo contact) {
		return create(name, tradingName, address, contact);
	}
	static Party create(String name, String tradingName, PostalAddress address, ContactInfo contact) {
		return new Party(name, tradingName, address, contact);
	}

	static Party create() {
		return create((PartyType)null);
	}
	// copy factory
	static Party create(PartyType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof PartyType && object.getClass()!=PartyType.class) {
			// object is instance of a subclass of PartyType, but not PartyType itself
			return (Party)object;
		} else {
			return new Party(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(Party.class.getName());
	
	// copy ctor
	private Party(PartyType party) {
		super();
		if(party!=null) {
			SCopyCtor.getInstance().invokeCopy(this, party);
			LOG.config("copy ctor:"+this);
		}
	}
	
	// in super existiert protected List<PartyLegalEntityType> partyLegalEntity
	PartyLegalEntityType partyLegalEntity;
	
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
	private Party(String name, String businessName, PostalAddress address, ContactInfo contact) {
		super();
		init(name, businessName, address, contact);
	}
	
	private void init(String registrationName, String businessName, PostalAddress address, ContactInfo contact) {
		partyLegalEntity = new PartyLegalEntityType();
		setRegistrationName(registrationName);
		setBusinessName(businessName);
		setAddress(address);
		setContactInfo(contact);
	}
	
	// PostalAddress
	@Override
	public PostalAddress getAddress() {
		AddressType address = getPostalAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return Address.create(address);
	}

	@Override
	public void setAddress(PostalAddress address) {
		this.setAddress((AddressType)address);
	}
	void setAddress(AddressType address) {
		if(address==null) return; // defensiv
		super.setPostalAddress(address);
	}
	
	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return Address.create(countryCode, postalCode, city);
	}


	// Contact
	@Override
	public ContactInfo getContactInfo() {
		return getContact()==null ? null : Contact.create(getContact());
	}

	@Override
	public void setContactInfo(ContactInfo contact) {
		super.setContact((ContactType)contact);	
	}

	@Override
	public ContactInfo createContactInfo(String contactName, String contactTel, String contactMail) {
		return Contact.create(contactName, contactTel, contactMail);
	}

	// (registration)Name
	// BG-4.BT-27  1..1 Seller name
	// BG-7.BT-44  1..1 Buyer name
	// BG-10.BT-59 1..1 Payee name
	// BG-11.BT-62 1..1 Seller tax representative name
	// BG-13.BT-70 0..1 Deliver to party name
	@Override
	public String getRegistrationName() {
		List<PartyLegalEntityType> partyLegalEntityList = getPartyLegalEntity();
		if(partyLegalEntityList.isEmpty()) return null;
		RegistrationNameType registrationName = partyLegalEntityList.get(0).getRegistrationName();
		return registrationName==null ? null : registrationName.getValue();
	}

	private void setRegistrationName(String name) {
		if(name==null) return;
		RegistrationNameType registrationName = new RegistrationNameType();
		registrationName.setValue(name);
		partyLegalEntity.setRegistrationName(registrationName);
		if(super.getPartyLegalEntity().isEmpty()) super.getPartyLegalEntity().add(partyLegalEntity);
	}
	
	// businessName
	// BG-4.BT-28  0..1 Seller trading name (also known as Business name)
	// BG-7.BT-45  0..1  Buyer trading name
	@Override
	public String getBusinessName() {
		List<PartyNameType> partyNameList = getPartyName();
		return partyNameList.isEmpty() ? null : partyNameList.get(0).getName().getValue();
	}

	@Override
	public void setBusinessName(String businessName) {
		if(businessName==null) return;
		NameType name = new NameType();
		name.setValue(businessName);
		PartyNameType partyName = new PartyNameType();
		partyName.setName(name);
		super.getPartyName().add(partyName);
	}

	// BG-4.BT-29  0..n Seller identifier / Kennung des Verkäufers
	// BG-7.BT-46  0..1  Buyer identifier
	// BG-10.BT-60 0..1  Payee identifier
	@Override
	public Identifier getIdentifier() {
		List<PartyIdentificationType> partyIdentificationList = getPartyIdentification();
		return partyIdentificationList.isEmpty() ? null 
				: new ID(partyIdentificationList.get(0).getID().getValue(), partyIdentificationList.get(0).getID().getSchemeID());
	}
	@Override
	public String getId() {
		List<PartyIdentificationType> partyIdentificationList = super.getPartyIdentification();
		return partyIdentificationList.isEmpty() ? null : partyIdentificationList.get(0).getID().getValue(); // ohne schema
	}

	@Override
	public void addId(String name, String schemeID) {
		if(name==null) return;
		PartyIdentificationType partyIdentification = new PartyIdentificationType();
		partyIdentification.setID(new ID(name, schemeID));
		super.getPartyIdentification().add(partyIdentification);
	}
	@Override
	public void setId(String name, String schemeID) {
		addId(name, schemeID);
	}

	// BG-4.BT-30  0..1 Seller legal registration identifier 
	// BG-7.BT-47  0..1  Buyer legal registration identifier
	// BG-10.BT-61 0..1  Payee legal registration identifier
	@Override
	public String getCompanyId() {
		Identifier id = getCompanyIdentifier();
		return id==null? null : id.getContent();
	}	
	@Override
	public Identifier getCompanyIdentifier() {
		List<PartyLegalEntityType> partyLegalEntityList = getPartyLegalEntity();
		if(partyLegalEntityList.isEmpty()) return null;
		CompanyIDType companyID = partyLegalEntityList.get(0).getCompanyID();
		return companyID==null ? null : new ID(companyID.getValue(), companyID.getSchemeID());
	}

	@Override
	public void setCompanyId(String name, String schemeID) {
		if(name==null) return;
		CompanyIDType companyID = new CompanyIDType();
		companyID.setValue(name);
		companyID.setSchemeID(schemeID);
		partyLegalEntity.setCompanyID(companyID);
		if(super.getPartyLegalEntity().isEmpty()) super.getPartyLegalEntity().add(partyLegalEntity);
	}

	// BG-4.BT-31  0..1 Seller VAT identifier mit schemeID BT-31-0 "VA"/"VAT"
	// BG-4.BT-32  0..1 Seller tax registration identifier mit schemeID BT-32-0 "FC"
	// BG-7.BT-48  0..1  Buyer VAT identifier
	// BG-11.BT-63 1..1 Seller tax representative VAT identifier
	
	// Die Umsatzsteuer-Identifikationsnummer des Verkäufers.
	static final String DEFAULT_TAX_SCHEME = "VAT"; // ein möglicher BUG in UBL Spez!
	static final String NO_CC = "??";
	/*
	 * Buyer/Seller VAT identifier - The VAT identifier (also known as VAT identification number).
	 * <p>
	 * VAT number prefixed by a country code based on EN ISO 3166-1 "Codes for the representation of names of countries and their subdivisions"
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID:      BT-48
	 * <br>Req.ID:  R45, R52, R57
	 * 
	 * @param registrationId Identifier
	 */
	@Override
	public void setVATRegistrationId(String registrationId) {
		if(registrationId==null) return;
		// countryCode of the party (which is mandatory) as default prefix , see https://github.com/klst-de/e-invoice/issues/1
		
		PostalAddress address = getAddress();
		String countryCode = address==null ? NO_CC : address.getCountryCode();
		if(countryCode==NO_CC || registrationId.startsWith(countryCode)) {
			addTaxRegistrationId(registrationId, DEFAULT_TAX_SCHEME);
		} else {
			LOG.warning("registrationId '"+registrationId+"' does not start with countryCode:"+countryCode + " - silently done.");
			addTaxRegistrationId(countryCode+registrationId, DEFAULT_TAX_SCHEME);
		}
	}


	@Override
	public List<Identifier> getTaxRegistrationIdentifier() {
		List<PartyTaxSchemeType> partyTaxSchemeList = getPartyTaxScheme();
		List<Identifier> result = new ArrayList<Identifier>(partyTaxSchemeList.size());
		if(partyTaxSchemeList.isEmpty()) return result;
		partyTaxSchemeList.forEach(partyTaxScheme -> {
			CompanyIDType companyID = partyTaxScheme.getCompanyID();
			TaxSchemeType taxScheme = partyTaxScheme.getTaxScheme();
			IDType taxSchemeID = taxScheme.getID();
			if(companyID!=null) {
				result.add(new ID(companyID.getValue(), taxSchemeID==null?null:taxSchemeID.getValue()));
			}
		});
		return result;
	}

	@Override
	public void setTaxRegistrationId(String name, String schemeID) {
		addTaxRegistrationId(name, schemeID);
	}

	@Override
	public void addTaxRegistrationId(String name, String schemeID) { 
/*
      <cac:PartyTaxScheme>
        <cbc:CompanyID>ATU123456789</cbc:CompanyID>
        <cac:TaxScheme>
          <cbc:ID>VAT</cbc:ID>
        </cac:TaxScheme>
      </cac:PartyTaxScheme>
      <cac:PartyTaxScheme>
        <cbc:CompanyID>123/456/789</cbc:CompanyID>
        <cac:TaxScheme>
          <cbc:ID>FC</cbc:ID>
        </cac:TaxScheme>
      </cac:PartyTaxScheme>
 */
		if(name==null) return;
		CompanyIDType companyID = new CompanyIDType();
		companyID.setValue(name);
		PartyTaxSchemeType partyTaxScheme = new PartyTaxSchemeType();
		partyTaxScheme.setCompanyID(companyID);
		
		TaxSchemeType taxScheme = new TaxSchemeType();
		taxScheme.setID(new ID(schemeID));
		partyTaxScheme.setTaxScheme(taxScheme);
		
		List<PartyTaxSchemeType> list = super.getPartyTaxScheme();
		LOG.fine("setTaxRegistrationId: List<PartyTaxSchemeType>#:"+list.size() + " vor add:"+name+"/"+schemeID);
		list.add(partyTaxScheme);
	}

	// BG-4.BT-33 0..1 Seller additional legal information
	@Override
	public String getCompanyLegalForm() {
		List<PartyLegalEntityType> partyLegalEntityList = getPartyLegalEntity();
		if(partyLegalEntityList.isEmpty()) return null;
		CompanyLegalFormType companyLegalForm = partyLegalEntityList.get(0).getCompanyLegalForm();
		return companyLegalForm==null ? null : companyLegalForm.getValue();
	}

	@Override
	public void setCompanyLegalForm(String name) {
		if(name==null) return;
		CompanyLegalFormType clf = new CompanyLegalFormType();
		clf.setValue(name);
		partyLegalEntity.setCompanyLegalForm(clf);	
		if(super.getPartyLegalEntity().isEmpty()) super.getPartyLegalEntity().add(partyLegalEntity);
	}

	// BG-4.BT-34 Seller electronic address
	// BG-7.BT-49 Buyer electronic address
	@Override
	public Identifier getUriUniversalCommunication() {
		EndpointIDType endpointID = super.getEndpointID();
		return endpointID==null ? null : new ID(endpointID.getValue(), endpointID.getSchemeID());
	}

	@Override
	public void setUriUniversalCommunication(String name, String schemeID) {
		if(name==null) return;
		EndpointIDType endpointID = new EndpointIDType();
		endpointID.setValue(name);
		endpointID.setSchemeID(schemeID);
		super.setEndpointID(endpointID);
	}

}
