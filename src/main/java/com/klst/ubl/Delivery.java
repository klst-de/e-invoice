package com.klst.ubl;

import java.sql.Timestamp;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryDateType;

/* DELIVERY INFORMATION                        BG-13                       0..1
 * 
 * Eine Gruppe von Informationselementen, die Informationen darüber liefern, 
 * wo und wann die in Rechnung gestellten Waren und Dienstleistungen geliefert bzw. erbracht werden.
 * 
 * Deliver to party name                       BT-70                  Text 0..1
 * Deliver to location identifier              BT-71            Identifier 0..1
 * Deliver to location identifier/Scheme identifier                        0..1
 * Actual delivery date                        BT-72                  Date 0..1
 * INVOICING PERIOD                            BG-14                       0..1
 * DELIVER TO ADDRESS                          BG-15                       0..1
 */
public class Delivery extends DeliveryType { // TODO implements IDelivery

	Delivery() {
		super();
	}
	
	// copy ctor
	public Delivery(DeliveryType delivery) {
		this();
		setParty(getParty(delivery));
		setLocationAddress(getLocationAddress(delivery));
		setActualDate(getActualDate(delivery));
	}

	// Party with party name
	public void setParty(Party party) {
		super.setDeliveryParty((PartyType)party);
	}
	
	public Party getParty() {
		return getParty(this);
	}
	
	static Party getParty(DeliveryType delivery) {
		PartyType party = delivery.getDeliveryParty();
		return party==null ? null : new Party(party);
	}

	// location PostalAddress
	public void setLocationAddress(Address address) {
		LocationType location = new LocationType();
		location.setAddress(address);
		super.setDeliveryLocation(location);
	}
	
	public Address getLocationAddress() {
		return getLocationAddress(this);
	}
	
	static Address getLocationAddress(DeliveryType delivery) {
		LocationType location = delivery.getDeliveryLocation();
		if(location==null) return null; 
		
		AddressType address = location.getAddress();
		if(address==null) return null;
		return new Address(address);
	}

	// ActualDeliveryDate
	public void setActualDate(String ymd) {
		if(ymd==null) return;
		setActualDate(Invoice.ymdToTs(ymd));
	}
	
	public void setActualDate(Timestamp ts) {
		if(ts==null) return;
		ActualDeliveryDateType dueDate = new ActualDeliveryDateType();
		dueDate.setValue(Invoice.tsToXMLGregorianCalendar(ts));
		super.setActualDeliveryDate(dueDate);
	}

	public Timestamp getActualDate() {
		return getActualDate(this);
	}
	
	static Timestamp getActualDate(DeliveryType delivery) {
		ActualDeliveryDateType actualDeliveryDate = delivery.getActualDeliveryDate();
		return actualDeliveryDate==null ? null : Invoice.xmlGregorianCalendarToTs(actualDeliveryDate.getValue());
	}

}
