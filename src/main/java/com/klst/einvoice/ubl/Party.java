package com.klst.einvoice.ubl;

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
public class Party extends PartyType implements BG4_Seller, BG7_Buyer, BG10_Payee, BG11_SellerTaxRepresentativeParty {

	private static final Logger LOG = Logger.getLogger(Party.class.getName());
	
	// wg. PostalAddressFactory, IContactFactory
	Party() {
		super();
	}
	
	// copy ctor
	Party(PartyType party) {
		this();
		LOG.fine("copy ctor (optional)trading name:"+getBusinessName(party) + " Address:"+getPostalAddress(party) + " Contact:"+getContact(party));
		this.init(getBusinessName(party), getPostalAddress(party), getContact(party));
		// BG-4.BT-27  1..1 Seller name
		// BG-7.BT-44  1..1  Buyer name
		// BG-10.BT-59 1..1  Payee name
		setRegistrationName(getRegistrationName(party));
		LOG.config("copy ctor Name:"+getRegistrationName() +" trading name:"+getBusinessName() + " Address:"+this.getAddress() + " Contact:"+this.getIContact());
				
		// BG-4.BT-28 ++ 0..1 Seller trading name
		// BG-7.BT-45 ++ 0..1 Buyer trading name
//		setBusinessName(getBusinessName(party));
		
		// BG-4.BT-29 ++ 0..n Seller identifier
		// BG-7.BT-46 ++ 0..1 Buyer identifier
		setIdentifier(getIdentifier(party));
		
		// BG-4.BT-30 0..1 Seller legal registration ID 
		// BG-7.BT-47 0..1 Buyer legal registration identifier
		setCompanyIdentifier(getCompanyIdentifier(party));

		// 0..n wg. BT-31 Seller VAT identifier, BT-32 Seller tax registration identifier, 
		//          BT-31-0, BT-32-0
		List<Identifier> taxIdList = getTaxRegistrationIdentifier(party);
		taxIdList.forEach(id -> {
			addTaxRegistrationIdentifier(id);
		});
		
		// BG-4.BT-33 0..1 additional legal info / not used for Buyer
		setCompanyLegalForm(getCompanyLegalForm(party));
		
		// BG-4.BT-34 ++ 0..1 Seller electronic address
		// BG-7.BT-49 ++ 0..1 Buyer electronic address
		EndpointIDType endpointID = party.getEndpointID();
		if(endpointID!=null) {
			setUriUniversalCommunication(endpointID.getValue(), endpointID.getSchemeID());
		}
	}
	
	PartyLegalEntityType partyLegalEntity;
	
	/**
	 * ctor for BusinessParty - use BusinessPartyFactory method
	 * 
	 * @param name             BT-27 1..1 Name des Verkäufers   / BT-44 1..1 Name des Käufers
	 * @param address          BG-5  1..1 SELLER POSTAL ADDRESS / BG-8  1..1 BUYER POSTAL ADDRESS
	 * @param contact          BG-6  0..1 SELLER CONTACT        / BG-9  0..1 BUYER CONTACT
	 * 
	 * @see BusinessPartyFactory
	 */
	Party(String name, PostalAddress address, IContact contact) {
		this();
		init(name, address, contact);
	}
	
	void init(String name, PostalAddress address, IContact contact) {
		partyLegalEntity = new PartyLegalEntityType();
		this.setBusinessName(name);
		setAddress(address);
		setIContact(contact);
	}
	
	// PostalAddress
	@Override
	public PostalAddress getAddress() {
		return getPostalAddress(this);
	}

	@Override
	public void setAddress(PostalAddress address) {
		this.setAddress((AddressType)address);
	}
	void setAddress(AddressType address) {
		if(address==null) return; // defensiv
		super.setPostalAddress(address);
	}
	
	static PostalAddress getPostalAddress(PartyType party) {
		AddressType address = party.getPostalAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return new Address(address);
	}

	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return new Address(countryCode, postalCode, city, null);
	}

	@Override
	public PostalAddress createAddress(PostalAddress address) {
		return new Address((AddressType)address);
	}


	// Contact
	@Override
	public IContact getIContact() {
		return getContact(this);
	}
	static IContact getContact(PartyType party) {
		ContactType contact = party.getContact();
		return contact==null ? null : new Contact(contact);
	}

	@Override
	public void setIContact(IContact contact) {
		super.setContact((ContactType)contact);	
	}

	@Override
	public IContact createContact(String contactName, String contactTel, String contactMail) {
		return new Contact(contactName, contactTel, contactMail);
	}

	@Override
	public IContact createContact(IContact contact) {
		return new Contact((ContactType) contact);
	}

	// Die Umsatzsteuer-Identifikationsnummer des Verkäufers.
	public static final String DEFAULT_TAX_SCHEME = "VAT";
	
	/**
	 * Buyer/Seller VAT identifier - The VAT identifier (also known as VAT identification number).
	 * <p>
	 * VAT number prefixed by a country code based on EN ISO 3166-1 "Codes for the representation of names of countries and their subdivisions"
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID:      BT-48
	 * <br>Req.ID:  R45, R52, R57
	 * 
	 * @param taxRegistrationId Identifier
	 */
	public void setTaxRegistrationId(String taxRegistrationId) { // TODO ==> setVATidentifier
		if(taxRegistrationId==null) return;
		// countryCode of the party (which is mandatory) as default prefix , see https://github.com/klst-de/e-invoice/issues/1
		PostalAddress address = getAddress();
		String countryCode = address==null ? "??" : address.getCountryCode();
		if(taxRegistrationId.startsWith(countryCode)) {
			addTaxRegistrationId(taxRegistrationId, DEFAULT_TAX_SCHEME);
		} else {
			LOG.warning("taxRegistrationId does not start with countryCode:"+taxRegistrationId + " - silently done.");
			addTaxRegistrationId(countryCode+taxRegistrationId, DEFAULT_TAX_SCHEME);
		}
	}

	@Override
	public String getRegistrationName() {
		return getRegistrationName(this);
	}
	static String getRegistrationName(PartyType party) {
		List<PartyLegalEntityType> partyLegalEntityList = party.getPartyLegalEntity();
		if(partyLegalEntityList.isEmpty()) return null;
		RegistrationNameType registrationName = partyLegalEntityList.get(0).getRegistrationName();
		return registrationName==null ? null : registrationName.getValue();
	}

	@Override
	public void setRegistrationName(String name) {
		if(name==null) return;
		RegistrationNameType registrationName = new RegistrationNameType();
		registrationName.setValue(name);
		partyLegalEntity.setRegistrationName(registrationName);
		if(super.getPartyLegalEntity().isEmpty()) super.getPartyLegalEntity().add(partyLegalEntity);
	}

	@Override
	public String getBusinessName() {
		return getBusinessName(this);
	}
	static String getBusinessName(PartyType party) {
		List<PartyNameType> partyNameList = party.getPartyName();
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

	@Override
	public String getId() {
		List<PartyIdentificationType> partyIdentificationList = super.getPartyIdentification();
		return partyIdentificationList.isEmpty() ? null : partyIdentificationList.get(0).getID().getValue(); // ohne schema
	}
	@Override
	public Identifier getIdentifier() {
		return getIdentifier(this);
	}
	static Identifier getIdentifier(PartyType party) {
		List<PartyIdentificationType> partyIdentificationList = party.getPartyIdentification();
		return partyIdentificationList.isEmpty() ? null 
				: new ID(partyIdentificationList.get(0).getID().getValue(), partyIdentificationList.get(0).getID().getSchemeID());
	}

	@Override
	public void setIdentifier(Identifier id) {
		if(id==null) return;
		setId(id.getContent(), id.getSchemeIdentifier());
	}
	
	@Override
	public void setId(String name) {
		setId(name, null);
	}

	@Override
	public void setId(String name, String schemeID) {
		if(name==null) return;
		PartyIdentificationType partyIdentification = new PartyIdentificationType();
		partyIdentification.setID(new ID(name, schemeID));
		super.getPartyIdentification().add(partyIdentification);
	}

	@Override
	public String getCompanyId() {
		Identifier id = getCompanyIdentifier();
		return id==null? null : id.getContent();
	}
	
	@Override
	public Identifier getCompanyIdentifier() {
		return getCompanyIdentifier(this);
	}
	static Identifier getCompanyIdentifier(PartyType party) {
		List<PartyLegalEntityType> partyLegalEntityList = party.getPartyLegalEntity();
		if(partyLegalEntityList.isEmpty()) return null;
		CompanyIDType companyID = partyLegalEntityList.get(0).getCompanyID();
		return companyID==null ? null : new ID(companyID.getValue(), companyID.getSchemeID());
	}

	@Override
	public void setCompanyId(String name) {
		setCompanyId(name, null);
	}

	@Override
	public void setCompanyIdentifier(Identifier id) {
		if(id==null) return;
		setCompanyId(id.getContent(), id.getSchemeIdentifier());
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

	@Override
	public List<Identifier> getTaxRegistrationIdentifier() {
		return getTaxRegistrationIdentifier(this);
	}
	static List<Identifier> getTaxRegistrationIdentifier(PartyType party) {
		List<PartyTaxSchemeType> partyTaxSchemeList = party.getPartyTaxScheme();
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
	public void addTaxRegistrationIdentifier(Identifier id) {
		if(id==null) return;
		addTaxRegistrationId(id.getContent(), id.getSchemeIdentifier());
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

	@Override
	public String getCompanyLegalForm() {
		return getCompanyLegalForm(this);
	}
	static String getCompanyLegalForm(PartyType party) {
		List<PartyLegalEntityType> partyLegalEntityList = party.getPartyLegalEntity();
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

	@Override
	public Identifier getUriUniversalCommunication() {
		EndpointIDType endpointID = super.getEndpointID();
		return endpointID==null ? null : new ID(endpointID.getValue(), endpointID.getSchemeID());
	}

	@Override
	public void setUriUniversalCommunication(Identifier id) {
		if(id==null) return;
		setUriUniversalCommunication(id.getContent(), id.getSchemeIdentifier());
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
