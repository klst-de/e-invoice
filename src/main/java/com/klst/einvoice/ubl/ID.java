package com.klst.einvoice.ubl;

import com.klst.einvoice.Identifier;
import com.klst.einvoice.Reference;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;

public class ID extends IDType implements Identifier, Reference {

	ID(String content, String schemeID, String schemeVersionID) {
		super();
		setContent(content);
		setSchemeIdentifier(schemeID);
		setSchemeVersion(schemeVersionID);
	}
	ID(String content, String schemeID) {
		this(content, schemeID, null);	}
	
	ID(String content) {
		this(content, null, null);
	}

	// copy ctor
	ID(IDType id) {
		this(id.getValue(), id.getSchemeID(), id.getSchemeVersionID());
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
	public void setSchemeIdentifier(String schemeID) {
		if(schemeID==null) return;
		super.setSchemeID(schemeID);
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
