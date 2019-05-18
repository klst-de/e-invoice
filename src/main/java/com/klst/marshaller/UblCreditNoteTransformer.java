package com.klst.marshaller;

import java.io.InputStream;

import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;

public class UblCreditNoteTransformer extends UblTransformer {

	public static final String UBL_CREDITNOTE_XSD_21 = "/ubl/maindoc/UBL-CreditNote-2.1.xsd";
	private static final String CREDITNOTE_CONTENT_PATH = "oasis.names.specification.ubl.schema.xsd.creditnote_2";
	
	public UblCreditNoteTransformer() {
		super(CREDITNOTE_CONTENT_PATH);
	}
	
	@Override
	String getResource() {
		return UBL_CREDITNOTE_XSD_21;
	}

	@Override
	public <T extends Object> T toModel(InputStream xmlInputStream) {
		return (T) this.toModel(xmlInputStream, CreditNoteType.class);
	}

}
