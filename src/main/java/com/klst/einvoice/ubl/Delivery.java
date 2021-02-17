package com.klst.einvoice.ubl;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.untdid.codelist.DateTimeFormats;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;

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
public class Delivery extends DeliveryType implements BG13_DeliveryInformation {

	static Delivery create() {
		return create((DeliveryType)null);
	}
	// copy factory
	static Delivery create(DeliveryType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof DeliveryType && object.getClass()!=DeliveryType.class) {
			// object is instance of a subclass of DeliveryType, but not DeliveryType itself
			return (Delivery)object;
		} else {
			return new Delivery(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(Delivery.class.getName());
	
	// copy ctor
	private Delivery(DeliveryType delivery) {
		super();
		if(delivery!=null) {
			CopyCtor.invokeCopy(this, delivery);
			LOG.config("copy ctor:"+this);
		}
	}

	// BT-70 ++ 0..1 Deliver to party name
	// BT-71 ++ 0..1 Deliver to location + 0..1 Scheme identifier
	// BT-72 ++ 0..1 Actual delivery date
	// BG-15 ++ 0..1 DELIVER TO ADDRESS
	public Delivery(String name, Timestamp ts, PostalAddress address, String locationId) {
		super();
		init(name, ts, address, locationId);
	}

	void init(String name, Timestamp ts, PostalAddress address, String locationId) {
		LOG.fine("init: BT-70/name:"+name + " BT-72/Timestamp:"+ts + " BG-15 ++ 0..1 DELIVER TO ADDRESS:"+address + " BT-71/locationId:"+locationId);
		Party party = new Party(null, name, null, null);
		setParty(party);		
		setActualDate(ts);
		setAddress(address);
		setId(locationId);
	}
	
	// Party with businessName
	void setParty(Party party) {
		super.setDeliveryParty((PartyType)party);
	}
	
	Party getParty() {
		PartyType party = getDeliveryParty();
		return party==null ? null : Party.create(party);
	}
	
	@Override
	public PostalAddress getAddress() {
		LocationType location = super.getDeliveryLocation();
		if(location==null) return null; 
		
		AddressType address = location.getAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return Address.create(address);
	}

	@Override
	public void setAddress(PostalAddress address) {
		LocationType location = super.getDeliveryLocation();
		if(location==null) location = new LocationType();
		location.setAddress((AddressType)address);
		super.setDeliveryLocation(location);
	}
	
	@Override
	public String getName() {
		return getParty().getBusinessName();
	}

	@Override
	public void setName(String name) {
		getParty().setBusinessName(name);
	}

	@Override
	public String getId() {
		LocationType location = super.getDeliveryLocation();
		if(location==null) return null;
		return location.getID()==null ? null : location.getID().getValue();
	}

	@Override
	public void setId(String name) {
		setId(new ID(name));
	}
	
	@Override
	public void setId(String name, String schemeID) {
		setId(new ID(name, schemeID));
	}
	
	void setId(IDType iD) {
		if(iD==null) return;
		LocationType location = super.getDeliveryLocation();
		if(location==null) location = new LocationType();
		location.setID(iD);
		super.setDeliveryLocation(location);
	}

	@Override
	public void setActualDate(Timestamp ts) {
		if(ts==null) return;
		ActualDeliveryDateType dueDate = new ActualDeliveryDateType();
		dueDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		super.setActualDeliveryDate(dueDate);
	}

	@Override
	public Timestamp getActualDate() {
		ActualDeliveryDateType actualDeliveryDate = super.getActualDeliveryDate();
		return actualDeliveryDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(actualDeliveryDate.getValue());
	}
	
}
