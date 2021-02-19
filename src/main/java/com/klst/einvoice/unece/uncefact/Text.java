package com.klst.einvoice.unece.uncefact;

import com.klst.einvoice.reflection.CopyCtor;

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

	static Text create(String value) {
		return new Text(value); 
	}
	static Text create(TextType object) {
		if(object instanceof TextType && object.getClass()!=TextType.class) {
			// object is instance of a subclass of TextType, but not TextType itself
			return (Text)object;
		} else {
			return new Text(object); 
		}
	}

	private Text(String value) {
		super.setValue(value);
	}
	
	private Text(TextType object) {
		super();
		if (object != null) {
			CopyCtor.invokeCopy(this, object);
		}
	}
	
}
