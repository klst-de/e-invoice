package com.klst.einvoice.ubl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.IdentifierType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.TextType;

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
		List<Map<Object,String>> mapList = getPartyLegalEntities(party);
		Map<Object,String> map = new HashMap<Object,String>();
		if(mapList.isEmpty()) {
			LOG.warning("PartyLegalEntities mapList is empty");
		} else {
			map = mapList.get(0); // first
		}
		
		this.init(map.get(RegistrationNameType.class)
				, getPostalAddress(party)
				, getContact(party)
				);
		LOG.info("copy ctor Name/BT-27,BT-44,BT-59, ...:"+this.getRegistrationName() + " Address:"+this.getAddress() + " Contact:"+this.getIContact());
		
		// BG-4.BT-28 ++ 0..1 Seller trading name / UBL: <cac:PartyName><cbc:Name>
		// BG-7.BT-45 ++ 0..1 Buyer trading name
		setBusinessName(getBusinessName(party ));
		
		// BG-4.BT-29 ++ 0..n Seller identifier
		// BG-7.BT-46 ++ 0..1 Buyer identifier
		List<PartyIdentificationType> partyIdentificationList = party.getPartyIdentification();
		if(!partyIdentificationList.isEmpty()) {
			setId(partyIdentificationList.get(0).getID().getValue(), partyIdentificationList.get(0).getID().getSchemeID());
		}
		
		// BG-4.BT-30 0..1 Seller legal registration ID 
		// BG-7.BT-47 0..1 Buyer legal registration identifier
		setCompanyId(map.get(CompanyIDType.class), map.get(String.class));

		// 0..n wg. BT-31 Seller VAT identifier, BT-32 Seller tax registration identifier, 
		//          BT-31-0, BT-32-0
		List<Map<Object,String>> taxSchemesList = getTaxSchemes(party);
		addTaxSchemes(taxSchemesList);
		
		// BG-4.BT-33 0..1 additional legal info / not used for Buyer
		setCompanyLegalForm(map.get(CompanyLegalFormType.class));
		
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
		setRegistrationName(name);
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
	public void setTaxRegistrationId(String taxRegistrationId) {
		if(taxRegistrationId==null) return;
		// countryCode of the party (which is mandatory) as default prefix , see https://github.com/klst-de/e-invoice/issues/1
		PostalAddress address = getAddress();
		String countryCode = address==null ? "??" : address.getCountryCode();
		if(taxRegistrationId.startsWith(countryCode)) {
			setTaxRegistrationId(taxRegistrationId, DEFAULT_TAX_SCHEME);
		} else {
			LOG.warning("taxRegistrationId does not start with countryCode:"+taxRegistrationId + " - silently done.");
			setTaxRegistrationId(countryCode+taxRegistrationId, DEFAULT_TAX_SCHEME);
		}
	}
	// wg copy ctor
	void addTaxSchemes(List<Map<Object,String>> partyTaxSchemes)  {
		partyTaxSchemes.forEach(partyTaxScheme -> {
			String taxScheme = partyTaxScheme==null ? null : partyTaxScheme.get(TaxSchemeType.class);
			String companyId = partyTaxScheme==null ? null : partyTaxScheme.get(CompanyIDType.class);
			setTaxRegistrationId(companyId, taxScheme);
		});
	}
	public List<Map<Object,String>> getTaxSchemes() { 
		return getTaxSchemes(this);
	}
	// wg copy ctor
	static List<Map<Object,String>> getTaxSchemes(PartyType party) { 
//		LOG.info("party:"+party);
		List<PartyTaxSchemeType> partyTaxSchemes = party.getPartyTaxScheme();
		List<Map<Object,String>> resultList = new ArrayList<Map<Object,String>>(partyTaxSchemes.size());
//		LOG.info("partyTaxSchemes#:"+partyTaxSchemes.size() + "== resultList#:"+resultList.size());
		partyTaxSchemes.forEach(partyTaxScheme -> {
			Map<Object,String> map = new HashMap<Object,String>();
			TaxSchemeType taxScheme = partyTaxScheme.getTaxScheme();
			IdentifierType taxSchemeID = null;
			if(taxScheme!=null) {
				taxSchemeID = taxScheme.getID();
			}	
			map.put(TaxSchemeType.class, taxSchemeID.getValue());
			IdentifierType companyID = partyTaxScheme.getCompanyID();
			map.put(CompanyIDType.class, companyID.getValue());
			resultList.add(map);
		});
//		LOG.info("resultList#:"+resultList.size());
		return resultList;
	}

	/**
	 * add LegalEntities for seller or buyer party or delivery party
	 * 
	 * @param registrationName mandatory, BT-27/BT-44
	 * @param companyId optional / legal registration identifier, BT-30/BT-45
	 * @param companyLegalForm optional / additional legal information, BT-33/BT-46
	 */
	void addLegalEntities(String registrationName, String companyId, String companyLegalForm)  {
		setRegistrationName(registrationName);
		setCompanyId(companyId);
		setCompanyLegalForm(companyLegalForm);
	}
	
	void addLegalEntities(List<Map<Object,String>> legalEntityList)  {
		legalEntityList.forEach(legalEntity -> {
			String registrationName = legalEntity==null ? null : legalEntity.get(RegistrationNameType.class);
			String companyId = legalEntity==null ? null : legalEntity.get(CompanyIDType.class);
			String companyLegalForm = legalEntity==null ? null : legalEntity.get(CompanyLegalFormType.class);
			addLegalEntities(registrationName, companyId, companyLegalForm);
		});
	}

	String getObject(Object clazz) {
		List<Map<Object,String>> mapList = getPartyLegalEntities(this);
		if(mapList.isEmpty()) {
			LOG.warning("mapList is empty");
			return null;
		} else {
			Map<Object,String> map = mapList.get(0); // first
			return map.get(clazz);
		}
	}
	static List<Map<Object,String>> getPartyLegalEntities(PartyType party) { 
		List<PartyLegalEntityType> partyLegalEntities = party.getPartyLegalEntity();
		List<Map<Object,String>> result = new ArrayList<Map<Object,String>>(partyLegalEntities.size());
		partyLegalEntities.forEach(partyLegalEntity -> {
			Map<Object,String> map = new HashMap<Object,String>();
			RegistrationNameType registrationName = partyLegalEntity.getRegistrationName();
			String name = registrationName==null ? null : registrationName.getValue();
			map.put(RegistrationNameType.class, name);
			
			CompanyIDType companyID = partyLegalEntity.getCompanyID();
			String companyIDvalue = companyID==null ? null : companyID.getValue();
//			Identifier companyIdentifier = companyID==null ? null : new ID(companyID.getValue(), companyID.getSchemeID());
			map.put(CompanyIDType.class, companyIDvalue);
			String companyIDschema = companyID==null ? null : companyID.getSchemeID();
			map.put(String.class, companyIDschema);
			
			TextType companyLegalForm = partyLegalEntity.getCompanyLegalForm();
			String companyLegalFormValue = companyLegalForm==null ? null : companyLegalForm.getValue();
			map.put(CompanyLegalFormType.class, companyLegalFormValue);	
			result.add(map);
		});
		return result;
	}
// ----------------------------------------

	@Override
	public String getRegistrationName() {
		return getObject(RegistrationNameType.class);
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
		List<PartyNameType> partyNameList = super.getPartyName();
		return partyNameList.isEmpty() ? null : partyNameList.get(0).getName().getValue();
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
		List<PartyIdentificationType> partyIdentificationList = super.getPartyIdentification();
		return partyIdentificationList.isEmpty() ? null 
				: new ID(partyIdentificationList.get(0).getID().getValue(), partyIdentificationList.get(0).getID().getSchemeID());
	}

	@Override
	public void setIdentifier(Identifier id) {
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
		return getObject(CompanyIDType.class);
	}

	@Override
	public void setCompanyId(String name) {
		setCompanyId(name, null);
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
	public String getTaxRegistrationId() {
		return getTaxRegistrationId("VA");
	}
	@Override
	public String getTaxRegistrationId(String schemeID) {
		List<Map<Object,String>> mapList = getTaxSchemes();
		if(mapList.size()==0) {
			return null;
		} else if(mapList.size()==1) {
			Map<Object,String> map = mapList.get(0);
			String [] val1 = map.values().toArray(new String[0]);
			LOG.info("mapList.size()==1" + " key#:"+map.keySet().size() + " value.0:"+val1[0]);
			if(map.keySet().size()==1) {
				return val1[0];
			} else {
				LOG.info(map.get(TaxSchemeType.class)+"=="+schemeID + " ? "+map.get(CompanyIDType.class) + " : "+val1[0]);
				return map.get(TaxSchemeType.class).equals(schemeID) ? map.get(CompanyIDType.class) : val1[0];
			}
// so wurde is in map eingetragen:
//			map.put(TaxSchemeType.class, taxSchemeID.getValue());
//			map.put(CompanyIDType.class, companyID.getValue());
		} else {
			LOG.info("TODO    mapList.size()="+mapList.size());
			for(int i=0; i<mapList.size(); i++) {
				Map<Object,String> map = mapList.get(i);
				if(map.get(TaxSchemeType.class).equals(schemeID)) {
					map.get(CompanyIDType.class);  // ????????????????????????????
				}
			}
			Map<Object,String> map = mapList.get(0);
			String [] val1 = map.values().toArray(new String[0]);
			LOG.info("return val1[0]:"+val1[0]);
			return val1[0];
		}
	}

	@Override
	public void setTaxRegistrationId(String name, String schemeID) { 
/*

            <cac:PartyTaxScheme>
                <cbc:CompanyID>DE123456789</cbc:CompanyID>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
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
		LOG.info("List<PartyTaxSchemeType>#:"+list.size() + " vor add:"+name+"/"+schemeID);
		list.add(partyTaxScheme);
		LOG.info("List<PartyTaxSchemeType>#:"+list.size() + " nach add:"+name+"/"+schemeID);
	}

	@Override
	public String getCompanyLegalForm() {
		return getObject(CompanyLegalFormType.class);
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
