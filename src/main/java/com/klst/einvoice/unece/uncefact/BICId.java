package com.klst.un.unece.uncefact;

import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.IdentifierType;

public class BICId extends IdentifierType {

	BICId() {
		super();
	}

	public BICId(String bic) {
		this();
		this.setValue(bic);
		this.setSchemeID("BIC"); 
	}

}
