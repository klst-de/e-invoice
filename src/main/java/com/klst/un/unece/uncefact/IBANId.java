package com.klst.un.unece.uncefact;

import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.IdentifierType;

public class IBANId extends IdentifierType {

	IBANId() {
		super();
	}

	public IBANId(String iban) {
		this();
		this.setValue(iban);
		this.setSchemeID("IBAN"); 
	}

}
