package com.klst.einvoice.ubl;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;

public class Identifier extends IDType {

	Identifier(String id, String schemeID) {
		super();
		setValue(id);
		setSchemeID(schemeID);
	}
	
	Identifier(String value) {
		this(value, null);
	}

}
