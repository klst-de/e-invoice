package com.klst.ubl;

import java.util.ArrayList;
import java.util.List;

import com.klst.cius.IContact;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;

/*
 * PartyName
 * PostalAddress
 * Contact
 * PartyTaxScheme TODO
 * PartyLegalEntity TODO
 */
public class Party extends PartyType { // TODO implements ???

	Party() {
		super();
	}
	
	// copy ctor
	public Party(PartyType party) {
		this();
		addName(getNames(party));
		setContact(getContact(party));
		setAddress(getPostalAddress(party));
	}
	
	public Party(String name, Address address, Contact contact) {
		this();
		addName(name);
		setAddress(address);
		setContact(contact);
	}

	// PartyName
	public void addName(String name) {
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
		super.setPostalAddress((AddressType)address);
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

}
