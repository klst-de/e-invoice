package com.klst.marshaller;

import static javax.xml.bind.JAXBContext.newInstance;

import java.io.InputStream;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBException;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@javax.inject.Singleton
public class UblInvoiceTransformer extends UblTransformer {

//	private static final Logger LOG = Logger.getLogger(UblInvoiceTransformer.class.getName());

	public static AbstactTransformer SINGLETON = new UblInvoiceTransformer();

	public static AbstactTransformer getInstance() {
		return SINGLETON;
	}

	private static final String UBL_INVOICE_XSD_21 = "/ubl/maindoc/UBL-Invoice-2.1.xsd";
	private static final String CONTENT_PATH = "oasis.names.specification.ubl.schema.xsd.invoice_2";
	
	private UblInvoiceTransformer() {
		super(CONTENT_PATH, SINGLETON);
//		LOG.info(this.toString());
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
