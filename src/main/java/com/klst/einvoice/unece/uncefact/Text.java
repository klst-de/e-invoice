package com.klst.einvoice.unece.uncefact;

import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

/**
 * Text
 * <p>
 * Text is the actual wording of anything written or printed. 
 * This EN 16931_Text is based on the Text as defined in ISO 15000-5:2014, Annex B. 
 * Line breaks in the text may be present.
 * <br><pre>
 * Component Use       Primitive Type Example
 * Content   Mandatory String         “5% allowance when paid within 30 days”
 * </pre>
 * 
 * @see "EN_16931_1.pdf" : 6.5.10 Text.Type
 */
public class Text extends TextType {

	Text() {
		super();
	}
	
	public Text(String value) {
		this();
		super.setValue(value);
	}
}
