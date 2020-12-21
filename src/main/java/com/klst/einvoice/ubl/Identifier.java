package com.klst.einvoice.ubl;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;

public class Identifier extends IDType {

	@Deprecated
	static IDType newIDType(String value, String schemeID) {
		IDType ID = new IDType();
		ID.setValue(value);
		ID.setSchemeID(schemeID);
		return ID;
	}

	Identifier(String value, String schemeID) {
		super();
		setValue(value);
		setSchemeID(schemeID);
	}
	
	Identifier(String value) {
		this(value, null);
	}

}
