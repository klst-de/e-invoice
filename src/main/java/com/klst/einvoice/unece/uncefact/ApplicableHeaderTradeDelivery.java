package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BG_Party;
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
		LOG.info("party:"+party + " ts:"+ts);
		setActualDate(ts);
		setParty(party);	
	}

	BG_Party party;
	
	public ApplicableHeaderTradeDelivery(String businessName, Timestamp ts, PostalAddress address, String locationId) {
		this();
	}
	
	void init(String businessName, Timestamp ts, PostalAddress address, String locationId) {
		LOG.info("BT-70/businessName:"+businessName + " BT-72/Timestamp:"+ts + " BG-15 ++ 0..1 DELIVER TO ADDRESS:"+address + " BT-71/locationId:"+locationId);
		party = new TradeParty(null, address, null, null, null);
		party.setBusinessName(businessName);
		party.setId(locationId);
		setParty(party);		
		setActualDate(ts);
//		setAddress(address);
//		setId(locationId);
	}

	// Party with businessName
	public void setParty(BG_Party party) {
		if(party==null) return;
		super.setShipToTradeParty((TradePartyType)party);
	}
	
	public BG_Party getParty() {
		return party;
	}
	
	static BG_Party getParty(HeaderTradeDeliveryType delivery) {
		TradePartyType party = delivery.getShipToTradeParty();
		return party==null ? null : new TradeParty(party);
	}

	@Override
	public PostalAddress getAddress() {
		return party.getAddress();
	}

	@Override
	public void setAddress(PostalAddress name) {
		party.setAddress(name);
	}

	@Override
	public String getRegistrationName() {
		return party.getRegistrationName();
	}

	@Override
	public void setRegistrationName(String name) {
		party.setRegistrationName(name);	
	}

	@Override
	public String getBusinessName() {
		return party.getBusinessName();
	}

	@Override
	public void setBusinessName(String name) {
		party.setBusinessName(name);	
	}

	@Override
	public String getId() {
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
	public String getCompanyId() {
		return party.getCompanyId();
	}

	@Override
	public void setCompanyId(String name) {
		party.setCompanyId(name);	
	}

	@Override
	public void setCompanyId(String name, String schemeID) {
		party.setCompanyId(name, schemeID);		
	}

	@Override
	public String getTaxRegistrationId() {
		return party.getTaxRegistrationId();
	}

	@Override
	public String getTaxRegistrationId(String schemeID) {
		return party.getTaxRegistrationId(schemeID);
	}

	@Override
	public void setTaxRegistrationId(String name, String schemeID) {
		party.setTaxRegistrationId(name, schemeID);		
	}

	@Override
	public String getCompanyLegalForm() {
		return party.getCompanyLegalForm();
	}

	@Override
	public void setCompanyLegalForm(String name) {
		party.setCompanyLegalForm(name);	
	}

	@Override
	public String getUriUniversalCommunication() {
		return party.getUriUniversalCommunication();
	}

	@Override
	public void setUriUniversalCommunication(String name, String schemeID) {
		party.setUriUniversalCommunication(name, schemeID);			
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

	public String asString() {
		return getBusinessName()==null ? "null" : getBusinessName();
	}
}
