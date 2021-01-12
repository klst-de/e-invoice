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

public interface BusinessParty {
	
	// BG-4.BT-27  1..1 Seller name
	// BG-7.BT-44  1..1  Buyer name
	// BG-10.BT-59 1..1  Payee name
	public String getBusinessName();
	public void setBusinessName(String name);
	
	public String getRegistrationName();
	public void setRegistrationName(String name);
	
	// BG-4.BT-29  0..n Seller identifier
	// BG-7.BT-46  0..1  Buyer identifier
	// BG-10.BT-60 0..1  Payee identifier
	public String getId(); // kleingeschrieben, nicht ID!
	public Identifier getIdentifier();
	public void setIdentifier(Identifier id);
	public void setId(String name);
	public void setId(String name, String schemeID);

	// BG-4.BT-30  0..1 Seller legal registration identifier 
	// BG-7.BT-47  0..1  Buyer legal registration identifier
	// BG-10.BT-61 0..1  Payee legal registration identifier
	public String getCompanyId();
	public Identifier getCompanyIdentifier();
	public void setCompanyIdentifier(Identifier id);
	public void setCompanyId(String name);
	public void setCompanyId(String name, String schemeID);
	
	public String getTaxRegistrationId(); // default VA?
	public String getTaxRegistrationId(String schemeID);
	public void setTaxRegistrationId(String name, String schemeID);

	public String getCompanyLegalForm();
	public void setCompanyLegalForm(String name);
	
	public Identifier getUriUniversalCommunication(); // kleingeschrieben, nicht URI!
	public void setUriUniversalCommunication(Identifier id);
	public void setUriUniversalCommunication(String name, String schemeID);
		
}
