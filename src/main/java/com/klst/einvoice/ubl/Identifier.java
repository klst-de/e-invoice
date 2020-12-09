package com.klst.einvoice.ubl;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;

public class Identifier {

	static IDType newIDType(String value, String schemeID) {
		IDType ID = new IDType();
		ID.setValue(value);
		ID.setSchemeID(schemeID);
		return ID;
	}

}
