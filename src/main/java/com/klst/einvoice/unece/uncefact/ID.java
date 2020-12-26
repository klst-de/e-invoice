package com.klst.einvoice.unece.uncefact;

import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;

/**
 * Identifier
 * <p>
 * Identifiers (IDs) are keys that are issued by the sender or recipient of a document or by a third party.
 * For each identifier in the model it is stated whether an identification scheme or a scheme version ID may 
 * or shall be defined and if so, from what list the identification schemes may be chosen. 
 * <br>
 * This EN 16931_Identifier is based on the Identifier as defined in ISO 15000-5:2014, Annex B.
 * The Scheme identifier and the Scheme version ID identify the scheme on which the identifier is based.
 * The use of the attributes is specified for each information element in the semantic model.
 * 
 * @see EN_16931_1.pdf : 6.5.6 Identifier.Type
 * @see 200-XRechnung-2020-06-30.pdf : 8.6. Identifier
 */
/*
 
Component                 | Use         	Primitive Type | Example
Content                   : Mandatory 		String         | abc:123-DEF
Scheme identifier         : Conditional 	String         | GLN
Scheme version identifier : Conditional 	String         | 1.0
 
 */
public class ID extends IDType {

	ID() {
		super();
	}
	
	public ID(String content, String schemeID, String schemeVersionID) {
		this();
		super.setValue(content);
		super.setSchemeID(schemeID);
		super.setSchemeVersionID(schemeVersionID);
	}

	public ID(String content, String schemeID) {
		this(content, schemeID, null);
	}
	
	public ID(String content) {
		this(content, null, null);
	}
		
	// copy ctor
	public ID(IDType id) {
		this(id.getValue(), id.getSchemeID(), id.getSchemeVersionID());
	}
	
	public String toString() {
		return "["+(super.getSchemeID()==null? "":",SchemeID="+getSchemeID())
			+(super.getSchemeVersionID()==null? "":",SchemeVersionID="+getSchemeVersionID())
			+"\""+super.getValue()+"\"]";
	}
}
