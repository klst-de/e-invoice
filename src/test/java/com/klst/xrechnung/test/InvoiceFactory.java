package com.klst.xrechnung.test;

import java.util.logging.Logger;

import com.klst.einvoice.api.CoreInvoice;
import com.klst.marshaller.AbstactTransformer;

public abstract class InvoiceFactory {

	private static final Logger LOG = Logger.getLogger(InvoiceFactory.class.getName());
	
	protected AbstactTransformer transformer; // ein Singleton
	protected Object invoice;
	
	// ctor
	public InvoiceFactory(AbstactTransformer transformer) {
		this.transformer = transformer;
	}

	public byte[] toUbl() {
		invoice = makeInvoice();
		return transformer.fromModel(invoice);
	}
	
	public byte[] toCii() {
		invoice = makeInvoice();
		return transformer.fromModel(invoice);
	}
	
	abstract Object makeInvoice();
	
	public CoreInvoice getTestDoc() { // ===> GenericInvoice ===> CoreInvoice
		LOG.warning("not implemented (for test only)");
		return null;
	}
	
	boolean check(byte[] xml) {
		LOG.warning("not implemented (for test only)");
		return false;
	}
}
