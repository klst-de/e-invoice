package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.untdid.codelist.DateTimeFormats;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainEventType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
// TODO rename to HeaderTradeDelivery
public class ApplicableHeaderTradeDelivery extends HeaderTradeDeliveryType implements BG13_DeliveryInformation {

	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return TradeAddress.create(countryCode, postalCode, city);
	}
	
	// factory
	static ApplicableHeaderTradeDelivery create(String name, Timestamp ts, PostalAddress address, String locationId, String schemeId) {
		return new ApplicableHeaderTradeDelivery(name, ts, address, locationId, schemeId);
	}

	static ApplicableHeaderTradeDelivery create() {
		return new ApplicableHeaderTradeDelivery(null);
	}
	// copy factory
	static ApplicableHeaderTradeDelivery create(HeaderTradeDeliveryType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof HeaderTradeDeliveryType && object.getClass()!=HeaderTradeDeliveryType.class) {
			// object is instance of a subclass of HeaderTradeDeliveryType, but not HeaderTradeDeliveryType itself
			return (ApplicableHeaderTradeDelivery)object;
		} else {
			return new ApplicableHeaderTradeDelivery(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(ApplicableHeaderTradeDelivery.class.getName());
	
	// copy ctor
	private ApplicableHeaderTradeDelivery(HeaderTradeDeliveryType delivery) {
		super();
		if(delivery!=null) {
			CopyCtor.invokeCopy(this, delivery);
			LOG.info("copy ctor:"+this);
		}
		TradePartyType tradeParty = super.getShipToTradeParty();
		party = tradeParty==null ? null : TradeParty.create(tradeParty);
		LOG.fine("copy ctor ShipToTradeParty:"+party + " delivery.ActualDate ts:"+getActualDate());
		setParty(party);	
	}

	private TradeParty party;
	
	private ApplicableHeaderTradeDelivery(String businessName, Timestamp ts, PostalAddress address, String locationId, String schemeId) {
		LOG.info("BT-70/businessName:"+businessName + " BT-72/Timestamp:"+ts + " BG-15 ++ 0..1 DELIVER TO ADDRESS:"+address + " BT-71/locationId:"+locationId);
		party = TradeParty.create(null, businessName, address, null);
		party.setId(locationId);
		if(schemeId!=null) party.getGlobalID().add(new ID(schemeId));
		setParty(party);		
		setActualDate(ts);
	}

	// Party with businessName
	void setParty(BusinessParty party) {
		if(party==null) return;
		super.setShipToTradeParty((TradePartyType)party);
	}
	
	TradeParty getParty() {
		return party;
	}
	
	static TradeParty getParty(HeaderTradeDeliveryType delivery) {
		TradePartyType party = delivery.getShipToTradeParty();
		return party==null ? null : TradeParty.create(party);
	}

	@Override
	public PostalAddress getAddress() {
		if(party==null) return null;
		return party.getAddress();
	}

	@Override
	public void setAddress(PostalAddress name) {
		party.setAddress(name);
	}

	@Override
	public String getName() {
		if(party==null) return null;
		return party.getRegistrationName();
	}

	@Override
	public void setName(String name) {
		party.setRegistrationName(name);	
	}

	@Override
	public String getId() {
		if(party==null) return null;
		return party.getId();
	}

	@Override
	public void setId(String name) {
		party.setId(name);	
	}

	@Override
	public void setId(String name, String schemeID) {
		party.setId(name, schemeID);		
	}

	@Override
	public void setActualDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		SupplyChainEventType supplyChainEvent = new SupplyChainEventType();
		supplyChainEvent.setOccurrenceDateTime(dateTime);
		super.setActualDeliverySupplyChainEvent(supplyChainEvent);
	}

	@Override
	public Timestamp getActualDate() {
		SupplyChainEventType supplyChainEvent = super.getActualDeliverySupplyChainEvent();
		if(supplyChainEvent==null) return null;
		DateTimeType dateTime = supplyChainEvent.getOccurrenceDateTime();
		if(dateTime==null) return null;
		return DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[Deliver to party name=");
		stringBuilder.append(getName()==null ? "null" : getName());
		stringBuilder.append(", Location identifier=");
		stringBuilder.append(getId()==null ? "null" : getId());
		stringBuilder.append(", Actual delivery date=");
		stringBuilder.append(getActualDate()==null ? "null" : getActualDate());
		stringBuilder.append(", Address=");
		stringBuilder.append(getAddress()==null ? "null" : getAddress());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
