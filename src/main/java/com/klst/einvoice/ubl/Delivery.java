package com.klst.einvoice.ubl;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.PostalAddress;
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

1 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall
0 .. 1 ShipToTradeParty Lieferinfomationen                        BG-13 xs:sequence 
0 .. 1 ID Kennung des Lieferorts                                  BT-71 
0 .. n GlobalID Globaler Identifier der Kennung für den Lieferort BT-71-0 
       required schemeID Kennung des Schemas                      BT-71-1 
0 .. 1 Name Name des Waren- oder Dienstleistungsempfängers        BT-70
 */
public class Delivery extends DeliveryType implements BG13_DeliveryInformation {

	private static final Logger LOG = Logger.getLogger(Delivery.class.getName());
	
	Delivery() {
		super();
	}
	
	// copy ctor
	public Delivery(DeliveryType delivery) {
		this();
		PartyType party = delivery.getDeliveryParty();
		Party deliveryParty = party==null ? null : new Party(party);
		String businessName = deliveryParty==null ? null : deliveryParty.getBusinessName();
//		LOG.info("businessName:"+businessName);
		
		init( businessName
			, getActualDate(delivery)
			, getPostalAddress(delivery)
			, null
			);
		
		LocationType location = delivery.getDeliveryLocation();
		IDType iD = location==null ? null : location.getID();
		setId(iD);
	}

/*

    <cac:Delivery>
        <cbc:ActualDeliveryDate>2018-04-13+01:00</cbc:ActualDeliveryDate>
        <cac:DeliveryLocation>
            <cbc:ID>68</cbc:ID>
            <cac:Address>
                <cbc:StreetName>[Deliver to street]</cbc:StreetName>
                <cbc:AdditionalStreetName>4. OG</cbc:AdditionalStreetName>
                <cbc:CityName>[Deliver to city]</cbc:CityName>
                <cbc:PostalZone>98765</cbc:PostalZone>
                <cbc:CountrySubentity>Bayern</cbc:CountrySubentity>
                <cac:Country>
                    <cbc:IdentificationCode>DE</cbc:IdentificationCode>
                </cac:Country>
            </cac:Address>
        </cac:DeliveryLocation>
        <cac:DeliveryParty>
            <cac:PartyName>
                <cbc:Name>[Deliver to party name]</cbc:Name>
            </cac:PartyName>
        </cac:DeliveryParty>
    </cac:Delivery>


 */
	// BT-70 ++ 0..1 Deliver to party name
	// BT-71 ++ 0..1 Deliver to location + 0..1 Scheme identifier
	// BT-72 ++ 0..1 Actual delivery date
	// BG-15 ++ 0..1 DELIVER TO ADDRESS

	public Delivery(String businessName, Timestamp ts, PostalAddress address, String locationId) {
		this();
		init(businessName, ts, address, locationId);
	}

	void init(String businessName, Timestamp ts, PostalAddress address, String locationId) {
		LOG.info("BT-70/businessName:"+businessName + " BT-72/Timestamp:"+ts + " BG-15 ++ 0..1 DELIVER TO ADDRESS:"+address + " BT-71/locationId:"+locationId);
		Party party = new Party(null, null, null, null, null);
		party.setBusinessName(businessName);
		setParty(party);		
		setActualDate(ts);
		setAddress(address);
		setId(locationId);
	}
	
	// Party with businessName
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

	@Override
	public PostalAddress getAddress() {
		return getPostalAddress(this);
	}

	@Override
	public void setAddress(PostalAddress address) {
		LocationType location = super.getDeliveryLocation();
		if(location==null) location = new LocationType();
		location.setAddress((AddressType)address);
		super.setDeliveryLocation(location);
	}
	
	static PostalAddress getPostalAddress(DeliveryType delivery) {
		LocationType location = delivery.getDeliveryLocation();
		if(location==null) return null; 
		
		AddressType address = location.getAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return new Address(address);
	}

	@Override
	public String getRegistrationName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRegistrationName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBusinessName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBusinessName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		LocationType location = super.getDeliveryLocation();
		if(location==null) return null;
		return location.getID()==null ? null : location.getID().getValue();
	}

	@Override
	public void setId(String name) {
//		setId(name, null);
		setId(Invoice.newIDType(name, null));
	}
	
	@Override
	public void setId(String name, String schemeID) {
		setId(Invoice.newIDType(name, schemeID));
//		if(name==null) return;
//		LocationType location = super.getDeliveryLocation();
//		if(location==null) location = new LocationType();
//		location.setID(Invoice.newIDType(name, schemeID));
//		super.setDeliveryLocation(location);
	}
	
	void setId(IDType iD) {
		if(iD==null) return;
		LocationType location = super.getDeliveryLocation();
		if(location==null) location = new LocationType();
		location.setID(iD);
		super.setDeliveryLocation(location);
	}

	@Override
	public String getCompanyId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCompanyId(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCompanyId(String name, String schemeID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTaxRegistrationId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaxRegistrationId(String schemeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTaxRegistrationId(String name, String schemeID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCompanyLegalForm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCompanyLegalForm(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUriUniversalCommunication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUriUniversalCommunication(String name, String schemeID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActualDate(String ymd) {
		if(ymd==null) return;
		setActualDate(DateTimeFormats.ymdToTs(ymd));
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
		return getActualDate(this);
	}
	
	static Timestamp getActualDate(DeliveryType delivery) {
	ActualDeliveryDateType actualDeliveryDate = delivery.getActualDeliveryDate();
	return actualDeliveryDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(actualDeliveryDate.getValue());
	}

}
