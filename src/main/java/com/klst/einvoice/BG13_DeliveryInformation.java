package com.klst.einvoice;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DateTimeFormats;

/**
 * BG-13 + 0..1 DELIVERY INFORMATION
 * <p>
 * A group of business terms providing information about where and when the goods and services invoiced are delivered.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-13
 * <br>Rule ID: 	
 * <br>Request ID: 	R31, R32, R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

/*  (de) rules / Geschäftsregel:
 * 
 * BR-DE-10 : Stadt der Lieferanschrift (gehört nach PostalAddress)
 * Das Element „Deliver to city“ (BT-77) muss übermittelt werden, 
 * wenn die Gruppe „DELIVER TO ADDRESS“ (BG-15) übermittelt wird.
 * 
 * BR-DE-11 : Postleitzahl der Lieferanschrift (gehört nach PostalAddress)
 * Das Element „Deliver to post code“ (BT-78) muss übermittelt werden, 
 * wenn die Gruppe „DELIVER TO ADDRESS“ (BG-15) übermittelt wird.
 * 
 * BR-DE-12 :
 * Mit dem Element „Deliver to post code“ (BT-78) muss eine Postleitzahl übermittelt werden.
 */

/* Test 02:

    <cac:Delivery>
        <cbc:ActualDeliveryDate>2016-06-21+01:00</cbc:ActualDeliveryDate>
    </cac:Delivery>

05:
    <cac:Delivery>
        <cac:DeliveryLocation>
            <cac:Address>
                <cbc:CityName>Schulungsort</cbc:CityName>
                <cbc:PostalZone>12345</cbc:PostalZone>
                <cac:Country>
                    <cbc:IdentificationCode>DE</cbc:IdentificationCode>
                </cac:Country>
            </cac:Address>
        </cac:DeliveryLocation>
        <cac:DeliveryParty>
            <cac:PartyName>
                <cbc:Name>Schulungsanbieter</cbc:Name>
            </cac:PartyName>
        </cac:DeliveryParty>
    </cac:Delivery>

06, 10 ..

14:
    <cac:InvoicePeriod>
        <cbc:StartDate>2018-04-13+01:00</cbc:StartDate>
        <cbc:EndDate>2018-04-13+01:00</cbc:EndDate>
    </cac:InvoicePeriod>
    ...
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
public interface BG13_DeliveryInformation extends BG15_DeliverToAddress {
	
	// BT-70 0..1 Deliver to party name
	public String getName();
	public void setName(String name);
	
	// BT-71 ++ 0..1 Deliver to location identifier
	public String getId(); // kleingeschrieben, nicht ID!
	public void setId(String name);
	public void setId(String name, String schemeID);
	
	// BT-72 ++ 0..1 Actual delivery date
	public void setActualDate(Timestamp ts);
	public Timestamp getActualDate();
	default void setActualDate(String ymd) {
		if(ymd!=null) setActualDate(DateTimeFormats.ymdToTs(ymd));
	}
	
	// BG-14 ++ 0..1 INVOICING PERIOD
	
	// BG-15 ++ 0..1 DELIVER TO ADDRESS
//	public PostalAddress getAddress();
//	public void setAddress(PostalAddress address);

}
