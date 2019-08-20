package com.klst.einvoice.ubl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.IContact;
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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WebsiteURIType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.IdentifierType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.TextType;

/*
 * PartyName
 * PostalAddress
 * Contact
 * PartyTaxScheme
 * PartyLegalEntity
 */
public class Party extends PartyType implements BG4_Seller, BG7_Buyer {

	private static final Logger LOG = Logger.getLogger(Party.class.getName());
	
	Party() {
		super();
	}
	
	// copy ctor
	public Party(PartyType party) {
		this();

		List<PartyNameType> partyNameList = party.getPartyName();
		partyNameList.forEach(partyName -> {
			this.getPartyName().add(partyName);
		});
		
		setContact(getContact(party));
		setAddress(getPostalAddress(party));
		addTaxSchemes(getTaxSchemes(party));
		partyLegalEntity = new PartyLegalEntityType();
		addLegalEntities(getPartyLegalEntities(party));
	}
	
	PartyLegalEntityType partyLegalEntity;
	
	/**
	 * 
	 * @param name             BT-27 1..1 Name des Verkäufers   / BT-44 1..1 Name des Käufers
	 * @param address          BG-5  1..1 SELLER POSTAL ADDRESS / BG-8  1..1 BUYER POSTAL ADDRESS
	 * @param contact          BG-6  0..1 SELLER CONTACT        / BG-9  0..1 BUYER CONTACT
	 * @param companyId        BT-30 0..1 legal registration ID / BT-47 0..1 Buyer legal registration identifier
	 * @param companyLegalForm BT-33 0..1 additional legal info / not used for Buyer
//	 * @param shipToTradeName  BT-70 0..1 ShipToTradeParty.Name Name des Waren- oder Dienstleistungsempfängers
	 */
	public Party(String name, PostalAddress address, Contact contact, String companyId, String companyLegalForm) {
		this();
//		addName(name);
		setAddress(address);
		setContact(contact);
		partyLegalEntity = new PartyLegalEntityType();
		addLegalEntities(name, companyId, companyLegalForm);
	}

	// BT-70 PartyName/shipToTradeName
//	public void addName(String shipToTradeName) { // ==> setTradingBusinessName
//		if(shipToTradeName==null) return;
//		LOG.info("name/shipToTradeName:"+shipToTradeName);
//		NameType name = new NameType();
//		name.setValue(shipToTradeName);
//		PartyNameType partyName = new PartyNameType();
//		partyName.setName(name);
//		super.getPartyName().add(partyName);
//	}
//	
//	void addName(List<String> names) {
//		names.forEach(name -> {
//			addName(name);
//		});
//	}
//
//	public List<String> getNames() {
//		return getNames(this);
//	}
//	
//	static List<String> getNames(PartyType party) {
//		List<PartyNameType> partyNames = party.getPartyName();
//		List<String> result = new ArrayList<String>(partyNames.size());
//		partyNames.forEach(partyName -> {
//			result.add(partyName.getName().getValue());
//		});
//		return result;
//	}
	
	// PostalAddress
	@Override
	public PostalAddress getAddress() {
		return getPostalAddress(this);
	}

	@Override
	public void setAddress(PostalAddress address) {
		this.setPostalAddress((AddressType)address);
	}

	void setAddress(AddressType address) {
		super.setPostalAddress(address);
	}
	
	static PostalAddress getPostalAddress(PartyType party) {
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
	public void addPartyTaxID(String companyId)  {
		// use countryCode of the party (which is mandatory) as default see https://github.com/klst-de/e-invoice/issues/1
		PostalAddress address = getAddress();
		String countryCode = address==null ? null : address.getCountryCode();
		setTaxRegistrationId(companyId, countryCode);
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
		super.getPartyLegalEntity().add(partyLegalEntity);
	}
	
	void addLegalEntities(List<Map<Object,String>> legalEntityList)  {
		legalEntityList.forEach(legalEntity -> {
			String registrationName = legalEntity==null ? null : legalEntity.get(RegistrationNameType.class);
			String companyId = legalEntity==null ? null : legalEntity.get(CompanyIDType.class);
			String companyLegalForm = legalEntity==null ? null : legalEntity.get(CompanyLegalFormType.class);
			addLegalEntities(registrationName, companyId, companyLegalForm);
		});
	}

//	String getName() {
//		return getObject(RegistrationNameType.class);
//	}
//	public String getCompanyID() {
//		return getObject(CompanyIDType.class);
//	}
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
	}

	@Override
	public String getTradingBusinessName() {
		List<PartyNameType> partyNameList = super.getPartyName();
		return partyNameList.isEmpty() ? null : partyNameList.get(0).getName().getValue();
	}

	@Override
	public void setTradingBusinessName(String businessName) {
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
	public void setId(String name) {
		setId(name, null);
	}

	@Override
	public void setId(String name, String schemeID) {
		if(name==null) return;
		PartyIdentificationType partyIdentification = new PartyIdentificationType();
		partyIdentification.setID(Invoice.newIDType(name, schemeID));
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
			if(map.keySet().size()==1) {
				return val1[0];
			} else {
				return map.get(schemeID)==null ? val1[0] : map.get(schemeID);
			}
		} else {
			for(int i=0; i<mapList.size(); i++) {
				Map<Object,String> map = mapList.get(i);
				if(map.get(schemeID)!=null) {
					return map.get(schemeID);
				}
			}
			Map<Object,String> map = mapList.get(0);
			String [] val1 = map.values().toArray(new String[0]);
			return val1[0];
		}
	}

	@Override
	public void setTaxRegistrationId(String name, String schemeID) { 
		if(name==null) return;
		CompanyIDType companyID = new CompanyIDType();
		companyID.setValue(name);
		PartyTaxSchemeType partyTaxScheme = new PartyTaxSchemeType();
		partyTaxScheme.setCompanyID(companyID);
		
		TaxSchemeType taxScheme = new TaxSchemeType();
		taxScheme.setID(Invoice.newIDType(schemeID, null));
		partyTaxScheme.setTaxScheme(taxScheme);
		
		super.getPartyTaxScheme().add(partyTaxScheme);
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
	}

	@Override
	public String getUriUniversalCommunication() {
		WebsiteURIType websiteURI = super.getWebsiteURI();
		return websiteURI==null ? null : websiteURI.getValue(); // ohne schema
	}

	@Override
	public void setUriUniversalCommunication(String name, String schemeID) {
		if(name==null) return;
		WebsiteURIType websiteURI = new WebsiteURIType();
		websiteURI.setValue(name);
		websiteURI.setSchemeID(schemeID);
		super.setWebsiteURI(websiteURI);
	}

}
