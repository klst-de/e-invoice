package com.klst.einvoice;

import com.klst.edoc.api.PostalAddress;

/* Elements not defined in EN_16931_1
 
 [CII-DT-088] - StreetName shall not be used.
 [CII-DT-094] - BuildingNumber shall not be used.
 
 Street ist nich definiert in
 un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._103.TradeAddressType
 (dieses schema wird in CIO verwendet, CII nutzt die Version 100)
 
 Street int in den XML schemas
 UBL oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType
 und un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType
 und auch in org.opentrans.xmlschema._2.ADDRESS
 
 */
public interface PostalAddressExt extends PostalAddress {

	public void setStreet(String street);
	public void setBuilding(String building);
	
	public String getStreet();
	public String getBuilding();
	
}
