package com.klst.marshaller;

import java.io.InputStream;

import javax.inject.Named;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@javax.inject.Singleton
public class UblCreditNoteTransformer extends UblTransformer {

	public static AbstactTransformer SINGLETON = new UblCreditNoteTransformer();

	public static AbstactTransformer getInstance() {
		return SINGLETON;
	}
	
	private static final String UBL_CREDITNOTE_XSD_21 = "/ubl/maindoc/UBL-CreditNote-2.1.xsd";
	private static final String CONTENT_PATH = "oasis.names.specification.ubl.schema.xsd.creditnote_2";
	private static final String CONTENT_SUPERTYPE_NAME = CONTENT_PATH+".CreditNoteType"; 
	public static final String CONTENT_TYPE_NAME = "com.klst.einvoice.ubl.GenericInvoice"; 
	
	private UblCreditNoteTransformer() {
		super(CONTENT_PATH, SINGLETON);
	}
	
	@Override
	String getResource() {
		return UBL_CREDITNOTE_XSD_21;
	}

	Class<?> loadClass() {
		Class<?> type = null;
		try {
			// dynamisch die UBL Klasse laden 
			type = Class.forName(CONTENT_SUPERTYPE_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> T toModel(InputStream xmlInputStream) {
		Class<?> type = loadClass();
		Object result = this.toModel(xmlInputStream, type);
		return (T) result;
	}

}
