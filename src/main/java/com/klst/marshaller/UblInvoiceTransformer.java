package com.klst.marshaller;

import java.io.InputStream;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;


public class UblInvoiceTransformer extends UblTransformer {

	private static final String UBL_INVOICE_XSD_21 = "/ubl/maindoc/UBL-Invoice-2.1.xsd";
	private static final String INVOICE_CONTENT_PATH = "oasis.names.specification.ubl.schema.xsd.invoice_2";
	
	public UblInvoiceTransformer() {
		super(INVOICE_CONTENT_PATH);
	}

	@Override
	String getResource() {
		return UBL_INVOICE_XSD_21;
	}

	@Override
	public <T extends Object> T toModel(InputStream xmlInputStream) {
		return (T) this.toModel(xmlInputStream, InvoiceType.class);
	}

}
