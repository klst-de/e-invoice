package com.klst.ubl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.klst.cius.IContact;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyTaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLegalFormType;
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
public class Party extends PartyType { // TODO implements ???

	private static final Logger LOG = Logger.getLogger(Party.class.getName());
	
	Party() {
		super();
	}
	
	// copy ctor
	public Party(PartyType party) {
		this();
		addName(getNames(party));
		setContact(getContact(party));
		setAddress(getPostalAddress(party));
		addTaxSchemes(getTaxSchemes(party));
		addLegalEntities(getPartyLegalEntities(party));
	}
	
	public Party(String name, Address address, Contact contact) {
		this();
		addName(name);
		setAddress(address);
		setContact(contact);
	}

	// PartyName
	public void addName(String name) {
		LOG.info("nmae:"+name);
		if(name==null) return;
		NameType n = new NameType();
		n.setValue(name);
		PartyNameType partyName = new PartyNameType();
		partyName.setName(n);
		super.getPartyName().add(partyName);
	}
	
	void addName(List<String> names) {
		names.forEach(name -> {
			addName(name);
		});
	}

	public List<String> getNames() {
		return getNames(this);
	}
	
	static List<String> getNames(PartyType party) {
		List<PartyNameType> partyNames = party.getPartyName();
		List<String> result = new ArrayList<String>(partyNames.size());
		partyNames.forEach(partyName -> {
			result.add(partyName.getName().getValue());
		});
		return result;
	}
	
	// PostalAddress
	public void setAddress(Address address) {
		this.setPostalAddress((AddressType)address);
	}
	void setAddress(AddressType address) {
		super.setPostalAddress(address);
	}
	
	public Address getAddress() {
		return getPostalAddress(this);
	}
	
	static Address getPostalAddress(PartyType party) {
		AddressType address = party.getPostalAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return new Address(address);
	}

	// Contact
	public void setContact(Contact contact) {
		super.setContact((ContactType)contact);
	}
	
	public IContact getIContact() {
		return getContact(this);
	}
	
	static Contact getContact(PartyType party) {
		ContactType contact = party.getContact();
		return contact==null ? null : new Contact(contact);
	}

	// PartyTaxScheme
	// wg. [BR-DE-16] In der Rechnung muss mindestens eines der Elemente "Seller VAT identifier" (BT-31), 
	//                "Seller tax registration identifier" (BT-32) 
	//                oder "SELLER TAX REPRESENTATIVE PARTY" (BG-11) übermittelt werden. 
	// Die Umsatzsteuer-Identifikationsnummer des Verkäufers.
	public void addPartyTaxScheme(String companyId)  {
		if(companyId==null) return;
		List<PartyTaxSchemeType> partyTaxSchemeList = super.getPartyTaxScheme();
		PartyTaxSchemeType partyTaxScheme = new PartyTaxSchemeType();
		CompanyIDType companyID = new CompanyIDType();
		companyID.setValue(companyId);
		partyTaxScheme.setCompanyID(companyID);
		
		// use countryCode of the party (which is mandatory) as default see https://github.com/klst-de/e-invoice/issues/1
		Address address = getAddress();
		String countryCode = address==null ? null : address.getCountryCode();
		TaxSchemeType taxScheme = VatCategory.getVatScheme(countryCode);
		
		partyTaxScheme.setTaxScheme(taxScheme);
		partyTaxSchemeList.add(partyTaxScheme);	
	}
	// wg copy ctor
	void addTaxSchemes(List<Map<Object,String>> partyTaxSchemes)  {
		partyTaxSchemes.forEach(partyTaxScheme -> {
//			String taxScheme = partyTaxScheme==null ? null : partyTaxScheme.get(TaxSchemeType.class); // wird immer weggeworfen???????
			String companyId = partyTaxScheme==null ? null : partyTaxScheme.get(CompanyIDType.class);
			addPartyTaxScheme(companyId);
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

	// PartyLegalEntity
	/**
	 * add LegalEntities for seller or buyer party
	 * 
	 * @param registrationName mandatory
	 * @param companyId optional / legal registration identifier, BT-30
	 * @param companyLegalForm optional / additional legal information, BT-33
	 */
	public void addLegalEntities(String name, String companyId, String companyLegalForm)  {
		List<PartyLegalEntityType> partyLegalEntities = super.getPartyLegalEntity();
		PartyLegalEntityType partyLegalEntity = new PartyLegalEntityType();
		RegistrationNameType registrationName = new RegistrationNameType();
		registrationName.setValue(name);
		partyLegalEntity.setRegistrationName(registrationName);
		if(companyId!=null) {
			CompanyIDType companyID = new CompanyIDType();
			companyID.setValue(companyId);
			partyLegalEntity.setCompanyID(companyID);
		}
		if(companyLegalForm!=null) {
			CompanyLegalFormType clf = new CompanyLegalFormType();
			clf.setValue(companyLegalForm);
			partyLegalEntity.setCompanyLegalForm(clf);
		}
		partyLegalEntities.add(partyLegalEntity);
	}
	
	void addLegalEntities(List<Map<Object,String>> legalEntityList)  {
		legalEntityList.forEach(legalEntity -> {
			String registrationName = legalEntity==null ? null : legalEntity.get(RegistrationNameType.class);
			String companyId = legalEntity==null ? null : legalEntity.get(CompanyIDType.class);
			String companyLegalForm = legalEntity==null ? null : legalEntity.get(CompanyLegalFormType.class);
			addLegalEntities(registrationName, companyId, companyLegalForm);
		});
	}

	public List<Map<Object,String>> getPartyLegalEntities() { 
		return getPartyLegalEntities(this);
	}
	static List<Map<Object,String>> getPartyLegalEntities(PartyType party) { 
		List<PartyLegalEntityType> partyLegalEntities = party.getPartyLegalEntity();
		List<Map<Object,String>> result = new ArrayList<Map<Object,String>>(partyLegalEntities.size());
		partyLegalEntities.forEach(partyLegalEntity -> {
			Map<Object,String> map = new HashMap<Object,String>();
			RegistrationNameType registrationName = partyLegalEntity.getRegistrationName();
			String name = registrationName==null ? null : registrationName.getValue();
			map.put(RegistrationNameType.class, name);
			IdentifierType companyID = partyLegalEntity.getCompanyID();
			String companyIDvalue = companyID==null ? null : companyID.getValue();
			map.put(CompanyIDType.class, companyIDvalue);			
			TextType companyLegalForm = partyLegalEntity.getCompanyLegalForm();
			String companyLegalFormValue = companyLegalForm==null ? null : companyLegalForm.getValue();
			map.put(CompanyLegalFormType.class, companyLegalFormValue);	
			result.add(map);
		});
		return result;
	}

}
