package com.klst.einvoice;

/**
 * Identifier and derived GlobalIdentifier (contains additional Scheme version identifier)
 * <p>
 * Identifiers (IDs) are keys that are issued by the sender or recipient of a document or by a third party.
 * For each (global) identifier in the model it is stated whether an identification scheme or a scheme version ID may 
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
Content                   : Mandatory 		String         | abc:123-DEF
Scheme identifier         : Conditional 	String         | GLN
Scheme version identifier : Conditional 	String         | 1.0               (in GlobalIdentifier)

Ausserdem basiert "EN 16931_ Document Reference_ Identifier. Type" auf Identifier, siehe 6.5.7 der Doku

 */
public interface Identifier {

	/**
	 * sets mandatory identifier content
	 * @param content
	 */
	public void setContent(String content);
	public String getContent();
	
	/**
	 * (optional) identification scheme identifier of the Seller/Buyer identifier f.i.
	 * @param id
	 * If used, the identification scheme identifier shall be chosen from the entries of the list
	 * published by the ISO/IEC 6523 maintenance agency.
	 */
	public void setSchemeIdentifier(String id);
	public String getSchemeIdentifier();

}
