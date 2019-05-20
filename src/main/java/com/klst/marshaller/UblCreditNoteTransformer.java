package com.klst.marshaller;

import java.io.InputStream;

import javax.inject.Named;

import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;

@Named
@javax.inject.Singleton
public class UblCreditNoteTransformer extends UblTransformer {

	public static AbstactTransformer SINGLETON = new UblCreditNoteTransformer();

	public static AbstactTransformer getInstance() {
		return SINGLETON;
	}
	
	private static final String UBL_CREDITNOTE_XSD_21 = "/ubl/maindoc/UBL-CreditNote-2.1.xsd";
	private static final String CONTENT_PATH = "oasis.names.specification.ubl.schema.xsd.creditnote_2";
	
	private UblCreditNoteTransformer() {
		super(CONTENT_PATH, SINGLETON);
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
