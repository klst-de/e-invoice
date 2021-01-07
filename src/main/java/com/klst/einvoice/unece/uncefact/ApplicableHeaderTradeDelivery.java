package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.PostalAddress;
import com.klst.untdid.codelist.DateTimeFormats;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainEventType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;

public class ApplicableHeaderTradeDelivery extends HeaderTradeDeliveryType implements BG13_DeliveryInformation {

	private static final Logger LOG = Logger.getLogger(ApplicableHeaderTradeDelivery.class.getName());
	
	ApplicableHeaderTradeDelivery() {
		super();
	}

	// copy ctor
	public ApplicableHeaderTradeDelivery(HeaderTradeDeliveryType delivery) {
		this();
		Timestamp ts = getActualDate(delivery);
		TradePartyType tradeParty = delivery.getShipToTradeParty();
		party = tradeParty==null ? null : new TradeParty(tradeParty);
		LOG.fine("copy ctor ShipToTradeParty:"+party + " delivery.ActualDate ts:"+ts);
		setActualDate(ts);
		setParty(party);	
	}

	TradeParty party;
	
	public ApplicableHeaderTradeDelivery(String businessName, Timestamp ts, PostalAddress address, String locationId, String schemeId) {
		this();
	}
	
	void init(String businessName, Timestamp ts, PostalAddress address, String locationId, String schemeId) {
		LOG.info("BT-70/businessName:"+businessName + " BT-72/Timestamp:"+ts + " BG-15 ++ 0..1 DELIVER TO ADDRESS:"+address + " BT-71/locationId:"+locationId);
		party = new TradeParty(null, address, null);
		party.setBusinessName(businessName);
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
		return party==null ? null : new TradeParty(party);
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
	public String getBusinessName() {
		if(party==null) return null;
		return party.getPartyName();
	}

	@Override
	public void setBusinessName(String name) {
		party.setBusinessName(name);	
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
	public void setActualDate(String ymd) {
		if(ymd==null) return;
		setActualDate(DateTimeFormats.ymdToTs(ymd));
	}

	@Override
	public void setActualDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = CrossIndustryInvoice.newDateTime(ts);
		SupplyChainEventType supplyChainEvent = new SupplyChainEventType();
		supplyChainEvent.setOccurrenceDateTime(dateTime);
		super.setActualDeliverySupplyChainEvent(supplyChainEvent);
	}

	@Override
	public Timestamp getActualDate() {
		return getActualDate(this);
	}

	static Timestamp getActualDate(HeaderTradeDeliveryType delivery) {
		SupplyChainEventType supplyChainEvent = delivery.getActualDeliverySupplyChainEvent();
		if(supplyChainEvent==null) return null;
		DateTimeType dateTime = supplyChainEvent.getOccurrenceDateTime();
		if(dateTime==null) return null;
		return DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[Deliver to party name=");
		stringBuilder.append(getBusinessName()==null ? "null" : getBusinessName());
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
