package com.klst.einvoice.unece.uncefact;

import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.IdentifierType;

public class IBANId extends IdentifierType {

	static final String IBAN = "IBAN";
	
	IBANId() {
		super();
	}

	public IBANId(String iban) {
		this();
		this.setValue(iban);
		this.setSchemeID(IBAN); 
	}

	public String toString() {
		return "["+this.getValue() + ", SchemeID="+this.getSchemeID()+"]";
	}
}
