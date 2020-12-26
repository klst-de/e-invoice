package com.klst.einvoice.ubl;

import com.klst.einvoice.Identifier;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;

public class ID extends IDType implements Identifier {

	ID(String content, String schemeID) {
		super();
		setContent(content);
		setSchemeIdentifier(schemeID);
	}
	
	ID(String content) {
		this(content, null);
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
