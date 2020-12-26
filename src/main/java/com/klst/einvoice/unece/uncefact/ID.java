package com.klst.einvoice.unece.uncefact;

import com.klst.einvoice.Identifier;

import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;

/*
 
Component                 | Use         	Primitive Type | Example
Content                   : Mandatory 		String         | abc:123-DEF
Scheme identifier         : Conditional 	String         | GLN
Scheme version identifier : Conditional 	String         | 1.0
 
 */
public class ID extends IDType implements Identifier {

	public ID(String content, String schemeID, String schemeVersionID) {
		super();
		setContent(content);
		setSchemeIdentifier(schemeID);
		setSchemeVersion(schemeVersionID);
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

	@Override
	public void setContent(String content) {
		super.setValue(content);
	}

	@Override
	public String getContent() {
		return super.getValue();
	}

	@Override
	public void setSchemeIdentifier(String schemeId) {
		if(schemeId==null) return;
		super.setSchemeID(schemeId);
	}

	@Override
	public String getSchemeIdentifier() {
		return super.getSchemeID();
	}

	@Override
	public void setSchemeVersion(String versionId) {
		if(versionId==null) return;
		super.setSchemeVersionID(versionId);
	}

	@Override
	public String getSchemeVersion() {
		return super.getSchemeVersionID();
	}
}
