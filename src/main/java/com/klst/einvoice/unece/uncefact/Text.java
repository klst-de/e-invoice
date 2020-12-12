package com.klst.einvoice.unece.uncefact;

import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class Text extends TextType {

	Text() {
		super();
	}
	
	public Text(String value) {
		this();
		super.setValue(value);
	}
}
