package com.klst.einvoice.api;

import java.util.List;

import com.klst.edoc.api.Identifier;

/**
 * BG-31 ITEM INFORMATION
 * <p>
 * A group of business terms providing information about the goods and services 
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-31
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 * 
 * @see CoreInvoiceLineFactory
 */
public interface BG31_ItemInformation {

	/**
	 * Item name
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-153 
	 * <br>Rule ID: 	BR-25
	 * <br>Request ID: 	R20, R56
	 * 
	 * @param text Text
	 */
//	public void setItemName(String text); // use factory
	public String getItemName();

	/**
	 * Item description
 	 * <p>
	 * The Item description allows for describing the item and its features in more detail than the Item name.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-154
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R20, R56
	 * 
	 * @param Text
	 */
	public void setDescription(String text);
	public String getDescription();

	/**
	 * Item Seller's identifier
 	 * <p>
	 * An identifier, assigned by the Seller, for the item.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-155
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R21, R56
	 * 
	 * @param Identifier
	 */
	public void setSellerAssignedID(String id);
	public String getSellerAssignedID();

	/**
	 * Item Buyer's identifier
 	 * <p>
	 * An identifier, assigned by the Buyer, for the item.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-156
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R21, R56, R22
	 * 
	 * @param Identifier
	 */
	public void setBuyerAssignedID(String id);
	public String getBuyerAssignedID();
	
	/*
	 * GlobalID Kennung eines Artikels nach registriertem Schema
	 * CII:
	 * BG-31    1 .. 1   SpecifiedTradeProduct
	 * BT-157   0 .. 1   GlobalID
	 * BT-157-1          required schemeID
	 * Codeliste: ISO 6523 :
	 * 0021 : SWIFT 
	 * 0088 : EAN 
	 * 0060 : DUNS 
	 * 0177 : ODETTE automotive industry
	 */
	/**
	 * Item standard identifier
 	 * <p>
	 * An item identifier based on a registered scheme.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-157 BT-157-1
	 * <br>Rule ID: 	BR-64
	 * <br>Request ID: 	R23, R56
	 * 
	 * @param Identifier
	 * @param schemeID, The identification scheme shall be identified from the entries of the list published by the ISO/IEC 6523 maintenance agency.
	 */
	public void setStandardID(String globalID, String schemeID);
	public void setStandardID(String globalID);
	public void setStandardIdentifier(Identifier id);
	public Identifier getStandardIdentifier();
	public String getStandardID();

	/**
	 * Item classification identifier
 	 * <p>
	 * A code for classifying the item by its type or nature.
	 * Classification codes are used to allow grouping of similar items for a various purposes e.g. public procurement (CPV), e-Commerce (UNSPSC) etc.
	 * <p>
	 * Cardinality: 	0..n (optional)
	 * <br>EN16931-ID: 	BT-158
	 * <br>Rule ID: 	BR-64
	 * <br>Request ID: 	R24
	 * 
	 * @param Identifier
	 * @param schemeID,      BT-158-1 1..1 The identification scheme shall be chosen from the entries in UNTDID 7143
	 * @param schemeVersion, BT-158-2 0..1 Scheme version identifier - The version of the identification scheme.
	 */
	public void addClassificationID(String id, String schemeID, String schemeVersion);
	public void addClassificationID(GlobalIdentifier id);
	public List<GlobalIdentifier> getClassifications();

	/**
	 * Item country of origin
 	 * <p>
	 * The code identifying the country from which the item originates.
	 * The lists of valid countries are registered with the EN ISO 3166-1 Maintenance agency, 
	 * “Codes for the representation of names of countries and their subdivisions”.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-159
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R29 
	 * 
	 * @param code
	 */
	public void setCountryOfOrigin(String code);
	public String getCountryOfOrigin();

}
