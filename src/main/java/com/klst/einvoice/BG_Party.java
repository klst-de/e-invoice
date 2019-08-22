package com.klst.einvoice;

/**
 * A common interface for
 * 
 * <br> BG-4 + 1..1 SELLER 
 * <br> BG-7 + 1..1 BUYER
 * <br> BG-10 + 0..1 PAYEE
 * <br> BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
 * <br> BG-13 + 0..1 DELIVERY INFORMATION / BT-70 BT-71 ShipToTradeParty
 */

public interface BG_Party {
	
	public PostalAddress getAddress();
	public void setAddress(PostalAddress name);
	
	public String getRegistrationName();
	public void setRegistrationName(String name);
	
	public String getTradingBusinessName();
	public void setTradingBusinessName(String name);
	
	public String getId(); // kleingeschrieben, nicht ID!
	public void setId(String name);
	public void setId(String name, String schemeID);

	public String getCompanyId();
	public void setCompanyId(String name);
	public void setCompanyId(String name, String schemeID);
	
	public String getTaxRegistrationId(); // default VA?
	public String getTaxRegistrationId(String schemeID);
//	public void setTaxRegistrationId(String name);                       required schemeID
	public void setTaxRegistrationId(String name, String schemeID);

	public String getCompanyLegalForm();
	public void setCompanyLegalForm(String name);
	
	public String getUriUniversalCommunication(); // kleingeschrieben, nicht URI!
	public void setUriUniversalCommunication(String name, String schemeID);
		
}
