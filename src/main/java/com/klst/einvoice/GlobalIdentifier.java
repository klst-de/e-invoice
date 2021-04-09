package com.klst.einvoice;

import com.klst.edoc.api.Identifier;

/**
 * Global Identifier
 * <p>
 * Identifiers (IDs) are keys that are issued by the sender or recipient of a document or by a third party.
 * For each identifier in the model it is stated whether an identification scheme or a scheme version ID may 
 * or shall be defined and if so, from what list the identification schemes may be chosen. 
 * <br>
 * This EN 16931_Identifier is based on the Identifier as defined in ISO 15000-5:2014, Annex B.
 * The Scheme identifier and the Scheme version ID identify the scheme on which the identifier is based.
 * The use of the attributes is specified for each information element in the semantic model.
 * 
 * @see EN_16931_1.pdf : 6.5.6 Identifier. Type
 * @see 200-XRechnung-2020-06-30.pdf : 8.6. Identifier
 */
/*
 
Component                 | Use         	Primitive Type | Example
Content                   : Mandatory 		String         | abc:123-DEF       (in Identifier)
Scheme identifier         : Conditional 	String         | GLN               (in Identifier)
Scheme version identifier : Conditional 	String         | 1.0

Used in
	 	 BT-1  Invoice number
	 	 BT-18 Invoiced object identifier
	BG-2.BT-24 Specification identifier
	BG-4.BT-29 Seller identifier
	BG-4.BT-30 Seller legal registration identifier
	BG-4.BT-31 Seller VAT identifier
	BG-4.BT-32 Seller tax registration identifier
	BG-4.BT-34 Seller electronic address
	BG-7.BT-46 Buyer identifier
	BG-7.BT-47 Buyer legal registration identifier
	BG-7.BT-48 Buyer VAT identifier
	BG-7.BT-49 Buyer electronic address
	BG-10.BT-60 Payee identifier
	BG-10.BT-61 Payee legal registration identifier
	BG-11.BT-63 Seller tax representative VAT identifier
	BG-17.BT-84 Payment account identifier
	BG-17.BT-86 Payment service provider identifier
	BG-19.BT-89 Mandate reference identifier
	BG-19.BT-90 Bank assigned creditor identifier
	BG-19.BT-91 Debited account identifier
	BG-25.BT-126 Invoice line identifier
	BG-25.BT-128 Invoice line object identifier
	BG-31.BT-155 Item Seller's identifier
	BG-31.BT-156 Item Buyer's identifier
	BG-31.BT-157 Item standard identifier
	BG-31.BT-158 Item classification identifier (Global Identifier)

 */
public interface GlobalIdentifier extends Identifier {

// in Identifier
//	public void setContent(String content);
//	public String getContent();
//	public void setSchemeIdentifier(String id);
//	public String getSchemeIdentifier();
	
	public void setSchemeVersion(String versionId);
	public String getSchemeVersion();
	
}
