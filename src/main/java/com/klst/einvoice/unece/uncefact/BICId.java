package com.klst.einvoice.unece.uncefact;

import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.IdentifierType;

public class BICId extends IdentifierType {

	static final String BIC = "BIC";
	
	BICId() {
		super();
	}

	public BICId(String bic) {
		this();
		this.setValue(bic);
		this.setSchemeID(BIC); 
	}

	public String toString() {
		return "["+this.getValue() + ", SchemeID="+this.getSchemeID()+"]";
	}

}
