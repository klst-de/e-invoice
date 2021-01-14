package com.klst.einvoice;

import java.util.List;

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
	// BG-11.BT-62 1..1 Seller tax representative name
	// BG-13.BT-70 0..1 Deliver to party name
	public String getRegistrationName();
	public void setRegistrationName(String name);
	
	// BG-4.BT-28  0..1 Seller trading name (also known as Business name)
	// BG-7.BT-45  0..1  Buyer trading name
	public String getBusinessName();
	public void setBusinessName(String name);
	
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
	
	// BG-4.BT-31  0..1 Seller VAT identifier mit schemeID BT-31-0 "VA" in CII, aber "VAT" in UBL (BUG)
	// BG-4.BT-32  0..1 Seller tax registration identifier mit schemeID BT-32-0 "FC"
	// BG-7.BT-48  0..1  Buyer VAT identifier
	// BG-11.BT-63 1..1 Seller tax representative VAT identifier
//	public String getTaxRegistrationId(String schemeID); // raus
	
	// usually the list contains one element, for BG-4 can be two BT-31+BT-32
	// in BG-7, BG-11 ist nur ein Eintrag ==> VAT
	public List<Identifier> getTaxRegistrationIdentifier();
	public void addTaxRegistrationIdentifier(Identifier id);
	public void addTaxRegistrationId(String name, String schemeID);
	
	// in BG-4 gibt es getTaxRegistrationId() ohne param für BT-32 und für alle BT-31:
	default String getVATRegistrationId() {
		List<Identifier> list = getTaxRegistrationIdentifier();
		if(list.isEmpty()) return null;
		if(list.size()==1) return list.get(0).getContent();
		for (int i=0; i<list.size(); i++) {
			Identifier id = list.get(i);
			if(id.getSchemeIdentifier().startsWith("VA")) return id.getContent();
			// similar to:
//			if(this instanceof PartyType) {
//				if(id.getSchemeIdentifier().equals("VAT")) return id.getContent();
//			} else {
//				if(id.getSchemeIdentifier().equals("VA")) return id.getContent();
//			}		
		}
		return null;
	}

	public String getCompanyLegalForm();
	public void setCompanyLegalForm(String name);
	
	public Identifier getUriUniversalCommunication(); // kleingeschrieben, nicht URI!
	public void setUriUniversalCommunication(Identifier id);
	public void setUriUniversalCommunication(String name, String schemeID);
		
}
